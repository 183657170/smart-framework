package com.sunkang.strategy;

public class TestStrategy {
	public static void main(String[] args) {
		//�����
		CheckoutStrategy checkoutStrategy=new CheckoutStrategy(new Fracture8Algorithm());
		int money=checkoutStrategy.checkout(1000);
		System.out.println("����ۺ�ļ۸�Ϊ��"+money+"Ԫ");
		
		//������
		CheckoutStrategy checkoutStrategy1=new CheckoutStrategy(new NormalAlgorithm());
		money=checkoutStrategy1.checkout(100);
		System.out.println("�����۵ļ۸�Ϊ��"+money+"Ԫ");
		
		//���ܻ�����100��10���֣�ֻ��Ҫ�Ӹ�������ˣ���Ӱ��֮ǰ�õ��㷨
	}
}
