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
        // Generated using JFormDesigner Evaluation license - Sara Castro
        btnActualizar = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        Alias = new JLabel();
        btnVolver = new JButton();
        Nombre = new JLabel();
        Influencia = new JLabel();
        FechaAlta = new JLabel();
        Pais = new JLabel();
        Alias_text = new JTextField();
        Nombre_text = new JTextField();
        Alta_text = new JTextField();
        Pais_text = new JTextField();
        scrollPane1 = new JScrollPane();
        textPane2 = new JTextPane();
        Descripcion = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        textField1 = new JTextField();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mis Contactos");
        setResizable(false);
        var contentPane = getContentPane();

        //---- btnActualizar ----
        btnActualizar.setText("Actualizar");
        btnActualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnActualizarMouseClicked(e);
            }
        });

        //======== jScrollPane1 ========
        {

            //---- jTable1 ----
            jTable1.setModel(new ModeloUsuarios());
            jTable1.setPreferredSize(new Dimension(500, 80));
            jTable1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    jTable1MouseClicked(e);
                }
            });
            jScrollPane1.setViewportView(jTable1);
        }

        //---- Alias ----
        Alias.setHorizontalAlignment(SwingConstants.RIGHT);
        Alias.setText("Alias:");

        //---- btnVolver ----
        btnVolver.setText("Volver");
        btnVolver.addActionListener(e -> btnBuscarActionPerformed(e));

        //---- Nombre ----
        Nombre.setHorizontalAlignment(SwingConstants.RIGHT);
        Nombre.setText("Nombre:");

        //---- Influencia ----
        Influencia.setHorizontalAlignment(SwingConstants.RIGHT);
        Influencia.setText("Influencia:");

        //---- FechaAlta ----
        FechaAlta.setHorizontalAlignment(SwingConstants.RIGHT);
        FechaAlta.setText("Dado de alta el:");

        //---- Pais ----
        Pais.setHorizontalAlignment(SwingConstants.RIGHT);
        Pais.setText("Pais:");

        //---- Alta_text ----
        Alta_text.setEnabled(false);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textPane2);
        }

        //---- Descripcion ----
        Descripcion.setHorizontalAlignment(SwingConstants.RIGHT);
        Descripcion.setText("Descripcion:");

        //---- label2 ----
        label2.setText("Foto de perfil");

        //---- label3 ----
        label3.setText("(imagen)");

        //---- label4 ----
        label4.setText("Jefe de divisi\u00f3n:");

        //---- textField1 ----
        textField1.setEnabled(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                    .addGap(162, 162, 162)
                    .addComponent(label2)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(Influencia)
                                                .addComponent(Alias))
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                    .addGap(122, 122, 122)
                                                    .addComponent(FechaAlta))
                                                .addComponent(Nombre, GroupLayout.Alignment.TRAILING)))
                                        .addGroup(contentPaneLayout.createParallelGroup()
                                            .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(182, 182, 182)
                                                .addComponent(Pais))
                                            .addComponent(Alias_text, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Alta_text, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                        .addComponent(Nombre_text, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                        .addComponent(Pais_text, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)))
                                .addComponent(Descripcion, GroupLayout.Alignment.LEADING)
                                .addComponent(scrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                            .addGap(150, 150, 150)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)))
                            .addGap(21, 21, 21))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(285, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(label2))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                            .addGap(25, 25, 25)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Nombre)
                                .addComponent(Nombre_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Alias)
                                .addComponent(Alias_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Influencia)
                                .addComponent(Alta_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(FechaAlta, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Pais)
                                .addComponent(Pais_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                            .addComponent(Descripcion)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                            .addComponent(btnActualizar)))
                    .addGap(15, 15, 15))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Sara Castro
    private JButton btnActualizar;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JLabel Alias;
    private JButton btnVolver;
    private JLabel Nombre;
    private JLabel Influencia;
    private JLabel FechaAlta;
    private JLabel Pais;
    private JTextField Alias_text;
    private JTextField Nombre_text;
    private JTextField Alta_text;
    private JTextField Pais_text;
    private JScrollPane scrollPane1;
    private JTextPane textPane2;
    private JLabel Descripcion;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
