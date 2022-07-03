package superMark.Formularios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import superMark.entidad.Producto;
import superMark.entidad.ProductoStock;
import superMark.principal.CRUD;

public class AltaProducto {
	
	public boolean DarAlta() throws IOException {
		boolean respuesta=true;

		String [] campos = {"Nombre *: ", "Marca*: ","Categoria*: ", "Descripcion*: ","FechaVencimiento AAAA-MM-DD: ","Stock*: ","Costo*: ","PrecioVenta*: "}; 
		String [] datos = new String[8];
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Formulario de Registro de un Nuevo Producto");

		for(int i=0;i<campos.length;i++) {
			System.out.println(campos[i]);
			datos[i]=lector.readLine();;
		    
		}
		
		ProductoStock nuevoProductoStock=new ProductoStock(datos[0], datos[1], datos[2], datos[3], datos[4], Integer.parseInt(datos[5]), Double.parseDouble(datos[6]), Double.parseDouble(datos[7]));
		CRUD crud=new CRUD();
		
		if(crud.ConexionGenerada()) {
			String resultado=crud.select("select idProducto,nombre,marca,categoria,descripcion from Productos;");
			
			String [] registros=resultado.split(";");
			ArrayList<Producto> productoStocks=new ArrayList<Producto>();
			
			for(int i=0;i<registros.length;i++) {
				String [] registro=registros[i].split(",");
				productoStocks.add(new Producto(Integer.parseInt(registro[0]),registro[1],registro[2],registro[3],registro[4]));
			}			
			
	     }
		else {
			System.out.println("Error en la conexion");
	    }
		return respuesta;
	}
}
