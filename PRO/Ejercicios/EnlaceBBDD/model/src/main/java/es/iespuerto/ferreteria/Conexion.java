package es.iespuerto.ferreteria;

import java.sql.*;

/*
1) Crear una conexion -> Connection
DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
2) Preparar la sentencia
PreparedStatement ps=c.prepareStatement("SELECT * FROM producto")
3) Ejecutar
ps.execute()
4) Obtener el ResultSet
ResultSet productos=ps.getResultSet()
5) Recorrer el resultado
productos.next()
*/

/*** @author Javier Criado, 15/05/2022:22:15:04 ***/
class Conexion {
    private static final String BASE = "ferreteria";
    private static final String USER = "ferreteria";
    private static final String PASSWORD = "ferreteria2022";
    private static Connection conexion;
    // Si no ponemos lo de serverTimezone habría que cambiar en el servidor mysql la
    // variable global
    // time_zone -> show global variables like 'time_zone'; o select
    // @@global.time_zone; devuelve SYSTEM y
    // debería coger la configuración válida de nuestra zona horaria del sistema
    // operativo, pero no lo hace
    // bien, podemos ponerla a mano con SET GLOBAL time_zone = '+1:00';
    // pero hemos de tener en cuenta los cambios horarios de verano/invierno
    // lo mejor es dejar a mysql como está y añadir al URL de la base de datos
    // ?serverTimezone=UTC (que debería encajar
    // con lo que haya en nuestro sistema.
    private static final String URL = "jdbc:mysql://localhost:3306/" + Conexion.BASE + "?serverTimezone=UTC";

    public static Connection getConexionBdFerreteria() throws Exception {

        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            return Conexion.conexion = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD); // Abrir
                                                                                                                    // conexión
                                                                                                                    // TCP/IP
        }
        // catch(ClassNotFoundException e) {
        // throw new Exception("No se ha podido cargar el controlador mysql jdbc");
        // }
        catch (SQLException ex) {
            throw new Exception("No se ha podido establecer la conexión con el servidor");
        }
    }

    public static PreparedStatement getPreparedStatement(String sql) throws Exception {
        // si no se ha podido establecer conexión mysql-server el método
        // getConexionBdTienda genera una excepción
        // indicando el motivo del error con lo cual aquí no necesitamos
        // controlar nada, simplemente transmitimos la excepción
        return Conexion.getConexionBdFerreteria().prepareStatement(sql);
    }

    public static ResultSet consulta(String sql) throws Exception {
        try {
            PreparedStatement ps = Conexion.getPreparedStatement(sql);
            if (ps.execute()) { // Si hay conjunto de resultados (ResulSet)
                return ps.getResultSet();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage() + "\nEjecutando consulta: " + sql + "\n");
        }
        return null;
    }

    public static void close() {
        if (Conexion.conexion != null) {
            try {
                Conexion.conexion.close();
            } catch (SQLException ex) {
            } // No hacemos nada
        }
    }
}
