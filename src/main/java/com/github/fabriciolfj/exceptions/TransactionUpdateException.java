package com.github.fabriciolfj.exceptions;

import com.github.fabriciolfj.exceptions.enums.Errors;

public class TransactionUpdateException extends OperationException {

    public TransactionUpdateException() {
        super(Errors.TRANSACTION_NOTFOUND.toMessage());
    }
}
