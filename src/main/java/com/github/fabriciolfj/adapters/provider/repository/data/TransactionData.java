package com.github.fabriciolfj.adapters.provider.repository.data;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.github.fabriciolfj.entities.values.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "transaction")
public class TransactionData  {

    private String code;
    private String status;
    private String payment;
    private BigDecimal value;
    private String details;
    private String dateRegistry;
    private String customer;

    @DynamoDBHashKey(attributeName = "code")
    public String getCode() {
        return code;
    }

    @DynamoDBRangeKey(attributeName = "status")
    public String getStatus() {
        return status;
    }

    @DynamoDBIndexHashKey(attributeName = "payment", globalSecondaryIndexName = "datastatus-index")
    public String getPayment() {
        return payment;
    }

    @DynamoDBAttribute(attributeName = "value")
    public BigDecimal getValue() {
        return value;
    }

    @DynamoDBAttribute(attributeName = "details")
    public String getDetails() {
        return details;
    }

    @DynamoDBIndexRangeKey(attributeName = "date_registry", globalSecondaryIndexName = "datastatus-index")
    public String getDateRegistry() {
        return dateRegistry;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDateRegistry(String dateRegistry) {
        this.dateRegistry = dateRegistry;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "TransactionData{" +
                "code='" + code + '\'' +
                ", status='" + status + '\'' +
                ", payment='" + payment + '\'' +
                ", value=" + value +
                ", details='" + details + '\'' +
                ", dateRegistry='" + dateRegistry + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }
}
