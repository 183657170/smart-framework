package com.sunkang.decorate;
/**
 * 人
 * @author sunkang
 *
 */
public class Person {
	
	private String name;
	public Person() {
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	
	/**
	 * 展示服装
	 */
	public void show(){
		
		System.out.println(name);
	}
}
