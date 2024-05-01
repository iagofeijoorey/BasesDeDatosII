/*
 * Created by JFormDesigner on Tue Apr 30 23:58:57 CEST 2024
 */

package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Diego
 */
public class VDetalles_NewProp extends JDialog {
    public VDetalles_NewProp(Window owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Diego
        panel1 = new JPanel();
        BtnContent = new JButton();
        TextAlmacen = new JLabel();
        TextBalas = new JLabel();
        Balas = new JTextField();
        TextNameType = new JLabel();
        AmountCapacity = new JTextField();
        TextEvento = new JLabel();
        Evento = new JTextField();
        TextValor = new JLabel();
        Valor = new JTextField();
        TextId = new JLabel();
        Id = new JTextField();
        TextTipo = new JLabel();
        Tipo = new JComboBox();
        TextGestor = new JLabel();
        Gestor = new JComboBox();
        TextAmountCapacity = new JLabel();
        button1 = new JButton();
        String = new JComboBox();
        comboBox1 = new JComboBox();
        TextUbicacion = new JLabel();
        Ubicacion = new JTextField();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
            EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax.swing
            .border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),
            java.awt.Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener()
            {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName()))
            throw new RuntimeException();}});

            //---- BtnContent ----
            BtnContent.setText("Ver contenido");

            //---- TextAlmacen ----
            TextAlmacen.setText("Almacen:");

            //---- TextBalas ----
            TextBalas.setText("Numero de balas:");

            //---- TextNameType ----
            TextNameType.setText("String");

            //---- TextEvento ----
            TextEvento.setText("Evento:");

            //---- TextValor ----
            TextValor.setText("Valor:");

            //---- TextId ----
            TextId.setText("Id:");

            //---- TextTipo ----
            TextTipo.setText("Tipo:");

            //---- TextGestor ----
            TextGestor.setText("Gestor:");

            //---- TextAmountCapacity ----
            TextAmountCapacity.setText("Integer:");

            //---- button1 ----
            button1.setText("Actualizar");

            //---- TextUbicacion ----
            TextUbicacion.setText("Ubicaci\u00f3n:");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap(11, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(TextBalas)
                                        .addGap(28, 28, 28)
                                        .addComponent(Balas, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(TextAlmacen)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboBox1)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(BtnContent)
                                    .addComponent(button1))
                                .addGap(59, 59, 59))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(TextId)
                                        .addGap(56, 56, 56)
                                        .addComponent(Id, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(TextTipo)
                                        .addGap(45, 45, 45)
                                        .addComponent(Tipo, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(TextValor)
                                        .addGap(35, 35, 35)
                                        .addComponent(Valor, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(TextGestor)
                                        .addGap(30, 30, 30)
                                        .addComponent(Gestor, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(TextEvento, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TextNameType))
                                        .addGap(9, 9, 9)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(Evento, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(String, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)
                                                .addComponent(TextAmountCapacity)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(AmountCapacity, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(TextUbicacion)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Ubicacion, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(26, 26, 26))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(TextId)
                                    .addComponent(TextTipo))))
                        .addGap(10, 10, 10)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(Valor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Gestor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(TextValor)
                                    .addComponent(TextGestor))))
                        .addGap(15, 15, 15)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(TextEvento))
                            .addComponent(Evento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(TextAmountCapacity)
                                .addComponent(AmountCapacity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextNameType)
                                    .addComponent(String, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(TextBalas))
                                    .addComponent(Balas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextAlmacen)
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextUbicacion)
                                    .addComponent(Ubicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(12, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(0, 32, Short.MAX_VALUE)
                                .addComponent(BtnContent)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button1)
                                .addGap(39, 39, 39))))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Diego
    private JPanel panel1;
    private JButton BtnContent;
    private JLabel TextAlmacen;
    private JLabel TextBalas;
    private JTextField Balas;
    private JLabel TextNameType;
    private JTextField AmountCapacity;
    private JLabel TextEvento;
    private JTextField Evento;
    private JLabel TextValor;
    private JTextField Valor;
    private JLabel TextId;
    private JTextField Id;
    private JLabel TextTipo;
    private JComboBox Tipo;
    private JLabel TextGestor;
    private JComboBox Gestor;
    private JLabel TextAmountCapacity;
    private JButton button1;
    private JComboBox String;
    private JComboBox comboBox1;
    private JLabel TextUbicacion;
    private JTextField Ubicacion;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
