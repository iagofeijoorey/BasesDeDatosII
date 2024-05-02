package baseDatos;

import aplicacion.*;
import aplicacion.PropiedadesYCuentas.Arma;
import aplicacion.PropiedadesYCuentas.Inmobiliario;
import aplicacion.PropiedadesYCuentas.Propiedad;
import aplicacion.PropiedadesYCuentas.Vehiculo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
            System.out.println("Conexión establecida con la base de datos.");

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
    public Boolean comprobarAutentificacion(String alias, String clave){
        return daoAcolitos.comprobarAutentificacion(alias, clave);
    }

    public Acolito devolverUsuario(String alias, String clave){
        return daoAcolitos.devolverUsuario(alias, clave);
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

    public void borrarPropiedad(Integer idPropiedad){
        daoPropiedades.borrarPropiedad(idPropiedad);
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

    // Buscar mayor id Propiedad
    public Integer obtenerIdPropiedadMayor(){
        return daoPropiedades.obtenerIdPropiedadMayor();
    }

    // Contenido Almacén
    public java.util.List<Inmobiliario> consultaAlmacenes() {
        // TODO add your code here
        return daoPropiedades.consultaAlmacenes();
    }
}
