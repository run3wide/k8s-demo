#!/bin/bash

start_dashboards() {
  x-terminal-emulator -e istioctl dashboard kiali
  x-terminal-emulator -e istioctl dashboard grafana
}

start_dashboards
