/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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

    public Acolito validarLogin(String idUsuario, String clave){
        return daoAcolitos.validarLogin(idUsuario, clave);
    }

    ///////////////////// MÉTODOS SARA. VACOLITOS /////////////////////
    public void actualizarAcolito(Acolito acolito){
        daoAcolitos.actualizarAcolito(acolito);
    }

    public void nuevoAcolito(Acolito acolito){
        daoAcolitos.nuevoAcolito(acolito);
    }

    public ArrayList<String> obtenerAliasAcolitos() {
        return daoAcolitos.obtenerAliasAcolitos();
    }

    public Acolito obtenerAcolito(String alias) {
        return daoAcolitos.obtenerAcolito(alias);
    }

    public void eliminarAcolito(String alias) {
        daoAcolitos.eliminarAcolito(alias);
    }

    public java.util.List<Evento> consultarEventos(String alias) {
        return daoEventos.consultarEventos(alias);
    }

    public java.util.List<Evento> consultarEventos() {
        return daoEventos.consultarEventos();
    }

    ///////////////////// MÉTODOS LAURA. VCONTACTOS /////////////////////

    public ArrayList<Contacto> obtenerContactos(Acolito acolito){
        return daoContactos.consultarContactos(acolito);
    }

    public void actualizarContacto(String pseudonimo, String nombre, String telefono, String descripcion){
        daoContactos.actualizarContacto(pseudonimo, nombre, telefono, descripcion);
    }

    public void eliminarContacto(String pseudonimo){
        daoContactos.eliminarContacto(pseudonimo);
    }

    public ArrayList<Trato> obtenerTratos(String acolito, String contacto){
        return daoContactos.obtenerTratos(acolito, contacto);
    }

    public boolean hayTratos(String acolito, String contacto){
        return daoContactos.hayTratos(acolito, contacto);
    }

    public void proponerTrato(ArrayList<String> datosTrato, String acolito, String contacto){
        daoContactos.proponerTrato(datosTrato, acolito, contacto);
    }

    public boolean existeTrato(Integer id){
        return daoContactos.existeTrato(id);
    }

    public void romperTrato(Trato trato){
        daoContactos.romperTrato(trato);
    }

    public void crearContacto(String acolito, String contacto){
        daoContactos.crearContacto(acolito, contacto);
    }

    public Contacto crearContacto(String pseudonimo, String nombre, String telefono, String descripcion){
        return daoContactos.crearContacto(pseudonimo, nombre, telefono, descripcion);
    }


}
