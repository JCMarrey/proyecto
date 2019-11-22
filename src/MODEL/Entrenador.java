package MODEL;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author juanm
 */
public class Entrenador extends Usuario {
    
    private String tipo;
    private String direccion;
    private double telefono;
   
    public Entrenador(String nombre,String apellidoP,String apellidoM,int edad,String sexo, String correo,String nombreU,String passwordU,String tipoU,float altura,int peso,String tipo,String direccion,double telefono){
        
        super(nombre,apellidoP, apellidoM,edad,sexo,correo, nombreU, passwordU,tipoU);
        this.tipo=tipo;
        this.direccion=direccion;
        this.telefono=telefono;
        
    }
    public Entrenador(){
        super();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String visualizaDatos(){
        String inf= "\nINFORMACIÓN ENTRENADOR: " + super.informacion() + "\nTipo: " + tipo +
                "\nDireccion: " + direccion;
        return inf;
    }
    
}
