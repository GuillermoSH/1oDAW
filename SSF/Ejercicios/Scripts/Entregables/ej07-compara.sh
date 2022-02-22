#!/bin/bash

##################################################################
#
# NOMBRE: ej07-compara.sh
#
# OBJETIVO:
# FECHA:08-02-2022
# AUTOR: Guillermo Sicilia Hernández
# 
# ENTRADAS:
# SALIDAS:
#
# VERSIONES: 0.1
#
##################################################################
 
val1=$1
val2=$2
if [ -z "$val1" ]
then
	echo "El valor del primer parámetro no se ha introducido, introdúzcalo a continuación:"
	read val1
fi
if [ -z "$val2" ]
then
	echo "El valor del segundo parámetro no se ha introducido, introdúzcalo a continuación:"
	read val2
fi
if [ -z "$val1" -o -z "$val2" ]
then
	echo "Error, no se ha introducido alguno de los valores necesarios"
	exit 1
fi
if [ "$val1" -eq "$val2" ]
then
	echo "Los números son iguales $val1=$val2"
elif [ "$val1" -ge "$val2" ]
then
	echo "El número $val1 es mayor que $val2"
else
	echo "El número $val2 es mayor que $val1"
fi
