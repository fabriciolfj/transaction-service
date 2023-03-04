package com.github.fabriciolfj.exceptions;

import com.github.fabriciolfj.exceptions.enums.Errors;

public class TypePaymentNotFoundException extends RuntimeException {

    public TypePaymentNotFoundException() {
        super(Errors.TYPE_PAYMENT_NOTFOUND.toMessage());
    }
}
