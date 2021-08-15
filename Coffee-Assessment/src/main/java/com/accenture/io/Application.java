package com.accenture.io;

import com.accenture.io.config.ApplicationConfig;
import com.accenture.io.repository.PaymentRepository;
import com.accenture.io.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private ApplicationConfig config;

    @Autowired
    private FileService fileService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args)  {
        fileService.readOrdersFromFile(config.getOrderFilePath());
        fileService.readPaymentFromFile(config.getPaymentFilePath());
        fileService.readProductsFromFile(config.getProductFilePath());
    }
}
