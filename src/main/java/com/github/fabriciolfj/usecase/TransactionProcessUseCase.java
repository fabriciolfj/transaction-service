package com.github.fabriciolfj.usecase;

import com.github.fabriciolfj.adapters.gateway.FraudServiceGateway;
import com.github.fabriciolfj.entities.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@RequiredArgsConstructor
@ApplicationScoped
public class TransactionProcessUseCase {

    private final TransactionSaveUseCase save;
    private final FraudServiceGateway fraudGateway;

    public Transaction execute(final Transaction transaction) {
        var result = save.execute(transaction);
        log.info("transaction save sucess {}", result.code());

        return fraudGateway.process(result);
    }
}
