package com.testleaf.currencyexchange.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("currency_from")
    private String from;
    @JsonProperty("currency_to")
    @Column(name="currency_to")
    private String to;
    private Double conversion_multiple;


}
