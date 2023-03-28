package com.github.fabriciolfj.exceptions.enums;

import java.util.ResourceBundle;

public enum Errors {

    ERROR_BUSINESS,
    TYPE_PAYMENT_NOTFOUND,
    TRANSACTION_ZERO,
    TRANSACTION_NOTFOUND,
    TRANSACTION_UPDATE;

    public String toMessage() {
        var bundle = ResourceBundle.getBundle("messages/exceptions");
        return bundle.getString(this.name() + ".message");
    }
}
