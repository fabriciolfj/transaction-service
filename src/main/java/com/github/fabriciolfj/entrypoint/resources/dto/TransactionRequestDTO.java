package com.github.fabriciolfj.entrypoint.resources.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestDTO {

    private BigDecimal value;
    private String describe;
    private String payment;
    private String customer;
    private String device;
}
