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
		System.out.println("git changes happend1");
		System.out.println("git changes happend2");
		boolean st=student.isPrime(97);
		System.out.println(st);
		System.out.println("kaka aagutalev kada");
		st=student.isPerfect(28);
		System.out.println(st+"IDI MAMULUGA LEDU GADA...program");
		System.out.pritnln("learning git.. trough terminal commands");
		System.out.println("new change.. after previous git terminal controlled command execution");
		System.out.println("new modifications");
	}

}
