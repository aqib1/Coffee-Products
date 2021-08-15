package com.accenture.io.helper;

import com.accenture.io.model.OrderModel;
import com.accenture.io.model.PaymentModel;
import com.accenture.io.model.ProductModel;

import java.util.*;

public class DataHelper {

    public static List<OrderModel> orders() {
        return Collections.singletonList(order());
    }

    public static OrderModel order() {
        return OrderModel.builder()
                .drinkName("test")
                .size("medium")
                .userName("aqib")
                .build();
    }

    public static List<PaymentModel> payments() {
        return Collections.singletonList(payment());
    }

    public static PaymentModel payment() {
        return PaymentModel.builder()
                .amount(1L)
                .userName("test")
                .build();
    }

    public static ProductModel productModelWithUnknownSize() {
        return ProductModel.builder().drinkName("test")
                .priceBySize(Collections.singletonMap("small", 12.0)).build();
    }

    private DataHelper() {

    }
}
