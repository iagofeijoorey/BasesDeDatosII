/*
 * Created by JFormDesigner on Mon Apr 29 20:31:47 CEST 2024
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author Usuario
 */
public class VPropiedades extends JDialog {
    public VPropiedades(Window owner) {
        super(owner);
        initComponents();
    }

    private void btnActualizarMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void btnBuscarActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Laura Antelo González
        IDPropiedad = new JLabel();
        btnVolver = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        Teléfono = new JLabel();
        Tipo = new JLabel();
        Ubicacion = new JLabel();
        comboBox1 = new JComboBox();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Propiedades");
        setResizable(false);
        var contentPane = getContentPane();

        //---- IDPropiedad ----
        IDPropiedad.setHorizontalAlignment(SwingConstants.RIGHT);
        IDPropiedad.setText("IDPropiedad: ");

        //---- btnVolver ----
        btnVolver.setText("Volver");
        btnVolver.addActionListener(e -> btnBuscarActionPerformed(e));

        //---- label3 ----
        label3.setText("(imagen)");

        //---- Teléfono ----
        Teléfono.setHorizontalAlignment(SwingConstants.RIGHT);
        Teléfono.setText("Valor acutal:");

        //---- Tipo ----
        Tipo.setHorizontalAlignment(SwingConstants.RIGHT);
        Tipo.setText("Tipo:");

        //---- Ubicacion ----
        Ubicacion.setHorizontalAlignment(SwingConstants.RIGHT);
        Ubicacion.setText("Ubicaci\u00f3n:");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(label2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(133, 133, 133)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(IDPropiedad)
                                .addComponent(Teléfono, GroupLayout.Alignment.LEADING))
                            .addGap(189, 189, 189)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(Tipo)
                                    .addGap(18, 18, 18)
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                                .addComponent(Ubicacion))))
                    .addContainerGap(479, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnVolver)
                    .addGap(21, 21, 21)
                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(IDPropiedad)
                        .addComponent(Tipo)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Teléfono)
                        .addComponent(Ubicacion))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label2)
                    .addGap(248, 248, 248))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Laura Antelo González
    private JLabel IDPropiedad;
    private JButton btnVolver;
    private JLabel label2;
    private JLabel label3;
    private JLabel Teléfono;
    private JLabel Tipo;
    private JLabel Ubicacion;
    private JComboBox comboBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
