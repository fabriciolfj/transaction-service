package com.github.fabriciolfj.usecase;

import com.github.fabriciolfj.adapters.gateway.FindTransactionGateway;
import com.github.fabriciolfj.adapters.gateway.TransactionUpdateGateway;
import com.github.fabriciolfj.entities.values.StatusEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class TransactionUpdateStatusUseCase {

    private final FindTransactionGateway findUseCase;
    private final TransactionUpdateGateway updateGateway;

    public void execute(final String code, final StatusEnum statusEnum) {
        log.info("update transaction code {}, to status", code, statusEnum.getDescribe());
        final var transaction = findUseCase.process(code, StatusEnum.APPROVED.getDescribe());

        final var result = transaction.updateStatus(statusEnum);
        updateGateway.processUpdate(result);
        log.info("update success transactiom {}, to status {}", code, statusEnum.getDescribe());
    }
}
