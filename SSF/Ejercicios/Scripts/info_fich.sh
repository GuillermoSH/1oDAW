#!/bin/bash

################################################################
#
# NOMBRE: info_fich.sh
# AUTOR: Guillermo Sicilia Hernández
# FECHA: 28-01-2022
#
# OBJETIVO: ver la información de los ficheros introducidos
# ENTRADAS: argumento con un fichero
# SALIDAS: información del fichero
#
# VERSIONES: 0.1
#
################################################################

args=$1

# Comprobar si existe
if [[ -e "$args" ]]
then
	echo "El argumento existe."
else
	echo "El argumento no existe."
	exit 1
fi

# Vamos a comprobar que no es nulo
if [[ -n "$args" ]]
then
	echo "El archivo $args no es nulo."
else
	echo "El archivo $args es nulo."
fi

# Vamos a comprobar que tipo de archivo es
if [[ -f "$args" ]]
then
	echo "$args es un fichero"
elif [[ -d "args" ]]
then
	echo "$args es un directorio"
elif [[ -c "args" ]]
then
	echo "$args es un fichero de caracteres especiales."
else
	echo "$args es un fichero especial"
fi

# Vamos a mostrar los permisos
if [[ -r "$args" ]]
then
	echo "  - Permisos de lectura: Sí."
else
	echo "  - Permisos de lectura: No."
fi

if [[ -w "$args" ]]
then
	echo "  - Permisos de escritura: Sí."
else
	echo "  - Permisos de escritura: No."
fi

if [[ -x "$args" ]]
then
	echo "  - Permisos de ejecución: Sí."
else
	echo "  - Permisos de ejecución: No."
fi

# Comprobar si está vacío o no
if [[ -z "$args" ]]
then
	echo "Está vacío"
else
	echo "No está vacío"
fi

