package com.example.REST_API_example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PrimeTest {

    //@Autowired
    //private Student student;

    @Test
    public void testForPrime(){
        Student student=new Student();
        boolean st=student.isPrime(97);
        Assertions.assertEquals(true,st);
    }
}
