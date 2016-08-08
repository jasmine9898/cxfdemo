package com.test.client;

import javax.annotation.Resource;
import javax.xml.namespace.QName;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import cxf.stub.HelloWebService;
import cxf.stub.HelloWebServiceImplService;

/*import stubsss.HelloWebService;
import stubsss.HelloWebServiceService;*/

@Controller
public class StubTestController {

	 	@RequestMapping("client4.do")
	@ResponseBody
	public String cxfclientstub(){
		HelloWebService hello=new HelloWebServiceImplService().getHelloWebServiceImplPort();
		return hello.say("stub---xxx");
	}
}
