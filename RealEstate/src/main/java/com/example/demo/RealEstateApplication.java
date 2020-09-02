package com.example.demo;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Controller.PropertyController;

@SpringBootApplication
public class RealEstateApplication {

	public static void main(String[] args) {
		new File(PropertyController.uploadDirectory).mkdir();
		SpringApplication.run(RealEstateApplication.class, args);
	}

}
