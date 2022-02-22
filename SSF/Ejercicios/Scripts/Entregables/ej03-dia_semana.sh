#!/bin/bash

##################################################################
#
# NOMBRE: ej03-dia_semana.sh
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
 
dia=$1
mes=$2
anio=$3
if [ -z "$dia" ]
then
        echo "El valor del dia no se ha introducido, introdúzcalo a continuación:"
        read dia
fi
if [ -z "$mes" ]
then
        echo "El valor del mes no se ha introducido, introdúzcalo a continuación"
        read mes
fi
if [ -z "$anio" ]
then
	echo "El valor del año no se ha introducido, introdúzcalo a continuación:"
	read anio
fi
if [ -z "$dia" -o -z "$mes" -o -z "$anio" ]
#Una alternativa a la condición de este if sería: $# -ne 3
then
        echo "Error, no se introdujo alguno de los valores"
        exit 1
fi

diafech=`date -d "$anio-$mes-$dia" +"%A" 2> /dev/null`

echo "El dia de la semana de la fecha indicada ($dia/$mes/$anio) fue/será $diafech"
