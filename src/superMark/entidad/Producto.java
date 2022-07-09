/**
 * 
 */
package superMark.entidad;

import superMark.principal.CRUD;

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
	private double precio;
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto(String nombre, String marca, String categoria, String descripcion, double precio) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.precio = precio;
		
	}
	public Producto(int id,String nombre, String marca, String categoria, String descripcion) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.marca = marca;
		this.categoria = categoria;
		this.descripcion = descripcion;
		
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
	public void mostrar() {
		System.out.println("Nombre: "+this.nombre);
		System.out.println("Marca: "+this.marca);
		System.out.println("Categporia: "+this.categoria);
		System.out.println("Descripcion: "+this.descripcion);
		System.out.println("Preio:$"+this.precio);
	}	
	
	public int getId() {
		return this.id;
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
  

public int StockActual(Producto p) {
	   
	   int actualStock=0;
	         
     CRUD crud=new CRUD();
		
		if(crud.ConexionGenerada()) {
			String resultado=crud.select("select idProductos, stock from Productos where nombre='"+p.getNombre()+"', marca='"+p.getMarca()+"',categoria'"+p.getCategoria()+"',descripcion='"+p.getDescripcion()+"';");
			
          if (resultado.length()!=0) {					
        	  resultado=resultado.substring(0,resultado.length()-1);
  				actualStock=Integer.parseInt(resultado);
  			}			
	    }	    	
 
		return actualStock;
}
}
