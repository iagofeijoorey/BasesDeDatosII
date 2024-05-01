package aplicacion;

public class Trato {
    private Integer idTrato;
    private TipoTrato tipoTrato;
    private String contacto;
    private String acolito;

    public Trato(Integer idTrato, TipoTrato tipoTrato, String contacto, String acolito){
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

    public String getContacto(){
        return this.contacto;
    }

    public String getAcolito(){
        return this.acolito;
    }

    public void setIdTrato(Integer idTrato){
        this.idTrato = idTrato;
    }

    public void setTipoTrato(TipoTrato tipoTrato){
        this.tipoTrato = tipoTrato;
    }

    public void setContacto(String contacto){
        this.contacto = contacto;
    }

    public void setAcolito(String acolito){
        this.acolito = acolito;
    }
}
