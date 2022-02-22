#!/bin/bash

##################################################################
#
# NOMBRE: ej05-calcula_tiempos.sh
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
 
seg=$1
if [ -z "$arg" ]
then
	echo "Introduce una cantidad de segundos para convertirlos:"
	read seg
fi
if [ -z "$arg" ]
then
	echo "Error no se ha introducido el valor necesario para operar"
	exit 1
fi
#equivalencias:
#86400segundos 1 día
#3600 segundos 1 hora
#60 segundos 1 minuto
dia=$(( $seg/86400 ))
h=$((( $seg%86400)/3600 ))
min=$(((($seg%86400)%3600)/60))
segres=$(((($seg%86400)%3600)%60))

echo "En $seg segundos hay $dia días, $h horas, $min minutos y $segres segundos"
