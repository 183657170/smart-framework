package com.sunkang.strategy;
/**
 * �����㷨
 * @author sunkang
 *
 */
public class NormalAlgorithm implements Checkout{

	@Override
	public int checkout(int money) {
		System.out.println("�����㷨����");
		return money*1;
	}
	
}
