package org.smart.framework.testProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * 动态代理
 * @author sunkang
 *
 */
public class CglibProxy implements MethodInterceptor{

	public Object intercept(Object obj, Method method, Object[] arg2,
			MethodProxy proxy) throws Throwable {
		before();
		//调用方法
		Object result=proxy.invokeSuper(obj, arg2);
		after();
		return result;
	}
	
	
	public <T> T getProxy(Class<?> cls){
		return (T) Enhancer.create(cls, this);
	}
	
	public void before(){
		System.out.println("调用方法之前");
	}
	
	public void after(){
		System.out.println("调用方法之后");
	}

}
