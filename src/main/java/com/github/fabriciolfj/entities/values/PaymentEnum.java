package com.github.fabriciolfj.entities.values;

import com.github.fabriciolfj.exceptions.BusinessException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum PaymentEnum {

    TRANSFER("Transfer"),
    CARD("Card"),
    TICKET("Ticket");

    private final String describe;

    public static PaymentEnum toEnum(final String describe) {
        return Stream.of(PaymentEnum.values())
                .filter(t -> t.describe.equalsIgnoreCase(describe))
                .findAny()
                .orElseThrow(() -> new BusinessException());
    }
}
