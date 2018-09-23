#Borra los datos y la salida del hdfs para que no cree conflicto si ya existe
hdfs dfs -rm /internet-use-data-*

#Copia el archivo con los datos al hdfs
hdfs dfs -copyFromLocal ../../../data/internet-use-data-2016.csv /internet-use-data-2016

#Muestra la salida del programa
#echo Salida de la carga de datos en bruto
#hdfs dfs -cat /internet-use-data*
echo Verificacion del archivo cargado en el hdfs:
hdfs dfs -ls /internet-use-data-2016
