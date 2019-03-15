package com.example.demo;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.entity.PartnerDriver;
import com.example.demo.services.DriverService;

@SpringBootApplication
public class JdbcTemplateApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(JdbcTemplateApplication.class, args);
		System.out.println(ctx.getBean("dataSource"));
		
		DriverService service = ctx.getBean(DriverService.class);
		
		System.out.println("Row Added :" + service.addDriver());
	}
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public JdbcTemplate template() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public PartnerDriver driver() {
		return new PartnerDriver(101, "Jayaraman", 48467, 3.9);
	}

}
