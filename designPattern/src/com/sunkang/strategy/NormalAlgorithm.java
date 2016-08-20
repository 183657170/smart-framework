package com.sunkang.strategy;
/**
 * 正常算法
 * @author sunkang
 *
 */
public class NormalAlgorithm implements Checkout{

	@Override
	public int checkout(int money) {
		System.out.println("正常算法。。");
		return money*1;
	}
	
}
