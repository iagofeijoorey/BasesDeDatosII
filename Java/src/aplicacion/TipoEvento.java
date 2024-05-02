package aplicacion;

import aplicacion.PropiedadesYCuentas.TipoArmamento;

import java.util.ArrayList;

public enum TipoEvento {
    TiroAlBlanco,
    EntrenamientoDeAutodefensa,
    EntrenamientoDeCombate,
    ConferenciaSobreLaReligion,
    AtaqueT,
    CharlaDelLider,
    Normal;


    public static TipoEvento stringToTipoEvento(String tu){
        switch (tu){
            case ("Cabecilla"):
                return CharlaDelLider;
            default:
                return Normal;
        }
    }

    public static ArrayList<String> getTipos(){
        ArrayList<String> res = new ArrayList<>();

        for (TipoEvento te: TipoEvento.values()){
            switch (te){
                case TiroAlBlanco:
                    res.add("Tiro al Blanco");
                    break;

                case EntrenamientoDeAutodefensa:
                    res.add("Entrenamiento De Autodefensa");
                    break;

                case EntrenamientoDeCombate:
                    res.add("Entrenamiento De Combate");
                    break;

                case ConferenciaSobreLaReligion:
                    res.add("Conferencia Sobre La Religion");
                    break;

                case AtaqueT:
                    res.add("Ataque terrorista");
                    break;

                case CharlaDelLider:
                    res.add("Charla Del Lider");
                    break;

                case Normal:
                    res.add("Normal");
                    break;
            }

        }
        return res;
    }
}
