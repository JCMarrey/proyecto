/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juanm
 */
public class Usuario implements informacion {

    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int edad;
    private String sex;
    private String correo;
    private String nombreU;
    private String paswordU;
    private String tipoU;
    
    //private String tipoUsuario;
        
    public Usuario(){
        
    }
    public Usuario(String nombre,String apellidoP,String apellidoM,int edad,String Sexo,String nombreU,String passwordU,String correo,String tipoU){
        this.nombre=nombre;
        this.apellidoP=apellidoP;
        this.apellidoM=apellidoM;
        this.edad=edad;
        this.correo=correo;
        this.nombreU=nombreU;
        this.paswordU=passwordU;
        this.tipoU=tipoU;
        this.sex=Sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreU() {
        return nombreU;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public String getPaswordU() {
        return paswordU;
    }

    public void setPaswordU(String paswordU) {
        this.paswordU = paswordU;
    }

    public String getTipoU() {
        return tipoU;
    }

    public void setTipoU(String tipoU) {
        this.tipoU = tipoU;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
  
    @Override
    public String informacion() {
         
        String info;
        info="Nombre: " + nombre + "\nApellido Paterno: " + "\nApellido Materno: " + "\nEdad: "  + "\nCorreo electrónico: " + "Nombre Usuario: "  + nombreU 
              + "Contraseña: " + paswordU;
        return info;
    }
    
    
    
    
}