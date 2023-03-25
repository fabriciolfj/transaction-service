package com.github.fabriciolfj.exceptions;

import com.github.fabriciolfj.exceptions.enums.Errors;

public class TransactionNotFoundException extends OperationException {

    public TransactionNotFoundException() {
        super(Errors.TRANSACTION_NOTFOUND.toMessage());
    }
}
