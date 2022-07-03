package superMark.coneccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 /** @author grupo3
 * Clase que se encarga de realizar la configuracion, la coneccion 
 * y habilitar las transacciones de una base de datos
 */

public class ConnectionFactory {
	/**
	 * Objeto encargado de mantener la conexion
	*/ 
	
	private static Connection connection;
	/**
	 * Metodo que permite conectarse a la base de datos
	 * @return objeto Connection con la informacionde la base de datos conectada | null
	 * @throws ClassNotFoundException exepcion generada al no cargar el Driver conexion
	 * @throws SQLException exepcion generada al no conectarse a la base de datos 
	 */
	public static Connection conectar() throws ClassNotFoundException, SQLException{
		
		// paso 1- cargar el driver de conexion.
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		//paso 2- Establecer los datos de conexion
		String url="jdbc:mysql://localHost:3307/SuperMark";
		String user="root";
		String password="12julio83";

		// paso 3: Establecer la conexion
		
		connection= DriverManager.getConnection(url, user, password);
		
		return connection;
	}

}
