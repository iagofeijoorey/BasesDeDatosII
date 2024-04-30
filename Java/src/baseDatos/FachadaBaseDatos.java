/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.*;
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

    /*

    MÉTODOS DA BIBLIOTECA


    public void anadirPrestamo (Usuario usuario, Evento evento){
    daoLibros.anadirPrestamo(usuario, evento);
    }


    public void devolver(Evento evento){
        daoLibros.devolver(evento);
    }


    public java.util.List<Libro> consultarCatalogo(Integer id, String titulo, String isbn, String autor){
        return daoLibros.consultarCatalogo(id, titulo, isbn, autor);
    }

    public Libro consultarLibro(Integer idLibro){
        return daoLibros.consultarLibro(idLibro);
    }
    public java.util.List<Evento> consultarEjemplaresLibro(Integer idLibro){
        return daoLibros.consultarEjemplaresLibro(idLibro);
    }
    
    public Integer consultarMaxEjemplarLibro(Integer idLibro){
        return daoLibros.consultarMaxEjemplarLibro(idLibro);
    }
                
            
    public java.util.List<String> obtenerRestoCategorias(Integer idLibro){
        return daoLibros.obtenerRestoCategorias(idLibro);
    }
    public void insertarCategoria(Categoria categoria){
        daoCategorias.insertarCategoria(categoria);
    }
    public void borrarCategoria(Categoria categoria){
        daoCategorias.borrarCategoria(categoria);
    }
    
    public Integer insertarLibro(Libro libro){
       return daoLibros.insertarLibro(libro);
    }
    
    public void insertarUsuario(Usuario usuario){
        daoUsuarios.insertarUsuario(usuario);
    }
    
    public void borrarLibro(Integer idLibro){
        daoLibros.borrarLibro(idLibro);
    }
    
    public void borrarUsuario(Usuario usuario){
        daoUsuarios.borrarUsuario(usuario);
    }
    public void modificarLibro(Libro libro){
         daoLibros.modificarLibro(libro);
    }
    public void modificarCategoriasLibro(Integer idLibro, java.util.List<String> categorias){
       daoLibros.modificarCategoriasLibro(idLibro, categorias);
    }
    public void insertarEjemplarLibro(Integer idLibro, Evento evento){
        evento.setNumEjemplar(daoLibros.consultarMaxEjemplarLibro(idLibro)+1);
        daoLibros.insertarEjemplarLibro(idLibro, evento);
    }
    public void borrarEjemplaresLibro(Integer idLibro, java.util.List<Integer> numsEjemplar){
        daoLibros.borrarEjemplaresLibro(idLibro, numsEjemplar);
    }
    public void modificarEjemplarLibro(Integer idLibro, Evento evento){
        daoLibros.modificarEjemplarLibro(idLibro, evento);
    }

    public Usuario validarUsuario(String idUsuario, String clave){
        return daoUsuarios.validarUsuario(idUsuario, clave);
    }
   
    public java.util.List<Categoria> consultarCategorias(){
        return daoCategorias.consultarCategorias();
    }


    /*

    */
    public void actualizarAcolito(String alias, String nombre, String ciudad, String pais){
    //    daoAcolitos.actualizarAcolito(alias, nombre, ciudad, pais);
    }


    //Código VPrincipal
    public java.util.List<Evento> consultarEventos(String ubicacion, String fecha) {
        return daoEventos.consultarEventos(ubicacion, fecha);
    }

}
