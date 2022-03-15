|================================== "CONSULTAS" ==================================|

a)  SELECT * FROM articulos;

b)  SELECT nombre FROM articulos;

c)  SELECT nombre,precio FROM articulos;

d)  SELECT nombre FROM articulos GROUP BY nombre;

e)  SELECT * FROM articulos WHERE clave_articulo=5;

f)  SELECT * FROM articulos WHERE nombre='Teclado';

g)  SELECT * FROM articulos WHERE nombre='Memoria RAM' OR nombre='Memoria USB';

h)  SELECT * FROM articulos WHERE nombre LIKE 'M%';

i)  SELECT * FROM articulos WHERE precio=100;

j)  SELECT * FROM articulos WHERE precio>200;

k)  SELECT * FROM articulos WHERE precio>=100 AND precio<=350;

l)  SELECT AVG(precio) FROM articulos;

m)  SELECT AVG(precio) FROM articulos WHERE clave_fabricante=2;

n)  
