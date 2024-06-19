package com.example.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		// ===건들 시 사망========================================================= //
		SpringApplication.run(PracticeApplication.class, args);
		// =============================================================== //


	}

}
