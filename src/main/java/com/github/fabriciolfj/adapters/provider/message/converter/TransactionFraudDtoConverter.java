package com.github.fabriciolfj.adapters.provider.message.converter;

import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.adapters.provider.message.dto.TransactionFraudDto;

public class TransactionFraudDtoConverter {

    private TransactionFraudDtoConverter() { }

    public static final TransactionFraudDto toDto(final Transaction entity) {
        return TransactionFraudDto.builder()
                .transaction(entity.code())
                .customer(entity.getCustomer())
                .date(entity.registration())
                .value(entity.value())
                .build();
    }
}
