package com.github.fabriciolfj.entities.values;

import com.github.fabriciolfj.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public enum StatusEnum {

    APPROVED("approved"),
    PENDING("pending"),
    DISAPPROVED("disapproved");

    private final String describe;

    public static StatusEnum toEnum(final String describe) {
        return Stream.of(StatusEnum.values())
                .filter(t -> t.describe.equalsIgnoreCase(describe))
                .findAny()
                .orElseThrow(BusinessException::new);
    }
}
