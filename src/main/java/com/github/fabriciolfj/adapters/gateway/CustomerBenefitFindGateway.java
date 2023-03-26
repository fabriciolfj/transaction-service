package com.github.fabriciolfj.adapters.gateway;

import com.github.fabriciolfj.entities.values.Customer;

import java.util.Optional;

public interface CustomerBenefitFindGateway {

    Optional<Customer> process(final String code);
}
