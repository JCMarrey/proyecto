package MODEL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GestorInventario {
    
    public static void main(String[] args) {
        byte respuesta=0;
        boolean bandera =false;
        GestorInventario llamar = new GestorInventario();
        Scanner leer = new Scanner(System.in);
        do{
            
            System.out.println("-----Administrar Inventario-----");
            System.out.println("[1]Agregar Nuevo Producto");
            System.out.println("[2]Actualizar Existencias");
            System.out.println("[3]Consultar Producto");
            System.out.println("[4]Eliminar Producto");
            System.out.println("[5]Modificar Producto");
            System.out.println("[6]Analisis de Existencias ");
            System.out.println("[7]Visualizar todo el Inventario");
            System.out.println("[8]Salir");
            System.out.println("Tu seleccion: ");respuesta = leer.nextByte();leer.nextLine();
           
            switch (respuesta){
                case 1:llamar.AgregarNuevoProducto(leer);break;
                case 2:llamar.AgregarProductoExistente(leer);break;
                case 3:llamar.ConsultaProducto(leer);break;
                case 4:llamar.EliminaProducto(leer);break;
                case 5:llamar.ModificaProducto(leer);break;
                case 6:llamar.AnalisisExistencias(leer);break;
                case 7:llamar.VisualizarTodoElInventario(leer);break;
                case 8:bandera=true;break;
                default:bandera=true;break;
            }
        }while(bandera==false);
    }
    
    public void AgregarNuevoProducto(Scanner leer){
        
        
        int existencia;
        float costo;
        float precio;
        String nombre;
        String foto;
        String descripcion;
        
        
        System.out.println("----Llena el siguiente formulario para agregar un producto--------");
        System.out.println("Nombre del producto: ");nombre = leer.nextLine();
        System.out.println("Costo: ");costo = leer.nextFloat();leer.nextLine();
        System.out.println("Precio: ");precio = leer.nextFloat();leer.nextLine();
        System.out.println("Existencia: ");existencia = leer.nextInt();leer.nextLine();
        System.out.println("Nombre de la foto del producto: ");foto = leer.nextLine();
        System.out.println("Breve descripcion del producto: ");descripcion = leer.nextLine();
       
        
        Connection conexion = null;
        Statement sentencia = null;
        try{
            conexion = BDConnection.getCon(true);
            sentencia = conexion.createStatement();
            sentencia.executeUpdate("INSERT INTO Inventario "
            +"VALUES("+0+",'"+nombre+"',"+costo+","+precio+","+existencia+","+"'"+foto+"','"+descripcion+"')");
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
                System.err.println("Error en Gestor");
            }
        }
        System.out.println("\033[32mEl producto se agrego correctamente al inventario.");
    }
