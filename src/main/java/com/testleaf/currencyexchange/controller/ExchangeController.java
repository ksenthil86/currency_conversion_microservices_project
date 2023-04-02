package com.testleaf.currencyexchange.controller;

import com.testleaf.currencyexchange.model.CurrencyExchange;
import com.testleaf.currencyexchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

    @Autowired
    ExchangeService exchangeService;

    @GetMapping(value="/currency-exchange/from/{from}/to/{to}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyExchange> getExchangeRate(@PathVariable String from, @PathVariable String to){
        CurrencyExchange curroutput = exchangeService.getExchangeMultiplier(from,to);
        return new ResponseEntity<>(curroutput, HttpStatus.OK);
    }
}
