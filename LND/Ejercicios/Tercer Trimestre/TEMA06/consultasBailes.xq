(: 1) Mostrar cada uno de los nombres de los bailes 

for $baile in doc("bailes.xml")/bailes/baile
return $baile/nombre

2) Mostrar los nombres de los bailes seguidos con el número de plazas entre paréntesis 

for $baile in doc("bailes.xml")/bailes/baile
return concat($baile/nombre," (",$baile/plazas,")")

3) Mostrar los nombres de los bailes cuyo precio sea mayor de 30

for $baile in doc("bailes.xml")/bailes/baile
where $baile/precio > 30
return $baile/nombre

4) Mostrar los nombres de los bailes cuyo precio sea mayor de 30 y la moneda "euro"

for $baile in doc("bailes.xml")/bailes/baile
where $baile/precio > 30
where $baile/precio/@moneda = 'euro'
return $baile/nombre

5) Mostrar la media de los precios de todos los bailes.

let $media:=avg(doc("bailes.xml")/bailes/baile/precio)
return $media

6) Mostrar la suma de los precios de los bailes de la sala 1 

let $media:=avg(doc("bailes.xml")/bailes/baile[sala=1]/precio)
return $media

7) Mostrar cuántas plazas en total oferta el profesor "Jesús Lozano"

let $suma:=sum(doc("bailes.xml")/bailes/baile[profesor='Jesús Lozano']/plazas)
return $suma

8) Mostrar el dinero que ganaría la profesora "Miriam Gutiérrez" si se completaran todas las plazas de sus bailes.

let $suma:=sum(doc("bailes.xml")/bailes/baile[profesor='Miriam Gutiérrez']/(plazas*precio))
return $suma

9) Mostrar el nombre del baile, su precio y el precio con un descuento del 15% para familias numerosas. Ordenar por el nombre del baile

for $baile in doc("bailes.xml")/bailes/baile
order by $baile/nombre
return
<baile>
{
  $baile/nombre,
  $baile/precio,
  <descuentoFN> 
  {
    $baile/(precio*0.85)    
  }
  </descuentoFN>
}
</baile>

10) Mostrar el dinero que ganaría la profesora "Laura" (no conocemos su apellido) si se completaran todas las plazas de su baile. *Función starts-with

let $suma:=sum(doc("bailes.xml")/bailes/baile[starts-with(profesor,'Laura')]/(precio*plazas))
return $suma

11) Mostrar los nombres y la fecha de comienzo de los bailes que comiencen el mes de enero (utiliza para buscarlo la cadena de texto "/1/").

for $baile in doc("bailes.xml")/bailes/baile[contains(comienzo,'-01-')]
return
<baile>
{
  $baile/nombre,
  $baile/comienzo
}
</baile>

12) Mostrar el dinero que ganaría el profesor "Jesus Lozano" si se completaran todas las plazas de su baile, pero mostrando el beneficio de cada baile por separado.

for $baile in doc("bailes.xml")/bailes/baile[profesor = 'Jesús Lozano']
return
<baile>
{
  $baile/nombre,
  <beneficio>
  {
    $baile/(precio*plazas)    
  }
  </beneficio>
}
</baile>

12.2) Con suma total

let $total:=sum(doc("bailes.xml")//baile[profesor='Jesús Lozano']/(precio * plazas))
return
<beneficios>
{
  for $baile in doc("bailes.xml")/bailes/baile[profesor = 'Jesús Lozano']
  return
  <baile>
  {
    $baile/nombre,
    <dinero>
    {
      $baile/(precio*plazas)    
    }
    </dinero>
  }
  </baile>
}
<total>{ $total }</total>
</beneficios>

13) Mostrar los nombres de los profesores y las salas en las que dan clase, ordenados por sala.

for $baile in doc("bailes.xml")/bailes/baile
order by $baile/sala
return
<baile>
{
  $baile/profesor,
  $baile/sala
}
</baile>

14) Mostrar los nombres de los profesores eliminando los repetidos y acompañar cada nombre con todas las salas en la que da clase, ordenados por nombre. Función distinct-value. :)

for $profesor in  distinct-values(doc("bailes.xml")/bailes/baile/profesor)
let $salas:=(doc("bailes.xml")/bailes/baile[profesor=$profesor]/sala)
order by $profesor
return
<profesor>
{
  <nombre>
  {
    $profesor
  }
  </nombre>,
  $salas
}
</profesor> 
(:
*) Paso de euros a dolares del total de las clases 

let $euros:=sum(doc("bailes.xml")//baile[precio/@moneda='euro']/(plazas*precio))
let $dolares:=sum(doc("bailes.xml")//baile[precio/@moneda='dolares']/(plazas*precio))
return concat($euros + $dolares * 0.95," €") :)








