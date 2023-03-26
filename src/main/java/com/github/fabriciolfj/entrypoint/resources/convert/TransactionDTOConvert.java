package com.github.fabriciolfj.entrypoint.resources.convert;

import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.entities.values.Customer;
import com.github.fabriciolfj.entities.values.PaymentEnum;
import com.github.fabriciolfj.entities.values.StatusEnum;
import com.github.fabriciolfj.entrypoint.resources.dto.TransactionRequestDTO;
import com.github.fabriciolfj.entrypoint.resources.dto.TransactionResponseDTO;
import com.github.fabriciolfj.exceptions.TransactionValueZeroException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionDTOConvert {

    private static final Integer ZERO_SCORE = 0;

    private TransactionDTOConvert() {
    }

    public static Transaction toEntity(final TransactionRequestDTO dto) {
        if (dto.getValue() == null || dto.getValue().equals(BigDecimal.ZERO)) {
            throw new TransactionValueZeroException();
        }

        return new Transaction(UUID.randomUUID().toString(),
                PaymentEnum.toEnum(dto.getPayment()),
                StatusEnum.PENDING,
                dto.getValue(),
                dto.getDescribe(),
                LocalDateTime.now(),
                toCustomer(dto));
    }

    private static Customer toCustomer(TransactionRequestDTO dto) {
        var customer = Customer.builder().code(dto.getCustomer()).cashBack(BigDecimal.ZERO).score(ZERO_SCORE)
                .device(dto.getDevice()).build();
        return customer;
    }

    public static TransactionResponseDTO toResponse(final Transaction transaction) {
        return new TransactionResponseDTO(transaction.code());
    }
}
