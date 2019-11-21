/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import GestorConsulta.*,GestorPaciente.*,GestorLaboratorio.*,GestorDatosClinicos;
package MODEL;

import java.util.ArrayList;


/**
 *
 * @author JC
 */
 public class TablaUsuarios {
    ArrayList<Usuario> tablaUsuarios = new ArrayList<>();
    
    public void agregaNuevoUsuario (Usuario usuario) {
        tablaUsuarios.add(usuario);
    }
    
    public Usuario getUsuario (int i) {
        return tablaUsuarios.get(i);
    }
    
    public int cantidadDeUsuarios () {
        return tablaUsuarios.size();
    }
    
}
