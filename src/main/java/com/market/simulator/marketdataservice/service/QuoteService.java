package com.market.simulator.marketdataservice.service;

import com.market.simulator.marketdataservice.model.dto.QuoteDto;

public interface QuoteService {

  QuoteDto getQuote(String symbol);
}
