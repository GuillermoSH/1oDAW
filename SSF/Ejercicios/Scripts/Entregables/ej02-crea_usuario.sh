#!/bin/bash

##################################################################
#
# NOMBRE: ej02-crea_usuario.sh
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
 
nombre=$1
apellidos=$2
usuario=$3
if [ -z "$nombre" ]
then
	echo "No se ha introducido el valor para el nombre, introdúzcalo a continuación:"
	read nombre
fi
if [ -z "$apellidos" ]
then
        echo "El valor de los apellidos no se ha introducido, introdúzcalo a continuación:"
        read apellidos
fi
if [ -z "$usuario" ]
then
        echo "El valor del usuario no se ha introducido, introdúzcalo a continuación"
        read usuario
fi
if [ -z "$nombre" -o -z "$apellidos" -o -z "$usuario" ]
#Una alternativa a la condición de este if sería: $# -ne 3
then
        echo "Error, no se introdujo alguno de los valores"
        exit 1
fi

echo "Bienvenido, $nombre"
echo "Tus datos son: $nombre $apellidos"
echo "Vamos a crear tu usuario: $3"
echo "Tu nueva ID es: $RANDOM"
