#!/bin/bash

################################################################
#
# NOMBRE: ej11-calculadora.sh
# AUTOR: Guillermo y Denisse
# FECHA: 28-02-2022
#
# OBJETIVO: realizar calculos con argumentos pasados por teclado
# ENTRADAS(2): dos numeros
# SALIDAS: resultados de las operaciones
#
# VERSIONES: 1.0
#
################################################################

val1=$1
val2=$2
textRes="El resultado de"
opciones=(Suma Resta Multiplicación División Media Cuadrado Salir)

# Cambiamos el texto de la pregunta para obtener la opción."
PS3="Elija una operación: "

# El comando select mostrará el menu automaticamente y
# obtendra la opcion indicada por el usuario.
echo "=============================== MENU ================================"
for i in {0,6,1}
do
    select opcion in ${opciones[$@]}
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

		    Media)
                suma=$(( val1 + val2 ))			
                media=$(echo "scale=2; $suma/$#" | bc)
			    echo -e "$textRes la media entre $val1 y $val2 es $media"
			    ;;

            Cuadrado)
			    cuadrado1=$(( val1 * val1 ))
			    cuadrado2=$(( val2 * val2 ))
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
done
