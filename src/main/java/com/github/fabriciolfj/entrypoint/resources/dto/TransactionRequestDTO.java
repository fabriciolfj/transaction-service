package com.github.fabriciolfj.entrypoint.resources.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestDTO {

    @NotNull(message = "{transaction.value.required}")
    private BigDecimal value;
    @NotEmpty(message = "{transaction.describe.required}")
    private String describe;
    @NotEmpty(message = "{transaction.payment.required}")
    private String payment;
    @NotEmpty(message = "{transaction.customer.required}")
    private String customer;
}
