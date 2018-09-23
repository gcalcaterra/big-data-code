#!/usr/bin/env bash
#Borra los datos y la salida del hdfs para que no cree conflicto si ya existe
hdfs dfs -rm -R /internet

#Crea el directorio /internet en el HDFS
hdfs dfs -mkdir -p /internet

#Copia los archivos del directorio local /data al directorio /internet del HDFS
hdfs dfs -copyFromLocal ../../../data/* /internet

#Muestra la salida del programa
#echo Salida de la carga de datos en bruto
#hdfs dfs -cat /internet-use-data*
echo Verificacion del archivo cargado en el hdfs:
hdfs dfs -ls /internet