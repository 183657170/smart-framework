package com.sunkang.decorate;
/**
 * ��
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
	 * չʾ��װ
	 */
	public void show(){
		
		System.out.println(name);
	}
}
