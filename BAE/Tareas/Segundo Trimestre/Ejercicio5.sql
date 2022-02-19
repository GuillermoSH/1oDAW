|================================== "CREACIÓN TABLAS" =================================|

CREATE TABLE departamentos (
dpto_cod INT(5),
nombre_dpto VARCHAR(30) NOT NULL,
dpto_padre INT(5),
presupuesto NUMERIC NOT NULL,
pres_actual NUMERIC
);

ALTER TABLE departamentos
ADD CONSTRAINT Pk_departamentos
PRIMARY KEY (dpto_cod,nombre_dpto);

--------------------------------------------------------------------------------------

CREATE TABLE empleados (
DNI NUMERIC(8,0),
nombre VARCHAR(10) NOT NULL,
apellido1 VARCHAR(15) NOT NULL,
apellido2 VARCHAR(15),
direcc1 VARCHAR(25),
direcc2 VARCHAR(20),
ciudad VARCHAR(20),
provincia VARCHAR(5),
cod_postal VARCHAR(5),
sexo VARCHAR(1),
fecha_nac DATE
);

ALTER TABLE empleados
MODIFY provincia VARCHAR(20);

ALTER TABLE empleados
ADD CONSTRAINT Pk_empleados
PRIMARY KEY (DNI,nombre);

ALTER TABLE empleados
ADD CONSTRAINT CHK_empleados CHECK (sexo='H' OR sexo='M');

--------------------------------------------------------------------------------------

CREATE TABLE universidades (
univ_cod INT(5),
nombre_univ VARCHAR(25) NOT NULL,
ciudad VARCHAR(20),
municipio VARCHAR(2),
cod_postal VARCHAR(5)
);

ALTER TABLE universidades
ADD CONSTRAINT Pk_universidades
PRIMARY KEY (univ_cod,nombre_univ);

--------------------------------------------------------------------------------------

CREATE TABLE estudios (
empleado_dni NUMERIC(8,0),
universidad INT(5),
anio INT,
grado VARCHAR(3),
especialidad VARCHAR(20)
);

ALTER TABLE estudios
ADD CONSTRAINT Fk_empleEstudios
FOREIGN KEY (empleado_dni) REFERENCES empleados (DNI);

ALTER TABLE estudios
ADD CONSTRAINT Fk_univEstudios
FOREIGN KEY (universidad) REFERENCES universidades (univ_cod);

ALTER TABLE estudios
ADD CONSTRAINT Pk_estudios
PRIMARY KEY (empleado_dni,universidad,anio,grado);

--------------------------------------------------------------------------------------

CREATE TABLE historial_laboral (
empleado_dni NUMERIC(8,0),
trabajo_cod INT(5),
fecha_inicio DATE,
fecha_fin DATE,
dpto_cod INT(5),
supervisor_dni INT(8)
);

ALTER TABLE historial_laboral
ADD CONSTRAINT Fk_empleHistoLabo
FOREIGN KEY (empleado_dni) REFERENCES empleados (DNI);

ALTER TABLE historial_laboral
ADD CONSTRAINT Fk_dptoHistoLabo
FOREIGN KEY (dpto_cod) REFERENCES departamentos (dpto_cod);

ALTER TABLE historial_laboral
ADD CONSTRAINT Pk_histoLabo
PRIMARY KEY (empleado_dni,trabajo_cod,dpto_cod);

--------------------------------------------------------------------------------------

CREATE TABLE trabajos (
trabajo_cod INT(5),
nombre_trab VARCHAR(20) NOT NULL,
salario_min NUMERIC(2,2),
salario_max NUMERIC(2,2)
);

ALTER TABLE trabajos 
ADD CONSTRAINT Pk_trabajos
PRIMARY KEY (trabajo_cod,nombre_trab);

ALTER TABLE historial_laboral
ADD CONSTRAINT Fk_trabajoHistoLabo
FOREIGN KEY (trabajo_cod) REFERENCES trabajos (trabajo_cod);

--------------------------------------------------------------------------------------

CREATE TABLE historial_salarial (
empleado_dni NUMERIC(8,0),
salario DOUBLE NOT NULL,
fecha_comienzo DATE,
fecha_fin DATE
);

ALTER TABLE historial_salarial
ADD CONSTRAINT Fk_empleHistoSala
FOREIGN KEY (empleado_dni) REFERENCES empleados (DNI);

ALTER TABLE historial_salarial
ADD CONSTRAINT Pk_histoSala
PRIMARY KEY (empleado_dni,salario);

ALTER TABLE departamentos
ADD CONSTRAINT Uk_dptoNombre
UNIQUE (nombre_dpto);

ALTER TABLE trabajos
ADD CONSTRAINT Uk_nombreTrab
UNIQUE (nombre_trab);



|=========================== "1. INSERTs 2 FILAS POR TABLA" ============================|

INSERT INTO empleados 
VALUES ('43392657','Antonio','Pérez','García','C/El repaso nº37','C/Doctor Méndez nº35','Madrid','Madrid','80123','H','1987-12-20');

INSERT INTO empleados 
VALUES ('43312453','Marina','Hernández','González','C/Los Espaguetis nº12','C/El callejón nº23','Puerto de la Cruz','S.C. de Tenerife','38400','S','1999-11-30');

--------------------------------------------------------------------------------------

INSERT INTO departamentos
VALUES ('12345','Departamento Administración','13579','135000','12000');

INSERT INTO departamentos
VALUES ('54321','Departamento Control y Gestión','97531','101000','20000');

--------------------------------------------------------------------------------------

INSERT INTO estudios
VALUES ('43392657','321','2011','123','Administración');

INSERT INTO estudios
VALUES ('43312453','1432','2022','321','Gestión Empresarial');

--------------------------------------------------------------------------------------

INSERT INTO universidades
VALUES ('321','Universidad Complutense','Madrid','12','12345');

INSERT INTO universidades
VALUES ('1432','ULL','S.C. de Tenerife','4','34001');

--------------------------------------------------------------------------------------

INSERT INTO trabajos
VALUES ('12345','Trabajo1','900','1400');

INSERT INTO trabajos
VALUES ('54321','Trabajo2','800','1200');

--------------------------------------------------------------------------------------

INSERT INTO historial_laboral
VALUES ('43392657','12345','10-10-2012','20-12-2021','12345','45362513');

INSERT INTO historial_laboral
VALUES ('43312453','54321','21-04-2012','02-09-2020','54321','43372213');

--------------------------------------------------------------------------------------

INSERT INTO historial_salarial
VALUES('43392657','1200','10-10-2012','20-12-2021');

INSERT INTO historial_salarial
VALUES('43392657','1000','21-04-2012','02-09-2020');


|============================== "2. INSERTs SIN SENTIDO" ===============================|

INSERT INTO empleados (nombre,apellido1,apellido2,DNI,sexo)
VALUES ('Sergio','Palma','Entrena','111222','P');

    ~~ RES: ERROR 3819 (HY000): Check constraint 'CHK_empleados' is violated. ~~

INSERT INTO empleados (nombre,apellido1,apellido2,DNI,sexo)
VALUES ('Lucia','Ortega','Plus','222333',NULL);

                ~~ RES: si se insertan los datos sin errores ~~

--------------------------------------------------------------------------------------

INSERT INTO historial_laboral (empleado_dni,trabajo_cod,fecha_inicio,fecha_fin,dpto_cod,supervisor_dni)
VALUES ('111222',NULL,'16/06/96',NULL,'222333',NULL);

        ~~ RES: ERROR 1048 (23000): Column 'trabajo_cod' cannot be null ~~

|============================== "3. MODIFY SIN SENTIDO" ================================|






