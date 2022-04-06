package ru.ulstu.is.sbapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@SpringBootApplication
@RestController
public class SbappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbappApplication.class, args);
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World")String name){
		return String.format("Hello %s!",name);
	}
	@GetMapping("/helloUp")
	public String helloUp(@RequestParam(value = "name", defaultValue = "World")String name){
		return String.format("Hello %s!",name).toUpperCase(Locale.ROOT);
	}
	@GetMapping("/helloLow")
	public String helloLow(@RequestParam(value = "name", defaultValue = "World")String name){
		return String.format("Hello %s!",name).toLowerCase(Locale.ROOT);
	}

}
