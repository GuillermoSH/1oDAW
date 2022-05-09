/*
1.-
*/
DROP PROCEDURE IF EXISTS pa_borrarEmpleados;

DELIMITER //
CREATE PROCEDURE pa_borrarEmpleados(
    IN num_empleado INT
)
BEGIN
    DELETE FROM empleados WHERE codigo = num_empleado;
END //
DELIMITER ;
/*
2.-
*/
DROP PROCEDURE IF EXISTS pa_modificarLocalidad;

DELIMITER //
CREATE PROCEDURE pa_modificarLocalidad(
    IN codigo_depart INT,
    IN loc VARCHAR(20)
)
BEGIN
    UPDATE departamentos SET localidad = loc WHERE codigo = codigo_depart;
END //
DELIMITER ;