package superMark.principal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import superMark.coneccion.ConnectionFactory;

public class CRUD {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	
   public CRUD() {
	   super();
	   this.con=null;
	   this.stmt=null;
	   this.rs=null;
		
	}

public Connection getCon() {
	return con;
}

public void setCon(Connection con) {
	this.con = con;
}

public Statement getStmt() {
	return stmt;
}

public void setStmt(Statement stmt) {
	this.stmt = stmt;
}

public ResultSet getRs() {
	return rs;
}

public void setRs(ResultSet rs) {
	this.rs = rs;
}

public boolean ConexionGenerada(){
	   boolean respuesta=true;
	   try {
			 this.con = ConnectionFactory.conectar();
			
			if (this.con!=null) {
				//System.out.println("La conexion ha sido un exito");				
                //System.out.println("Creando sentencia...");
                this.stmt=this.con.createStatement();
			}else {
				respuesta=false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return respuesta;
   }
   
   public String select(String query) {
	   
	   String string="";
	   try {
           
           this.rs=this.stmt.executeQuery(query);
           ResultSetMetaData rsmd=this.rs.getMetaData();
           
           while(rs.next()) {
        	   for(int i=1;i<=rsmd.getColumnCount();i++) {
        		   switch (rsmd.getColumnType(i)) {
        		      case 12:
        			      string=string+rs.getString(i);
        		      break;
        		      case 4:
        		    	  string=string+rs.getInt(i);
        		      break;
        		      case 93:
        		    	  string=string+rs.getDate(i);
        		      break;
        		      default:
        		    	  System.out.println("Tipo: "+rsmd.getColumnType(i));
        		   }
        		   if(i<rsmd.getColumnCount()) {
        		   
        		   string=string+",";
             	   }
        	   }
        	   string=string+";"; 
           }
			
       } catch (SQLException e) {
       	string="";
       }
	   return string;   
   }
   
   public boolean insert(String query){
	   
	   boolean respuesta=true;
	   try {
		this.stmt.executeUpdate(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block	
		respuesta=false;
	}
	   	   return respuesta;
   }
   
public boolean eliminar(String query){
	   
	   boolean respuesta=true;
	   try {
	   this.rs=this.stmt.executeQuery(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block	
		respuesta=false;
	}
	   	   return respuesta;
   }
   
   public boolean cerrar(){
	   
	   boolean respuesta=true;
	   try {
			if(this.stmt!=null)
				this.stmt.close();
		}catch(SQLException e){
			respuesta=false;
		}
	   
	   try {
			if(this.con!=null)
				this.con.close();
	   }catch (SQLException e){
			respuesta=false;
		}
	   
	   try {
	       if(this.rs!=null)
			this.rs.close();
	   }catch (SQLException e){
		   respuesta=false;
	       }
	    return respuesta;
   }
}


















