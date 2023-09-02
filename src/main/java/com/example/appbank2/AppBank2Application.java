package com.example.appbank2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@PropertySource(value = {"classpath:application-mysql.properties"})

@SpringBootApplication
public class AppBank2Application {

    public static void main(String[] args) {
        SpringApplication.run(AppBank2Application.class, args);
    }

}