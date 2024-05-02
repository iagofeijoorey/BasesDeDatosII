package baseDatos;
import aplicacion.Acolito;
import aplicacion.TipoAcolito;
import aplicacion.Trato;

import java.sql.*;
import java.util.ArrayList;


public class DAOAcolitos extends AbstractDAO {

   public DAOAcolitos(Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Boolean comprobarAutentificacion(String alias, String contraseña) {
        Boolean booleanValor = null;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement("SELECT * " +
                    "FROM acólitos " +
                    "WHERE alias = ?");
            stmUsuario.setString(1, alias);
            rsUsuario = stmUsuario.executeQuery();
            if (rsUsuario.next()) {
                // El usuario existe, ahora verificamos la contraseña
                String contraseñaBD = rsUsuario.getString("contraseña");
                if (contraseña.equals(contraseñaBD)) {
                    // Las contraseñas coinciden, creamos el objeto Acolito
                    booleanValor = true;
                }
                else booleanValor = false;
            } else booleanValor = false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmUsuario != null) {
                    stmUsuario.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return booleanValor;
    }


    public Acolito devolverUsuario(String alias, String contraseña) {
        Acolito resultado = null;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario, rsTipo;

        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement("SELECT * " +
                    "FROM acólitos " +
                    "WHERE alias = ?");
            stmUsuario.setString(1, alias);
            rsUsuario = stmUsuario.executeQuery();
            if (rsUsuario.next()) {
                // El usuario existe, ahora verificamos la contraseña
                String contraseñaBD = rsUsuario.getString("contraseña");
                if (contraseña.equals(contraseñaBD)) {
                    // Las contraseñas coinciden, creamos el objeto Acolito
                    resultado = new Acolito(rsUsuario.getString("alias"), contraseñaBD,
                            rsUsuario.getString("nombrecompleto"), rsUsuario.getString("direccion"),
                            rsUsuario.getInt("influencia"), null);

                    stmUsuario = con.prepareStatement("WITH todas_las_tablas AS (\n" +
                            "    SELECT alias, 'cabecillas' AS tabla FROM cabecillas\n" +
                            "    UNION\n" +
                            "    SELECT alias, 'gestor_interno' AS tabla FROM gestor_interno\n" +
                            "    UNION\n" +
                            "    SELECT alias, 'miembros_basicos' AS tabla FROM miembros_basicos\n" +
                            "    UNION\n" +
                            "    SELECT alias, 'guia_espiritual' AS tabla FROM guia_espiritual\n" +
                            ")\n" +
                            "SELECT * FROM todas_las_tablas WHERE alias = ?;");
                    stmUsuario.setString(1, alias);
                    rsTipo = stmUsuario.executeQuery();
                    if (rsTipo.next()) {
                        String tipo = rsTipo.getString("tabla");
                        switch (tipo) {
                            case "cabecillas": resultado.setTipo(TipoAcolito.Cabecilla); break;
                            case "gestor_interno": resultado.setTipo(TipoAcolito.Gestor); break;
                            case "miembros_basicos": resultado.setTipo(TipoAcolito.Normal); break;
                            case "guia_espiritual": resultado.setTipo(TipoAcolito.LiderEspiritual); break;
                        }
                    }

                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmUsuario != null) {
                    stmUsuario.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }


    /*
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
          try {
              assert stmUsuario != null;
              stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
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
            stmUsuario.setInt(5, acolito.getDinero());
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
    }*/
}
