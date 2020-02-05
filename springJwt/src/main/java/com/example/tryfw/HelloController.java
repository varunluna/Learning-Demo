package com.example.tryfw;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private String greetingMessage = "hello";
	
	@GetMapping("/hello")
	public String sayHello()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName();
		Object pricipal = authentication.getPrincipal();
		Object detail = authentication.getDetails();
		System.out.println("name : "+name+" pricipla : "+pricipal+" detail : "+detail);
		return greetingMessage+"................."+name ;
	}
	
	@GetMapping("/helloAdmin")
	public String adminHello()
	{
		return "this is a special message....."+SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	@PutMapping("/changeMessage/{message}")
	public String changeMesage(@PathVariable String message)
	{
		this.setGreetingMessage(message);
		return "success";
	}
	
	public String getGreetingMessage() {
		return greetingMessage;
	}

	public void setGreetingMessage(String greetingMessage) {
		this.greetingMessage = greetingMessage;
	}
	
}
