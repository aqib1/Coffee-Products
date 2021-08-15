package com.accenture.io.service;

public interface FileService {
    void readProductsFromFile(String filePath);
    void readOrdersFromFile(String filePath);
    void readPaymentFromFile(String filePath);
}
