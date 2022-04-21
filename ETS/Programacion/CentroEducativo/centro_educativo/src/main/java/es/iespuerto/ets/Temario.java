package es.iespuerto.ets;

import java.util.*;

/**
 * Clase Temario que contiene los datos de cada asignatura impartida
 */
public class Temario {
    private String nombre;
    private ArrayList<Tema> temas = new ArrayList<>();
    private int horasTotales;

    /**
     * Contructor parametrizado de la clase Temario
     * 
     * @param nombre nombre de la asignatura referida al temario
     * @param temas  coleccion de temas de la asignatura
     */
    public Temario(String nombre, ArrayList<Tema> temas) {
        this.nombre = nombre.toUpperCase();
        this.temas = temas;
    }

    /**
     * Getter del parametro nombre de la clase Temario
     * 
     * @return nombre de la asignatura referida al temario
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Getter de la lista de objetos de Tema, temas de la clase Temario
     * 
     * @return coleccion de temas de la asignatura
     */
    public List<Tema> getTemas() {
        return this.temas;
    }

    /**
     * Getter del parametro horasTotales de la clase Temario
     * 
     * @return horas totales de cada temario
     */
    public int getHorasTotales() {
        int sumaHorasTotales = 0;

        for (int i = 0; i < this.temas.size(); i++) {
            Tema tema = this.temas.get(i);
            int horas = tema.getHoras();
            sumaHorasTotales += horas;
        }

        this.horasTotales = sumaHorasTotales;

        return this.horasTotales;
    }

    /**
     * Metodo para añadir objetos de la clase Tema a la lista temas
     * 
     * @param newTema nuevo objeto Tema a añadir
     */
    public void crear(Tema newTema) {
        temas.add(newTema);
    }

    /**
     * Metodo para eliminar un objeto de la clase Tema de la lista temas
     * 
     * @param oldTema objeto existente Tema a eliminar
     * @return true si existia el objeto a eliminar
     * @throws Exception Error Temario.eliminar(): no existe ese tema.
     */
    public boolean eliminar(Tema oldTema) throws Exception {
        if (temas.contains(oldTema)) {
            temas.remove(oldTema);
            return true;
        } else {
            throw new Exception("Error Temario.eliminar(): no existe ese tema.");
        }
    }

    /**
     * Metodo para editar un objeto de la clase Tema de la lista temas
     * 
     * @param oldTema objeto existente Tema a editar
     * @param newTema objeto nuevo Tema a reemplazar por el anterior
     * @return true si existia eñ objeto a editar
     * @throws Exception Error Temario.editar(): no existe ese tema
     */
    public boolean editar(Tema oldTema, Tema newTema) throws Exception {
        if (temas.contains(oldTema)) {
            temas.set(temas.indexOf(oldTema), newTema);
            return true;
        } else {
            throw new Exception("Error Temario.editar(): no existe ese tema");
        }
    }

    /**
     * Metodo sobrecargado del metodo {@link #toString()} de java para imprimir los objetos Tema de la lista temas
     */
    @Override
    public String toString() {
        return String.format("\n· Temario %s con %d horas totales:\n  %s\n",this.nombre,getHorasTotales(),this.temas.toString());

    }
    /*
    public static void main(String args[]) throws Exception {
        ArrayList<Tema> temas = new ArrayList<>();
        Temario t = new Temario("Fisica y Química", temas);
        Tema t1 = new Tema("Tema1: Magintudes y Unidades", 24);
        Tema t2 = new Tema("Tema2: La Materia", 12);
        Tema t3 = new Tema("Tema3: Formulación Inorgánica", 18);
        Tema t4 = new Tema("Tema4: Reacciones Químicas", 30);
        Tema t5 = new Tema("Tema5: Termoquímica", 20);

        t.crear(t1);
        t.crear(t2);
        t.crear(t3);
        t.crear(t4);

        t.editar(t2, t5);

        t.eliminar(t4);

        t.getHorasTotales();

        System.out.println(t);
    }
    */
}
