package com.example.crystalepoxy;

import com.example.crystalepoxy.product.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class CrystalEpoxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrystalEpoxyApplication.class, args);
	}

}
