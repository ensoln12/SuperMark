package superMark.entidad;

	public class ProductoCarrito extends Producto{
		
		private int cantidad;

		public ProductoCarrito(int id, String nombre, String marca, String categoria, String descripcion, int cantidad) {
			super(id, nombre, marca, categoria, descripcion);
			this.cantidad = cantidad;
		}

		public ProductoCarrito(String nombre, String marca, String categoria, String descripcion, double precio,
				int cantidad) {
			super(nombre, marca, categoria, descripcion, precio);
			this.cantidad = cantidad;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
		
		public void mostrar() {
			super.mostrar();
			System.out.println("Cantidad:"+this.cantidad);
		}

	}


