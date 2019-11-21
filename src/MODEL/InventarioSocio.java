package MODEL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class InventarioSocio {

    public static void main(String[] args) {
        
        Scanner leer= new Scanner(System.in);
        byte respuesta=0;
        boolean bandera = false;
        
        do{
            System.out.println("-----Selecciona el filtro para tu busqueda-----");
            System.out.println("[1]Busqueda por nombre");
            System.out.println("[2]Ordenados A->Z");
            System.out.println("[3]Ordenados Z->A");
            System.out.println("[4]Ordenados por ID Decendiente");
            System.out.println("[5]Ordenados por ID Ascendente");
            System.out.println("[6]Mayor a menor precio");
            System.out.println("[7]Menor a mayor precio");
            System.out.println("[8]Salir");
            System.out.println("Tu seleccion: ");respuesta=leer.nextByte();leer.nextLine();

            switch(respuesta){
                case 1: BuscarNombre(leer);break;
                case 2: OrdenA_Z( leer);break;
                case 3: OrdenZ_A(leer);break;
                case 4: OrdenIDDescendente(leer);break;
                case 5: OrdenIDAscendente(leer);break;
                case 6: OrdenMayorAMenorPrecio(leer);break;
                case 7: OrdenMenorAMayorPrecio(leer);break;
                case 8: bandera=true;break;
                default:bandera=true;break;
            }
        }while(bandera==false);
        
        
    }
    public static void BuscarNombre(Scanner leer){
        
        String nombre="";
        System.out.println("-----Buscar Producto-----");
        System.out.println("Ingresa el nombre del producto: ");nombre = leer.nextLine();  
        
        
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultSet = null;
        
        try{
            conexion = BDConnection.getCon(true);
            sentencia = conexion.createStatement();
            resultSet=sentencia.executeQuery("SELECT* FROM Inventario WHERE Nombre ='"+nombre+"'");
            
            resultSet.next();
            ResultSetMetaData metaDatos = resultSet.getMetaData();
            int numCols = metaDatos.getColumnCount();
            System.out.println("\t\t\t\t\t-----Resultado de la busqueda-----");
            for(int i=1;i<=numCols;i++){
                System.out.printf("%-8s\t\t",metaDatos.getColumnName(i));
            }
            System.out.println("");
                for(int i=1;i<=numCols;i++){
                    System.out.printf("%-8s\t\t",resultSet.getObject(i));
                }
                System.out.println("");


        }catch(SQLException error){
            System.out.println("*****No existe ningun articulo con el nombre: '"+nombre+"'*****");
        }catch (Exception error){
            error.printStackTrace();
        }finally{
            try{
               resultSet.close();
                sentencia.close();
                conexion.close();
            }catch(Exception error){
                System.err.println("Error");
            }
        }        
    }
    
    public static void OrdenA_Z(Scanner leer){
        
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultSet = null;
        try{
            conexion = BDConnection.getCon(true);
            sentencia = conexion.createStatement();
            resultSet=sentencia.executeQuery("SELECT* FROM Inventario ORDER BY Nombre");
             ResultSetMetaData metaDatos = resultSet.getMetaData();
             int numCols = metaDatos.getColumnCount();
             System.out.println("\t\t\t\t\t-----Inventario BlackPanthers-----");
             for(int i=1;i<=numCols;i++){
                 System.out.printf("%-8s\t\t",metaDatos.getColumnName(i));
             }
             System.out.println("");
             while(resultSet.next()){
                 for(int i=1;i<=numCols;i++){
                     System.out.printf("%-8s\t\t",resultSet.getObject(i));
                 }
                 System.out.println("");
             }
        }catch(SQLException error){
            System.err.println("Error de conexion..");
            error.printStackTrace();
        }catch (Exception error){
            error.printStackTrace();
        }finally{
            try{
               resultSet.close();
                sentencia.close();
                conexion.close();
            }catch(Exception error){
                System.err.println("Error");
            }
        }  
    }
    
    public static void OrdenZ_A(Scanner leer){
        
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultSet = null;
        try{
            conexion = BDConnection.getCon(true);
            sentencia = conexion.createStatement();
            resultSet=sentencia.executeQuery("SELECT* FROM Inventario ORDER BY Nombre DESC");
             ResultSetMetaData metaDatos = resultSet.getMetaData();
             int numCols = metaDatos.getColumnCount();
             System.out.println("\t\t\t\t\t-----Inventario BlackPanthers-----");
             for(int i=1;i<=numCols;i++){
                 System.out.printf("%-8s\t\t",metaDatos.getColumnName(i));
             }
             System.out.println("");
             while(resultSet.next()){
                 for(int i=1;i<=numCols;i++){
                     System.out.printf("%-8s\t\t",resultSet.getObject(i));
                 }
                 System.out.println("");
             }
        }catch(SQLException error){
            System.err.println("Error de conexion..");
            error.printStackTrace();
        }catch (Exception error){
            error.printStackTrace();
        }finally{
            try{
               resultSet.close();
                sentencia.close();
                conexion.close();
            }catch(Exception error){
                System.err.println("Error");
            }
        }          
    }
    
    public static void OrdenIDDescendente(Scanner leer){
        
        
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultSet = null;
        try{
            conexion = BDConnection.getCon(true);
            sentencia = conexion.createStatement();
            resultSet=sentencia.executeQuery("SELECT* FROM Inventario ORDER BY idProducto DESC");
             ResultSetMetaData metaDatos = resultSet.getMetaData();
             int numCols = metaDatos.getColumnCount();
             System.out.println("\t\t\t\t\t-----Inventario BlackPanthers-----");
             for(int i=1;i<=numCols;i++){
                 System.out.printf("%-8s\t\t",metaDatos.getColumnName(i));
             }
             System.out.println("");
             while(resultSet.next()){
                 for(int i=1;i<=numCols;i++){
                     System.out.printf("%-8s\t\t",resultSet.getObject(i));
                 }
                 System.out.println("");
             }
        }catch(SQLException error){
            System.err.println("Error de conexion..");
            error.printStackTrace();
        }catch (Exception error){
            error.printStackTrace();
        }finally{
            try{
               resultSet.close();
                sentencia.close();
                conexion.close();
            }catch(Exception error){
                System.err.println("Error");
            }
        }  
    }

    public static void OrdenIDAscendente(Scanner leer){

        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultSet = null;
        try{
            conexion = BDConnection.getCon(true);
            sentencia = conexion.createStatement();
            resultSet=sentencia.executeQuery("SELECT* FROM Inventario ORDER BY idProducto");
             ResultSetMetaData metaDatos = resultSet.getMetaData();
             int numCols = metaDatos.getColumnCount();
             System.out.println("\t\t\t\t\t-----Inventario BlackPanthers-----");
             for(int i=1;i<=numCols;i++){
                 System.out.printf("%-8s\t\t",metaDatos.getColumnName(i));
             }
             System.out.println("");
             while(resultSet.next()){
                 for(int i=1;i<=numCols;i++){
                     System.out.printf("%-8s\t\t",resultSet.getObject(i));
                 }
                 System.out.println("");
             }
        }catch(SQLException error){
            System.err.println("Error de conexion..");
            error.printStackTrace();
        }catch (Exception error){
            error.printStackTrace();
        }finally{
            try{
               resultSet.close();
                sentencia.close();
                conexion.close();
            }catch(Exception error){
                System.err.println("Error");
            }
        }
    }

    public static void OrdenMayorAMenorPrecio(Scanner leer){
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultSet = null;
        try{
            conexion = BDConnection.getCon(true);
            sentencia = conexion.createStatement();
            resultSet=sentencia.executeQuery("SELECT* FROM Inventario ORDER BY Precio DESC");
             ResultSetMetaData metaDatos = resultSet.getMetaData();
             int numCols = metaDatos.getColumnCount();
             System.out.println("\t\t\t\t\t-----Inventario BlackPanthers-----");
             for(int i=1;i<=numCols;i++){
                 System.out.printf("%-8s\t\t",metaDatos.getColumnName(i));
             }
             System.out.println("");
             while(resultSet.next()){
                 for(int i=1;i<=numCols;i++){
                     System.out.printf("%-8s\t\t",resultSet.getObject(i));
                 }
                 System.out.println("");
             }
        }catch(SQLException error){
            System.err.println("Error de conexion..");
            error.printStackTrace();
        }catch (Exception error){
            error.printStackTrace();
        }finally{
            try{
               resultSet.close();
                sentencia.close();
                conexion.close();
            }catch(Exception error){
                System.err.println("Error");
            }
        }    

    }

    public static void OrdenMenorAMayorPrecio(Scanner leer){

        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultSet = null;
        try{
            conexion = BDConnection.getCon(true);
            sentencia = conexion.createStatement();
            resultSet=sentencia.executeQuery("SELECT* FROM Inventario ORDER BY Precio");
             ResultSetMetaData metaDatos = resultSet.getMetaData();
             int numCols = metaDatos.getColumnCount();
             System.out.println("\t\t\t\t\t-----Inventario BlackPanthers-----");
             for(int i=1;i<=numCols;i++){
                 System.out.printf("%-8s\t\t",metaDatos.getColumnName(i));
             }
             System.out.println("");
             while(resultSet.next()){
                 for(int i=1;i<=numCols;i++){
                     System.out.printf("%-8s\t\t",resultSet.getObject(i));
                 }
                 System.out.println("");
             }
        }catch(SQLException error){
            System.err.println("Error de conexion..");
            error.printStackTrace();
        }catch (Exception error){
            error.printStackTrace();
        }finally{
            try{
               resultSet.close();
                sentencia.close();
                conexion.close();
            }catch(Exception error){
                System.err.println("Error");
            }
        } 
    }
    
}
