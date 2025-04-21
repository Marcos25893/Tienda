import java.util.ArrayList;
import java.util.List;
/**
 * @author Marcos
 * @version 1.1
 * @since 7.3
 * 
 * La clase Tienda gestiona un inventario de productos, permitiendo agregar productos,
 * venderlos aplicando descuentos, actualizar precios y stock, y calcular el valor total del inventario
 */
public class Tienda {
	private static final double DESCUENTO_25_PORCIENTO = 0.25;
	private static final double DESCUENTO_10_PORCIENTO = 0.10;
	private List <Producto> productos;
	
	public Tienda() {
		productos =new ArrayList<>();
	}
	
	// Añadir producto nuevo
	/**
	 * agregarProducto se encarga de crear un nuevo Producto y agregarlo
	 * a la lista de productos del inventario
	 * @param nombre es el nombre que tendra el producto
	 * @param precio es el precio del producto
	 * @param stock es la cantidad que habrar de ese producto
	 */
	public void agregarProducto (String nombre, double precio, int stock) {
		Producto producto= new Producto (nombre, precio, stock);
		productos.add(producto);
	}
	
	// Vender producto
	/**
	 * totalVenta se encarga de realizar una venta del producto, si no hay suficiente stock saltara
	 * mensaje de "Stock insuficiente", en cambio si hay stock aplica un descuento dependiendo
	 * del precio total de la venta, despues reduce el stock del producto y muesta el subtotal
	 * el descuento aplicacado y el total con el descuento aplicado
	 * @param nombreProducto es el nombre que tiene el producto que vamos a comprar
	 * @param cantidadVendida es la cantidad de ese producto que vamos a comprar
	 */
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
	                ventaPorPantalla(producto, total, descuento, totalConDescuento);
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

	private void ventaPorPantalla(Producto producto, double total, double descuento, double totalConDescuento) {
		System.out.println("Venta "+ producto.getNombre()+" realizada. ");
		System.out.println("Subtotal : " + total);
		System.out.println("Decuento aplicado: "+descuento);
		System.out.println("Total : " + totalConDescuento);
	}

	private double calculoDescuentoVenta(double total, double descuento) {
		return total - (total * descuento);
	}

	/**
	 * Muestra todos los productos que hay en el inventario, junto con su precio y la cantidad
	 * de stock
	 */
	public void mostrarInventario() {
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " - Precio: " + producto.getPrecio() + " - Stock: " + producto.getStock());
        }
    }
	
	
	 // Buscar producto por nombre
	/**
	 * Busca un producto por el nombre que le pasemos, si lo encuentra mostrara ese producto
	 * sino mostrara null
	 * @param nombre es el nombre del producto que queremos buscar
	 * @return devuelve el producto si lo encuentra o null si no lo encuentra
	 */
    public Producto buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
	
    // Actualizar precio de un producto
    /**
     * Si el producto se encuentra en el inventario se le pone un nuevo precio
     * @param nombre es nombre del producto al que vamos a cambiar el precio
     * @param nuevoPrecio es el precio nuevo que tendra el producto
     */
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
    /**
     * Si encuentra el producto aumenta el stock del producto que le pasemos, y añade al inventario
     * la cantidad que le pasemos que le pasemos
     * @param nombre es el nombre del producto que vamos a reponer
     * @param cantidad es el cantidad que va a aumentar de stock
     */
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
    /**
     * Calcula el valor total que hay en el inventario, multiplicando cada producto por la cantidad
     * que hay en stock y por su precio y sumandolo
     * @return devuelve el precio total que hay en el inventario
     */
    public double precioTotalStock() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getStock();
        }
        return total;
    }
	
}//fin clase

