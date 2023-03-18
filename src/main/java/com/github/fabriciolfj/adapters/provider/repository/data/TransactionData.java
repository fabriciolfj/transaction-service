package com.github.fabriciolfj.adapters.provider.repository.data;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@DynamoDBTable(tableName = "transaction")
public class TransactionData  {

    private String code;
    private String status;
    private String payment;
    private BigDecimal value;
    private String details;
    private String dateRegistry;

    @DynamoDBHashKey(attributeName = "code")
    public String getCode() {
        return code;
    }

    @DynamoDBIndexHashKey(attributeName = "status", globalSecondaryIndexName = "datastatus-index")
    public String getStatus() {
        return status;
    }

    @DynamoDBRangeKey(attributeName = "payment")
    public String getPayment() {
        return payment;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getDetails() {
        return details;
    }

    @DynamoDBIndexRangeKey(attributeName = "date_registry", globalSecondaryIndexName = "datastatus-index")
    public String getDateRegistry() {
        return dateRegistry;
    }
}
