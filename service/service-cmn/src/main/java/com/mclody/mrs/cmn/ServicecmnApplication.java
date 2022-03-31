package com.mclody.mrs.cmn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mclody")
public class ServicecmnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicecmnApplication.class, args);
    }
}
