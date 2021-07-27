istioctl install --set profile=demo -y

kubectl label namespace default istio-injection=enabled

istioctl install -f ~/istio-1.10.3/samples/addons/kiali.yaml -y
