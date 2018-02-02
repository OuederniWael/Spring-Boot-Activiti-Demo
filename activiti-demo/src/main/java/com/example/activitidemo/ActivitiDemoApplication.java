package com.example.activitidemo;

import java.awt.PageAttributes.MediaType;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ActivitiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiDemoApplication.class, args);
	}
	
	@RestController
	public static class MyRestController{
		@Autowired
		private RuntimeService runtimeService;
		
		@RequestMapping(value = "/start-my-process", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
		public void startMyProcess() {
			runtimeService.startProcessInstanceByKey("testProcess");
			System.out.println("we have now " + runtimeService.createProcessInstanceQuery().count() + "process instances !");
		}
	}
}
