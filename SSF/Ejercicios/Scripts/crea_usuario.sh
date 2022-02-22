#!/bin/bash

#########################################
#
# NOMBRE: crea_usuario.sh
# OBJETIVO: crear un usuario
# AUTOR: Guillermo Sicilia Hernández
# FECHA: 2022-01-21
# ENTRADAS: información usuario
# SALIDAS: usuario creado
#
# VERSIONES: 0.1
#
#########################################

nombre=$1
apellidos=$2
usuario=$3

echo "Hola, $nombre"
echo "Vamos a crear el usuario: $usuario"
echo "Tus datos son: $nombre $apellidos"
echo "Tu ID en nuestro sistema es: $RANDOM"
