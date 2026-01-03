# User Service

### Tech
- Spring Data JDBC
- WebSocket
- MapStruct

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

* Create a new user with a POST request:


### TODO

