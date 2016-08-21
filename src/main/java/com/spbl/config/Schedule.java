package com.spbl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spbl.repository.BookRepository;

@Component
public class Schedule implements CommandLineRunner{
	@Autowired
	private BookRepository bookRepository;
	@Override
	public void run(String... args) throws Exception {
	}
	
	@Scheduled(initialDelay=1000,fixedRate=10000)
	public void run() {
		System.out.println("The number of books:"+bookRepository.count()+" from schedule.");
	}

}
