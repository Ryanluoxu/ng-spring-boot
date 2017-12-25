package io.ryanluoxu.springboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ryanluoxu.springboot.demo.model.Info;

@RestController
public class InfoController {

	@RequestMapping("/info")
	public String showInfo() {
		String info = "This is a Spring Boot Starter Project by RyanLuoXu..";
		return info;
	}
	// Actually it is already a web service.
	// URL - http://localhost:8080/info
	
	@RequestMapping("/moreinfo") // to activate ../moreinfo URL
	public Info showMoreInfo() {
		Info info = new Info();
		
		info.setAuthor("RyanLuoXu");
		info.setDatabase("PostgreSQL");
		info.setDescription("This is a Spring Boot Starter Project");
		info.setFramework("Spring Boot");
		info.setStartDate("2017-12-23");
		
		return info;
	}
	// info will be converted to JSON automatically
	// Go to URL - http://localhost:8080/moreinfo to see all these info
}
