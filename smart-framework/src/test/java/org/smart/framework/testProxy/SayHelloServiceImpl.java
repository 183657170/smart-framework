package org.smart.framework.testProxy;

public class SayHelloServiceImpl implements SayHelloService{

	public void sayHello(String name) {
		System.out.println("早上好！ "+name);
		
	}

}
