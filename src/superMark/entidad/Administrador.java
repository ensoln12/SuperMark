package superMark.entidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import superMark.principal.CRUD;

public class Administrador {

	public boolean Administrar() throws IOException {
		boolean respuesta=true;
	    String legajo;
	    
	   

		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
	    
        System.out.print("Ingrese Legajo : ");
        legajo=lector.readLine();
       
		
	CRUD crud=new CRUD();
	
	if(crud.ConexionGenerada()==false) {
		
		System.out.println("Error de conexion");
	}
	else {
		String resultado=crud.select("select legajo from clientes where legajo='"+legajo+"';");
		if (resultado.length()==0) {
			
			System.out.println("El Legajo N°: "+legajo+" no corresponde a un Administrador.");
			respuesta=false;
			}
		else {
			
			resultado=resultado.substring(0,resultado.length()-1);
			
			if (resultado.equalsIgnoreCase(legajo)) {
				System.out.println("Opciones de Administrador");
			}
			else {
				System.out.println("El legajo no corresponde a un Usuario");
				respuesta=false;
			}
		}
			
		
	
}
	return respuesta;
	
	
}
}
