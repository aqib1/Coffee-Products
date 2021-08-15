package com.accenture.io.repository;

import com.accenture.io.model.OrderModel;
import com.accenture.io.model.PaymentModel;
import com.accenture.io.model.ProductModel;

import java.util.List;

public interface PaymentRepository {
    void addOrders(List<OrderModel> orders);
    void addPayments(List<PaymentModel> payments);
    void addProducts(List<ProductModel> products);
    List<PaymentModel> paymentsByUserName(String userName);
    List<OrderModel> ordersByUserName(String userName);
    ProductModel productByName(String name);
}
