/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackpanthers;

import MODEL.GestorUsuarios;
import VIEW.GUI_Autentificacion;
import VIEW.GUI_Principal;
import java.io.IOException;

/**
 *
 * @author juanm
 */
public class BlackPanthers {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        GUI_Principal principal;
        new GUI_Principal().setVisible(true);
        
        
        
        //GUI_Autentificacion p;
        //new GUI_Autentificacion().setVisible(true);
        //GestorUsuarios gU= new GestorUsuarios();
        //gU.visualizaMenuAdministrativo();
    }

}
