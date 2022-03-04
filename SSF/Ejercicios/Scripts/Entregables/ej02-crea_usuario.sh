#!/bin/bash

##################################################################
#
# NOMBRE: ej02-crea_usuario.sh
#
# OBJETIVO: imprimir los datos de usuario
# FECHA: 28-02-2022
# AUTOR: Guillermo y Denisse
# 
# ENTRADAS(3): nombre, 1er apellido, nombre de usuario
# SALIDAS: datos de usuario
#
# VERSIONES: 1.0
#
##################################################################
 
nombre=$1
apellidos=$2
usuario=$3

if [ -z "$nombre" ]
then
	read -p "Tu nombre no ha sido introducido, introdúzcalo a continuación: " nombre
fi
if [ -z "$apellidos" ]
then
    read -p "El valor de los apellidos no se ha introducido, introdúzcalo a continuación: " apellidos
fi
if [ -z "$usuario" ]
then
    read -p "El valor del usuario no se ha introducido, introdúzcalo a continuación: " usuario
fi

if [ $# -ne 3 ]
then
	echo "Error404, no se han encontrado todos los parametros."
	exit 1
fi

echo "Bienvenido, $nombre"
echo "Tus datos son: $nombre $apellidos"
echo "Vamos a crear tu usuario: $usuario"
echo "Tu nueva ID es: $RANDOM"
