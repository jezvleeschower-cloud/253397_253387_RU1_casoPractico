import java.util.Locale;

public class Producto {
    private int idProducto;
    private String nombre;
    private int stock;
    private double precioCompra;
    private Proveedor proveedor;

    public Producto(int idProducto, String nombre, int stock, double precioCompra, Proveedor proveedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.stock = stock;
        this.precioCompra = precioCompra;
        this.proveedor = proveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        // Se evita NullPointerException si el producto no tiene proveedor
        String datosProveedor = (proveedor != null) ? proveedor.toString() : "Sin proveedor";
        // Precio con 2 decimales y siempre con punto decimal (Locale.ROOT), sin importar la configuración regional
        return "ID: " + idProducto + " | Nombre: " + nombre + " | Stock: " + stock +
               " | Precio: $" + String.format(Locale.ROOT, "%.2f", precioCompra) +
               " | Proveedor: [" + datosProveedor + "]";
    }
}
