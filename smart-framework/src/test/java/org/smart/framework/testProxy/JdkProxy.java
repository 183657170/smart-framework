package org.smart.framework.testProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * jdk的动态代理
 * @author sunkang
 *
 */
public class JdkProxy implements InvocationHandler{
	
	private Object  tarage;
	
	

	public JdkProxy(Object tarage) {
		this.tarage = tarage;
	}



	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before();
		Object obj=method.invoke(tarage, args);
		after();
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(){
		return (T) Proxy.newProxyInstance(tarage.getClass().getClassLoader(), tarage.getClass().getInterfaces(), this);
	}
	
	public void before(){
		System.out.println("调用方法之前");
	}
	
	public void after(){
		System.out.println("调用方法之后");
	}
	
}
