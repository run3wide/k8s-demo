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

start_dashboard() {
  x-terminal-emulator -e istioctl dashboard kiali
}

install_istio
mark_pods_for_istio_injection
install_istio_addons
start_dashboard