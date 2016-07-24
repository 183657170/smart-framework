package org.smart.framework.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.smart.framework.entity.Person;

public class JsonUtilTest {

	@Test
	public void testToJson() {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", "1");
		Person person=new Person("sunkang", "男", 24, "13016488900");
		map.put("person", person);
		String json=JsonUtil.toJson(map);
		System.out.println("haha ");
		System.out.println(json);
	}

	@Test
	public void testFromJson() {
		Person person1=new Person("sunkang", "男", 24, "13016488900");
		String json=JsonUtil.toJson(person1);
		System.out.println(json);
//		String json="{name:'sunkang',sex:'男',age:24,tel:'13016488900'}";
		Person person= JsonUtil.fromJson(json, Person.class);
		System.out.println(person.toString());
	}

}
