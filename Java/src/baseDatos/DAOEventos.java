/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.*;

import java.sql.*;
import java.util.List;

import aplicacion.Objetivo;

/**
 *
 * @author basesdatos
 */

public class DAOEventos extends AbstractDAO {

    public DAOEventos(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

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
            stmObjetivos.setString(2, evento.getFecha());
            rsObjetivos = stmObjetivos.executeQuery();

            while (rsObjetivos.next()) {
                objetivoActual = new Objetivo(rsObjetivos.getInt("idobjetivo"), rsObjetivos.getString("ubicacion"),
                        rsObjetivos.getString("fecha"), rsObjetivos.getString("descripcion")
                        , rsObjetivos.getInt("prioridad"), null);

                //Carga de recompensas
                PreparedStatement stmRecompensas = con.prepareStatement("SELECT idrecompensa, 0 as cantidad\n, \'recompensacontactos' as tipo " +
                        "FROM recompensas_contacto\n" +
                        "WHERE idobjetivo = ?\n" +
                        "\n" +
                        "UNION ALL\n" +
                        "\n" +
                        "SELECT idrecompensa, dinero AS cantidad, \'recompensadinero' as tipo\n" +
                        "FROM recompensas_dinero\n" +
                        "WHERE idobjetivo = ?\n" +
                        "\n" +
                        "UNION ALL\n" +
                        "\n" +
                        "SELECT idrecompensa, influencia AS cantidad, 'recompensainfluencia' as tipo\n" +
                        "FROM recompensas_influencia\n" +
                        "WHERE idobjetivo = ?");

                stmRecompensas.setInt(1, objetivoActual.getIdObjetivo());
                stmRecompensas.setInt(2, objetivoActual.getIdObjetivo());
                stmRecompensas.setInt(3, objetivoActual.getIdObjetivo());
                ResultSet rsRecompensas = stmRecompensas.executeQuery();

                while (rsRecompensas.next()) {
                    switch (rsRecompensas.getString("tipo")) {
                        case "recompensacontactos":
                            objetivoActual.addRecompensa(new RecompensaDinero(rsRecompensas.getInt("idrecompensa"), objetivoActual.getIdObjetivo(),
                                    evento.getFecha(), evento.getUbicacion(), rsRecompensas.getInt("cantidad")));
                            break;
                        case "recompensadinero":
                            objetivoActual.addRecompensa(new RecompensaDinero(rsRecompensas.getInt("idrecompensa"), objetivoActual.getIdObjetivo(),
                                    evento.getFecha(), evento.getUbicacion(), rsRecompensas.getInt("cantidad")));
                            break;
                        case "recompensainfluencia":
                            //objetivoActual.addRecompensa(new RecompensaContacto(rsRecompensas.getInt("idrecompensa"), rsRecompensas.getInt("cantidad")));
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
            stmObjetivo.setString(2, objetivoSeleccionado.getFecha());
            stmObjetivo.setString(3, objetivoSeleccionado.getDescripcion());
            stmObjetivo.setInt(4, objetivoSeleccionado.getPrioridad());
            stmObjetivo.setInt(5, objetivoSeleccionado.getIdObjetivo());
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

            //Inserción de recompensas
            for (Recompensa recompensa : objetivoSeleccionado.getRecompensa()) {
                if (recompensa instanceof RecompensaDinero) {
                    stmObjetivo = con.prepareStatement("insert into recompensas_dinero(idrecompensa, idobjetivo, fecha, ubicacion, dinero) " +
                            "values (?,?,?,?)");
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
            stmRecompensa = con.prepareStatement("insert into recompensas_dinero(idobjetivo, fecha, ubicacion, dinero) " +
                    "values (?,?,?,?)");
            stmRecompensa.setInt(1, recompensa.getIdObjetivo());
            stmRecompensa.setString(2, recompensa.getFecha());
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

    public Integer obtenerIdRecompensaMayor() {
        Connection con;
        PreparedStatement stmRecompensa = null;
        ResultSet rsIdRecompensa;
        String idRecompensa = null;

        con = super.getConexion();
        try {
            stmRecompensa = con.prepareStatement("select max(idrecompensa) as idrecompensa " +
                    "from recompensas_dinero, recompensas_contacto, recompensas_influencia");
            rsIdRecompensa = stmRecompensa.executeQuery();
            if (rsIdRecompensa.next()) {
                idRecompensa = rsIdRecompensa.getString("idrecompensa");
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
            stmRecompensa.setString(2, recompensa.getFecha());
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
            stmRecompensa.setString(2, recompensa.getFecha());
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
            stmRecompensa.setString(2, recompensa.getFecha());
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

/*
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
    }


    public List<Evento> consultarEventos(String ubicacion, String fecha) {
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
                    "where ubicacion = ? or fecha = ?");
            stmEventos.setString(1, "%" + ubicacion + "%");
            stmEventos.setString(2, "%" + fecha + "%");
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
    }

    public void borrarEvento(Evento evento) {
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

}


