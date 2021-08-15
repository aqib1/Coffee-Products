package com.accenture.io.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderModel {
    @JsonProperty("user")
    private String userName;
    @JsonProperty("drink")
    private String drinkName;
    private String size;
}
