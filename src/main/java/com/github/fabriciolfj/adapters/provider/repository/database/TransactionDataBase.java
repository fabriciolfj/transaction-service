package com.github.fabriciolfj.adapters.provider.repository.database;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.TransactionWriteRequest;
import com.github.fabriciolfj.adapters.gateway.TransactionSaveGateway;
import com.github.fabriciolfj.adapters.provider.repository.converter.CustomerBenefitDataConverter;
import com.github.fabriciolfj.adapters.provider.repository.data.CustomerBenefitData;
import com.github.fabriciolfj.adapters.provider.repository.data.TransactionData;
import com.github.fabriciolfj.entities.Transaction;
import lombok.extern.slf4j.Slf4j;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static com.github.fabriciolfj.adapters.provider.repository.converter.TransactionDataConverter.toData;

@Slf4j
@ApplicationScoped
public class TransactionDataBase implements TransactionSaveGateway {

    @Inject
    private DynamoDBMapper dynamoDBMapper;

    @Override
    public Transaction process(final Transaction transaction) {
        final TransactionData transactionData = toData(transaction);
        final CustomerBenefitData customerBenefitData = CustomerBenefitDataConverter.toData(transaction.getCustomerBenefit());

        var dynamodbTransaction = new TransactionWriteRequest();
        dynamodbTransaction.addPut(transactionData);
        dynamodbTransaction.addPut(customerBenefitData);

        dynamoDBMapper.transactionWrite(dynamodbTransaction);
        log.info("transaction save, to code {}", transaction.code());
        return transaction;
    }
}
