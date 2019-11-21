/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import VIEW.*;
import javax.swing.JFrame;

/**
 *
 * @author juanm
 */
public class OInventario implements ActionListener {
    
    JButton AgregarProducto;
    GUI_AgregarProducto_G guiAgregarProducto ;
        
        
    JButton Regresar;
    GUI_Inventario guiInventario;
   
    public OInventario (){}
    public OInventario (JButton B_AgregarProducto){
        this.AgregarProducto = B_AgregarProducto;
        this.guiInventario = guiInventario;
    }
    public OInventario (JButton B_Regresar,GUI_AgregarProducto_G guiAgregarProducto){
        this.Regresar=B_Regresar;
        this.guiAgregarProducto = guiAgregarProducto;
    }
 
    
    @Override
    public void actionPerformed(ActionEvent ae) {
              
        Object BotonSeleccionado = ae.getSource();
      //  guiAgregarProducto = new GUI_AgregarProducto_G();
//        guiAgregarProducto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        if(BotonSeleccionado == this.AgregarProducto){
           this.guiInventario = new GUI_Inventario();
            this.guiAgregarProducto.setVisible(true);
          //  this.guiInventario.setVisible(false);
        }
        if(BotonSeleccionado == this.Regresar){
            this.guiAgregarProducto.setVisible(false);
            new GUI_Inventario().setVisible(true);
        // this.guiInventario.setVisible(true);
        }
        
    }
    
    
    
   
}
