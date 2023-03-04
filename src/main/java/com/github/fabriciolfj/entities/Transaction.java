package com.github.fabriciolfj.entities;

import com.github.fabriciolfj.entities.values.PaymentEnum;
import com.github.fabriciolfj.entities.values.StatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Transaction(String code, PaymentEnum payment, StatusEnum status, BigDecimal value, String describe, LocalDateTime registration) {

    public String getDescribePayment() {
        return payment.getDescribe();
    }

    public String getDescribeStatus() {
        return status.getDescribe();
    }
}
