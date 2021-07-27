##K8s demo app

To run
These steps are for Mac

1. Enable kubernetes in DockerDesktop
1. Install istio (assumes `istioctl` can be found on PATH)
   - ```$ ./script/setup.sh```
1. Deploy resources
   - ```$ ./script/deploy.sh```
1. Take note of ingress port
   - ```kubectl get svc```
   - Look for the port for service k8s-demo
1. Start kiali
   - ```script/start-kiali.sh```
1. Navigate to `localhost:${INGRESS_PORT}`
