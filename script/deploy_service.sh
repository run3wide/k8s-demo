#!/bin/sh

build_docker_image() {
  cd ../"$SERVICE_NAME" || exit 1
  ./gradlew bootBuildImage
}

load_docker_image_into_kubernetes_cluster() {
    kind load docker-image run3wide/"$SERVICE_NAME":latest run3wide/"$SERVICE_NAME":latest --name dev-cluster
}

deploy_service() {
  kubectl replace --force -f "infrastructure/resources.yml"
  kubectl replace --force -f "infrastructure/virtual_service.yml"
}

test_app_endpoint() {
  INGRESS_HOST=$(kubectl get po -l istio=ingressgateway -n istio-system -o jsonpath='{.items[0].status.hostIP}')
  INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}')

  APP_URL=$INGRESS_HOST:$INGRESS_PORT
  echo "Kubernetes Ingress: $APP_URL"

  sleep 10
  curl -HHost:user-api.run3wide.com "$APP_URL"/actuator/health
  echo
}

set e
SERVICE_NAME=$1
CURRENT_DIRECTORY=$PWD

if [ -z "$SERVICE_NAME" ]; then
  echo "SERVICE_NAME not set"
    exit 1
fi

build_docker_image
load_docker_image_into_kubernetes_cluster
deploy_service
test_app_endpoint
cd "$CURRENT_DIRECTORY" || exit