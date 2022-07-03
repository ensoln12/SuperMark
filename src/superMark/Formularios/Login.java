package superMark.Formularios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import superMark.principal.CRUD;

public class Login{
	

	public boolean Loguear() throws IOException, ClassNotFoundException {
		
		boolean respuesta=true;
	    String email;
	    String clave;
	   

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("***************************************************************");
		System.out.println("************************INICIAR SESION*************************");
		System.out.println("***************************************************************");
	    System.out.println("(*)Campos Obligatorios");
	    System.out.println();
	    
        System.out.print("Email *: ");
        email=lector.readLine();
        
        System.out.print("Clave *: ");
        clave=lector.readLine();
		
		 
		CRUD crud=new CRUD();
		
		if(crud.ConexionGenerada()==false) {
			
			System.out.println("Error de conexion");
		}
		else {
			String resultado=crud.select("select clave from usuarios where email='"+email+"';");
			if (resultado.length()==0) {
				
				System.out.println("El Usuario: "+email+" no se encuentra registrado. Registrese");			
				}
			else {
				
				resultado=resultado.substring(0,resultado.length()-1);
				
				if (resultado.equalsIgnoreCase(clave)) {
					System.out.println("BIENVENIDO A SUPERMARK");
				}
				else {
					System.out.println("la clave no corresponde al usuario"+email);
				}
			}
				
			}
		return respuesta;
	}     

}
