package MODEL;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author juanm
 */

public class GestorMembresias {
  java.util.Date utilDate = new java.util.Date(); //fecha actual
    
  InputStreamReader isr = new InputStreamReader (System.in);
  BufferedReader reader = new BufferedReader (isr);
    
    public int agregarMembresia() throws IOException{
        System.out.println("\nINSERTAR CÓDIGO DE LA MEMBRESÍA: ");
        int codigo=  Integer.parseInt(reader.readLine());
        System.out.println("\nTipo de membresía: (bronce/plata/oro"); 
        String tipo= reader.readLine();
        long lnMilisegundos = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
        String tiempo;
        
        switch(tipo){
            
            case  "bronce":     tiempo="3 meses";
                                Membresia membresia1 = new Membresia(codigo, sqlDate ,tiempo);
                                break;
            case   "plata":     tiempo= "6 meses"; Membresia membresia2 = new Membresia(codigo, sqlDate ,tiempo); 
                                break;
            case   "oro":       tiempo="12 meses";Membresia membresia3 = new Membresia(codigo, sqlDate ,tiempo);
                                break;   
        }
        return codigo;
        
    }
    
}
