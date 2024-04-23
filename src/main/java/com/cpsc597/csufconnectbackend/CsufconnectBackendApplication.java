package com.cpsc597.csufconnectbackend;

import com.cpsc597.csufconnectbackend.firebase.FirebaseInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CsufconnectBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(CsufconnectBackendApplication.class, args);
		try {
			FirebaseInitializer.initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
