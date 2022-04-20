package com.example.ProgettoCasotto;

import com.example.ProgettoCasotto.api.PostoDatiMg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgettoCasottoApplication {

	// html checkbox
	public static void main(String[] args) {
		SpringApplication.run(PostoDatiMg.class, args);
	}

}
