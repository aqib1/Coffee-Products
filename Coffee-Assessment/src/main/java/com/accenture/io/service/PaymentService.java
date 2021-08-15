package com.accenture.io.service;

public interface PaymentService {
    Long amountPaidByUserName(String userId);
    Double amountUserOwned(String userName);
}
