/**
 * 
 */
package superMark.entidad;

/**
 * @author Enzo
 * Clase que representa una entidad de tipo productos en la base de datos 
 */
public class Producto {
	
	private int id;
	private String nombre;
	private String marca;
	private String categoria;
	private String descripcion;
	private String fechaVencimiento;

	public Producto(String nombre, String marca, String categoria, String descripcion,
			String fechaVencimiento) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.fechaVencimiento = fechaVencimiento;
	}
	
	

	public Producto(int id, String nombre, String marca, String categoria, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.categoria = categoria;
		this.descripcion = descripcion;
	
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}



	public void mostrar() {
		System.out.println("Nombre: "+this.nombre);
		System.out.println("Marca: "+this.marca);
		System.out.println("Categporia: "+this.categoria);
		System.out.println("Descripcion: "+this.descripcion);
			
	}
	
	public boolean iguales(Producto p) {
		
		if(this.nombre.equalsIgnoreCase(p.getNombre())) {
			if(this.marca.equalsIgnoreCase(p.getMarca())) {
				if(this.categoria.equalsIgnoreCase(p.getCategoria())) {
					if(this.descripcion.equalsIgnoreCase(p.getDescripcion())) {
						return true;
					}
					else return false;
				}
				else return false;
			}
			else return false;
		}
		else return false;
	}
  
}
