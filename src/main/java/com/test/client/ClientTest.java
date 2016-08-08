package com.test.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cxf.stub.HelloWebService;

public final class ClientTest {

    private ClientTest() {
    }

    public static void main(String args[]) throws Exception {
        ClassPathXmlApplicationContext context 
            = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});

        HelloWebService client = (HelloWebService)context.getBean("helloClient");

        String response = client.say("Joe");
        System.out.println("Response: " + response);
        System.exit(0);
    }
}