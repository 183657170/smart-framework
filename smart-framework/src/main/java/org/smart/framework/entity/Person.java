package org.smart.framework.entity;

public class Person {
	private String name;
	
	private String sex;
	
	private Integer age;
	
	private String tel;
	
	

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", age=" + age
				+ ", tel=" + tel + "]";
	}

	public Person(String name, String sex, Integer age, String tel) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
	}

	
	
	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
