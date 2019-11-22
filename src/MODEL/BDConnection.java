package MODEL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class BDConnection {
    private static Connection conexion;
    private BDConnection (){}
    public static Connection getCon(boolean autocomit){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlackPanthers","root","2173034521");
            conexion.setAutoCommit(autocomit);
            if(conexion!=null){
                System.out.println("\033[32mConexion establecida...");
            }
        }catch(ClassNotFoundException error){
        }catch (SQLException error2){
            error2.printStackTrace();
            System.err.println("Conexion Fallida...");
        }
        return conexion;
    }
    public static void close (){
        try{
            if(conexion!=null){
                conexion.close();
            }
        }catch(SQLException error3){
            error3.printStackTrace();
             System.err.println("Error en BDConnection");
        }
    }
  
}

