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


textRes="El resultado de"

# Si no se pasa argumentos:
if [ -z "$val1" ]
then
	read -p "Introduzca el argumento 1: " val1
	read -p "Introduzca el argumento 2: " val2
else
	val1=$1
	val2=$2
fi


# Cambiamos el texto de la pregunta para obtener la opción.
PS3="Elija una operación: "

# El comando select mostrará el menu automaticamente y
# obtendra la opcion indicada por el usuario.
echo "=================== MENU ===================="
select opcion in Suma Resta Multiplicación División Media Cuadrado Salir
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

		Media) # Error sintaxico no detectado PREGUNTAR PROFE
			media=$(echo "scale=2; $suma/$*" | bc)
			echo -e "$textRes la media entre $val1 y $val2 es $media"
			;;

		Cuadrado)
			cuadrado1=$val1*$val1
			cuadrado2=$val2*$val2
			echo -e "El cuadrado de $val1 es $cuadrado1"
			echo "El cuadrado de $val2 es $cuadrado2"
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
