package com.github.fabriciolfj.adapters.provider.repository.data;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transactions")
public class TransactionData extends PanacheEntity {

    @Column(name ="code", unique = true, nullable = false)
    private String code;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "payment", nullable = false)
    private String payment;
    @Column(name = "value", nullable = false)
    private BigDecimal value;
    @Column(name = "describe_transaction", nullable = false)
    private String details;
    @Column(name = "date_registration", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateRegistry;
}
