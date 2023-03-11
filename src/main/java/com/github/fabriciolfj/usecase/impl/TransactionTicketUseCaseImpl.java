package com.github.fabriciolfj.usecase.impl;

import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.usecase.TransactionCreateUseCase;
import com.github.fabriciolfj.usecase.TransactionProcessUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import javax.enterprise.context.ApplicationScoped;

@RequiredArgsConstructor
@Slf4j
@ApplicationScoped
public class TransactionTicketUseCaseImpl implements TransactionCreateUseCase {

    private static final Integer CALC_SCORE = 100;

    private final TransactionProcessUseCase transactionProcessUseCase;

    @Override
    public Transaction execute(final Transaction transaction) {
        log.info("transaction ticket create started, to code {}", transaction.code());
        var result = transaction.calcScore(CALC_SCORE);

        return transactionProcessUseCase.execute(result);
    }
}
