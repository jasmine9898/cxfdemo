package com.test.client;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cxf.stub.HelloWebService;
import cxf.stub.HelloWebServiceImplService;

public class Test {
	
	/*@RequestMapping("cxfclient3.do")
	@ResponseBody
	public String cxfclient3(){
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext(new String[] {"stub/client-beans.xml"});   
		  
		HelloWebService client = (HelloWebService)context.getBean("HelloWebService");   
        String response = client.say("World");   
        return "Response: " + response;
	}*/
	
	//静态调用
	public static void main2(String[] args){
		JaxWsProxyFactoryBean svr=new JaxWsProxyFactoryBean();
		svr.setServiceClass(HelloWebService.class);
		svr.setAddress("http://localhost:8180/cxfdemo/services/HelloWebService");
		HelloWebService ws=(HelloWebService) svr.create();
		System.out.println(ws.say("2222"));
	}
	//动态调用
	public static void main3(String[] args1) throws Exception {  
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
        org.apache.cxf.endpoint.Client client  =null;
        client=dcf.createClient("http://localhost:8180/cxfdemo/services/HelloWebService?wsdl");  
        //url为调用webService的wsdl地址  
        QName qname=new QName("http://test.com/","say");
        Object[] objects=client.invoke(qname,"aaa"); 
        System.out.println(objects[0].toString());
    }
	public static void main4(String[] args1) throws Exception {  
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext(new String[] {"stub/client-beans.xml"});   
  
		HelloWebService client = (HelloWebService)context.getBean("HelloWebService");   
        String response = client.say("World");   
        System.out.println("Response: " + response);   
        System.exit(0);  
	}

	public static void main(String[] args1) throws Exception {  
		HelloWebService hello=new HelloWebServiceImplService().getHelloWebServiceImplPort();
		System.out.println(hello.say("stub---xxx"));
	}
}	