/*-----------------------------------------------------------------------------------------------------*/    
    public void AgregarProductoExistente(Scanner leer){
        int id_UpdateThisProduct;
        int num_productos_nuevos;
        System.out.println("-----Actualizar existencias-----");
        System.out.println("Ingresa el ID del producto: ");id_UpdateThisProduct = leer.nextInt();
        System.out.println("Ingresa la cantidad de productos que llegaron: ");num_productos_nuevos = leer.nextInt();
        
        
        /*-----------------------------------*/
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultSet = null;
        int Cantidad_Modificar=0;
        String cantidadProducto="";
        try{
            conexion = BDConnection.getCon(true);
            sentencia = conexion.createStatement();
            resultSet=sentencia.executeQuery("SELECT Existencia FROM Inventario "
            + "WHERE idProducto = +"+id_UpdateThisProduct);
        
            resultSet.next();
            Cantidad_Modificar=resultSet.getInt(1);

            Cantidad_Modificar=Cantidad_Modificar+num_productos_nuevos;
        }catch(SQLException error){
            System.err.println("Error de conexion...");
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
        
        /*-----------------------------------*/
        
        conexion = null;
        sentencia = null;
        try{
            conexion = BDConnection.getCon(true);
            sentencia = conexion.createStatement();
            sentencia.executeUpdate("UPDATE Inventario SET Existencia = '"+Cantidad_Modificar+"'WHERE idProducto ='"+id_UpdateThisProduct+"'");
        }catch(SQLException error){
            System.err.println("Error de conexion...");
            error.printStackTrace();
        }catch (Exception error){
            error.printStackTrace();
        }finally{
            try{
                sentencia.close();
                conexion.close();
            }catch(Exception error){
                System.err.println("Error en Gestor");
            }
        }
    }
/*-----------------------------------------------------------------------------------------------------*/  
    public void EliminaProducto(Scanner leer){
        
        int id=0;
        
        System.out.println("-----Eliminar Producto-----");
        System.out.println("Ingresa el ID del Producto: ");id = leer.nextInt();leer.nextLine();
        
        Connection conexion = null;
        Statement sentencia = null;
        
        try{
            conexion = BDConnection.getCon(true);
            sentencia = conexion.createStatement();
            sentencia.executeUpdate("DELETE FROM Inventario WHERE idProducto='"+id+"'");
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
    
    }
/*-----------------------------------------------------------------------------------------------------*/  
    public void ConsultaProducto(Scanner leer){
        
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
            String match = resultSet.getString(1);
            if(match==""){
                System.out.println("Lo sentimos no existen productos con el nombre: '"+nombre+"'");
            }else{
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
                
            }
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
/*-----------------------------------------------------------------------------------------------------*/  
    public void VisualizarTodoElInventario(Scanner leer){
        
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultSet = null;
        try{
            conexion = BDConnection.getCon(true);
            sentencia = conexion.createStatement();
            resultSet=sentencia.executeQuery("SELECT* FROM Inventario");
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
/*-----------------------------------------------------------------------------------------------------*/  
    public void ModificaProducto(Scanner leer){
          
        int id_Producto;
        int existencia;
        float costo;
        float precio;
        String nombre;
        String foto;
        String descripcion;
        boolean bandera=false;
        byte respuesta=0;
        
        System.out.println("-----Modificar producto-----");
        System.out.println("Ingresa el ID producto: ");id_Producto = leer.nextInt();leer.nextLine();
        do{
            System.out.println("-----Selecciona que campo quieres modificar-----");
            System.out.println("[1]Nombre del producto");
            System.out.println("[2]Costo");
            System.out.println("[3]Precio");
            System.out.println("[4]Existencia");
            System.out.println("[5]Nombre de la foto del producto");
            System.out.println("[6]Breve descripcion del producto");
            System.out.println("[7]Salir");
            System.out.print("Tu seleccion: ");respuesta = leer.nextByte();leer.nextLine();
            
            switch(respuesta){
                case 1: {                    
                    System.out.println("Nombre del producto: ");nombre = leer.nextLine();
                    Connection conexion = null;
                    Statement sentencia = null;
                    try{
                        conexion = BDConnection.getCon(true);
                        sentencia = conexion.createStatement();
                        sentencia.executeUpdate("UPDATE Inventario SET Nombre = '"+nombre+"' WHERE idProducto ='"+id_Producto+"'");
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
                            System.err.println("Error en Gestor");
                        }
                    }
                    System.out.println("\033[32mEl producto se modifico correctamente al inventario.");                
                    break;
                }
                case 2: {
                    System.out.println("Costo del producto: ");costo = leer.nextFloat();
                    Connection conexion = null;
                    Statement sentencia = null;
                    try{
                        conexion = BDConnection.getCon(true);
                        sentencia = conexion.createStatement();
                        sentencia.executeUpdate("UPDATE Inventario SET Costo = '"+costo+"' WHERE idProducto ='"+id_Producto+"'");
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
                            System.err.println("Error en Gestor");
                        }
                    }
                    System.out.println("\033[32mEl producto se modifico correctamente al inventario.");                
                    break;                
                }                   
                case 3:{
                    System.out.println("Precio: ");precio = leer.nextFloat();leer.nextLine();
                    Connection conexion = null;
                    Statement sentencia = null;
                    try{
                        conexion = BDConnection.getCon(true);
                        sentencia = conexion.createStatement();
                        sentencia.executeUpdate("UPDATE Inventario SET Precio = '"+precio+"' WHERE idProducto ='"+id_Producto+"'");
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
                            System.err.println("Error en Gestor");
                        }
                    }
                    System.out.println("\033[32mEl producto se modifico correctamente al inventario.");                
                    break; 
                }
                case 4:{
                    System.out.println("Existencia: ");existencia = leer.nextInt();leer.nextLine();
                    Connection conexion = null;
                    Statement sentencia = null;
                    try{
                        conexion = BDConnection.getCon(true);
                        sentencia = conexion.createStatement();
                        sentencia.executeUpdate("UPDATE Inventario SET Existencia = '"+existencia+"' WHERE idProducto ='"+id_Producto+"'");
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
                            System.err.println("Error en Gestor");
                        }
                    }
                    System.out.println("\033[32mEl producto se modifico correctamente al inventario.");                
                    break; 
                }        
                case 5:{
                    System.out.println("Nombre de la foto del producto: ");foto = leer.nextLine();
                    Connection conexion = null;
                    Statement sentencia = null;
                    try{
                        conexion = BDConnection.getCon(true);
                        sentencia = conexion.createStatement();
                        sentencia.executeUpdate("UPDATE Inventario SET Foto = '"+foto+"' WHERE idProducto ='"+id_Producto+"'");
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
                            System.err.println("Error en Gestor");
                        }
                    }
                    System.out.println("\033[32mEl producto se modifico correctamente al inventario.");                
                    break;                
                }
                case 6:{
                    System.out.println("Breve descripcion del producto: ");descripcion = leer.nextLine();
                    Connection conexion = null;
                    Statement sentencia = null;
                    try{
                        conexion = BDConnection.getCon(true);
                        sentencia = conexion.createStatement();
                        sentencia.executeUpdate("UPDATE Inventario SET Descripcion = '"+descripcion+"' WHERE idProducto ='"+id_Producto+"'");
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
                            System.err.println("Error en Gestor");
                        }
                    }
                    System.out.println("\033[32mEl producto se modifico correctamente al inventario.");                
                    break;                  
                
                }
                case 7: bandera=true; break;
                default: break;
            }
        }while(bandera==false);    
    }    
/*-----------------------------------------------------------------------------------------------------*/  
    public void AnalisisExistencias(Scanner leer){
        
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultSet = null;
        try{
            conexion = BDConnection.getCon(true);
            sentencia = conexion.createStatement();
            resultSet=sentencia.executeQuery("SELECT* FROM Inventario WHERE Existencia<='3'");
             ResultSetMetaData metaDatos = resultSet.getMetaData();
             int numCols = metaDatos.getColumnCount();
             System.out.println("\t\t\t\t\t-----Se recomienda volver a surtir estos productos-----");
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
