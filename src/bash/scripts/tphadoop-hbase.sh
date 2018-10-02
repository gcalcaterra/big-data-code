#!/usr/bin/env bash
#Inicia servicios: hadoop, hbase
cd /usr/local/hadoop/sbin
./start-all.sh
cd /usr/local/hbase/bin
./start-hbase.sh
#Construye el proyecto (genera el .jar)
./build_jar_hadoop.sh
#Serializa los objetos del scheme
./genthrift.sh
#Carga archivos en el hdfs
cd src/bash/scripts
./DataUpload.sh
#Ejecuta el programa
cd ..
cd ..
cd ..
cd target
hadoop jar tp-primer-parcial-1.0.0-SNAPSHOT-jar-with-dependencies.jar /home/{DATA_HOME}
