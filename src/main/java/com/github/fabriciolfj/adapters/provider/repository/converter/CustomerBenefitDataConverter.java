package com.github.fabriciolfj.adapters.provider.repository.converter;

import com.github.fabriciolfj.adapters.provider.repository.data.CustomerBenefitData;
import com.github.fabriciolfj.entities.values.CustomerBenefit;

public class CustomerBenefitDataConverter {

    private CustomerBenefitDataConverter() {

    }

    public static CustomerBenefitData toData(final CustomerBenefit customerBenefit) {
        return CustomerBenefitData
                .builder()
                .score(customerBenefit.getScore())
                .code(customerBenefit.getCode())
                .cashBack(customerBenefit.getCashBack())
                .build();
    }

    public static CustomerBenefit toEntity(final CustomerBenefitData data) {
        return CustomerBenefit
                .builder()
                .code(data.getCode())
                .score(data.getScore())
                .cashBack(data.getCashBack())
                .build();
    }
}
