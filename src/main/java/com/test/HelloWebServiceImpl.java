package com.test;


public class HelloWebServiceImpl implements HelloWebService {

	public String say(String value) {

		System.out.println("HelloWebService say : " +value);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "HelloWebService say : " +value;
	}

}
