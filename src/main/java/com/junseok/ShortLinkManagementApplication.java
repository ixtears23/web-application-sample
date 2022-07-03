package com.junseok;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.ab180.api.**.domain")
@SpringBootApplication
public class ShortLinkManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShortLinkManagementApplication.class, args);
	}

}
