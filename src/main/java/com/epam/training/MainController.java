package com.epam.training;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class MainController {
    public static void main(String[] args) {
        SpringApplication.run(MainController.class,args);
    }

}
