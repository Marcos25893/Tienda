/**
 * @author Marcos
 * @version 1.1
 * @since 7.3
 * 
 * La clase Producto crea un nuevo producto para añadirlo al inventario
 * a este producto se le pasa un nombre, el precio de ese producto
 * y la cantidad que va a haber en el inventario
 */
public class Producto {

	private String nombre;
	private double precio;
	private int stock;
	
	public Producto (String nombre, double precio, int stock) {
		this.nombre=nombre;
		this.precio=precio;
		this.stock=stock;
	}
	
	/**
	 * 
	 * @return devuelve el nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sirve para cambiar el nombre de un producto
	 * @param nombre es el nuevo nombre del producto
	 */
	public void setNombre (String nombre) {
		this.nombre=nombre;
	}
	
	/**
	 * 
	 * @return devuelve el precio de ese producto
	 */
	public double getPrecio () {
		return precio;
	}
	
	/**
	 * Sirve para cambiar el precio del producto
	 * @param precio es el nuevo precio del producto
	 */
	public void setPrecio (double precio) {
		this.precio=precio;
	}
	
	/**
	 * 
	 * @return devuelve la cantidad que hay de ese producto en el inventario
	 */
	public int getStock() {
		return stock;
	}
	
	/**
	 * Cambia la cantidad de ese producto en el inventario
	 * @param stock sera la nueva cantidad que hay de ese producto
	 */
	public void setStock(int stock) {
		this.stock=stock;
	}
	
	/**
	 * Reduce el stock que hay de ese producto dependiendo de la cantidad que le pasemos
	 * @param cantidad es la cantidad que reducira el stock
	 */
	public void reducirStock (int cantidad) {
		this.stock-=cantidad;
	}
	
	/**
	 * Aumenta el stock que hay de ese producto dependiendo de la cantidad que le pasemos
	 * @param cantidad es la cantidad que aumentara el stock
	 */
	public void aumentarStock (int cantidad) {
		this.stock+=cantidad;
	}
	
}
