/*
 * Created by JFormDesigner on Tue Apr 30 23:58:57 CEST 2024
 */

package gui;

import aplicacion.PropiedadesYCuentas.*;

import java.awt.*;
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

        TextTipoCommodity.setVisible(false);
        TipoCommodity.setVisible(false);
        BoxString.setVisible(true);
        TextNameType.setVisible(true);

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

        // Botones
        BtnActualizar.setText("Actualizar");
        BtnContent.setVisible(false);

        // BoxTipo
        BoxTipo.addItem("Armamento");
        BoxTipo.addItem("Commodities");
        BoxTipo.addItem("Inmobiliario");
        BoxTipo.addItem("Vehiculos");

        //BoxGestor
        BoxGestor.addItem(propiedad.getGestor().getNombreCompleto());

        //// Mostrar u ocultar elementos
        // Commodity
        TextTipoCommodity.setVisible(false);
        TipoCommodity.setVisible(false);
        // Armamento
        TextBalas.setVisible(false);
        Balas.setVisible(false);
        // Inmobiliario
        TextUbicacion.setVisible(false);
        Ubicacion.setVisible(false);
        // Armamento y Vehículos
        TextAlmacen.setVisible(false);
        BoxAlmacen.setVisible(false);

        //// Editable
        Id.setEditable(false);

        //Textos
        Id.setText(propiedad.getIdPropiedad().toString());
        Valor.setText(propiedad.getValorActual().toString());
        BoxTipo.setSelectedItem(propiedad.getTipoGeneral());
        BoxGestor.setSelectedItem(propiedad.getGestor().getNombreCompleto());
        switch (propiedad.getTipoGeneral()){
            case "arma":
                
                Arma arma = (Arma) propiedad;

                // Visibilidad textos
                TextBalas.setVisible(true);
                Balas.setVisible(true);

                // Datos
                Balas.setText(arma.getBalas().toString());
                TextAmountCapacity.setText("Cantidad:");
                AmountCapacity.setText(arma.getCantidad().toString());
                for (String tipo : TipoArmamento.valuesString()) {
                    BoxString.addItem(tipo);
                }
                BoxString.setSelectedItem(arma.getTipoString());

                // Almacen asociado
                TextAlmacen.setVisible(true);
                BoxAlmacen.setVisible(true);
                BoxAlmacen.addItem(arma.getAlmacen().getUbicacion());
                BoxAlmacen.setSelectedItem(arma.getAlmacen().getUbicacion());
                break;
                
            case "inmobiliario":
                
                Inmobiliario inmobiliario = (Inmobiliario) propiedad;

                // Visibilidad textos
                TextUbicacion.setVisible(true);
                Ubicacion.setVisible(true);
                
                // Textos
                Ubicacion.setText(inmobiliario.getUbicacion());
                for (String tipo : TipoInmobiliario.valuesString()) {
                    BoxString.addItem(tipo);
                }
                BoxString.setSelectedItem(inmobiliario.getTipoString());
                if (inmobiliario.getTipoString().equals("Almacen")) {
                    AmountCapacity.setText(inmobiliario.getCapacidad().toString());
                }
                else {
                    AmountCapacity.setVisible(false);
                    TextAmountCapacity.setVisible(false);
                }
                break;

            case "commodities":

                Commodity commodity = (Commodity) propiedad;
                
                // Visibilidad textos
                TextTipoCommodity.setVisible(true);
                TipoCommodity.setVisible(true);
                TextNameType.setVisible(false);
                BoxString.setVisible(false);
                
                // Textos
                TipoCommodity.setText(commodity.getTipoString());
                
                break;

            case "vehiculos":
                Vehiculo vehiculo = (Vehiculo) propiedad;

                // Visibilidad textos
                AmountCapacity.setText(vehiculo.getCapacidad().toString());

                // Almacen asociado
                TextAlmacen.setVisible(true);
                BoxAlmacen.setVisible(true);
                BoxAlmacen.addItem(vehiculo.getAlmacen().getUbicacion());
                BoxAlmacen.setSelectedItem(vehiculo.getAlmacen().getUbicacion());
                break;


            default:
                //Default
                break;
        }
    }

    private void entrarContenido(MouseEvent e) {
        fa.ventanaContenido((Inmobiliario) propiedad);
    }

    private void BoxTipoItemStateChanged(ItemEvent e) {
        // Obtener el tipo seleccionado en el BoxTipo
        String tipoSeleccionado = (String) BoxTipo.getSelectedItem();

        // Limpiar los elementos actuales del BoxString
        BoxString.removeAllItems();

        // Llenar el BoxString con los tipos correspondientes al tipo seleccionado en el BoxTipo
        switch (tipoSeleccionado) {
            case "Armamento":
                TextTipoCommodity.setVisible(false);
                TipoCommodity.setVisible(false);
                BoxString.setVisible(true);
                TextNameType.setVisible(true);
                for (String tipo : TipoArmamento.valuesString()) {
                    BoxString.addItem(tipo);
                }
                break;
            case "Inmobiliario":
                TextTipoCommodity.setVisible(false);
                TipoCommodity.setVisible(false);
                BoxString.setVisible(true);
                TextNameType.setVisible(true);
                for (String tipo : TipoInmobiliario.valuesString()) {
                    BoxString.addItem(tipo);
                }
                break;
            case "Vehiculos":
                TextTipoCommodity.setVisible(false);
                TipoCommodity.setVisible(false);
                BoxString.setVisible(true);
                TextNameType.setVisible(true);
                for (String tipo : TipoVehiculo.valuesString()) {
                    BoxString.addItem(tipo);
                }
                break;
            case "Commodities":
                TextTipoCommodity.setVisible(true);
                TipoCommodity.setVisible(true);
                BoxString.setVisible(false);
                TextNameType.setVisible(false);
                break;
            // Agregar más casos según sea necesario para otros tipos
        }
    }

    private void BoxTipoMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Diego
        panel1 = new JPanel();
        BtnContent = new JButton();
        TextAlmacen = new JLabel();
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
        BoxAlmacen = new JComboBox();
        TextUbicacion = new JLabel();
        Ubicacion = new JTextField();
        scrollPane1 = new JScrollPane();
        tablaEventos = new JTable();
        TextNameType = new JLabel();
        BoxString = new JComboBox();
        TipoCommodity = new JTextField();
        TextTipoCommodity = new JLabel();
        TextBalas = new JLabel();
        Balas = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
            .swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing
            .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
            Font("Dialo\u0067",java.awt.Font.BOLD,12),java.awt.Color.red
            ),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
            public void propertyChange(java.beans.PropertyChangeEvent e){if("borde\u0072".equals(e.getPropertyName(
            )))throw new RuntimeException();}});

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

            //---- TextNameType ----
            TextNameType.setText("String");

            //---- TextTipoCommodity ----
            TextTipoCommodity.setText("Tipo Commodity");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(TextAmountCapacity)
                                    .addComponent(TextAlmacen)
                                    .addComponent(TextUbicacion))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(AmountCapacity, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Ubicacion, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BoxAlmacen, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(TextTipoCommodity)
                                            .addComponent(TextNameType))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(BoxString, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                            .addComponent(TipoCommodity)))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(BtnContent)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                        .addComponent(BtnActualizar)))
                                .addGap(42, 42, 42))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(TextEvento, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(TextId)
                                        .addGap(56, 56, 56)
                                        .addComponent(Id, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(TextTipo)
                                        .addGap(45, 45, 45)
                                        .addComponent(BoxTipo, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(TextValor)
                                        .addGap(35, 35, 35)
                                        .addComponent(Valor, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(TextGestor)
                                        .addGap(30, 30, 30)
                                        .addComponent(BoxGestor, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 49, Short.MAX_VALUE))))
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
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(TextEvento))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(BoxString, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(TextNameType, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TipoCommodity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(TextTipoCommodity, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnContent)
                                    .addComponent(BtnActualizar))
                                .addGap(92, 92, 92))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(AmountCapacity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(TextAmountCapacity, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(BoxAlmacen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(TextAlmacen, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(Ubicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextUbicacion, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(102, 102, 102))))
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
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //---- TextBalas ----
        TextBalas.setText("Numero de balas:");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Diego
    private JPanel panel1;
    private JButton BtnContent;
    private JLabel TextAlmacen;
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
    private JComboBox BoxAlmacen;
    private JLabel TextUbicacion;
    private JTextField Ubicacion;
    private JScrollPane scrollPane1;
    private JTable tablaEventos;
    private JLabel TextNameType;
    private JComboBox BoxString;
    private JTextField TipoCommodity;
    private JLabel TextTipoCommodity;
    private JLabel TextBalas;
    private JTextField Balas;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
