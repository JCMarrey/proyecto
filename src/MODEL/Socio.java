package MODEL;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author juanm
 */
public class Socio extends Usuario{
    
    private float altura;
    private int peso;
    private float IMC;
    private Membresia membresia;

    
     public Socio(String nombre,String apellidoP,String apellidoM,int edad,String sexo,String correo,String nombreU,String sex,String passwordU,String tipoU,float altura,int peso){ 
        super(nombre,apellidoP, apellidoM,edad,sexo,correo, nombreU, passwordU,tipoU);
        this.altura=altura;
        this.peso=peso;
        this.IMC=(float) ((float)this.peso/(Math.pow(this.altura,2)));
         
    }
    
    public Socio(){
        super();
    }

    
    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }
    
    
    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public float getIMC() {
        return IMC;
    }

    public void setIMC(float IMC) {
        this.IMC = IMC;
    }
     
    public void visualizaDatos(){
        
        System.out.println("INFORMACIÓN SOCIO: " +  super.informacion() +
                "\nAltura: "+ altura +"\nPeso: " + peso + "\nIMC: " + IMC 
                + membresia.visualizaDatosMembresia());
         
    }
    
    
}
