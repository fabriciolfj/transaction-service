package com.github.fabriciolfj.adapters.gateway;

import com.github.fabriciolfj.entities.Transaction;
public interface TransactionUpdateGateway {

    void processUpdate(final Transaction transaction);
}
