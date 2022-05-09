import java.time.*;
import java.time.temporal.ChronoUnit;

public class DatosNacimiento {
    public static void datosNacimiento(String fecha) {
        if (fecha.matches("[0-3][0-9][\\-/][0-1][0-9][\\-/][0-9]{4}")) {
            int dia = Integer.parseInt(fecha.substring(0, 2));
            int mes = Integer.parseInt(fecha.substring(3, 5));
            int anio = Integer.parseInt(fecha.substring(6, 10));

            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            LocalDate hoy = LocalDate.now();

            Long anios = ChronoUnit.YEARS.between(fechaNacimiento, hoy);
            Long meses = ChronoUnit.MONTHS.between(fechaNacimiento, hoy);
            Long dias = ChronoUnit.DAYS.between(fechaNacimiento, hoy);
            Long horas = ChronoUnit.HOURS.between(fechaNacimiento, hoy);
            Long minutos = ChronoUnit.MINUTES.between(fechaNacimiento, hoy);
            Long segundos = ChronoUnit.SECONDS.between(fechaNacimiento, hoy);
            Long milis = ChronoUnit.MILLIS.between(fechaNacimiento, hoy);
            Long nanos = ChronoUnit.NANOS.between(fechaNacimiento, hoy);

            System.out.printf("Has vivido %d años, %d meses, %d dias, %d horas,%d minutos, %d segundos, %d miliSeg y %d nanoSeg.\n",anios,meses,dias,horas,minutos,segundos,milis,nanos);
        }
    }

    public static void main(String args[]) {
        datosNacimiento("16/05/2000");
    }
}
