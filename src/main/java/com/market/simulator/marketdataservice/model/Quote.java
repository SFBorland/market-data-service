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
