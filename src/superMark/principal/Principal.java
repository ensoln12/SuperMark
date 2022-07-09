package superMark.principal;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import superMark.Formularios.AltaProducto;
import superMark.Formularios.Login;
import superMark.Formularios.Registro;
import superMark.entidad.Administrador;
import superMark.entidad.Usuarios;

/**
 * 
 * @author Grupo3
 *Clase principal para probar la conexion a la base de datos 
 */

public class Principal { 
	

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub}
		
		Scanner entrada= new Scanner(System.in);
		boolean salir=false;  
		int opcion; 
		System.out.println("************************************************");
		System.out.println("******************SUPERMARK*********************");
	    System.out.println("************************************************");  
	    System.out.println();
		while (!salir) {
			  
		   System.out.println("1- Iniciar Sesion");
		   System.out.println("2- Registrarse");
	       System.out.println("3- Salir");
	       System.out.println(); 
	       System.out.println("************************************************"); 
		   try {
			  		   
		   System.out.print("Ingresa una opcion ");
		   opcion=entrada.nextInt();
			
		   switch (opcion){
		   case 1:
			   Login login=new Login();
			   login.Loguear();
			   
		       if(login.esAdministrador()) {
		    	   Administrador administrador=new Administrador();
			    	 if(administrador.Administrar()) {
			    	 
					 boolean abandonar=false;  
					 int item; 
						   
				     while (!abandonar) {
				     System.out.println(); 		  
					 System.out.println("1- Alta de Producto");
					 System.out.println("2- Modificar Producto");
					 System.out.println("3- Eliminar Producto");
					 System.out.println("4- Consultar Cliente");
					 System.out.println("5- Salir");
					 System.out.println(); 
					 System.out.println("**************************************************");
					 try {
							  		   
					 System.out.println("Ingresa una opcion");
					 item=entrada.nextInt();
							
					 switch (item){
							case 1:
								 AltaProducto productoAlta=new AltaProducto();
						    	 productoAlta.DarAlta();
						         System.out.println(); 
								 System.out.println("************************************************"); 
							break;
							case 2:
							
							break;
							case 3:
							break;
							case 4:
							break;
							case 5:
							
							    abandonar=true;
							    
							break;
							    default:
							    System.out.println("La opcion no es correcta ingresa una opcion entre 1 y 7");
									
							}
				       		
						        }catch (InputMismatchException e) {
							  
							    System.out.println("Debes insertar un numero");								     	  
						    }  
					        }
			    	 }else {
			    		 System.out.println("Verifique he ingrese nuevamente");
			    	 } 
		      }else {
		    	   
		    	   boolean bandera=false;  
			       int op;
			       
			       while (!bandera) {
			    	    System.out.println();       
					    System.out.println("1- Comprar");
						System.out.println("2- Mi Cuenta");
						System.out.println("3- Mi Carrito");
						System.out.println("3- Mis compras");
						System.out.println("0- Salir");
						System.out.println(); 
						System.out.println("************************************************");
					try {
						  		   
					System.out.println("Elige una opcion");
					op=entrada.nextInt();
						
					switch (op){
					    case 1:
							
					    break;
							
					    case 2:
					       
                           // System.out.println("Usuario: "+usuario.getEmail);
					    	 
					    break;	 
							
					    case 3:
					    	 
					    break;	
					    case 4:
					    	 
					    break;	
					    case 0:
							
					    bandera=true;
					
				        break;
					    default:
					    System.out.println("La opcion no es correcta ingresa una opcion entre 1 y 4");
								
					}
			       		
					    }catch (InputMismatchException e) {
						  
				        System.out.println("Debes insertar un numero");
						  
				        entrada.next();		  
					}  
			    	}
		       }
		       

			break;
		      
			case 2:
				
		        Registro registro=new Registro();
		        registro.Registrarse();
		        
		    break;	
		    
			case 3:
				
			    salir=true;
			    System.out.println("Ud esta saliendo de SuperMArk...");
			    break;
			    default:
			    System.out.println("La opcion no es correcta ingresa una opcion entre 1 y 3");				
			}       		
		        }catch (InputMismatchException e) {
			  
			    System.out.println("Debes insertar un numero");
			  
			entrada.next();		  
		   }		  
	       }   
       entrada.close();
	}
	
	public static void limpiarPantalla() {
		 System.out.print("\033[H\033[2J");
	     System.out.flush();
	}
	
	
}





