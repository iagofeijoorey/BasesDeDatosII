/*
 * Created by JFormDesigner on Wed May 01 13:12:39 CEST 2024
 */

package gui;

import aplicacion.FachadaAplicacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Usuario
 */
public class VTratoNuevo extends JDialog {
    private FachadaAplicacion fa;
    private String identificador;
    private String tipoTrato;
    public VTratoNuevo(Window owner, FachadaAplicacion fa) {
        super(owner);
        identificador = null;
        tipoTrato = null;
        initComponents();
    }

    public String getIdentificador() { return identificador; }
    public String getTipoTrato() { return tipoTrato; }

    private void btnAceptarActionPerformed(ActionEvent e) {
        if(identificador != "Identificador numérico..." )
            if (!fa.existeTrato(Integer.parseInt(identificador))){
                identificador = textoIdentificador.getText();
                tipoTrato = comboTipoTrato.getSelectedItem().toString();
                this.dispose();
            }
        //else //Imprimir que o valor non sirve
    }

    private void btnCancelarActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Sara Castro
        textoIdentificador = new JTextField();
        btnAceptar = new JButton();
        btnCancelar = new JButton();
        comboTipoTrato = new JComboBox<>();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("A\u00f1adir trato nuevo");
        setModal(true);
        setName("VAutentificacion");
        setResizable(false);
        var contentPane = getContentPane();

        //---- textoIdentificador ----
        textoIdentificador.setText("Identificador num\u00e9rico...");
        textoIdentificador.setForeground(Color.gray);

        //---- btnAceptar ----
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(e -> btnAceptarActionPerformed(e));

        //---- btnCancelar ----
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(e -> btnCancelarActionPerformed(e));

        //---- comboTipoTrato ----
        comboTipoTrato.setForeground(Color.gray);
        comboTipoTrato.setModel(new DefaultComboBoxModel<>(new String[] {
            "DebeFavor",
            "Soborno",
            "DebesFavor",
            "Deuda",
            "Extorsion"
        }));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(btnCancelar)
                    .addGap(18, 18, 18)
                    .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 42, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(textoIdentificador, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboTipoTrato, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))
                    .addGap(35, 35, 35))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(textoIdentificador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(comboTipoTrato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAceptar)
                        .addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(20, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Sara Castro
    private JTextField textoIdentificador;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JComboBox<String> comboTipoTrato;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
