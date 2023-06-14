package com.jmg.checkagro.customer;

import com.jmg.checkagro.customer.model.Customer;
import com.jmg.checkagro.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDate;

@SpringBootApplication
@EnableFeignClients
@EnableMongoRepositories
public class ApiCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCustomerApplication.class, args);
	}
/*
	@Bean
	public CommandLineRunner loadData(CustomerRepository repository) {
		return (args) -> {
			if (!repository.findAll().isEmpty()) {
				return;
			}

			repository.save(new Customer(null, "DNI", "1111111", "", "", "", LocalDate.now(), true));
			repository.save(new Customer(null, "DNI", "2222222", "", "", "", LocalDate.now(), true));
			repository.save(new Customer(null, "DNI", "3333333", "", "", "", LocalDate.now(), true));
			repository.save(new Customer(null, "DNI", "4444444", "", "", "", LocalDate.now(), true));
		};
	}
*/
}
