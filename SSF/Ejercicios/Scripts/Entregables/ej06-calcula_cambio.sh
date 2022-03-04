#!/bin/bash

##################################################################
#
# NOMBRE: ej06-calcula_cambio.sh
#
# OBJETIVO: dar el cambio en billetes y monedas de un pago
# FECHA: 28-02-2022
# AUTOR: Guillermo y Denisse
# 
# ENTRADAS(2): precio del articulo y dinero entregado
# SALIDAS: cambio en billetes y monedas
#
# VERSIONES: 1.0
#
##################################################################
precio=$1
dinero=$2
devolucion=$(( precio - dinero ))
cambio=(500 200 100 50 20 10 5 2 1)

if [ -z "$precio" ]
then
	read -p "Introduce el precio del articulo: " precio
fi

if [ -z "$dinero" ]
then
    read -p "Introduce el dinero entregado: " dinero
fi

if [ $# -ne 2 ]
then
	echo "Error404, no se han encontrado todos los parametros."
	exit 1
fi

i=0
while [ "$devolucion" -gt 0 ]
do
    j=0
    if [ "$devolucion" -ge "${cambio[$i]}" ]; then
        devolucion=$(( $devolucion - ${cambio[$i]} ))        
        (( j++ ))
    elif [ "$devolucion" -lt "${cambio[$i]}" ]; then
        (( i++ ))
    fi
    if [ "$j" -ne 0 ]; then
        if [ "${cambio[$i]}" -eq 2 ] || [ "${cambio[$i]}" -eq 1 ]; then
            echo "$j monedas de ${cambio[$i]}."
        else
            echo "$j billetes de ${cambio[$i]}."
        fi
    fi
done

