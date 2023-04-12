package com.github.fabriciolfj.adapters.provider.repository.converter;

import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.adapters.provider.repository.data.TransactionData;
import com.github.fabriciolfj.entities.values.Customer;
import com.github.fabriciolfj.entities.values.PaymentEnum;
import com.github.fabriciolfj.entities.values.StatusEnum;
import com.github.fabriciolfj.util.DateFormatedUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionDataConverter {

    private TransactionDataConverter() { }

    public static TransactionData toData(final Transaction transaction) {
        return TransactionData.builder()
                .value(transaction.value())
                .code(transaction.code())
                .status(transaction.getDescribeStatus())
                .dateRegistry(transaction.registration())
                .details(transaction.describe())
                .payment(transaction.getDescribePayment())
                .customer(transaction.getCustomer())
                .build();
    }

    public static Transaction toEntity(final TransactionData data) {
        var customer = Customer.builder()
                .code(data.getCustomer())
                .build();

        return new Transaction(data.getCode(), PaymentEnum.toEnum(data.getPayment()), StatusEnum.toEnum(data.getStatus()), data.getValue(),
                data.getDetails(), data.getDateRegistry(), customer);
    }
}
