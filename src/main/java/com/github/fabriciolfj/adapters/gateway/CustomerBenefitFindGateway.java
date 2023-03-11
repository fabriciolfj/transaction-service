package com.github.fabriciolfj.adapters.gateway;

import com.github.fabriciolfj.entities.values.CustomerBenefit;

import java.util.Optional;

public interface CustomerBenefitFindGateway {

    Optional<CustomerBenefit> process(final String code);
}
