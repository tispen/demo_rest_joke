package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//веб-ресурс, выдающий рандомные шутки
		String url = "https://official-joke-api.appspot.com/random_joke";

		WebClient.Builder builder = WebClient.builder();

		String jokeRandom = builder.build()
				.get()
				.uri(url)
				.retrieve()
				.bodyToMono(String.class)
				.block();

		System.out.println("-------------------------");
		System.out.println(jokeRandom);
		System.out.println("-------------------------");
	}
}
