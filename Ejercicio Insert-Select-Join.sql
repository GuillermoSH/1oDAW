/*
1-Elimine las 3 talas, si existen:
*/
DROP TABLE IF EXISTS socios,deportes,inscritos;
/*
2-Cree las tablas:
*/
CREATE TABLE socios(
documento CHAR(8),
nombre VARCHAR(30),
domicilio VARCHAR(30),
PRIMARY KEY (documento)
);

CREATE TABLE deportes (
codigo TINYINT UNSIGNED AUTO_INCREMENT,
nombre VARCHAR(15),
profesor VARCHAR(30),
PRIMARY KEY (codigo)
);

CREATE TABLE inscritos (
documento CHAR(8),
codigodeporte TINYINT,
ao YEAR,
cuota CHAR(1),
PRIMARY KEY (documento,codigodeporte,ao)
);

ALTER TABLE inscritos
ADD CONSTRAINT FK_deporInscritos
FOREIGN KEY (codigodeporte) REFERENCES deportes (codigo);

ALTER TABLE inscritos
ADD CONSTRAINT FK_socioInscritos
FOREIGN KEY (documento) REFERENCES socios (documento);
/*
3-Ingrese los siguientes registros para las tablas socios, deportes e inscritos:
*/
INSERT INTO socios VALUES (22333444,'Juan Perez','Colon 123');
INSERT INTO socios VALUES (23333444,'Ana Lopez','Caseros 984');
INSERT INTO socios VALUES (24333444,'Marcelo Morales','Sucre 356');
INSERT INTO socios VALUES (25333444,'Susana Juarez','Sarmiento 723');

INSERT INTO deportes VALUES (1,'tenis','Tadeo Torres');
INSERT INTO deportes VALUES (2,'natacion','Natalia Nores');
INSERT INTO deportes VALUES (3,'basquet','Bautista Pereyra');
INSERT INTO deportes VALUES (4,'paddle','Bautista Pereyra');

INSERT INTO inscritos VALUES (22333444,1,2015,'s');
INSERT INTO inscritos VALUES (22333444,1,2016,'n');
INSERT INTO inscritos VALUES (22333444,2,2015,'s');
INSERT INTO inscritos VALUES (23333444,1,2015,'s');
INSERT INTO inscritos VALUES (23333444,1,2016,'s');
INSERT INTO inscritos VALUES (23333444,2,2016,'s');
INSERT INTO inscritos VALUES (24333444,1,2016,'s');
INSERT INTO inscritos VALUES (24333444,3,2016,'n');
/*
4-Se desea saber la cantidad de alumnos inscritos en cada deporte cada año, sin considerar los
deportes para los cuales no hay inscritos:
*/
SELECT d.nombre,COUNT(i.documento) 
FROM deportes AS d 
LEFT JOIN inscritos AS i 
ON i.codigodeporte=d.codigo
GROUP BY d.nombre;
/*
5-El club quiere almacenar esa información en una tabla llamada inscritospordeporteporaño.
Elimine la tabla, si existe.
*/
DROP TABLE IF EXISTS inscritospordeporteporaño;

CREATE TABLE inscritospordeporteporaño (
SELECT d.nombre AS deporte,COUNT(i.documento) AS total
FROM deportes AS d 
LEFT JOIN inscritos AS i 
ON i.codigodeporte=d.codigo
GROUP BY d.nombre
);
/*
6-Cree la tabla con la siguiente estructura:
*/
DROP TABLE IF EXISTS inscritospordeporteporaño;

CREATE TABLE inscritospordeporteporaño (
deporte VARCHAR(15),
ao YEAR,
cantidad TINYINT UNSIGNED
);
/*
7-
*/
INSERT INTO inscritospordeporteporaño
SELECT d.nombre AS deporte,ao,COUNT(i.documento) AS total
FROM deportes AS d 
LEFT JOIN inscritos AS i 
ON i.codigodeporte=d.codigo
GROUP BY d.nombre;
/*
8-Muestre el nombre del socio, el nombre del deporte y el año de inscripción de todas las inscripciones
con cuota impaga:
*/
SELECT socios.nombre,deportes.nombre,inscritos.ao
FROM socios JOIN inscritos ON inscritos.documento=socios.documento 
JOIN deportes ON deportes.codigo=inscritos.codigodeporte
WHERE inscritos.cuota='n';
/*
9-Elimine la tabla sociosdeudores si existe:
*/
DROP TABLE IF EXISTS sociosdeudores;
/*
10-Cree la tabla:
*/
CREATE TABLE sociosdeudores (
socio VARCHAR(30),
deporte VARCHAR(15),
ao YEAR
);
/*
11-Intente ingresar en la tabla anteriormente creada los registros resultado de la consulta del punto 8,
colocando los cmapos socio y deporte en la lista de campos a cargar:
*/
INSERT INTO sociosdeudores
SELECT socios.nombre,deportes.nombre
FROM socios JOIN inscritos ON inscritos.documento=socios.documento 
JOIN deportes ON deportes.codigo=inscritos.codigodeporte
WHERE inscritos.cuota='n';
/*
12-Ingrese en la tabla anteriormente creada los registros resultado de la consulta del punto 8,
correctamente:
*/
INSERT INTO sociosdeudores
SELECT socios.nombre,deportes.nombre,inscritos.ao
FROM socios JOIN inscritos ON inscritos.documento=socios.documento 
JOIN deportes ON deportes.codigo=inscritos.codigodeporte
WHERE inscritos.cuota='n';
/*
13-Vea los registros de sociosdeudores:
*/
SELECT * FROM sociosdeudores;
/*
14-Agrupe por nombre del profesor y deporte y cuente la cantidad de alumnos por profesor y deporte,
considerando los deportes para los que no haya inscritos:
*/
SELECT DISTINCT d.profesor,d.nombre,COUNT(i.documento)
FROM deportes d,inscritos i
WHERE i.codigodeporte=d.codigo
GROUP BY d.nombre,d.profesor;
/*
15-Elimine la tabla alumnosporprofesor
*/
DROP TABLE IF EXISTS alumnosporprofesor;
/*
16-Cree la tabla alumnosporprofesor
*/
CREATE TABLE alumnosporprofesor (
profesor VARCHAR(30),
deporte VARCHAR(15),
cantidad TINYINT UNSIGNED
);
/*
17-Ingrese en la tabla creada en el punto anterior con el resultado de la consulta del punto 14:
*/
INSERT INTO alumnosporprofesor
SELECT DISTINCT d.profesor AS profesor,d.nombre AS deporte,COUNT(i.documento) AS CANTIDAD
FROM deportes d,inscritos i
WHERE i.codigodeporte=d.codigo
GROUP BY d.nombre,d.profesor;
/*
18-Muestre todos los registros de la nueva tabla
*/
SELECT * FROM alumnosporprofesor;