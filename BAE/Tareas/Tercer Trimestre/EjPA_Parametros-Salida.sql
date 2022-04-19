
DROP TABLE IF EXISTS empleados;
/*
1.-
*/
CREATE TABLE empleados (
documento CHAR(8),
nombre VARCHAR(20),
apellido VARCHAR(20),
sueldo DECIMAL(6,2),
cantidadhijos INT,
seccion VARCHAR(20),
PRIMARY KEY (documento)
);
/*
2.-
*/
INSERT INTO empleados VALUES (22222222,'Juan','Perez',300.00,2,'Contaduria');
INSERT INTO empleados VALUES (22333333,'Luis','Lopez',300.00,1,'Contaduria');
INSERT INTO empleados VALUES (22444444,'Marta','Perez',500.00,1,'Sistemas');
INSERT INTO empleados VALUES (22555555,'Susana','Garcia',400.00,2,'Secretaria');
INSERT INTO empleados VALUES (22666666,'Jose Maria','Morales',400.00,3,'Secretaria');
/*
3.-
*/
DROP PROCEDURE IF EXISTS pa_seccion;
/*
4.-
*/
DELIMITER //
CREATE PROCEDURE pa_seccion(IN nombre_seccion VARCHAR(20), OUT media DECIMAL(6,2), OUT mayor DECIMAL(6,2))
BEGIN
    SELECT AVG(sueldo) INTO media
    FROM empleados
    WHERE seccion = nombre_seccion;
    SELECT MAX(sueldo) INTO mayor
    FROM empleados
    WHERE seccion = nombre_seccion;
END //
DELIMITER ;
/*
5.-
*/
CALL pa_seccion ('Secretaria',@media,@mayor);

SELECT @media,@mayor;