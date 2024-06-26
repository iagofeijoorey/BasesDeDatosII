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

    ///BOTONES
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        etiquetaFallo.setVisible(false);
        if(!textoClave.getText().isEmpty() && !textoUsuario.getText().isEmpty()){
            if (fa.comprobarAutentificacion(textoUsuario.getText(), textoClave.getText())){
                fa.setUsuario(textoUsuario.getText(), textoClave.getText());
                etiquetaFallo.setVisible(false);
                this.dispose();
            }
            else etiquetaFallo.setVisible(true);
        }
        else etiquetaFallo.setVisible(true);
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) { System.exit(0); }

    ///Cosas que no he implementado yo y no se que hacen
    private void formKeyPressed(java.awt.event.KeyEvent evt) { /* TODO add your handling code here: */  }
    private void formKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) System.out.printf("ENTER");
    }
    private void textoClaveKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        //System.out.println(evt.getKeyChar());
        //if (evt.getKeyChar() == '\n') System.out.println("BARRAN");
        if (evt.getKeyChar() == '\n') //btnAceptarActionPerformed(null); //todo, devolver al original
            this.dispose();
    }




    private void initComponents() {
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Iago Feijoo Rey
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
        Container contentPane = getContentPane();

        //---- textoUsuario ----
        textoUsuario.setForeground(Color.gray);

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
                            .addGap(0, 2, Short.MAX_VALUE)))
                    .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 81, Short.MAX_VALUE)
                    .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
                    .addGap(79, 79, 79))
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
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                    .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(etiquetaFallo))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // </editor-fold>//GEN-END:initComponents
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Iago Feijoo Rey
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

