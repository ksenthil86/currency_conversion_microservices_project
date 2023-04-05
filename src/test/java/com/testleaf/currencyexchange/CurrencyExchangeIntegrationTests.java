package com.testleaf.currencyexchange;

import com.testleaf.currencyexchange.model.CurrencyExchange;
import com.testleaf.currencyexchange.repository.CurrencyExchangeRepository;
import com.testleaf.currencyexchange.service.ExchangeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CurrencyExchangeIntegrationTests {

    @LocalServerPort
    int port;

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    ExchangeService exchangeService;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    @Sql(statements = "insert into currency_exchange (id,CONVERSION_MULTIPLE  , CURRENCY_FROM  , CURRENCY_TO  ) values (1005,50.5,'AUD','INR');",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "delete from currency_exchange where id=1001;",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void should_return_specific_user(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type","application/json");
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<CurrencyExchange> exchange = testRestTemplate.exchange("http://localhost:" + port + "/currency-exchange/from/{from}/to/{to}", HttpMethod.GET, entity, new ParameterizedTypeReference<CurrencyExchange>() {},"AUD","INR");
        Assertions.assertEquals(exchange.getBody(),currencyExchangeRepository.findByFromAndTo("AUD","INR"));
        Assertions.assertEquals(exchange.getBody(),exchangeService.getExchangeMultiplier("AUD","INR"));
        Assertions.assertEquals(200,exchange.getStatusCode().value());
        Assertions.assertEquals(50.5,exchange.getBody().getConversion_multiple());
    }
}
