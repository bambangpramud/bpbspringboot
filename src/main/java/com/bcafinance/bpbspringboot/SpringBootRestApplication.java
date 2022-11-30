package com.bcafinance.bpbspringboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories
public class SpringBootRestApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApplication.class,args);
    }
}