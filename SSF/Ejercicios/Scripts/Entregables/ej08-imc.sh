#!/bin/bash

##################################################################
#
# NOMBRE: ej08-imc.sh
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
 
altura=$1
peso=$2
if [ -z "$altura" ]
then
	echo "El valor de la altura no se ha introducido, introduzcalo a continuación:"
	read altura
fi
if [ -z "$peso" ]
then
	echo "El peso no se ha introducido, introduzcalo a continuación:"
	read peso
fi
if [ $# -ne 2 ]
then
	echo "Error, no se han introducido todo los parametros"
	exit 1
fi
IMC=$(( 10000 * peso / (altura * altura) ))
echo "El valor del IMC es $IMC, es decir, "
if [ $IMC lt 16 ]
then
	echo "Delgadez severa"
elif [ $IMC lt 17 ]
then
	echo "Delgadez moderada"
elif [ $IMC lt 18.5 ]
then
	echo "Delgadez leve"
elif [ $IMC lt 25 ]
then
	echo "Normal"
elif [ $IMC lt 30 ]
then
	echo "Preobesidad"
elif [ $IMC lt 35 ]
then
	echo "obesidad leve"
elif [ $IMC lt 40 ]
then
	echo "Obesidad media"
else
	echo "Obesidad mórbida"
fi
