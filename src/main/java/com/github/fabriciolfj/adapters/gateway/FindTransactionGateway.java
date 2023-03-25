package com.github.fabriciolfj.adapters.gateway;

import com.github.fabriciolfj.entities.Transaction;

public interface FindTransactionGateway {

    Transaction process(final String code, final String status);
}
