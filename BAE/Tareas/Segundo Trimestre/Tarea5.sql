|================================ "1. CREACIÓN DE TABLAS" ================================|

CREATE TABLE proveedores (
p VARCHAR(2) NOT NULL,
pnombre VARCHAR(10) NOT NULL,
categoria INT NOT NULL,
ciudad VARCHAR(10) NOT NULL
);

CREATE TABLE componentes (
c VARCHAR(2) NOT NULL,
cnombre VARCHAR(3) NOT NULL,
color VARCHAR(10) NOT NULL,
peso INT NOT NULL,
ciudad VARCHAR(10) NOT NULL
);

CREATE TABLE articulos (
t VARCHAR(2) NOT NULL,
tnombre VARCHAR(15) NOT NULL,
ciudad VARCHAR(10) NOT NULL
);

CREATE TABLE envios (
p VARCHAR(2) NOT NULL,
c VARCHAR(2) NOT NULL,
t VARCHAR(2) NOT NULL,
cantidad INT NOT NULL
);

|============================= "2. RESTRICCIONES TABLAS" ===============================|

ALTER TABLE proveedores
ADD CONSTRAINT Pk_proveedores
PRIMARY KEY (p);

ALTER TABLE componentes
ADD CONSTRAINT Pk_componentes
PRIMARY KEY (c);

ALTER TABLE articulos
ADD CONSTRAINT Pk_articulos
PRIMARY KEY (t);

ALTER TABLE envios ADD CONSTRAINT Fk_proEnv FOREIGN KEY (p) REFERENCES proveedores (p);

ALTER TABLE envios ADD CONSTRAINT Fk_compEnv FOREIGN KEY (c) REFERENCES componentes (c);

ALTER TABLE envios ADD CONSTRAINT Fk_artEnv FOREIGN KEY (t) REFERENCES articulos (t);

ALTER TABLE envios
ADD CONSTRAINT Pk_envios
PRIMARY KEY (p,c,t);

|============================ "3. INSERTs TABLAS TAREAS 5" =============================|

INSERT INTO proveedores
VALUES ('P1','CARLOS',20,'SEVILLA'),
('P2','JUAN',10,'MADRID'),
('P3','JOSE',30,'SEVILLA'),
('P4','INMA',20,'SEVILLA'),
('P5','EVA',30,'CACERES');

INSERT INTO componentes
VALUES ('C1','X3A','ROJO',12,'SEVILLA'),
('C2','B85','VERDE',17,'MADRID'),
('C3','C4B','AZUL',17,'MALAGA'),
('C4','C4B','ROJO',14,'SEVILLA'),
('C5','VT8','AZUL',12,'MADRID'),
('C6','C30','ROJO',19,'SEVILLA');

INSERT INTO articulos
VALUES ('T1','CLASIFICADORA','MADRID'),
('T2','PERFORADORA','MALAGA'),
('T3','LECTORA','CACERES'),
('T4','CONSOLA','CACERES'),
('T5','MEZCLADORA','SEVILLA'),
('T6','TERMINAL','BARCELONA'),
('T7','CINTA','SEVILLA');

INSERT INTO envios
VALUES ('P1','C1','T1',200),
('P1','C1','T4',700),
('P2','C3','T1',400),
('P2','C3','T2',200),
('P2','C3','T3',200),
('P2','C3','T4',500),
('P2','C3','T5',600),
('P2','C3','T6',400),
('P2','C3','T7',800),
('P2','C5','T2',100),
('P3','C3','T1',200),
('P3','C4','T2',500),
('P4','C6','T3',300),
('P4','C6','T7',300),
('P5','C2','T2',200),
('P5','C2','T4',100),
('P5','C5','T4',500),
('P5','C5','T7',100),
('P5','C6','T2',200),
('P5','C1','T4',100),
('P5','C3','T4',200),
('P5','C4','T4',800),
('P5','C5','T5',400),
('P5','C6','T4',500);

|=================================== "4. CONSULTAS" ====================================|
                    https://studylib.es/doc/4521827/ejercicios-sql-1-14

1.  SELECT * FROM articulos WHERE ciudad='CACERES';

2.  SELECT p FROM envios WHERE t='T1';

3.  SELECT DISTINCT color,ciudad FROM componentes;

4.  SELECT t,ciudad FROM articulos WHERE ciudad LIKE '%D' OR ciudad LIKE '%E%';

5.  SELECT p FROM envios WHERE t='T1' AND c='C1';

6.  SELECT DISTINCT tnombre FROM articulos INNER JOIN envios ON envios.p='P1' AND envios.t=articulos.t;

7.  SELECT DISTINCT envios.c FROM articulos INNER JOIN envios ON articulos.t=envios.t WHERE articulos.ciudad='MADRID';

8.  SELECT c FROM componentes WHERE peso=(SELECT MIN(peso) FROM componentes);

9.  SELECT envios.p FROM envios WHERE t='T1' INTERSECT SELECT envios.p FROM envios WHERE t='T2';

10. SELECT DISTINCT envios.p FROM (envios JOIN componentes ON envios.c=componentes.c) JOIN articulos ON envios.t=articulos.t WHERE (articulos.ciudad='SEVILLA' OR articulos.ciudad='MADRID') AND (componentes.color='ROJO');

11. SELECT DISTINCT c FROM envios WHERE t IN(SELECT t FROM articulos WHERE ciudad='SEVILLA') AND p IN(SELECT p FROM proveedores WHERE ciudad='SEVILLA');

12. SELECT DISTINCT t FROM envios WHERE c IN(SELECT c FROM envios WHERE p='P1');

13. SELECT p.ciudad,e.c,a.ciudad FROM envios e,proveedores p,articulos a WHERE e.p=p.p AND e.t=a.t;

14. 



































