|============================== "1. CREACIÓN DE TABLAS" ================================|

CREATE TABLE usuarios (
idx INT PRIMARY KEY AUTO_INCREMENT,
usuario VARCHAR(20),
nombre VARCHAR(20),
sexo VARCHAR(1),
nivel TINYINT,
email VARCHAR(50),
telefono VARCHAR(20),
marca VARCHAR(20),
compañia VARCHAR(20),
saldo FLOAT,
activo BOOLEAN
);

|============================ "2. INSERTs TABLAS TAREAS 4" =============================|

INSERT INTO usuarios 
VALUES ('1','BRE2271','BRENDA','M','2','brenda@live.com','655-330-5736','SAMSUNG','IUSACELL','100','1'),
('2','OSC4677','OSCAR','H','3','oscar@gmail.com','655-143-4181','LG','TELCEL','0','1'),
('3','JOS7086','JOSE','H','3','francisco@gmail.com','655-143-3922','NOKIA','MOVISTAR','150','1'),
('4','LUI6115','LUIS','H','0','enrique@outlook.com','655-137-1279','SAMSUNG','TELCEL','50','1'),
('5','LUI7072','LUIS','H','1','luis@hotmail.com','655-100-8260','NOKIA','IUSACELL','50','0'),
('6','DAN2832','DANIEL','H','0','daniel@outlook.com','655-145-2586','SONY','UNEFON','100','1'),
('7','JAQ5351','JAQUELINE','M','0','jaqueline@outlook.com','655-330-5514','BLACKBERRY','AXEL','0','1'),
('8','ROM6520','ROMAN','H','2','roman@gmail.com','655-330-3263','LG','IUSACELL','50','1'),
('9','BLA9739','BLAS','H','0','blas@hotmail.com','655-330-3871','LG','UNEFON','100','1'),
('10','JES4752','JESSICA','M','1','jessica@hotmail.com','655-143-6861','SAMSUNG','TELCEL','500','1'),
('11','DIA6570','DIANA','M','1','diana@live.com','655-143-3952','SONY','UNEFON','100','0'),
('12','RIC8283','RICARDO','H','2','ricardo@hotmail.com','655-145-6049','MOTOROLA','IUSACELL','150','1'),
('13','VAL6882','VALENTINA','M','0','valentina@live.com','655-137-4253','BLACKBERRY','AT&T','50','0'),
('14','BRE8106','BRENDA','M','3','brenda2@gmail.com','655-100-1351','MOTOROLA','NEXTEL','150','1'),
('15','LUC4982','LUCIA','M','3','lucia@gmail.com','655-145-4992','BLACKBERRY','IUSACELL','0','1'),
('16','JUA2337','JUAN','H','0','juan@outlook.com','655-100-6517','SAMSUNG','AXEL','0','0'),
('17','ELP2984','ELPIDIO','H','1','elpidio@outlook.com','655-145-9938','MOTOROLA','MOVISTAR','500','1'),
('18','JES9640','JESSICA','M','3','jessica2@live.com','655-330-5143','SONY','IUSACELL','200','1'),
('19','LET4015','LETICIA','M','2','leticia@yahoo.com','655-143-4019','BLACKBERRY','UNEFON','100','1'),
('20','LUI1076','LUIS','H','3','luis2@live.com','655-100-5085','SONY','UNEFON','150','1'),
('21','HUG5441','HUGO','H','2','hugo@live.com','655-137-3935','MOTOROLA','AT&T','500','1');

|=================================== "3. CONSULTAS" ====================================|

"BLOQUE 1.-"

1.  SELECT nombre FROM usuarios;

2.  SELECT MAX(saldo) FROM usuarios WHERE sexo='M';

3.  SELECT nombre,telefono FROM usuarios WHERE marca IN('NOKIA','BLACKBERRY','SONY');

4.  SELECT COUNT(usuario) FROM usuarios WHERE saldo<=0 OR NOT activo;

