/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Ejemplar;
import aplicacion.Usuario;
import aplicacion.Acolito;
import aplicacion.Libro;
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
    private DAOLibros daoLibros;
    private DAOCategorias daoCategorias;
    private DAOUsuarios daoUsuarios;

    public FachadaBaseDatos (aplicacion.FachadaAplicacion fa){
        
        Properties configuracion = new Properties();
        this.fa=fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();
     

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion=java.sql.DriverManager.getConnection("jdbc:"+gestor+"://"+
                    configuracion.getProperty("servidor")+":"+
                    configuracion.getProperty("puerto")+"/"+
                    configuracion.getProperty("baseDatos"),
                    usuario);
            daoLibros = new DAOLibros(conexion, fa);
            daoCategorias = new DAOCategorias(conexion, fa);
            daoUsuarios = new DAOUsuarios(conexion, fa);
          


        } catch (FileNotFoundException f){
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i){
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } 
        catch (java.sql.SQLException e){
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
        }
        
        
        
    }
    
    public void anadirPrestamo (Usuario usuario, Ejemplar ejemplar){
    daoLibros.anadirPrestamo(usuario,ejemplar);
    }
    
    
    public void devolver(Ejemplar ejemplar){
        daoLibros.devolver(ejemplar);
    }
    
    

    public java.util.List<Libro> consultarCatalogo(Integer id, String titulo, String isbn, String autor){
        return daoLibros.consultarCatalogo(id, titulo, isbn, autor);
    }

    public Libro consultarLibro(Integer idLibro){
        return daoLibros.consultarLibro(idLibro);
    }
    public java.util.List<Ejemplar> consultarEjemplaresLibro(Integer idLibro){
        return daoLibros.consultarEjemplaresLibro(idLibro);
    }
    
    public Integer consultarMaxEjemplarLibro(Integer idLibro){
        return daoLibros.consultarMaxEjemplarLibro(idLibro);
    }
                
            
    public java.util.List<String> obtenerRestoCategorias(Integer idLibro){
        return daoLibros.obtenerRestoCategorias(idLibro);
    }
    public void insertarCategoria(Acolito acolito){
        daoCategorias.insertarCategoria(acolito);
    }
    public void borrarCategoria(Acolito acolito){
        daoCategorias.borrarCategoria(acolito);
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
    public void insertarEjemplarLibro(Integer idLibro, Ejemplar ejemplar){
        ejemplar.setNumEjemplar(daoLibros.consultarMaxEjemplarLibro(idLibro)+1);
        daoLibros.insertarEjemplarLibro(idLibro, ejemplar);
    }
    public void borrarEjemplaresLibro(Integer idLibro, java.util.List<Integer> numsEjemplar){
        daoLibros.borrarEjemplaresLibro(idLibro, numsEjemplar);
    }
    public void modificarEjemplarLibro(Integer idLibro, Ejemplar ejemplar){
        daoLibros.modificarEjemplarLibro(idLibro, ejemplar);
    }

    public Usuario validarUsuario(String idUsuario, String clave){
        return daoUsuarios.validarUsuario(idUsuario, clave);
    }
   
    public java.util.List<Acolito> consultarCategorias(){
        return daoCategorias.consultarCategorias();
    }
    
    public java.util.List<Usuario> consultarUsuarios(){
        return daoUsuarios.consultarUsuarios();
    }
    
    public java.util.List<Usuario> consultarUsuariosPrestamos(){
        return daoUsuarios.consultarUsuariosPrestamos("",""); //Sin filtros
    }
    
    public java.util.List<Usuario> consultarUsuariosPrestamos(String IDUsuario, String Nombre) {
        return daoUsuarios.consultarUsuariosPrestamos(IDUsuario,Nombre);
     }
         
    public java.util.List<Usuario> consultarUsuarios(String IDUsuario, String Nombre){
        //System.out.println("Iniciando consulta de ID: "+IDUsuario +" y Nombre: "+Nombre);
        return daoUsuarios.consultarUsuarios(IDUsuario, Nombre);
    }


}
