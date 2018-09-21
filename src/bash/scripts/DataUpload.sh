#Borra los datos y la salida del hdfs para que no cree conflicto si ya existe
hdfs dfs -rm /datos

#Copia el archivo con los datos al hdfs
hdfs dfs -copyFromLocal ../../../../../datos/internet-use-data-2016.csv /datos/internet-use-data-2016.csv

#Muestra la salida del programa
echo Salida de la carga de datos en bruto
hdfs dfs -cat /datos/*

