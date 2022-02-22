#!/bin/bash

################################################################
#
# NOMBRE: calcula_segundos.sh
# AUTOR: Guillermo Sicilia Hernández
# FECHA: 26-01-2022
#
# OBJETIVO: calcular los segundos mediante la hora pasada por el usuario
# ENTRADAS(3): dias, horas, minutos, segundos
# SALIDAS: segundos
#
# VERSIONES: 0.1
#
################################################################

dias=$1
horas=$2
minutos=$3
segundos=$4

# Equivalencias
# 1 dia=24*60*60=86400
# 1 hora=60*60=3600

resultado=$((dias*86400 + horas*3600 + minutos*60 + segundos))

echo "$dias día(s), $horas hora(s), $minutos minuto(s) y $segundos segundo(s) son tal que $resultado segundo(s)."
