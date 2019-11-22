/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import VIEW.GUI_Autentificacion;
import VIEW.GUI_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author juanm
 */
public class OPrincipal implements ActionListener {
        JButton boton1,boton2,boton3,boton4,boton5;  //son los generadores de eventos..
        GUI_Principal guiPrincipal;
        public OPrincipal(GUI_Principal guiP,JButton jButton1, JButton jButton2, JButton jButton3, JButton jButton4, JButton jButton5){
            boton1=jButton1; 
            boton2=jButton2;
            boton3=jButton3;
            boton4=jButton4;
            boton5=jButton5;
            guiPrincipal=guiP;
        }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object botonPresionado= ae.getSource();
        
        if(botonPresionado==boton1){
            //menu membresias
        }
        if(botonPresionado==boton2){
            //menu productos
        }
        if(botonPresionado==boton3){
            //menu eventos
        }
        if(botonPresionado==boton4){
            //menu rutinas
        }
        
        if(botonPresionado==boton5){  //inicio de sesió
            new GUI_Autentificacion().setVisible(true);
            this.guiPrincipal.setVisible(false);
            
        }
       
    }
    
    
    
    
}
