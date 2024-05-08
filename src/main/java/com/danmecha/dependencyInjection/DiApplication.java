package com.danmecha.dependencyInjection;

import com.danmecha.dependencyInjection.postgresql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.Collections;

@SpringBootApplication
public class DiApplication {

	@Autowired
	private Environment env;

//	public String getHostName() {
//		return env.getProperty("HOSTNAME");
//	}

	//setting up the studentRepositoty for use
	private final StudentRepository repository;

	public DiApplication(StudentRepository repository) {
		this.repository = repository;
	}

	//setting the profile programmatically by doing the following
//	SpringApplication app = new SpringApplication(DiApplication.class);
//	app.setDefaultProperties(Collections.single)
	public static void main(String[] args) {
		SpringApplication.run(DiApplication.class, args);
		String hostname = System.getProperty("java.net.hostname");
		System.out.println("Hostname: " + hostname);

	}



}
