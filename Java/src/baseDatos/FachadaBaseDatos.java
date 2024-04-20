/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Acolito;
import aplicacion.Ejemplar;
import aplicacion.Categoria;
import aplicacion.Libro;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
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
            System.out.println("HE LLEGAO");

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
    
    public void anadirPrestamo (Acolito acolito, Ejemplar ejemplar){
    daoEventos.anadirPrestamo(acolito,ejemplar);
    }


    public void devolver(Ejemplar ejemplar){
        daoEventos.devolver(ejemplar);
    }


    public java.util.List<Libro> consultarCatalogo(Integer id, String titulo, String isbn, String autor){
        return daoEventos.consultarCatalogo(id, titulo, isbn, autor);
    }

    public Libro consultarLibro(Integer idLibro){
        return daoEventos.consultarLibro(idLibro);
    }
    public java.util.List<Ejemplar> consultarEjemplaresLibro(Integer idLibro){
        return daoEventos.consultarEjemplaresLibro(idLibro);
    }
    
    public Integer consultarMaxEjemplarLibro(Integer idLibro){
        return daoEventos.consultarMaxEjemplarLibro(idLibro);
    }
                
            
    public java.util.List<String> obtenerRestoCategorias(Integer idLibro){
        return daoEventos.obtenerRestoCategorias(idLibro);
    }
    public void insertarCategoria(Categoria categoria){
        daoPropiedades.insertarCategoria(categoria);
    }
    public void borrarCategoria(Categoria categoria){
        daoPropiedades.borrarCategoria(categoria);
    }
    
    public Integer insertarLibro(Libro libro){
       return daoEventos.insertarLibro(libro);
    }
    
    public void insertarUsuario(Acolito acolito){
        daoAcolitos.insertarUsuario(acolito);
    }
    
    public void borrarLibro(Integer idLibro){
        daoEventos.borrarLibro(idLibro);
    }
    
    public void borrarUsuario(Acolito acolito){
        daoAcolitos.borrarUsuario(acolito);
    }
    public void modificarLibro(Libro libro){
         daoEventos.modificarLibro(libro);
    }
    public void modificarCategoriasLibro(Integer idLibro, java.util.List<String> categorias){
       daoEventos.modificarCategoriasLibro(idLibro, categorias);
    }
    public void insertarEjemplarLibro(Integer idLibro, Ejemplar ejemplar){
        ejemplar.setNumEjemplar(daoEventos.consultarMaxEjemplarLibro(idLibro)+1);
        daoEventos.insertarEjemplarLibro(idLibro, ejemplar);
    }
    public void borrarEjemplaresLibro(Integer idLibro, java.util.List<Integer> numsEjemplar){
        daoEventos.borrarEjemplaresLibro(idLibro, numsEjemplar);
    }
    public void modificarEjemplarLibro(Integer idLibro, Ejemplar ejemplar){
        daoEventos.modificarEjemplarLibro(idLibro, ejemplar);
    }

    public Acolito validarUsuario(String idUsuario, String clave){
        return daoAcolitos.validarUsuario(idUsuario, clave);
    }
   
    public java.util.List<Categoria> consultarCategorias(){
        return daoPropiedades.consultarCategorias();
    }
    
    public java.util.List<Acolito> consultarUsuarios(){
        return daoAcolitos.consultarUsuarios();
    }
    
    public java.util.List<Acolito> consultarUsuariosPrestamos(){
        return daoAcolitos.consultarUsuariosPrestamos("",""); //Sin filtros
    }
    
    public java.util.List<Acolito> consultarUsuariosPrestamos(String IDUsuario, String Nombre) {
        return daoAcolitos.consultarUsuariosPrestamos(IDUsuario,Nombre);
     }
         
    public java.util.List<Acolito> consultarUsuarios(String IDUsuario, String Nombre){
        //System.out.println("Iniciando consulta de ID: "+IDUsuario +" y Nombre: "+Nombre);
        return daoAcolitos.consultarUsuarios(IDUsuario, Nombre);
    }
}
