package com.sunkang.strategy;
/**
 * ¥Ú∞À’€
 * @author sunkang
 *
 */
public class Fracture8Algorithm implements Checkout{

	@Override
	public int checkout(int money) {
		System.out.println("¥Ú∞À’€°£°£");
		return money*8/10;
	}

}
