package MODEL;

import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author JC
 */
public class GestorAutentificacion {
    
    
    
    
    
    void menuAdministrativo(){
       
    }
    
    void menuPaciente(){
       
    }
    void menuDoctor(){
       
    }
    void menuEnfermera(){
       
    }
    
    void menuFarmaceutico(){
        
    }
    
    public void visualizaMenuAutenticacion() throws IOException{
        //CREACIÓN DE UN OBJETO INSTANCIA DE LA CLASE 'TablaUsuarios',
        //EL CUAL SE PASA COMO REFERENCIA AL OBJETO INSTANCIA DE LA CLASE 'Sesion'.
        //ES DECIR, EL CONSTRUCTOR DE LA CLASE 'Sesion' RECIBE COMO PARÁMETRO UN OBJETO
        //INSTANCIA DE LA CLASE 'TablaUsuarios'
        TablaUsuarios tablaUsuarios = new TablaUsuarios();
        
        Usuario u1= new Usuario ("Juan","Martínez","Reyes",21,"juan369@hotmail.com","jcMarrey","M","123","ADMINISTRATIVO",54789612);
        tablaUsuarios.agregaNuevoUsuario(u1);
      
        
        //CREACIÓN DE UN OBJETO DE LA CLASE 'Scanner'. SE INDICA QUE LOS DATOS PROVIENEN DEL TECLADO
        //AL ENVIAR EL PARÁMETRO 'System.in' AL CONSTRUCTOR
        Scanner input = new Scanner(System.in); 
        int seleccion;        
        //CREACIÓN DE UN OBJETO INSTANCIA DE LA CLASE 'Sesion'
        Sesion nuevaSesion = new Sesion (tablaUsuarios);
        
        
        
        do {
            System.out.println();
            System.out.println();
            System.out.println("INTRODUZCA: ");
            System.out.println("1 PARA INICIAR SESIÓN");
            System.out.println("2 PARA FINALIZAR");
            System.out.print("SELECCIÓN: ");
            seleccion = input.nextInt();
            
        
            switch (seleccion){
                case 1:
                    nuevaSesion.IniciaSesion();        
                    break;

                case 2: break;
                
                default: System.out.println("**OPCÓN INCORRECTA**");
            }
        } while (seleccion != 2);
    }    
}    
   
