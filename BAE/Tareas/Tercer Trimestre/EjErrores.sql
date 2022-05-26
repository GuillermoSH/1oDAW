/*
 Crea una base de datos llamada test que contenga una tabla llamada alumno. La
 tabla debe tener cuatro columnas:
 
 id: entero sin signo (clave primaria).
 nombre: cadena de 50 caracteres.
 apellido1: cadena de 50 caracteres.
 apellido2: cadena de 50 caracteres.
 
 Una vez creada la base de datos y la tabla deberá crear un procedimiento llamado
 insertar_alumno con las siguientes características. El procedimiento recibe cuatro
 parámetros de entrada (id, nombre, apellido1, apellido2) y los insertará en la
 tabla alumno. El procedimiento devolverá como salida un parámetro llamado error
 que tendrá un valor igual a 0 si la operación se ha podido realizar con éxito y
 un valor igual a 1 en caso contrario.
 
 Deberá manejar los errores que puedan ocurrir cuando se intenta insertar una fila que contiene una clave primaria repetida.
 */
/*
 Paso 1: Creacion de la tabla
 */
DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;
/*
 Paso 2: Creacion de la tabla
 */
DROP TABLE IF EXISTS alumno;
CREATE TABLE alumno (
    id INT UNSIGNED,
    nombre VARCHAR(50),
    apellido1 VARCHAR(50),
    apellido2 VARCHAR(50),
    PRIMARY KEY(id)
);
/*
 Paso 3: Creacion del procedimiento
 */
DROP PROCEDURE IF EXISTS insertar_alumno;
DELIMITER // 
CREATE PROCEDURE insertar_alumno (
    id INT,
    nombre VARCHAR(50),
    apellido1 VARCHAR(50),
    apellido2 VARCHAR(50)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLSTATE '23000' SET @error = 1;
    INSERT INTO alumno VALUE (id, nombre, apellido1, apellido2);
    SET @error = 0;
END //
DELIMITER ;
/*
 Paso 4: comprobar si la salida es correcta
 */
CALL insertar_alumno(1, 'maria', 'perez', 'almeida');
SELECT @error;
CALL insertar_alumno(1, 'juan', 'garcia', 'perez');
SELECT @error;