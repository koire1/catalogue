package com.stage.catalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication()
public class CatalogueApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CatalogueApplication.class, args);
	}

}
