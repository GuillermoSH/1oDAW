#!/bin/bash

################################################################
#
# NOMBRE: dia_semana.sh
# AUTOR: Guillermo Sicilia Hernández
# FECHA: 25-01-2022
#
# OBJETIVO: devolver el día de la semana
# ENTRADAS(3): dia mes año
# SALIDAS: dia de la semana
#
# VERSIONES: 0.1
#
################################################################

dia=$1
mes=$2
anio=$3

dow=`date -d "$anio-$mes-$dia" +"%A"`

echo "El día de la semana de la fecha $dia/$mes/$anio fue: $dow"
