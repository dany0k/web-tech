package ru.vsu.ru.zmaev.lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@SpringBootApplication
public class Lab2Application {
    public static void main(String[] args) {

        SpringApplication.run(Lab2Application.class, args);
    }
}
