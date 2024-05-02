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
                if (inmobiliario.getTipo().equals(TipoInmobiliario.Almacen)) {
                    stmUsuario = con.prepareStatement("insert into almacenes(idpropiedad, capacidad) " +
                            "values (?,?)");
                    stmUsuario.setInt(1, inmobiliario.getIdPropiedad());
                    stmUsuario.setInt(2, inmobiliario.getCapacidad());
                    stmUsuario.executeUpdate();
                }
            } else if (propiedad.getClass().equals(Vehiculo.class)) {
                Vehiculo vehiculo = (Vehiculo) propiedad;
                stmUsuario = con.prepareStatement("insert into vehiculos(idpropiedad, tipovehiculo, capacidad, almacén) " +
                        "values (?,?,?,?)");
                stmUsuario.setInt(1, vehiculo.getIdPropiedad());
                stmUsuario.setString(2, vehiculo.getTipo().toString());
                stmUsuario.setInt(3, vehiculo.getCantidad());
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

    public void actualizarPropiedad(Propiedad propiedad) {
        Connection con;
        PreparedStatement stmPropiedad = null;

        con = super.getConexion();

        try {
            // Actualizar datos en la tabla propiedades
            stmPropiedad = con.prepareStatement("UPDATE propiedades SET valor_actual = ?, gestor = ? WHERE idpropiedad = ?");
            stmPropiedad.setInt(1, propiedad.getValorActual());
            stmPropiedad.setString(2, propiedad.getGestor().getAlias());
            stmPropiedad.setInt(3, propiedad.getIdPropiedad());
            stmPropiedad.executeUpdate();

            // Actualizar datos en la tabla correspondiente dependiendo del tipo de propiedad
            if (propiedad instanceof Inmobiliario) {
                Inmobiliario inmobiliario = (Inmobiliario) propiedad;
                stmPropiedad = con.prepareStatement("UPDATE inmobiliario SET ubicacion = ?, tipoinmobiliario = ? WHERE idpropiedad = ?");
                stmPropiedad.setString(1, inmobiliario.getUbicacion());
                stmPropiedad.setString(2, inmobiliario.getTipo().toString());
                stmPropiedad.setInt(3, inmobiliario.getIdPropiedad());
                if (inmobiliario.getTipo().equals(TipoInmobiliario.Almacen)) {
                    stmPropiedad = con.prepareStatement("UPDATE almacenes SET capacidad = ? WHERE idpropiedad = ?");
                    stmPropiedad.setInt(1, inmobiliario.getCapacidad());
                    stmPropiedad.setInt(2, inmobiliario.getIdPropiedad());
                }
            } else if (propiedad instanceof Vehiculo) {
                Vehiculo vehiculo = (Vehiculo) propiedad;
                stmPropiedad = con.prepareStatement("UPDATE vehiculos SET tipovehiculo = ?, capacidad = ?, almacén = ? WHERE idpropiedad = ?");
                stmPropiedad.setString(1, vehiculo.getTipo().toString());
                stmPropiedad.setInt(2, vehiculo.getCantidad());
                stmPropiedad.setInt(3, vehiculo.getAlmacen().getIdPropiedad());
                stmPropiedad.setInt(4, vehiculo.getIdPropiedad());
            } else if (propiedad instanceof Arma) {
                Arma arma = (Arma) propiedad;
                stmPropiedad = con.prepareStatement("UPDATE armas SET tipoarmamento = ?, cantidad = ?, numbalas = ?, almacén = ? WHERE idpropiedad = ?");
                stmPropiedad.setString(1, arma.getTipoString().toString());
                stmPropiedad.setInt(2, arma.getCantidad());
                stmPropiedad.setInt(3, arma.getBalas());
                stmPropiedad.setInt(4, arma.getAlmacen().getIdPropiedad());
                stmPropiedad.setInt(5, arma.getIdPropiedad());
            } else if (propiedad instanceof Commodity) {
                Commodity commodity = (Commodity) propiedad;
                stmPropiedad = con.prepareStatement("UPDATE commodities SET nombre = ?, cantidad = ? WHERE idpropiedad = ?");
                stmPropiedad.setString(1, commodity.getNombre());
                stmPropiedad.setInt(2, commodity.getCantidad());
                stmPropiedad.setInt(3, commodity.getIdPropiedad());
            }

            // Ejecutar la actualización
            stmPropiedad.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPropiedad.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public List<Propiedad> consultarPropiedades(String tipo) {
        List<Propiedad> resultado = new ArrayList<>();
        Propiedad propiedadActual = null;
        Connection con;
        PreparedStatement stmPropiedades = null;
        ResultSet rsPropiedades, rsGestor, rsTipoConcreto, rsAlmacen;

        Acolito gestorAux=null;
        Inmobiliario almacenAux=null;
        TipoInmobiliario tipoInmobiliarioAux=null;
        int cantidad, numbalas, capacidad;
        String TipoConcreto, nombre;

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
                    System.out.println("No hay Gestor asociado a la propiedad");
                    gestorAux = null;
                }
                else {
                    // Crea al gestor relacionado
                    gestorAux = new Acolito(rsGestor.getString("alias"), rsGestor.getString("contraseña"),
                            rsGestor.getString("nombrecompleto"), rsGestor.getString("direccion"),
                            rsGestor.getInt("influencia"), TipoAcolito.Gestor);
                }


                switch (rsPropiedades.getString("tipo")) {
                    case "Inmobiliario":

                        if (rsPropiedades.getString("tipoinmobiliario").equals("Almacén")  || rsPropiedades.getString("tipoinmobiliario").equals("almacen")) {

                            // Busca la capacidad del almacen
                            consulta = "SELECT i.*, a.capacidad FROM inmobiliario i, almacenes a\n" +
                                    "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad";

                            stmPropiedades = con.prepareStatement(consulta);
                            stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                            rsTipoConcreto = stmPropiedades.executeQuery();
                            capacidad=0;
                            TipoConcreto="";
                            if(!rsTipoConcreto.next()){
                                System.out.println("No hay vehículo asociado al almacen");
                            }
                            else {
                                capacidad=rsTipoConcreto.getInt("capacidad");
                                TipoConcreto=rsTipoConcreto.getString("ubicacion");
                            }
                            // Crea el almacen
                            propiedadActual = new Inmobiliario(rsPropiedades.getInt("idpropiedad"), TipoConcreto,
                                    capacidad, TipoInmobiliario.stringToTipoInmobiliario(rsPropiedades.getString("tipoinmobiliario")), rsPropiedades.getInt("valor_actual"),
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
                            almacenAux = null;
                        }
                        else {
                            // Almacen asociado al vehículo
                            almacenAux = new Inmobiliario(rsPropiedades.getInt("idpropiedad"), rsAlmacen.getString("ubicacion"),
                                    rsAlmacen.getInt("capacidad"), tipoInmobiliarioAux, rsAlmacen.getInt("valor_actual"),
                                    gestorAux);
                        }

                        // Setea el tipo de inmobiliario del almacen
                        tipoInmobiliarioAux = TipoInmobiliario.Almacen;

                        // Busca info del vehículo
                        consulta = "Select * from vehiculos where idpropiedad = ?";
                        stmPropiedades = con.prepareStatement(consulta);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();

                        capacidad=0;
                        if(!rsTipoConcreto.next()) {
                            System.out.println("No hay vehículo asociado al almacen");
                        }
                        else {
                            capacidad=rsTipoConcreto.getInt("capacidad");
                        }

                        // Crea al vehículo
                        propiedadActual = new Vehiculo(rsPropiedades.getInt("idpropiedad"),
                                TipoVehiculo.stringToTipoVehiculo(rsPropiedades.getString("tipovehiculo")), rsPropiedades.getInt("valor_actual"),
                                capacidad, almacenAux);
                        break;
                    case "Arma":

                        // Setea el tipo de inmobiliario del almacen
                        tipoInmobiliarioAux = TipoInmobiliario.Almacen;

                        // Busca el almacen entero
                        consulta = "SELECT p.*, i.*, a.capacidad FROM inmobiliario i, almacenes a, propiedades p\n" +
                                "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad and p.idpropiedad = a.idpropiedad";
                        stmPropiedades = con.prepareStatement(consulta);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("almacen"));
                        rsAlmacen = stmPropiedades.executeQuery();

                        if (!rsAlmacen.next()) {
                            System.out.println("No hay almacen asociado al arma");
                            almacenAux = null;
                        }
                        else {
                            // Almacen asociado al vehículo
                            almacenAux = new Inmobiliario(rsAlmacen.getInt("idpropiedad"), rsAlmacen.getString("ubicacion"),
                                    rsAlmacen.getInt("capacidad"), tipoInmobiliarioAux, rsAlmacen.getInt("valor_actual"),
                                    gestorAux);
                        }

                        // Busca info especial del arma
                        consulta = "Select * from armas where idpropiedad = ?";
                        stmPropiedades = con.prepareStatement(consulta);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();

                        cantidad=0;
                        numbalas=0;
                        if(!rsTipoConcreto.next()){
                            System.out.println("No hay arma asociada al almacen");
                        }
                        else {
                            cantidad = rsTipoConcreto.getInt("cantidad");
                            numbalas = rsTipoConcreto.getInt("numbalas");
                        }

                        // Crea el arma
                        propiedadActual = new Arma(rsPropiedades.getInt("idpropiedad"), TipoArmamento.stringToTipoArmamento(rsPropiedades.getString("tipoarmamento")),
                                cantidad, numbalas, rsPropiedades.getInt("valor_actual"),
                                almacenAux);
                        break;
                    case "Commodity":

                        // Busca info especial del commodity
                        consulta = "Select * from commodities where idpropiedad = ?";
                        stmPropiedades = con.prepareStatement(consulta);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();

                        cantidad=0;
                        nombre="";
                        if(!rsTipoConcreto.next()){
                            System.out.println("No hay commodity asociado al almacen");
                        }
                        else {
                            cantidad = rsTipoConcreto.getInt("cantidad");
                            nombre=rsTipoConcreto.getString("nombre");
                        }

                        // Crea el commodity
                        propiedadActual = new Commodity(rsPropiedades.getInt("idpropiedad"),nombre,
                                cantidad, rsPropiedades.getInt("valor_actual"),
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

    // Contenido almacén
    public java.util.List<Vehiculo> consultarVehiculos(Integer idAlmacen) {
        List<Vehiculo> resultado = new ArrayList<>();
        Vehiculo vehiculoActual = null;
        Connection con;
        PreparedStatement stmVehiculos = null;
        ResultSet rsVehiculos;


        con = this.getConexion();

        String consulta = "SELECT v.*, p.valor_actual\n" +
                "FROM vehiculos v\n" +
                "         INNER JOIN propiedades p ON v.idpropiedad = p.idpropiedad\n" +
                "WHERE v.almacén = ?";

        try{
            stmVehiculos = con.prepareStatement(consulta);
            stmVehiculos.setInt(1, idAlmacen);
            rsVehiculos = stmVehiculos.executeQuery();
            while(rsVehiculos.next()){

                vehiculoActual = new Vehiculo(rsVehiculos.getInt("idpropiedad"), TipoVehiculo.stringToTipoVehiculo(rsVehiculos.getString("tipovehiculo")),
                        rsVehiculos.getInt("valor_actual"), rsVehiculos.getInt("capacidad"));
                resultado.add(vehiculoActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                assert stmVehiculos != null;
                stmVehiculos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;

    }
    public java.util.List<Arma> consultarArmas(Integer idAlmacen) {
        List<Arma> resultado = new ArrayList<>();
        Arma armaActual = null;
        Connection con;
        PreparedStatement stmArmas = null;
        ResultSet rsArmas;

        con = this.getConexion();

        String consulta = "SELECT a.*, p.valor_actual\n" +
                "FROM armas a\n" +
                "INNER JOIN propiedades p ON a.idpropiedad = p.idpropiedad\n" +
                "WHERE a.almacén = ?";

        try{
            stmArmas = con.prepareStatement(consulta);
            stmArmas.setInt(1, idAlmacen);
            rsArmas = stmArmas.executeQuery();
            while(rsArmas.next()){

                armaActual = new Arma(rsArmas.getInt("idpropiedad"), TipoArmamento.stringToTipoArmamento(rsArmas.getString("tipoarmamento")),
                        rsArmas.getInt("valor_actual"), rsArmas.getInt("cantidad"), rsArmas.getInt("numbalas"));
                resultado.add(armaActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                assert stmArmas != null;
                stmArmas.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }
}
