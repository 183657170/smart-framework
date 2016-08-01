package org.smart.framework.testProxy;

public class TestCglibProxy {
	public static void main(String[] args) {
		CglibProxy cglibProxy=new CglibProxy();
		SayHelloServiceImpl helloServiceImpl= cglibProxy.getProxy(SayHelloServiceImpl.class);
		helloServiceImpl.sayHello("孙康");
	}
}
