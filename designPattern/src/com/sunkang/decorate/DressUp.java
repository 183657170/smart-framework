package com.sunkang.decorate;
/**
 * װ�ζ���
 *��1�� װ�ζ������ʵ��������ͬ�Ľӿڡ������ͻ��˶�������Ժ���ʵ������ͬ�ķ�ʽ��װ�ζ��󽻻���
 *��2�� װ�ζ������һ����ʵ��������ã�reference��
 *��3�� װ�ζ�������������Կͻ��˵�����������Щ����ת������ʵ�Ķ���
 *��4�� װ�ζ��������ת����Щ������ǰ���Ժ�����һЩ���ӹ��ܡ�
 *������ȷ����������ʱ�������޸ĸ�������Ľṹ�Ϳ������ⲿ���Ӹ��ӵĹ��ܡ���������������У�ͨ����ͨ���̳���ʵ�ֶԸ�����Ĺ�����չ��
 * @author sunkang
 *
 */
public class DressUp extends Person{
	
	private Person person;

	/**
	 * װ��
	 * @param person
	 */
	public void  decorate(Person person) {
		this.person = person;
	}



	@Override
	public void show() {
		person.show();
	}

	
}
