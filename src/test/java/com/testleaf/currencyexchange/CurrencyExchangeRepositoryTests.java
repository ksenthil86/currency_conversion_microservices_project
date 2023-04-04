package com.testleaf.currencyexchange;

import com.testleaf.currencyexchange.model.CurrencyExchange;
import com.testleaf.currencyexchange.repository.CurrencyExchangeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class CurrencyExchangeRepositoryTests {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Test
    public void saveTest(){
        CurrencyExchange currencyExchange = new CurrencyExchange();
        currencyExchange.setId(1);
        currencyExchange.setFrom("AUD");
        currencyExchange.setTo("INR");
        currencyExchange.setConversion_multiple(50.5);

        CurrencyExchange savedcurrencyExchange = currencyExchangeRepository.save(currencyExchange);
        assertNotNull(savedcurrencyExchange);
        assertEquals(1,savedcurrencyExchange.getId());
        assertEquals(savedcurrencyExchange.getFrom(),"AUD");
        assertEquals(savedcurrencyExchange.getTo(),"INR");
        assertEquals(50.5,savedcurrencyExchange.getConversion_multiple());
    }

}
