/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;


/**
 *
 * @author basesdatos
 */
public class

FachadaAplicacion {
    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GesionLibros cl;
    GestionUsuarios cu;
    GestionCategorias cc;
    Acolito currentUser;
    
    
 public FachadaAplicacion(){
   fgui=new gui.FachadaGui(this);
   fbd= new baseDatos.FachadaBaseDatos(this);
   cl= new GesionLibros(fgui, fbd);
   cu= new GestionUsuarios(fgui, fbd);
   cc = new GestionCategorias(fgui,fbd);
 }

 public static void main(String args[]) {
     FachadaAplicacion fa;
     
     fa= new FachadaAplicacion();
     fa.iniciaInterfazUsuario();
 }
 
 public void iniciaInterfazUsuario(){
     fgui.iniciaVista();
 }

 public void muestraExcepcion(String e){
     fgui.muestraExcepcion(e);
 }
 
public java.util.List<Libro> obtenerLibros(Integer id, String titulo, String isbn, String autor){
  return cl.obtenerLibros(id, titulo,  isbn,  autor);
};

public java.util.List<Categoria> obtenerCategorias(){
  return cl.obtenerCategorias();
};

public java.util.List<Acolito> obtenerUsuarios(){
    return cu.obtenerUsuarios();
}
public java.util.List<Acolito> obtenerUsuariosPretamos(){
    return cu.obtenerUsuariosPrestamos();
}

public void anadirPrestamo (Acolito acolito, Ejemplar ejemplar){
    cl.anadirPrestamo(acolito,ejemplar);
}

public java.util.List<Acolito> buscarUsuarios(String IDUsuario, String Nombre){
    return cu.buscarUsuarios(IDUsuario, Nombre);
}
public java.util.List<Acolito> buscarUsuariosPrestamos(String IDUsuario, String Nombre){
    return cu.buscarUsuariosPrestamos(IDUsuario, Nombre);
}


public void visualizarLibro(Integer idLibro){
 cl.visualizarLibro(idLibro);
}

public void nuevoLibro(){
 cl.nuevoLibro();
}


public void nuevoUsuario(Acolito acolito){
    cu.nuevoUsuario(acolito);
}

public void nuevaCategoria(Categoria categoria){
    cc.nuevaCategoria(categoria);
}

public void borrarCategoria(Categoria categoria){
    cc.borrarCategoria(categoria);
}

public void usuarios(){
    cl.usuarios();
}
public void categorias(){
    cl.categorias();
}

public void prestar(Ejemplar ejemplar){
    cl.prestar(ejemplar);
}
public void devolver(Ejemplar ejemplar){
    cl.devolver(ejemplar);
}


public Integer actualizarLibro(Libro l){
  return cl.actualizarLibro(l);
}

public void borrarLibro(Integer idLibro){
   cl.borrarLibro(idLibro);
}

public void borrarUsuario(Acolito acolito){
    cu.borrarUsuario(acolito);
}

public void borrarEjemplar(Integer idLibro, Integer numEjemplar){
    cl.borrarEjemplar(idLibro, numEjemplar);
}

public void actualizarCategoriasLibro(Integer idLibro, java.util.List<String> categorias){
 cl.actualizarCategoriasLibro(idLibro, categorias);
}

public java.util.List<Ejemplar> actualizarEjemplaresLibro(Integer idLibro, java.util.List<Ejemplar> ejemplares, java.util.List<Integer> borrar){
  return cl.actualizarEjemplaresLibro(idLibro, ejemplares, borrar);
}


public Boolean comprobarAutentificacion(String idUsuario, String clave){
    return cu.comprobarAutentificacion(idUsuario, clave, this);
    //return true;
}


    public void setCurrentUser(Acolito u) {
    currentUser = u;
    }
}
