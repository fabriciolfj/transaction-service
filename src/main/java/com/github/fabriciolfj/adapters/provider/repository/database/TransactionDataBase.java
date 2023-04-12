package com.github.fabriciolfj.adapters.provider.repository.database;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.TransactionWriteRequest;
import com.github.fabriciolfj.adapters.gateway.FindTransactionGateway;
import com.github.fabriciolfj.adapters.gateway.TransactionSaveGateway;
import com.github.fabriciolfj.adapters.gateway.TransactionUpdateGateway;
import com.github.fabriciolfj.adapters.provider.repository.converter.CustomerBenefitDataConverter;
import com.github.fabriciolfj.adapters.provider.repository.data.CustomerBenefitData;
import com.github.fabriciolfj.adapters.provider.repository.data.TransactionData;
import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.exceptions.TransactionNotFoundException;
import com.github.fabriciolfj.exceptions.TransactionUpdateException;
import lombok.extern.slf4j.Slf4j;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static com.github.fabriciolfj.adapters.provider.repository.converter.TransactionDataConverter.toData;
import static com.github.fabriciolfj.adapters.provider.repository.converter.TransactionDataConverter.toEntity;

@Slf4j
@ApplicationScoped
public class TransactionDataBase implements TransactionSaveGateway, FindTransactionGateway, TransactionUpdateGateway {

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

    @Override
    public Transaction process(final String code, final String status) {
        try {
            var data = dynamoDBMapper.load(TransactionData.class, code, status);
            return toEntity(data);
        } catch (Exception e) {
            log.info("transacao nao encontrada para o code {}, detalhes: {}", code, e.getMessage());
            throw new TransactionNotFoundException();
        }
    }

    @Override
    public void processUpdate(final Transaction transaction) {
        try {
            dynamoDBMapper.save(toData(transaction));
        } catch (Exception e) {
            log.info("falha ao atualizar a transacao code {} para o status {}, detalhes: {}", transaction.code(), transaction.status().getDescribe(), e.getMessage());
            throw new TransactionUpdateException();
        }
    }
}
