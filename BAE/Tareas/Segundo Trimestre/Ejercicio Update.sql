/*
1-Elimine la tabla clientes y provincias, si existen:
*/
DROP TABLE IF EXISTS clientes,provincias;
/*
2-Créalas con la siguientes estructuras:
*/
CREATE TABLE clientes (
codigo INT UNSIGNED,
nombre VARCHAR(30) NOT NULL,
domicilio VARCHAR(30),
ciudad VARCHAR(20),
codigoprovincia TINYINT UNSIGNED,
telefono VARCHAR(11),
PRIMARY KEY(codigo)
);

CREATE TABLE provincias (
codigo TINYINT UNSIGNED,
nombre VARCHAR(20),
PRIMARY KEY(codigo)
);
/*
3-Ingrese algunos registros para ambas tablas:
*/
INSERT INTO clientes VALUES (1,'Lopez Marcos','Colon 111','Cordoba',1,NULL);
INSERT INTO clientes VALUES (2,'Perez Ana','San Martin 222','Cruz del Eje',1,'4578585');
INSERT INTO clientes VALUES (3,'Garcia Juan','Rivadavia 333','Villa Maria',1,'4578445');
INSERT INTO clientes VALUES (4,'Perez Luis','Sarmineto 444','Rosario',2,NULL);
INSERT INTO clientes VALUES (5,'Pereyra Lucas','San Martin 555','Cruz del Eje',1,'4253685');
INSERT INTO clientes VALUES (6,'Gomez Ines','San Martin 666','Santa Fe',2,'0345252525');
INSERT INTO clientes VALUES (7,'Torres Fabiola','Alem 777','Villa del Rosario',1,'4554455');
INSERT INTO clientes VALUES (8,'Lopez Carlos','Irigoyen 888','Cruz del Eje',1,NULL);
INSERT INTO clientes VALUES (9,'Ramos Betina','San Martin 999','Cordoba',1,'4223366');
INSERT INTO clientes VALUES (10,'Lopez Lucas','San Martin 1010','Posadas',4,'0457858745');

INSERT INTO provincias VALUES (1,'Cordoba');
INSERT INTO provincias VALUES (2,'Santa Fe');
INSERT INTO provincias VALUES (3,'Corrientes');
INSERT INTO provincias VALUES (4,'Misiones');
INSERT INTO provincias VALUES (5,'Salta');
INSERT INTO provincias VALUES (6,'Buenos Aires');
INSERT INTO provincias VALUES (7,'Neuquen');
/*
5-Altere la tabla clientes para que se almacenen en ella el nombre de la provincia:
*/
ALTER TABLE clientes ADD nombreprovincia VARCHAR(20);
/*
4-La empresa quiere eliminar la tabla provincia y almacenar el nombre de la provincia de la cual
son oriundos sus clientes en la misma tabla clientes.
*/
UPDATE clientes SET nombreprovincia="Cordoba" WHERE codigoprovincia=1;
UPDATE clientes SET nombreprovincia="Santa Fe" WHERE codigoprovincia=2;
UPDATE clientes SET nombreprovincia="Corrientes" WHERE codigoprovincia=3;
UPDATE clientes SET nombreprovincia="Misiones" WHERE codigoprovincia=4;
UPDATE clientes SET nombreprovincia="Salta" WHERE codigoprovincia=5;
UPDATE clientes SET nombreprovincia="Buenos Aires" WHERE codigoprovincia=6;
UPDATE clientes SET nombreprovincia="Neuquen" WHERE codigoprovincia=7;
/*
6-Actualice el campo provincia de todos los registros de clientes, con el valor del campo nombre de
la tabla provincias mediante un join:
*/
UPDATE clientes JOIN provincias ON clientes.codigoprovincia=provincias.codigo
SET clientes.codigoprovincia=provincias.nombre;
/*
7-Elimine el campo innecesario en clientes y la tabla provincias:
*/
DROP TABLE provincias;
ALTER TABLE clientes DROP COLUMN codigoprovincia;