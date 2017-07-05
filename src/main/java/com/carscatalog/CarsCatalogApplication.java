package com.carscatalog;

import com.carscatalog.controllers.ViewCarController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;

@SpringBootApplication
@EnableTransactionManagement
public class CarsCatalogApplication {
	public static void main(String[] args) {
		new File(ViewCarController.uploadingdir).mkdirs();
		SpringApplication.run(CarsCatalogApplication.class, args);
	}
}
