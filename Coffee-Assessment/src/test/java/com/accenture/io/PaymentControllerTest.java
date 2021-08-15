package com.accenture.io;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Amount paid by user against user name")
    @Test
    public void testAmountPaidByUser_Success() throws Exception {
        mockMvc.perform(get("/paid/aqib"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.user").value("aqib"))
            .andExpect(jsonPath("$.amount").value(2L))
            .andDo(print());
    }

    @DisplayName("Payment not found against given user")
    @Test
    public void testAmountPaidByUser_PaymentNotFound_Failure() throws Exception {
        mockMvc.perform(get("/paid/test"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.detailedMessage").value("Payment not found for user [test] [Bad request exception! => (PaymentNotFoundException)]"))
                .andExpect(jsonPath("$.errorCode").value(400))
                .andExpect(jsonPath("$.exceptionName").value("com.accenture.io.exceptions.PaymentNotFoundException"))
                .andDo(print());
    }

    @DisplayName("Payment owned by a user against user name")
    @Test
    public void testOwnedByUser_Test() throws Exception {
        mockMvc.perform(get("/owned/aqib"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user").value("aqib"))
                .andExpect(jsonPath("$.owned").value(1.0))
                .andDo(print());
    }

    @DisplayName("Payment owned not found against given user")
    @Test
    public void testOwnedPaidByUser_PaymentNotFound_Failure() throws Exception {
        mockMvc.perform(get("/owned/test"))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.detailedMessage").value("Payment not found for user [test] [Bad request exception! => (PaymentNotFoundException)]"))
                .andExpect(jsonPath("$.errorCode").value(400))
                .andExpect(jsonPath("$.exceptionName").value("com.accenture.io.exceptions.PaymentNotFoundException"))
                .andDo(print());
    }
}
