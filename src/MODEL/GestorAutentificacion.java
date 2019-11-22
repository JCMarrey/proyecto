package MODEL;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;



/**
 *
 * @author JC
 */
public class GestorAutentificacion {
        JFormattedTextField nombreU;  //para el nombre de usuario
        JComboBox tipoUsuario;
        JPasswordField password;
        
        GestorAutentificacion(JFormattedTextField nombreU,JComboBox tipoU,JPasswordField password){
            this.nombreU=nombreU;
            this.password=password;
            this.tipoUsuario=tipoU;
            
        }
    
        public  void iniciarSesion(){
            
        } 
}    
   
