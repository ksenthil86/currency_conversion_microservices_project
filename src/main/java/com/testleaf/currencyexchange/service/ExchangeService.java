package com.testleaf.currencyexchange.service;

import com.testleaf.currencyexchange.model.CurrencyExchange;
import com.testleaf.currencyexchange.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeService {

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchange getExchangeMultiplier(String from,String to){
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from,to);
        if (currencyExchange == null) throw new CurrencyNotFoundException("Currency value for from - "+from+"and to - "+to+" not found");
        return currencyExchange;
    }
}
