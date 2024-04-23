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
    GestionAcolitos cu;
    GestionCategorias cc;
    Acolito currentUser;
    
    
 public FachadaAplicacion(){
   fgui=new gui.FachadaGui(this);
   fbd= new baseDatos.FachadaBaseDatos(this);
   cl= new GesionLibros(fgui, fbd);
   cu= new GestionAcolitos(fgui, fbd);
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


public java.util.List<Acolito> consultarAcolitos(){
    return cu.consultarAcolitos();
}


public java.util.List<Acolito> consultarAcolitos(String IDUsuario, String Nombre){
    return cu.buscarUsuarios(IDUsuario, Nombre);
}

public void nuevoUsuario(Acolito usuario){
    cu.nuevoUsuario(usuario);
}

public void usuarios(){
    cl.usuarios();
}
public void categorias(){
    cl.categorias();
}

public void prestar(Evento evento){
    cl.prestar(evento);
}
public void devolver(Evento evento){
    cl.devolver(evento);
}


public Integer actualizarLibro(Libro l){
  return cl.actualizarLibro(l);
}

public void borrarLibro(Integer idLibro){
   cl.borrarLibro(idLibro);
}

public void borrarAcolito(Acolito usuario){
    cu.borrarAcolito(usuario);
}

public void borrarEjemplar(Integer idLibro, Integer numEjemplar){
    cl.borrarEjemplar(idLibro, numEjemplar);
}

public void actualizarCategoriasLibro(Integer idLibro, java.util.List<String> categorias){
 cl.actualizarCategoriasLibro(idLibro, categorias);
}

public java.util.List<Evento> actualizarEjemplaresLibro(Integer idLibro, java.util.List<Evento> ejemplares, java.util.List<Integer> borrar){
  return cl.actualizarEjemplaresLibro(idLibro, ejemplares, borrar);
}


public Boolean comprobarAutentificacion(String idUsuario, String clave){
  //return cu.comprobarAutentificacion(idUsuario, clave);
    return true;
}


    public void setCurrentUser(Acolito u) {
        currentUser = u;
    }
}
