package com.accenture.io.repository.Impl;

import com.accenture.io.exceptions.OrderNotFoundException;
import com.accenture.io.exceptions.PaymentNotFoundException;
import com.accenture.io.exceptions.ProductNotFoundException;
import com.accenture.io.model.OrderModel;
import com.accenture.io.model.PaymentModel;
import com.accenture.io.model.ProductModel;
import com.accenture.io.repository.PaymentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.Collectors;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {
    private final List<OrderModel> orders = new ArrayList<>();
    private final List<PaymentModel> payments = new ArrayList<>();
    private final List<ProductModel> products = new ArrayList<>();
    private final StampedLock stampedLock = new StampedLock();


    @Override
    public void addOrders(List<OrderModel> orders) {
        long writeLock = stampedLock.writeLock();
        try {
            this.orders.addAll(orders);
        } finally {
            stampedLock.unlockWrite(writeLock);
        }
    }

    @Override
    public void addPayments(List<PaymentModel> payments) {
        long writeLock = stampedLock.writeLock();
        try {
            this.payments.addAll(payments);
        } finally {
            stampedLock.unlockWrite(writeLock);
        }
    }

    @Override
    public void addProducts(List<ProductModel> products) {
        long writeLock = stampedLock.writeLock();
        try {
            this.products.addAll(products);
        } finally {
            stampedLock.unlockWrite(writeLock);
        }
    }


    @Override
    public List<PaymentModel> paymentsByUserName(String userName) {
        long readLock = stampedLock.tryOptimisticRead();
        if (!stampedLock.validate(readLock)){
            readLock = stampedLock.readLock();
        }
        try {
            List<PaymentModel> payments = this.payments
                    .stream()
                    .filter(payment ->  userName.equals(payment.getUserName()))
                    .collect(Collectors.toList());

            if(payments.isEmpty()) {
                throw new PaymentNotFoundException("Payment not found for user ["+userName+"]");
            }

        return payments;
        } finally {
            if (StampedLock.isReadLockStamp(readLock))
            stampedLock.unlockRead(readLock);
        }
    }

    @Override
    public List<OrderModel> ordersByUserName(String userName) {
        long readLock = stampedLock.tryOptimisticRead();
        if (!stampedLock.validate(readLock)){
            readLock = stampedLock.readLock();
        }
        try {
            List<OrderModel> orders = this.orders
                    .stream()
                    .filter(order -> userName.equals(order.getUserName()))
                    .collect(Collectors.toList());

            if(orders.isEmpty()) {
                throw new OrderNotFoundException("Order not found against user ["+userName+"]");
            }

        return orders;
        } finally {
            if (StampedLock.isReadLockStamp(readLock))
                stampedLock.unlockRead(readLock);
        }
    }

    @Override
    public ProductModel productByName(String name) {
        long readLock = stampedLock.tryOptimisticRead();
        if (!stampedLock.validate(readLock)){
            readLock = stampedLock.readLock();
        }
        try {
            return this.products
                    .stream()
                    .filter(product -> name.equals(product.getDrinkName()))
                    .findFirst()
                    .orElseThrow(() -> new ProductNotFoundException("Product not found for name ["+name+"]"));
        } finally {
            if (StampedLock.isReadLockStamp(readLock))
                stampedLock.unlockRead(readLock);
        }
    }

}
