package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableEurekaClient
@SpringBootApplication
public class DemoApplication implements CommandLineRunner
{
	//injetando o repository na classe principal
//	@Autowired
//	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//	   userRepository.saveAll(List.of(
//			   new User(null, "Flavio Augusto1","flavioaom@yahoo.com.br", "12345", 10.0),
//			   new User(null, "Flavio Augusto2","flavioaom@yahoo.com.br", "12345", 10.0),
//			   new User(null, "Flavio Augusto3","flavioaom@yahoo.com.br", "12345", 10.0)
//	   ));
	}
}
