package com.github.fabriciolfj.adapters.controllers;

import com.github.fabriciolfj.entities.values.StatusEnum;
import com.github.fabriciolfj.usecase.TransactionUpdateStatusUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class TransactionUpdateController {

    private final TransactionUpdateStatusUseCase updateStatusUseCase;

    public void process(final String code, final String status) {
        var statusEnum = StatusEnum.toEnum(status);
        log.info("update transaction code {}, to status", code, statusEnum.getDescribe());

        updateStatusUseCase.execute(code, statusEnum);
    }
}
