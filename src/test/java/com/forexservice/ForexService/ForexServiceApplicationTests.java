//package com.forexservice.ForexService;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//import java.util.Collections;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.forexservice.ForexService.Dto.ExchangeRateDto;
//import com.forexservice.ForexService.Entity.ExchangeRate;
//import com.forexservice.ForexService.Exception.AdminNotFoundException;
//import com.forexservice.ForexService.Exception.ExchangeRateNotFoundException;
//import com.forexservice.ForexService.Repository.AdminRepository;
//import com.forexservice.ForexService.Repository.ExchangeRateRepository;
//import com.forexservice.ForexService.Service.ExchangeRateService;
//import com.forexservice.ForexService.Service.ExchangeRateServiceImplementation;
//
//import net.bytebuddy.agent.builder.AgentBuilder.Transformer.ForAdvice;
//
//@SpringBootTest
//class ForexServiceApplicationTests {
//
//	 @Mock
//	    private ExchangeRateRepository exchangeRateRepository;
//
//	    @Mock
//	    private AdminRepository adminRepository;
//
//	    @InjectMocks
//	    private ExchangeRateServiceImplementation exchangeRateService;
//
//	    @InjectMocks
//	    private ForexService forexService;
//
//	    @BeforeEach
//	    public void setup() {
//	        MockitoAnnotations.initMocks(this);
//	    }
//
//	    @Test
//	    public void testCurrencyConversionSuccess() {
//	        // Mocking an exchange rate between USD and EUR
//	        ExchangeRate exchangeRate = new ExchangeRate();
//	        exchangeRate.setFromCurrency("USD");
//	        exchangeRate.setToCurrency("EUR");
//	        exchangeRate.setRate(0.85);
//
//	        when(exchangeRateRepository.findByFromCurrencyAndToCurrency("USD", "EUR")).thenReturn(exchangeRate);
//
//	        double convertedAmount = forexService.convertCurrency("USD", "EUR", 100);
//
//	        // Verify that the conversion is accurate (considering a 0.85 exchange rate from USD to EUR)
//	        assertEquals(85.0, convertedAmount);
//	    }
//
//	    @Test
//	    public void testAdminNotFoundException() {
//	        // Mocking behavior for Admin not found
//	        when(adminRepository.findById(anyInt())).thenReturn(Optional.empty());
//
//	        ExchangeRateDto exchangeRateDto = new ExchangeRateDto();
//	        exchangeRateDto.setAdminId(1); // Admin ID that doesn't exist
//
//	        // Verify that an AdminNotFoundException is thrown when admin is not found
//	        assertThrows(AdminNotFoundException.class, () -> exchangeRateService.saveExchangeRate(exchangeRateDto));
//	    }
//
//	    @Test
//	    public void testExchangeRateNotFoundException() {
//	        // Mocking behavior for ExchangeRate not found
//	        when(exchangeRateRepository.findByFromCurrencyAndToCurrency(anyString(), anyString())).thenReturn(null);
//
//	        // Verify that an ExchangeRateNotFoundException is thrown when the exchange rate is not found
//	        assertThrows(ExchangeRateNotFoundException.class, () -> ForAdvice.convertCurrency("USD", "EUR", 100));
//	    }
//
//	    @Test
//	    public void testGetRatesByDate() {
//	        // Mocking behavior for getting rates by date
//	        LocalDate date = LocalDate.now();
//	        when(exchangeRateRepository.findByDate(date)).thenReturn(Collections.singletonList(new ExchangeRate()));
//
//	        // Call the service method to get rates by date and verify the result
//	        List<ExchangeRate> exchangeRates = exchangeRateService.getRatesByDate(date.toString());
//	        assertFalse(exchangeRates.isEmpty());
//	    }
//
//
//}
