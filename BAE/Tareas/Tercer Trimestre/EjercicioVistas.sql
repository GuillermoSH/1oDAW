DROP TABLE IF EXISTS empleados, secciones;
/*
1.-
*/
CREATE TABLE secciones (
codigo INT AUTO_INCREMENT,
nombre VARCHAR(30),
sueldo DECIMAL(5,2),
PRIMARY KEY (codigo)
);

CREATE TABLE empleados (
legajo INT AUTO_INCREMENT,
documento CHAR(8),
sexo CHAR(1),
apellido VARCHAR(40),
nombre VARCHAR(30),
domicilio VARCHAR(30),
seccion INT NOT NULL,
cantidadhijos INT,
estadocivil CHAR(10),
fechaingreso DATE,
PRIMARY KEY (legajo)
);
/*
2.-
*/
INSERT INTO secciones VALUES (1,'Administracion',300.00);
INSERT INTO secciones VALUES (2,'Contaduria',400.00);
INSERT INTO secciones VALUES (3,'Sistemas',500.00);

INSERT INTO empleados VALUES (1,22222222,'f','Lopez','Ana','Colon 123',1,2,'casado','1990-10-10');
INSERT INTO empleados VALUES (2,23333333,'m','Lopez','Luis','Sucre 235',1,0,'soltero','1990-02-10');
INSERT INTO empleados VALUES (3,24444444,'m','García','Marcos','Sarmiento 1234',2,3,'divorciado','1998-07-12');
INSERT INTO empleados VALUES (4,25555555,'m','Lopez','Pablo','Bulnes 321',2,3,'casado','1998-10-09');
INSERT INTO empleados VALUES (5,26666666,'f','Lopez','Laura','Peru 1254',3,3,'casado','2000-05-09');
/*
3.-
*/
DROP VIEW IF EXISTS vista_empleados;
/*
4.-
*/
CREATE VIEW vista_empleados AS
    SELECT CONCAT(e.apellido,', ',e.nombre) AS nombre,
        e.sexo,
        s.nombre AS seccion,
        e.fechaingreso
    FROM empleados e, secciones s
    WHERE s.codigo=e.seccion;
/*
5.-
*/
SELECT * FROM vista_empleados;
/*
6.-
*/
SELECT CONCAT(apellido,', ',nombre),documento,fechaingreso AS 'Nombre Empleado'
FROM empleados
WHERE seccion=1;
/*
7.-
*/
DROP VIEW IF EXISTS vista_empleados_ingreso;
/*
8.-
*/
CREATE VIEW vista_empleados_ingreso(fechaingreso,cantidad) AS
    SELECT EXTRACT(YEAR FROM fechaingreso) AS fechaingreso,
        COUNT(*) AS cantidad
    FROM empleados
    GROUP BY fechaingreso;
/*
9.-
*/
SELECT * FROM vista_empleados_ingreso;
