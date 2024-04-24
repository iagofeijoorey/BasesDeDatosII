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
   
    
    public DAOPropiedades(Connection conexion, FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }




    public List<Propiedad> consultarPropiedades() {
        ArrayList<Propiedad> resultado = new ArrayList<Propiedad>();
        Propiedad propiedadActual = null;
        Connection con;
        PreparedStatement stmPropiedades=null;
        ResultSet rsPropiedades, rsGestor, rsTipoConcreto, rsAuxiliar;

        con=this.getConexion();

        String consulta =   "SELECT u.idpropiedad, u.valor_actual, u.gestor ,\n" +
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


        try  {
            stmPropiedades=con.prepareStatement(consulta);
            rsPropiedades=stmPropiedades.executeQuery();
            while (rsPropiedades.next()) {
                String consulta2 = "SELECT * FROM acólitos " +
                        "WHERE alias = ? ";

                stmPropiedades = con.prepareStatement(consulta2);
                stmPropiedades.setString(1, rsPropiedades.getString("gestor"));
                rsGestor = stmPropiedades.executeQuery();

                switch (rsPropiedades.getString("tipo")) {
                    case "Inmobiliario":
                        String consulta4 = "SELECT i.*, a.capacidad FROM inmobiliario i, almacenes a\n" +
                                "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad";

                        stmPropiedades = con.prepareStatement(consulta4);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsAuxiliar = stmPropiedades.executeQuery();

                        String consulta3 = "SELECT i.*, a.capacidad FROM inmobiliario i, almacenes a\n" +
                                "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad";

                        stmPropiedades = con.prepareStatement(consulta3);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();

                        propiedadActual = new Inmobiliario(rsPropiedades.getInt("idpropiedad"), rsTipoConcreto.getString("ubicacion"),
                                rsPropiedades.getInt("capacidad"), rsPropiedades.getInt("valor_actual"),
                                new Acolito(rsGestor.getString("alias"), rsGestor.getString("contraseña"),
                                        rsGestor.getString("nombrecompleto"), rsGestor.getString("direccion"), 0,
                                        TipoAcolito.valueOf(rsGestor.getString("tipo_usuario"))));
                        break;


                    case "Vehículo":
                        String consulta5 = "SELECT i.*, a.capacidad FROM inmobiliario i, almacenes a\n" +
                                "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad";

                        stmPropiedades = con.prepareStatement(consulta5);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("almacen"));
                        rsAuxiliar = stmPropiedades.executeQuery();

                        String consulta6 = "Select * from vehiculos where idpropiedad = ?";
                        stmPropiedades = con.prepareStatement(consulta6);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();

                        propiedadActual = new Vehiculo(rsPropiedades.getInt("idpropiedad"), rsPropiedades.getString("ubicacion"),
                                TipoVehiculo.stringToTipoVehiculo(rsPropiedades.getString("tipo_vehiculo")), rsPropiedades.getInt("valor_actual"),
                                new Acolito(rsGestor.getString("alias"), rsGestor.getString("contraseña"),
                                        rsGestor.getString("nombrecompleto"), rsGestor.getString("direccion"), 0,
                                        TipoAcolito.valueOf(rsGestor.getString("tipo_usuario"))), new Inmobiliario(rsAuxiliar.getInt("idpropiedad"), rsTipoConcreto.getString("ubicacion"),
                                rsTipoConcreto.getInt("capacidad"), rsTipoConcreto.getInt("valor_actual"), null));
                        break;
                    case "Arma":
                        String consulta7 = "SELECT i.*, a.capacidad FROM inmobiliario i, almacenes a\n" +
                                "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad";

                        stmPropiedades = con.prepareStatement(consulta7);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("almacen"));
                        rsAuxiliar = stmPropiedades.executeQuery();

                        String consulta8 = "Select * from armas where idpropiedad = ?";
                        stmPropiedades = con.prepareStatement(consulta8);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();


                        propiedadActual = new Arma(rsPropiedades.getInt("idpropiedad"), TipoArmamento.stringToTipoArmamento(rsPropiedades.getString("tipo_armamento")),
                                rsTipoConcreto.getInt("cantidad"), rsPropiedades.getInt("valor_actual"), rsTipoConcreto.getInt("Balas"),
                                new Inmobiliario(rsTipoConcreto.getInt("idpropiedad"), rsTipoConcreto.getString("ubicacion"),
                                        rsTipoConcreto.getInt("capacidad"), rsTipoConcreto.getInt("valor_actual"), null));
                        break;
                    case "Commodity":
                        String consulta9 = "Select * from armas where idpropiedad = ?";
                        stmPropiedades = con.prepareStatement(consulta9);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();
                        new Commodity(rsPropiedades.getInt("idpropiedad"), rsTipoConcreto.getString("nombre"),
                                rsTipoConcreto.getInt("cantidad"), rsPropiedades.getInt("valor_actual"),
                                new Acolito(rsGestor.getString("alias"), rsGestor.getString("contraseña"),
                                        rsGestor.getString("nombrecompleto"), rsGestor.getString("direccion"), 0,
                                        TipoAcolito.valueOf(rsGestor.getString("tipo_usuario"))));
                break;
                    default:
                        throw new IllegalStateException("Unexpected value of propiedades type: " + rsPropiedades.getString("tipo"));
            }
                resultado.add(propiedadActual);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                assert stmPropiedades != null;
                stmPropiedades.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }


    /**
     * Tipo debe ser el nombre exacto rollo "Arma, Inmobiliario, Vehiculo, Commodity"
     * Está implementado de la forma más ineficiente posible (literalmente cojo todos los resultados y filtro con Java,
     * habría que cambiar las consultas, pero ahora mismo me da pereza ->
     * todo añadir condiciones sobre el tipo en cada consulta y jugar con el switch
     * @param tipo
     * @return
     */
    public List<Propiedad> consultarPropiedades(String tipo) {
        ArrayList<Propiedad> resultado = new ArrayList<Propiedad>();
        Propiedad propiedadActual = null;
        Connection con;
        PreparedStatement stmPropiedades=null;
        ResultSet rsPropiedades, rsGestor, rsTipoConcreto, rsAuxiliar;

        con=this.getConexion();

        String consulta =   "SELECT u.idpropiedad, u.valor_actual, u.gestor ,\n" +
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


        try  {
            stmPropiedades=con.prepareStatement(consulta);
            rsPropiedades=stmPropiedades.executeQuery();
            while (rsPropiedades.next()) {
                String consulta2 = "SELECT * FROM acólitos " +
                        "WHERE alias = ? ";

                stmPropiedades = con.prepareStatement(consulta2);
                stmPropiedades.setString(1, rsPropiedades.getString("gestor"));
                rsGestor = stmPropiedades.executeQuery();

                switch (rsPropiedades.getString("tipo")) {
                    case "Inmobiliario":
                        String consulta4 = "SELECT i.*, a.capacidad FROM inmobiliario i, almacenes a\n" +
                                "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad";

                        stmPropiedades = con.prepareStatement(consulta4);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsAuxiliar = stmPropiedades.executeQuery();

                        String consulta3 = "SELECT i.*, a.capacidad FROM inmobiliario i, almacenes a\n" +
                                "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad";

                        stmPropiedades = con.prepareStatement(consulta3);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();

                        propiedadActual = new Inmobiliario(rsPropiedades.getInt("idpropiedad"), rsTipoConcreto.getString("ubicacion"),
                                rsPropiedades.getInt("capacidad"), rsPropiedades.getInt("valor_actual"),
                                new Acolito(rsGestor.getString("alias"), rsGestor.getString("contraseña"),
                                        rsGestor.getString("nombrecompleto"), rsGestor.getString("direccion"), 0,
                                        TipoAcolito.valueOf(rsGestor.getString("tipo_usuario"))));
                        break;


                    case "Vehículo":
                        String consulta5 = "SELECT i.*, a.capacidad FROM inmobiliario i, almacenes a\n" +
                                "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad";

                        stmPropiedades = con.prepareStatement(consulta5);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("almacen"));
                        rsAuxiliar = stmPropiedades.executeQuery();

                        String consulta6 = "Select * from vehiculos where idpropiedad = ?";
                        stmPropiedades = con.prepareStatement(consulta6);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();

                        propiedadActual = new Vehiculo(rsPropiedades.getInt("idpropiedad"), rsPropiedades.getString("ubicacion"),
                                TipoVehiculo.stringToTipoVehiculo(rsPropiedades.getString("tipo_vehiculo")), rsPropiedades.getInt("valor_actual"),
                                new Acolito(rsGestor.getString("alias"), rsGestor.getString("contraseña"),
                                        rsGestor.getString("nombrecompleto"), rsGestor.getString("direccion"), 0,
                                        TipoAcolito.valueOf(rsGestor.getString("tipo_usuario"))), new Inmobiliario(rsAuxiliar.getInt("idpropiedad"), rsTipoConcreto.getString("ubicacion"),
                                rsTipoConcreto.getInt("capacidad"), rsTipoConcreto.getInt("valor_actual"), null));
                        break;
                    case "Arma":
                        String consulta7 = "SELECT i.*, a.capacidad FROM inmobiliario i, almacenes a\n" +
                                "where a.idpropiedad = ? and i.idpropiedad = a.idpropiedad";

                        stmPropiedades = con.prepareStatement(consulta7);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("almacen"));
                        rsAuxiliar = stmPropiedades.executeQuery();

                        String consulta8 = "Select * from armas where idpropiedad = ?";
                        stmPropiedades = con.prepareStatement(consulta8);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();


                        propiedadActual = new Arma(rsPropiedades.getInt("idpropiedad"), TipoArmamento.stringToTipoArmamento(rsPropiedades.getString("tipo_armamento")),
                                rsTipoConcreto.getInt("cantidad"), rsPropiedades.getInt("valor_actual"), rsTipoConcreto.getInt("Balas"),
                                new Inmobiliario(rsTipoConcreto.getInt("idpropiedad"), rsTipoConcreto.getString("ubicacion"),
                                        rsTipoConcreto.getInt("capacidad"), rsTipoConcreto.getInt("valor_actual"), null));
                        break;
                    case "Commodity":
                        String consulta9 = "Select * from armas where idpropiedad = ?";
                        stmPropiedades = con.prepareStatement(consulta9);
                        stmPropiedades.setInt(1, rsPropiedades.getInt("idpropiedad"));
                        rsTipoConcreto = stmPropiedades.executeQuery();
                        new Commodity(rsPropiedades.getInt("idpropiedad"), rsTipoConcreto.getString("nombre"),
                                rsTipoConcreto.getInt("cantidad"), rsPropiedades.getInt("valor_actual"),
                                new Acolito(rsGestor.getString("alias"), rsGestor.getString("contraseña"),
                                        rsGestor.getString("nombrecompleto"), rsGestor.getString("direccion"), 0,
                                        TipoAcolito.valueOf(rsGestor.getString("tipo_usuario"))));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value of propiedades type: " + rsPropiedades.getString("tipo"));
                }
                resultado.add(propiedadActual);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {
                assert stmPropiedades != null;
                stmPropiedades.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado.stream()
                .filter(propiedad -> propiedad.getClass().toString().equals(tipo))
                .collect(Collectors.toList());
    }
}
