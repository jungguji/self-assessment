package com.jgji.selfassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SelfAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelfAssessmentApplication.class, args);
	}

}
