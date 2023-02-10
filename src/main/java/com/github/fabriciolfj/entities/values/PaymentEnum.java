package com.github.fabriciolfj.entities.values;

import com.github.fabriciolfj.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public enum PaymentEnum {

    PIX("pix"),
    CARD("card"),
    TICKET("ticket");

    private final String describe;

    public static PaymentEnum toEnum(final String describe) {
        return Stream.of(PaymentEnum.values())
                .filter(t -> t.describe.equalsIgnoreCase(describe))
                .findAny()
                .orElseThrow(() -> new BusinessException());
    }
}
