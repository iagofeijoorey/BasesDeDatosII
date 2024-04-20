package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author basesdatos
 */
public class Acolito {
    private String idUsuario;
    private String clave;
    private String nombre;
    private String direccion;
    private int telefono;
    private TipoAcolito tipo;
    private Integer prestamos = 0;
    private Integer prestamosVencidos = 0;

   public Acolito(String idUsuario, String clave, String nombre, String direccion, int telefono, TipoAcolito tipo){
    this.idUsuario=idUsuario;
    this.clave=clave;
    this.nombre=nombre;
    this.direccion=direccion;
    this.telefono=telefono;
    this.tipo=tipo;
   }
   
    public Acolito(String idUsuario, String clave, String nombre, String direccion, int telefono, TipoAcolito tipo, Integer prestamosVencidos){
    this.idUsuario=idUsuario;
    this.clave=clave;
    this.nombre=nombre;
    this.direccion=direccion;
    this.telefono=telefono;
    this.tipo=tipo;
    this.prestamosVencidos = prestamosVencidos;
   }
   
    
    
   public String getIdUsuario(){

       return this.idUsuario;
   }

    public Integer getPrestamos() {
        return prestamos;
    }

    public Integer getPrestamosVencidos() {
        return prestamosVencidos;
    }

    public void setPrestamos(Integer prestamos) {
        this.prestamos = prestamos;
    }

    public void setPrestamosVencidos(Integer prestamosVencidos) {
        this.prestamosVencidos = prestamosVencidos;
    }

   public String getClave(){

       return this.clave;
   }

   public String getNombre(){
       return this.nombre;
   }

   public String getDireccion(){

       return this.direccion;
   }

   public int getEmail(){

       return this.email;
   }

   public TipoAcolito getTipoUsuario(){

       return this.tipo; 
   }
}
