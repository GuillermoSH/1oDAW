#!/bin/bash

##################################################################
#
# NOMBRE: ej01-resta.sh
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
	echo "El valor del segundo parámetro no se ha introducido, introdúzcalo a continuación"
	read val2
fi
if [ -z "$val1" -o -z "$val2" ]
#Una alternativa a la condición de este if sería: $# -ne 2
then
	echo "Error, no se introdujo alguno de los valores"
	exit 1
fi
#Realizamos la resta de los parámetros introducidos
echo "La resta de $val1 - $val2 es:  $(( val1 - val2 ))"
