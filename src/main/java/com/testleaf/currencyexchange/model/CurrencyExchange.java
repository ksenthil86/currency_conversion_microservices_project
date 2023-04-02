package com.testleaf.currencyexchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "currency_exchange")
public class CurrencyExchange {

    @Id
    private Integer id;
    @Column(name="currency_from")
    private String from;
    @Column(name="currency_to")
    private String to;
    private Double conversion_multiple;


}
