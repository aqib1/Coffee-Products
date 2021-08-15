package com.accenture.io;

import com.accenture.io.exceptions.SizeUnavailableException;
import com.accenture.io.exceptions.ValidationException;
import com.accenture.io.helper.DataHelper;
import com.accenture.io.repository.PaymentRepository;
import com.accenture.io.service.Impl.PaymentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PaymentServiceImplTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Spy
    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Test
    public void testAmountUserOwned_ValidationException_Null_UserName() {
        Assertions.assertThrows(ValidationException.class, () ->
                paymentService.amountUserOwned(null)
        );
    }

    @Test
    public void testAmountUserOwned_ValidationException_Empty_UserName() {
        Assertions.assertThrows(ValidationException.class, () ->
                paymentService.amountUserOwned("")
        );
    }

    @Test
    public void testAmountUserOwned_SizeUnavailableException() {
        when(paymentRepository.paymentsByUserName(anyString()))
                .thenReturn(DataHelper.payments());
        when(paymentRepository.productByName(anyString()))
                .thenReturn(DataHelper.productModelWithUnknownSize());
        when(paymentRepository.ordersByUserName(anyString()))
                .thenReturn(DataHelper.orders());

        Assertions.assertThrows(SizeUnavailableException.class, () ->
                paymentService.amountUserOwned("test")
        );
    }
}
