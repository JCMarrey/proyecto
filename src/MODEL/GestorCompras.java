package MODEL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.ArrayList;

public class GestorCompras {
    public static void main(String[] args) {

        byte respuesta=0;
        boolean bandera =false;
        GestorCompras llamar = new GestorCompras();
        Scanner leer = new Scanner(System.in);
        do{
            
            System.out.println("-----Gestor compras-----");
            System.out.println("[1]Realizar venta");
            System.out.println("[2]Salir");
            System.out.println("Tu seleccion: ");respuesta = leer.nextByte();
           
            switch (respuesta){
                case 1:llamar.Venta(leer);break;
                case 2:bandera=true;break;
                default:bandera=true;break;
            }
        }while(bandera==false);        
    }
    
    public void Venta(Scanner leer){
    
        ArrayList<Producto> ticket = new ArrayList<>();
        
        byte respuesta=0;
        boolean bandera=false;
             
        Connection conexion = null;
        Statement sentencia = null;
        
        try{
            conexion = BDConnection.getCon(false);
            sentencia = conexion.createStatement();
            sentencia.executeQuery("BEGIN");
        }catch(SQLException error){
            System.err.println("Error de conexion..");
            error.printStackTrace();
        }catch (Exception error){
            error.printStackTrace();
        }       

        do{
            System.out.println("-----Seleciona una opcion-----");
            System.out.println("[1]Agregar Producto a la venta");
            System.out.println("[2]Finalizar venta");
            System.out.println("[3]Cancelar venta");
            System.out.print("Tu seleccion: ");respuesta = leer.nextByte();
            
            switch(respuesta){
                case 1: {

                    int id_UpdateThisProduct;
                    int numProductosVendidos;
                    System.out.println("Ingresa el ID del producto: ");id_UpdateThisProduct = leer.nextInt();
                    System.out.println("Ingresa la cantidad de productos de este tipo: ");numProductosVendidos = leer.nextInt();

                    /*-----------------------------------*/
                    ResultSet resultSet = null;
                    int Cantidad_Modificar=0;
                    try{
                        sentencia = conexion.createStatement();
                        resultSet=sentencia.executeQuery("SELECT Existencia FROM Inventario "
                        + "WHERE idProducto = +"+id_UpdateThisProduct);

                        resultSet.next();
                        Cantidad_Modificar=resultSet.getInt(1);

                        Cantidad_Modificar=Cantidad_Modificar-numProductosVendidos;
                    }catch(SQLException error){
                        System.err.println("Error de conexion...");
                        error.printStackTrace();
                    }catch (Exception error){
                        error.printStackTrace();
                    }
                    /*-----------------------------------*/        
                    try{
                        
                        sentencia = conexion.createStatement();
                        sentencia.executeUpdate("UPDATE Inventario SET Existencia = '"+Cantidad_Modificar+"'WHERE idProducto ='"+id_UpdateThisProduct+"'");
                    }catch(SQLException error){
                        System.err.println("Error de conexion...");
                        error.printStackTrace();
                    }catch (Exception error){
                        error.printStackTrace();
                    }
                    break;
                } 
                case 2:{
                    try{
                        sentencia.executeQuery("COMMIT");
                    }catch(SQLException error){
                        System.err.println("Error de conexion..");
                        error.printStackTrace();
                    }catch (Exception error){
                        error.printStackTrace();
                    }finally{
                        try{
                            sentencia.close();
                            conexion.close();
                        }catch(Exception error){
                            System.err.println("Error");
                        }
                    }       
                    bandera=true; 
                    break;
                }
                case 3:{
                    try{
                      
                        sentencia = conexion.createStatement();
                        sentencia.executeQuery("ROLLBACK");
                    }catch(SQLException error){
                        System.err.println("Error de conexion..");
                        error.printStackTrace();
                    }catch (Exception error){
                        error.printStackTrace();
                    }finally{
                        try{
                            sentencia.close();
                            conexion.close();
                        }catch(Exception error){
                            System.err.println("Error");
                        }
                    }       
                    bandera=true; 
                    break;
                }
                default:{
          
                    try{
          
                        sentencia = conexion.createStatement();
                        sentencia.executeQuery("ROLLBACK");
                    }catch(SQLException error){
                        System.err.println("Error de conexion..");
                        error.printStackTrace();
                    }catch (Exception error){
                        error.printStackTrace();
                    }finally{
                        try{
                            sentencia.close();
                            conexion.close();
                        }catch(Exception error){
                            System.err.println("Error");
                        }
                    }       
                    bandera=true; 
                    break;
                
                
                }
            }
        }while(bandera==false);
    }
}
