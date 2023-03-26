package com.github.fabriciolfj.adapters.provider.repository.converter;

import com.github.fabriciolfj.adapters.provider.repository.data.CustomerBenefitData;
import com.github.fabriciolfj.entities.values.Customer;

public class CustomerBenefitDataConverter {

    private CustomerBenefitDataConverter() {

    }

    public static CustomerBenefitData toData(final Customer customer) {
        return CustomerBenefitData
                .builder()
                .score(customer.getScore())
                .code(customer.getCode())
                .cashBack(customer.getCashBack())
                .build();
    }

    public static Customer toEntity(final CustomerBenefitData data) {
        return Customer
                .builder()
                .code(data.getCode())
                .score(data.getScore())
                .cashBack(data.getCashBack())
                .build();
    }
}
