/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VAutentificacion.java
 *
 * Created on 16-feb-2011, 17:52:08
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 *
 * @author basesdatos
 */
public class VAutentificacion extends javax.swing.JDialog {

    aplicacion.FachadaAplicacion fa;
    
    /** Creates new form VAutentificacion */
    public VAutentificacion(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa) {
        super(parent, modal);
        this.fa=fa;
        initComponents();
        etiquetaFallo.setVisible(false);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Mateo Bodenlle Villarino
    private void initComponents() {
        textoUsuario = new JTextField();
        btnAceptar = new JButton();
        btnCancelar = new JButton();
        etiquetaFallo = new JLabel();
        textoClave = new JTextField();
        cajaGuardarUser = new JCheckBox();
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autentificaci\u00f3n de usuarios");
        setModal(true);
        setName("VAutentificacion");
        setResizable(false);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                formKeyPressed(e);
            }
            @Override
            public void keyTyped(KeyEvent e) {
                formKeyTyped(e);
            }
        });
        var contentPane = getContentPane();

        //---- textoUsuario ----
        textoUsuario.setForeground(Color.gray);
        textoUsuario.addActionListener(e -> textoUsuarioActionPerformed(e));

        //---- btnAceptar ----
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(e -> btnAceptarActionPerformed(e));

        //---- btnCancelar ----
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(e -> btnCancelarActionPerformed(e));

        //---- etiquetaFallo ----
        etiquetaFallo.setForeground(new Color(0xff3333));
        etiquetaFallo.setText("Autentificaci\u00f3n incorrecta!");

        //---- textoClave ----
        textoClave.setForeground(Color.gray);
        textoClave.addActionListener(e -> textoUsuarioActionPerformed(e));

        //---- label1 ----
        label1.setText("Usuario:");

        //---- label2 ----
        label2.setText("Contrase\u00f1a:");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(etiquetaFallo)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(textoUsuario, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addComponent(textoClave, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cajaGuardarUser)
                            .addGap(0, 21, Short.MAX_VALUE)))
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(80, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textoUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textoClave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cajaGuardarUser))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                    .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(etiquetaFallo))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void textoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoUsuarioActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        etiquetaFallo.setVisible(false);
        //if (fa.comprobarAutentificacion(textoUsuario.getText(), textoClave.getText()))
           this.dispose();
       // else etiquetaFallo.setVisible(true);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
     System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) System.out.printf("ENTER");
    }//GEN-LAST:event_formKeyTyped

    private void textoClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoClaveKeyTyped
        // TODO add your handling code here:
        //System.out.println(evt.getKeyChar());
        //if (evt.getKeyChar() == '\n') System.out.println("BARRAN");
        if (evt.getKeyChar() == '\n') //btnAceptarActionPerformed(null); //todo, devolver al original
            this.dispose();
    }//GEN-LAST:event_textoClaveKeyTyped

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mateo Bodenlle Villarino
    private JTextField textoUsuario;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JLabel etiquetaFallo;
    private JTextField textoClave;
    private JCheckBox cajaGuardarUser;
    private JLabel label1;
    private JLabel label2;
    // End of variables declaration//GEN-END:variables

}
