package oa_maven_ssm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("Affair")
public class Test {
	
	@RequestMapping("/doList.action")
	public void doList(String name){
		
		System.out.println(name);
	}
	
}
