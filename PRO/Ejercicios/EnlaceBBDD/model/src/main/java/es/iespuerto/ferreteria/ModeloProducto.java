package es.iespuerto.ferreteria;

import java.sql.*;
import java.util.*;

public class ModeloProducto {
    public ModeloProducto() {

    }

    public static int numeroProductos() throws Exception {
        int total;
        String sql = "SELECT COUNT(*) AS cantidad FROM producto";
        PreparedStatement ps = Conexion.getPreparedStatement(sql);
        ResultSet rs = ps.getResultSet();
        if (rs.next()) {
            return rs.getInt("");
        } else {
            throw new Exception("");
        }
        return total;
    }

    public static List<Producto> getProductos(int pagina, int tamanioPagina) throws Exception {
        List<Productos> productos = new ArrayList<>();
        ModeloProducto modeloProducto = new ModeloProducto();
        String sql = "SELECT * FROM producto LIMIT " + (pagina - 1) * tamanioPagina + ", " + tamanioPagina;
        PreparedStatement ps = Conexion.getPreparedStatement(sql);
        ResultSet rs = ps.getResultSet();

        while (rs.next()) {
            productos.add(modeloProducto.registroProductos(rs));
        }
        return productos;
    }

    public static Producto getProducto(int codigo) throws Exception {
        ModeloProducto modeloProducto = new ModeloProducto();
        String sql = "SELECT * FROM producto WHERE codigo=" + codigo;
        PreparedStatement ps = Conexion.getPreparedStatement(sql);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        if (rs.next()) {
            return modeloProducto.registroProducto(rs);
        } else {
            throw new Exception("Error ModeloProducto.getProducto: el producto no existe");
        }
    }

    public static int actualizarProducto(Producto producto) throws Exception {
        try {
            String sql = "UPDATE productos SET codigo=?, nombre=?, precio_compra=?, precio_venta=?, stock=?, WHERE codigo=?";
            PreparedStatement ps = Conexion.getPreparedStatement(sql);

            
        }
    }

    public static int borrarProducto(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM productos WHERE codigo = " + codigo;
            PreparedStatement ps = Conexion.getPreparedStatement(sql);

            return ps.executeUpdate();
        } catch (Exception exception) {
            System.out.println("Error ModeloProducto.borrarProducto(): no se ha podido borrar el producto");
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(ModeloProducto.numeroProductos());
        System.out.println(ModeloProducto.getProducto(9));
    }
}
