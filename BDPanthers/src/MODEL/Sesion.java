package MODEL;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JC
 */
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author usuario
 */
public class Sesion{
    private String nombreUsuario;
    private String emailUsuario;
    private String usernameUsuario;
    private String passwordUsuario;
    private String rpasswordUsuario;
    private TablaUsuarios tablaUsuarios;
    private int edad,tUsuario;

    
    
    GestorUsuarios gu= new GestorUsuarios();

    public int gettUsuario() {
        return tUsuario;
    }

    public void settUsuario(int tUsuario) {
        this.tUsuario = tUsuario;
    }
    private String sexo,tipoUsuario;
    

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public void setUsernameUsuario(String usernameUsuario) {
        this.usernameUsuario = usernameUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public void setRpasswordUsuario(String rpasswordUsuario) {
        this.rpasswordUsuario = rpasswordUsuario;
    }

    public void setTablaUsuarios(TablaUsuarios tablaUsuarios) {
        this.tablaUsuarios = tablaUsuarios;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setIsr(InputStreamReader isr) {
        this.isr = isr;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    //CREACIÓN DE LA TABLA DINÁMICA DE USUARIOS. 
    //TablaUsuarios tablaUsuarios = new TablaUsuarios();
    
    //DEFINIENDO UN FLUJO DE CARACTERES DE ENTRADA PARA LECTURA DESDE EL TECLADO
    private InputStreamReader isr = new InputStreamReader (System.in);
    private BufferedReader reader = new BufferedReader (isr);
    //PARA LEER LA ENTRADA DEL TECLADO Y FINALIZAR AL PRESIONAR LA TECLA 'ENTER':
    //String nombreVariable = reader.readLine();
    
    public Sesion (TablaUsuarios tablaU) {
        tablaUsuarios = tablaU;
    }
    
    
    int busqueda(String passwordUsuario,String usernameUsuario){
        int cantidadU = tablaUsuarios.cantidadDeUsuarios();
        int exitoBusqueda=0, i=0;
        
         while (exitoBusqueda == 0 && i < cantidadU) { 
                    if (passwordUsuario.equals(tablaUsuarios.getUsuario(i).getPaswordU()) && 
                        usernameUsuario.equals(tablaUsuarios.getUsuario(i).getNombreU())) {
                        exitoBusqueda = 1;
                        return exitoBusqueda;
                    }      
                    i++;
                } 
        
        return exitoBusqueda;
    }
    
    public void IniciaSesion ( ) throws IOException {
        //LA CLASE IniciaSesion DEBE RESOLVER TAMBIÉN ASPECTOS PROPIOS DE UNA GUI,
        //TALES COMO EL INPUT/OUTPUT (INTERACCIÓN/VISUALIZACIÓN)
        Scanner sc= new Scanner(System.in);
        System.out.println("***** INICIO DE SESIÓN *****");
        System.out.print("INTRODUCIR USERNAME: ");
        usernameUsuario = reader.readLine();
        System.out.print("INTRODUCIR PASSWORD: ");
        passwordUsuario = reader.readLine();
        System.out.println("\n\nINTRODUCIR TIPO DE USUARIO: \n1: ADMINISTRATIVO, \n2: SOCIO,\n3: ENTRENADOR");
        tipoUsuario=reader.readLine();
        tUsuario=Integer.parseInt(tipoUsuario);
        //INICIA VALIDACIÓN DE CREDENCIALES
        String usernameUsuarioT;
        String passwordUsuarioT;
        int i = 0;
        int exitoBusqueda = 0;
        
        int respuesta;
        switch(tUsuario){
                
            case 1 :
                        System.out.println("TIPO CUENTA: ADMINISTRATIVO");
                        exitoBusqueda=busqueda(passwordUsuario,usernameUsuario);
  
                        if (exitoBusqueda ==1) {
                        System.out.println("***** VALIDACIÓN EXITOSA, ACCESO CONCEDIDO *****");
                        
                        do{
                        System.out.println("¿QUÉ DESEA HACER?:  \n 1: Gestionar Socios \n 2: Gestionar Entrenadores \n 3:Salir");
                        respuesta=sc.nextInt();
                        
                        
                                if(respuesta==1){
                                    gu.visualizaMenuAdministrativo();
                                    
                                }
                                if(respuesta==2){
                                   // gMedico.visualizaMenuAdministrativo();
                                }
                  
                            }while (respuesta!=3);
                        }
                        else {
                            System.out.println("***** USER NAME ERRÓNEO O PASSWORD ERRÓNEA *****");
                        }
                        
                break;
                
                
            case 2 :
                
                System.out.println("TIPO CUENTA: SOCIO");
                        exitoBusqueda=busqueda(passwordUsuario,usernameUsuario);
                        if (exitoBusqueda ==1) {
                        System.out.println("***** VALIDACIÓN EXITOSA, ACCESO CONCEDIDO *****");
                        System.out.println("¿Qué desea hacer?");
                        respuesta=sc.nextInt();
                            if(respuesta==1){
                                
                            }
                        
                        
                        } else {
                        System.out.println("***** USER NAME ERRÓNEO O PASSWORD ERRÓNEA *****");
                        }
                        
                        
                        
                break;
            case 3 :
                
                System.out.println("TIPO CUENTA: ENTRENADOR");
                        exitoBusqueda=busqueda(passwordUsuario,usernameUsuario);
                        if (exitoBusqueda ==1) {
                        System.out.println("***** VALIDACIÓN EXITOSA, ACCESO CONCEDIDO *****");
                        } else {
                        System.out.println("***** USER NAME ERRÓNEO O PASSWORD ERRÓNEA *****");
                        }
                break;
            default: System.out.println("OPCIÓN INCORRECTA");    
            
        }
    }  
    public void RegistraUsuario () throws IOException {
        Scanner sc= new Scanner(System.in);
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
        System.out.println("\nCorreo electrónico: "); String correo= reader.readLine();
        System.out.println("\nNombre de usuario: ");String nombreU= reader.readLine();
        System.out.println("\n Sexo: M/F");String sex= reader.readLine();
        System.out.print("\nINTRODUCIR PASSWORD: ");passwordUsuario = reader.readLine();
        System.out.println("\nTIPO DE USUARIO: "); tipoUsuario= reader.readLine();
        System.out.println("\nTELEFONO:");int telefono=Integer.parseInt(reader.readLine());
        
        
        do {            
            System.out.print("INTRODUCIR NUEVAMENTE LA PASSWORD: ");
            rpasswordUsuario = reader.readLine();
        } while (passwordUsuario == null ? rpasswordUsuario != null : !passwordUsuario.equals(rpasswordUsuario));
        //PROCESO DE REGISTRO DE NUEVO USUARIO
        nuevoUsuario = new Usuario(nombre,ApellidoP,ApellidoM,edadd,correo,nombreU,sex,passwordUsuario,tipoUsuario,telefono);   
        
        //tablaUsuarios.agregaNuevoUsuario(nuevoUsuario);  HACER ONEXIÓN
        System.out.println("***** REGISTRO DE NUEVO USUARIO CONCLUIDO DE FORMA EXITOSA*****");
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public String getUsernameUsuario() {
        return usernameUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public String getRpasswordUsuario() {
        return rpasswordUsuario;
    }

    public TablaUsuarios getTablaUsuarios() {
        return tablaUsuarios;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public InputStreamReader getIsr() {
        return isr;
    }

    public BufferedReader getReader() {
        return reader;
    }
    
}
