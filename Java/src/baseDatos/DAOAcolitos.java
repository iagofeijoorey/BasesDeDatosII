/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.Acolito;
import aplicacion.TipoAcolito;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author basesdatos
 */
public class DAOAcolitos extends AbstractDAO {

   public DAOAcolitos(Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Acolito validarLogin(String alias, String contraseña) {
        Acolito resultado = null;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement("select alias, contraseña " +
                    "from acólitos " +
                    "where alias = ? and contraseña = ?");
            stmUsuario.setString(1, alias);
            stmUsuario.setString(2, contraseña);
            rsUsuario = stmUsuario.executeQuery();
            if (rsUsuario.next()) {
                resultado = new Acolito(rsUsuario.getString("alias"), rsUsuario.getString("contraseña"),
                        rsUsuario.getString("nombrecompleto"), rsUsuario.getString("direccion"), 0
                        , TipoAcolito.valueOf(rsUsuario.getString("tipo_usuario")));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                assert stmUsuario != null;
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    public ArrayList<Acolito> consultarAcolitos(String alias, String nombre){
        java.util.ArrayList<Acolito> resultado = new java.util.ArrayList<Acolito>();
        Acolito acolitoActual;
        Connection con;
        PreparedStatement stmUsuarios=null;
        ResultSet rsUsuarios;

        con=this.getConexion();

        String consulta =   "SELECT u.nombrecompleto, u.alias,\n" +
                "       CASE\n" +
                "           WHEN public.cabecillas.alias IS NOT NULL THEN 'Cabecilla' " +
                "           WHEN public.gestor_interno.alias IS NOT NULL THEN 'Gestor' " +
                "           WHEN public.jefes_de_division.alias IS NOT NULL THEN 'JefeDivision' " +
                "           WHEN public.miembros_basicos.alias IS NOT NULL THEN 'Normal' " +
                "           WHEN public.guia_espiritual.alias IS NOT NULL THEN 'LiderEspiritual' " +
                "           ELSE 'tipo_desconocido' " +
                "           END AS tipo\n" +
                "FROM acólitos u " +
                "         LEFT JOIN public.cabecillas ON u.alias = cabecillas.alias " +
                "         LEFT JOIN public.gestor_interno ON u.alias = gestor_interno.alias " +
                "         LEFT JOIN public.jefes_de_division ON u.alias = jefes_de_division.alias " +
                "         LEFT JOIN public.miembros_basicos ON u.alias = miembros_basicos.alias " +
                "         LEFT JOIN public.guia_espiritual ON u.alias = guia_espiritual.alias " +
                "WHERE u.alias LIKE ? OR u.nombrecompleto LIKE ?";


        try  {
            stmUsuarios=con.prepareStatement(consulta);
            stmUsuarios.setString(1, "%"+alias+"%");
            stmUsuarios.setString(2, "%"+nombre+"%");

            rsUsuarios=stmUsuarios.executeQuery();
            while (rsUsuarios.next())
            {
                acolitoActual = new Acolito(rsUsuarios.getString("alias"), rsUsuarios.getString("contraseña"),
                        rsUsuarios.getString("nombrecompleto"), rsUsuarios.getString("direccion"),
                        rsUsuarios.getInt("influencia"),  TipoAcolito.stringToTipoAcolito(rsUsuarios.getString("tipo")));


                resultado.add(acolitoActual);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                assert stmUsuarios != null;
                stmUsuarios.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public void insertarAcolito(Acolito acolito){
        Connection con;
        PreparedStatement stmUsuario=null;

        con=super.getConexion();

        // AÑADIR A ACÓLITOS
        try {
        stmUsuario=con.prepareStatement("insert into acólitos(alias, nombrecompleto,fechaingreso,telefono,direccion,influencia,dinero,contraseña, influencia, primeraentrada) "+
                                      "values (?,?,?,?,?,?,?,?,?,?)");
        stmUsuario.setString(1, acolito.getAlias());
        stmUsuario.setString(2, acolito.getNombreCompleto());
        stmUsuario.setString(3,acolito.getFechaingreso());
        stmUsuario.setInt(4,acolito.getTelefono());
        stmUsuario.setInt(5,acolito.getInfluencia());
        stmUsuario.setInt(6, acolito.getDinero());
        stmUsuario.setString(7, acolito.getContraseña());
        stmUsuario.setBoolean(8,true);
        stmUsuario.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {
              assert stmUsuario != null;
              stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        // AÑADIR A LA TABLA DE TIPO CORRESPONDIENTE
        try {
            switch (acolito.getTipo()){
                case TipoAcolito.Cabecilla -> stmUsuario=con.prepareStatement("insert into cabecillas(alias) values (?)");
                case TipoAcolito.JefeDivision -> stmUsuario=con.prepareStatement("insert into jefes_de_division(alias) values (?)");
                case TipoAcolito.Normal -> stmUsuario=con.prepareStatement("insert into miembros_basicos(alias) values (?)");
                case TipoAcolito.LiderEspiritual -> stmUsuario=con.prepareStatement("insert into guia_espiritual(alias) values (?)");
                case TipoAcolito.Gestor -> stmUsuario=con.prepareStatement("insert into gestor_interno(alias) values (?)");
            }
            stmUsuario.setString(1,acolito.getAlias());
            stmUsuario.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void borrarAcolito(Acolito acolito){
        Connection con;
        PreparedStatement stmUsuario=null;

        con=super.getConexion();

        try {
        stmUsuario=con.prepareStatement("delete from acólitos where alias = ?");
        stmUsuario.setString(1, acolito.getAlias());
        stmUsuario.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

}
