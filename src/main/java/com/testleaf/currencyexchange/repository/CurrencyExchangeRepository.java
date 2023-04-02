package com.testleaf.currencyexchange.repository;

import com.testleaf.currencyexchange.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,String> {
    CurrencyExchange findByFromAndTo(String from,String to);
}
