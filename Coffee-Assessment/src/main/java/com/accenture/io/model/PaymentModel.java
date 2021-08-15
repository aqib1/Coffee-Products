package com.accenture.io.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentModel {
    @JsonProperty("user")
    private String userName;
    private Long amount;
}
