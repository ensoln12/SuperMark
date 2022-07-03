package superMark.entidad;

public class ProductoStock extends Producto{
    private int stock;
    private double costo;
    private double precioVenta;
    
	public ProductoStock(String nombre, String marca, String categoria, String descripcion, String fechaVencimiento, int stock,
			double costo, double precioVenta) {
		super(nombre, marca, categoria, descripcion,fechaVencimiento);
		this.stock = stock;
		this.costo = costo;
		this.precioVenta = precioVenta;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
    
	public void mostrar() {
		super.mostrar();
		System.out.println("Stock: "+this.stock);
		System.out.println("Costo: "+this.costo);
		System.out.println("Precio de Venta: "+this.precioVenta);
	}
	
	public String crearQueryInsert() {
		return"insert into Productos(nombre,marca,categoria.descripcion,fechaVencimiento,stock,costo,precioVenta)values('"+super.getNombre()+"','"+super.getMarca()+"','"+super.getCategoria()+"','"+super.getDescripcion()+"','"+super.getFechaVencimiento()+"',"+this.stock+","+this.costo+","+this.precioVenta+");";
	
	}
	public String creaQueryDelete() {
		return"delete into Productos(idProductos,nombre,marca,categoria,descripcion,fechaVencimiento,stock,costo,precioVenta)";
	}
}
