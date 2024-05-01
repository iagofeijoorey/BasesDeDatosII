/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.*;
import aplicacion.PropiedadesYCuentas.Inmobiliario;
import aplicacion.Objetivo;
import aplicacion.PropiedadesYCuentas.Propiedad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author basesdatos
 */
public class FachadaBaseDatos {
    // Hola, esta es la branch de prueba
    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOAcolitos daoAcolitos;
    private DAOContactos daoContactos;
    private DAOEventos daoEventos;
    private DAOPropiedades daoPropiedades;

    public FachadaBaseDatos (aplicacion.FachadaAplicacion fa) {

        Properties configuracion = new Properties();
        this.fa = fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("Java/baseDatosSecta.properties");
            configuracion.load(arqConfiguracion);

            arqConfiguracion.close();

            Properties usuario = new Properties();

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            System.out.println("HE LLEGAO");

            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://" +
                            configuracion.getProperty("servidor") + ":" +
                            configuracion.getProperty("puerto") + "/" +
                            configuracion.getProperty("baseDatos"),
                    usuario);

            daoAcolitos = new DAOAcolitos(conexion, fa);
            daoContactos = new DAOContactos(conexion, fa);
            daoEventos = new DAOEventos(conexion, fa);
            daoPropiedades = new DAOPropiedades(conexion, fa);


        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i) {
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());

        }
    }

    public void actualizarAcolito(String alias, String nombre, String ciudad, String pais){
        //daoAcolitos.actualizarAcolito(alias, nombre, ciudad, pais);
    }


    //Código VPrincipal
    /*public java.util.List<Evento> consultarEventos(String ubicacion, String fecha) {
        return daoEventos.consultarEventos(ubicacion, fecha);
    }

    public void borrarEvento(Evento evento){
        daoEventos.borrarEvento(evento);
    }

    public void insertarEvento(Evento evento){
        daoEventos.insertarEvento(evento);
    }*/

    public java.util.List<Propiedad> consultarPropiedades(String tipo){
         return daoPropiedades.consultarPropiedades(tipo);
    }

    public void borrarPropiedad(String idPropiedad){
        daoPropiedades.borrarPropiedad(idPropiedad);
    }

    public List<String> consultarArmasAlmacen(Inmobiliario almacen) {
        return daoPropiedades.consultarArmasAlmacen(almacen);
    }

    public List<String> consultarVehiculosAlmacen(Inmobiliario almacen) {
        return daoPropiedades.consultarVehiculosAlmacen(almacen);
    }

    public List<Objetivo> consultarObjetivosEvento(Evento evento) {
        return daoEventos.consultarObjetivosEvento(evento);
    }

    public void actualizarObjetivo(Objetivo objetivoSeleccionado) {
        daoEventos.actualizarObjetivo(objetivoSeleccionado);
    }

    public void insertarRecompensaDinero(RecompensaDinero recompensa) {

        recompensa.setIdRecompensa(daoEventos.obtenerIdRecompensaMayor()+1);
        daoEventos.insertarRecompensaDinero(recompensa);
    }

    public void actualizarRecompensaDinero(RecompensaDinero recompensa) {
        daoEventos.actualizarRecompensaDinero(recompensa);
    }

    public void borrarRecompensaDinero(RecompensaDinero recompensa) {
        daoEventos.borrarRecompensaDinero(recompensa);
    }

    public void insertarRecompensaInfluencia(RecompensaInfluencia recompensa) {
        recompensa.setIdRecompensa(daoEventos.obtenerIdRecompensaMayor()+1);
        daoEventos.insertarRecompensaInfluencia(recompensa);
    }

    public void actualizarRecompensaInfluencia(RecompensaInfluencia recompensa) {
        daoEventos.actualizarRecompensaInfluencia(recompensa);
    }

    public void borrarRecompensaInfluencia(RecompensaInfluencia recompensa) {
        daoEventos.borrarRecompensaInfluencia(recompensa);
    }

    public void borrarObjetivo(Objetivo objetivoSeleccionado) {
        daoEventos.borrarObjetivo(objetivoSeleccionado);
    }
}
