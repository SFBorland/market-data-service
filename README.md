# User Service

[kaggle S&P Dataset](https://www.kaggle.com/datasets/joebeachcapital/s-and-p500-index-stocks-daily-updated?resource=download&select=sp500_data.csv)
### Tech
- Spring Data JDBC (Historical data)
- WebSocket (update UI live ticker from cache)
- gRPC (get persistent quote updates for cache)
  - eventually switch to Aeron+SBE?
- Redis API (test) / Ehcache (dev)
- MapStruct

### Flow (update quote cache)
```
Quote-Generator-Service  
  └─ generates ticks (e.g., every 100–500ms)
     └─ gRPC stream
        └─ Market-Data-Ingest
            ├─ in-memory cache (hot path)
            ├─ Redis (shared state / scale-out)
            └─ WebSocket → UI
```
### Flow (select stock)
- View stocks/price
  - Screen that shows (sym, mkt.price)
- Execute trade
  - Buy screen (sym,#shares,est.cost)
  - ![img.png](img.png)

### Docker

Build the Docker image:

```docker build -t sfborland/<TODO> .```  
```docker push sfborland/<TODO>```

### Minikube

```minikube start```  
```minikube dashboard --url```  
```kubectl port-forward -n kubernetes-dashboard svc/kubernetes-dashboard 9090:80 --address=0.0.0.0```  

### K8s commands

```kubectl apply -f k8s/deployment.yaml```  
```kubectl apply -f k8s/service.yaml```  
```kubectl get pods```  
```kubectl get services```  

### NGINX commands

### Swagger spec
* [local Swagger](http://localhost:<TODO>/swagger-ui/index.html)
* [pi5 Swagger](http://pi5.local/swagger-ui/index.html)

### H2

* [H2 URL](http://localhost:<TODO>/h2-console)
* JDBC URL (input at login screen): `jdbc:h2:mem:testdb`
* Command to print schema: `SCRIPT` then `RUN` in the H2 console text window.

### Sample CURLs
* [FinnHub](https://finnhub.io/docs/api/quote)

```json
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
```

* [FinnHub | GET Trade](https://finnhub.io/docs/api/websocket-trades)
```json
{
  "data": [
    {
      "p": 7296.89,
      "s": "BINANCE:BTCUSDT",
      "t": 1575526691134,
      "v": 0.011467
    }
  ],
  "type": "trade"
}
```

* [AlphaVantage](https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&outputsize=full&apikey=demo)
```json
{
  "Meta Data": {
    "1. Information": "Intraday (5min) open, high, low, close prices and volume",
    "2. Symbol": "IBM",
    "3. Last Refreshed": "2026-01-02 19:55:00",
    "4. Interval": "5min",
    "5. Output Size": "Full size",
    "6. Time Zone": "US/Eastern"
  },
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
    "2026-01-02 19:45:00": {
      "1. open": "291.0200",
      "2. high": "291.0200",
      "3. low": "291.0200",
      "4. close": "291.0200",
      "5. volume": "4"
    },
    "2026-01-02 19:40:00": {
      "1. open": "291.2972",
      "2. high": "291.3500",
      "3. low": "291.2972",
      "4. close": "291.3500",
      "5. volume": "141"
    }
  }
}
```


### NOTES
- First build generator
  - With the same format as the Site
- Then use Websocket for Live ticker view

### Package Structure (not markdown friendly)
com.market.simulator.marketdataservice
│
├── api                     ← Your REST boundary
│   ├── controller
│   └── dto                 ← DTOs used by your API only
│       ├── QuoteDto.java
│       └── MarketStatusDto.java
│
├── domain                  ← Pure business models
│   ├── Quote.java
│   ├── Stock.java
│   └── MarketStatus.java
│
├── service                 ← Provider-agnostic logic
│   ├── QuoteService.java
│   ├── QuoteServiceImpl.java
│   └── mapper              ← domain ↔ api dto mapping
│
├── integration             ← All external systems
│   ├── alphavantage
│   │   ├── AlphaVantageClient.java
│   │   ├── dto             ← provider-specific DTOs
│   │   └── mapper
│   │
│   ├── finnhub
│   │   ├── FinnhubClient.java
│   │   ├── dto
│   │   └── mapper
│   │
│   └── quotegenerator
│       ├── QuoteGeneratorClient.java
│       ├── QuoteGeneratorClient.proto
│       ├── dto
│       └── mapper
│
├── repository
│
└── MarketDataServiceApplication.java


