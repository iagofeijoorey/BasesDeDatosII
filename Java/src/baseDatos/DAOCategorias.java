/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.Acolito;
import java.sql.*;
/**
 *
 * @author basesdatos
 */
public class DAOCategorias extends AbstractDAO {
   
    
    public DAOCategorias (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Acolito> consultarCategorias(){
        java.util.List<Acolito> resultado = new java.util.ArrayList<Acolito>();
        Acolito acolitoActual;
        Connection con;
        PreparedStatement stmCategorias=null;
        ResultSet rsCategorias;

        con=this.getConexion();

        try  {
        stmCategorias=con.prepareStatement("select nombre, descripcion from categoria");
        rsCategorias=stmCategorias.executeQuery();
        while (rsCategorias.next())
        {
            acolitoActual = new Acolito(rsCategorias.getString("nombre"), rsCategorias.getString("descripcion"));
            resultado.add(acolitoActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCategorias.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    public void borrarCategoria(Acolito acolito){
        Connection con;
        PreparedStatement stmCategoria=null;

        con=super.getConexion();

        try {
        stmCategoria=con.prepareStatement("delete from categoria where nombre = ?");
        stmCategoria.setString(1, acolito.getNombre());
        stmCategoria.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCategoria.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void insertarCategoria(Acolito acolito){
        Connection con;
        PreparedStatement stmCategoria=null;
        PreparedStatement stmAutores=null;
       // PreparedStatement stmIdLibro=null;
        //ResultSet rsIdLibro;
        //Integer numAutor;
        //Integer idLibro=null;

        con=super.getConexion();

        try {
        stmCategoria=con.prepareStatement("insert into categoria(nombre, descripcion) "+
                                      "values (?,?)");
        stmCategoria.setString(1, acolito.getNombre());
        stmCategoria.setString(2, acolito.getDescripcion());

        stmCategoria.executeUpdate();

        /*try{
        stmIdLibro=con.prepareStatement("select currval('seq_libro_id_libro') as idLibro");
        rsIdLibro=stmIdLibro.executeQuery();
        rsIdLibro.next();
        idLibro=rsIdLibro.getInt("idLibro");
        } catch (SQLException e){
          System.out.println(e.getMessage());
        }finally{stmIdLibro.close();}
*/
        /*try{
        stmAutores=con.prepareStatement("insert into autor(libro, nombre, orden) "+
                                      "values (?,?,?)");
        numAutor=1;
        for (String s:libro.getAutores()){
            stmAutores.setInt(1, idLibro);
            stmAutores.setString(2, s);
            stmAutores.setInt(3, numAutor);
            stmAutores.executeUpdate();
            numAutor=numAutor+1;
        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{stmAutores.close();}
        */
        
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCategoria.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }

    }


   

}
