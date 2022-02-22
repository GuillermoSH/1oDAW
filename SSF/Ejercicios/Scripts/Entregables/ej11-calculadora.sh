#!/bin/bash

################################################################
#
# NOMBRE: ej11-calculadora.sh
# AUTOR: Guillermo Sicilia Hernández
# FECHA: 1-02-2022
#
# OBJETIVO: pequeña calculadora
# ENTRADAS: dos números
# SALIDAS: resultados de la operacion
#
# VERSIONES: 0.1
#
################################################################

val1=$1
val2=$2
textRes="El resultado de"

# Cambiamos el texto de la pregunta para obtener la opción."
PS3="Elija una operación: "

# El comando select mostrará el menu automaticamente y
# obtendra la opcion indicada por el usuario.
echo "=================== MENU ===================="
select opcion in Suma Resta Multiplicación División Media Salir
do
	echo ""
	case "$opcion" in
		Suma)
			echo -e "$textRes $val1 + $val2 es $(( val1 + val2 ))"
			;;

		Resta)
			if [[ $val1 -le $val2 ]]
			then
				echo -e "$textRes $val2 - $val1 es $(( val2 - val1 ))"
			else
				echo -e "$textRes $val1 - $val2 es $(( val1 - val2 ))"
			fi
			;;

		Multiplicación)
			echo -e "$textRes $val1 * $val2 es $(( val1 * val2 ))"
			;;

		División)
			if [[ $val1 -le $val2 ]]
			then
                                echo -e "$textRes $val2 / $val1 es $(( val2 / val1 ))"
                        else
                                echo -e "$textRes $val1 / $val2 es $(( val1 / val2 ))"
                        fi
			;;

		Media) # Error sintaxico no detectado
			media=$(echo "scale=2; $suma/$*" | bc)
			echo -e "$textRes la media entre $val1 y $val2 es $media"
			;;

		Salir)
			echo -e "Un placer."
			break
			;;

		*)
			echo -e "\nError!! Opción inválida: $REPLY"
			;;

	esac
done
