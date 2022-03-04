#!/bin/bash

##################################################################
#
# NOMBRE: ej03-dia_semana.sh
#
# OBJETIVO: imprimir dia de la semana
# FECHA: 28-02-2022
# AUTOR: Guillermo y Denisse
# 
# ENTRADAS(3): dia, mes y año
# SALIDAS: string del dia de la semana
#
# VERSIONES: 1.0
#
##################################################################
 
dia=$1
mes=$2
anio=$3

if [ -z "$dia" ]
then
    read -p "El valor del dia no se ha introducido, introdúzcalo a continuación: " dia
fi
if [ -z "$mes" ]
then
    read -p "El valor del mes no se ha introducido, introdúzcalo a continuación: " mes
fi
if [ -z "$anio" ]
then
	read -p "El valor del año no se ha introducido, introdúzcalo a continuación: " anio
fi

diafech=`date -d "$anio-$mes-$dia" +"%A" 2> /dev/null`

echo "El dia de la semana de la fecha indicada ($dia/$mes/$anio) fue/será $diafech."
