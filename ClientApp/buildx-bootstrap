#!/usr/bin/env bash

if [ $(docker ps | grep multibuilder | wc -l) -ne 1 ]; then
  export DOCKER_BUILDKIT=1
  docker buildx create --name multibuilder --use
  docker buildx inspect --bootstrap
fi