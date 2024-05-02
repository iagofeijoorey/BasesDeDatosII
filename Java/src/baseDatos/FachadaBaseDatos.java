package baseDatos;

import aplicacion.*;
import aplicacion.PropiedadesYCuentas.Inmobiliario;
import aplicacion.Objetivo;
import aplicacion.PropiedadesYCuentas.Arma;
import aplicacion.PropiedadesYCuentas.Propiedad;
import aplicacion.PropiedadesYCuentas.Vehiculo;

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
    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOAcolitos daoAcolitos;
    private DAOContactos daoContactos;
    private DAOEventos daoEventos;
    private DAOPropiedades daoPropiedades;

    //constructor
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

    ///Código VAcólitos
    public void actualizarAcolito(String alias, String nombre, String ciudad, String pais){
        //daoAcolitos.actualizarAcolito(alias, nombre, ciudad, pais);
    }


    ///Código VPrincipal
    public java.util.List<Evento> consultarEventos(Evento evento) {
        return daoEventos.consultarEventos(evento);
    }


    ///Código VEventos
    public java.util.List<Evento> consultarEventosSinArgs(){
        return daoEventos.consultarEventosSinArgs();
    }

    public void borrarEvento(Evento evento){
        daoEventos.borrarEvento(evento);
    }

    public void anhadirEvento(Evento evento){
        daoEventos.insertarEvento(evento);
    }

    public void insertarEvento(Evento evento){
        //daoEventos.insertarEvento(evento);
    }


    ///Código VPropiedades
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

    // Contenido Almacén
    public java.util.List<Vehiculo> consultarVehiculos(Integer idAlmacen) {
        return daoPropiedades.consultarVehiculos(idAlmacen);
    }

    public java.util.List<Arma> consultarArmas(Integer idAlmacen) {
        return daoPropiedades.consultarArmas(idAlmacen);
    }

    //Anadir propiedad
    public void anadirPropiedad(Propiedad p){
        daoPropiedades.insertarPropiedad(p);
    }

    //Actualizar propiedad
    public void actualizarPropiedad(Propiedad p){
        daoPropiedades.actualizarPropiedad(p);
    }
}
