package com.github.fabriciolfj.entities;

import com.github.fabriciolfj.entities.values.PaymentEnum;
import jdk.jshell.Snippet;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Transaction(String code, PaymentEnum payment, Snippet.Status status, BigDecimal value, String describe, LocalDateTime registration) {
}
