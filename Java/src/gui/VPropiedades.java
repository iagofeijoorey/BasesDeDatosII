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

    aplicacion.FachadaAplicacion fa;

    public VPropiedades(aplicacion.FachadaAplicacion fa) { /** Creates new form VPrincipal */
        this.fa=fa;
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
        // Generated using JFormDesigner Evaluation license - Diego
        panel1 = new JPanel();
        btnVolver = new JButton();
        ImagenPropiedad = new JLabel();
        TextId = new JLabel();
        Id = new JTextField();
        Valor = new JTextField();
        TextValor = new JLabel();
        TextTipo = new JLabel();
        TextGestor = new JLabel();
        TextTipoSearch = new JLabel();
        TipoSearch = new JTextField();
        buscar = new JButton();
        scrollPane1 = new JScrollPane();
        Propiedades = new JTable();
        TextEvento = new JLabel();
        Evento = new JTextField();
        BtnMasInfo = new JButton();
        Gestor = new JComboBox();
        Tipo = new JComboBox();
        btnNewProp = new JButton();
        BtnEraseProp = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
            swing.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border
            .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog"
            ,java.awt.Font.BOLD,12),java.awt.Color.red),panel1. getBorder
            ()));panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
            .beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException
            ();}});

            //---- btnVolver ----
            btnVolver.setText("volver");

            //---- TextId ----
            TextId.setText("Id:");

            //---- TextValor ----
            TextValor.setText("Valor:");

            //---- TextTipo ----
            TextTipo.setText("Tipo:");

            //---- TextGestor ----
            TextGestor.setText("Gestor:");

            //---- TextTipoSearch ----
            TextTipoSearch.setText("Tipo:");

            //---- buscar ----
            buscar.setText("Buscar");

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(Propiedades);
            }

            //---- TextEvento ----
            TextEvento.setText("Evento:");

            //---- BtnMasInfo ----
            BtnMasInfo.setText("Detalles");

            //---- btnNewProp ----
            btnNewProp.setText("Nueva Propiedad");

            //---- BtnEraseProp ----
            BtnEraseProp.setText("Borrar");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnVolver)
                                .addGap(148, 148, 148)
                                .addComponent(ImagenPropiedad, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(TextValor)
                                            .addComponent(TextId)
                                            .addComponent(TextEvento, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                                        .addGap(8, 8, 8)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addGroup(panel1Layout.createParallelGroup()
                                                    .addGroup(panel1Layout.createSequentialGroup()
                                                        .addComponent(Id, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(TextTipo))
                                                    .addGroup(panel1Layout.createSequentialGroup()
                                                        .addComponent(Valor, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(TextGestor)))
                                                .addGap(31, 31, 31)
                                                .addGroup(panel1Layout.createParallelGroup()
                                                    .addComponent(Gestor)
                                                    .addComponent(Tipo)))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(Evento, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addComponent(BtnEraseProp)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BtnMasInfo)))
                                .addGap(1, 1, 1)))
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(TextTipoSearch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TipoSearch, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(buscar)
                                .addGap(74, 74, 74))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(btnNewProp)
                                .addContainerGap(140, Short.MAX_VALUE))))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(574, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(TextTipoSearch)
                                            .addComponent(TipoSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(buscar)))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(btnVolver)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(ImagenPropiedad, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextId)
                                    .addComponent(Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextTipo)
                                    .addComponent(Tipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextValor)
                                    .addComponent(Valor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextGestor)
                                    .addComponent(Gestor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextEvento)
                                    .addComponent(Evento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnMasInfo)
                                    .addComponent(BtnEraseProp)
                                    .addComponent(btnNewProp))))
                        .addContainerGap(23, Short.MAX_VALUE))
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
    private JButton btnVolver;
    private JLabel ImagenPropiedad;
    private JLabel TextId;
    private JTextField Id;
    private JTextField Valor;
    private JLabel TextValor;
    private JLabel TextTipo;
    private JLabel TextGestor;
    private JLabel TextTipoSearch;
    private JTextField TipoSearch;
    private JButton buscar;
    private JScrollPane scrollPane1;
    private JTable Propiedades;
    private JLabel TextEvento;
    private JTextField Evento;
    private JButton BtnMasInfo;
    private JComboBox Gestor;
    private JComboBox Tipo;
    private JButton btnNewProp;
    private JButton BtnEraseProp;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
