/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.*;
import aplicacion.PropiedadesYCuentas.Propiedad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
}
