#!/bin/bash

##################################################################
#
# NOMBRE: ej06-calcula_cambio.sh
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
precio=$1 
division=( 500 200 100 50 20 10 5 2 1)
echo "El precio del articulo es: $1 introduce una cantidad para pagar:"
read dinero
cambio=$((dinero - precio))


