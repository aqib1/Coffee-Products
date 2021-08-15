package com.accenture.io.controller.model;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseError {
    private String createdAt;
    private String detailedMessage;
    private int errorCode;
    private String exceptionName;
    private String errorMessage;
}
