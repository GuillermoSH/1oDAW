DROP TABLE IF EXISTS alumnos,profesores;

CREATE TABLE alumnos (
documento CHAR(8),
nombre VARCHAR(30),
nota DECIMAL(4,2),
codigoprofesor INT,
PRIMARY KEY (documento)
);

CREATE TABLE profesores(
codigo INT AUTO_INCREMENT,
nombre VARCHAR(30),
PRIMARY KEY (codigo)
);

INSERT INTO alumnos VALUES (30111111,'Ana algarbe',5.10,1);
INSERT INTO alumnos VALUES (30222222,'Bernardo Bustamante',3.20,1);
INSERT INTO alumnos VALUES (30333333,'Carolina Conte',4.50,1);
INSERT INTO alumnos VALUES (30444444,'Diana Dominguez',9.70,1);
INSERT INTO alumnos VALUES (30555555,'Fabian Funetes',8.50,2);
INSERT INTO alumnos VALUES (30666666,'Gaston Gonzalez',9.70,2);

INSERT INTO profesores VALUES (1,'María Luque');
INSERT INTO profesores VALUES (2,'Jorje Dante');

DROP IF EXISTS vista_alumnos;

CREATE VIEW vista_alumnos (
SELECT a.* ,p.nombre
FROM alumnos a, profesores p
WHERE p.codigo = a.codigoprofesor AND a.nota > 7;
);

SELECT * FROM vista_alumnos;

SELECT * FROM alumnos;

UPDATE vista_alumnos SET nota=10
WHERE documento='30555555';

SELECT * FROM alumnos;