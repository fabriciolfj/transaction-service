package com.github.fabriciolfj.usecase.impl;


import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.adapters.gateway.TransactionSaveGateway;
import com.github.fabriciolfj.usecase.TransactionCreateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import javax.enterprise.context.ApplicationScoped;

@RequiredArgsConstructor
@Slf4j
@ApplicationScoped
public class TransactionTransferUseCaseImpl implements TransactionCreateUseCase {

    private final TransactionSaveGateway gateway;

    @Override
    public Transaction execute(final Transaction transaction) {
        log.info("transaction transfer create started, to code {}", transaction.code());
        return gateway.process(transaction);
    }
}
