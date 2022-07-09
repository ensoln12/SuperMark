package superMark.entidad;

public class Usuarios {
	
	private String email;
	private String clave;
	
	
	public Usuarios(String email, String clave) {
		
		this.email = email;
		this.clave = clave;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public void mostrar() {
		System.out.println("Tu Usuario es: "+this.email);
	}

    
	public String creaQueryInsert() {
		return "insert into Usuarios (email,clave) values ('"+this.email+"','"+this.clave+"');";
	}

}
