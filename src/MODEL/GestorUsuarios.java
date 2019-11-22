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


import baseDatos.Conectar;
import baseDatos.FuncionalidadesSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JC
 */
public class GestorUsuarios {
    //Variables para la conexión.
    FuncionalidadesSQL conexion = new FuncionalidadesSQL(); //llama a todos nuestros métodos
    ResultSet rs;       //para usar en toda la BD
    Conectar con = new Conectar();
    
    Connection conn= null;
    //instanciar para obtener el método
  
    
    //CONSULTAS
    public boolean registrarUsuarios(Usuario usuario){
       
        PreparedStatement ps= null; //mi consulta y usar la bd para enviar datos
        conn= Conectar.getCon();
        
        String sql= "INSERT INTO usuarios (nombre,APaterno,AMaterno,Edad,Sexo,NombreUsuario,Contraseña,Correo,TipoUsuario)VALUES(?,?,?,?,?,?,?,?,?)";
        //?? evitar que inyecten código
        
        //mandar los datos
        
        try{
            
            ps=conn.prepareStatement(sql);
            ps.setString(1,usuario.getNombre());  //enviar los datos
            ps.setString(2, usuario.getApellidoP());
            ps.setString(3, usuario.getApellidoM());
            ps.setInt(4, usuario.getEdad()); //sin parseo todo esta bien
            ps.setString(5, usuario.getSex());
            ps.setString(6, usuario.getNombreU());
            ps.setString(7, usuario.getPaswordU());
            ps.setString(8, usuario.getCorreo());
            ps.setString(9, usuario.getTipoU());
            ps.executeUpdate();
            
            return true; //agrego usuarios
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally{
              try{
                  conn.close();
              }catch(SQLException e){
                   System.out.println(e);
              }  
        }
            
    }
    
    
    public boolean modificarUsuarios(Usuario usuario){
       
        PreparedStatement ps= null; //mi consulta y usar la bd para enviar datos
        conn= Conectar.getCon();
        
        String sql= "UPDATE usuarios SET NombreUsuario=?,APaterno=?, AMaterno=?,Edad=?,Sexo=?,NombreUsuario=?,Contraseña=?,Correo=?,TipoUsuario=?"
                + "WHERE NombreUsuario=?";
        //puede ser con eel id del usuario que sera invisible
        
        //mandar los datos
        
        try{
            
            ps=conn.prepareStatement(sql);
            ps.setString(1,usuario.getNombre());  //enviar los datos
            ps.setString(2, usuario.getApellidoP());
            ps.setString(3, usuario.getApellidoM());
            ps.setInt(4, usuario.getEdad()); //sin parseo todo esta bien
            ps.setString(5, usuario.getSex());
            ps.setString(6, usuario.getNombreU());
            ps.setString(7, usuario.getPaswordU());
            ps.setString(8, usuario.getCorreo());
            ps.setString(9, usuario.getTipoU());
            ps.executeUpdate();
            
            return true; //agrego usuarios
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally{
              try{
                  conn.close();
              }catch(SQLException e){
                   System.out.println(e);
              }  
        }
            
    }
    
    
    public boolean eliminarUsuarios(Usuario usuario){
       
        PreparedStatement ps= null; //mi consulta y usar la bd para enviar datos
        conn= Conectar.getCon();
        
        String sql= "DELETE  FROM usuarios WHERE NombreUsuario=?";
        //puede ser con eel id del usuario que sera invisible
        
        //mandar los datos
        
        try{
            
            ps=conn.prepareStatement(sql);  
            ps.setString(1, usuario.getNombreU());
            ps.executeUpdate();
            
            return true; //agrego usuarios
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally{
              try{
                  conn.close();
              }catch(SQLException e){
                   System.out.println(e);
              }  
        }
            
    }
    
      public boolean BuscarUsuarios(Usuario usuario){
       
        PreparedStatement ps= null; //mi consulta y usar la bd para enviar datos
        conn= Conectar.getCon();
        rs=null;
        String sql= "SELECT*FROM usuarios WHERE NombreUsuario=?";

        try{
            
            ps=conn.prepareStatement(sql);  
            ps.setString(1, usuario.getNombreU());
            rs=ps.executeQuery();
            
            if(rs.next())  {  //para traer sólo una fila, si son más es con un while
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidoP(rs.getString("APaterno"));
                usuario.setApellidoM(rs.getString("AMaterno"));
                usuario.setEdad(Integer.parseInt(rs.getString("Edad")));
                usuario.setSex(rs.getString("Sexo"));
                usuario.setNombreU(rs.getString("NombreUsuario"));
                usuario.setPaswordU(rs.getString("Contraseña"));
                usuario.setCorreo(rs.getString("Correo"));
                usuario.setTipoU(rs.getString("TipoUsuario"));
                return true;
            }
            return false; //no hay nada
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally{
              try{
                  conn.close();
              }catch(SQLException e){
                   System.out.println(e);
              }  
        }
            
    }
    
    
    
    
    
    
    
   /*
    
    String nombre,ApellidoP,ApellidoM,sex,nombreU,passwordUsuario,correo;
    int edadd,peso,idMembresia;
    float altura;
    JTextField jtextFiel;
     
    public GestorUsuarios(String nombre,String ApellidoP,String ApellidoM,int edad, String sexo,String nombreU,String password,String correo, int idM){
        this.nombre=nombre;
        this.ApellidoP=ApellidoP;
        this.ApellidoM=ApellidoM;
        this.edadd=edad;
        this.sex=sexo;
        this.nombreU=nombreU;
        this.passwordUsuario=password;
        this.correo=correo;
        this.idMembresia=idM;
        this.jtextFiel=jtex;
                
    }
    
    public GestorUsuarios(){
        
    }
    
    
    public void agregarSocio() {
        
            
           
    }         
                    

    private String rpasswordUsuario;
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(isr);

    Socio s = new Socio();
    GestorMembresias gm = new GestorMembresias();
    Membresia membresia = new Membresia();
   
    

    public void visualizaMenuAdministrativo() throws IOException {
        
        int option;
        do {
            System.out.println("\n\nSelecciones la operación que va a realizar, por favor \n1: Registrar Usuario \n2: Buscar Usuario \n3: Eliminar Usuario, \n4: Modificar Información Usuario \n5: Visualizar tablas\n6: Salir");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            //PARA HACER LAS CONEXIONES
            Connection rg = Conectar.getCon();
            System.out.println("valor de rg" + rg);
            Connection conn = null;
            Statement stmt = null;

            switch (option) {

                case 1:

                    //LA CLASE RegistraUsuario DEBE RESOLVER TAMBIÉN ASPECTOS PROPIOS DE UNA GUI,
                    //TALES COMO EL INPUT/OUTPUT (INTERACCIÓN/VISUALIZACIÓN)
                    
                    
                    Usuario nuevoUsuario;
                    System.out.println("***** REGISTRO DE NUEVO USUARIO *****");
                    System.out.println("Nombre:");
                    
                    /*
                    String nombre = reader.readLine();
                    //usuario.setName(nombre);
                    System.out.println("\nApellido Paterno: ");
                    String ApellidoP = reader.readLine();
                    System.out.println("\nApellido Materno: ");
                    String ApellidoM = reader.readLine();
                    System.out.println("\nEdad:");
                    int edadd = Integer.parseInt(reader.readLine());
                    System.out.println("\n Sexo: (masculino/femenino)");
                    String sex = reader.readLine();
                    System.out.println("\nNombre de usuario: ");
                    String nombreU = reader.readLine();
                    System.out.print("INTRODUCIR PASSWORD: ");
                    String passwordUsuario = reader.readLine();
                    System.out.println("\nCorreo electrónico: ");
                    String correo = reader.readLine();
                    System.out.println("TIPO DE USUARIO:  (socio/entrenador/administrador)");
                    
                    String tipoUsuario = reader.readLine();
                    
                    
                    switch (tipoUsuario) {
                        case "socio":

                            System.out.println("\nAltura del nuevo socio: ");
                            altura = Float.parseFloat(reader.readLine());
                            System.out.println("\nPeso del nuevo socio: ");
                            peso = Integer.parseInt(reader.readLine());
                            float IMC = (float) ((float) peso / (Math.pow(altura, 2)));
                            System.out.println("LLENAR DATOS DE MEMBRESÍA:");
                            idMembresia = gm.agregarMembresia();
                            System.out.println("ID MEMBRESIA: " + idMembresia);
                            //inicar conexión:

                            conexion.insertaSocio(conn, stmt,nombre,ApellidoP, ApellidoM,edadd, sex, nombreU,  passwordUsuario, correo,altura, peso, IMC, idMembresia);
                            conexion.crearUsuario(conn,stmt,nombreU, passwordUsuario, tipoUsuario);
                            conexion.darPermisosUsuario(conn,stmt,nombreU, passwordUsuario, tipoUsuario);
                            conexion.insertaUsuario(nombre, ApellidoP, ApellidoM, edadd, sex, nombreU, passwordUsuario, correo, tipoUsuario); //insertar en tabla usuarios
                            System.out.println("***** REGISTRO DE NUEVO USUARIO CONCLUIDO DE FORMA EXITOSA*****");
                            break;
                        case "entrenador":
                            System.out.println("\n Tipo de Entrenador: (Personal/General)");
                            String tipo = reader.readLine();
                            System.out.println("\nDirección: ");
                            String direc = reader.readLine();
                            System.out.println("\n Telefóno: ");
                            double telefon = Double.parseDouble(reader.readLine());

                            conexion.insertaEntrenador(conn, stmt, nombre, ApellidoP, ApellidoM, edadd, sex, nombreU, passwordUsuario, correo, direc, telefon, tipo);
                            conexion.crearUsuario(conn,stmt,nombreU, passwordUsuario, tipoUsuario);
                            conexion.darPermisosUsuario(conn,stmt,nombreU, passwordUsuario, tipoUsuario);
                            conexion.insertaUsuario(nombre, ApellidoP, ApellidoM, edadd, sex, nombreU, passwordUsuario, correo, tipoUsuario); //insertar en tabla usuarios
                            System.out.println("***** REGISTRO DE NUEVO USUARIO CONCLUIDO DE FORMA EXITOSA*****");
                            break;
                            
                        case "administrador":
                            System.out.println("\nDirección: ");
                            String direcc = reader.readLine();
                            System.out.println("\n Telefóno: ");
                            double telefonn = Double.parseDouble(reader.readLine());

                            conexion.insertaAdministrador(nombre, ApellidoP, ApellidoM, edadd, sex, nombreU, passwordUsuario, correo, direcc, telefonn);
                            conexion.crearUsuario(conn,stmt,nombreU, passwordUsuario, tipoUsuario);
                            conexion.darPermisosUsuario(conn,stmt,nombreU, passwordUsuario, tipoUsuario);
                            conexion.insertaUsuario(nombre, ApellidoP, ApellidoM, edadd, sex, nombreU, passwordUsuario, correo, tipoUsuario); //insertar en tabla usuarios
                            System.out.println("***** REGISTRO DE NUEVO USUARIO CONCLUIDO DE FORMA EXITOSA*****");
                            break;

                        case "regresar":

                            break;
                        default:
                            System.out.println("OPCIÓN INCORRECTA");
                    }

                    
                    

                    break;

                case 2:
                    
                    System.out.println("\nINTRODUCIR EL NOMBRE DE USUARIO, POR FAVOR");
                    String nombreUA = reader.readLine();              
                    conexion.busca(conn, stmt, nombreUA);

                    break;

                case 3:
                    System.out.println("\n INTRODUCIR EL NOMBRE DE USUARIO A ELIMINAR, POR FAVOR\n");
                    String numU;
                    numU = reader.readLine();
                    conexion.elimina(conn, numU);

                    break;

                case 4:
                    System.out.println("\n INTRODUCIR EL NOMBRE DE USUARIO A ELIMINAR, POR FAVOR\n");
                    String nomU;
                    nomU = reader.readLine();
                    System.out.println("\n¿QUÉ DESEA MODIFICAR?: \n1: NOMBRE PACIENTE\n2: CURP PACIENTE\n3: Número teléfonico del paciente\n4: Salir");
                    int opMof;
                    opMof = sc.nextInt();
                    switch (opMof) {
                        case 1:
                            System.out.println("NOMBRE DEL USUARIO");
                            String nombreM = reader.readLine();
                            //hacer el sql
                            System.out.println("\nNOMBRE MODIFICADO CON EXITO");
                            break;
                        case 2:
                            System.out.println("\nCONTRASEÑA:\n");
                            String CURPM = reader.readLine();

                            System.out.println("\nCONTRASEÑA MODIFICADO CON EXITO\n");
                            break;

                        case 3:
                            System.out.println("Correo electrónico");
                            String nuevoN = reader.readLine();

                            System.out.println("\nCORREO MODIFICADO CON EXITO\n");
                            break;

                        default:
                            System.out.println("\nOPCIÓN INCORRECTA");

                    }
                    break;

                case 5:
                    
                    /*VAMOS A LLAMAR DEPENDIENTO DE QUE TABLA SEA PARA MOSTRAR.
                    
                    System.out.println("¿QUÉ TABLA DESEA VISUALIZAR?:  \n1: Tabla Socios \n2: Tabla Entrenadores \n3: Tabla Administradores \n4: Usuarios \n5: Regresar");
                    int stabla= Integer.parseInt(reader.readLine());
                    ResultSet resultSett = null;
                    
                    switch(stabla){
                        
                        case 1:   conexion.visualizaTSocios(conn, stmt); visualizaMenuAdministrativo(); break;
                        case 2:   conexion.visualizaTEntrenadores(conn, stmt, resultSett); visualizaMenuAdministrativo();  break;
                        case 3:   conexion.visualizaTUAdministradores(conn, stmt, resultSett); visualizaMenuAdministrativo();  break;
                        case 4:   conexion.visualizaTUsuarios(conn, stmt, resultSett);visualizaMenuAdministrativo();  break;
                        case 5:     break;
                        default: System.out.println("OPCIÓN INCORRECTA");
                    }
                    
                    
                    //conexion.visualizaTUsuarios(conn, stmt, resultSett);

                case 6:
                    return;
                default:
                    System.out.println("Opción incorrecta");
            }

        } while (option != 6);

    }

    public void VisualizaMenuSocio() {

    }

    public void VisualizaMenuEntrenador() {

    }

*/
}
