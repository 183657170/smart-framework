package com.sunkang.strategy;
/**
 * 结算方法接口
 * @author sunkang
 *
 */
public interface Checkout {
	/**
	 * 结算
	 * @return
	 */
	public int checkout(int money);
}
