/*
 * Created by JFormDesigner on Mon Apr 29 18:02:36 GMT+02:00 2024
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
public class VContactos extends JDialog {
    public VContactos(Window owner) {
        super(owner);
        initComponents();
    }

    private void btnActualizarMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void jTable1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void btnBuscarActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Laura Antelo González
        btnRomperTrato = new JButton();
        Alias = new JLabel();
        btnVolver = new JButton();
        Alias_text = new JTextField();
        Alta_text = new JTextField();
        Pais_text = new JTextField();
        scrollPane1 = new JScrollPane();
        textPane2 = new JTextPane();
        Descripcion = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane2 = new JScrollPane();
        list1 = new JList();
        btnProponerTrato = new JButton();
        btnGuardar = new JButton();
        Teléfono = new JLabel();
        Nombre = new JLabel();
        scrollPane3 = new JScrollPane();
        list2 = new JList();
        btnGuardar2 = new JButton();
        btnGuardar3 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mis Contactos");
        setResizable(false);
        var contentPane = getContentPane();

        //---- btnRomperTrato ----
        btnRomperTrato.setText("Romper trato seleccinonado");
        btnRomperTrato.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnActualizarMouseClicked(e);
            }
        });

        //---- Alias ----
        Alias.setHorizontalAlignment(SwingConstants.RIGHT);
        Alias.setText("Alias:");

        //---- btnVolver ----
        btnVolver.setText("Volver");
        btnVolver.addActionListener(e -> btnBuscarActionPerformed(e));

        //---- Alta_text ----
        Alta_text.setEnabled(false);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textPane2);
        }

        //---- Descripcion ----
        Descripcion.setHorizontalAlignment(SwingConstants.RIGHT);
        Descripcion.setText("Descripcion:");

        //---- label3 ----
        label3.setText("(imagen)");

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(list1);
        }

        //---- btnProponerTrato ----
        btnProponerTrato.setText("Proponer tato");
        btnProponerTrato.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnActualizarMouseClicked(e);
            }
        });

        //---- btnGuardar ----
        btnGuardar.setText("Guardar edici\u00f3n");
        btnGuardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnActualizarMouseClicked(e);
            }
        });

        //---- Teléfono ----
        Teléfono.setHorizontalAlignment(SwingConstants.RIGHT);
        Teléfono.setText("Tel\u00e9fono:");

        //---- Nombre ----
        Nombre.setHorizontalAlignment(SwingConstants.RIGHT);
        Nombre.setText("Nombre:");

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(list2);
        }

        //---- btnGuardar2 ----
        btnGuardar2.setText("A\u00f1adir contacto");
        btnGuardar2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnActualizarMouseClicked(e);
            }
        });

        //---- btnGuardar3 ----
        btnGuardar3.setText("Borrar contacto");
        btnGuardar3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnActualizarMouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label2))
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(Teléfono)
                                    .addComponent(Alias))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(Descripcion)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addComponent(Nombre)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Pais_text, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Alta_text, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Alias_text, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))))))))
                    .addGap(18, 19, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(btnProponerTrato, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRomperTrato, GroupLayout.Alignment.TRAILING)
                        .addComponent(scrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(btnGuardar2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnGuardar3, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 1, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(279, 279, 279))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGap(19, 19, 19)
                                            .addComponent(label2)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28)
                                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(Alias)
                                                .addComponent(Alias_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(13, 13, 13)
                                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(Alta_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Teléfono))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(Pais_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Nombre))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(Descripcion)))
                                    .addGap(2, 2, 2)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnRomperTrato)
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnProponerTrato)
                                        .addComponent(btnGuardar2))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnGuardar)
                                        .addComponent(btnGuardar3))))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                            .addGap(117, 117, 117))))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Laura Antelo González
    private JButton btnRomperTrato;
    private JLabel Alias;
    private JButton btnVolver;
    private JTextField Alias_text;
    private JTextField Alta_text;
    private JTextField Pais_text;
    private JScrollPane scrollPane1;
    private JTextPane textPane2;
    private JLabel Descripcion;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane2;
    private JList list1;
    private JButton btnProponerTrato;
    private JButton btnGuardar;
    private JLabel Teléfono;
    private JLabel Nombre;
    private JScrollPane scrollPane3;
    private JList list2;
    private JButton btnGuardar2;
    private JButton btnGuardar3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
