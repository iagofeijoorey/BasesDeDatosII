/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.Acolito;
import aplicacion.FachadaAplicacion;
import aplicacion.PropiedadesYCuentas.*;
import aplicacion.TipoAcolito;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author basesdatos
 */

public class DAOPropiedades extends AbstractDAO {


    public DAOPropiedades(Connection conexion, FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public void insertarPropiedad(Propiedad propiedad) {
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsIdUsuario;
        String idUsuario = null;

        con = super.getConexion();
        try {
            stmUsuario = con.prepareStatement("insert into propiedades(idpropiedad, valor_actual, gestor) " +
                    "values (?,?,?)");
            stmUsuario.setInt(1, propiedad.getIdPropiedad());
            stmUsuario.setInt(2, propiedad.getValorActual());
            stmUsuario.setString(3, propiedad.getGestor().getAlias());
            stmUsuario.executeUpdate();

            if (propiedad.getClass().equals(Inmobiliario.class)) {
                Inmobiliario inmobiliario = (Inmobiliario) propiedad;
                stmUsuario = con.prepareStatement("insert into inmobiliario(idpropiedad, ubicacion, tipoinmobiliario) " +
                        "values (?,?,?)");
                stmUsuario.setInt(1, inmobiliario.getIdPropiedad());
                stmUsuario.setString(2, inmobiliario.getUbicacion());
                stmUsuario.setString(3, inmobiliario.getTipo().toString());
                stmUsuario.executeUpdate();
            } else if (propiedad.getClass().equals(Vehiculo.class)) {
                Vehiculo vehiculo = (Vehiculo) propiedad;
                stmUsuario = con.prepareStatement("insert into vehiculos(idpropiedad, tipovehiculo, capacidad, almacén) " +
                        "values (?,?,?,?)");
                stmUsuario.setInt(1, vehiculo.getIdPropiedad());
                stmUsuario.setString(2, vehiculo.getTipo().toString());
                stmUsuario.setInt(3, vehiculo.getCapacidad());
                stmUsuario.setInt(4, vehiculo.getAlmacen().getIdPropiedad());
                stmUsuario.executeUpdate();
            } else if (propiedad.getClass().equals(Arma.class)) {
                Arma arma = (Arma) propiedad;
                stmUsuario = con.prepareStatement("insert into armas(idpropiedad, tipoarmamento, cantidad, numbalas, almacén) " +
                        "values (?,?,?,?,?)");
                stmUsuario.setInt(1, arma.getIdPropiedad());
                stmUsuario.setString(2, arma.getTipoString().toString());
                stmUsuario.setInt(3, arma.getCantidad());
                stmUsuario.setInt(4, arma.getBalas());
                stmUsuario.setInt(5, arma.getAlmacen().getIdPropiedad());
                stmUsuario.executeUpdate();
            } else if (propiedad.getClass().equals(Commodity.class)) {
                Commodity commodity = (Commodity) propiedad;
                stmUsuario = con.prepareStatement("insert into commodities(idpropiedad, nombre, cantidad) " +
                        "values (?,?,?)");
                stmUsuario.setInt(1, commodity.getIdPropiedad());
                stmUsuario.setString(2, commodity.getNombre());
                stmUsuario.setInt(3, commodity.getCantidad());
                stmUsuario.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

// No hace falta porque el de abajo ya busca todas si no se pone nada en el tipo
/*    public List<Propiedad> consultarPropiedades() {
        String consulta;
        ArrayList<Propiedad> resultado = new ArrayList<Propiedad>();
        Propiedad propiedadActual = null;
        Connection con;
        PreparedStatement stmPropiedades = null;
        ResultSet rsPropiedades, rsGestor, rsTipoConcreto, rsAlmacen;

        Acolito gestorAux=null;
        Inmobiliario almacenAux=null;
        TipoInmobiliario tipoInmobiliarioAux=null;

        con = this.getConexion();

        consulta = "SELECT u.idpropiedad, u.valor_actual, u.gestor ,\n" +
                "       CASE\n" +
                "           WHEN public.inmobiliario.idpropiedad IS NOT NULL THEN 'Inmobiliario' " +
                "           WHEN public.vehiculos.idpropiedad IS NOT NULL THEN 'Vehículo' " +
                "           WHEN public.armas.idpropiedad IS NOT NULL THEN 'Arma' " +
                "           WHEN public.commodities.idpropiedad IS NOT NULL THEN 'Commodity' " +
                "           ELSE 'tipo_desconocido' " +
                "           END AS tipo\n" +
                "FROM propiedades u " +
                "         LEFT JOIN public.inmobiliario ON u.idpropiedad = public.inmobiliario.idpropiedad " +
                "         LEFT JOIN public.vehiculos ON u.idpropiedad = public.vehiculos.idpropiedad " +
                "         LEFT JOIN public.armas ON u.idpropiedad = public.armas.idpropiedad " +
                "         LEFT JOIN public.commodities ON u.idpropiedad = public.commodities.idpropiedad";


        try {
            stmPropiedades = con.prepareStatement(consulta);
            rsPropiedades = stmPropiedades.executeQuery();
            while (rsPropiedades.next()) {
                String consulta2 = "SELECT * FROM acólitos " +
                        "WHERE alias = ? ";

                stmPropiedades = con.prepareStatement(consulta2);
                stmPropiedades.setString(1, rsPropiedades.getString("gestor"));
                rsGestor = stmPropiedades.executeQuery();
                rsGestor.next();

                // Crea al gestor relacionado
                gestorAux = new Acolito(rsGestor.getString("alias"), rsGestor.getString("contraseña"),
                        rsGestor.getString("nombrecompleto"), rsGestor.getString("direccion"), rsGestor.getString("email"),
                        rsGestor.getInt("influencia"), TipoAcolito.stringToTipoAcolito(rsGestor.getString("tipo_usuario")));

                switch (rsPropiedades.getString("tipo")) {
                    case "Inmobiliario":

                        if (rsPropiedades.getString("tipoinmobiliario").equals("Almacen")  || rsPropiedades.getString("tipoinmobiliario").equals("almacen")) {

                            // Busca la capacidad del almacen
                            consulta = "SELECT i.*, a.capacidad FROM inmobiliario i, almacenes a\n" +
                                    "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad";

                            stmPropiedades = con.prepareStatement(consulta);
                            stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                            rsTipoConcreto = stmPropiedades.executeQuery();
                            rsTipoConcreto.next();

                            // Crea el almacen
                            propiedadActual = new Inmobiliario(rsPropiedades.getInt("idpropiedad"), rsTipoConcreto.getString("ubicacion"),
                                    rsTipoConcreto.getInt("capacidad"), TipoInmobiliario.stringToTipoInmobiliario(rsPropiedades.getString("tipoinmobiliario")), rsPropiedades.getInt("valor_actual"),
                                    gestorAux);
                        }

                        else {
                            // Crea el inmobiliario
                            propiedadActual = new Inmobiliario(rsPropiedades.getInt("idpropiedad"), rsPropiedades.getString("ubicacion"), TipoInmobiliario.stringToTipoInmobiliario(rsPropiedades.getString("tipoinmobiliario")), rsPropiedades.getInt("valor_actual"),
                                    gestorAux);

                        }
                        break;

                    case "Vehículo":

                        // Busca almacen entero
                        consulta = "SELECT i.*, a.capacidad FROM inmobiliario i, almacenes a\n" +
                                "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad";
                        stmPropiedades = con.prepareStatement(consulta);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("almacen"));
                        rsAlmacen = stmPropiedades.executeQuery();
                        rsAlmacen.next();

                        // Setea el tipo de inmobiliario del almacen
                        tipoInmobiliarioAux = TipoInmobiliario.Almacen;

                        // Busca info del vehículo
                        consulta = "Select * from vehiculos where idpropiedad = ?";
                        stmPropiedades = con.prepareStatement(consulta);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();
                        rsTipoConcreto.next();

                        // Almacen asociado al vehículo
                        almacenAux = new Inmobiliario(rsPropiedades.getInt("idpropiedad"), rsAlmacen.getString("ubicacion"),
                                rsAlmacen.getInt("capacidad"), tipoInmobiliarioAux, rsAlmacen.getInt("valor_actual"),
                                gestorAux);

                        // Crea al vehículo
                        propiedadActual = new Vehiculo(rsPropiedades.getInt("idpropiedad"), rsPropiedades.getString("ubicacion"),
                                TipoVehiculo.stringToTipoVehiculo(rsPropiedades.getString("tipo_vehiculo")), rsPropiedades.getInt("valor_actual"),
                                rsTipoConcreto.getInt("capacidad"), almacenAux);
                        break;
                    case "Arma":

                        // Busca el almacen entero
                        consulta = "SELECT i.*, a.capacidad FROM inmobiliario i, almacenes a\n" +
                                "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad";
                        stmPropiedades = con.prepareStatement(consulta);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("almacen"));
                        rsAlmacen = stmPropiedades.executeQuery();
                        rsAlmacen.next();

                        // Setea el tipo de inmobiliario del almacen
                        tipoInmobiliarioAux = TipoInmobiliario.Almacen;

                        // Busca info especial del arma
                        consulta = "Select * from armas where idpropiedad = ?";
                        stmPropiedades = con.prepareStatement(consulta);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();
                        rsTipoConcreto.next();

                        // Almacen asociado al vehículo
                        almacenAux = new Inmobiliario(rsAlmacen.getInt("idpropiedad"), rsAlmacen.getString("ubicacion"),
                                rsAlmacen.getInt("capacidad"), tipoInmobiliarioAux, rsAlmacen.getInt("valor_actual"),
                                gestorAux);

                        // Crea el arma
                        propiedadActual = new Arma(rsPropiedades.getInt("idpropiedad"), TipoArmamento.stringToTipoArmamento(rsPropiedades.getString("tipo_armamento")),
                                rsTipoConcreto.getInt("cantidad"), rsTipoConcreto.getInt("Balas"), rsPropiedades.getInt("valor_actual"),
                                almacenAux);
                        break;
                    case "Commodity":

                        // Busca info especial del commodity
                        consulta = "Select * from commodities where idpropiedad = ?";
                        stmPropiedades = con.prepareStatement(consulta);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();
                        rsTipoConcreto.next();

                        // Crea el commodity
                        new Commodity(rsPropiedades.getInt("idpropiedad"), rsTipoConcreto.getString("nombre"),
                                rsTipoConcreto.getInt("cantidad"), rsPropiedades.getInt("valor_actual"),
                                gestorAux);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value of propiedades type: " + rsPropiedades.getString("tipo"));
                }
                resultado.add(propiedadActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                assert stmPropiedades != null;
                stmPropiedades.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }


    /**
     * Tipo entre Inmobiliario, Vehículo, Arma, Commodity, o subtipos
     * Está implementado de la forma más ineficiente posible (literalmente cojo todos los resultados y filtro con Java,
     * habría que cambiar las consultas, pero ahora mismo me da pereza ->
     * todo añadir condiciones sobre el tipo en cada consulta y jugar con el switch
     *
     * @param tipo
     * @return
     */
    public List<Propiedad> consultarPropiedades(String tipo) {
        List<Propiedad> resultado = new ArrayList<>();
        Propiedad propiedadActual = null;
        Connection con;
        PreparedStatement stmPropiedades = null;
        ResultSet rsPropiedades, rsGestor, rsTipoConcreto, rsAlmacen;

        Acolito gestorAux=null;
        Inmobiliario almacenAux=null;
        TipoInmobiliario tipoInmobiliarioAux=null;

        con = this.getConexion();

        String consulta = "SELECT propFiltradas.* " +
                "FROM " +
                "( " +
                "    SELECT u.*, " +
                "           CASE " +
                "               WHEN i.idpropiedad IS NOT NULL THEN 'Inmobiliario' " +
                "               WHEN v.idpropiedad IS NOT NULL THEN 'Vehículo' " +
                "               WHEN a.idpropiedad IS NOT NULL THEN 'Arma' " +
                "               WHEN c.idpropiedad IS NOT NULL THEN 'Commodity' " +
                "               ELSE 'tipo_desconocido' " +
                "           END AS tipo, " +
                "           i.tipoinmobiliario, " +
                "           v.tipovehiculo, " +
                "           a.tipoarmamento, " +
                "           c.nombre, " +
                "           i.ubicacion, " +
                "           COALESCE(a.almacén, v.almacén) AS almacen " +
                "    FROM propiedades u " +
                "             LEFT JOIN public.inmobiliario i ON u.idpropiedad = i.idpropiedad " +
                "             LEFT JOIN public.vehiculos v ON u.idpropiedad = v.idpropiedad " +
                "             LEFT JOIN public.armas a ON u.idpropiedad = a.idpropiedad " +
                "             LEFT JOIN public.commodities c ON u.idpropiedad = c.idpropiedad " +
                ") as propFiltradas " +
                "WHERE tipo LIKE ? OR tipoinmobiliario LIKE ? OR tipovehiculo LIKE ? OR nombre LIKE ? OR tipoarmamento LIKE ?;";

        try {
            stmPropiedades = con.prepareStatement(consulta);
            stmPropiedades.setString(1, "%" + tipo + "%");
            stmPropiedades.setString(2, "%" + tipo + "%");
            stmPropiedades.setString(3, "%" + tipo + "%");
            stmPropiedades.setString(4, "%" + tipo + "%");
            stmPropiedades.setString(5, "%" + tipo + "%");

            rsPropiedades = stmPropiedades.executeQuery();
            while (rsPropiedades.next()) {
                String consulta2 = "SELECT * FROM acólitos " +
                        "WHERE alias = ? ";

                stmPropiedades = con.prepareStatement(consulta2);
                stmPropiedades.setString(1, rsPropiedades.getString("gestor"));
                rsGestor = stmPropiedades.executeQuery();
                if(!rsGestor.next()){
                    System.out.println("No hay vehículo asociado al almacen");
                }

                // Crea al gestor relacionado
                gestorAux = new Acolito(rsGestor.getString("alias"), rsGestor.getString("contraseña"),
                        rsGestor.getString("nombrecompleto"), rsGestor.getString("direccion"),
                        rsGestor.getInt("influencia"), TipoAcolito.Gestor);

                switch (rsPropiedades.getString("tipo")) {
                    case "Inmobiliario":

                        if (rsPropiedades.getString("tipoinmobiliario").equals("Almacen")  || rsPropiedades.getString("tipoinmobiliario").equals("almacen")) {

                            // Busca la capacidad del almacen
                            consulta = "SELECT i.*, a.capacidad FROM inmobiliario i, almacenes a\n" +
                                    "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad";

                            stmPropiedades = con.prepareStatement(consulta);
                            stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                            rsTipoConcreto = stmPropiedades.executeQuery();
                            if(!rsTipoConcreto.next()){
                                System.out.println("No hay vehículo asociado al almacen");
                            }

                            // Crea el almacen
                            propiedadActual = new Inmobiliario(rsPropiedades.getInt("idpropiedad"), rsTipoConcreto.getString("ubicacion"),
                                    rsTipoConcreto.getInt("capacidad"), TipoInmobiliario.stringToTipoInmobiliario(rsPropiedades.getString("tipoinmobiliario")), rsPropiedades.getInt("valor_actual"),
                                    gestorAux);
                        }

                        else {
                            // Crea el inmobiliario
                            propiedadActual = new Inmobiliario(rsPropiedades.getInt("idpropiedad"), rsPropiedades.getString("ubicacion"), TipoInmobiliario.stringToTipoInmobiliario(rsPropiedades.getString("tipoinmobiliario")), rsPropiedades.getInt("valor_actual"),
                                    gestorAux);

                        }
                        break;

                    case "Vehículo":

                        // Busca almacen entero
                        consulta = "SELECT p.*, i.*, a.capacidad FROM inmobiliario i, almacenes a, propiedades p\n" +
                                "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad and p.idpropiedad = a.idpropiedad";
                        stmPropiedades = con.prepareStatement(consulta);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("almacen"));
                        rsAlmacen = stmPropiedades.executeQuery();
                        if (!rsAlmacen.next()) {
                            System.out.println("No hay almacen asociado al vehículo");
                        }

                        // Setea el tipo de inmobiliario del almacen
                        tipoInmobiliarioAux = TipoInmobiliario.Almacen;

                        // Busca info del vehículo
                        consulta = "Select * from vehiculos where idpropiedad = ?";
                        stmPropiedades = con.prepareStatement(consulta);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();
                        if(!rsTipoConcreto.next()){
                            System.out.println("No hay vehículo asociado al almacen");
                        }

                        // Almacen asociado al vehículo
                        almacenAux = new Inmobiliario(rsPropiedades.getInt("idpropiedad"), rsAlmacen.getString("ubicacion"),
                                rsAlmacen.getInt("capacidad"), tipoInmobiliarioAux, rsAlmacen.getInt("valor_actual"),
                                gestorAux);

                        // Crea al vehículo
                        propiedadActual = new Vehiculo(rsPropiedades.getInt("idpropiedad"),
                                TipoVehiculo.stringToTipoVehiculo(rsPropiedades.getString("tipovehiculo")), rsPropiedades.getInt("valor_actual"),
                                rsTipoConcreto.getInt("capacidad"), almacenAux);
                        break;
                    case "Arma":

                        // Busca el almacen entero
                        consulta = "SELECT p.*, i.*, a.capacidad FROM inmobiliario i, almacenes a, propiedades p\n" +
                                "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad and p.idpropiedad = a.idpropiedad";
                        stmPropiedades = con.prepareStatement(consulta);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("almacen"));
                        rsAlmacen = stmPropiedades.executeQuery();
                        if (!rsAlmacen.next()) {
                            System.out.println("No hay almacen asociado al arma");
                        }

                        // Setea el tipo de inmobiliario del almacen
                        tipoInmobiliarioAux = TipoInmobiliario.Almacen;

                        // Busca info especial del arma
                        consulta = "Select * from armas where idpropiedad = ?";
                        stmPropiedades = con.prepareStatement(consulta);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();
                        if(!rsTipoConcreto.next()){
                            System.out.println("No hay arma asociada al almacen");
                        }

                        // Almacen asociado al vehículo
                        almacenAux = new Inmobiliario(rsAlmacen.getInt("idpropiedad"), rsAlmacen.getString("ubicacion"),
                                rsAlmacen.getInt("capacidad"), tipoInmobiliarioAux, rsAlmacen.getInt("valor_actual"),
                                gestorAux);

                        // Crea el arma
                        propiedadActual = new Arma(rsPropiedades.getInt("idpropiedad"), TipoArmamento.stringToTipoArmamento(rsPropiedades.getString("tipoarmamento")),
                                rsTipoConcreto.getInt("cantidad"), rsTipoConcreto.getInt("numbalas"), rsPropiedades.getInt("valor_actual"),
                                almacenAux);
                        break;
                    case "Commodity":

                        // Busca info especial del commodity
                        consulta = "Select * from commodities where idpropiedad = ?";
                        stmPropiedades = con.prepareStatement(consulta);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();
                        if(!rsTipoConcreto.next()){
                            System.out.println("No hay commodity asociado al almacen");
                        }

                        // Crea el commodity
                        propiedadActual = new Commodity(rsPropiedades.getInt("idpropiedad"), rsTipoConcreto.getString("nombre"),
                                rsTipoConcreto.getInt("cantidad"), rsPropiedades.getInt("valor_actual"),
                                gestorAux);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value of propiedades type: " + rsPropiedades.getString("tipo"));
                }
                resultado.add(propiedadActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                assert stmPropiedades != null;
                stmPropiedades.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        /*return resultado.stream()
                .filter(propiedad -> propiedad.getClass().toString().equals(tipo))
                .collect(Collectors.toList());*/
        return resultado;
    }

    public void borrarPropiedad(String idPropiedad) {
        Connection con;
        PreparedStatement stmUsuario = null;

        con = super.getConexion();
        try {
            stmUsuario = con.prepareStatement("delete from propiedades where idpropiedad = ?");
            stmUsuario.setString(1, idPropiedad);
            stmUsuario.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
}
