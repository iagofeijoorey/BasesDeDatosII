/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author basesdatos
 */
public class Ejemplar {

    private Integer numEjemplar;
    private String localizador;
    private String anoCompra;
    private Libro libro;
    private Acolito tenedor = new Acolito(" "," "," "," "," ", TipoAcolito.Normal); //Usamos un usuario vacío para los ejemplares en manos de la biblioteca
    private String fechaPrestamo = " ";
    private String fechaVencimiento = " ";

    public void setTenedor(Acolito tenedor) {
        this.tenedor = tenedor;
    }
    
    public void setNumEjemplar (Integer numEjemplar){
        this.numEjemplar = numEjemplar;
    }

    public void setLibro(Libro libro){
        this.libro = libro;
    }
    
    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Acolito getTenedor() {
        return tenedor;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Ejemplar(Libro libro, Integer numEjemplar, String localizador, String anoCompra) {
        this.numEjemplar = numEjemplar;
        this.anoCompra = anoCompra;
        this.localizador = localizador;
        this.libro = libro;
    }
    
      public Ejemplar(Libro libro, Integer numEjemplar, String localizador, String anoCompra,  String fechaPrestamo, String fechaVencimiento) {
        this.numEjemplar = numEjemplar;
        this.anoCompra = anoCompra;
        this.localizador = localizador;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getNumEjemplar() {
        return this.numEjemplar;
    }

    public String getAnoCompra() {
        return this.anoCompra;
    }

    public String getLocalizador() {
        return this.localizador;
    }

    public Libro getLibro() {
        return this.libro;
    }

    public void setLocalizador(String l) {
        localizador = l;
    }

    public void setAnoCompra(String a) {
        anoCompra = a;
    }

    
}
