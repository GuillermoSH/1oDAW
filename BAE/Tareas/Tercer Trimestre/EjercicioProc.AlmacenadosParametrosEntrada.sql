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
DROP PROCEDURE IF EXISTS pa_empleados_sueldo;
/*
4.-
*/
DELIMITER //
CREATE PROCEDURE pa_empleados_sueldo(IN p_sueldo DECIMAL(6,2))
BEGIN
    SELECT nombre,apellido,sueldo
    FROM empleados
    WHERE sueldo >= p_sueldo;
END //
DELIMITER ;
/*
5.-
*/
CALL pa_empleados_sueldo(300.00);
/*
6.-
*/
CALL pa_empleados_sueldo();
/*
7.-
*/
DROP PROCEDURE IF EXISTS pa_empleados_actualizar_sueldo;
/*
8.-
*/
DELIMITER //
CREATE PROCEDURE pa_empleados_actualizar_sueldo(IN p_sueldo DECIMAL(6,2), IN n_sueldo DECIMAL(6,2))
BEGIN
    UPDATE empleados SET sueldo=p_sueldo WHERE sueldo=n_sueldo;
END //
DELIMITER ;
/*
9.-
*/
CALL pa_empleados_actualizar_sueldo(400.00,300.00);
/*
10.-
*/
CALL pa_empleados_actualizar_sueldo(400.00);