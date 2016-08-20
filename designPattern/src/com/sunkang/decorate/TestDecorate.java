package com.sunkang.decorate;

public class TestDecorate {
	public static void main(String[] args) {
		Person person=new Person("sunkang");
		
		DressUp dressUp=new DressUp();
		
		TShirt shirt=new TShirt();
		
		Trousers trousers=new Trousers();
		
		//装饰的过程
		dressUp.decorate(person);
		shirt.decorate(dressUp);
		trousers.decorate(shirt);
		
		trousers.show();
		
	}
}
