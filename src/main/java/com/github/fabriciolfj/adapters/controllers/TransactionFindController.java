package com.github.fabriciolfj.adapters.controllers;

import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.entities.values.StatusEnum;
import com.github.fabriciolfj.usecase.TransactionFindUseCase;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class TransactionFindController {

    private final TransactionFindUseCase useCase;

    public Transaction process(final String code, final StatusEnum statusEnum) {
        return useCase.execute(code, statusEnum);
    }
}
