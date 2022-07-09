/**
 * 
 */
package superMark.entidad;
/**
 * @author grupo3
 * Clase que representa una entidad de tipo cliente en la base de datos
 */
public class Clientes {

	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String domicilio;
	private String email;
	private String clave;
	
	
	    public Clientes(String nombre, String apellido, String dni, String telefono, String domicilio, String email,String clave) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.email = email;
		this.clave = clave;
		
	}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getDomicilio() {
			return domicilio;
		}

		public void setDomicilio(String domicilio) {
			this.domicilio = domicilio;
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
		
		public String creaQueryInsert() {
			return "insert into Clientes (fecha,nombre,apellido,dni,telefono,domicilio,email,clave)values(Now(),'"+this.nombre+"','"+this.apellido+"','"+this.dni+"','"+this.telefono+"','"+this.domicilio+"','"+this.email+"','"+this.clave+"');";
	}


}
	
	

