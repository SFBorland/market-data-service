package com.market.simulator.marketdataservice.domain;

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
//GET https://finnhub.io/api/v1/quote?symbol=AAPL&token=
[
  {
  "c": 261.74,
  "h": 263.31,
  "l": 260.68,
  "o": 261.07,
  "pc": 259.45,
  "t": 1582641000
},
{
  "c": "Current price",
  "d": "Change",
  "dp": "Percent change",
  "h": "High price of the day",
  "l": "Low price of the day",
  "o": "Open price of the day",
  "pc": "Previous close price"
  }
]
 */
