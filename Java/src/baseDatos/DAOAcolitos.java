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
            String sql = "select a.*, " +
                    "       case " +
                    "           when c.alias is not null then 'Cabecilla' " +
                    "           when g.alias is not null then 'Gestor' " +
                    "           when gd.alias is not null then 'GuiaEspiritual' " +
                    "           when jd.alias is not null then 'JefeDivision' " +
                    "           when mb.alias is not null then 'Normal' " +
                    "           end as tipo, " +
                    "       mb.jefe as jefeDivision, " +
                    "       jd.nombreDivision as nombreDivision " +
                    "from acólitos a " +
                    "         left join cabecillas c on a.alias = c.alias " +
                    "         left join gestor_interno g on a.alias = g.alias " +
                    "         left join guia_espiritual gd on a.alias = gd.alias " +
                    "         left join jefes_de_division jd on a.alias = jd.alias " +
                    "         left join miembros_basicos mb on a.alias = mb.alias " +
                    "where a.alias = ? and contraseña = ?";

            stmUsuario = con.prepareStatement(sql);
            stmUsuario.setString(1, alias);
            stmUsuario.setString(2, contraseña);
            rsUsuario = stmUsuario.executeQuery();
            if (rsUsuario.next()) {
                resultado = new Acolito(alias, contraseña, rsUsuario.getString("fechaingreso"), rsUsuario.getString("nombreCompleto"),
                        rsUsuario.getDouble("dinero"), rsUsuario.getInt("telefono"), rsUsuario.getString("direccion"),
                        rsUsuario.getInt("influencia"), TipoAcolito.stringToTipoAcolito("tipo"), rsUsuario.getBoolean("primeraEntrada"),
                        rsUsuario.getString("jefeDivision"), rsUsuario.getString("nombreDivision"));
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
        stmUsuario.setDouble(6, acolito.getDinero());
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
                case Cabecilla -> stmUsuario=con.prepareStatement("insert into cabecillas(alias) values (?)");
                case JefeDivision -> stmUsuario=con.prepareStatement("insert into jefes_de_division(alias) values (?)");
                case Normal -> stmUsuario=con.prepareStatement("insert into miembros_basicos(alias) values (?)");
                case GuiaEspiritual -> stmUsuario=con.prepareStatement("insert into guia_espiritual(alias) values (?)");
                case Gestor -> stmUsuario=con.prepareStatement("insert into gestor_interno(alias) values (?)");
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

    public void actualizarAcolito(Acolito acolito){
        Connection con;
        PreparedStatement stmUsuario=null;

        con=super.getConexion();

        try {
            stmUsuario=con.prepareStatement("update acólitos "+
                    "set nombrecompleto = ?, telefono = ?, direccion = ?, influencia = ?, dinero = ?, contraseña = ? "+
                    "where alias = ?");
            stmUsuario.setString(1, acolito.getNombreCompleto());
            stmUsuario.setInt(2, acolito.getTelefono());
            stmUsuario.setString(3, acolito.getDireccion());
            stmUsuario.setInt(4, acolito.getInfluencia());
            stmUsuario.setDouble(5, acolito.getDinero());
            stmUsuario.setString(6, acolito.getContraseña());
            stmUsuario.setString(7, acolito.getAlias());
            stmUsuario.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    public void actualizarAcolito(String alias, String nombre, String ciudad, String pais){
       //HACER DAO
    }

    // VENTANA VACOLITOS
    public ArrayList<String> obtenerAliasAcolitos() {

        ArrayList<String> listaAlias = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmUsuario = null;
        ResultSet rs = null;

        try {
            con = super.getConexion();
            stmUsuario = con.prepareStatement("select alias from acólitos");
            rs = stmUsuario.executeQuery();

            while (rs.next()) {
                String alias = rs.getString("alias");
                listaAlias.add(alias);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                assert stmUsuario != null;
                stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }

        return listaAlias;
    }

    public Acolito obtenerAcolito(String alias) {

        Acolito acolito = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = super.getConexion();

            // Consulta para obtener información del acólito y su tipo, el nombre de la división si es un jefe de división y el jefe asociado
            // si es un miembro básico (y si es que está asociado, que puede no estarlo)
            String sql = "select a.*, " +
                    "       case " +
                    "           when c.alias is not null then 'Cabecilla' " +
                    "           when g.alias is not null then 'Gestor' " +
                    "           when gd.alias is not null then 'GuiaEspiritual' " +
                    "           when jd.alias is not null then 'JefeDivision' " +
                    "           when mb.alias is not null then 'Normal' " +
                    "           end as tipo, " +
                    "       mb.jefe as jefeDivision, " +
                    "       jd.nombreDivision as nombreDivision " +
                    "from acólitos a " +
                    "         left join cabecillas c on a.alias = c.alias " +
                    "         left join gestor_interno g on a.alias = g.alias " +
                    "         left join guia_espiritual gd on a.alias = gd.alias " +
                    "         left join jefes_de_division jd on a.alias = jd.alias " +
                    "         left join miembros_basicos mb on a.alias = mb.alias " +
                    "where a.alias like ?";

            stm = con.prepareStatement(sql);
            stm.setString(1, "%"+alias+"%");
            rs = stm.executeQuery();

            if (rs.next()) {
                // Crear un objeto Acolito recuperando los datos de la base de datos
                acolito = new Acolito(alias, rs.getString("contraseña"), rs.getString("fechaingreso"), rs.getString("nombreCompleto"),
                        rs.getDouble("dinero"), rs.getInt("telefono"), rs.getString("direccion"),
                        rs.getInt("influencia"), TipoAcolito.stringToTipoAcolito("tipo"), rs.getBoolean("primeraEntrada"),
                        rs.getString("jefeDivision"), rs.getString("nombreDivision"));
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                assert stm != null;
                stm.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }

        return acolito;
    }
}
