package com.github.fabriciolfj.adapters.provider.repository.converter;

import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.adapters.provider.repository.data.TransactionData;
import com.github.fabriciolfj.entities.values.PaymentEnum;
import com.github.fabriciolfj.entities.values.StatusEnum;

import java.time.LocalDateTime;

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
                .customer(transaction.getCustomer())
                .build();
    }

    public static Transaction toEntity(final TransactionData data) {
        return new Transaction(data.getCode(), PaymentEnum.toEnum(data.getPayment()), StatusEnum.toEnum(data.getStatus()), data.getValue(),
                data.getDetails(), LocalDateTime.parse(data.getDateRegistry()));
    }
}
