package com.accenture.io.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
    @JsonProperty("drink_name")
    private String drinkName;
    @JsonProperty("prices")
    private Map<String, Double> priceBySize;
}
