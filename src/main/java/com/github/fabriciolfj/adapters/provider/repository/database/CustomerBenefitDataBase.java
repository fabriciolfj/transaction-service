package com.github.fabriciolfj.adapters.provider.repository.database;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.github.fabriciolfj.adapters.gateway.CustomerBenefitFindGateway;
import com.github.fabriciolfj.adapters.provider.repository.converter.CustomerBenefitDataConverter;
import com.github.fabriciolfj.adapters.provider.repository.data.CustomerBenefitData;
import com.github.fabriciolfj.entities.values.Customer;
import lombok.extern.slf4j.Slf4j;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
@Slf4j
public class CustomerBenefitDataBase implements CustomerBenefitFindGateway {

    @Inject
    private DynamoDBMapper dynamoDBMapper;

    @Override
    public Optional<Customer> process(final String code) {
        try {
           return Optional.ofNullable(dynamoDBMapper.load(CustomerBenefitData.class, code))
                    .map(CustomerBenefitDataConverter::toEntity);
        } catch (Exception e) {
            log.error("fail find customer {}, details: {}", code, e.getMessage());
            return Optional.empty();
        }
    }

}
