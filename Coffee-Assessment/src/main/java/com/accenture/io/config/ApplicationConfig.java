package com.accenture.io.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value("${file.order.path}")
    private String orderFilePath;

    @Value("${file.payment.path}")
    private String paymentFilePath;

    @Value("${file.product.path}")
    private String productFilePath;

    public String getPaymentFilePath() {
        return paymentFilePath;
    }

    public String getOrderFilePath() {
        return orderFilePath;
    }

    public String getProductFilePath() {
        return productFilePath;
    }
}
