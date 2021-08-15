package com.accenture.io.model;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AmountPaidUserResponse {
 private String user;
 private Long amount;
}
