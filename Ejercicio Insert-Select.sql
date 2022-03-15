/*
1-Elimine las tablas, si existen:
*/
DROP TABLE IF EXISTS socios,inscritos;
/*
2-Cree las tablas socios e inscritos:
*/
CREATE TABLE socios(
numero INT UNSIGNED AUTO_INCREMENT,
documento CHAR(8) NOT NULL,
nombre VARCHAR(30) NOT NULL,
domicilio VARCHAR(30),
PRIMARY KEY (numero)
);

CREATE TABLE inscritos(
numerosocio INT UNSIGNED,
deporte VARCHAR(20),
ao YEAR NOT NULL,
cuota CHAR(1),
PRIMARY KEY (numerosocio,deporte,ao)
);

ALTER TABLE inscritos
ADD CONSTRAINT FK_inscritosSocios
FOREIGN KEY (numerosocio) REFERENCES socios (numero);
/*
3-Ingrese los siguientes registros en las tablas socios e inscritos:
*/
INSERT INTO socios VALUES (23,22333444,'Juan Perez','Colon 123');
INSERT INTO socios VALUES (56,23333444,'Ana Garcia','Sarmiento 984');
INSERT INTO socios VALUES (102,24333444,'Hector Fuentes','Sucre 293');
INSERT INTO socios VALUES (150,25333444,'Agustin Perez','Avellaneda 1234');
INSERT INTO socios VALUES (230,26333444,'Maria Perez','Urquiza 283');
INSERT INTO socios VALUES (231,29333444,'Agustin Perez','Urquiza 283');

INSERT INTO inscritos VALUES (23,'natacion',2015,'s');
INSERT INTO inscritos VALUES (23,'tenis',2015,'s');
INSERT INTO inscritos VALUES (23,'tenis',2016,'s');
INSERT INTO inscritos VALUES (102,'natacion',2016,'s');
INSERT INTO inscritos VALUES (102,'tenis',2015,'s');
/*
4-El socio con documento '23333444' quiere inscribirse en 'basquet' este año, pero no recuerda su
numero de socio. Inscriba al socio en la tabla 'inscritos' buscando en la tabla 'socios' el número de
socio a partir del numero de documento:
*/
INSERT INTO inscritos (numerosocio,deporte,ao,cuota)
SELECT numero,'basquet',2022,'s'
FROM socios
WHERE documento=23333444;
/* 
5-Intente inscribir una persona cuyo número de documento no exista en la tabla 'socios':
*/
INSERT INTO inscritos (numerosocio,deporte,ao,cuota)
SELECT numero,'tenis',2016,'s'
FROM socios
WHERE documento=NULL;
/*
6-La madre de los socios "Perez" quiere inscribir a su hijo "Agustin" en "basquet" este año, pero no
recuerda su número de socio ni su documento. Si se busca el número de socio a partir del nombre
("Agustin Perez"), la consulta retornará 2 registros, porque hay 2 socios llamados "Agustin Perez".
Obtendremos como resultado, la inscripcion a "basquet" este año, de ambos socios. Si localizamos el
número de socios a partir del domicilio ("Urquiza 283"), también obtendremos 2 inscripciones, porque
hay 2 socios con ese domicilio. Ingrese la inscripción del socio, localizando su número de socio con el
nombre y domicilio:
*/
INSERT INTO inscritos (numerosocio,deporte,ao,cuota)
SELECT numero,'basquet',2022,'s'
FROM socios
WHERE nombre LIKE 'Agustin%' AND domicilio='Urquiza 283';
/*
7-La madre de los socios "Perez" quiere inscribir a ambos hijos "natacion" este año, pero no recuerda sus
números de socio ni sus documentos. Inscriba a ambos localizando sus números de socio con el domicilio:
*/

/*
8-Vea si las inscripciones anteriores se cargaron
*/