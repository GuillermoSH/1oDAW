#!/bin/bash

##################################################################
#
# NOMBRE: ej08-imc.sh
#
# OBJETIVO: calculo del indice de masa corporal
# FECHA: 28-02-2022
# AUTOR: Guillermo y Denisse
# 
# ENTRADAS(2): altura y peso
# SALIDAS: string con la respuesta dependiendo del IMC
#
# VERSIONES: 1.0
#
##################################################################
 
altura=$1
peso=$2

if [ -z "$altura" ]
then
	read -p "La altura no se ha introducido, introduzcalo a continuación: " altura
fi

if [ -z "$peso" ]
then
	read -p "El peso no se ha introducido, introduzcalo a continuación: " peso
fi

IMC=$(( 10000 * peso / (altura * altura) ))
if [ "$IMC" -lt 16 ]
then
	echo "El valor del IMC es $IMC, es decir, delgadez severa."
elif [ "$IMC" -lt 17 ]
then
	echo "El valor del IMC es $IMC, es decir, delgadez moderada."
elif [ "$IMC" -lt 19 ]
then
	echo "El valor del IMC es $IMC, es decir, delgadez leve."
elif [ "$IMC" -lt 25 ]
then
	echo "El valor del IMC es $IMC, es decir, normal."
elif [ "$IMC" -lt 30 ]
then
	echo "El valor del IMC es $IMC, es decir, preobesidad."
elif [ "$IMC" -lt 35 ]
then
	echo "El valor del IMC es $IMC, es decir, obesidad leve."
elif [ "$IMC" -lt 40 ]
then
	echo "El valor del IMC es $IMC, es decir, obesidad media."
else
	echo "El valor del IMC es $IMC, es decir, obesidad mórbida."
fi
