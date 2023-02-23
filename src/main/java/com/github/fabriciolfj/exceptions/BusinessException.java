package com.github.fabriciolfj.exceptions;

import com.github.fabriciolfj.exceptions.enums.Errors;

public class BusinessException extends RuntimeException {

    public BusinessException() {
        super(Errors.ERROR_BUSINESS.toMessage());
    }
}
