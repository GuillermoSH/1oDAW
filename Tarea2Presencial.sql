|============================== "CONSULTAS"  ==============================|

1.  SELECT apellido,oficio,dept_no FROM emple;

2.  SELECT * FROM depart;

3.  SELECT * FROM emple;

4.  SELECT * FROM emple ORDER BY apellido;

5.  SELECT * FROM emple ORDER BY dept_no DESC;

6.  SELECT * FROM emple ORDER BY dept_no DESC, apellido;

7.  SELECT * FROM emple WHERE salario>200000;

8.  SELECT * FROM emple WHERE oficio='ANALISTA';

9.  SELECT apellido,oficio FROM emple WHERE dept_no='20';

10. SELECT * FROM emple ORDER BY apellido;

11. SELECT * FROM emple WHERE oficio='VENDEDOR' ORDER BY apellido;

12. SELECT * FROM emple WHERE dept_no='10' AND oficio='ANALISTA' ORDER BY apellido;

13.  SELECT * FROM emple WHERE salario>200000 OR dept_no='20';

14. SELECT * FROM emple ORDER BY oficio,nombre;

15. SELECT * FROM emple WHERE apellido LIKE 'A%';

16. SELECT * FROM emple WHERE apellido LIKE '%Z';

17. SELECT * FROM emple WHERE apellido LIKE 'A%' AND oficio LIKE '%E%';

18. SELECT * FROM emple WHERE salario BETWEEN 100000 AND 200000;

19. SELECT * FROM emple WHERE oficio='VENDEDOR' AND comision>100000;
   
20. SELECT * FROM emple ORDER BY dept_no,apellido;

21. SELECT emp_no, apellido FROM emple WHERE apellido LIKE 'G%' AND salario>30000;

22. SELECT * FROM depart WHERE loc LIKE 'B%';

23. SELECT * FROM emple WHERE oficio='EMPLEADO' AND salario>200 AND dept_no=10;

24. SELECT apellido FROM emple WHERE comision IS NULL;

25. SELECT apellido FROM emple WHERE comision IS NULL AND apellido LIKE 'J%';

26. SELECT apellido FROM emple WHERE oficio IN ('VENDEDOR','ANALISTA','EMPLEADO');

27. SELECT apellido FROM emple WHERE oficio NOT IN ('ANALISTA','EMPLEADO') AND salario>200000;

28. SELECT * FROM emple WHERE salario BETWEEN 200000 AND 300000;

29. SELECT apellido,salario,dept_no FROM emple WHERE salario>200000 AND (dept_no=10 OR dept_no=30);

30. SELECT  apellido,emp_no FROM emple WHERE salario NOT BETWEEN 100000 AND 200000;

31. SELECT  LOWER(apellido) FROM emple;

32. SELECT  CONCAT(apellido,'',oficio) FROM emple;

33. SELECT apellido,LENGTH(apellido) FROM emple ORDER BY LENGTH(apellido) DESC;

34. SELECT YEAR(fecha_alt) FROM emple;

35. SELECT * FROM emple WHERE YEAR(fecha_alt)=1992;

36. SELECT * FROM emple WHERE MONTHNAME(fecha_alt)='February';

37. SELECT apellido,GREATEST(apellido,salario) FROM emple;

38. SELECT apellido FROM emple WHERE apellido LIKE 'A%' AND YEAR(fecha_alt)=1990;

39. SELECT * FROM emple WHERE dept_no=10 AND comision IS NULL;