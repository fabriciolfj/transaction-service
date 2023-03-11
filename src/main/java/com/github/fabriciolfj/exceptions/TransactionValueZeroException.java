package com.github.fabriciolfj.exceptions;

import com.github.fabriciolfj.exceptions.enums.Errors;

public class TransactionValueZeroException extends RuntimeException {

    public TransactionValueZeroException() {
        super(Errors.TRANSACTION_ZERO.toMessage());
    }
}
