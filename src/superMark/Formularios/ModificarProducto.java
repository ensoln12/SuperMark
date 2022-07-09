package superMark.Formularios;

import superMark.entidad.Producto;
import superMark.principal.CRUD;

/**public class ModificarProducto {
	
	public boolean ActualizarStock() {
		
		boolean respuesta=true;
        
        Producto producto = new Producto();        
        CRUD crud=new CRUD();
		ControlarStock controlStock=new ControlarStock();
		if(crud.ConexionGenerada()) {
			
			String resultado=crud.select("UPDATE Productos SET disponible=1 WHERE controlStock.StockActual()");			
             if (resultado.length()!=0) {
				
            	 //controlStock.StockActual([1])=ControlStock.StockActual()[1]+1;
            	  
				}
		  }
	
	    return respuesta;
	

	}
}*/
