<div align="justify">

# Centro Educativo (Javadocs && Testing)

</br>

<div align="center">
  <img src="https://www3.gobiernodecanarias.org/medusa/ecoescuela/familias/files/2020/03/profe.png" width="400px" />
</div>

</br>

## Introducción

  Realizar un programa que nos va a permitir gestionar un centro educativo.

  A continuación se van a describir las clases que utilizaremos en nuestro programa.

  Tenemos una clase Fecha que representa una fecha, en la cuál guardaremos la fecha:
  - Mes: será un valor entre 1 y 12. A la hora de mostrar el mes deberíamos considerar la posibilidad de devolver el número de mes o devolver el nombre del mes, es decir, enero, febrero, etc...
  - Día: será un valor numérico donde el rango de valores válidos dependerá del mes, dados los siguientes valores:
  - Si es Enero, Marzo, Mayo, Julio, Agosto, Octubre, Diciembre: el rango del día será desde el 1 al 31
  - Si se trata de Febrero el rango será del 1 al 28, menos cuando el año sea bisiesto que en tal caso será del 1 al 29.
  - Para el resto de meses el rango será del 1 al 30
  - Anyo: Será un valor desde el año 1900 hasta el año 9999.
  - Hay que tener en cuenta que podremos dar de alta una fecha con el formato "dd/mm/aaaa".

Tenemos una clase llamada Tema que representa el tema de un temario de una asignatura, y tiene los siguientes atributos:
  - Nombre: Nombre del tema, que siempre lo guardaremos en minúsculas.
  - Horas: la cantidad de horas dedicadas a dicho tema, será un número entero.

Tenemos una clase llamada Temario que representa el temario de una asignatura, y tiene los siguientes atributos:
  - Nombre: Contiene el nombre de la asignatura a la cuál está referido el temario, siempre en formato de mayúsculas.
  - Temas: Contiene una colección de temas, es decir, de la clase descrita anteriormente.
  - HorasTotales: Contiene las horas totales de todo el temario, es decir, la suma de las horas de todos los temas, y es un número entero.
  - Necesitamos un método que nos ayude a agregar temas, otro para eliminarlos y otro para editarlos.

La clase Asignatura que va a contener lo siguiente:
  - Nombre: Nombre de la asignatura que lo guardaremos en formato capitalizado (es decir, que la primera letra será en mayúscula y el resto en minúsculas)
  - Temario: Es el temario de dicha asignatura.
  - Precio: (Expresado en euros, puede contener decimales). Contiene el precio de la asignatura, el precio siempre va a ser 3'755 euros por cada hora que tenga dicha asignatura en su temario. A nivel interno vamos a guardar todos los decimales, pero cuando mostremos el precio sólo se mostrarán 2 decimales de precisión.

También vamos a tener una clase llamada Profesor que tiene los siguientes atributos:
  - Nombre: puede ser único o compuesto, además lo guardaremos en formato capitalizado (es decir, que la primera letra será en mayúscula y el resto en minúsculas)
  - Apellidos: lo guardaremos en formato capitalizado (es decir, que la primera letra será en mayúscula y el resto en minúsculas).
  - Titulación: aquí guardaremos la titulación de dicho profesor siempre en mayúsculas.
  - Asignaturas: Es la colección de asignaturas que imparte dicho profesor. Un profesor nunca va a poder sobrepasar un total de 3.000 horas de docencia, por tanto la suma total de horas de las asignaturas nunca podrá sobrepasar ese límite.
  - Necesitamos un método que nos ayude a agregar asignaturas al profesor, otro para eliminarlos y otro para editarlos.

Tenemos también una clase llamada __Matricula__ que consta de:
  - DNI: el dni del alumno al cuál pertenece la matrícula. El dni no tendrá letra y debe ser un número de como máximo 8 cifras. A nivel interno en nuestra aplicación sólo guardaremos el número del dni, pero cuando mostremos al usuario por pantalla el dni mostrará también la letra calculada para dicho dni.
  - Nombre: El nombre del centro educativo donde se ha realizado la matrícula.
  - Asignaturas: Es la colección de asignaturas en las cuales se ha matriculado un alumno. Hay que tener en cuenta que un alumno no puede matricularse dos veces en la misma asignatura en una misma matrícula.
  - Notas: Será una colección de notas asociadas a cada una de las asignaturas.
  - Fecha: Se guardará el día, mes y año en que se ha realizado la matrícula.
  - Precio: El precio calculado de la matrícula en euros en base a las asignaturas matriculadas.
  - Pagada: Indica si dicha matricula ha sido pagada por el alumno o no. Debemos tener en cuenta que una vez que la matrícula está pagada no será posible modificarla.
  - Necesitamos un método que nos ayude a agregar asignaturas a la matrícula, otro para eliminarlos y otro para editarlos.

