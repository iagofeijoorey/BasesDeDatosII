/*
 * Created by JFormDesigner on Wed May 01 10:29:43 CEST 2024
 */

package gui;

import aplicacion.FachadaAplicacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author Usuario
 */
public class VContactoNuevo extends JDialog {
    private FachadaAplicacion fa;
    public VContactoNuevo(Window owner, FachadaAplicacion fa) {
        super(owner);
        this.fa = fa;
        initComponents();
    }

    private void formKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void formKeyTyped(KeyEvent e) {
        // TODO add your code here
    }

    private void textoUsuarioActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btnAceptarActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btnCancelarActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Laura Antelo González
        textoUsuario = new JTextField();
        btnAceptar = new JButton();
        btnCancelar = new JButton();
        textoClave = new JTextField();
        textoClave2 = new JTextField();
        txtDescripcion = new JTextPane();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("A\u00f1adir contacto nuevo");
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
        textoUsuario.setText("Pseudonimo...");
        textoUsuario.setForeground(Color.gray);
        textoUsuario.addActionListener(e -> textoUsuarioActionPerformed(e));

        //---- btnAceptar ----
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(e -> btnAceptarActionPerformed(e));

        //---- btnCancelar ----
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(e -> btnCancelarActionPerformed(e));

        //---- textoClave ----
        textoClave.setText("Nombre...");
        textoClave.setForeground(Color.gray);
        textoClave.addActionListener(e -> textoUsuarioActionPerformed(e));

        //---- textoClave2 ----
        textoClave2.setText("Tel\u00e9fono...");
        textoClave2.setForeground(Color.gray);
        textoClave2.addActionListener(e -> textoUsuarioActionPerformed(e));

        //---- txtDescripcion ----
        txtDescripcion.setText("Descripci\u00f3n...");
        txtDescripcion.setForeground(Color.gray);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(textoUsuario, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textoClave, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textoClave2, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(39, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(textoUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(textoClave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(textoClave2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addContainerGap(18, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Laura Antelo González
    private JTextField textoUsuario;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JTextField textoClave;
    private JTextField textoClave2;
    private JTextPane txtDescripcion;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
