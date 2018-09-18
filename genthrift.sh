#!/usr/bin/env bash
rm -rf gen-javabean src/java/tp1Parcial/schema
#thrift -r --gen java:beans,hashcode,nocamel src/schema.thrift
thrift -r --gen java:beans,nocamel src/schema.thrift
mv gen-javabean/tp1Parcial/schema/ src/java/tp1Parcial
rm -rf gen-javabean
