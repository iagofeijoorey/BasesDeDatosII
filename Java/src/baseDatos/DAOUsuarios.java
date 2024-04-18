/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.Usuario;
import aplicacion.TipoUsuario;
import java.sql.*;
/**
 *
 * @author basesdatos
 */
public class DAOUsuarios extends AbstractDAO {

   public DAOUsuarios (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Usuario validarUsuario(String idUsuario, String clave){
        Usuario resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsUsuario;

        con=this.getConexion();

        try {
        stmUsuario=con.prepareStatement("select id_usuario, clave, nombre, direccion, email, tipo_usuario "+
                                        "from usuario "+
                                        "where id_usuario = ? and clave = ?");
        stmUsuario.setString(1, idUsuario);
        stmUsuario.setString(2, clave);
        rsUsuario=stmUsuario.executeQuery();
        if (rsUsuario.next())
        {
            resultado = new Usuario(rsUsuario.getString("id_usuario"), rsUsuario.getString("clave"),
                                      rsUsuario.getString("nombre"), rsUsuario.getString("direccion"),
                                      rsUsuario.getString("email"), TipoUsuario.valueOf(rsUsuario.getString("tipo_usuario")));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public void insertarUsuario(Usuario usuario){
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsIdUsuario;
        String idUsuario=null;

        con=super.getConexion();

        try {
        stmUsuario=con.prepareStatement("insert into usuario(id_usuario, nombre, clave, direccion, email, tipo_usuario) "+
                                      "values (?,?,?,?,?,?)");
        stmUsuario.setString(1, usuario.getIdUsuario());
        stmUsuario.setString(2, usuario.getNombre());
        stmUsuario.setString(3, usuario.getClave());
        stmUsuario.setString(4, usuario.getDireccion());
        stmUsuario.setString(5,usuario.getEmail());
        stmUsuario.setString(6,usuario.getTipoUsuario().toString());
        stmUsuario.executeUpdate();
/*
        try{
        stmIdLibro=con.prepareStatement("select currval('seq_libro_id_libro') as idLibro");
        rsIdUsuario=stmIdLibro.executeQuery();
        rsIdUsuario.next();
        idUsuario=rsIdUsuario.getInt("idLibro");
        } catch (SQLException e){
          System.out.println(e.getMessage());
        }finally{stmIdLibro.close();}

        try{
        stmAutores=con.prepareStatement("insert into autor(libro, nombre, orden) "+
                                      "values (?,?,?)");
        numAutor=1;
        for (String s:libro.getAutores()){
            stmAutores.setInt(1, idUsuario);
            stmAutores.setString(2, s);
            stmAutores.setInt(3, numAutor);
            stmAutores.executeUpdate();
            numAutor=numAutor+1;
        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{stmAutores.close();}*/
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    public java.util.List<Usuario> consultarUsuarios(){
    java.util.List<Usuario> resultado = new java.util.ArrayList<>();
    Usuario usuarioActual;
    Connection con;
    PreparedStatement stmUsuarios=null;
    ResultSet rsUsuarios;

    con=this.getConexion();

    String consulta = "select *" +
                                     "from usuario";

    try  {
     stmUsuarios=con.prepareStatement(consulta);
     rsUsuarios=stmUsuarios.executeQuery();
    while (rsUsuarios.next())
    {
        usuarioActual = new Usuario(rsUsuarios.getString("id_usuario"), rsUsuarios.getString("clave"),
                                  rsUsuarios.getString("nombre"), rsUsuarios.getString("direccion"),
                                  rsUsuarios.getString("email"), TipoUsuario.stringToTipoUsuario(rsUsuarios.getString("tipo_usuario")));

        resultado.add(usuarioActual);
    }
    } catch (SQLException e){
      System.out.println(e.getMessage());
      this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    }finally{
      try {stmUsuarios.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
    }
    return resultado;
}

    public java.util.List<Usuario> consultarUsuarios(String IDUsuario, String Nombre){ 
        java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUsuarios=null;
        ResultSet rsUsuarios;

        con=this.getConexion();
        
        String consulta = "select * " +
                                         "from usuario as l "+
                                         "where id_usuario like ?"+
                                         "  and nombre like ?";
       
        try  {
         stmUsuarios=con.prepareStatement(consulta);
         stmUsuarios.setString(1, "%"+IDUsuario+"%");
         stmUsuarios.setString(2, "%"+Nombre+"%");
         
         rsUsuarios=stmUsuarios.executeQuery();
        while (rsUsuarios.next())
        {
            usuarioActual = new Usuario(rsUsuarios.getString("id_usuario"), rsUsuarios.getString("clave"),
                                      rsUsuarios.getString("nombre"), rsUsuarios.getString("direccion"),
                                      rsUsuarios.getString("email"), TipoUsuario.stringToTipoUsuario(rsUsuarios.getString("tipo_usuario")));
            resultado.add(usuarioActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuarios.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public java.util.List<Usuario> consultarUsuariosPrestamos(String IDUsuario, String Nombre){ //Consulta para los casos en los que nos importan los préstamos y préstamos vencidos
        java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUsuarios=null;
        ResultSet rsUsuarios;

        con=this.getConexion();
        
        String consulta = "select distinct u.*," +
                          " (select count(*) from prestamo where id_usuario LIKE ? and u.nombre like ? and prestamo.id_usuario = u.id_usuario and fechaprestamo + interval '30 days' < current_date and fechadevolucion isnull)" +
                          " from usuario  u left join prestamo on u.id_usuario = prestamo.id_usuario" +
                          " where u.id_usuario like ? and u.nombre like ?";
        try  {
         stmUsuarios=con.prepareStatement(consulta);
         stmUsuarios.setString(1, "%"+IDUsuario+"%");
         stmUsuarios.setString(2, "%"+Nombre+"%");
         stmUsuarios.setString(3, "%"+IDUsuario+"%");
         stmUsuarios.setString(4, "%"+Nombre+"%");
         
         rsUsuarios=stmUsuarios.executeQuery();

        while (rsUsuarios.next()) 
        {
            usuarioActual = new Usuario(rsUsuarios.getString("id_usuario"), rsUsuarios.getString("clave"),
                    rsUsuarios.getString("nombre"), rsUsuarios.getString("direccion"), rsUsuarios.getString("email"), 
                    TipoUsuario.stringToTipoUsuario(rsUsuarios.getString("tipo_usuario")),
                    rsUsuarios.getInt("count"));
            resultado.add(usuarioActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuarios.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public void borrarUsuario(Usuario usuario){
        Connection con;
        PreparedStatement stmUsuario=null;

        con=super.getConexion();

        try {
        stmUsuario=con.prepareStatement("delete from usuario where id_usuario = ?");
        stmUsuario.setString(1, usuario.getIdUsuario());
        stmUsuario.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
   
}
