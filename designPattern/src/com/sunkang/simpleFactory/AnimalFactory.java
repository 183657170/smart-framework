package com.sunkang.simpleFactory;
/**
 * 创建动物的工厂类
 * @author sunkang
 *
 */
public class AnimalFactory {
	/**
	 * 获得动物
	 * @throws Exception 
	 */
	public static Animal getAnimal(String animalType) throws Exception{
		if("cat".equalsIgnoreCase(animalType)){
			return new Cat();
		}else if("dog".equalsIgnoreCase(animalType)){
			return new Dog();
		}
		throw new Exception("没有【"+animalType+"】这种动物！");
	}
}
