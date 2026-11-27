# 253397_253387_RU1_CasoPractico4

Sistema de gestión de almacén en Java (consola) que usa arreglos de objetos para registrar proveedores y productos.

## Estructura

```
.
├── Main.java            # Menú principal y lectura validada de datos
├── SistemaAlmacen.java  # Arreglos de productos/proveedores y operaciones
├── Producto.java        # Entidad Producto
├── Proveedor.java       # Entidad Proveedor
├── .gitignore
└── README.md
```

## Funcionalidades

1. Registrar nuevo proveedor (ID automático: el mayor ID registrado + 1).
2. Registrar mercancía/producto (ID automático a partir de 101).
3. Cambiar el proveedor de un producto.
4. Generar el reporte "ENTRADA DE PRODUCTOS".
5. Salir.

## Compilar y ejecutar

```bash
javac -encoding UTF-8 *.java
java Main
```

> En la consola de Windows, si los acentos se ven mal (p. ej. `GESTIÃ“N`), ejecuta `chcp 65001` antes de `java Main`.

## Correcciones realizadas

- Las opciones 2 y 3 ya no truenan con `NumberFormatException` si se escribe texto en lugar de un número; ahora se vuelve a pedir el dato.
- Se valida que nombres, teléfono y empresa no estén vacíos.
- Se valida que el stock sea mayor que 0 y el precio mayor que 0 (acepta `12.5` o `12,5`).
- Se verifica la capacidad de los arreglos antes de pedir datos, y el ID consecutivo solo avanza si el registro fue exitoso.
- La opción 3 muestra la lista de productos antes de pedir el ID y distingue entre "producto no encontrado" y "proveedor no encontrado".
- `registrarProveedor` / `registrarProducto` rechazan `null` e IDs duplicados.
- `Producto.toString()` ya no lanza `NullPointerException` si no hay proveedor y muestra el precio con 2 decimales.
- El programa termina limpiamente si se cierra la entrada (Ctrl+Z / Ctrl+D) en lugar de lanzar `NoSuchElementException`.
- README convertido de UTF-16 a UTF-8 (el título estaba duplicado y se veía con caracteres raros en GitHub/editores).
- El siguiente ID de proveedor/producto lo calcula `SistemaAlmacen` a partir del mayor ID registrado (antes era un contador fijo en 3 que podía chocar con un ID existente y bloquear la opción 1 para siempre).
- El teléfono se valida: solo dígitos con espacios, guiones, paréntesis o `+` inicial, entre 7 y 15 dígitos.
- La opción 3 avisa si se elige el mismo proveedor que ya tenía el producto y da un mensaje distinto para cada error.
- `Proveedor.toString()` incluye el ID, así el reporte "ENTRADA DE PRODUCTOS" muestra qué proveedor surtió cada producto.
- El precio siempre se muestra con punto decimal, sin importar la configuración regional del equipo.
- La opción 2 verifica que exista al menos un proveedor antes de pedir datos (sin proveedores no se puede surtir mercancía).
