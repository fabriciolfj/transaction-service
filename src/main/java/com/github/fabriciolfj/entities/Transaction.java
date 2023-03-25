package com.github.fabriciolfj.entities;

import com.github.fabriciolfj.entities.values.CustomerBenefit;
import com.github.fabriciolfj.entities.values.PaymentEnum;
import com.github.fabriciolfj.entities.values.StatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Transaction(String code, PaymentEnum payment, StatusEnum status, BigDecimal value, String describe,
                          LocalDateTime registration, CustomerBenefit customer) {

    public Transaction(final String code, final PaymentEnum payment, final StatusEnum status, final BigDecimal value, final String describe, final LocalDateTime registration) {
        this(code, payment, status, value, describe, registration, null);
    }

    public String getDescribePayment() {
        return payment.getDescribe();
    }

    public String getDescribeStatus() {
        return status.getDescribe();
    }

    public Transaction updateBenefit(final CustomerBenefit customer) {
        updateCashBack(customer.getCashBack());
        updateScore(customer.getScore());

        return this;
    }

    public Transaction updateCashBack(final BigDecimal value) {
        this.customer.setCashBack(getCashBack().add(value));
        return this;
    }

    public Transaction updateScore(final Integer score) {
        this.customer.setScore(getScore() + score);
        return this;
    }

    public Transaction calcScore(final Integer value) {
        return updateScore(this.value
                .divide(BigDecimal.valueOf(value))
                .intValue());
    }

    public Transaction calcCashBack(final BigDecimal value) {
        return updateCashBack(this.value.multiply(value.divide(BigDecimal.valueOf(100))));
    }

    public String getCustomer() {
        return this.customer.getCode();
    }

    public CustomerBenefit getCustomerBenefit() {
        return this.customer;
    }

    public Integer getScore() {
        return customer.getScore();
    }

    public BigDecimal getCashBack() {
        return customer.getCashBack();
    }
}
