package superMark.Formularios;

import java.util.ArrayList;

import superMark.entidad.Usuarios;
import superMark.principal.CRUD;

public class MiCuenta {
		
		private Usuarios usuario;
		private Carrito carrito;
		
		private ArrayList <Carrito> historial;
		
		public MiCuenta(Usuarios usuario) {
			// TODO Auto-generated constructor stub
			this.usuario=usuario;
			this.carrito=new Carrito();
			obtenerHistorial();
			
		}
		
		private void obtenerHistorial() {
			CRUD crud=new CRUD();
			if(crud.ConexionGenerada()) {
				
				String r=crud.select("select ventas.idVentas,ventas.fecha,productos.nombre,productos.precio,detalle_venta.cantidad from clientes inner join ventas using (idCliente) inner join detalle_venta using (idVenta)\r\n"
						+ "inner join productos using(idProducto) where idCliente"+crud.select("select idCliente from Clientes where email='"+this.usuario.getEmail())+"';");
				if(r.equalsIgnoreCase("")) {
					System.out.println("No hay nada para mostrar");
				}
				else {
						String [] registros=r.split(";");
						String [] registro;
						String [] registro2;
						this.historial=new ArrayList<Carrito>();
						int i=0;
						
						
						while(i<registros.length) {
							
							registro=registros[i].split(",");
							registro2=registros[i+1].split(",");
							
							//this.historial.add(new Carrito(Integer.parseInt(registro[0]),registro[1]));
							
							//while(registro[0].equalsIgnoreCase()) {
								
							}
						}
				}
			}
		//}

	}


//}
