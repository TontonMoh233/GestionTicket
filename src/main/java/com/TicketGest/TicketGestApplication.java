package com.TicketGest;


import com.TicketGest.configuration.SecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class TicketGestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketGestApplication.class, args);
	}

}
