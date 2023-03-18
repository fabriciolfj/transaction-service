package com.github.fabriciolfj.adapters.provider.repository.data;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApplicationScoped
@DynamoDBTable(tableName = "customer")
public class CustomerBenefitData {

    private String code;
    private Integer score;
    private BigDecimal cashBack;

    @DynamoDBHashKey(attributeName = "code")
    public String getCode() {
        return code;
    }

    public Integer getScore() {
        return score;
    }

    public BigDecimal getCashBack() {
        return cashBack;
    }
}
