/*
1.-
*/
DROP PROCEDURE IF EXISTS pa_suma;

DELIMITER //
CREATE PROCEDURE pa_suma(
    IN numero1 INT, 
    IN numero2 INT,
    OUT resultado INT
)
BEGIN
    SET resultado=numero1+numero2;
END //
DELIMITER ;

CALL pa_suma(3,2,@res);
SELECT @res;
/*
2.-
*/
DROP PROCEDURE IF EXISTS pa_invertir;

DELIMITER //
CREATE PROCEDURE pa_invertir(
    IN cadena VARCHAR(20), 
    OUT resultado VARCHAR(20)
)
BEGIN
    SET resultado = REVERSE(cadena);
END //
DELIMITER ;
CALL pa_invertir("hola que tal",@res);
SELECT @res;
/*
3.-
*/
DROP FUNCTION IF EXISTS f_anioFecha;

DELIMITER //
CREATE FUNCTION f_anioFecha(
    fecha DATE
)
RETURNS INT DETERMINISTIC
BEGIN
    DECLARE anio INT;
    SET anio = YEAR(fecha);

    RETURN (anio);
END //
DELIMITER ;
SELECT f_anioFecha("2022-02-21");
/*
4.-
*/
DROP PROCEDURE IF EXISTS pa_calculoAnioFecha;

DELIMITER //
CREATE PROCEDURE pa_calculoAnioFecha(
    IN fecha DATE,
    OUT anio INT
)
BEGIN
    SELECT f_anioFecha(fecha) AS anio;
END //
DELIMITER ;
CALL pa_calculoAnioFecha("2022-02-21",@res);