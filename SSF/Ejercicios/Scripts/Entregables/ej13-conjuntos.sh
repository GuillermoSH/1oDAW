#!/bin/bash

################################################################
#
# NOMBRE: ej13-conjuntos.sh
# AUTOR: Guillermo y Denisse
# FECHA: 28-02-2022
#
# OBJETIVO: trabajar con bucles y arrays
# ENTRADAS(2): argumentos y valores pedidos a usuario
# SALIDAS: los conjuntos de cada apartado
#
# VERSIONES: 1.0
#
################################################################

# ---------------- Conjunto A -----------------
# Array para almacenar parámetros indefinidos
# Para lograr el orden inverso, lo que tengo que hacer es
# insertar los nuevos elementos por el principio
declare -a conjuntoA

for val in "$@"
do
	conjuntoA=("$val" ${conjuntoA[@]})
done

echo "Conjunto A = ${conjuntoA[@]}"


# ---------------- Conjunto B -----------------
declare -a conjuntoB

val1=1
echo ""
for (( ; ; ))
do
	read -p "Indique un nuevo número: " val1
    
    if [ "$val1" -eq 0 ];then
        break
    fi

	conjuntoB=(${conjuntoB[@]} "$val1")
done
echo ""
echo "Conjunto B = ${conjuntoB[@]}"


# ---------------- Conjunto C -----------------
# Vamos a obtener el número de elementos quiere el usuario

echo ""
read -p "Indique cuántos elementos debe tener el conjunto (por debajo de 1): " num_elem

if [ -z $num_elem ];then
    num_elem=30
fi

declare -a conjuntoC

for i in `seq 1 1 $num_elem`
do
	mitad=$(( ${#conjuntoC[@]} / 2 ))
	conjuntoC=( ${conjuntoC[@]::$mitad} $i ${conjuntoC[@]:$mitad} )
done
echo ""
echo "Conjunto C = ${conjuntoC[@]}"


# -------------- MIN MAX MEDIA ---------------
# Calculo de num min, max y media de cada conjunto

i=0
minA=${conjuntoA[0]}
maxA=${conjuntoA[0]}
sumaA=0
while [ -n "${conjuntoA[$i]}" ]
do
    if [ "${conjuntoA[$i]}" -lt "$minA" ];then
        minA=${conjuntoA[$i]}
    fi
    if [ "${conjuntoA[$i]}" -gt "$maxA" ];then   
        maxA=${conjuntoA[$i]}
    fi
    
    sumaA=$(( $sumaA + ${conjuntoA[$i]} ))

    (( i++ ))
done

echo ""
echo "---------------- Conjunto A -----------------"
echo "  · El mínimo es: $minA"
echo "  · El máximo es: $maxA"
echo "  · La media es: $(echo "scale=2; $sumaA/($i)" | bc)"
echo ""

i=0
minB=${conjuntoB[0]}
maxB=${conjuntoB[0]}
sumaB=0
while [ -n "${conjuntoB[$i]}" ]
do
    if [ "${conjuntoB[$i]}" -lt "$minB" ];then
        minB=${conjuntoB[$i]}
    fi
    if [ "${conjuntoB[$i]}" -gt "$maxB" ];then   
        maxB=${conjuntoB[$i]}
    fi
    
    sumaB=$(( $sumaB + ${conjuntoB[$i]} ))

    (( i++ ))
done

echo "---------------- Conjunto B -----------------"
echo "  · El mínimo es: $minB"
echo "  · El máximo es: $maxB"
echo "  · La media es: $(echo "scale=2; $sumaB/($i)" | bc)"
echo ""

i=0
minC=${conjuntoC[0]}
maxC=${conjuntoC[0]}
sumaC=0
while [ -n "${conjuntoC[$i]}" ]
do
    if [ "${conjuntoC[$i]}" -lt "$minC" ];then
        minC=${conjuntoC[$i]}
    fi
    if [ "${conjuntoC[$i]}" -gt "$maxC" ];then   
        maxC=${conjuntoC[$i]}
    fi
    
    sumaC=$(( $sumaC + ${conjuntoC[$i]} ))

    (( i++ ))
done

echo "---------------- Conjunto C -----------------"
echo "  · El mínimo es: $minC"
echo "  · El máximo es: $maxC"
echo "  · La media es: $(echo "scale=2; $sumaC/($i)" | bc)"
echo ""


# -------------- SUPER CONJUNTO ---------------

superConjunto=( ${conjuntoA[@]} ${conjuntoB[@]} ${conjuntoC[@]} )

i=0
minSuper=${superConjunto[0]}
maxSuper=${superConjunto[0]}
sumaSuper=0
while [ -n "${superConjunto[$i]}" ]
do
    if [ "${superConjunto[$i]}" -lt "$minSuper" ];then
        minSuper=${superConjunto[$i]}
    fi
    if [ "${superConjunto[$i]}" -gt "$maxSuper" ];then   
        maxSuper=${superConjunto[$i]}
    fi
    
    sumaSuper=$(( $sumaSuper + ${superConjunto[$i]} ))

    (( i++ ))
done

echo "-------------- Super Conjunto ---------------"
echo "  · El mínimo es: $minSuper"
echo "  · El máximo es: $maxSuper"
echo "  · La media es: $(echo "scale=2; $sumaSuper/($i)" | bc)"




