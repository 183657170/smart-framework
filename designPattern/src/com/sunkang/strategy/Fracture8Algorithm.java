package com.sunkang.strategy;
/**
 * �����
 * @author sunkang
 *
 */
public class Fracture8Algorithm implements Checkout{

	@Override
	public int checkout(int money) {
		System.out.println("����ۡ���");
		return money*8/10;
	}

}
