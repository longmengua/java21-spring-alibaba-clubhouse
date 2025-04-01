package com.example.spring_alibaba_clubhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringAlibabaClubhouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringAlibabaClubhouseApplication.class, args);
    }
}
