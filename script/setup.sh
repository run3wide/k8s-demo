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

start_dashboards() {
  x-terminal-emulator -e istioctl dashboard kiali
  x-terminal-emulator -e istioctl dashboard grafana
}

deploy_gateway() {
  CURRENT_DIRECTORY=$(pwd)
  cd "$CURRENT_DIRECTORY" || exit 1
  kubectl apply -f ./../infrastructure/gateway.yml
}

deploy_gateway
install_istio
mark_pods_for_istio_injection
install_istio_addons
start_dashboards