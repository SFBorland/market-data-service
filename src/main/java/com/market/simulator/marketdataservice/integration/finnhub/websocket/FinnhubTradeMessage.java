package com.market.simulator.marketdataservice.integration.finnhub.websocket;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

// The top-level message structure
public class FinnhubTradeMessage {
    public String type;
    public List<TradeData> data;

    public static class TradeData {
        @JsonProperty("s")
        public String symbol;

        @JsonProperty("p")
        public double price;

        @JsonProperty("t")
        public long timestamp;

        @JsonProperty("v")
        public double volume;

        @JsonProperty("c")
        public List<String> conditions;
    }
}
