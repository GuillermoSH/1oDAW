#!/bin/bash

##################################################################
#
# NOMBRE: ej05-calcula_tiempos.sh
#
# OBJETIVO: devolver cuantos dias, horas, minutos y segundos
# corresponden a los segundos indicados
# FECHA: 28-02-2022
# AUTOR: Guillermo y Denisse
# 
# ENTRADAS(1): segundos
# SALIDAS: los dias, horas, minutos y segundos que corresponden a
# los segundos introducidos
#
# VERSIONES: 1.0
#
##################################################################
 
seg=$1
if [ -z "$seg" ]
then
	read -p "Introduce una cantidad de segundos para convertirlos: " seg
fi

dia=$(( $seg/86400 ))
horas=$((( $seg%86400)/3600 ))
minutos=$(((($seg%86400)%3600)/60))
segundos=$(((($seg%86400)%3600)%60))

echo "$seg segundos son $dia día/s, $horas hora/s, $minutos minuto/s y $segundos segundos."
