/*
1.-
*/
DROP PROCEDURE IF EXISTS bloquePLSQL1;

DELIMITER //
CREATE PROCEDURE bloquePLSQL1(
    IN fecha DATE,
    IN numero1 INT,
    IN numero2 INT,
    OUT anioPa INT,
    OUT anioF INT,
    OUT suma INT
)
BEGIN
    SELECT f_anioFecha(fecha) AS anioF;
    CALL pa_calculoAnioFecha(fecha,@res1);
    CALL pa_suma(numero1,numero2,@res2);

    SET anioPa = @res1;
    SET suma = @res2;
END //
DELIMITER ;

CALL bloquePLSQL1("2022-02-21",3,2,@anioPa,@anioF,@suma);
/*
2.-
*/
DROP FUNCTION IF EXISTS f_calculoAniosEntreFechas(
    fecha1 DATE,
    fecha2 DATE
)
RETURNS INT DETERMINISTIC
BEGIN
    DECLARE anio1 INT;
    DECLARE anio2 INT;
    DECLARE contador INT;

    SET anio1 = YEAR(fecha1);
    SET anio2 = YEAR(fecha2);

    WHILE anio1 <= anio2 DO
        SET anio1 = anio1 + 1;
        SET contador = contador + 1;
    END WHILE;

    RETURN (contador);
END //
DELIMITER ;
/*
3.-
*/
DROP FUNCTION IF EXISTS f_calculoTrienios(
    fecha1 DATE,
    fecha2 DATE
)
RETURNS DECIMAL(8,2) DETERMINISTIC
BEGIN
    DECLARE trienios DECIMAL(8,2);

    SET trienios = f_calculoAniosEntreFechas(fecha1,fecha2) / 3;

    RETURN (trienios);
END //
DELIMITER ;