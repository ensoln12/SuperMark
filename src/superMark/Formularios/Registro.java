package superMark.Formularios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import superMark.entidad.Clientes;
import superMark.entidad.Usuarios;
import superMark.principal.CRUD;

public class Registro {
	    
	public boolean Registrarse() throws IOException{
		
		     boolean respuesta=true;
		     String nombre;
		     String apellido;
		     String dni;
		     String telefono;
		     String domicilio;
		     String email;
		     String clave;
		   
		    
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("************************************************");
		System.out.println("******************REGISTRARSE*******************");
	    System.out.println("************************************************");  
	    System.out.println("(*)Campos Obligatorios");
	    System.out.println();
	     
		System.out.print("Nombre *: ");
		nombre = lector.readLine();
		
		System.out.print("Apellido *: ");
		apellido = lector.readLine();
		
		System.out.print("DNI *: ");
		dni = lector.readLine();
		
		System.out.print("Telefono *: ");
        telefono=lector.readLine();
        
        System.out.print("Domicilio *:");
        domicilio=lector.readLine();
        
        System.out.print("Email *: ");
        email=lector.readLine();
        
        System.out.print("Clave *: ");
        clave=lector.readLine();
		
		System.out.println("************************************************"); 
		
		if(validarCampos(nombre,apellido,dni,telefono,domicilio,email,clave)) {
			
			CRUD crud=new CRUD();
			
			if(crud.ConexionGenerada()) {
				
				String resultado=crud.select("select email from Clientes where email='"+email+"';");
				
				if (resultado.length()==0) {
					
					Clientes nuevoCliente=new Clientes(nombre,apellido,dni,telefono,domicilio,email,clave);
					
					Usuarios usuario=new Usuarios(email, clave);
					
					if(crud.insert(nuevoCliente.creaQueryInsert())) {
						
						crud.insert(usuario.creaQueryInsert());
						
						System.out.println("Felicidades usted ya es usuario de SuperMark...");
						System.out.println("Usuario registrado Ingrese");
					    crud.cerrar();
					}
					else 
						System.out.println("Error al intentar registrarse. Intente nuevamente mas tarde...");
			   }
			   else
						System.out.println("El email ingresado ya se encuentra registrado. Ingresa con tu cuenta");						
					}
			else System.out.println("Error en la conexion");
				}
			
        return respuesta;
		
	}   
	
	
	
    private boolean validarCampos(String nombre, String apellido, String dni, String telefono, String domicilio, String email, String clave)
    {
		boolean respuesta=true;
		Pattern pat;
		Matcher mat;
		boolean cadena=false;
		
		if(nombre.length()==0) {
			System.out.println("Campo obligatorio ingrese su nombre");
		}else {		
			pat = Pattern.compile("[A-Z][a-zA-Z]*");   
		    mat = pat.matcher(nombre);
		    if(!mat.find()){
		          respuesta=false;
		          System.out.println("Ingreso algun caracter incorrecto primera letra del nombre con mayuscula");
	             }		
             	}
		
		if(apellido.length()==0) {
			System.out.println("Campo obligatorio ingrese su apellido");
		}else {
			pat = Pattern.compile("[A-Z][a-zA-Z]*");   
		    mat = pat.matcher(apellido);
		    if(!mat.find()){
		          respuesta=false;
		          System.out.println("Ingreso algun caracter incorrecto primera letra del apellido con mayuscula");
	                      }			
             	}
		
		if(dni.length()==0) {
			System.out.println("Campo obligatorio ingrese su dni");
		}else {
			cadena=dni.matches("[0-9]+");
			if(!cadena) {
				respuesta=false;
		          System.out.println("Ingreso algun caracter incorrecto el dni solo admite numeros");
			}		
		}	
		
		if(telefono.length()==0) {
			System.out.println("Campo obligatorio ingrese su telefono");
		}else {  
			cadena=telefono.matches("[0-9]+");
			if(!cadena) {
				respuesta=false;
		          System.out.println("Ingreso algun caracter incorrecto el telefono solo admite numeros");
			}		
		}	
		
		if(domicilio.length()==0) {
			System.out.println("Campo obligatorio ingrese su domicilio");
		}else {
			pat = Pattern.compile("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z0-9]+)+\\s+\\d");   
		    mat = pat.matcher(domicilio);
		    if(!mat.find()){
		          respuesta=false;
		          System.out.println("Ingreso algun caracter incorrecto el domicilio solo admite letras");
	                      }			
             	}
		
		if(email.length()==0) {
			System.out.println("Campo obligatorio ingrese su email");
		}else {
			pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");   
		    mat = pat.matcher(email);
		    if(!mat.find()){
		          respuesta=false;
		          System.out.println("Ingreso algun caracter incorrecto el email");
	                      }			
             	}
		
		if(clave.length()==0) {
			System.out.println("Campo obligatorio ingrese su clave");
		}else {
			pat = Pattern.compile("^[A-Za-z0-9]\\w{7,11}$");   
		    mat = pat.matcher(clave);
		    if(!mat.find()){
		          respuesta=false;
		          System.out.println("Ingreso algun caracter incorrecto en la clave admite letras, numeros y guion bajo debe contener de 8 a 12 caracteres");
	                      }			
             	}		
		
		return respuesta;
       }
	
}




















