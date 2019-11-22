package baseDatos;/*

    con esta clase nos conectamos a la BD
*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juanm
 */
public class Conectar {

   private static Connection con;
   //private static final String driver ="com.mysql.jdbc.Driver"; //hacemos referencias al driver que sé conecto
   private static final String usuario= "root";
   private static final String pwd ="jUAM2017CNI";
   private static final String url= "jdbc:mysql://localhost:3306/BP";
   private Conectar conecta;
   /*MÉTODO PARA CONECTAR A LA BD*/
  
   
  public Conectar(){
  }
  public static Connection getCon()
  {
      try { //carga la clase controlador
            Class.forName("com.mysql.cj.jdbc.Driver"); //controlador para realizar la conexión
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bp","root","jUAM2017CNI");
            //
            //con=DriverManager.getConnection(url, usuario, pwd);
            if(con!=null){
                System.out.println("conexión establecida");
            }
        } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("Conexión fallida: fallo");
        }
      return con; //regresa la conexión
  }
  
  public static void close()
  {
      try {
          if(con != null)
              System.out.println("Conexión terminada");
             con.close();
      } catch (SQLException ex) {
      }
  }

  
  
}
