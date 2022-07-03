package superMark.Formularios;

import java.time.LocalDate;

import superMark.entidad.Producto;
import superMark.entidad.ProductoStock;
import superMark.principal.CRUD;

public class EliminarProducto {
	
	CRUD crud=new CRUD();
	
	public boolean Eliminar() {
		boolean respuesta=true;
		
		if(crud.ConexionGenerada()) {
			int iD=BuscarId();
			String sql="DELETE FROM Productos WHERE idProducto ="+iD;
			boolean resultado=crud.eliminar(sql);
			
			ProductoStock producto=new ProductoStock(nombre, marca, categoria, descripcion, fechaVencimiento, stock, costo, precioVenta);
				
			    crud.cerrar();
			}
		
		
		return respuesta;
	
	}
	
	
	public int BuscarId() {
		int id=0;
		
		if(crud.ConexionGenerada()) {
			String actualFecha=fechaActual()+"";
			String resultado=crud.select("select idProducto from Productos where fechaVencimiento='"+actualFecha+"';");
              if (resultado.length()!=0) {
            	  
            	resultado=resultado.substring(0,resultado.length()-1);	
				id=Integer.parseInt(resultado);
			 }		
			
	     }
		else {
			System.out.println("Error en la conexion");
	    }
		
		
		return id;
	}
	
	public LocalDate fechaActual() {
		
		LocalDate fechaActual= LocalDate.now(); 
		return fechaActual;
	}


}
