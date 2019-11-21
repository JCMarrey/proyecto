/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODEL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juanm
 */


public class ejemplo {
    
   public ejemplo(){
       
   } 

    
   public void inserta(Connection conn,Statement stmt,String nombre,String apellidoP,String apellidoM,int edad,double telefono,String sex,String nombreU,String correo,float altura, int peso, float IMC, int idM){ 
      
    try {
      conn = Conectar.getCon();
      stmt = conn.createStatement();
      stmt.executeUpdate("INSERT INTO r VALUES('"+nombre+"','"+apellidoP+"','"+apellidoM+"',"+edad+","+telefono+",'"+sex+"','"+nombreU+"','"+correo+"',"+altura+","+peso+","+IMC+","+idM+")");
    } catch (SQLException e) {
      System.out.println("error: no se pudo conectar a base de datos");
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("error al ejecutar el comando de BD");
      e.printStackTrace();
    } finally {
      try {
        stmt.close();
        conn.close();
      } catch (SQLException e) {
      }
    
    }
    
}

   
   public void selecciona(Connection conn, Statement stmt, ResultSet resultSet){
       // para manejar los resultados

      try {
            conn = Conectar.getCon();
            //System.out.println("VALOR DE COON" + conn );
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT*FROM r");
            
            ResultSetMetaData metaDatos = resultSet.getMetaData();
            int numCols = metaDatos.getColumnCount();
            System.out.println( "Tabla nombreTabla de la BD nombreBD: \n");
            for(int i = 1; i<= numCols; i++)
                System.out.printf("%-8s\t",metaDatos.getColumnName(i));

            while(resultSet.next())
            {
                System.out.println();
                for(int i = 1; i<= numCols; i++)
                    
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                System.out.println(); 
            }        
            
        } catch (SQLException e) {
            System.out.println("error: no se pudo establecer conexión con BD");
        } catch (Exception e) {
            System.out.println("other error:");
        } finally {
        try {
            resultSet.close(); 
            stmt.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
} 
   
 public void busca(Connection conn, Statement stmt, ResultSet resultSet,String nombreU){
       // para manejar los resultados

      try {
            conn = Conectar.getCon();
            System.out.println("VALOR DE COON" + conn );
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT*FROM r WHERE NombreU='"+nombreU+"'");
            
            ResultSetMetaData metaDatos = resultSet.getMetaData();
            int numCols = metaDatos.getColumnCount();
            System.out.println( "Tabla nombreTabla de la BD nombreBD: \n");
            for(int i = 1; i<= numCols; i++)
                System.out.printf("%-8s\t",metaDatos.getColumnName(i));

            while(resultSet.next())
            {
                System.out.println();
                for(int i = 1; i<= numCols; i++)
                    
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                System.out.println(); 
            }        
            
        } catch (SQLException e) {
            System.out.println("error: no se pudo establecer conexión con BD");
        } catch (Exception e) {
            System.out.println("other error:");
        } finally {
        try {
            resultSet.close(); 
            stmt.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
}

public void elimina(Connection conn, String nombreU){

      Statement stmt = null;
      
    try {
      conn = Conectar.getCon();
      stmt = conn.createStatement();
      stmt.executeUpdate("DELETE FROM r WHERE NombreU='"+nombreU+"'");
    } catch (SQLException e) {
      System.out.println("error: no se pudo conectar a base de datos");
    } catch (Exception e) {
      System.out.println("error al ejecutar el comando de BD");
    } finally {
      try {
        stmt.close();
        conn.close();
      } catch (SQLException e) {
      }
    
    } 
 }

public void privilegioSocio(Connection conn, String nombreU){

      Statement stmt = null;
      
    try {
      conn = Conectar.getCon();
      stmt = conn.createStatement();
      stmt.executeUpdate("GRANT SELECT ON bp.r TO '"+nombreU+" '@'localhost'");
        System.out.println("PRIVILEGIOS");
    } catch (SQLException e) {
      System.out.println("error: no se pudo conectar a base de datos");
    } catch (Exception e) {
      System.out.println("error al ejecutar el comando de BD");
    } finally {
      try {
        stmt.close();
        conn.close();
      } catch (SQLException e) {
      }
    
    } 
 }



}