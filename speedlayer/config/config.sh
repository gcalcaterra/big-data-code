#!/bin/sh

#Cambiar por la carpeta donde esta wildfly
#WILDFLY_HOME=/ruta/completa/a/wildfly

WILDFLY_HOME=/home/rafael/wildfly-12.0.0.Final

$WILDFLY_HOME/bin/jboss-cli.sh  --file=./postgres.cli
$WILDFLY_HOME/bin/jboss-cli.sh  --file=./datasources.cli
