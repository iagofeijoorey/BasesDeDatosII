package aplicacion.PropiedadesYCuentas;

import aplicacion.Acolito;

public class Cuenta{
    private String IBAN;
    private Integer cantidad;
    private String divisa;
    private Acolito gestor;

    public Cuenta(String IBAN, Integer cantidad, String divisa, Acolito gestor) {
        this.IBAN = IBAN;
        this.cantidad = cantidad;
        this.divisa = divisa;
        this.gestor = gestor;
    }


    // Getters
    public String getIBAN() {
        return IBAN;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public String getDivisa() {
        return divisa;
    }
    public Acolito getGestor() {
        return gestor;
    }

    // Setters
    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }
    public void setGestor(Acolito gestor) {
        this.gestor = gestor;
    }
}
