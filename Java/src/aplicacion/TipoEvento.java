package aplicacion;

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
    }
