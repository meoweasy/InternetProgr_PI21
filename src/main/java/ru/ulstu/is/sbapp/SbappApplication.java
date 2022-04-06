package ru.ulstu.is.sbapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Locale;

@SpringBootApplication

public class SbappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbappApplication.class, args);
	}
}