5.  SELECT usuario FROM usuarios WHERE nivel IN (1,2,3);

6.  SELECT telefono FROM usuarios WHERE saldo<=300;

7.  SELECT SUM(saldo) FROM usuarios WHERE compañia='NEXTEL';

8.  SELECT compañia,COUNT(usuario) FROM usuarios GROUP BY compañia;

9.  SELECT nivel,COUNT(usuario) FROM usuarios GROUP BY nivel;

10. SELECT usuario FROM usuarios WHERE nivel=2;

11. SELECT email FROM usuarios WHERE email LIKE '%gmail.com';

12. SELECT nombre,telefono FROM usuarios WHERE marca IN('LG','SAMSUNG','MOTOROLA');

"BLOQUE 2.-"

13. SELECT nombre,telefono FROM usuarios WHERE marca NOT IN('LG','SAMSUNG');

14. SELECT usuario,telefono FROM usuarios WHERE compañia='IUSACELL';

15. SELECT usuario,telefono FROM usuarios WHERE compañia!='TELCEL';

16. SELECT AVG(saldo) FROM usuarios WHERE marca='NOKIA';

17. SELECT usuario,telefono FROM usuarios WHERE compañia IN('IUSACELL','AXEL');

18. SELECT email FROM usuarios WHERE email NOT LIKE '%yahoo.com';

19. SELECT usuario,telefono FROM usuarios WHERE marca NOT IN('TELCEL','IUSACELL');

20. SELECT usuario,telefono FROM usuarios WHERE compañia='UNEFON';

21. SELECT marca FROM usuarios GROUP BY marca ORDER BY marca DESC;

22. SELECT marca FROM usuarios GROUP BY marca ORDER BY RAND();

23. SELECT usuario FROM usuarios WHERE nivel IN(0,2);

24. SELECT AVG(saldo) FROM usuarios WHERE marca='LG';

"BLOQUE 3.-"

25. SELECT usuario FROM usuarios WHERE nivel IN(1, 3);

26. SELECT nombre, telefono FROM usuarios WHERE marca<>"BLACKBERRY";

27. SELECT usuario FROM usuarios WHERE nivel = 3;

28. SELECT usuario FROM usuarios WHERE nivel = 0;

29. SELECT usuario FROM usuarios WHERE nivel = 1;

30. SELECT sexo, COUNT(*) FROM usuarios GROUP BY sexo;

31. SELECT usuario, telefono FROM usuarios WHERE compañia="AT&T";

32. SELECT DISTINCT compañia FROM usuarios ORDER BY compañia DESC;

33. SELECT usuario FROM usuarios WHERE NOT activo;

34. SELECT telefono FROM usuarios WHERE saldo=0;

35. SELECT MIN(saldo) FROM usuarios WHERE sexo='H';

36. SELECT telefono FROM usuarios WHERE saldo>300;

"BLOQUE 4.-"

37. SELECT marca,COUNT(*) FROM usuarios GROUP BY marca;

38. SELECT nombre,telefono FROM usuarios WHERE marca<>"LG";

39. SELECT DISTINCT compañia FROM usuarios ORDER BY compañia ASC;

40. SELECT SUM(saldo) FROM usuarios WHERE compañia='UNEFON';

41. SELECT email FROM usuarios WHERE email LIKE "%hotmail.com";

42. SELECT nombre FROM usuarios WHERE NOT activo OR saldo<=0;

43. SELECT usuario, telefono FROM usuarios WHERE compañia IN('IUSACELL','TELCEL');

44. SELECT DISTINCT marca FROM usuarios ORDER BY marca DESC;

45. SELECT DISTINCT marca FROM usuarios ORDER BY RAND();

46. SELECT usuario, telefono FROM usuarios WHERE compañia IN('IUSACELL','UNEFON');

47. SELECT nombre, telefono FROM usuarios WHERE marca NOT IN('MOTOROLA','NOKIA');

48. SELECT SUM(saldo) FROM usuarios WHERE compañia='TELCEL';