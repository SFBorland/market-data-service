package com.market.simulator.marketdataservice.domain;

import java.math.BigDecimal;
import java.time.Instant;
import lombok.Builder;
import lombok.Data;

//This may be used for non-position screens so come back to it
@Data
@Builder
public class Stock {

  private String symbol;
  private String name;
  private String exchange;
  private String currency;
  private BigDecimal price;
  private Long volume;
  private Instant lastUpdated;
  private BigDecimal marketCap;
  private BigDecimal peRatio;
}
