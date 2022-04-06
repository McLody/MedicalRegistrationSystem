package com.mclody.mrs.cmn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mclody.mrs")
@EnableDiscoveryClient
public class ServicecmnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicecmnApplication.class, args);
    }
}
