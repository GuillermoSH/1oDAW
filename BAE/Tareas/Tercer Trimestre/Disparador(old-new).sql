/*
1.- Creación de las tablas
*/
DROP TABLE IF EXISTS control,libros;

CREATE TABLE libros(
codigo INT(6),
titulo VARCHAR(40),
autor VARCHAR(30),
editorial VARCHAR(20),
precio DECIMAL(6,2)
);

CREATE TABLE control(
usuario VARCHAR(30),
fecha DATE,
codigo INT(6),
precioAnterior DECIMAL(6,2),
precioNuevo DECIMAL(6,2)
);
/*
2.- Insertar los datos dentro de la tabla libros
*/
INSERT INTO libros VALUES(100,'Uno','Richard Bach','Planeta',25);
INSERT INTO libros VALUES(103,'El aleph','Borges','Emece',28);
INSERT INTO libros VALUES(105,'Matematica estas ahi','Paenza','Nuevo siglo',12);
INSERT INTO libros VALUES(120,'Aprenda PHP','Molina Mario','Nuevo siglo',55);
INSERT INTO libros VALUES(145,'Alicia en el pais de las maravillas','Carroll','Planeta',35);
/*
3.- Creación del trigger para que cuando se actualice un campo de la tabla se cree un registro en la tabla
control en la que se guardara el usuario, la fecha actual, el codigo del libro, el precio anterior al 
cambio y el nuevo precio.
*/
DROP TRIGGER IF EXISTS tr_actualizarPrecioLibros;

DELIMITER //
CREATE TRIGGER tr_actualizarPrecioLibros
BEFORE UPDATE
ON libros
FOR EACH ROW
BEGIN
    INSERT INTO control VALUES(USER(),SYSDATE(),new.codigo,old.precio,new.precio);
END //
DELIMITER ;
/*
4.- Update de libros para ver que se dispara correctamente el trigger creado
*/
UPDATE libros SET precio=30 WHERE codigo=100;

SELECT * FROM control;
/*
5.- Updates adicionales
*/
UPDATE libros SET precio = precio+precio*0.1 WHERE editorial='Planeta';
UPDATE libros SET editorial='Sudamerica' WHERE editorial='Planeta';

SELECT * FROM control;