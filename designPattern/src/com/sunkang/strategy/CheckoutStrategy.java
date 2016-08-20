package com.sunkang.strategy;
/**
 * ���ò��Եķ�ʽ����
 * 
 * ����һϵ�е��㷨�ķ�������Щ��������ɵĹ�������ͬ�ģ�����ģʽ��������ͬ�ķ����������е��㷨��
 * ���ٸ����㷨֮�����ϣ��޸�����һ���㷨����Ӱ�������㷨�������ڵ�Ԫ����
 * @author sunkang
 *
 */
public class CheckoutStrategy {
	
	private Checkout checkout;

	public CheckoutStrategy(Checkout checkout) {
		this.checkout = checkout;
	}
	/**
	 * ����
	 * @return
	 */
	public int checkout(int money){
		return checkout.checkout(money);
	}
}
