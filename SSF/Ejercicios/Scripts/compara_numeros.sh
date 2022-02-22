#!/bin/bash

################################################################
#
# NOMBRE: compara_numeros.sh
# AUTOR: Guillermo Sicilia Hernández
# FECHA: 27-01-2022
#
# OBJETIVO: indicar si los numeros son iguales, y si no es asi, cuál es mayor
# ENTRADAS(2): los numeros a y b
# SALIDAS: mensaje si los dos números son iguales o cuál es mayor
#
# VERSIONES: 0.1
#
################################################################


# Comprobación de que el usuario ha introducido 2 parámetros.

if [ $# -ne 2 ]
then
	echo "ERROORR!! Se deben indicar dos números."
	echo "Sintaxis: $0 num1 num2"
	exit
fi

a=$1
b=$2

if [ $a -eq $b ]
then
	echo "Los números $a y $b son iguales."

elif [ $a -ge $b ]
then
	echo "El número $b es mayor que $a"

else
	echo "El número $a es mayor que $b"
fi
