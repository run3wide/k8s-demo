##K8s demo app

To run
These steps are for Mac

1. Enable kubernetes in DockerDesktop
1. ```cd script/```
1. Install istio (assumes `istioctl` can be found on PATH)
   - ```$ ./setup.sh```
1. Deploy resources 
   - ```$ ./${order-api or user-api}/infrastructure/deploy.sh```
1. Start kiali
   - ```dashboards.sh```
1. Take note of ingress port
   - ```kubectl get svc```
   - Look for the port for service k8s-demo
1. Services are reachable at ```http://localhost/some-path```
   - Note you will need to pass the host header matching the service
   - ex ```curl -v -HHost:order-api.run3wide.com http://localhost/rest/orders```
