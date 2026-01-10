# User Service

### Tech
- Spring Data JDBC
- WebSocket (maybe not - use for live ticker)
- Redis API (test) / Ehcache (dev)
- MapStruct

### Flow
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

