package com.github.fabriciolfj.entrypoint.resources.convert;

import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.entrypoint.resources.dto.TransactionFindResponseDTO;

public class TransactionFindResponseDTOConvert {

    private TransactionFindResponseDTOConvert() {

    }

    public static TransactionFindResponseDTO toDTO(final Transaction transaction) {
        return TransactionFindResponseDTO
                .builder()
                .value(transaction.value())
                .describe(transaction.describe())
                .payment(transaction.getDescribePayment())
                .build();

    }
}
