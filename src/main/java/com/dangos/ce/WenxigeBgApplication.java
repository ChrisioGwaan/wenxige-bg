package com.dangos.ce;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dangos.ce.mapper")
public class WenxigeBgApplication {

	public static void main(String[] args) {
		SpringApplication.run(WenxigeBgApplication.class, args);
	}

}
