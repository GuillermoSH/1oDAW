public class ProductoProf {
    private String codigo;
    private String descripcion;
    private double pcompra;
    private double pventa;
    private int stock;

    public ProductoProf(String codigo, String descripcion, double pcompra, double pventa, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.pcompra = pcompra;
        this.pventa = pventa;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("Código: %s , Descripción: %s, P.Compra: %8.2f, P.Venta: %8.2f, Stock: %d", this.codigo, this.descripcion, this.pcompra, this.pventa, this.stock);
    }
    /*
    @Override
    public String equals() {
        
    }
    */
}
