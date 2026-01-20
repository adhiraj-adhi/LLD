package com.design.schema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ScalerSchemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScalerSchemaApplication.class, args);
	}

}
