#!/bin/bash

################################################################
#
# NOMBRE: ej_funciones.sh
# AUTOR: Guillermo Sicilia Hernández
# FECHA: 08-02-2022
#
# OBJETIVO: Iniciacion a funciones
# ENTRADAS: 
# SALIDAS: 
#
# VERSIONES: 0.1
#
################################################################

# DECLARAR FUNCIONES
minimo(){
	local min=$1
	local val

	for val in "$@"
	do
		if [ "$val" -lt "$min" ]
		then
			min=$val
		fi
	done
	echo "$min"
}

function maximo(){
	echo "Hola, soy la función máximo y el primer argumento es $1"
}

function media(){
	echo "Hola, soy la función media y el primer argumento es $1"
}


# LLAMAR O INVOCAR A LAS FUNCIONES:
valores=(234 643 234 654)
echo "El primer argumento del script es $1"

echo -n "El minimo es: "
minimo 2 54 76 3 4 6

edad=(2 54 76 3 4 6)
val_min=$(minimo ${edad[@]})
val_min=`minimo ${edad[@]}`
# ...
echo "El minimo es $val_min y el doble del minimo es $(( 2 * val_min ))"


maximo "$@"
media "${valores[@]}"
