package superMark.Formularios;

import java.util.ArrayList;
import java.util.Scanner;

import superMark.entidad.Producto;
import superMark.entidad.ProductoStock;
import superMark.principal.CRUD;

public class AltaProducto {
	
	public boolean DarAlta(){
		boolean respuesta=true;

		String [] campos = {"Nombre *: ", "Marca*: ","Categoria*: ", "Descripcion*: ", "precio*: ","Stock*: ","Costo*: "}; 
		String [] datos = new String[7];
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Formulario de Registro de un Nuevo Producto");

		for(int i=0;i<campos.length;i++) {
			System.out.println(campos[i]);
			datos[i]=lector.nextLine();;
		    
		}
		
		ProductoStock nuevoProductoStock=new ProductoStock(datos[0], datos[1], datos[2], datos[3], Double.parseDouble(datos[4]), Integer.parseInt(datos[5]), Double.parseDouble(datos[6]));
		
		CRUD crud=new CRUD();
		
		if(crud.ConexionGenerada()) {
			
			String resultado=crud.select("select idProductos,nombre,marca,categoria,descripcion from Productos;");
			
			String [] registros=resultado.split(";");
			ArrayList<Producto> productoStocks=new ArrayList<Producto>();
			
			for(int i=0;i<registros.length;i++) {
				String [] registro=registros[i].split(",");
				
				productoStocks.add(new Producto(Integer.parseInt(registro[0]),registro[1],registro[2],registro[3],registro[4]));
				}
						
			int i=0;
			while(i<productoStocks.size() && nuevoProductoStock.iguales(productoStocks.get(i))==false) {
				i++;
			}
			if(i>productoStocks.size()) {
				System.out.println("El producto ya se encuentra registrado el codigo es "+productoStocks.get(i).getId());
			}
			else {
				if(crud.insert(nuevoProductoStock.creaQueryInsert())) {
					System.out.println("El producto fue ingresado con existo");
					System.out.println("¿Desea seguir ingresando?[s(si)/n(no)]");
					
					if(new Scanner(System.in).nextLine().equalsIgnoreCase("s")) {
						DarAlta();
					
			       }
				}
			}
		}
		else {
				respuesta=false;
				System.out.println("Error en la conexion");
		}
		
		return respuesta;
	}
	
}



