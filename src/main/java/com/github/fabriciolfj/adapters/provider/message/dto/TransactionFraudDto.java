package com.github.fabriciolfj.adapters.provider.message.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TransactionFraudDto {

    private String customer;
    private String transaction;
    private BigDecimal value;
    private LocalDateTime date;
}
