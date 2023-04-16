package com.github.fabriciolfj.usecase.impl;

import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.usecase.TransactionCreateUseCase;
import com.github.fabriciolfj.usecase.TransactionProcessUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@ApplicationScoped
public class TransactionCardUseCaseImpl implements TransactionCreateUseCase {

    @ConfigProperty(name = "calc.cartao")
    private BigDecimal indexCalc;

    private final TransactionProcessUseCase transactionProcessUseCase;

    @Override
    public Transaction execute(final Transaction transaction) {
        log.info("transaction card create started, to code {}", transaction.code());
        var result = transaction.calcCashBack(indexCalc);

        return transactionProcessUseCase.execute(result);
    }
}
