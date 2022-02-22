#!/bin/bash

################################################################
#
# NOMBRE: ej13-conjuntos.sh
# AUTOR: Guillermo Sicilia Hernández
# FECHA: 04-02-2022
#
# OBJETIVO: Trabajar con bucles y arrays
# ENTRADAS: argumentos, valores pedidos a usuario
# SALIDAS: 
#
# VERSIONES: 0.1
#
################################################################

# ---------------- Conjunto A -----------------
# Array para almacenar parámetros indefinidos
# Para lograr el orden inversio, lo que tengo que hacer es
# insertar los nuevos elementos por el principio
declare -a conjuntoA

for val in "$@"
do
	conjuntoA=("$val" ${conjuntoA[@]})
done
echo "ConjuntosA = ${conjuntoA[@]}"

# ---------------- Conjunto B -----------------
declare -a conjuntoB

val="1"
while [ "val" -ne 0 ]
do
	read -p "Indique un nuevo número: " val
	if [ "$val" -eq 0 ]
	then
		conjuntoB+=("$val")
	fi
done
echo "ConjuntoB = ${conjuntoB[@]}"

# ---------------- Conjunto C -----------------
# Vamos a obtener el número de elementos quiere el usuario

read -p "Indique cuántos elementos debe tener el conjunto (por debajo de 1): " num_elem

declare -a conjuntoC

for i in ` seq 1 $num_elem `
do
	mitad=$(( ${#conjuntoC[@]} / 2 ))
	conjuntoC=( ${conjuntoC[@]::$mitad} $i ${conjuntoC[@]:$mitad} )
done
echo "ConjuntoC = ${conjuntoC[@]}"
