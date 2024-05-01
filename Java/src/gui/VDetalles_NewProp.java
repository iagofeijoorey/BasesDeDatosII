/*
 * Created by JFormDesigner on Tue Apr 30 23:58:57 CEST 2024
 */

package gui;

import aplicacion.PropiedadesYCuentas.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Diego
 */
public class VDetalles_NewProp extends JDialog {
    Propiedad propiedad;
    aplicacion.FachadaAplicacion fa;

    // Constructor para añadir propiedad
    public VDetalles_NewProp(aplicacion.FachadaAplicacion fa) {
        this.fa=fa;
        initComponents();
        BtnActualizar.setText("Añadir");
        BoxTipo.addItem("Armamento");
        BoxTipo.addItem("Commodities");
        BoxTipo.addItem("Inmobiliario");
        BoxTipo.addItem("Vehiculos");

        TextId.setText("");
        TextValor.setText("");
        AmountCapacity.setText("");
        TextBalas.setText("");
        TextUbicacion.setText("");
    }

    // Constructor para mostrar detalles
    public VDetalles_NewProp(aplicacion.FachadaAplicacion fa, Propiedad propiedad) {
        this.fa=fa;
        initComponents();
        BtnActualizar.setText("Actualizar");
        BoxTipo.addItem("Armamento");
        BoxTipo.addItem("Commodities");
        BoxTipo.addItem("Inmobiliario");
        BoxTipo.addItem("Vehiculos");

        //Textos
        Id.setText(propiedad.getIdPropiedad().toString());
        Valor.setText(propiedad.getValorActual().toString());
        switch (propiedad.getTipoGeneral()){
            case "arma":
                Arma arma = (Arma) propiedad;
                //1
                Balas.setText(arma.getBalas().toString());
                //2
                AmountCapacity.setText(arma.getCantidad().toString());
                //3
                BoxTipo.setSelectedItem("Armamento");
                //4
                for (String tipo : TipoArmamento.valuesString()) {
                    BoxString.addItem(tipo);
                }
                BoxString.setSelectedItem(arma.getTipoString());
                break;


            case "inmobiliario":
                Inmobiliario inmobiliario = (Inmobiliario) propiedad;
                //1
                Ubicacion.setText(inmobiliario.getUbicacion());
                //2
                BoxTipo.setSelectedItem("Inmobiliario");
                //3
                for (String tipo : TipoInmobiliario.valuesString()) {
                    BoxString.addItem(tipo);
                }
                BoxString.setSelectedItem(inmobiliario.getTipoString());
                //4
                if (inmobiliario.getTipoString().equals("Almacen"))
                    AmountCapacity.setText(inmobiliario.getCapacidad().toString());
                else AmountCapacity.setText("");
                break;

            case "commodities":
                //Caso3
                break;

            case "vehiculos":
                //Caso 4
                break;


            default:
                //Default
                break;
        }
    }

    private void entrarContenido(MouseEvent e) {
        fa.ventanaContenido();
    }

    private void BoxTipoItemStateChanged(ItemEvent e) {
        // Obtener el tipo seleccionado en el BoxTipo
        String tipoSeleccionado = (String) BoxTipo.getSelectedItem();

        // Limpiar los elementos actuales del BoxString
        BoxString.removeAllItems();

        // Llenar el BoxString con los tipos correspondientes al tipo seleccionado en el BoxTipo
        switch (tipoSeleccionado) {
            case "Armamento":
                for (String tipo : TipoArmamento.valuesString()) {
                    BoxString.addItem(tipo);
                }
                break;
            case "Inmobiliario":
                for (String tipo : TipoInmobiliario.valuesString()) {
                    BoxString.addItem(tipo);
                }
                break;
            // Agregar más casos según sea necesario para otros tipos
        }
    }

