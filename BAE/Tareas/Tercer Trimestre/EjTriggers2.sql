/*
4) Crear un Trigger para controlar la inserción de empleados, cuando insertemos
un empleado se copiarán datos sobre la inserción en una tabla llamada Control_BD.
Los datos que se copiarán son el Número de empleado, El usuario que está realizando
la operación, la fecha y el tipo de operación. 
*/
CREATE TABLE Control_BD (
emp_no INT NULL,
usuario VARCHAR(20) NULL,
fecha DATETIME NULL,
operacion VARCHAR(15) NULL
);

DROP TRIGGER IF EXISTS tr_control_insercion_emp;

DELIMITER //
CREATE TRIGGER tr_control_insercion_emp
AFTER INSERT
ON Emp
FOR EACH ROW
BEGIN
    INSERT INTO Control_BD(emp_no,usuario,fecha,operacion) VALUES(new.Emp_No,USER(),CURRENT_DATE(),'Insercion');;
END //
DELIMITER ;
/*
5) Crear un Trigger que actue cuando se modifique la tabla hospital y sobre todas
las tablas con las que esté relacionadas.
*/
DROP TRIGGER IF EXISTS tr_update_hospital_cascada;

DELIMITER //
CREATE TRIGGER tr_update_hospital_cascada
AFTER UPDATE
ON Hospital
FOR EACH ROW
BEGIN
    UPDATE Plantilla SET Plantilla.Hospital_Cod = new.Hospital_Cod WHERE Plantilla.Hospital_Cod = old.Hospital_Cod;
    UPDATE Sala SET Sala.Hospital_Cod = new.Hospital_Cod WHERE Sala.Hospital_Cod = old.Hospital_Cod;
    UPDATE Doctor SET Doctor.Hospital_Cod = new.Hospital_Cod WHERE Doctor.Hospital_Cod = old.Hospital_Cod;
END //
DELIMITER ;
/*
6) Crear un Trigger en la tabla plantilla. Cuando actualicemos la tabla plantilla,
debemos comprobar que el hospital que actualizamos existe, si intentamos actualizar
el código de hospital, no podremos hacerlo si no existe relación con algún código
de hospital. Realizar el mismo Trigger para las tablas relacionadas con Hospital.
*/
DROP TRIGGER IF EXISTS tr_actualizar_plantillas;

DELIMITER //
CREATE TRIGGER tr_actualizar_plantillas
AFTER UPDATE 
ON Plantilla
FOR EACH ROW
IF Hospital.Hospital_Cod IS NOT NULL THEN
BEGIN
    UPDATE Plantilla SET Hospital_Cod=new.Hospital_Cod WHERE Plantilla.Hospital_Cod=old.Hospital_Cod;
END //
DELIMITER ;