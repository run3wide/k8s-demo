#Install istio
istioctl install --set profile=demo -y

#Mark pods for istio injection
kubectl label namespace default istio-injection=enabled

#Install istio addons
kubectl apply -f ~/istio-1.10.3/samples/addons/kiali.yaml
kubectl apply -f ~/istio-1.10.3/samples/addons/prometheus.yaml
kubectl apply -f ~/istio-1.10.3/samples/addons/grafana.yaml
