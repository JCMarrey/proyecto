package MODEL;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Date;
//import java.util.Date;

/**
 *
 * @author juanm
 */
public class Membresia {
    private int idMembresia;
    private Date fechaRegistro;
    private String tiempo;

    
    public Membresia(int id, Date fecha, String tiempo){
        this.idMembresia=id;
        this.fechaRegistro=fecha;
        this.tiempo=tiempo;
    }
    public Membresia(){
        
    }
    
    public int getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }

    public Date getFecha() {
        return fechaRegistro;
    }

    public void setFecha(Date fecha) {
        this.fechaRegistro = fecha;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    
    public String visualizaDatosMembresia(){
        String inf= "\n Número de Membresía: " + idMembresia + "\nFecha de Registro: " 
                + "\ntiempo: " + tiempo;
        
        return inf;
    }
    
}
