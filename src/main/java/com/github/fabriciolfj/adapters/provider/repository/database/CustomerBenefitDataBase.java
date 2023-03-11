package com.github.fabriciolfj.adapters.provider.repository.database;

import com.github.fabriciolfj.adapters.gateway.CustomerBenefitFindGateway;
import com.github.fabriciolfj.adapters.gateway.CustomerBenefitSaveGateway;
import com.github.fabriciolfj.adapters.gateway.CustomerBenefitUpdateGateway;
import com.github.fabriciolfj.adapters.provider.repository.converter.CustomerBenefitDataConverter;
import com.github.fabriciolfj.adapters.provider.repository.data.CustomerBenefitData;
import com.github.fabriciolfj.entities.values.CustomerBenefit;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.LockModeType;
import java.util.Optional;

@ApplicationScoped
@Slf4j
public class CustomerBenefitDataBase implements CustomerBenefitFindGateway, CustomerBenefitSaveGateway, CustomerBenefitUpdateGateway {

    @Override
    public Optional<CustomerBenefit> process(final String code) {
        log.info("query customer by code {}", code);
        return CustomerBenefitData.find("code", code).withLock(LockModeType.OPTIMISTIC).firstResultOptional()
                .map(value -> CustomerBenefitDataConverter.toEntity((CustomerBenefitData) value));
    }

    @Override
    public void process(final CustomerBenefit customer) {
        var data = CustomerBenefitDataConverter.toData(customer);
        data.persistAndFlush();
    }

    @Override
    public void processUpdate(final CustomerBenefit customer) {
        var data = CustomerBenefitDataConverter.toData(customer);
        data.update("score = ?1, cashBack = ?2 where code = ?3", data.getScore(), data.getCashBack(), data.getCode());
    }
}
