package com.testleaf.currencyexchange;

import com.testleaf.currencyexchange.controller.ExchangeController;
import com.testleaf.currencyexchange.model.CurrencyExchange;
import com.testleaf.currencyexchange.service.ExchangeService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes = CurrencyexchangeApplication.class)
public class BaseClass {

    @Autowired
    ExchangeController exchangeController;

    @MockBean
    ExchangeService exchangeService;

    @BeforeEach
    public void setup(){

        List<CurrencyExchange> currencies = Arrays.asList(
                CurrencyExchange.builder().id(1004).from("AUD").to("INR").conversion_multiple(50.5).build()
        );

        RestAssuredMockMvc.standaloneSetup(exchangeController);

        Mockito.when(exchangeService.getExchangeMultiplier(anyString(),anyString())).thenReturn(currencies.get(0));

    }
}
