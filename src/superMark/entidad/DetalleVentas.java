/**
 * 
 */
package superMark.entidad;

/**
 * @author grupo3
 * Clase que representa una entidad de tipo detale de ventas en la base de datos
 */
public class DetalleVentas {

	
	private Ventas venta;
	private int cantidad;
	

	public Ventas getVenta() {
		return venta;
	}

	public void setVenta(Ventas venta) {
		this.venta = venta;
	}
	
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
