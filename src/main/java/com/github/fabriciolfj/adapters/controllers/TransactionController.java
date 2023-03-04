package com.github.fabriciolfj.adapters.controllers;

import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.exceptions.TypePaymentNotFoundException;
import com.github.fabriciolfj.usecase.TransactionCreateUseCase;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;

@ApplicationScoped
@RequiredArgsConstructor
public class TransactionController {

    private final Instance<TransactionCreateUseCase> createsTransaction;

    public Transaction process(final Transaction entity) {
        return createsTransaction.stream()
                .filter(t -> isPaymentPresent(entity, t))
                .map(v -> v.execute(entity))
                .findFirst()
                .orElseThrow(() -> new TypePaymentNotFoundException());
    }

    private static boolean isPaymentPresent(Transaction entity, TransactionCreateUseCase t) {
        var name = t.getClass().getSimpleName();
        return name.contains(entity.getDescribePayment());
    }
}
