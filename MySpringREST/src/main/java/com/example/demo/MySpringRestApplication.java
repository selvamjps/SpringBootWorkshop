package com.example.demo;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Payment;
import com.example.demo.repos.PaymentRepo;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude=SecurityAutoConfiguration.class)
@EnableSwagger2
@EnableDiscoveryClient
public class MySpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringRestApplication.class, args);
	}

	@Bean(name = "ramesh")
	public Payment payment1() {
		return new Payment(202, LocalDate.of(2019, Month.MARCH, 13), 4500, "Ramesh");
	}

	@Bean(name = "suresh")
	public Payment payment2() {
		return new Payment(203, LocalDate.of(2019, Month.MARCH, 13), 6500, "Suresh");
	}

	@Bean
	public CommandLineRunner commandLineRunner(PaymentRepo repo) {
		return args -> {
			repo.save(new Payment(204, LocalDate.of(2019, Month.MARCH, 14), 4500, "Kumar"));
			repo.save(new Payment(205, LocalDate.of(2018, Month.MARCH, 14), 9500, "Rajesh"));
			repo.save(new Payment(206, LocalDate.of(2017, Month.MARCH, 14), 7000, "Gopi"));
			repo.save(new Payment(207, LocalDate.of(2019, Month.MARCH, 14), 6000, "Mani"));
		};
	}

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).build();
	}

}
