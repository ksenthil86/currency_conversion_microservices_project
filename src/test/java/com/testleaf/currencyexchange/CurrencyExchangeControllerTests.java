package com.testleaf.currencyexchange;

import com.testleaf.currencyexchange.controller.ExchangeController;
import com.testleaf.currencyexchange.model.CurrencyExchange;
import com.testleaf.currencyexchange.service.ExchangeService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(ExchangeController.class)
@ExtendWith(MockitoExtension.class)
public class CurrencyExchangeControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ExchangeService exchangeService;

    @Test
    @SneakyThrows
    public void getExchangeRateControllerTests(){
        CurrencyExchange currency = CurrencyExchange.builder().id(1).from("AUD").to("INR").conversion_multiple(50.5).build();

        when(exchangeService.getExchangeMultiplier(anyString(),anyString())).thenReturn(currency);

        mockMvc.perform(MockMvcRequestBuilders.get("/currency-exchange/from/AUD/to/INR")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("currency_from").value("AUD")) //why not currency_from
                .andExpect(MockMvcResultMatchers.jsonPath("currency_to").value("INR")) //why not currency_to
                .andExpect(MockMvcResultMatchers.jsonPath("conversion_multiple").value(50.5))
                .andDo(print());
    }


}
