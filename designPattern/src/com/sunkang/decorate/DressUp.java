package com.sunkang.decorate;
/**
 * 装饰对象
 *（1） 装饰对象和真实对象有相同的接口。这样客户端对象就能以和真实对象相同的方式和装饰对象交互。
 *（2） 装饰对象包含一个真实对象的引用（reference）
 *（3） 装饰对象接受所有来自客户端的请求。它把这些请求转发给真实的对象。
 *（4） 装饰对象可以在转发这些请求以前或以后增加一些附加功能。
 *这样就确保了在运行时，不用修改给定对象的结构就可以在外部增加附加的功能。在面向对象的设计中，通常是通过继承来实现对给定类的功能扩展。
 * @author sunkang
 *
 */
public class DressUp extends Person{
	
	private Person person;

	/**
	 * 装饰
	 * @param person
	 */
	public void  decorate(Person person) {
		this.person = person;
	}



	@Override
	public void show() {
		person.show();
	}

	
}
