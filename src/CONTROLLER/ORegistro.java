/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.GestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author juanm
 */
public class ORegistro implements ActionListener{
    
    
    JButton boton1,boton2;
    GestorUsuarios gestorU;
    
    
    public ORegistro(JButton jButton1,JButton jButton2){
      this.boton1=jButton1;
      this.boton1=jButton2;
      
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object botonPresionado= ae.getSource();
        
        //gestorU= new GestorUsuarios();
        
        if(botonPresionado==boton1){
            System.out.println("HOLa");
        }
        
    }
    
}
