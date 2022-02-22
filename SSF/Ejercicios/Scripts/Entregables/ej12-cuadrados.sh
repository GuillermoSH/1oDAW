#!/bin/bash

################################################################
#
# NOMBRE: ej12-cuadrados.sh
# AUTOR: Guillermo Sicilia Hernández
# FECHA: 10-02-2022
#
# OBJETIVO: Imprimir números pares y sus cuadrados
# ENTRADAS(2): dos parámetros
# SALIDAS: pares y cuadrados de los numeros pares
#
# VERSIONES: 0.1
#
################################################################

salto=1

# Si no se pasa argumentos:
if [ -z "$val1" ]
then
	read -p "INtroduzca el argumento 1: " val1
	read -p "Introduzca el argumento 2: " val2
else
	val1=$1
	val2=$2
fi

# Comprobación de que el argumento 1 es mayor al 2o:
if [[ $val1 -le $val2 ]]
then
	for i in `$val1 $salto $val2`
	do
		if [ "$(( i % 2 ))" -eq "0" ]]
		then
			echo "El número $i es par y su cuadrado es: $(( i*i ))."
		fi
	done
else
	for i in `$val2 $salto $val1`
        do
        	if [ "$(( i % 2 ))" -eq "0" ]]
        	then
                	echo "El número $i es par y su cuadrado es: $(( i*i ))."
        	fi
        done
fi

