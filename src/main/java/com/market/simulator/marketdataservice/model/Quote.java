package com.market.simulator.marketdataservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Quote {

  private String symbol;
  private BigDecimal lastPrice;
  private BigDecimal previousClose;
  private LocalDateTime asOf;
  private MarketStatus marketStatus;
}
/*
"Time Series (5min)": {
    "2026-01-02 19:55:00": {
      "1. open": "291.3500",
      "2. high": "291.3500",
      "3. low": "291.3400",
      "4. close": "291.3500",
      "5. volume": "57"
    },
    "2026-01-02 19:50:00": {
      "1. open": "291.0734",
      "2. high": "291.0734",
      "3. low": "291.0734",
      "4. close": "291.0734",
      "5. volume": "1"
    },
 */
