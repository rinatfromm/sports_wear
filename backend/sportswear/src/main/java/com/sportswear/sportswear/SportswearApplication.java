package com.sportswear.sportswear;

import io.swagger.v3.oas.models.examples.Example;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySources;

@Slf4j
@SpringBootApplication
@PropertySources({
		//@PropertySource("classpath:constantparameters.properties"),
		//@PropertySource("classpath:sportswear.properties"),
		//@PropertySource("classpath:email.properties"),
		//@PropertySource("file:/home/vlad/IdeaProjects/MailKey/emailslog.properties")
})
public class SportswearApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportswearApplication.class, args);
		log.info("Example log from {}", Example.class.getSimpleName());
	}
}