#!/bin/bash

##################################################################
#
# NOMBRE: ej07-compara.sh
#
# OBJETIVO: comparar dos numeros pasados por teclado
# FECHA: 28-02-2022
# AUTOR: Guillermo y Denisse
# 
# ENTRADAS(2): numero1 y numero2
# SALIDAS: comparacion de los numeros
#
# VERSIONES: 1.0
#
##################################################################
 
val1=$1
val2=$2

if [ -z "$val1" ]
then
	read -p "El valor del primer parámetro no se ha introducido, introdúzcalo a continuación: " val1
fi

if [ -z "$val2" ]
then
	read -p "El valor del segundo parámetro no se ha introducido, introdúzcalo a continuación: " val2
fi

if [ "$val1" -eq "$val2" ]
then
	echo "Los números son iguales $val1 = $val2"
elif [ "$val1" -ge "$val2" ]
then
	echo "El número $val1 es mayor que $val2"
else
	echo "El número $val2 es mayor que $val1"
fi
