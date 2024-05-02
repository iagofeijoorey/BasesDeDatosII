package baseDatos;

import aplicacion.*;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import aplicacion.Objetivo;

public class DAOEventos extends AbstractDAO {

    //Constructor
    public DAOEventos(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }


    //Métodos de gestión de eventos
    public List<Objetivo> consultarObjetivosEvento(Evento evento) {
        List<Objetivo> resultado = null;
        Objetivo objetivoActual;
        Connection con;
        PreparedStatement stmObjetivos = null;
        ResultSet rsObjetivos;

        con = this.getConexion();
        resultado = new java.util.ArrayList<Objetivo>();
        try {
            stmObjetivos = con.prepareStatement("select idobjetivo, ubicacion, fecha, descripción, prioridad " +
                    "from objetivos " +
                    "where ubicacion = ? and fecha = ?");
            stmObjetivos.setString(1, evento.getUbicacion());
            stmObjetivos.setDate(2, java.sql.Date.valueOf(evento.getFecha()));
            rsObjetivos = stmObjetivos.executeQuery();

            while (rsObjetivos.next()) {
                objetivoActual = new Objetivo(rsObjetivos.getInt("idobjetivo"), rsObjetivos.getString("ubicacion"),
                        rsObjetivos.getString("fecha"), rsObjetivos.getString("descripción")
                        , rsObjetivos.getInt("prioridad"), null);

                //Carga de recompensas
                PreparedStatement stmRecompensas = con.prepareStatement("SELECT idrecompensa, 0 as cantidad, 'recompensas_contacto' as tipo\n" +
                        "FROM recompensas_contacto\n" +
                        "WHERE idobjetivo = ?\n" +
                        "UNION ALL\n" +
                        "SELECT idrecompensa, dinero AS cantidad, 'recompensas_dinero' as tipo\n" +
                        "FROM recompensas_dinero\n" +
                        "WHERE idobjetivo = ?\n" +
                        "UNION ALL\n" +
                        "SELECT idrecompensa, influencia AS cantidad, 'recompensas_influencia' as tipo\n" +
                        "FROM recompensas_influencia\n" +
                        "WHERE idobjetivo = ?");

                stmRecompensas.setInt(1, objetivoActual.getIdObjetivo());
                stmRecompensas.setInt(2, objetivoActual.getIdObjetivo());
                stmRecompensas.setInt(3, objetivoActual.getIdObjetivo());
                ResultSet rsRecompensas = stmRecompensas.executeQuery();

                while (rsRecompensas.next()) {
                    switch (rsRecompensas.getString("tipo")) {
                        case "recompensas_contactos":
                            objetivoActual.addRecompensa(new RecompensaDinero(rsRecompensas.getInt("idrecompensa"), objetivoActual.getIdObjetivo(),
                                    evento.getFecha(), evento.getUbicacion(), rsRecompensas.getInt("cantidad")));
                            break;
                        case "recompensas_dinero":
                            objetivoActual.addRecompensa(new RecompensaDinero(rsRecompensas.getInt("idrecompensa"), objetivoActual.getIdObjetivo(),
                                    evento.getFecha(), evento.getUbicacion(), rsRecompensas.getInt("cantidad")));
                            break;
                        case "recompensas_influencia":
                            objetivoActual.addRecompensa(new RecompensaInfluencia(rsRecompensas.getInt("idrecompensa"), objetivoActual.getIdObjetivo(),
                                    evento.getFecha(), evento.getUbicacion(), rsRecompensas.getInt("cantidad")));
                            break;
                    }
                }
                resultado.add(objetivoActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmObjetivos != null) {
                    stmObjetivos.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    public void actualizarObjetivo(Objetivo objetivoSeleccionado) {
        Connection con;
        PreparedStatement stmObjetivo = null;

        con = super.getConexion();
        try {
            stmObjetivo = con.prepareStatement("update objetivos " +
                    "set ubicacion = ?, fecha = ?, descripción = ?, prioridad = ? " +
                    "where idobjetivo = ?");
            stmObjetivo.setString(1, objetivoSeleccionado.getUbicacion());
            stmObjetivo.setDate(2,  java.sql.Date.valueOf(objetivoSeleccionado.getFecha()));
            stmObjetivo.setString(3, objetivoSeleccionado.getDescripcion());
            stmObjetivo.setInt(4, objetivoSeleccionado.getPrioridad());
            stmObjetivo.setInt(5, objetivoSeleccionado.getIdObjetivo());
            stmObjetivo.executeUpdate();

            //Borrado de recompensas
//            PreparedStatement stmBorradoRecompensas = con.prepareStatement("delete from recompensas_contacto where idobjetivo = ?");
//            stmBorradoRecompensas.setInt(1, objetivoSeleccionado.getIdObjetivo());
//            stmBorradoRecompensas.executeUpdate();
//
//            stmBorradoRecompensas = con.prepareStatement("delete from recompensas_dinero where idobjetivo = ?");
//            stmBorradoRecompensas.setInt(1, objetivoSeleccionado.getIdObjetivo());
//            stmBorradoRecompensas.executeUpdate();
//
//            stmBorradoRecompensas = con.prepareStatement("delete from recompensas_influencia where idobjetivo = ?");
//            stmBorradoRecompensas.setInt(1, objetivoSeleccionado.getIdObjetivo());
//            stmBorradoRecompensas.executeUpdate();

            //Inserción de recompensas
            for (Recompensa recompensa : objetivoSeleccionado.getRecompensa()) {
                if (recompensa instanceof RecompensaDinero) {
                    stmObjetivo = con.prepareStatement("insert into recompensas_dinero(idrecompensa, idobjetivo, fecha, ubicacion, dinero) " +
                            "values (?,?,?,?,?)");
                    stmObjetivo.setInt(1, recompensa.getIdRecompensa());
                    stmObjetivo.setInt(2, objetivoSeleccionado.getIdObjetivo());
                    stmObjetivo.setString(3, objetivoSeleccionado.getFecha());
                    stmObjetivo.setString(4, objetivoSeleccionado.getUbicacion());
                }
            }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } finally {
                try {
                    stmObjetivo.close();
                } catch (SQLException e) {
                    System.out.println("Imposible cerrar cursores");
                }
            }
        }
    public void insertarRecompensaDinero(RecompensaDinero recompensa) {
        Connection con;
        PreparedStatement stmRecompensa = null;
        ResultSet rsIdRecompensa;
        String idRecompensa = null;

        con = super.getConexion();
        try {
            stmRecompensa = con.prepareStatement("insert into recompensas_dinero(idrecompensa, idobjetivo, fecha, ubicacion, dinero) " +
                    "values (?,?,?,?,?)");
            stmRecompensa.setInt(1, recompensa.getIdRecompensa());
            stmRecompensa.setInt(2, recompensa.getIdObjetivo());
            stmRecompensa.setDate(3, java.sql.Date.valueOf(recompensa.getFecha()));
            stmRecompensa.setString(4, recompensa.getUbicacion());
            stmRecompensa.setInt(5, recompensa.getCantidad());
            stmRecompensa.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmRecompensa.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    public Integer obtenerIdRecompensaMayor() {
        Connection con;
        PreparedStatement stmRecompensa = null;
        ResultSet rsIdRecompensa;
        String idRecompensa = null;

        con = super.getConexion();
        try {
            stmRecompensa = con.prepareStatement("SELECT MAX(idrecompensa) AS max_idrecompensa\n" +
                    "FROM (\n" +
                    "         SELECT idrecompensa FROM recompensas_dinero\n" +
                    "         UNION ALL\n" +
                    "         SELECT idrecompensa FROM recompensas_contacto\n" +
                    "         UNION ALL\n" +
                    "         SELECT idrecompensa FROM recompensas_influencia\n" +
                    "     ) AS all_recompensas");
            rsIdRecompensa = stmRecompensa.executeQuery();
            if (rsIdRecompensa.next()) {
                idRecompensa = rsIdRecompensa.getString("max_idrecompensa");
            }
            if (idRecompensa == null) {
                idRecompensa = "0";
            }
            return Integer.parseInt(idRecompensa);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmRecompensa.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return 0;
    }
    public void actualizarRecompensaDinero(RecompensaDinero recompensa) {
        Connection con;
        PreparedStatement stmRecompensa = null;

        con = super.getConexion();
        try {
            stmRecompensa = con.prepareStatement("update recompensas_dinero " +
                    "set idobjetivo = ?, fecha = ?, ubicacion = ?, dinero = ? " +
                    "where idrecompensa = ?");
            stmRecompensa.setInt(1, recompensa.getIdObjetivo());
            stmRecompensa.setDate(2, java.sql.Date.valueOf(recompensa.getFecha()));
            stmRecompensa.setString(3, recompensa.getUbicacion());
            stmRecompensa.setInt(4, recompensa.getCantidad());
            stmRecompensa.setInt(5, recompensa.getIdRecompensa());
            stmRecompensa.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmRecompensa.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    public void borrarRecompensaDinero(RecompensaDinero recompensa) {
        Connection con;
        PreparedStatement stmRecompensa = null;

        con = super.getConexion();
        try {
            stmRecompensa = con.prepareStatement("delete from recompensas_dinero where idrecompensa = ?");
            stmRecompensa.setInt(1, recompensa.getIdRecompensa());
            stmRecompensa.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmRecompensa.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    public void insertarRecompensaInfluencia(RecompensaInfluencia recompensa) {
        Connection con;
        PreparedStatement stmRecompensa = null;
        ResultSet rsIdRecompensa;
        String idRecompensa = null;

        con = super.getConexion();
        try {
            stmRecompensa = con.prepareStatement("insert into recompensas_influencia(idobjetivo, fecha, ubicacion, influencia) " +
                    "values (?,?,?,?)");
            stmRecompensa.setInt(1, recompensa.getIdObjetivo());
            stmRecompensa.setDate(2, java.sql.Date.valueOf(recompensa.getFecha()));
            stmRecompensa.setString(3, recompensa.getUbicacion());
            stmRecompensa.setInt(4, recompensa.getCantidad());
            stmRecompensa.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmRecompensa.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    public void actualizarRecompensaInfluencia(RecompensaInfluencia recompensa) {
        Connection con;
        PreparedStatement stmRecompensa = null;

        con = super.getConexion();
        try {
            stmRecompensa = con.prepareStatement("update recompensas_influencia " +
                    "set idobjetivo = ?, fecha = ?, ubicacion = ?, influencia = ? " +
                    "where idrecompensa = ?");
            stmRecompensa.setInt(1, recompensa.getIdObjetivo());
            stmRecompensa.setDate(2, java.sql.Date.valueOf(recompensa.getFecha()));
            stmRecompensa.setString(3, recompensa.getUbicacion());
            stmRecompensa.setInt(4, recompensa.getCantidad());
            stmRecompensa.setInt(5, recompensa.getIdRecompensa());
            stmRecompensa.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmRecompensa.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    public void borrarRecompensaInfluencia(RecompensaInfluencia recompensa) {
        Connection con;
        PreparedStatement stmRecompensa = null;

        con = super.getConexion();
        try {
            stmRecompensa = con.prepareStatement("delete from recompensas_influencia where idrecompensa = ?");
            stmRecompensa.setInt(1, recompensa.getIdRecompensa());
            stmRecompensa.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmRecompensa.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    public void borrarObjetivo(Objetivo objetivoSeleccionado) {
        Connection con;
        PreparedStatement stmObjetivo = null;

        con = super.getConexion();
        try {
            stmObjetivo = con.prepareStatement("delete from objetivos where idobjetivo = ?");
            stmObjetivo.setInt(1, objetivoSeleccionado.getIdObjetivo());
            stmObjetivo.executeUpdate();

            //Borrado de recompensas
            PreparedStatement stmBorradoRecompensas = con.prepareStatement("delete from recompensas_contacto where idobjetivo = ?");
            stmBorradoRecompensas.setInt(1, objetivoSeleccionado.getIdObjetivo());
            stmBorradoRecompensas.executeUpdate();

            stmBorradoRecompensas = con.prepareStatement("delete from recompensas_dinero where idobjetivo = ?");
            stmBorradoRecompensas.setInt(1, objetivoSeleccionado.getIdObjetivo());
            stmBorradoRecompensas.executeUpdate();

            stmBorradoRecompensas = con.prepareStatement("delete from recompensas_influencia where idobjetivo = ?");
            stmBorradoRecompensas.setInt(1, objetivoSeleccionado.getIdObjetivo());
            stmBorradoRecompensas.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmObjetivo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void insertarEvento(Evento evento) {
        Connection con = super.getConexion();
        PreparedStatement stmUsuarioInsert = null;
        PreparedStatement stmUsuarioUpdate = null;

        try {
            // Intentamos insertar el evento
            stmUsuarioInsert = con.prepareStatement("INSERT INTO eventos(ubicacion, fecha, tipoevento, descripcion, autorizador, organizador) " +
                    "VALUES (?, ?, ?, ?, ?, ?)");
            stmUsuarioInsert.setString(1, evento.getUbicacion());
            stmUsuarioInsert.setDate(2, java.sql.Date.valueOf(evento.getFecha()));
            stmUsuarioInsert.setString(3, evento.getTipoEvento().toString());
            stmUsuarioInsert.setString(4, evento.getDescripcion());
            stmUsuarioInsert.setString(5, null); // Revisar si se puede hacer esto (meter un null)
            stmUsuarioInsert.setString(6, evento.getOrganizador().getAlias());
            stmUsuarioInsert.executeUpdate();
        } catch (SQLException e) {
            // Si ocurre un error, intentamos actualizar el evento
            try {
                stmUsuarioUpdate = con.prepareStatement("UPDATE eventos " +
                        "SET tipoevento = ?, descripcion = ?, autorizador = ?, organizador = ? " +
                        "WHERE ubicacion = ? AND fecha = ?");
                stmUsuarioUpdate.setString(1, evento.getTipoEvento().toString());
                stmUsuarioUpdate.setString(2, evento.getDescripcion());
                stmUsuarioUpdate.setString(3, null); // Revisar si se puede hacer esto (meter un null)
                stmUsuarioUpdate.setString(4, evento.getOrganizador().getAlias());
                stmUsuarioUpdate.setString(5, evento.getUbicacion());
                stmUsuarioUpdate.setDate(6, java.sql.Date.valueOf(evento.getFecha()));
                stmUsuarioUpdate.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
            } finally {
                try {
                    if (stmUsuarioUpdate != null) {
                        stmUsuarioUpdate.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("Imposible cerrar cursores");
                }
            }
        } finally {
            try {
                if (stmUsuarioInsert != null) {
                    stmUsuarioInsert.close();
                }
            } catch (SQLException ex) {
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

    public Integer obtenerIdObjetivoMayor() {
        Connection con;
        PreparedStatement stmObjetivo = null;
        ResultSet rsIdObjetivo;
        String idObjetivo = null;

        con = super.getConexion();
        try {
            stmObjetivo = con.prepareStatement("SELECT MAX(idobjetivo) AS max_idobjetivo\n" +
                    "FROM objetivos");
            rsIdObjetivo = stmObjetivo.executeQuery();
            if (rsIdObjetivo.next()) {
                idObjetivo = rsIdObjetivo.getString("max_idobjetivo");
            }
            if (idObjetivo == null) {
                idObjetivo = "0";
            }
            return Integer.parseInt(idObjetivo);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmObjetivo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return 0;
        
    }
    public void insertarObjetivo(Objetivo objetivoSeleccionado) {
        Connection con;
        PreparedStatement stmObjetivo = null;

        con = super.getConexion();
        try {
            stmObjetivo = con.prepareStatement("insert into objetivos(idobjetivo, ubicacion, fecha, descripción, prioridad) " +
                    "values (?,?,?,?,?)");
            stmObjetivo.setInt(1, objetivoSeleccionado.getIdObjetivo());
            stmObjetivo.setString(2, objetivoSeleccionado.getUbicacion());
            stmObjetivo.setDate(3, java.sql.Date.valueOf(objetivoSeleccionado.getFecha()));
            stmObjetivo.setString(4, objetivoSeleccionado.getDescripcion());
            stmObjetivo.setInt(5, objetivoSeleccionado.getPrioridad());
            stmObjetivo.executeUpdate();

            //Inserción de recompensas
            for (Recompensa recompensa : objetivoSeleccionado.getRecompensa()) {
                if (recompensa instanceof RecompensaDinero) {
                    stmObjetivo = con.prepareStatement("insert into recompensas_dinero(idrecompensa, idobjetivo, fecha, ubicacion, dinero) " +
                            "values (?,?,?,?,?)");
                    stmObjetivo.setInt(1, recompensa.getIdRecompensa());
                    stmObjetivo.setInt(2, objetivoSeleccionado.getIdObjetivo());
                    stmObjetivo.setDate(3, java.sql.Date.valueOf(objetivoSeleccionado.getFecha()));
                    stmObjetivo.setString(4, objetivoSeleccionado.getUbicacion());
                    stmObjetivo.setInt(5, ((RecompensaDinero) recompensa).getCantidad());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmObjetivo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
}


