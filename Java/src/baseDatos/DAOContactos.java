/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Acolito;
import aplicacion.Contacto;
import aplicacion.TipoAcolito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author basesdatos
 */
public class DAOContactos extends AbstractDAO {

   public DAOContactos(Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }


    public void insertarContacto(Contacto contacto, Acolito acolito){
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsIdUsuario;
        String idUsuario=null;

        con=super.getConexion();
        try {
            stmUsuario=con.prepareStatement("insert into contactos(pseudonimo, nombre, telefono, descripcion) "+
                                          "values (?,?,?,?)");
            stmUsuario.setString(1, contacto.getPseudonimo());
            stmUsuario.setString(2, contacto.getNombre());
            stmUsuario.setInt(3, contacto.getTelefono());
            stmUsuario.setString(4, contacto.getDescripcion());
            stmUsuario.executeUpdate();
            if (contacto.getTratos().isEmpty()) {
                stmUsuario = con.prepareStatement("insert into sersolocontacto(contacto, acólito) values (?,?)");
                stmUsuario.setString(1, contacto.getPseudonimo());
                stmUsuario.setString(1, contacto.getPseudonimo());
            }
            else{
                //todo implementación de tratos entera
                System.out.println("Easter egg");
            }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

    /**
     * Consultar contacto genérico (creo que no se usa, no la voy a implementar aún)
     */
    public java.util.List<Contacto>  consultarContactos(String pseudonimo, String nombre){
        java.util.ArrayList<Contacto> resultado = new java.util.ArrayList<Contacto>();
        Contacto contactoActual;
        Connection con;
        PreparedStatement stmContactos=null;
        ResultSet rsContactos, rsAcolito;

        con=this.getConexion();

        String consulta =   "SELECT c.* " +
                             "FROM contactos c " +
                            "WHERE c.pseudonimo like ? and c.nombre like ?";
        try  {
            stmContactos=con.prepareStatement(consulta);
            stmContactos.setString(1, "%"+pseudonimo+"%");
            stmContactos.setString(2, "%"+nombre+"%");

            rsContactos=stmContactos.executeQuery();
            while (rsContactos.next())
            {
                contactoActual = new Contacto(rsContactos.getString("pseudonimo"), rsContactos.getString("nombre"),
                        rsContactos.getString("descripcion"), rsContactos.getInt("telefono"),
                         null);

                consulta = "select a.*, s.contacto from acólitos a join sersolocontacto s ON a.alias = s.acólito " +
                        "where s.contacto = ? " +
                        "union " +
                        "select a.*, s.contacto from acólitos a join tratos s ON a.alias = s.acólito " +
                        "where s.contacto = ? ";
                try  {
                    stmContactos=con.prepareStatement(consulta);
                    stmContactos.setString(1, contactoActual.getPseudonimo());
                    stmContactos.setString(2, contactoActual.getPseudonimo());
                    rsAcolito = stmContactos.executeQuery();
                    if (rsAcolito.next())
                    {
                        contactoActual.setAcolito(new Acolito(rsAcolito.getString("alias"), rsAcolito.getString("contraseña"),
                                rsAcolito.getString("nombrecompleto"), rsAcolito.getString("direccion"), rsAcolito.getInt("influencia"),
                                TipoAcolito.valueOf(rsAcolito.getString("tipo_usuario"))));
                    }
                } catch (SQLException e){
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                }finally{
                    try {
                        assert stmContactos != null;
                        stmContactos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
                }
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                assert stmContactos != null;
                stmContactos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
   }

    /**
     * Consultar contacto dado el acólito del que es contacto
     */
    public java.util.List<Contacto>  consultarContactosDeAcolito(Acolito acolito, String pseudonimo, String nombre){
        java.util.ArrayList<Contacto> resultado = new java.util.ArrayList<Contacto>();
        Contacto contactoActual;
        Connection con;
        PreparedStatement stmContactos=null;
        ResultSet rsContactos, rsAcolito;

        con=this.getConexion();

        String consulta =   "SELECT c.* " +
                "FROM contactos c "+
                "         INNER JOIN sersolocontacto ca ON c.pseudonimo = ca.contacto " +
                "WHERE ca.acólito LIKE ? AND (c.pseudonimo LIKE ? OR c.nombre LIKE ?) " +
                "UNION " +
                "SELECT c.* " +
                "FROM contactos c " +
                "         INNER JOIN tratos ca ON c.pseudonimo LIKE ca.contacto " +
                "WHERE ca.acólito LIKE ? AND (c.pseudonimo LIKE ? OR c.nombre LIKE ?)";
        try  {
            stmContactos=con.prepareStatement(consulta);
            stmContactos.setString(1, acolito.getAlias());
            stmContactos.setString(2, "%"+nombre+"%");
            stmContactos.setString(3, "%"+pseudonimo+"%");
            stmContactos.setString(4, acolito.getAlias());
            stmContactos.setString(5, "%"+pseudonimo+"%");
            stmContactos.setString(6, "%"+nombre+"%");

            rsContactos=stmContactos.executeQuery();
            while (rsContactos.next())
            {
                resultado.add(new Contacto(rsContactos.getString("pseudonimo"), rsContactos.getString("nombre"),
                        rsContactos.getString("descripcion"), rsContactos.getInt("telefono"),
                        acolito));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                assert stmContactos != null;
                stmContactos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    /**
     * Consultar contacto dado el nombre o alias aproximado (usamos %) del acólito del que es contacto
     */
    public java.util.List<Contacto>  consultarContactosDeAcolito(String aliasAcolito, String pseudonimoContacto, String nombreContacto){
        java.util.ArrayList<Contacto> resultado = new java.util.ArrayList<Contacto>();
        Contacto contactoActual;
        Connection con;
        PreparedStatement stmContactos=null;
        ResultSet rsContactos, rsAcolito;

        con=this.getConexion();

        String consulta =   "SELECT c.* " +
                "FROM contactos c "+
                "         INNER JOIN sersolocontacto ca ON c.pseudonimo = ca.contacto " +
                "WHERE ca.acólito LIKE ? AND (c.pseudonimo LIKE ? OR c.nombre LIKE ?) " +
                "UNION " +
                "SELECT c.* " +
                "FROM contactos c " +
                "         INNER JOIN tratos ca ON c.pseudonimo = ca.contacto " +
                "WHERE ca.acólito LIKE ? AND (c.pseudonimo LIKE ? OR c.nombre LIKE ?)";
        try  {
            stmContactos=con.prepareStatement(consulta);
            stmContactos.setString(1, "%"+aliasAcolito+"%");
            stmContactos.setString(2, "%"+nombreContacto+"%");
            stmContactos.setString(3, "%"+pseudonimoContacto+"%");
            stmContactos.setString(4, "%"+aliasAcolito+"%");
            stmContactos.setString(5, "%"+pseudonimoContacto+"%");
            stmContactos.setString(6, "%"+nombreContacto+"%");

            rsContactos=stmContactos.executeQuery();
            while (rsContactos.next())
            {
                contactoActual= new Contacto(rsContactos.getString("pseudonimo"), rsContactos.getString("nombre"),
                        rsContactos.getString("descripcion"), rsContactos.getInt("telefono"),
                        null);
                consulta = "select a.*, s.contacto from acólitos a join sersolocontacto s ON a.alias = s.acólito " +
                        "where s.contacto = ? " +
                        "union " +
                        "select a.*, s.contacto from acólitos a join tratos s ON a.alias = s.acólito " +
                        "where s.contacto = ? ";
                try  {
                    stmContactos=con.prepareStatement(consulta);
                    stmContactos.setString(1, contactoActual.getPseudonimo());
                    stmContactos.setString(2, contactoActual.getPseudonimo());
                    rsAcolito = stmContactos.executeQuery();
                    if (rsAcolito.next())
                    {
                        contactoActual.setAcolito(new Acolito(rsAcolito.getString("alias"), rsAcolito.getString("contraseña"),
                                rsAcolito.getString("nombrecompleto"), rsAcolito.getString("direccion"), rsAcolito.getInt("influencia"),
                                TipoAcolito.valueOf(rsAcolito.getString("tipo_usuario"))));
                        resultado.add(contactoActual);
                    }
                } catch (SQLException e){
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                }finally{
                    try {
                        assert stmContactos != null;
                        stmContactos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
                }
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                assert stmContactos != null;
                stmContactos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }


    public void borrarContacto(Contacto contacto){
        Connection con;
        PreparedStatement stmUsuario=null;

        con=super.getConexion();

        try {
            stmUsuario=con.prepareStatement("delete from contactos where pseudonimo = ?");
            stmUsuario.setString(1, contacto.getPseudonimo());
            stmUsuario.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
}