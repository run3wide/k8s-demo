#!/bin/sh

build_docker_image() {
  cd ../"$SERVICE_NAME" || exit
  ./gradlew bootBuildImage
  cd ..
}

load_docker_image_into_kubernetes_cluster() {
    kind load docker-image docker.io/run3wide/"$SERVICE_NAME":latest docker.io/run3wide/"$SERVICE_NAME":latest --name dev-cluster
}

deploy_service() {
  kubectl replace --force -f "$SERVICE_NAME"/infrastructure/resources.yml
  kubectl replace --force -f "$SERVICE_NAME"/infrastructure/virtual_service.yml
}

test_app_endpoint() {
  INGRESS_HOST=$(kubectl get po -l istio=ingressgateway -n istio-system -o jsonpath='{.items[0].status.hostIP}')
  INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}')

  APP_URL=$INGRESS_HOST:$INGRESS_PORT
  echo "$APP_URL"

  sleep 10
  curl -HHost:user-api.run3wide.com "$APP_URL"/actuator/health
  echo
}

SERVICE_NAME=$1
CURRENT_DIRECTORY=$(pwd)
cd "$CURRENT_DIRECTORY" || exit 1

if [ -z "$1" ]
  then
    echo "Service name was not supplied. Please enter a valid service name."
    exit 1
fi

build_docker_image
load_docker_image_into_kubernetes_cluster
deploy_service
test_app_endpoint
