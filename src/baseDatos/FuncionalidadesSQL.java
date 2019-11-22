/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juanm
 */
public class FuncionalidadesSQL {

    PreparedStatement ps;  //para usar en toda la BD
    ResultSet rs;       //para usar en toda la BD

    public FuncionalidadesSQL() {

    }

    //MÉTODO PARA CREAR AL USUARIO
    public void insertaUsuario(String nombre, String apellidoP, String apellidoM, int edad, String sex, String nombreU, String password, String correo,
            String tipo) {

        Connection co = null;
        Statement st = null;

        try {
            co = Conectar.getCon();
            st = co.createStatement();
            st.executeUpdate("INSERT INTO usuarios (nombre,APaterno,AMaterno,Edad,Sexo,NombreUsuario,Contraseña,Correo,TipoUsuario) "
                    + "VALUES('" + nombre + "','" + apellidoP + "','" + apellidoM + "'," + edad + ",'" + sex + "','" + nombreU + "','" + password + "','" + correo + "','" + tipo + "')");
            System.out.println("USUARIO INSERTADO");
        } catch (SQLException e) {
            System.out.println("error: no se pudo conectar a base de datos : insertar a la tabla usuarios");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("error al ejecutar el comando de BD");
            e.printStackTrace();
        } finally {
            try {
                st.close();
                co.close();
            } catch (SQLException e) {
            }

        }

    }

