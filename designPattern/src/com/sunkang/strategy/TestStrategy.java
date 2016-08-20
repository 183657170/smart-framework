package com.sunkang.strategy;

public class TestStrategy {
	public static void main(String[] args) {
		//打八折
		CheckoutStrategy checkoutStrategy=new CheckoutStrategy(new Fracture8Algorithm());
		int money=checkoutStrategy.checkout(1000);
		System.out.println("打八折后的价格为："+money+"元");
		
		//不打折
		CheckoutStrategy checkoutStrategy1=new CheckoutStrategy(new NormalAlgorithm());
		money=checkoutStrategy1.checkout(100);
		System.out.println("不打折的价格为："+money+"元");
		
		//可能还有满100减10这种，只需要加个类就行了，不影响之前好的算法
	}
}
