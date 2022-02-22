#!/bin/bash

##################################################################
#
# NOMBRE: ej04-calcula_segundos.sh
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
 
dias=$1
horas=$2
minutos=$3
segundos=$4
if [ -z "$dias" ]
then
        echo "El valor de los dias no se ha introducido, introdúzcalo a continuación:"
        read dias
fi
if [ -z "$horas" ]
then
        echo "El valor de las horas no se ha introducido, introdúzcalo a continuación"
        read horas
fi
if [ -z "$minutos" ]
then
        echo "El valor de los minutos no se ha introducido, introdúzcalo a continuación:"
        read minutos
fi
if [ -z "$segundos" ]
then
        echo "El valor de los segundos no se ha introducido, introdúzcalo a continuación"
        read segundos
fi
if [ -z "$dias" -o -z "$horas" -o -z "$minutos" -o -z "$segundos" ]
#Una alternativa a la condición de este if sería: $# -ne 4
then
        echo "Error, no se introdujo alguno de los valores"
        exit 1
fi

#Factores de conversión
# 1 dia = 24 horas = 1440 minutos = 86400 segundos
# 1 hora = 60 minutos = 3600 segundos
# 1 minuto = 60 segundos
echo "$dias días, $horas horas, $minutos minutos y $segundos segundos son: $(( dias * 86400 + horas * 3600 + minutos * 60 + segundos ))"
