/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Acolito;
import aplicacion.Contacto;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
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
    private DAOEventos daoEventos;
    private DAOPropiedades daoPropiedades;
    private DAOContactos daoContactos;
    private DAOAcolitos daoAcolitos;

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

            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://" +
                            configuracion.getProperty("servidor") + ":" +
                            configuracion.getProperty("puerto") + "/" +
                            configuracion.getProperty("baseDatos"),
                    usuario);

            daoEventos = new DAOEventos(conexion, fa);
            daoPropiedades = new DAOPropiedades(conexion, fa);
            daoAcolitos = new DAOAcolitos(conexion, fa);
            daoContactos = new DAOContactos(conexion, fa);

        } catch (IOException | SQLException i) {
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        }
    }
    public void insertarAcolito(Acolito usuario){
        daoAcolitos.insertarAcolito(usuario);
    }

    public void borrarAcolito(Acolito usuario){
        daoAcolitos.borrarAcolito(usuario);
    }

    public Acolito validarLogin(String idUsuario, String clave){
        return daoAcolitos.validarLogin(idUsuario, clave);
    }

    public java.util.List<Acolito> consultarAcolitos(){
        return daoAcolitos.consultarAcolitos("","");
    }

    public java.util.List<Acolito> consultarAcolitos(String alias, String Nombre){
        return daoAcolitos.consultarAcolitos(alias, Nombre);
    }

    public List<Contacto> consultarContacto(String pseudonimo, String nombre) {
        return daoContactos.consultarContactos(pseudonimo,nombre);
    }

    public List<Contacto> consultarContactosDeAcolito(Acolito acolito, String pseudonimo, String nombre) {
        return daoContactos.consultarContactosDeAcolito(acolito, pseudonimo, nombre);
    }
    public List<Contacto> consultarContactosDeAcolito(String aliasAcolito, String pseudonimo, String nombre) {
        return daoContactos.consultarContactosDeAcolito(aliasAcolito, pseudonimo, nombre);
    }
}
