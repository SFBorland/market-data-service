package com.market.simulator.marketdataservice.model.dto;

import com.market.simulator.marketdataservice.model.MarketStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuoteDto {
  private String symbol;
  private BigDecimal lastPrice;
  private BigDecimal previousClose;
  private LocalDateTime asOf;
  private MarketStatus marketStatus;
}
