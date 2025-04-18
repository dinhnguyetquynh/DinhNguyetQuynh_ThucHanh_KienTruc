package com.example.BookstoreCB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
public class BookstoreCbApplication {
	@RequestMapping(value = "/recommended")
	public Mono<String> readingList() throws InterruptedException {
		Thread.sleep(4000);
		return Mono.just("Truy cap bookstore");
	}


	public static void main(String[] args) {
		SpringApplication.run(BookstoreCbApplication.class, args);
	}

}
