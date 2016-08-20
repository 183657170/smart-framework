package com.sunkang.simpleFactory;
/**
 * ��������Ĺ�����
 * @author sunkang
 *
 */
public class AnimalFactory {
	/**
	 * ��ö���
	 * @throws Exception 
	 */
	public static Animal getAnimal(String animalType) throws Exception{
		if("cat".equalsIgnoreCase(animalType)){
			return new Cat();
		}else if("dog".equalsIgnoreCase(animalType)){
			return new Dog();
		}
		throw new Exception("û�С�"+animalType+"�����ֶ��");
	}
}
