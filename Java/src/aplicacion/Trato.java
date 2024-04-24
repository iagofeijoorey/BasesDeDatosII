package aplicacion;

public class Trato {
    private Integer idTrato;
    private TipoTrato tipoTrato;
    private Contacto contacto;
    private Acolito acolito;

    public Trato(Integer idTrato, TipoTrato tipoTrato, Contacto contacto, Acolito acolito){
        this.idTrato = idTrato;
        this.tipoTrato = tipoTrato;
        this.contacto = contacto;
        this.acolito = acolito;
    }

    public Integer getIdTrato(){
        return this.idTrato;
    }

    public TipoTrato getTipoTrato(){
        return this.tipoTrato;
    }

    public Contacto getContacto(){
        return this.contacto;
    }

    public Acolito getAcolito(){
        return this.acolito;
    }

    public void setIdTrato(Integer idTrato){
        this.idTrato = idTrato;
    }

    public void setTipoTrato(TipoTrato tipoTrato){
        this.tipoTrato = tipoTrato;
    }

    public void setContacto(Contacto contacto){
        this.contacto = contacto;
    }

    public void setAcolito(Acolito acolito){
        this.acolito = acolito;
    }
}
