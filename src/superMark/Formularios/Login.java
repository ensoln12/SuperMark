package superMark.Formularios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import superMark.entidad.Usuarios;
import superMark.principal.CRUD;

public class Login{
	
	private String email;
    
	public Usuarios Loguear() throws IOException, ClassNotFoundException {
		
		boolean respuesta=true;
	    String clave;
	    String resultado="";
	    Usuarios usuario = null;

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("*************************************************");
		System.out.println("******************INICIAR SESION*****************");
		System.out.println("*************************************************");
	    System.out.println("(*)Campos Obligatorios");
	    System.out.println();
	    
        System.out.print("Email *: ");
        email=lector.readLine();
        
        System.out.print("Clave *: ");
        clave=lector.readLine();
        System.out.println(); 
        System.out.println("*************************************************"); 
		 
		CRUD crud=new CRUD();
		
		if(crud.ConexionGenerada()==false) {
			
			System.out.println("Error de conexion");
			
		} else {
			resultado=crud.select("select clave from Usuarios where email='"+email+"';");
			
			if (resultado.length()==0) {
				
				System.out.println("El Usuario: "+email+" no se encuentra registrado. Registrese");			
				}
			else {
				
				resultado=resultado.substring(0,resultado.length()-1);
				
				if (resultado.equalsIgnoreCase(clave)) {
					System.out.println("BIENVENIDO A SUPERMARK");
					usuario=new Usuarios(email,clave);
				}
				else 
					System.out.println("la clave no corresponde al usuario "+email);
				
			}
				
			}
		return usuario;
	} 
	
	public boolean esAdministrador() {
		boolean respuesta=true;
		
                    CRUD crud=new CRUD();
		
		if(crud.ConexionGenerada()==false) {
			
			System.out.println("Error de conexion");
		}
		String resultado=crud.select("select legajo from clientes where email='"+email+"';");
		resultado=resultado.substring(0,resultado.length()-1);
		
		if (resultado.equalsIgnoreCase("null")) {
			respuesta=false;
		}
		
		return respuesta; 
	}

}
