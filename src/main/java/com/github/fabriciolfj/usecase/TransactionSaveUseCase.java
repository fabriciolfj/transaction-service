package com.github.fabriciolfj.usecase;

import com.github.fabriciolfj.adapters.gateway.*;
import com.github.fabriciolfj.entities.Transaction;
import com.github.fabriciolfj.entities.values.CustomerBenefit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@ApplicationScoped
public class TransactionSaveUseCase {

    private final TransactionSaveGateway gateway;
    private final CustomerBenefitFindGateway customerGateway;
    private final CustomerBenefitSaveGateway customerSave;
    private final CustomerBenefitUpdateGateway customerUpdate;

    @Transactional(Transactional.TxType.REQUIRED)
    public Transaction execute(final Transaction transaction) {
        var customer = customerGateway.process(transaction.getCustomer());

        if (customer.isPresent()) {
            log.info("before update benefit score {}, cashback {}", transaction.getScore(), transaction.getCashBack());
            var result = transaction.updateBenefit(customer.get());

            log.info("after update benefit score {}, cashback {}", result.getScore(), result.getCashBack());
            customerUpdate.processUpdate(result.getCustomerBenefit());
            return gateway.process(result);
        }

        customerSave.process(transaction.getCustomerBenefit());
        return gateway.process(transaction);
    }
}
