/**
 * 
 */
package superMark.entidad;

import java.time.LocalDateTime;

/**
 * @author grupo3
 * Clase que representa una entidad de tipo ventas en la base de datos
 */
public class Ventas {
     private int idVentas;
     private Clientes Cliente;
     private LocalDateTime fechaVenta;
	/**
	 * @return the idVentas
	 */
	public int getIdVentas() {
		return idVentas;
	}
	/**
	 * @param idVentas the idVentas to set
	 */
	public void setIdVentas(int idVentas) {
		this.idVentas = idVentas;
	}
	/**
	 * @return the cliente
	 */
	public Clientes getCliente() {
		return Cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Clientes cliente) {
		Cliente = cliente;
	}
	/**
	 * @return the fechaVenta
	 */
	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}
	/**
	 * @param fechaVenta the fechaVenta to set
	 */
	public void setFechaVenta(LocalDateTime fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
}
