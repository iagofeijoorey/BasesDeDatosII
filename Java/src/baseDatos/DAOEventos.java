package baseDatos;

import aplicacion.Evento;

import java.sql.*;
import java.util.List;

import aplicacion.Acolito;
import aplicacion.TipoAcolito;
import aplicacion.TipoEvento;

public class DAOEventos extends AbstractDAO {

    //Constructor
    public DAOEventos(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }


    //Métodos de gestión de eventos
    public void insertarEvento(Evento evento) {
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsIdUsuario;
        String idUsuario = null;

        con = super.getConexion();
        try {
            stmUsuario = con.prepareStatement("insert into eventos(ubicacion, fecha, tipoevento, descripcion, autorizador, organizador) " +
                    "values (?,?,?,?,?,?)");
            stmUsuario.setString(1, evento.getUbicacion());
            stmUsuario.setString(2, evento.getFecha());
            stmUsuario.setString(3, evento.getTipoEvento().toString());
            stmUsuario.setString(4, evento.getDescripcion());
            stmUsuario.setString(5, null); //todo revisar si se puede hacer esto (meter un null)
            stmUsuario.setString(6, evento.getOrganizador().getAlias());
            stmUsuario.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    public void borrarEvento(Evento evento) {
        Connection con;
        PreparedStatement stmUsuario = null;

        con = super.getConexion();
        try {
            stmUsuario = con.prepareStatement("delete from eventos where ubicacion = ? and fecha = ?");
            stmUsuario.setString(1, evento.getUbicacion());
            stmUsuario.setDate(2, java.sql.Date.valueOf(evento.getFecha())); // Convierte el String a java.sql.Date
            stmUsuario.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    /*public void borrarEvento(Evento evento) {
        Connection con;
        PreparedStatement stmUsuario = null;

        con = super.getConexion();
        try {
            stmUsuario = con.prepareStatement("delete from eventos where ubicacion = ? and fecha = ?");
            stmUsuario.setString(1, evento.getUbicacion());
            stmUsuario.setString(2, evento.getFecha());
            stmUsuario.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }*/


    //Métodos de consulta
    public List<Evento> consultarEventos(Evento evento) {
        List<Evento> resultado = null;
        Evento eventoActual;
        Connection con;
        PreparedStatement stmEventos = null, stmAcolito = null;
        ResultSet rsEventos, rsAcolito;

        con = this.getConexion();
        resultado = new java.util.ArrayList<Evento>();
        try {
            stmEventos = con.prepareStatement("select ubicacion, fecha, tipoevento, descripcion, autorizador, organizador " +
                    "from eventos " +
                    "where ubicacion like ? or fecha = ?;");
            /*stmEventos.setString(1, "%" + ubicacion + "%");
            stmEventos.setDate(2, java.sql.Date.valueOf(fecha));*/
            stmEventos.setString(1, evento.getUbicacion());
            stmEventos.setDate(2, java.sql.Date.valueOf(evento.getFecha())); // Convierte el String a java.sql.Date
            /*/ Convertir el String fecha a un objeto java.sql.Date
            //java.sql.Date fechaSQL = java.sql.Date.valueOf(fecha);
            //String fechaSQL;
            //stmEventos.setDate(2, Date.valueOf("%" + fecha + "%")); */



            rsEventos = stmEventos.executeQuery();
            while (rsEventos.next()) {
                eventoActual = new Evento(rsEventos.getString("ubicacion"), rsEventos.getString("fecha"),
                        TipoEvento.stringToTipoEvento(rsEventos.getString("tipoevento")), rsEventos.getString("descripcion"), null);

                stmAcolito = con.prepareStatement("select * " +
                        "from acólitos " +
                        "where alias = ?");
                stmAcolito.setString(1, rsEventos.getString("organizador"));
                rsAcolito = stmAcolito.executeQuery();
                Acolito organizador;
                if (!rsAcolito.next()){
                    System.out.println("No hay acólito");
                    organizador = null;
                }else{
                    organizador = new Acolito(rsAcolito.getString("alias"), rsAcolito.getString("contraseña"),
                            rsAcolito.getString("nombrecompleto"), rsAcolito.getString("direccion"), rsAcolito.getInt("influencia"),
                            TipoAcolito.stringToTipoAcolito("Gestor"));
                }
                eventoActual.setOrganizador(organizador);
                resultado.add(eventoActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmEventos != null) {
                    stmEventos.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    public List<Evento> consultarEventosSinArgs() {
        List<Evento> resultado = null;
        Evento eventoActual;
        Connection con;
        PreparedStatement stmEventos = null, stmAcolito = null;
        ResultSet rsEventos, rsAcolito;

        con = this.getConexion();
        resultado = new java.util.ArrayList<Evento>();
        try {
            stmEventos = con.prepareStatement("select ubicacion, fecha, tipoevento, descripcion, autorizador, organizador " +
                    "from eventos; ");
            rsEventos = stmEventos.executeQuery();

            while (rsEventos.next()) {
                eventoActual = new Evento(rsEventos.getString("ubicacion"), rsEventos.getString("fecha"),
                        TipoEvento.stringToTipoEvento(rsEventos.getString("tipoevento")), rsEventos.getString("descripcion"), null);

                stmAcolito = con.prepareStatement("select * " +
                        "from acólitos " +
                        "where alias = ?");
                stmAcolito.setString(1, rsEventos.getString("organizador"));
                rsAcolito = stmAcolito.executeQuery();
                Acolito organizador;
                if (!rsAcolito.next()){
                    System.out.println("No hay acólito");
                    organizador = null;
                }else{
                    organizador = new Acolito(rsAcolito.getString("alias"), rsAcolito.getString("contraseña"),
                            rsAcolito.getString("nombrecompleto"), rsAcolito.getString("direccion"), rsAcolito.getInt("influencia"),
                            TipoAcolito.stringToTipoAcolito("Gestor"));
                }
                eventoActual.setOrganizador(organizador);
                resultado.add(eventoActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmEventos != null) {
                    stmEventos.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }



/*
    public List<Evento> consultarEventos() {
        List<Evento> resultado = null;
        Evento eventoActual;
        Connection con;
        PreparedStatement stmEventos = null;
        ResultSet rsEventos;

        con = this.getConexion();
        resultado = new java.util.ArrayList<Evento>();
        try {
            stmEventos = con.prepareStatement("select ubicacion, fecha, tipoevento, descripcion, autorizador, organizador " +
                    "from eventos ");
            rsEventos = stmEventos.executeQuery();
            while (rsEventos.next()) {
                eventoActual = new Evento(rsEventos.getString("ubicacion"), rsEventos.getString("fecha"),
                        TipoEvento.stringToTipoEvento(rsEventos.getString("tipoevento")), rsEventos.getString("descripcion"), null);
                stmEventos = con.prepareStatement("select * " +
                        "from acólitos " +
                        "where alias = ?");
                stmEventos.setString(1, rsEventos.getString("organizador"));
                rsEventos = stmEventos.executeQuery();
                if (rsEventos.next()) {
                    eventoActual.setOrganizador(new Acolito(rsEventos.getString("alias"), rsEventos.getString("contraseña"),
                            rsEventos.getString("nombrecompleto"), rsEventos.getString("direccion"), rsEventos.getString("email"),
                            rsEventos.getInt("influencia"), TipoAcolito.stringToTipoAcolito(rsEventos.getString("tipo_usuario"))));
                }

                stmEventos = con.prepareStatement("select * " +
                        "from acólitos " +
                        "where alias = ?");

                stmEventos.setString(1, rsEventos.getString("autorizador"));
                rsEventos = stmEventos.executeQuery();
                if (rsEventos.next()) {
                    eventoActual.setAutorizador(new Acolito(rsEventos.getString("alias"), rsEventos.getString("contraseña"),
                            rsEventos.getString("nombrecompleto"), rsEventos.getString("direccion"), rsEventos.getString("email"),
                            rsEventos.getInt("influencia"), TipoAcolito.stringToTipoAcolito(rsEventos.getString("tipo_usuario"))));
                }
                resultado.add(eventoActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmEventos != null) {
                    stmEventos.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }


    public List<Evento> consultarEventos(Acolito acolito) {
        List<Evento> resultado = null;
        Evento eventoActual;
        Connection con;
        PreparedStatement stmEventos = null;
        ResultSet rsEventos;

        con = this.getConexion();
        resultado = new java.util.ArrayList<Evento>();
        try {
            stmEventos = con.prepareStatement("select ubicacion, fecha, tipoevento, descripcion, autorizador, organizador " +
                    "from eventos " +
                    "where organizador = ? or autorizador = ?");
            stmEventos.setString(1, acolito.getAlias());
            stmEventos.setString(2, acolito.getAlias());
            rsEventos = stmEventos.executeQuery();
            while (rsEventos.next()) {
                eventoActual = new Evento(rsEventos.getString("ubicacion"), rsEventos.getString("fecha"),
                        TipoEvento.stringToTipoEvento(rsEventos.getString("tipoevento")), rsEventos.getString("descripcion"), null);
                stmEventos = con.prepareStatement("select * " +
                        "from acólitos " +
                        "where alias = ?");
                stmEventos.setString(1, rsEventos.getString("organizador"));
                rsEventos = stmEventos.executeQuery();

                eventoActual.setOrganizador(new Acolito(rsEventos.getString("alias"), rsEventos.getString("contraseña"),
                        rsEventos.getString("nombrecompleto"), rsEventos.getString("direccion"), rsEventos.getString("email"),
                        rsEventos.getInt("influencia"), TipoAcolito.stringToTipoAcolito(rsEventos.getString("tipo_usuario"))));

                stmEventos = con.prepareStatement("select * " +
                        "from acólitos " +
                        "where alias = ?");

                stmEventos.setString(1, rsEventos.getString("autorizador"));
                rsEventos = stmEventos.executeQuery();
                if (rsEventos.next()) {
                    eventoActual.setAutorizador(new Acolito(rsEventos.getString("alias"), rsEventos.getString("contraseña"),
                            rsEventos.getString("nombrecompleto"), rsEventos.getString("direccion"), rsEventos.getString("email"),
                            rsEventos.getInt("influencia"), TipoAcolito.stringToTipoAcolito(rsEventos.getString("tipo_usuario"))));
                }
                resultado.add(eventoActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmEventos != null) {
                    stmEventos.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }*/

}


