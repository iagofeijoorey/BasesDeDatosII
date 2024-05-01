/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Acolito;
import aplicacion.Contacto;
import aplicacion.TipoAcolito;
import aplicacion.Trato;
import aplicacion.TipoTrato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 * DAO de Contactos y Tratos
 * @author basesdatos
 */
public class DAOContactos extends AbstractDAO {

   public DAOContactos(Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

/*
    public void insertarContacto(Contacto contacto, Acolito acolito){
        Connection con;
        PreparedStatement stmUsuario=null;

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
                for (int i = 0; i < contacto.getTratos().size(); i++) {
                    stmUsuario = con.prepareStatement("insert into tratos(idtrato,tipotrato,contacto, acólito) values (?,?,?,?)");
                    stmUsuario.setInt(1, contacto.getTratos().get(i).getIdTrato());
                    stmUsuario.setString(2, contacto.getTratos().get(i).getTipoTrato().toString());
                    stmUsuario.setString(3, contacto.getPseudonimo());
                    stmUsuario.setString(4, contacto.getTratos().get(i).getAcolito().getAlias());

                    stmUsuario.executeUpdate();

                }
            }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {
              assert stmUsuario != null;
              stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
*/
    /*
     * TRANSACCIÓN - Consultar todos los contactos (con y sin tratos) de un acólito
     */
    public ArrayList<Contacto> consultarContactos(Acolito acolito){
        ArrayList<Contacto> resultado = new ArrayList<Contacto>();
        Contacto contactoActual;
        Connection con;
        PreparedStatement stmContactos = null;
        ResultSet rsContactos, rsContactos2;

        con=this.getConexion();

        String consulta =  "SELECT contacto " +
                           "FROM sersolocontacto " +
                           "WHERE acólito = ? " +
                           " UNION " +
                           "SELECT contacto " +
                           "FROM tratos " +
                           "WHERE acólito = ? ";
        try  {
            stmContactos=con.prepareStatement(consulta);
            stmContactos.setString(1, "%"+acolito.getAlias()+"%");

            rsContactos=stmContactos.executeQuery();
            while (rsContactos.next())
            {
                consulta = "SELECT * FROM contacto WHERE pseudonimo = ?"

                try {
                    stmContactos = con.prepareStatement(consulta);
                    stmContactos.setString(1, rsContactos.getString("pseudonimo"));

                    rsContactos2 = stmContactos.executeQuery();

                    while(rsContactos.next()){
                        contactoActual = new Contacto(rsContactos2.getString("pseudonimo"), rsContactos2.getString("nombre"),
                                rsContactos2.getString("descripcion"), rsContactos2.getInt("telefono"));
                        resultado.add(contactoActual);
                    }
                } catch (SQLException e){
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
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

    /*
     Se elimana un contacto de la base de datos (no puede tener tratos contigo)
     */
   public void eliminarContacto(String contacto){
       Connection con;
       PreparedStatement stmContactos = null;

       con=this.getConexion();

       if(!hayTratos(contacto)) {
           String consulta = "delete from sersolocontacto where contacto = ? ";
           try {
               stmContactos = con.prepareStatement(consulta);
               stmContactos.setString(1, contacto);

               stmContactos.executeUpdate();

           } catch (SQLException e) {
               System.out.println(e.getMessage());
               this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
           } finally {
               try {
                   assert stmContactos != null;
                   stmContactos.close();
               } catch (SQLException e) {
                   System.out.println("Imposible cerrar cursores");
               }
           }
       }
   }

   /*
    Tras realizar cambios en un contacto, se actualiza la base de datos
    */
    public void actualizarContacto(String pseudonimo, String nombre, String telefono, String descripcion){
        Connection con;
        PreparedStatement stmContactos = null;

        con=this.getConexion();

        String consulta = "update contacto " +
                "set nombre = ?, telefono = ?, descripcion = ? " +
                "where pseudonimo = ? ";
        try  {
            stmContactos=con.prepareStatement(consulta);
            stmContactos.setString(1, nombre);
            stmContactos.setString(2, telefono);
            stmContactos.setString(3, descripcion);
            stmContactos.setString(4, pseudonimo);

            stmContactos.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                assert stmContactos != null;
                stmContactos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

    /*
    Comprobar si un contacto y acólito dados tienen tratos entre ellos
     */
    public boolean hayTratos(String acolito, String contacto){
        Connection con;
        PreparedStatement stmContactos = null;
        ResultSet rsTratos;

        con=this.getConexion();

        String consulta = "select count(*) " +
                          "from tratos " +
                          "where acólito = ? and contacto = ?";
        try  {
            stmContactos=con.prepareStatement(consulta);
            stmContactos.setString(1, acolito);
            stmContactos.setString(2, contacto);

            rsTratos = stmContactos.executeQuery();

            if(rsTratos.next()) return true;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                assert stmContactos != null;
                stmContactos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }

        return false;
    }

    /*
    Comprobar si un contacto tiene tratos asociados
     */
    public boolean hayTratos(String contacto){
        Connection con;
        PreparedStatement stmContactos = null;
        ResultSet rsTratos;

        con=this.getConexion();

        String consulta = "select count(*) " +
                          "from tratos " +
                          "where contacto = ?";
        try  {
            stmContactos=con.prepareStatement(consulta);
            stmContactos.setString(1, contacto);

            rsTratos = stmContactos.executeQuery();

            if(rsTratos.next()) return true;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                assert stmContactos != null;
                stmContactos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }

        return false;
    }

    /*
    Obtener los tratos de un contacto y acólito dados
     */

    public ArrayList<Trato> obtenerTratos(String acolito, String contacto){
        ArrayList<Trato> resultado = new ArrayList<>();
        Trato tratoActual;
        Connection con;
        PreparedStatement stmContactos = null;
        ResultSet rsTratos;

        con=this.getConexion();

        String consulta = "select * " +
                          "from tratos " +
                          "where acolito = ? and contacto = ?";
        try  {
            stmContactos=con.prepareStatement(consulta);
            stmContactos.setString(1, acolito);
            stmContactos.setString(2, contacto);

            rsTratos = stmContactos.executeQuery();

            while(rsTratos.next()) {
                TipoTrato tipoTrato = TipoTrato.stringToTipTrato(rsTratos.getString("tipoTrato"));
                tratoActual = new Trato(rsTratos.getInt("idTrato"), tipoTrato,
                        rsTratos.getString("contacto"), rsTratos.getString("acólito"));
                resultado.add(tratoActual);
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

    /*
    Comprueba si existe algún trato con el identificador dado
     */

    public boolean existeTrato(Integer id){
        Connection con;
        PreparedStatement stmContactos = null;
        ResultSet rsTratos;

        con=this.getConexion();

        String consulta = "select * " +
                          "from tratos " +
                          "where idTrato = ?";
        try  {
            stmContactos=con.prepareStatement(consulta);
            stmContactos.setInt(1, id);

            rsTratos = stmContactos.executeQuery();

            if(rsTratos.next()) return true;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                assert stmContactos != null;
                stmContactos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }

        return false;
    }

    /*
    TRANSACCIÓN - Dado un acólito y un contacto, se establece un trato entre ellos.
    Se elimina de la tabla sersolocontacto de ser el primer trato
     */
    public void proponerTrato(ArrayList<String> datosTratos, String acolito, String contacto){
        Connection con;
        PreparedStatement stmContactos = null;

        con=this.getConexion();

        if(!hayTratos(acolito, contacto)) {
            //TRANSACCIÓN
            String consulta = "DELETE FROM sersolocontacto WHERE contacto = ? and acolito = ?";

            try {
                stmContactos = con.prepareStatement(consulta);
                stmContactos.setString(1, contacto);
                stmContactos.setString(2, acolito);

                stmContactos.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }

            String consulta2 = "INSERT INTO Tratos (idTrato, tipoTrato, contacto, acólito)" +
                    "VALUES (?, ?, ?, ?)";

            try {
                stmContactos = con.prepareStatement(consulta2);
                stmContactos.setInt(1, Integer.parseInt(datosTratos.get(0)));
                stmContactos.setString(2, datosTratos.get(1));
                stmContactos.setString(3, contacto);
                stmContactos.setString(4, acolito);

                stmContactos.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } finally {
                try {
                    assert stmContactos != null;
                    stmContactos.close();
                } catch (SQLException e) {
                    System.out.println("Imposible cerrar cursores");
                }
            }
        }
    }

    /*
    TRANSACCION - Rompe un trato. Si es el único que une al acólito y al contacto, se cambia a la tabla de sersolocontacto
     */
    public void romperTrato(Trato trato){
        Connection con;
        PreparedStatement stmContactos = null;

        con=this.getConexion();

        String consulta = "delete from tratos where idTrato = ? ";
        try {
            stmContactos = con.prepareStatement(consulta);
            stmContactos.setInt(1, trato.getIdTrato());

            stmContactos.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                assert stmContactos != null;
                stmContactos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        if(!hayTratos(trato.getAcolito(), trato.getContacto())){
            String consulta2 = "INSERT INTO sersolocontacto (contacto, acólito)" +
                    "VALUES (?, ?)";
            try {
                stmContactos = con.prepareStatement(consulta2);
                stmContactos.setString(1, trato.getContacto());
                stmContactos.setString(2, trato.getAcolito());

                stmContactos.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } finally {
                try {
                    assert stmContactos != null;
                    stmContactos.close();
                } catch (SQLException e) {
                    System.out.println("Imposible cerrar cursores");
                }
            }
        }
    }

   /*
    /**
     * Consultar

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
                        rsContactos.getString("descripcion"), rsContactos.getInt("telefono")));
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

    public List<Trato> consultarTratosContacto(Contacto contacto){
        java.util.ArrayList<Trato> resultado = new java.util.ArrayList<Trato>();
        Trato tratoActual;
        Connection con;
        PreparedStatement stmTratos=null;
        ResultSet rsTratos;

        con=this.getConexion();

        String consulta =   "SELECT t.* " +
                "FROM tratos t " +
                "WHERE t.contacto = ?";
        try  {
            stmTratos=con.prepareStatement(consulta);
            stmTratos.setString(1, contacto.getPseudonimo());

            rsTratos=stmTratos.executeQuery();
            while (rsTratos.next())
            {
                tratoActual = new Trato(rsTratos.getInt("idtrato"), TipoTrato.valueOf(rsTratos.getString("tipotrato")),
                        contacto, null);
                resultado.add(tratoActual);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                assert stmTratos != null;
                stmTratos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    */
}