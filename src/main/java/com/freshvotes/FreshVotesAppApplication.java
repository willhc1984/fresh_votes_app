package com.freshvotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.freshvotes.model.User;
import com.freshvotes.repository.UserRepository;

@SpringBootApplication
public class FreshVotesAppApplication  implements CommandLineRunner{
	
	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(FreshVotesAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		UserModel u1 = new UserModel();
//		u1.setName("maria"); u1.setUsername("maria"); u1.setPassword("$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK");
//		repository.save(u1);
	}

}
