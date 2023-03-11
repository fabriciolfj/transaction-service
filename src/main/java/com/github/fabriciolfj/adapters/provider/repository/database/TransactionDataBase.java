package com.github.fabriciolfj.adapters.provider.repository.database;

import com.github.fabriciolfj.adapters.gateway.TransactionSaveGateway;
import com.github.fabriciolfj.adapters.provider.repository.data.TransactionData;
import com.github.fabriciolfj.entities.Transaction;
import lombok.extern.slf4j.Slf4j;
import javax.enterprise.context.ApplicationScoped;
import static com.github.fabriciolfj.adapters.provider.repository.converter.TransactionDataConverter.toData;

@Slf4j
@ApplicationScoped
public class TransactionDataBase implements TransactionSaveGateway {

    @Override
    public Transaction process(final Transaction transaction) {
        final TransactionData data = toData(transaction);
        data.persistAndFlush();

        log.info("transaction save, to code {}", transaction.code());
        return transaction;
    }
}
