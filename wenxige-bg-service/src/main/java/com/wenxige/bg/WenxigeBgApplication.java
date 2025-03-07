package com.wenxige.bg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wenxige.bg.mapper")
public class WenxigeBgApplication {

	public static void main(String[] args) {
		SpringApplication.run(WenxigeBgApplication.class, args);
	}

}
