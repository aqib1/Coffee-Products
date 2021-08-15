package com.accenture.io.service.Impl;

import com.accenture.io.exceptions.SizeUnavailableException;
import com.accenture.io.exceptions.ValidationException;
import com.accenture.io.model.PaymentModel;
import com.accenture.io.repository.PaymentRepository;
import com.accenture.io.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Override
    public Double amountUserOwned(String userName) {
        if (Objects.isNull(userName) || userName.isBlank()) {
            throw new ValidationException("Validation exception, user name is empty!!");
        }
        long paidAmount = amountPaidByUserName(userName);
        AtomicReference<Double> amountOfOrderedProducts = new AtomicReference<>(0.0);
        repository.ordersByUserName(userName).forEach(order ->
                amountOfOrderedProducts.set(
                        amountOfOrderedProducts.get() +
                                Optional.ofNullable(repository.productByName(order.getDrinkName())
                                        .getPriceBySize()
                                        .get(order.getSize()))
                                        .orElseThrow(() -> new SizeUnavailableException("Order size [" + order.getSize() + "] is unavailable for drink [" + order.getDrinkName() + "]"))));

        return amountOfOrderedProducts.get() - paidAmount;
    }

    @Override
    public Long amountPaidByUserName(String userName) {
        if (Objects.isNull(userName) || userName.isBlank()) {
            throw new ValidationException("Validation exception, user name is empty!!");
        }

        return repository
                .paymentsByUserName(userName)
                .stream().map(PaymentModel::getAmount).reduce(0L, Long::sum);
    }
}
