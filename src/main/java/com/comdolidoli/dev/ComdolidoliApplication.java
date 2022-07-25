package com.comdolidoli.dev;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
@Slf4j
public class ComdolidoliApplication implements ApplicationListener<ApplicationReadyEvent> {

	@Value("${custom.message}")
	String message;

	public static void main(String[] args) {
		SpringApplication.run(ComdolidoliApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		log.debug("######################################################");
		log.debug(message);
		log.debug("######################################################");
	}
}
