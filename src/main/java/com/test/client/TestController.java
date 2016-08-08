package com.test.client;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cxf.stub.HelloWebService;


@Controller
public class TestController {

	@RequestMapping("hello.do")
	public void hello(){
	}
	
	/*http://localhost:8280/cxfdemo/cxfclient.do*/
	//客户端代理方式，需要服务端提供的接口
	@RequestMapping("client.do")
	@ResponseBody
	public String cxfclient() throws Exception{
		JaxWsProxyFactoryBean svr=new JaxWsProxyFactoryBean();
		svr.setServiceClass(com.test.HelloWebService.class);
		svr.setAddress("http://localhost:18080/cxfdemo/services/HelloWebService");
		com.test.HelloWebService ws=(com.test.HelloWebService) svr.create();
		return ws.say("Proxy-2222");
	}
	
	
	@RequestMapping("client2.do")
	@ResponseBody
	public String cxfclient2() throws Exception{
	JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
    org.apache.cxf.endpoint.Client client=dcf.createClient("http://localhost:18080/cxfdemo/services/HelloWebService?wsdl");
    //url为调用webService的wsdl地址  
    QName qname=new QName("http://test.com/","say");
    Object[] objects=client.invoke(qname,"Dynamic-aaa"); 
    return objects[0].toString();
	}
	
	@RequestMapping("client3.do")
	@ResponseBody
	public String cxfclient3() throws Exception{
      DynamicClientFactory factory = DynamicClientFactory.newInstance();  
      org.apache.cxf.endpoint.Client client = factory.createClient("http://localhost:18080/cxfdemo/services/HelloWebService?wsdl");
      QName qname=new QName("http://test.com/","say");
      Object[] results=client.invoke(qname,"DynamicClientFactory"); 
      return results[0].toString();  
     
	}

}
