package com.accenture.io.controller;

import com.accenture.io.model.AmountOwnedUserResponse;
import com.accenture.io.model.AmountPaidUserResponse;
import com.accenture.io.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.accenture.io.utils.URLS.USER_AMOUNT_OWNED_INFO_URL;
import static com.accenture.io.utils.URLS.USER_AMOUNT_PAID_INFO_URL;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(USER_AMOUNT_PAID_INFO_URL)
    public ResponseEntity<AmountPaidUserResponse> amountPaidByUser(@PathVariable("user") String userName) {
        return ResponseEntity.ok(AmountPaidUserResponse.builder()
                        .user(userName)
                        .amount(paymentService.amountPaidByUserName(userName))
                        .build());
    }

    @GetMapping(USER_AMOUNT_OWNED_INFO_URL)
    public ResponseEntity<AmountOwnedUserResponse> ownedByUser(@PathVariable("user") String userName) {
        return ResponseEntity.ok(AmountOwnedUserResponse.builder()
                .user(userName)
                .owned(paymentService.amountUserOwned(userName))
                .build());
    }

}
