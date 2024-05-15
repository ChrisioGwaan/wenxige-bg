package com.dangos.ce;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dangos.ce.mapper")
public class CeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeApplication.class, args);
	}

}
