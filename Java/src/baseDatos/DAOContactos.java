/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Acolito;
import aplicacion.Contacto;
import aplicacion.Trato;
import aplicacion.TipoTrato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

/*
 * DAO de Contactos y Tratos
 * @author basesdatos
 */
public class DAOContactos extends AbstractDAO {

   public DAOContactos(Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    /*
    Crear un contacto si no existe en la base de datos
     */
    public void crearContacto(String acolito, String contacto){
        Connection con;
        PreparedStatement stmContactos = null;

        con = this.getConexion();

        /*String consulta = "INSERT INTO sersolocontacto (contacto, acólito)" +
                "VALUES (?, ?)";
        try {
            stmContactos = con.prepareStatement(consulta);
            stmContactos.setString(1, contacto);
            stmContactos.setString(2, acolito);

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
    }*/

    }

    public Contacto crearContacto(String pseudonimo, String nombre, String telefono, String descripcion) {
        Contacto contacto = null;
        Connection con;
        PreparedStatement stmContactos = null;
        ResultSet rsContactos, rsContactos2;

        con = this.getConexion();

        /*String consulta = "select * from contactos where pseudonimo = ?";

        try {
            stmContactos = con.prepareStatement(consulta);
            stmContactos.setString(1, pseudonimo);

            rsContactos = stmContactos.executeQuery();
            if(rsContactos.next()) {
                contacto = new Contacto(rsContactos.getString("pseudonimo"), rsContactos.getString("nombre"),
                        rsContactos.getString("descripcion"), rsContactos.getInt("telefono"));
            } else {
                String consulta2 = "INSERT INTO contactos (pseudonimo, nombre, telefono, descripcion)" +
                " VALUES (?, ?, ?, ?);";

                stmContactos = con.prepareStatement(consulta2);
                stmContactos.setString(1, pseudonimo);
                stmContactos.setString(2, nombre);
                stmContactos.setInt(3, Integer.parseInt(telefono));
                stmContactos.setString(4, descripcion);

                stmContactos.executeUpdate();

                contacto = crearContacto(pseudonimo, nombre, telefono, descripcion);
            }
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
        }*/
        return contacto;
    }

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

        /*String consulta =  "SELECT contacto " +
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
                consulta = "SELECT * FROM contacto WHERE pseudonimo = ?";

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
        }*/
        return resultado;
   }

    /*
     Se elimina un contacto de la base de datos (no puede tener tratos contigo)
     */
   public void eliminarContacto(String contacto){
       Connection con;
       PreparedStatement stmContactos = null;

       con=this.getConexion();

       /*if(!hayTratos(contacto)) {
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
       }*/
   }

   /*
    Tras realizar cambios en un contacto, se actualiza la base de datos
    */
    public void actualizarContacto(String pseudonimo, String nombre, String telefono, String descripcion){
        Connection con;
        PreparedStatement stmContactos = null;

        con=this.getConexion();

        /*String consulta = "update contacto " +
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
        }*/
    }

    /*
    Comprobar si un contacto y acólito dados tienen tratos entre ellos
     */
    public boolean hayTratos(String acolito, String contacto){
        Connection con;
        PreparedStatement stmContactos = null;
        ResultSet rsTratos;

        con=this.getConexion();

        /*String consulta = "select count(*) " +
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
        }*/

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

        /*String consulta = "select count(*) " +
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
        }*/

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

       /* String consulta = "select * " +
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
*/
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

        /*String consulta = "select * " +
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
        }*/

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

        /*if(!hayTratos(acolito, contacto)) {
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
        }*/
    }

    /*
    TRANSACCION - Rompe un trato. Si es el único que une al acólito y al contacto, se cambia a la tabla de sersolocontacto
     */
    public void romperTrato(Trato trato) {
        Connection con;
        PreparedStatement stmContactos = null;

        con = this.getConexion();

        /*String consulta = "delete from tratos where idTrato = ? ";
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

        if (!hayTratos(trato.getAcolito(), trato.getContacto())) {
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
        }*/
    }
}