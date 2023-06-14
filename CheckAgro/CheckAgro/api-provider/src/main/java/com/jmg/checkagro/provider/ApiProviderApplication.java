package com.jmg.checkagro.provider;

import com.jmg.checkagro.provider.model.Provider;
import com.jmg.checkagro.provider.repository.ProviderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@SpringBootApplication
@EnableJpaRepositories
@EnableFeignClients
public class ApiProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProviderApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ProviderRepository repository) {
		return (args) -> {
			if (!repository.findAll().isEmpty()) {
				return;
			}

			repository.save(new Provider(null, "DNI", "6666666", "", "", "", LocalDate.now(), true));
			repository.save(new Provider(null, "DNI", "7777777", "", "", "", LocalDate.now(), true));
			repository.save(new Provider(null, "DNI", "8888888", "", "", "", LocalDate.now(), true));
			repository.save(new Provider(null, "DNI", "9999999", "", "", "", LocalDate.now(), true));
		};
	}

}
