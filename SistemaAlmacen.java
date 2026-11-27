public class SistemaAlmacen {
    // Uso obligatorio de arreglos de objetos
    private Producto[] productos;
    private Proveedor[] proveedores;
    private int contadorProductos;
    private int contadorProveedores;

    public SistemaAlmacen(int capacidadProductos, int capacidadProveedores) {
        this.productos = new Producto[capacidadProductos];
        this.proveedores = new Proveedor[capacidadProveedores];
        this.contadorProductos = 0;
        this.contadorProveedores = 0;
    }

    public boolean registrarProveedor(Proveedor p) {
        // No se aceptan nulos ni IDs repetidos
        if (p == null || buscarProveedorPorId(p.getIdProveedor()) != null) {
            return false;
        }
        if (contadorProveedores < proveedores.length) {
            proveedores[contadorProveedores] = p;
            contadorProveedores++;
            return true;
        }
        return false;
    }

    public boolean registrarProducto(Producto p) {
        if (p == null || buscarProductoPorId(p.getIdProducto()) != null) {
            return false;
        }
        if (contadorProductos < productos.length) {
            productos[contadorProductos] = p;
            contadorProductos++;
            return true;
        }
        return false;
    }

    public boolean hayEspacioProveedores() {
        return contadorProveedores < proveedores.length;
    }

    public boolean hayEspacioProductos() {
        return contadorProductos < productos.length;
    }

    // El siguiente ID se calcula a partir del mayor ID registrado, así nunca choca con un ID existente
    public int siguienteIdProveedor() {
        int max = 0;
        for (int i = 0; i < contadorProveedores; i++) {
            max = Math.max(max, proveedores[i].getIdProveedor());
        }
        return max + 1;
    }

    public int siguienteIdProducto() {
        int max = 100; // Los productos inician en 101
        for (int i = 0; i < contadorProductos; i++) {
            max = Math.max(max, productos[i].getIdProducto());
        }
        return max + 1;
    }

    public Proveedor buscarProveedorPorId(int id) {
        for (int i = 0; i < contadorProveedores; i++) {
            if (proveedores[i].getIdProveedor() == id) {
                return proveedores[i];
            }
        }
        return null;
    }

    public Producto buscarProductoPorId(int id) {
        for (int i = 0; i < contadorProductos; i++) {
            if (productos[i].getIdProducto() == id) {
                return productos[i];
            }
        }
        return null;
    }

    public boolean cambiarProveedorProducto(int idProducto, int idNuevoProveedor) {
        Producto prod = buscarProductoPorId(idProducto);
        Proveedor prov = buscarProveedorPorId(idNuevoProveedor);

        if (prod != null && prov != null) {
            prod.setProveedor(prov);
            return true;
        }
        return false;
    }

    public void generarReporteEntrada() {
        System.out.println("\n=======================================================");
        System.out.println("        REPORTE DE ENTRADA DE PRODUCTOS              ");
        System.out.println("=======================================================");
        if (contadorProductos == 0) {
            System.out.println("No hay productos registrados en el almacén.");
        } else {
            for (int i = 0; i < contadorProductos; i++) {
                System.out.println(productos[i]);
            }
        }
        System.out.println("=======================================================\n");
    }

    public void listarProveedores() {
        System.out.println("\n--- LISTA DE PROVEEDORES ---");
        if (contadorProveedores == 0) {
            System.out.println("No hay proveedores registrados.");
            return;
        }
        for (int i = 0; i < contadorProveedores; i++) {
            System.out.println(proveedores[i]); // toString() ya incluye el ID
        }
    }

    public void listarProductos() {
        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        if (contadorProductos == 0) {
            System.out.println("No hay productos registrados.");
            return;
        }
        for (int i = 0; i < contadorProductos; i++) {
            System.out.println(productos[i]);
        }
    }

    public int getContadorProductos() {
        return contadorProductos;
    }

    public int getContadorProveedores() {
        return contadorProveedores;
    }
}
