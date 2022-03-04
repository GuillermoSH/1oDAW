#!/bin/bash

################################################################
#
# NOMBRE: ej09-info_ruta.sh
# AUTOR: Guillermo y Denisse
# FECHA: 28-02-2022
#
# OBJETIVO: Mostrar información de los ficheros, directorios, etc.
# ENTRADAS(1): un argumento.
# SALIDAS: Si se ha indicado un argumento o no, si el argumento
#	indicado existe o no en el disco, si existe, si es un
#	fichero, directorio, enlace simbólico o "tipo especial"
#	si tiene o no cada uno de los permisos y si está vacío
#	o no.
#
# VERSIONES: 1.0
#
################################################################

arg=$1
permisos=""

# COMPROBACIÓN DE QUE EL ARGUMENTO SE HA INDICADO.-
if [ -z "$arg" ]
then
	echo "ERROR01: Se debe indicar como mín un argumento."
	exit 1
fi

# COMPROBACIÓN DE SI EL AGUMENTO EXISTE.-
echo -e "\n======== COMPROBACIÓN EXISTENCIA ========"
if [ -e "$arg" ]
then
	echo "  El argumento $arg existe."
else
	echo "ERROR02: El argumento $arg introducido no existe."
	exit 2
fi

# COMPROBACIÓN DEL TIPO DE ARGUMENTO.-
echo -e "\n=========== COMPROBACIÓN TIPO ==========="
if [ -d "$arg" ]
then
	echo "  $arg es un directorio."
    echo ""    
    cd $arg | ls -l
elif [ -f "$arg" ]
then
	echo "  $arg es un fichero."
elif [ -L "$arg" ]
then
	echo "  $arg es un enlace simbólico."
else
	echo "  $arg es un tipo especial (difire de fichero, directorio o enlace simbólico)."
fi


# COMPROBACIÓN DE PERMISOS.-
echo -e "\n========= COMPROBACIÓN PERMISOS ========="
if [ -r "$arg" ]
then
	echo " ~ $(whoami) tiene permiso de lectura."
	permisos+="r"
else
        echo " ~ $(whoami) no tiene permiso de lectura."
	permisos+="-"
fi

if [ -w "$arg" ]
then
        echo " ~ $(whoami) tiene permiso de escritura."
	permisos+="w"
else
        echo " ~ $(whoami) no tiene permiso de escritura."
	permisos+="-"
fi

if [ -x "$arg" ]
then
        echo " ~ $(whoami) tiene permiso de ejecución."
        permisos+="x"
else
        echo " ~ $(whoami) no tiene permiso de ejecución."
        permisos+="-"
fi

echo -e "\n========== PERMISOS DE USUARIO =========="
echo "                $permisos"

# COMPROBAR SI ESTÁ VACÍO O NO
echo -e "\n======== COMPROBACIÓN VACÍO O NO ========"
if [ -s "$arg" ]
then
	echo "  $arg no está vacío."
else
	echo "  $arg está vacío."
fi
echo -e "\n"






