package aplicacion;

import java.util.ArrayList;

public class RecompensaDinero extends Recompensa{
    private int cantidad;

    public RecompensaDinero(int idRecompensa, int idObjetivo, String fecha, String ubicacion, int cantidad) {
        super(idRecompensa, idObjetivo, fecha, ubicacion);
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

@Override
    public void realizarRecompensa(ArrayList<Acolito> acolitos) {
        cantidad/=acolitos.size();
        for(Acolito acolito: acolitos){
            acolito.addDinero(acolito.getDinero()+cantidad);
        }

    }
}
