package com.github.fabriciolfj.entrypoint.resources.convert;

import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.entities.values.PaymentEnum;
import com.github.fabriciolfj.entities.values.StatusEnum;
import com.github.fabriciolfj.entrypoint.resources.dto.TransactionRequestDTO;
import com.github.fabriciolfj.entrypoint.resources.dto.TransactionResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionDTOConvert {

    private TransactionDTOConvert() {
    }

    public static Transaction toEntity(final TransactionRequestDTO dto) {
        return new Transaction(UUID.randomUUID().toString(), PaymentEnum.toEnum(dto.getPayment()), StatusEnum.PENDING, dto.getValue(), dto.getDescribe(), LocalDateTime.now());
    }

    public static TransactionResponseDTO toResponse(final Transaction transaction) {
        return new TransactionResponseDTO(transaction.code());
    }
}
