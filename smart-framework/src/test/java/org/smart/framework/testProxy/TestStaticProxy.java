package org.smart.framework.testProxy;

public class TestStaticProxy {
	public static void main(String[] args) {
		SayHelloService helloService=new StaticProxy() ;
		helloService.sayHello("孙康");
	}
}
