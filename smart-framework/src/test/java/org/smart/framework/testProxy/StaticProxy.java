package org.smart.framework.testProxy;
/**
 * 实现静态代理
 * @author sunkang
 *
 */
public class StaticProxy implements SayHelloService{
	private SayHelloService helloService;
	
	
	
	public StaticProxy() {
		this.helloService = new SayHelloServiceImpl();
	}



	public void sayHello(String name) {
		before();
		helloService.sayHello(name);
		after();
	}
	
	public void before(){
		System.out.println("调用方法之前");
	}
	
	public void after(){
		System.out.println("调用方法之后");
	}
	
	
}
