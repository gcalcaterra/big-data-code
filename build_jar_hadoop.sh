#!/usr/bin/env bash
cd ./dfs-datastores/
mvn clean install package

cd ../batchlayer/
mvn compile assembly:single

cd ../speedlayer/
mvn clean install package
