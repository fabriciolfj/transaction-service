package com.github.fabriciolfj.entrypoint.resources.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionFindResponseDTO {

    private BigDecimal value;
    private String describe;
    private String payment;
}
