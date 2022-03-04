#!/bin/bash

##################################################################
#
# NOMBRE: ej04-calcula_segundos.sh
#
# OBJETIVO: devolver el total de segundos del tiempo indicado
# FECHA: 28-02-2022
# AUTOR: Guillermo y Denisse
# 
# ENTRADAS(4): dias, horas, minutos y segundos
# SALIDAS: la suma de segundos
#
# VERSIONES: 1.0
#
##################################################################
 
dias=$1
horas=$2
minutos=$3
segundos=$4
if [ -z "$dias" ]
then
    read -p "El valor de los dias no se ha introducido, introdúzcalo a continuación: " dias
fi
if [ -z "$horas" ]
then
    read -p "El valor de las horas no se ha introducido, introdúzcalo a continuación: " horas
fi
if [ -z "$minutos" ]
then
    read -p "El valor de los minutos no se ha introducido, introdúzcalo a continuación: " minutos
fi
if [ -z "$segundos" ]
then
    read -p "El valor de los segundos no se ha introducido, introdúzcalo a continuación: " segundos
fi

if [ $# -ne 4 ]
then
	echo "Error404, no se han encontrado todos los parametros."
	exit 1
fi

#Factores de conversión
# 1 dia = 24 horas = 1440 minutos = 86400 segundos
# 1 hora = 60 minutos = 3600 segundos
# 1 minuto = 60 segundos
echo "$dias días, $horas horas, $minutos minutos y $segundos segundos son: $(( dias * 86400 + horas * 3600 + minutos * 60 + segundos ))"
