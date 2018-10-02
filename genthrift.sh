#!/usr/bin/env bash
rm -rf gen-javabean src/java/tpBigData/schema
#thrift -r --gen java:beans,hashcode,nocamel src/schema.thrift
thrift -r --gen java:beans,nocamel src/schema.thrift
mv gen-javabean/tpBigData/schema/ src/java/tpBigData
rm -rf gen-javabean
