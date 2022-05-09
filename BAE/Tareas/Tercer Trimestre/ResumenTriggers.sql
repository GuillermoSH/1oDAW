-- EJEMPLO 1
/*
1.- Creación de la tabla producto con su insert
*/
DROP TABLE IF EXISTS productos;

CREATE TABLE productos(
codigo VARCHAR(12),
nombre VARCHAR(30),
porgana INT(2),
costo INT,
valorVenta INT,
cantidad INT,
PRIMARY KEY(codigo)
);

INSERT INTO productos VALUES('1','arroz 1 kilo',15,1800,0,45);

SELECT * FROM productos;
/*
2.- Creamos el trigger para que cada vez que se inserte un produco en la tabla
productos, se calcule el valor de la venta.
*/
DROP TRIGGER IF EXISTS calValorVenta;

DELIMITER //
CREATE TRIGGER calValorVenta
BEFORE INSERT
ON productos
FOR EACH ROW
BEGIN
    SET new.valorVenta = new.costo + new.costo * new.porgana/100;
END //
DELIMITER ;
/*
3.- Quitamos los valores añadidos a la tabla para hacer la comprobacion de que
el disparador de activa en la accion requerida
*/
DELETE FROM productos;
INSERT INTO productos VALUES('1','arroz 1 kilo',15,1800,0,45);

SELECT * FROM productos; -- Veremos que se ha calculado correctamente el valor

-- EJEMPLO 2
/*
1.- Creacion del trigger para que cada vez que se actualice un valor de la tabla
productos, se calcule el valor de la venta
*/
DROP TRIGGER IF EXISTS actValorVenta;

DELIMITER //
CREATE TRIGGER actValorVenta
BEFORE UPDATE
ON productos
FOR EACH ROW
BEGIN
    SET new.valorVenta = new.costo + new.costo * new.porgana/100;
END //
DELIMITER ;
/*
2.- Hacemos un update para disparar el trigger y comprobar que ha hecho el calculo
*/
UPDATE productos SET costo = 5000 WHERE codigo = '1';

SELECT * FROM productos;