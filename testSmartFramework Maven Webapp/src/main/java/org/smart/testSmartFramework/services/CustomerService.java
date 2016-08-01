package org.smart.testSmartFramework.services;

import java.util.ArrayList;
import java.util.List;

import org.smart.framework.annotation.Service;
import org.smart.testSmartFramework.Customer;
@Service
public class CustomerService {
	
	private  String test="hahah";
	
	
	
	public CustomerService(String test) {
		super();
		this.test = "11111111111";
	}



	public CustomerService() {
		super();
	}



	public String getTest() {
		return test;
	}



	public void setTest(String test) {
		this.test = test;
	}



	public  List<Customer> getCustomerList(){
		Customer customer=new Customer();
		customer.setId("11313slkfjhlszk");
		List<Customer> list=new ArrayList<Customer>();
		list.add(customer);
		return list;
	}
	
	
}
