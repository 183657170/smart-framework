package org.smart.testSmartFramework.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.smart.framework.annotation.Action;
import org.smart.framework.annotation.Controller;
import org.smart.framework.annotation.Inject;
import org.smart.framework.entity.Data;
import org.smart.framework.entity.Param;
import org.smart.framework.entity.View;
import org.smart.framework.helper.IocHelper;
import org.smart.framework.util.ReflectionUtil;
import org.smart.testSmartFramework.Customer;
import org.smart.testSmartFramework.services.CustomerService;


/**
 * �ͻ�������
 */
@Controller
public class CustomerController {

    @Inject
    public static CustomerService customerService;

    /**
     * ��ÿͻ�
     */
    @Action("get:/customer")
    public View index(Param param) {
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList", customerList);
    }
    
    /**
     * ��ÿͻ�
     */
    @Action("post:/testcustomer")
    public Data testcustomer(Param param) {
    	System.out.println(param.getParamMap().toString());
        List<Customer> customerList = customerService.getCustomerList();
        return new Data(customerList);
    }
    
    
    
    
    
                                
    public static void main(String[] args) {
		//��������
    	IocHelper iocHelper=new IocHelper();
    	CustomerController customerController=new CustomerController();
		try {
			Field field=CustomerController.class.getField("customerService");
			ReflectionUtil.setField(customerController,field,new CustomerService("hah"));
			System.out.println(customerService.getTest());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}



}