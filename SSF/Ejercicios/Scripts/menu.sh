#!/bin/bash

################################################################
#
# NOMBRE: menu.sh
# AUTOR: Guillermo Sicilia Hernández
# FECHA: 28-01-2022
#
# OBJETIVO: Pruebas de menú
# ENTRADAS: Ninguna
# SALIDAS: Operación elegida
#
# VERSIONES: 0.1
#
################################################################

# Mostrar el menú
echo "+-----------------------------------------+"
echo "|·············    M E N Ú   ··············|"
echo "+-----------------------------------------+"
echo "| 1) Espacio libre en disco (%)           |"
echo "| 2) Espacio libre en disco (tamaño)      |"
echo "| 3) Mi nombre de usuario                 |"
echo "| 4) El nombre de la máquina              |"
echo "| 5) Indica el número de usuarios         |"
echo "| 6) Espacio usado en directorios         |"
echo "+-----------------------------------------+"
echo ""

# Capturar la opcion del usuario
read -p "Introduzca una opción: " opcion

# Switch de acciones con las opciones dadas al usuario
case "$opcion" in
 1)
 	echo ""
	porcentajeUsado=$(df -h / | tail -n 1 | tr -s " " | cut -d" " -f5 | tr -d "%")
	porcentajeLibre=$((100-$porcentajeUsado))
	echo " ~ El porcentaje de espacio usado en el disco es del $porcentajeLibre %."
	;;

 2)
	echo ""
	tamanioUsado=$(df -h / | tail -n 1 | tr -s " " | cut -d" " -f2 | tr -d "G")
	tamanioLibre=$((100-$tamanioUsado))
	echo " ~ El tamaño de espacio libre en el disco es de $tamanioLibre G."
	;;

 3)
	echo ""
	echo " ~ Mi nombre de usuario es: $(whoami)."
	;;

 4)
	echo ""
	echo " ~ El nombre de la máquina es: $(hostname)"
	;;

 5)
	echo ""
	numUsuarios=$(cd ~/ | cut -d: -f1 /etc/passwd | wc -l)
	echo " ~ El número de usuarios de este equipo es/son de $numUsuarios."
	;;

 6) # No esta cogiendo bien los datos
	echo ""
	espacioUsado=$(cd ~/ | du -h | tail -1 | cut -f1)
	echo " ~ El espacio total usado en directorios personales es de $espacioUsado."
	;;

 *)
	echo ""
	echo " !ERROR01: La opción introducida no es válida."
	;;
esac
