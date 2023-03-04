package com.github.fabriciolfj.adapters.gateway;

import com.github.fabriciolfj.entities.Transaction;

public interface TransactionSaveGateway {

    Transaction process(final Transaction transaction);
}
