package com.market.simulator.marketdataservice.integration.finnhub.websocket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import tools.jackson.databind.ObjectMapper;

public class FinnhubClient extends WebSocketClient {

  private final ObjectMapper mapper = new ObjectMapper();

  public FinnhubClient(URI serverUri) {
    super(serverUri);
  }

  @Override
  public void onOpen(ServerHandshake handshakedata) {
    System.out.println("Connected to Finnhub");
    // Subscribe to symbols as soon as the connection opens
//    this.send("{\"type\":\"subscribe\",\"symbol\":\"BINANCE:BTCUSDT\"}");
    this.send("{\"type\":\"subscribe\",\"symbol\":\"AAPL\"}");
//    this.send("{\"type\":\"subscribe\",\"symbol\":\"NVDA\"}");
  }

  @Override
  public void onMessage(String message) {
    try {
      FinnhubTradeMessage tradeMsg = mapper.readValue(message, FinnhubTradeMessage.class);
System.out.println("Message: " + message);
      if ("trade".equals(tradeMsg.type) && tradeMsg.data != null) {
        for (FinnhubTradeMessage.TradeData trade : tradeMsg.data) {
//          System.out.println("Message: " + message);
//          System.out.printf("Symbol: %s | Price: %.2f | Volume: %f | TimeStamp: %s%n",
//              trade.symbol, trade.price, trade.volume, trade.timestamp);

          // Process each trade (e.g., push to Kafka, save to DB, or update cache)
        }
      }
    } catch (Exception e) {
      System.err.println("Error parsing trade JSON: " + e.getMessage());
    }
  }

  @Override
  public void onClose(int code, String reason, boolean remote) {
    System.out.println("Disconnected: " + reason);
  }

  @Override
  public void onError(Exception ex) {
    ex.printStackTrace();
  }

  public static void main(String[] args) throws Exception {
    // Replace 'YOUR_API_KEY' with your actual token from the Finnhub dashboard
    String token = "d5umo19r01qr4f89oqqgd5umo19r01qr4f89oqr0";
    FinnhubClient client = new FinnhubClient(new URI("wss://ws.finnhub.io?token=" + token));
    client.connect();
  }
}
