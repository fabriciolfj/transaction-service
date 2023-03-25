package com.github.fabriciolfj.entities.values;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerBenefit {

    private String code;
    private Integer score;
    private BigDecimal cashBack;
}
