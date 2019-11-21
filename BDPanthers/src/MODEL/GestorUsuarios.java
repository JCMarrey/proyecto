/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author juanm
 */


package MODEL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author JC
 */
public class GestorUsuarios {
  
  private String rpasswordUsuario;
  InputStreamReader isr = new InputStreamReader (System.in);
  BufferedReader reader = new BufferedReader (isr);
 
  Socio s= new Socio();  
  GestorMembresias gm = new GestorMembresias();
  Membresia membresia= new Membresia();
  ejemplo conexion = new ejemplo();
  public void visualizaMenuAdministrativo() throws IOException{
   
              
      
      
      int option;  
      do{
      System.out.println("\n\nSelecciones la operación que va a realizar, por favor \n1: Registrar Usuario \n2: Buscar Usuario \n3: Eliminar Usuario, \n4: Modificar Información Usuario \n5: Visualizar tabla de usuarios \n6: Salir");
      Scanner sc= new Scanner(System.in);
      option=sc.nextInt();
     
      
      
      switch(option){
          
            case 1: 
                
                        //LA CLASE RegistraUsuario DEBE RESOLVER TAMBIÉN ASPECTOS PROPIOS DE UNA GUI,
                //TALES COMO EL INPUT/OUTPUT (INTERACCIÓN/VISUALIZACIÓN)
                Usuario nuevoUsuario;
                System.out.println("***** REGISTRO DE NUEVO USUARIO *****");
                System.out.println("Nombre:");
                String nombre=reader.readLine();
                      //usuario.setName(nombre);
                System.out.println("\nApellido Paterno: "); String ApellidoP=reader.readLine();
                System.out.println("\nApellido Materno: "); String ApellidoM=reader.readLine();
                System.out.println("\nEdad:"); int edadd= Integer.parseInt(reader.readLine());
                System.out.println("\n Telefono: ");  double telefono = Double.parseDouble(reader.readLine());
                System.out.println("\nCorreo electrónico: "); String correo= reader.readLine();
                System.out.println("\nNombre de usuario: ");String nombreU= reader.readLine();
                System.out.println("\n Sexo: M/F");String sex= reader.readLine();
                System.out.println("TIPO DE USUARIO:  (socio/entrenador"); String tipoUsuario= reader.readLine();
                System.out.print("INTRODUCIR PASSWORD: ");String passwordUsuario= reader.readLine();
           
               

                //tablaUsuarios.agregaNuevoUsuario(nuevoUsuario);  HACER ONEXIÓN
                
                switch (tipoUsuario){
                    case "socio" : 
                            System.out.println("\nPeso del nuevo socio: "); int peso=Integer.parseInt(reader.readLine());
                            System.out.println("\nAltura del nuevo socio: "); float altura=Float.parseFloat(reader.readLine());
                            float IMC= (float) ((float)peso/(Math.pow(altura,2)));
                            System.out.println("LLENAR DATOS DE MEMBRESÍA:");       
                            int idMembresia= gm.agregarMembresia();
                            System.out.println("ID MEMBRESIA: "  +  idMembresia);
                            //inicar conexión:
                            Connection rg=Conectar.getCon();
                            Connection conn = null;
                            Statement stmt = null;
                            conexion.inserta(conn, stmt, nombre, ApellidoP, ApellidoM, edadd,telefono,sex,nombreU,correo, altura, peso, IMC, idMembresia);
                            
                            //darle prioridad
                            
                           // conexion.privilegioSocio(conn, nombreU);
                            
                            break;
                    case "entrenador": 
                            System.out.println("\n Tipo de Entrenador: (Personal/General)"); String tipo= reader.readLine();
                            System.out.println("\nDirección: "); String direc= reader.readLine();
                            System.out.println("\n Telefóno: ");double telefon= Double.parseDouble(reader.readLine());
                        
                        break;
                         
                    case "regresar": 
                        
                        break;
                    default :
                }
                
                
                System.out.println("***** REGISTRO DE NUEVO USUARIO CONCLUIDO DE FORMA EXITOSA*****");
                //int ID=(int) (Math.random() * ( 100 - 1 ));  //lo correcto es que cada vez que agreguemos a unos este vaya en proceso.;
             
            break;
          
            case 2: 
              int IDB;
              System.out.println("\nINTRODUCIR EL NOMBRE DE USUARIO, POR FAVOR");
              String nombreUA= reader.readLine();
              
                    Connection rg=Conectar.getCon();
                    Connection conn = null;
                    Statement stmt = null;
                    ResultSet resultSet = null;
                    conexion.busca(conn, stmt, resultSet, nombreUA);
              
              
            break;
              
            case 3: System.out.println("\n INTRODUCIR EL NOMBRE DE USUARIO A ELIMINAR, POR FAVOR\n");
                    String numU;
                    numU= reader.readLine();
                    Connection rgg=Conectar.getCon();
                    Connection connn = null;
                    conexion.elimina(connn, numU);
                    
            break;
          
            case 4: 
                    System.out.println("\n INTRODUCIR EL NOMBRE DE USUARIO A ELIMINAR, POR FAVOR\n");
                    String nomU;
                    nomU= reader.readLine();
                    System.out.println("\n¿QUÉ DESEA MODIFICAR?: \n1: NOMBRE PACIENTE\n2: CURP PACIENTE\n3: Número teléfonico del paciente\n4: Salir"); 
                    int opMof;
                    opMof=sc.nextInt();
                    switch(opMof){
                        case 1: 
                            System.out.println("NOMBRE DEL USUARIO");
                            String nombreM=reader.readLine();
                            //hacer el sql
                            System.out.println("\nNOMBRE MODIFICADO CON EXITO");
                        break;
                        case 2: 
                            System.out.println("\nCONTRASEÑA:\n");
                            String CURPM=reader.readLine();
                            
                            System.out.println("\nCONTRASEÑA MODIFICADO CON EXITO\n");
                        break;
                    
                        case 3: 
                            System.out.println("Correo electrónico");
                            String nuevoN=reader.readLine();
                            
                            System.out.println("\nCORREO MODIFICADO CON EXITO\n");
                        break;
                    
         
                    
                        default: System.out.println("\nOPCIÓN INCORRECTA");
                    
                    
                }    
            break;
          
          case 5: 
                 Connection rggg=Conectar.getCon();
                 Connection connnn = null;
                 Statement stmtt = null;
                 ResultSet resultSett = null;          
                 conexion.selecciona(connnn, stmtt, resultSett);
              
          case 6: return;
          default: System.out.println("Opción incorrecta");
      }
     
  }while(option!=6);
 
    }
  
    public void VisualizaMenuSocio(){
        
    }
    
    
    public void VisualizaMenuEntrenador(){
        
    }
}

