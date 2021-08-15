package com.accenture.io.model;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AmountOwnedUserResponse {
    private String user;
    private Double owned;
}
