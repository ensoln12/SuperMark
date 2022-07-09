package superMark.entidad;

import superMark.principal.CRUD;

/**public class ControlarStock {
	
        
	   public int[] StockActual() {
		   
		   int actualStock[]=new int [2];
		         
	        CRUD crud=new CRUD();
			
			if(crud.ConexionGenerada()) {
				String resultado=crud.select("select idProductos, stock from Productos nombre='"+producto.getNombre()+"', marca='"+producto.getMarca()+"',categoria'"+producto.getCategoria()+"',descripcion='"+producto.getDescripcion()+"';");
				
	             if (resultado.length()!=0) {					
	     				String [] registro=resultado.split(","); 
	     				actualStock[0]=Integer.parseInt(registro[0]);
	     				actualStock[1]=Integer.parseInt(registro[1]);
	     			}			
		    }	    	
	    
			return actualStock;
    }
}*/