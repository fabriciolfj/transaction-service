package com.github.fabriciolfj.adapters.provider.repository.data;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class CustomerBenefitData extends PanacheEntity {

    private String code;
    private Integer score;
    @Column(name = "cash_back", nullable = false, unique = true)
    private BigDecimal cashBack;
    @Version
    private Integer version;
}
