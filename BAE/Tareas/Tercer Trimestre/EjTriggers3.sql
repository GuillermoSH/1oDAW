/*
7) Modificar el Trigger del ejercicio 4, utilizando control de errores, 
si la operación es correcta, se insertará en la tabla de controltrigger
la hora y campo insertado y que ha sido correcto, en caso contrario,
incorrecto.
*/
DROP TABLE IF EXISTS controltrigger;

CREATE TABLE controltrigger (
hora DATETIME,
campoInsertado INT,
estado VARCHAR(30)
);

DROP TRIGGER IF EXISTS tr_control_insercion_emp;

DELIMITER //
CREATE TRIGGER tr_control_insercion_emp
BEFORE INSERT
ON Emp
FOR EACH ROW
BEGIN
    DECLARE EXIT HANLDER FOR SQLSTATE '23000' SET @error = 'incorrecto';

    IF (INSERT INTO Control_BD VALUES (Emp_No, USER(), SYSDATE(), 'INSERT')) THEN
        SET @error = 'correcto';
    END IF;
    
    INSERT INTO controltrigger VALUES (SYSDATE(), Emp_No, @error);
END //
DELIMITER ;
/*
8) Crear un trigger que guarde los datos en la tabla controltrigger cuando
se realice la baja de un empleado.
*/
DROP TRIGGER IF EXISTS tr_controltrigger_bajaEmple;

DELIMITER //
CREATE TRIGGER tr_controltrigger_bajaEmple BEFORE DELETE ON Emp
FOR EACH ROW
BEGIN 
INSERT INTO ControlTrigger VALUES(CURRENT_DATE(),old.Emp_No,old.Apellido,old.Oficio,old.Dir,old.Fecha_Alt,old.Salario,old.Comision,old.Dept_No);
END //
DELIMITER ;

DELETE FROM Emp WHERE Emp_No=8369;
SELECT * FROM ControlTrigger;
/*
9) Crear un Trigger que guarde los datos en la tabla ControlTrigger cuando
se relice una modificación en un empleado. Guardar la hora de la
actualización en un campo aparte en la tabla ControlTrigger.
(Añadir un campo).
*/
ALTER TABLE ControlTrigger ADD Hora TIME;

DROP TRIGGER IF EXISTS ControlTriggerUpdate;

DELIMITER //
CREATE TRIGGER ControlTriggerUpdate AFTER UPDATE ON Emp
FOR EACH ROW
BEGIN 
INSERT INTO ControlTrigger VALUES(CURRENT_DATE(),new.Emp_No,new.Apellido,new.Oficio,new.Dir,new.Fecha_Alt,new.Salario,new.Comision,new.Dept_No,CURRENT_TIME());
END //
DELIMITER ;

UPDATE Emp SET Apellido='Fernandez' WHERE Emp_No=8369;
SELECT * FROM ControlTrigger;