    private void BoxTipoMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Iago Feijoo Rey
        panel1 = new JPanel();
        BtnContent = new JButton();
        TextAlmacen = new JLabel();
        TextBalas = new JLabel();
        Balas = new JTextField();
        TextNameType = new JLabel();
        AmountCapacity = new JTextField();
        TextEvento = new JLabel();
        TextValor = new JLabel();
        Valor = new JTextField();
        TextId = new JLabel();
        Id = new JTextField();
        TextTipo = new JLabel();
        BoxTipo = new JComboBox();
        TextGestor = new JLabel();
        BoxGestor = new JComboBox();
        TextAmountCapacity = new JLabel();
        BtnActualizar = new JButton();
        BoxString = new JComboBox();
        BoxAlmacen = new JComboBox();
        TextUbicacion = new JLabel();
        Ubicacion = new JTextField();
        scrollPane1 = new JScrollPane();
        tablaEventos = new JTable();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
            EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing
            .border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),
            java.awt.Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener()
            {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))
            throw new RuntimeException();}});

            //---- BtnContent ----
            BtnContent.setText("Ver contenido");
            BtnContent.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    entrarContenido(e);
                }
            });

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

            //---- BoxTipo ----
            BoxTipo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    BoxTipoMouseClicked(e);
                }
            });
            BoxTipo.addItemListener(e -> BoxTipoItemStateChanged(e));

            //---- TextGestor ----
            TextGestor.setText("Gestor:");

            //---- TextAmountCapacity ----
            TextAmountCapacity.setText("Integer:");

            //---- BtnActualizar ----
            BtnActualizar.setText("Actualizar");

            //---- TextUbicacion ----
            TextUbicacion.setText("Ubicaci\u00f3n:");

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(tablaEventos);
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(TextUbicacion)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Ubicacion, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(324, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(TextNameType)
                                        .addGap(9, 9, 9)
                                        .addComponent(BoxString, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TextAmountCapacity)
                                        .addGap(27, 27, 27)
                                        .addComponent(AmountCapacity, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addComponent(TextId)
                                        .addGap(56, 56, 56)
                                        .addComponent(Id, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(TextTipo)
                                        .addGap(45, 45, 45)
                                        .addComponent(BoxTipo, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addComponent(TextValor)
                                        .addGap(35, 35, 35)
                                        .addComponent(Valor, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(TextGestor)
                                        .addGap(30, 30, 30)
                                        .addComponent(BoxGestor, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addComponent(TextEvento, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
                                .addGap(0, 31, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(TextAlmacen)
                                        .addGap(18, 18, 18)
                                        .addComponent(BoxAlmacen, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(TextBalas)
                                        .addGap(28, 28, 28)
                                        .addComponent(Balas, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addComponent(BtnContent)
                                        .addGap(95, 95, 95))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addComponent(BtnActualizar)
                                        .addGap(106, 106, 106))))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(TextId)
                                    .addComponent(TextTipo))))
                        .addGap(10, 10, 10)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(Valor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoxGestor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(TextValor)
                                    .addComponent(TextGestor))))
                        .addGap(25, 25, 25)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(TextEvento)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextNameType)
                                    .addComponent(BoxString, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(AmountCapacity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextAmountCapacity))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(TextBalas))
                                    .addComponent(Balas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextAlmacen)
                                    .addComponent(BoxAlmacen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(BtnContent)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnActualizar)
                                .addGap(8, 8, 8)))
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(TextUbicacion)
                            .addComponent(Ubicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
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
    // Generated using JFormDesigner Evaluation license - Iago Feijoo Rey
    private JPanel panel1;
    private JButton BtnContent;
    private JLabel TextAlmacen;
    private JLabel TextBalas;
    private JTextField Balas;
    private JLabel TextNameType;
    private JTextField AmountCapacity;
    private JLabel TextEvento;
    private JLabel TextValor;
    private JTextField Valor;
    private JLabel TextId;
    private JTextField Id;
    private JLabel TextTipo;
    private JComboBox BoxTipo;
    private JLabel TextGestor;
    private JComboBox BoxGestor;
    private JLabel TextAmountCapacity;
    private JButton BtnActualizar;
    private JComboBox BoxString;
    private JComboBox BoxAlmacen;
    private JLabel TextUbicacion;
    private JTextField Ubicacion;
    private JScrollPane scrollPane1;
    private JTable tablaEventos;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}