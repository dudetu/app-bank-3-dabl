package com.example.appbank2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;

//@PropertySource(value = {"classpath:application-mysql.properties"})

@EntityScan(basePackages = "com.example.app_bank2.other_paymens.categories")
@PropertySource(value = "classpath:variables.properties")
@SpringBootApplication
public class AppBank2Application {

    public static void main(String[] args) {
        SpringApplication.run(AppBank2Application.class, args);
    }

}