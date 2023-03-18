package com.github.fabriciolfj.adapters.provider.repository.converter;

import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.adapters.provider.repository.data.TransactionData;

public class TransactionDataConverter {

    private TransactionDataConverter() { }

    public static TransactionData toData(final Transaction transaction) {
        return TransactionData.builder()
                .value(transaction.value())
                .code(transaction.code())
                .status(transaction.getDescribeStatus())
                .dateRegistry(transaction.registration().toString())
                .details(transaction.describe())
                .payment(transaction.getDescribePayment())
                .build();
    }
}
