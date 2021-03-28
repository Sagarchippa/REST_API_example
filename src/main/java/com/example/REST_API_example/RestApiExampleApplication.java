package com.example.REST_API_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.Scanner;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class RestApiExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(RestApiExampleApplication.class, args);
		System.out.println("hello spring boot");
		Student student=context.getBean(Student.class);
        boolean[] primes=student.primeSeive(100);
        Scanner input=new Scanner(System.in);
        int m=input.nextInt();
        student.printPrimes(primes);
		System.out.println(m+"hello anna");
	}

}
