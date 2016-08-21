package com.spbl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.spbl.repository.BookRepository;

@SpringBootApplication
@EnableScheduling
public class SpblApplication implements CommandLineRunner{
	@Autowired
	private BookRepository bookRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpblApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("The number of books:"+bookRepository.count());
	}
}
