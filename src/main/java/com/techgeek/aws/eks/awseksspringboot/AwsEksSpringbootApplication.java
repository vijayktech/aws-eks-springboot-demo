package com.techgeek.aws.eks.awseksspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AwsEksSpringbootApplication {

	@GetMapping("/welcome")
	public String getGreetings(){
		return "App is deployed to EKS cluster";
	}

	public static void main(String[] args) {
		SpringApplication.run(AwsEksSpringbootApplication.class, args);
	}

}