    public void crearUsuario(Connection conn, Statement stmt, String nombreU, String password, String tipo) {
        conn = null;
        stmt = null;

        try {
            conn = Conectar.getCon();
            stmt = conn.createStatement();
            stmt.executeUpdate("CREATE USER '" + nombreU + "'@'localhost' IDENTIFIED BY '" + password + "'");  //para crear usuario.

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error: no se pudo conectar a base de datos : CREAR USUARIO");
        } catch (Exception e) {
            System.out.println("error al ejecutar el comando de BD");
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }

        }

    }

    public void darPermisosUsuario(Connection conn, Statement stmt, String nombreU, String password, String tipo) {
        conn = null;
        stmt = null;

        try {
            conn = Conectar.getCon();
            stmt = conn.createStatement();

            if (tipo.equalsIgnoreCase("socio")) {
                stmt.executeQuery("GRANT SELECT ON bp.membresias TO '" + nombreU + "'@'localhost'");
                System.out.println("permisos socio");
            }

            if (tipo.equalsIgnoreCase("entrenador")) {
                stmt.execute("GRANT SELECT ON bp.socios TO '" + nombreU + "'@'localhost'");  //para que pueda visualizar todos los socios :v
                //stmt.execute("FLUSH PRIVILEGES");  //guardar privilegios
                System.out.println("permisos entre");
            }

            if (tipo.equalsIgnoreCase("administrador")) {
                stmt.execute("GRANT ALL PRIVILEGES ON bp.* TO '" + nombreU + "'@'localhost'");
                System.out.println("permisos admin");

            }
        } catch (SQLException e) {
            System.out.println("error: no se pudo conectar a base de datos : DARPERMISOS");
        } catch (Exception e) {
            System.out.println("error al ejecutar el comando de BD");
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }

        }

    }

    //MÉTODO PARA INSERTAR A UN SOCIO. 
    public void insertaSocio(Connection conn, Statement stmt, String Nombre, String ApellidoP, String ApellidoM, int Edad, String Sexo, String NombreU, String Password, String Correo,
            float Altura, int Peso, float IMC, int idM) {
        int resultado=0;    
        conn = null;
        stmt = null;

        try {
            conn = Conectar.getCon();
            stmt = conn.createStatement();
            /*
            stmt.executeUpdate("INSERT INTO socios (Nombre,ApellidoP,ApellidoM,Edad,Sexo,NombreU,Password,Correo,Altura,Peso,IMC,idM) "
                    + "VALUES('" + nombre + "','" + apellidoP + "','" + apellidoM + "'," + edad + ",'" + sex + "','" + nombreU + "','"+password+"','"+correo+"',"+altura+","+peso+","+IMC+","+idM+")");
             */

            ps = conn.prepareStatement("INSERT INTO socios (Nombre,ApellidoP,ApellidoM,Edad,Sexo,NombreU,Password,Correo,Altura,Peso,IMC,idM) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, Nombre);
            ps.setString(2, ApellidoP);
            ps.setString(3, ApellidoM);
            ps.setInt(4, Edad);
            ps.setString(5, Sexo);
            ps.setString(5, NombreU);
            ps.setString(6, Password);
            ps.setString(7, Correo);
            ps.setFloat(8, Altura);
            ps.setInt(9, Peso);
            ps.setFloat(10, IMC);
            ps.setInt(11, idM);
            
            resultado=ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            System.out.println("error: no se pudo conectar a base de datos: insertar socio");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("error al ejecutar el comando de BD");
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }

        }

    }

    public void insertaEntrenador(Connection conn, Statement stmt, String nombre, String apellidoP, String apellidoM, int edad, String sex, String nombreU, String password, String correo,
            String direccion, double telefono, String tipo) {

        try {
            conn = Conectar.getCon();
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO entrenadores(nombre,APaterno,AMaterno,Edad,Sexo,NombreUsuario,Contraseña,Correo,Direccion,Telefono,Tipo)"
                    + "VALUES('" + nombre + "','" + apellidoP + "','" + apellidoM + "'," + edad + ",'" + sex + "','" + nombreU + "','" + password + "',"
                    + "'" + correo + "','" + direccion + "','" + telefono + "','" + tipo + "')");

        } catch (SQLException e) {
            System.out.println("error: no se pudo conectar a base de datos : insertarENTRENADOR");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("error al ejecutar el comando de BD");
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }

        }

    }

    public void insertaAdministrador(String nombre, String apellidoP, String apellidoM, int edad, String sex, String nombreU, String password, String correo, String direccion, double telefono) {
        Connection p = null;
        Statement r = null;
        try {
            p = Conectar.getCon();
            r = p.createStatement();
            r.executeUpdate("INSERT INTO administradores (nombre,APaterno,AMaterno,Edad,Sexo,NombreUsuario,Contraseña,Correo,Direccion,Telefono) "
                    + "VALUES('" + nombre + "','" + apellidoP + "','" + apellidoM + "'," + edad + ",'" + sex + "','" + nombreU + "','" + password + "','" + correo + "' ,'" + direccion + "'," + telefono + ")");
            System.out.println("administrador insertador");

        } catch (SQLException e) {
            System.out.println("error: no se pudo conectar a base de datos: insertarADMIN");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("error al ejecutar el comando de BD");
            e.printStackTrace();
        } finally {
            try {
                r.close();
                p.close();
            } catch (SQLException e) {
            }

        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////77
    public void visualizaTUsuarios(Connection conn, Statement stmt, ResultSet resultSet) {
        // para manejar los resultados
        stmt = null;
        conn = null;
        try {
            conn = Conectar.getCon();
            //System.out.println("VALOR DE COON" + conn );
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT*FROM usuarios");
            ResultSetMetaData metaDatos = resultSet.getMetaData();
            int numCols = metaDatos.getColumnCount();
            System.out.println("Tabla nombreTabla de la BD nombreBD: usuarios \n");
            for (int i = 1; i <= numCols; i++) {
                System.out.printf("%-8s\t", metaDatos.getColumnName(i));
            }

            while (resultSet.next()) {
                System.out.println();
                for (int i = 1; i <= numCols; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("error: no se pudo establecer conexión con BD");
        } catch (Exception e) {
            System.out.println("other error:");
        } finally {
            try {
                resultSet.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    public void visualizaTSocios(Connection conn, Statement stmt) {
        // para manejar los resultados
        ResultSet resultSet = null;
        stmt = null;
        conn = null;
        try {
            conn = Conectar.getCon();
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT*FROM socios");
            ResultSetMetaData metaDatos = resultSet.getMetaData();
            int numCols = metaDatos.getColumnCount();
            System.out.println("Tabla nombreTabla de la BD nombreBD: SOCIOS \n");
            for (int i = 1; i <= numCols; i++) {
                System.out.printf("%-8s\t", metaDatos.getColumnName(i));
            }

            while (resultSet.next()) {
                System.out.println();
                for (int i = 1; i <= numCols; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("error: no se pudo establecer conexión con BD");
        } catch (Exception e) {
            System.out.println("other error:");
        } finally {
            try {
                resultSet.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    public void visualizaTUAdministradores(Connection conn, Statement stmt, ResultSet resultSet) {
        // para manejar los resultados
        stmt = null;
        conn = null;
        try {
            conn = Conectar.getCon();
            //System.out.println("VALOR DE COON" + conn );
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT*FROM administradores");
            ResultSetMetaData metaDatos = resultSet.getMetaData();
            int numCols = metaDatos.getColumnCount();
            System.out.println("Tabla nombreTabla de la BD nombreBD: Administradores \n");
            for (int i = 1; i <= numCols; i++) {
                System.out.printf("%-8s\t", metaDatos.getColumnName(i));
            }

            while (resultSet.next()) {
                System.out.println();
                for (int i = 1; i <= numCols; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("error: no se pudo establecer conexión con BD");
        } catch (Exception e) {
            System.out.println("other error:");
        } finally {
            try {
                resultSet.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    public void visualizaTEntrenadores(Connection conn, Statement stmt, ResultSet resultSet) {
        // para manejar los resultados
        stmt = null;
        conn = null;
        try {
            conn = Conectar.getCon();
            //System.out.println("VALOR DE COON" + conn );
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT*FROM entrenadores");
            ResultSetMetaData metaDatos = resultSet.getMetaData();
            int numCols = metaDatos.getColumnCount();
            System.out.println("Tabla nombreTabla de la BD nombreBD: Entrenadores \n");
            for (int i = 1; i <= numCols; i++) {
                System.out.printf("%-8s\t", metaDatos.getColumnName(i));
            }

            while (resultSet.next()) {
                System.out.println();
                for (int i = 1; i <= numCols; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("error: no se pudo establecer conexión con BD");
        } catch (Exception e) {
            System.out.println("other error:");
        } finally {
            try {
                resultSet.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    public void visualizaTMembresias(Connection conn, Statement stmt, ResultSet resultSet) {
        // para manejar los resultados
        stmt = null;
        conn = null;
        try {
            conn = Conectar.getCon();
            //System.out.println("VALOR DE COON" + conn );
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("SELECT*FROM membresias");
            ResultSetMetaData metaDatos = resultSet.getMetaData();
            int numCols = metaDatos.getColumnCount();
            System.out.println("Tabla nombreTabla de la BD nombreBD: \n");
            for (int i = 1; i <= numCols; i++) {
                System.out.printf("%-8s\t", metaDatos.getColumnName(i));
            }

            while (resultSet.next()) {
                System.out.println();
                for (int i = 1; i <= numCols; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("error: no se pudo establecer conexión con BD");
        } catch (Exception e) {
            System.out.println("other error:");
        } finally {
            try {
                resultSet.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    public void busca(Connection conn, Statement stmt, String nombreU) {
        // para manejar los resultados

        conn = null;
        stmt = null;
        ResultSet resultSet;
        try {
            conn = Conectar.getCon();

            stmt = conn.createStatement();
            stmt.executeUpdate("SELECT*FROM bp.usuarios WHERE NombreU='" + nombreU + "'");

        } catch (SQLException e) {
            System.out.println("error: no se pudo conectar a base de datos en busqued");
        } catch (Exception e) {
            System.out.println("error al ejecutar el comando de BD");
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }

        }

    }

    public void elimina(Connection conn, String nombreU) {
        conn = null;
        Statement stmt = null;

        try {
            conn = Conectar.getCon();
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM usuarios WHERE NombreU='" + nombreU + "'");
        } catch (SQLException e) {
            System.out.println("error: no se pudo conectar a base de datos");
        } catch (Exception e) {
            System.out.println("error al ejecutar el comando de BD");
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }

        }
    }

    public void privilegioSocio(Connection conn, String nombreU) {

        Statement stmt = null;

        try {
            conn = Conectar.getCon();
            stmt = conn.createStatement();
            stmt.executeUpdate("GRANT SELECT ON bp.r TO '" + nombreU + " '@'localhost'");
            System.out.println("PRIVILEGIOS");
        } catch (SQLException e) {
            System.out.println("error: no se pudo conectar a base de datos");
        } catch (Exception e) {
            System.out.println("error al ejecutar el comando de BD");
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }

        }
    }

}
