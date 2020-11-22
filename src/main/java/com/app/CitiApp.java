package com.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.services",
})
@SpringBootApplication
public class CitiApp {
    public static void main(String[] args) {
        SpringApplication.run(CitiApp.class, args);
    }

}
