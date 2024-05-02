/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import aplicacion.PropiedadesYCuentas.Inmobiliario;
import aplicacion.PropiedadesYCuentas.Arma;
import aplicacion.PropiedadesYCuentas.Propiedad;
import aplicacion.PropiedadesYCuentas.Vehiculo;
import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author basesdatos
 */
public class GestionPropiedades {

    FachadaGui fgui;
    FachadaBaseDatos fbd;


    public GestionPropiedades(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }

    public java.util.List<Propiedad> consultarPropiedades(String tipo){
        return fbd.consultarPropiedades(tipo);
    }

//
//     public java.util.List<Propiedad> consultarPropiedades(){
//         return fbd.consultarPropiedades();
//    }

//     public java.util.List<Acolito> buscarUsuarios(String IDUsuario, String Nombre) {
//         return fbd.consultarPropiedades(IDUsuario,Nombre);
//     }

     public void borrarPropiedad(String propiedad){
         fbd.borrarPropiedad(propiedad);
     }

    public List<String> consultarArmasAlmacen(Inmobiliario almacen) {
        return fbd.consultarArmasAlmacen(almacen);
    }

    public List<String> consultarVehiculosAlmacen(Inmobiliario almacen) {
        return fbd.consultarVehiculosAlmacen(almacen);
    }

//     public void nuevoUsuario(Acolito acolito){
//         fbd.insertarAcolito(acolito);
//     }


    // Contenido Almacén
    public java.util.List<Vehiculo> consultarVehiculos(Integer idAlmacen) {
        return fbd.consultarVehiculos(idAlmacen);
    }
    public java.util.List<Arma> consultarArmas(Integer idAlmacen) {
        return fbd.consultarArmas(idAlmacen);
    }

    //Anadir propiedad
    public void anadirPropiedad(Propiedad p){
        fbd.anadirPropiedad(p);
    }

    //Actualizar propiedad
    public void actualizarPropiedad(Propiedad p){
        fbd.actualizarPropiedad(p);
    }

}
