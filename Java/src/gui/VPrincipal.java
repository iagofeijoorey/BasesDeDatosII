/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VPrincipal.java
 *
 * Created on 27-ene-2011, 10:31:24
 */

package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;


/**
 *
 * @author basesdatos
 */
public class VPrincipal extends javax.swing.JFrame {
  
    aplicacion.FachadaAplicacion fa;
    
    /** Creates new form VPrincipal */
    public VPrincipal(aplicacion.FachadaAplicacion fa) {
        this.fa=fa;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Sara Castro
    private void initComponents() {
        buscaTitulo = new JTextField();
        etiquetaTitulo = new JLabel();
        buscaIsbn = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        buscaAutor = new JTextField();
        jScrollPane1 = new JScrollPane();
        tablaLibros = new JTable();
        btnBuscar = new JButton();
        btnSalir = new JButton();
        btnNuevoLibro = new JButton();
        btnEditarLibro = new JButton();
        jLabel3 = new JLabel();
        buscaId = new JTextField();
        jPanel1 = new JPanel();
        jLabel4 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca de Inform\u00e1tica");
        setName("vPrincipal");
        setResizable(false);
        var contentPane = getContentPane();

        //---- buscaTitulo ----
        buscaTitulo.setToolTipText("Titulo a buscar");
        buscaTitulo.addActionListener(e -> buscaTituloActionPerformed(e));

        //---- etiquetaTitulo ----
        etiquetaTitulo.setText("T\u00edtulo:");

        //---- jLabel1 ----
        jLabel1.setText("Isbn:");

        //---- jLabel2 ----
        jLabel2.setText("Autor:");

        //---- buscaAutor ----
        buscaAutor.addActionListener(e -> buscaAutorActionPerformed(e));

        //======== jScrollPane1 ========
        {

            //---- tablaLibros ----
            tablaLibros.setModel(new ModeloTablaLibros());
            tablaLibros.setColumnSelectionAllowed(true);
            tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jScrollPane1.setViewportView(tablaLibros);
        }

        //---- btnBuscar ----
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(e -> btnBuscarActionPerformed(e));

        //---- btnSalir ----
        btnSalir.setText("Salir");
        btnSalir.addActionListener(e -> btnSalirActionPerformed(e));

        //---- btnNuevoLibro ----
        btnNuevoLibro.setText("Nuevo");
        btnNuevoLibro.addActionListener(e -> btnNuevoLibroActionPerformed(e));

        //---- btnEditarLibro ----
        btnEditarLibro.setText("Editar");
        btnEditarLibro.setEnabled(false);
        btnEditarLibro.addActionListener(e -> btnEditarLibroActionPerformed(e));

        //---- jLabel3 ----
        jLabel3.setText("Id:");

        //======== jPanel1 ========
        {
            jPanel1.setBackground(new Color(0xdcdcdc));
            jPanel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
            .EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax
            .swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,
            12),java.awt.Color.red),jPanel1. getBorder()));jPanel1. addPropertyChangeListener(new java.beans
            .PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.
            getPropertyName()))throw new RuntimeException();}});

            //---- jLabel4 ----
            jLabel4.setBackground(new Color(0xdcdcdc));
            jLabel4.setFont(new Font("sansserif", Font.BOLD, 14));
            jLabel4.setText("Administraci\u00f3n");

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(260, 260, 260))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addGap(0, 0, 0))
            );
        }

        //---- jButton1 ----
        jButton1.setFont(new Font("sansserif", Font.BOLD, 13));
        jButton1.setText("Usuarios");
        jButton1.setMaximumSize(new Dimension(120, 23));
        jButton1.setMinimumSize(new Dimension(120, 23));
        jButton1.setPreferredSize(new Dimension(125, 23));
        jButton1.addActionListener(e -> btnUsuariosActionPerformed(e));

        //---- jButton2 ----
        jButton2.setFont(new Font("sansserif", Font.BOLD, 13));
        jButton2.setText("Categor\u00edas");
        jButton2.setMaximumSize(new Dimension(120, 23));
        jButton2.setMinimumSize(new Dimension(120, 23));
        jButton2.setPreferredSize(new Dimension(125, 23));
        jButton2.addActionListener(e -> btnCategoriasActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(etiquetaTitulo)
                                .addComponent(jLabel1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(buscaIsbn, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(buscaAutor))
                                .addComponent(buscaTitulo)))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(btnNuevoLibro)
                            .addGap(18, 18, 18)
                            .addComponent(btnEditarLibro)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalir))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buscaId, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscar)))
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buscaTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(etiquetaTitulo))
                    .addGap(21, 21, 21)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buscaAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(buscaIsbn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(jLabel3))
                        .addComponent(buscaId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalir)
                        .addComponent(btnNuevoLibro)
                        .addComponent(btnEditarLibro))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void buscaAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscaAutorActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
                // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarLibros();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarLibroActionPerformed
        // TODO add your handling code here:
        ModeloTablaLibros mtl = (ModeloTablaLibros) tablaLibros.getModel();
        int idLibro;
        idLibro = mtl.obtenerLibro(tablaLibros.getSelectedRow()).getIdLibro();
        fa.visualizarLibro(idLibro);
    }//GEN-LAST:event_btnEditarLibroActionPerformed

    private void btnNuevoLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoLibroActionPerformed
        // TODO add your handling code here:
        fa.nuevoLibro();
    }//GEN-LAST:event_btnNuevoLibroActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        // TODO add your handling code here:
        fa.usuarios();
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        // TODO add your handling code here:
        fa.categorias();
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void buscaTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscaTituloActionPerformed

   
    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sara Castro
    private JTextField buscaTitulo;
    private JLabel etiquetaTitulo;
    private JTextField buscaIsbn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField buscaAutor;
    private JScrollPane jScrollPane1;
    private JTable tablaLibros;
    private JButton btnBuscar;
    private JButton btnSalir;
    private JButton btnNuevoLibro;
    private JButton btnEditarLibro;
    private JLabel jLabel3;
    private JTextField buscaId;
    private JPanel jPanel1;
    private JLabel jLabel4;
    private JButton jButton1;
    private JButton jButton2;
    // End of variables declaration//GEN-END:variables

    public void buscarLibros(){
        ModeloTablaLibros m;

        m=(ModeloTablaLibros) tablaLibros.getModel();
        m.setFilas(fa.obtenerLibros((buscaId.getText().isEmpty())?null:Integer.parseInt(buscaId.getText()), buscaTitulo.getText(), buscaIsbn.getText(), buscaAutor.getText()));
        if (m.getRowCount() > 0) {
            tablaLibros.setRowSelectionInterval(0, 0);
            btnEditarLibro.setEnabled(true);
        }
        else btnEditarLibro.setEnabled(false);
    }
}
