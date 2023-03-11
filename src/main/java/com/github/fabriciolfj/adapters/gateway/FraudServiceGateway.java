package com.github.fabriciolfj.adapters.gateway;

import com.github.fabriciolfj.entities.Transaction;

public interface FraudServiceGateway {

    Transaction process(final Transaction transaction);
}
