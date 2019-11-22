/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import VIEW.GUI_Autentificacion;
import VIEW.GUI_RegistroAdmin_Socio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author juanm
 */
public class OAutentificacion implements ActionListener {
    
    
    
    
    JButton boton1, boton2, boton3, boton4;
    GUI_Autentificacion guiAutentificacion;
    
    
    public OAutentificacion(GUI_Autentificacion gAuto,JButton jButton1, JButton jButton2, JButton jButton3, JButton jButton4) {
        this.guiAutentificacion=gAuto;
        boton1 = jButton1;
        boton2 = jButton2;
        boton3 = jButton3; 
        boton4 = jButton4;   
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        Object botonPresionado = ae.getSource();

        if (botonPresionado == boton1) {
            
            //iniciar sesión
        }
        if (botonPresionado == boton2) {
            //iniciar sesión dependiendo del usuario
        }
        if (botonPresionado == boton3) {      
            new GUI_RegistroAdmin_Socio().setVisible(true);
            this.guiAutentificacion.setVisible(false);
        }
        if (botonPresionado == boton4) { 

        }
    }

}
