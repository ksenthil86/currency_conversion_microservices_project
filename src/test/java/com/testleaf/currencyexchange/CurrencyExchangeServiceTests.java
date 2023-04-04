package com.testleaf.currencyexchange;

import com.testleaf.currencyexchange.model.CurrencyExchange;
import com.testleaf.currencyexchange.repository.CurrencyExchangeRepository;
import com.testleaf.currencyexchange.service.ExchangeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrencyExchangeServiceTests {

	@Mock
	CurrencyExchangeRepository currencyExchangeRepository;

	@InjectMocks
	ExchangeService exchangeService;

	@Test
	public void getExchangeRateTests() {

		CurrencyExchange currency = CurrencyExchange.builder().id(1).from("AUD").to("INR").conversion_multiple(50.5).build();

		when(currencyExchangeRepository.findByFromAndTo("AUD","INR")).thenReturn(currency);

		assertEquals(currency,exchangeService.getExchangeMultiplier("AUD","INR"));

	}

}
