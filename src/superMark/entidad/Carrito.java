package superMark.entidad;

import java.util.ArrayList;

public class Carrito {
	
		private int id;
		private String fecha;
		private ArrayList <ProductoCarrito> productos;
		
		public Carrito() {
			this.productos=new ArrayList<ProductoCarrito>();
		}
		
		
		
		public Carrito(int id, String fecha) {
			super();
			this.id = id;
			this.fecha = fecha;
			this.productos = new ArrayList<ProductoCarrito>();
		}



		public void agregar(ProductoCarrito nuevo) {
			int acum=0;
				
			for(int i=0;i<this.productos.size();i++) {
				acum=acum+this.productos.get(i).getCantidad();
			}
			
			if(acum+nuevo.getCantidad()<=30) {
				this.productos.add(nuevo);
			}
			else System.out.println("Excede los 30 productos");
			
		}
		
		public void mostrar() {
			double total=0;
			
			if(this.productos.size()!=0) {
				for(int i=0;i<this.productos.size();i++) {
					this.productos.get(i).mostrar();
					total=total+this.productos.get(i).getCantidad()*this.productos.get(i).getPrecio();
				}
				System.out.println("Total:$"+total);
			}
			else System.out.println("Carrito Vacio...");
			
		}

	}

