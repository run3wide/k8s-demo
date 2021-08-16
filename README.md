## K8s demo app

This script will set up Kind kubernetes on a Linux machine.

1. Create kubernetes cluster
   1. ```kind create cluster --name dev-cluster```
2. ```cd script/```
   1. Note: You will need to cd into the script directory. This should probably be cleaned up in a future release.
3. Setup istio ingress gateway (assumes `istioctl` can be found on PATH)
   - ```$ ./setup.sh```
4. Deploy resources 
   1. The deployment script takes one argument; the name of the module you wish to deploy.
      - ```$ .deploy.sh user-api```
      - The script will build, tag and load the docker image into the kubernetes cluster.
5. Services are reachable at ```http://localhost/some-path```
   - Note you will need to pass the host header matching the service
   - ex ```curl -v -HHost:order-api.run3wide.com http://localhost/rest/orders```
   

## Removing the cluster

1. ```kind delete cluster --name dev-cluster```
