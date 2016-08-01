package org.smart.framework.testProxy;

import java.lang.reflect.Proxy;

public class TestJdkProxy {
	public static void main(String[] args) {
		SayHelloService tarage=new SayHelloServiceImpl();
		JdkProxy jdkProxy=new JdkProxy(tarage);
//		SayHelloService helloService=(SayHelloService) Proxy.newProxyInstance(tarage.getClass().getClassLoader(),tarage.getClass().getInterfaces(), jdkProxy);
//		helloService.sayHello();
		SayHelloService helloService=jdkProxy.getProxy();
		helloService.sayHello("孙康");
	}
}
