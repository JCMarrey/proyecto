/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODEL;

/**
 *
 * @author juanm
 */
public class Administrador extends Usuario {
    

    private String direccion;
    private double telefono;
    
     public Administrador (String nombre,String apellidoP,String apellidoM,int edad,String Sexo,String correo,String nombreU,String passwordU,String tipo, String direccion,double telefono){
        super(nombre,apellidoP, apellidoM,edad,Sexo,correo, nombreU,passwordU,tipo);
        this.direccion=direccion;
        this.telefono=telefono;
    }

    public Administrador(){
        super();
    }
     
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getTelefono() {
        return telefono;
    }

    public void setTelefono(double telefono) {
        this.telefono = telefono;
    }
    
    public void visualizaDatos(){
        System.out.println("INFORMACIÓN ADMINISTRADO\n"+ super.informacion()  + "\nDirección: " + direccion + "\ntelefóno: " + telefono);
    }
    
    public void modificarDatosUsuarios(){
        
    }
    
    
}
