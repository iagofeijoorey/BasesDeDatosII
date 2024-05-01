/*
 * Created by JFormDesigner on Wed May 01 10:29:43 CEST 2024
 */

package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.Contacto;

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
    private Contacto contacto;

    public VContactoNuevo(Window owner, FachadaAplicacion fa) {
        super(owner);
        this.fa = fa;
        contacto = null;
        initComponents();
    }

    public Contacto getContacto() { return contacto; }

    private void btnAceptarActionPerformed(ActionEvent e) {
        if(textoPseudonimo.getText().equals("Pseudónimo...") && textoPseudonimo.getText() != null){
            contacto = fa.crearContacto(textoPseudonimo.getText(), textoNombre.getText(), textoTelefono.getText(), txtDescripcion.getText());
            }
        //else //Imprimir que o valor non sirve

        this.dispose();
    }

    private void btnCancelarActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Sara Castro
        textoPseudonimo = new JTextField();
        btnAceptar = new JButton();
        btnCancelar = new JButton();
        textoNombre = new JTextField();
        textoTelefono = new JTextField();
        txtDescripcion = new JTextPane();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("A\u00f1adir contacto nuevo");
        setModal(true);
        setName("VAutentificacion");
        setResizable(false);
        var contentPane = getContentPane();

        //---- textoPseudonimo ----
        textoPseudonimo.setText("Pseudonimo...");
        textoPseudonimo.setForeground(Color.gray);

        //---- btnAceptar ----
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(e -> btnAceptarActionPerformed(e));

        //---- btnCancelar ----
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(e -> btnCancelarActionPerformed(e));

        //---- textoNombre ----
        textoNombre.setText("Nombre...");
        textoNombre.setForeground(Color.gray);

        //---- textoTelefono ----
        textoTelefono.setText("Tel\u00e9fono...");
        textoTelefono.setForeground(Color.gray);

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
                                .addComponent(textoPseudonimo, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textoNombre, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textoTelefono, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(39, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(textoPseudonimo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(textoNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(textoTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Sara Castro
    private JTextField textoPseudonimo;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JTextField textoNombre;
    private JTextField textoTelefono;
    private JTextPane txtDescripcion;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
