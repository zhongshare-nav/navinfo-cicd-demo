package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("/hello")
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/zz")
	public String hello(@RequestParam(name="name") String name ,
						@RequestParam(name="age") String age){
		return "name = "+name+" age= "+age;
	}
	@GetMapping("/02")
	public String hello02(@RequestParam(name="name") String name ,
						  @RequestParam(name="age") String age){
		return "name= "+name+" age= "+age;
	}
}
