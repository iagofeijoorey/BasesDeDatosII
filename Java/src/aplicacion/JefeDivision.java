package aplicacion;

/**
 *
 * @author basesdatos
 */

public class JefeDivision extends Acolito {
    private String nombreDivision;

   public JefeDivision(String idUsuario, String clave, String nombre, String direccion, String email, int influencia, TipoAcolito tipo, String nombreDivision){
       super(idUsuario, clave, nombre, direccion, email, influencia, tipo);
       this.nombreDivision = nombreDivision;
   }

   //Getter

    public String getNombreDivision() {
        return nombreDivision;
    }

    //Setter
    public void setNombreDivision(String nombreDivision) {
        this.nombreDivision = nombreDivision;
    }


}
