package org.smart.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smart.framework.entity.Data;
import org.smart.framework.entity.Handler;
import org.smart.framework.entity.Param;
import org.smart.framework.entity.View;
import org.smart.framework.helper.ConfigHelper;
import org.smart.framework.helper.ControllerHelper;
import org.smart.framework.helper.HelperLoader;
import org.smart.framework.util.CodecUtil;
import org.smart.framework.util.JsonUtil;
import org.smart.framework.util.ReflectionUtil;
import org.smart.framework.util.StreamUtil;
import org.smart.framework.util.StringUtil;
/**
 * 控制转发器
 * @author sunkang
 *
 */
//@WebServlet(urlPatterns="*.do",loadOnStartup=0)
public class DispatcherServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		//初始化各种helper
		HelperLoader.init();
		ServletContext servletContext=config.getServletContext();
		//设置什么不拦截
		registerServlet(servletContext);
	}
	/**
	 * 如果是jsp，或者静态的资源，则不调用该servlet
	 * @param servletContext
	 */
	 private void registerServlet(ServletContext servletContext) {
	        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
	        jspServlet.addMapping("/index.jsp");
	        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");

	        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
	        defaultServlet.addMapping("/js/*");
	        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
	    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//获得请求的类型
		String requestMethod=req.getMethod().toLowerCase();
		//获得请求的路径
		String requestPath=req.getPathInfo();
		System.out.println(requestPath);
		//获得处理请求的action
		Handler handler= ControllerHelper.getHandler(requestMethod, requestPath);
		if(handler!=null){
			//创建并获取请求参数
			Map<String, Object> paramMap=new HashMap<String, Object>();
			//获得表单传过来的参数
			Enumeration<String> paramNames=req.getParameterNames();
			while(paramNames.hasMoreElements()){
				String paramName=paramNames.nextElement();
				//获得请求参数
				String paramValue=req.getParameter(paramName);
				paramMap.put(paramName, paramValue);
			}
			//获得文件流的参数
			String body=CodecUtil.decodeURL(StreamUtil.getString(req.getInputStream()));
			if(body !=null&&!"".equals(body)){
				String[] params=StringUtil.splitString(body, "&");
				for(String param:params){
					String[] arrs=StringUtil.splitString(param, "=") ;
					if(arrs!=null&&arrs.length>1){
						String paramName=arrs[0];
						String prameValue=arrs[1];
						paramMap.put(paramName, prameValue);
					}
				}
			}
			
			//请求参数
			Param param=new Param(paramMap);
			if(paramMap==null||paramMap.size()==0){
				param=null;
			}
			//获得controller
			Class<?> controllerClass=handler.getControllerClass();
			//获得请求的controller的实体
			Object controllerObj=ReflectionUtil.newInstance(controllerClass);
			//获得处理请求的action方法
			Method actionMethod=handler.getActionMethod();
			//调用action方法并且获得返回值
			Object result=ReflectionUtil.invokeMethod(controllerObj, actionMethod, param); 
			//如果返回的是视图
			if(result instanceof View){
				View view=(View) result;
				String path=view.getPath();
				//如果以/开头，则为重定向
				if(path.startsWith("/")){
					//跳转到新的action
					res.sendRedirect(req.getContextPath()+path);
				}else{//否则为转发
					Map<String, Object > model=view.getModel();
					for(Map.Entry<String, Object> entry:model.entrySet()){
						req.setAttribute(entry.getKey(), entry.getValue());
					}
					req.getRequestDispatcher(ConfigHelper.getAppJspPath()+path).forward(req, res);
				}
			}
			//如果返回的是数据类型
			if(result instanceof Data){
				Data data=(Data) result;
				Object model=data.getModel();
				if(model!=null){
					//响应为json类型
					res.setContentType("application/json");
					res.setCharacterEncoding("UTF-8");
					PrintWriter printWriter=res.getWriter();
					//转换为json类型
					String json=JsonUtil.toJson(model);
					printWriter.write(json);
					printWriter.flush();
					printWriter.close();
				}
			}
			
		}
	}

	

	
}
