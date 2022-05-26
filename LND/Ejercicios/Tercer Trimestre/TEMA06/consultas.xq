(:Ejercicio 3
let $n:=count(doc("libros.xml")/biblioteca/libros/libro) return $n
------------------------------------------------------
Ejercicio 4
<ol>
{
  for $liro in doc("libro.xml")//libro
  where $libro/editorial="O'Reilly"
  order by $libro/titulo
  return
  <li> { data($libro/titulo)} </li>  
}
</ol>
------------------------------------------------------
Ejercicio5
FLWOR
for $libro in doc("libro.xml")/biblioteca/libros/libro
where $libro/@publicacion = 2002
return
<libro>
{
  $libro/titulo,
  $libro/editorial  
}
</libro>

Con XPath: :)
for $libro in doc("libro.xml")/biblioteca/libros/libro[@publicacion=2002]
return
<libro>
{
  <titul> { data($libro/titulo) } </titul>
  <edit> { data($libro/editorial) } </edit>
}
</libro>















