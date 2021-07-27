##K8s demo app

In platform directory
- ```$ platform/setup.sh```
- ```$ platform/deploy.sh```

Check which port is the ingress port.
- ```echo $(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}')```

The app will serve up index from `http://localhost`