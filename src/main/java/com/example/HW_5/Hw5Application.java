package com.example.HW_5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Hw5Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw5Application.class, args);
	}

	@Bean
	CommandLineRunner runner(SightRepository repository) {
		return args -> {
			KeelungSightsCrawler crawler = new KeelungSightsCrawler();

			List<Sight> sightsAll = new ArrayList<>();
			List<String> zones = Arrays.asList("七堵", "中山","中正","仁愛","安樂","信義","暖暖");
			for (String zone : zones) {
				List<Sight> sightsZone = crawler.getItems(zone);
				sightsAll.addAll(sightsZone);
			}

			repository.insert(sightsAll);
		};
	}

}
