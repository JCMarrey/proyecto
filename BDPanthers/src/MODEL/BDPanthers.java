package MODEL;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;

/**
 *
 * @author juanm
 */
public class BDPanthers {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        GestorAutentificacion ga= new GestorAutentificacion();
        ga.visualizaMenuAutenticacion();
    }
    
}
