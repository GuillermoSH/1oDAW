#!/bin/bash

##################################################################
#
# NOMBRE: ej01-resta.sh
#
# OBJETIVO: pasar 2 argumentos y devolver la resta
# FECHA: 28-02-2022
# AUTOR: Guillermo y Denisse
# 
# ENTRADAS(2): 2 numeros para la operacion
# SALIDAS: resta de los dos numeros
#
# VERSION: 1.0
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

#Realizamos la resta de los parámetros introducidos
if [ "$val1" -gt "$val2" ] ; then
    echo -e "La resta de $val1 - $val2 es: $(( val1 - val2 ))."
else
    echo -e "La resta de $val2 - $val1 es: $(( val2 - val1 ))."
fi
