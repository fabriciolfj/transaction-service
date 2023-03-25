package com.github.fabriciolfj.usecase;

import com.github.fabriciolfj.adapters.gateway.FindTransactionGateway;
import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.entities.values.StatusEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class TransactionFindUseCase {

    private final FindTransactionGateway findTransaction;

    public Transaction execute(final String code, final StatusEnum statusEnum) {
        log.info("find transaction to code {}", code);
        return findTransaction.process(code, statusEnum.getDescribe());
    }
}
