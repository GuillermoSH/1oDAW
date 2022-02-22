#!/bin/bash

####################################################
#
# NOMBRE: mi_primer_script.sh
# OBJETIVO: hacer un pequeño script
# AUTOR: Guillermo Sicilia Hernández
# FECHA: 2022-01-20
# ENTRADAS: None
# SALIDAS: Mensajes en la pantalla
#
# VERSIONES: 0.1: Inicial
#
####################################################

nombre=${12}

echo "Hola, soy el primer script"
echo "Binevenido, $1"
echo "Vives en $2"

# echo "Param 1: $1"
# ...
# echo "Param 10: ${10}" #para parametros de 2 o más dígitos usar {}

echo "Param 1: $1"
echo "Param 2: $2"
echo "Param 3: $3"
echo "Param 4: $4"
echo "Param 5: $5"
echo "Param 6: $6"
echo "Param 7: $7"
echo "Param 8: $8"
echo "Param 9: $9"
echo "Param 10: ${10}"
echo "Param 11: ${11}"

echo "Nombre: $nombre"
echo "El script se llama: $0" # $0 es el nombre del script
echo "Has indicado $# parámetro(s)" # $# cuenta los parámetros introducidos
echo "Resultado último comando: $?" # $? salida del ultimo proceso
echo "PID: $$" # $$ indicador de proceso
echo "Se ejecutó en $SECONDS segundo(s)" # $SECONDS indica los segundos de ejecucion
echo "Estoy en la línea $LINENO" # $LINENO indica la linea
echo "Los parámetros indicados fueron: $@" # $@ muestra todos los parametros pasados como un array
echo "Los parámetros indicados fueron: $*" # $* muestra todos los parametros pasados como un único elemento concatenado
echo "Un valor aleatorio: $RANDOM" # $RANDOM devuelve un número aleatorio


# echo "Usted va a ser invadido por un virus malicioso"
# cd /home/robertodr/Escritorio
# mkdir VIRUS
# cd VIRUS
# touch virus.txt
# echo "Virus muy peligroso" > virus.txt

