package es.iespuerto.model;

/**
 * @author jpexposito Joatham Perez Exposito
 * Clase Producto de la tienda
 */
public class Producto implements Comparable {
    private String codigo;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private int stock;

    /**
     * Constructor de la clase Producto
     * @param codigo Codigo del producto.
     * @param descripcion Descripcion del producto.
     * @param precioCompra Precio de compra del producto.
     * @param precioVenta Precio de venta del producto.
     * @param stock Stok del producto.
     */
    public Producto(String codigo, String descripcion, double precioCompra, double precioVenta, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    /**
     * Funcion que retorna la informacion del producto
     * @return String con la informacion del producto
     */
    public String toString() {
        return String.format("Código: %s, Descripción: %s, P.compra: %8.2f, P.venta: 8.2f, Stock: %f",
                codigo, descripcion, precioCompra, precioVenta, stock);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void changeStock(int cantidad){
        stock += cantidad;
    }

    @Override
    public boolean equals(Object o) {
        return codigo.equals(((Producto) o).codigo);
    }

    @Override
    public int compareTo(Object o) {
        Producto p = (Producto) o;
        return codigo.compareTo(p.codigo);
    }
}
