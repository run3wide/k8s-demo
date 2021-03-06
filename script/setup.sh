#!/bin/bash

install_istio() {
  istioctl install --set profile=demo -y
}

mark_pods_for_istio_injection() {
  kubectl label namespace default istio-injection=enabled
}

install_istio_addons() {
  ISTIOCTL_DIRECTORY=$(which istioctl)
  ISTIO_DIRECTORY="${ISTIOCTL_DIRECTORY/"/bin/istioctl"/}"
  kubectl apply -f "$ISTIO_DIRECTORY"/samples/addons/kiali.yaml
  kubectl apply -f "$ISTIO_DIRECTORY"/samples/addons/prometheus.yaml
  kubectl apply -f "$ISTIO_DIRECTORY"/samples/addons/grafana.yaml
}

deploy_gateway() {
  kubectl apply -f ./../infrastructure/gateway.yml
}

create_cluster() {
  kind create cluster --name dev-cluster
}

create_cluster
deploy_gateway
install_istio
mark_pods_for_istio_injection
install_istio_addons