También tenemos una clase llama Alumno que consta de:
  - Nombre: puede ser único o compuesto, además lo guardaremos en formato capitalizado (es decir, que la primera letra será en mayúscula y el resto en minúsculas)
  - Apellidos: lo guardaremos en formato capitalizado (es decir, que la primera letra será en mayúscula y el resto en minúsculas).
  - DNI: el dni del alumno. El dni no tendrá letra y debe ser un número de como máximo 8 cifras. A nivel interno en nuestra aplicación sólo guardaremos el número del dni, pero cuando mostremos al usuario por pantalla el dni mostrará también la letra calculada para dicho dni.
  - FechaNacimiento: Aquí guardaremos la fecha de nacimiento del alumno.
  - Matriculas: Contendrá una colección matriculas realizadas por el alumno.
  - Necesitamos un método que nos ayude a agregar matrículas al alumno, otro para eliminarlos y otro para editarlos.
  - Por último tenemos una clase llamada Usuario que consta de:
  - Email: Será el correo electrónico del usuario.
  - Password: La contraseña del usuario que debe ser de al menos 6 caracteres entre los cuales debe haber una mayúscula, una minúscula, y algún número.

Todas estas clases las vamos a poner en funcionamiento en una clase llamada ___CentroEducativo___, esta clase tendrá una colección de usuarios, otra de profesores, otra de asignaturas, y otra de alumnos. La clase CentroEducativo nos debe permitir dar de alta, modificar y eliminar usuarios, profesores, asignaturas con sus respectivos temarios con temas y alumnos con sus respectivas matriculas. Debemos tener en cuenta que los métodos que usemos para eliminar y modificar deberán comprobar que dicho elemento existe para que sea eliminado o modificado.

___OPCIONAL___: Para aquellos alumnos que quieran subir la nota en el ejercicio deben realizar los siguientes aspectos:
Se propone crear una interfaz de usuario en formato de texto con un menú que me permite gestionar datos de usuarios, alumnos, profesores y asignaturas.

  GESTIÓN DE CENTRO EDUCATIVO
**************************************************
1. Usuarios.
2. Alumnos.
3. Profesores.
4. Asignaturas.
0. Salir

Cada una de esas opciones del menu nos llevará a las siguientes.
Si pulsamos la opción "1. Usuarios" nos mostrará:

  GESTIÓN DE USUARIOS
**************************************************
1. Crear.
2. Editar.
3. Eliminar.
4. Buscar.
0. Volver al menu anterior.
Si pulsamos la opción "2. Alumnos" nos mostrará:

  GESTIÓN DE ALUMNOS
**************************************************
1. Crear.
2. Editar.
3. Eliminar.
4. Buscar.
5. Matricular.
0. Volver al menu anterior.
Si pulsamos la opción "3. Profesores" nos mostrará:

  GESTIÓN DE PROFESORES
**************************************************
1. Crear.
2. Editar.
3. Eliminar.
4. Buscar.
5. Agregar asignaturas.
0. Volver al menu anterior.

Si pulsamos la opción "4. Asignaturas" nos mostrará:

  GESTIÓN DE ASIGNATURAS
**************************************************
1. Crear.
2. Editar.
3. Eliminar.
4. Buscar.
0. Volver al menu anterior.

</br>
Cuando creamos una asignatura debemos de tener en cuenta que habrá que crear un Temario con sus respectivos Temas.
A la hora de hacer las búsquedas en los menú debemos tener en cuenta el campo que sea más relevante para las mismas, es decir, por ejemplo en el caso del alumno a través del dni, o del profesor a través del nombre de las asignaturas que imparta, o quizá buscas alumnos por matriculaciones, etc, es decir, estos aspectos se van a dejar a criterio del alumno que realice el ejercicio.

Se tendrá en cuenta para evaluar el ejercicio que se usen las estructuras de datos adecuadas, los criterios de ordenación y búsquedas, documentación de clases y junitest de estas, además de cualquier aportación por parte del alumno.
