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
    
    private int numero;
    private String direccion;
    
     public Administrador (String nombre,String apellidoP,String apellidoM,int edad,String correo,String nombreU,String sex,String passwordU,String tipo,int numero, String direccion,long telefono){
        super(nombre,apellidoP, apellidoM,edad,correo, nombreU,sex, passwordU,tipo,telefono);
        this.numero=numero;
        this.direccion=direccion;
        
        
        
    }

    public Administrador(){
        super();
    }
     
     
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
   
    public void visualizaDatos(){
        System.out.println("INFORMACIÓN ADMINISTRADO\n"+ super.informacion()  + "\nDirección: " + direccion + "\ntelefóno: " + numero);
    }
    
    public void modificarDatosUsuarios(){
        
    }
    
    
}
