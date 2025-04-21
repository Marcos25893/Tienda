import java.util.ArrayList;
import java.util.List;

public class Tienda {
	private static final double DESCUENTO_25_PORCIENTO = 0.25;
	private static final double DESCUENTO_10_PORCIENTO = 0.10;
	private List <Producto> productos;
	
	public Tienda() {
		productos =new ArrayList<>();
	}
	
	// Añadir producto nuevo
	public void agregarProducto (String nombre, double precio, int stock) {
		Producto producto= new Producto (nombre, precio, stock);
		productos.add(producto);
	}
	
	// Vender producto
	public void totalVenta(String nombreProducto, int cantidadVendida) {
	    boolean productoEncontrado = false;  // Variable para verificar si se encontró el producto
	    for (Producto producto : productos) {
	        	        
	        // Comprobamos si el nombre del producto coincide
	        if (producto.getNombre().equals(nombreProducto)) {
	            productoEncontrado = true;  // Marcamos que el producto fue encontrado
	            
	            // Verificamos si hay suficiente stock
	            if (producto.getStock() >= cantidadVendida) {
	                double total = producto.getPrecio() * cantidadVendida;
	                double descuento = 0;

	                // Aplicamos descuento según el total
	                boolean descuentoInicial = total >= 50 && total <= 100;
					if (descuentoInicial) {
	                    descuento = DESCUENTO_10_PORCIENTO;  // 10% de descuento
	                } else {
						boolean descuentoAvanzado = total > 100;
						if (descuentoAvanzado) {
						    descuento = DESCUENTO_25_PORCIENTO;  // 25% de descuento
						}
					}

	                // Calculamos el total con el descuento
	                double totalConDescuento = calculoDescuentoVenta(total, descuento);
	                
	                // Reducimos el stock del producto
	                producto.reducirStock(cantidadVendida);    
	                // Mostramos venta por pantalla
	                System.out.println("Venta "+ producto.getNombre()+" realizada. ");
	                System.out.println("Subtotal : " + total);
	                System.out.println("Decuento aplicado: "+descuento);
	                System.out.println("Total : " + totalConDescuento);
	            } else {
	                System.out.println("Stock insuficiente.");
	            }
	            break;  // Salimos del ciclo porque ya hemos procesado el producto
	        }
	    }
	    
	    // Si no se encontró el producto
	    if (!productoEncontrado) {
	        System.out.println("Producto "+nombreProducto +" no encontrado.");
	    }
	}

	private double calculoDescuentoVenta(double total, double descuento) {
		return total - (total * descuento);
	}

	public void mostrarInventario() {
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " - Precio: " + producto.getPrecio() + " - Stock: " + producto.getStock());
        }
    }
	
	
	 // Buscar producto por nombre
    public Producto buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
	
    // Actualizar precio de un producto
    public void actualizarPrecio(String nombre, double nuevoPrecio) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
            System.out.println("Precio actualizado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
	
    // Actualizar stock
    public void reponerStock(String nombre, int cantidad) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            producto.aumentarStock(cantidad);
            System.out.println("Stock actualizado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
	
    // Calcular valor total del inventario
    public double precioTotalStock() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getStock();
        }
        return total;
    }
	
}//fin clase

