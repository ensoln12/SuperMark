package superMark.entidad;

import java.time.LocalDateTime;

public class Categorias {
	
	private int idCategoria;
	private String nombre;
	
	public Categorias(int idCategoria, String nombre) {
		
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
