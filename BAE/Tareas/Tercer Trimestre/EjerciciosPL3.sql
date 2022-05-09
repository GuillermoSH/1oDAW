/*
1.-
*/
DROP PROCEDURE IF EXISTS pa_suma;

DELIMITER //
CREATE PROCEDURE pa_suma(
    IN numero1 INT DEFAULT 0, 
    IN numero2 INT DEFAULT 0,
    IN numero3 INT DEFAULT 0,
    IN numero4 INT DEFAULT 0,
    IN numero5 INT DEFAULT 0,
    OUT resultado INT
)
BEGIN
    SET resultado=numero1+numero2+numero3+numero4+numero5;
END //
DELIMITER ;

CALL pa_suma(3,2,@res);
SELECT @res;
/*
2.-
*/
DROP FUNCTION IF EXISTS f_caracteres;

DELIMITER //
CREATE FUNCTION f_caracteres(
    cadena VARCHAR(30)
)
RETURNS VARCHAR(30) DETERMINISTIC
BEGIN
    DECLARE caracter CHAR;
    DECLARE cadenaNueva VARCHAR(30);
    DECLARE i INT;
    
    WHILE i < LENGTH(cadena) DO
        SET caracter = SUBSTR(cadena,i,1);

        IF (ASCII(cadena) NOT BETWEEN 65 AND 90) AND (ASCII(cadena) NOT BETWEEN 97 AND 122) THEN
            SET caracter = ' ';
        END IF;

        SET cadenaNueva = CONCAT(cadenaNueva,caracter);

        SET i = i+1;
    END WHILE;
    RETURN (cadenaNueva);
END //
DELIMITER ;
SELECT f_caracteres("HOLA0QUE0TAL?!");
/*
3.-
*/
DROP PROCEDURE IF EXISTS pa_cambio;

DELIMITER //
CREATE PROCEDURE pa_cambio(
    IN importe INT,
    OUT resultado INT
)
BEGIN
    DECLARE cambio INT;
    DECLARE resultado VARCHAR(50);
    SET resultado = "Cambio: ";
    SET cambio = importe;

    WHILE cambio > 0 DO
        IF cambio >= 5000 THEN
            SET cambio = cambio - 5000;
            SET resultado = CONCAT(resultado,"5000");
        ELSEIF cambio >= 2000 THEN
            SET cambio = cambio - 2000;
            SET resultado = CONCAT(resultado,"2000");
        ELSEIF cambio >= 1000 THEN
            SET cambio = cambio - 1000;
            SET resultado = CONCAT(resultado,"1000");
        ELSEIF cambio >= 500 THEN
            SET cambio = cambio - 500;
            SET resultado = CONCAT(resultado,"500");
        ELSEIF cambio >= 200 THEN
            SET cambio = cambio - 200;
            SET resultado = CONCAT(resultado,"200");
        ELSEIF cambio >= 100 THEN
            SET cambio = cambio - 100;
            SET resultado = CONCAT(resultado,"100");
        ELSEIF cambio >= 50 THEN
            SET cambio = cambio - 50;
            SET resultado = CONCAT(resultado,"50");
        ELSEIF cambio >= 25 THEN
            SET cambio = cambio - 25;
            SET resultado = CONCAT(resultado,"25");
        ELSEIF cambio >= 10 THEN
            SET cambio = cambio - 10;
            SET resultado = CONCAT(resultado,"10");
        ELSEIF cambio >= 5 THEN
            SET cambio = cambio - 5;
            SET resultado = CONCAT(resultado,"5");
        ELSEIF cambio >= 1 THEN
            SET cambio = cambio - 1;
            SET resultado = CONCAT(resultado,"1");
        END IF;

        SET resultado = CONCAT(resultaod,", ");
    END WHILE;
END //
DELIMITER ;

CALL pa_suma(3,2,@res);
SELECT @res;