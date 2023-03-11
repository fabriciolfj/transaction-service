package com.github.fabriciolfj.adapters.provider.message;

import com.github.fabriciolfj.adapters.gateway.FraudServiceGateway;
import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.adapters.provider.message.converter.TransactionFraudDtoConverter;
import com.github.fabriciolfj.adapters.provider.message.dto.TransactionFraudDto;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Slf4j
public class ProducerFraudMessage implements FraudServiceGateway {

    @Inject
    @Channel("fraud-service")
    Emitter<TransactionFraudDto> emitter;

    @Override
    public Transaction process(final Transaction transaction) {
        var dto = TransactionFraudDtoConverter.toDto(transaction);

        emitter.send(dto);
        log.info("message send validate fraud to transaciton {}", transaction.code());
        return transaction;
    }
}
