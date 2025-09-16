#!/usr/bin/env bash

if [ $(docker ps |grep multibuilder|wc -l) -eq 1 ];
then
  docker buildx rm -f multibuilder;
fi