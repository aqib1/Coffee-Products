package com.accenture.io.service.Impl;

import com.accenture.io.exceptions.FileHelperException;
import com.accenture.io.model.OrderModel;
import com.accenture.io.model.PaymentModel;
import com.accenture.io.model.ProductModel;
import com.accenture.io.repository.PaymentRepository;
import com.accenture.io.service.FileService;
import com.accenture.io.utils.FileHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileHelper fileHelper;

    @Autowired
    private PaymentRepository repository;

    @Override
    public void readProductsFromFile(String filePath) {
        try {
           List<ProductModel> products = fileHelper.fromJson(fileHelper.readJsonFromFile(filePath), new TypeReference<>() {});
           repository.addProducts(products);
        } catch (URISyntaxException | IOException e) {
            throw new FileHelperException(e.getMessage(), e);
        }

    }

    @Override
    public void readOrdersFromFile(String filePath) {
        try {
            List<OrderModel> orders = fileHelper.fromJson(fileHelper.readJsonFromFile(filePath), new TypeReference<>() {});
            repository.addOrders(orders);
        } catch (URISyntaxException | IOException e) {
            throw new FileHelperException(e.getMessage(), e);
        }
    }

    @Override
    public void readPaymentFromFile(String filePath) {
        try {
            List<PaymentModel> payments = fileHelper.fromJson(fileHelper.readJsonFromFile(filePath), new TypeReference<>() {});
           repository.addPayments(payments);
        } catch (URISyntaxException | IOException e) {
            throw new FileHelperException(e.getMessage(), e);
        }
    }
}
