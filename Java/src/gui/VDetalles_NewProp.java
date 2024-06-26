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
    // Atributos para lógica
    boolean inicializador; // Para controlar el cambio de tipo
    boolean continuador; // Para controlar el cambio de tipo
    boolean continuador_almacen; // Para controlar el cambio de subtipo

    // Constructor para añadir propiedad
    public VDetalles_NewProp(aplicacion.FachadaAplicacion fa) {

        this.fa=fa;
        inicializador = true;
        continuador = true;
        initComponents();

        // Botones
        BtnActualizar.setText("Actualizar");
        BtnContent.setVisible(false);
        BtnActualizar.setText("Añadir");

        // BoxTipo
        BoxTipo.addItem("arma");
        BoxTipo.addItem("Commodities");
        BoxTipo.addItem("Inmobiliario");
        BoxTipo.addItem("Vehículo");

        // Editable
        Id.setEditable(false);

        BoxTipo.setSelectedItem("arma");
        iniciarVisibilidad();

    }

    // Constructor para mostrar detalles
    public VDetalles_NewProp(aplicacion.FachadaAplicacion fa, Propiedad propiedad) {
        this.fa=fa;
        this.propiedad = propiedad;
        inicializador = true;
        continuador = true;
        initComponents();

        // Tabla eventos
        buscarEventos();

        // Botones
        BtnActualizar.setText("Actualizar");
        BtnContent.setVisible(false);

        // BoxTipo
        BoxTipo.addItem("arma");
        BoxTipo.addItem("Commodities");
        BoxTipo.addItem("Inmobiliario");
        BoxTipo.addItem("Vehículo");

        //Textos
        Id.setText(propiedad.getIdPropiedad().toString());
        Valor.setText(propiedad.getValorActual().toString());

        //BoxGestor
        BoxGestor.addItem(propiedad.getGestor().getNombreCompleto());
        BoxGestor.setSelectedItem(propiedad.getGestor().getNombreCompleto());

        BoxTipo.setSelectedItem(propiedad.getTipoGeneral().toString());
        iniciarVisibilidad();

        // Editable
        Id.setEditable(false);
        BoxTipo.setEnabled(false);
        BoxString.setEnabled(false);

        // Inicializar datos
        switch (propiedad.getTipoGeneral().toString()){
            case "arma":
                Arma arma = (Arma) propiedad;
                BoxTipo.setSelectedItem(arma.getTipoGeneral().toString());

                // Datos
                Balas.setText(arma.getBalas().toString());
                AmountCapacity.setText(arma.getCantidad().toString());
                BoxString.setSelectedItem(arma.getTipoString());

                // Almacen asociado
                BoxAlmacen.setSelectedItem(arma.getAlmacen().getUbicacion());
                break;

            case "Inmobiliario":
                Inmobiliario inmobiliario = (Inmobiliario) propiedad;
                BoxTipo.setSelectedItem(inmobiliario.getTipoGeneral().toString());

                // Textos
                Ubicacion.setText(inmobiliario.getUbicacion());
                BoxString.setSelectedItem(inmobiliario.getTipoString());
                if (BoxString.getSelectedItem().toString().equals("Almacen")){
                    AmountCapacity.setText(inmobiliario.getCapacidad().toString());
                }
                break;

            case "Commodities":
                Commodity commodity = (Commodity) propiedad;

                BoxTipo.setSelectedItem(commodity.getTipoGeneral().toString());
                // Textos
                TipoCommodity.setText(commodity.getTipoString());
                AmountCapacity.setText(commodity.getCantidad().toString());

                break;

            case "Vehículo":
                Vehiculo vehiculo = (Vehiculo) propiedad;
                BoxTipo.setSelectedItem(vehiculo.getTipoGeneral().toString());

                AmountCapacity.setText(vehiculo.getCantidad().toString());

                // Almacen asociado
                BoxAlmacen.addItem(vehiculo.getAlmacen().getUbicacion());
                BoxAlmacen.setSelectedItem(vehiculo.getAlmacen().getUbicacion());
                break;

            default:
                //Default
                break;
        }
    }

    //// Gestión Visibilidad
    // Visibilidad dependiendo del tipo de propiedad
    public void iniciarVisibilidad() {

        continuador = true;

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
        AmountCapacity.setVisible(true);
        TextAmountCapacity.setVisible(true);
        BtnContent.setVisible(false);
        // Armamento y Vehículos
        TextAlmacen.setVisible(false);
        BoxAlmacen.setVisible(false);

        TextNameType.setVisible(true);
        BoxString.setVisible(true);

        java.util.List<Inmobiliario> almacenes;

        switch (BoxTipo.getSelectedItem().toString()){
            case "arma":
                // Visibilidad textos
                TextAlmacen.setVisible(true);
                BoxAlmacen.setVisible(true);
                TextBalas.setVisible(true);
                Balas.setVisible(true);

                // Datos
                TextAmountCapacity.setText("Cantidad:");
                for (String tipo : TipoArmamento.valuesString()) {
                    BoxString.addItem(tipo);
                }

                // Almacenes
                almacenes = consultaAlmacenes();
                for (Inmobiliario inmobiliario : almacenes) {
                    String tipoString = inmobiliario.getUbicacion();
                    BoxAlmacen.addItem(tipoString);
                }

                break;

            case "Inmobiliario":

                // Visibilidad textos
                TextUbicacion.setVisible(true);
                Ubicacion.setVisible(true);

                // Datos
                for (String tipo : TipoInmobiliario.valuesString()) {
                    BoxString.addItem(tipo);
                }
                if (BoxString.getSelectedItem().toString().equals("Almacen")){
                    TextAmountCapacity.setText("Capacidad:");
                    BtnContent.setVisible(true);
                }
                else {
                    AmountCapacity.setVisible(false);
                    TextAmountCapacity.setVisible(false);
                    BtnContent.setVisible(false);
                }

                break;

            case "Commodities":

                // Visibilidad textos
                TextTipoCommodity.setVisible(true);
                TipoCommodity.setVisible(true);
                TextNameType.setVisible(false);
                BoxString.setVisible(false);


                // Datos
                TextAmountCapacity.setText("Cantidad:");

                break;

            case "Vehículo":

                // Visibilidad textos
                TextAmountCapacity.setText("Cantidad:");

                // Almacen asociado
                TextAlmacen.setVisible(true);
                BoxAlmacen.setVisible(true);

                // Datos
                for (String tipo : TipoVehiculo.valuesString()) {
                    BoxString.addItem(tipo);
                }
                TextAmountCapacity.setText("Cantidad:");

                // Almacenes
                almacenes = consultaAlmacenes();
                for (Inmobiliario inmobiliario : almacenes) {
                    String tipoString = inmobiliario.getUbicacion();
                    BoxAlmacen.addItem(tipoString);
                }
                break;

            default:
                //Default
                break;
        }
    }

    // Tipos
    private void BoxTipoItemStateChanged(ItemEvent e) {

        if (inicializador) {
            inicializador = false;
        }
        else if (continuador) {
            continuador = false;
        }
        else {
            BoxString.removeAllItems();
            BoxAlmacen.removeAllItems();
            BoxGestor.removeAllItems();
            iniciarVisibilidad();
        }
    }

    // Subtipos
    private void BoxStringItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if (continuador_almacen) {
            continuador_almacen = false;
        }
        else {
            continuador_almacen = true;

            if(BoxTipo.getSelectedItem().toString().equals("Inmobiliario")) {
                // Visibilidad textos
                TextUbicacion.setVisible(true);
                Ubicacion.setVisible(true);

                // Datos
                if (BoxString.getSelectedItem().toString().equals("Almacen")) {
                    AmountCapacity.setVisible(true);
                    TextAmountCapacity.setVisible(true);
                    TextAmountCapacity.setText("Capacidad:");
                    BtnContent.setVisible(true);
                } else {
                    AmountCapacity.setVisible(false);
                    TextAmountCapacity.setVisible(false);
                    BtnContent.setVisible(false);
                }
            }
        }
    }

    // Btn Contenido Almacen
    private void entrarContenido(MouseEvent e) {
        fa.ventanaContenido((Inmobiliario) propiedad);
    }

    private void BoxTipoMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void BoxStringMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    // Comprobar si hay alguna casilla vacía a la hora de añadir/modificar
    private boolean algunaCasillaVacia(){
        // TODO add your code here
        if (Valor.getText().equals("") || AmountCapacity.getText().equals("")){
            return true;
        }
        switch (BoxTipo.getSelectedItem().toString()){
            case "Inmobiliario":
                if (Ubicacion.getText().equals(""))
                    return true;
                break;

            case "Commodities":
                if (TipoCommodity.getText().equals(""))
                    return true;
                break;

            case "arma":
                if (Balas.getText().equals(""))
                    return true;
                break;
        }
        return false;
    }

    // Añadir propiedad / modificar OJO HAY QUE PONER LA LISTA DE ALMACENES Y METER EL USUARIO EN
    private void BtnActualizar_AnadirMouseClicked(MouseEvent e) {
        // TODO add your code here
        if (algunaCasillaVacia()){
            fa.muestraExcepcion("Rellene todos los campos");
            return;
        }
        Integer idPropiedad = fa.obtenerIdPropiedadMayor() + 1;
        switch (BoxTipo.getSelectedItem().toString()){
            case "arma":

                Arma arma = new Arma(idPropiedad, TipoArmamento.stringToTipoArmamento(BoxString.getSelectedItem().toString()),
                        Integer.parseInt(AmountCapacity.getText()), Integer.parseInt(Balas.getText()), Integer.parseInt(Valor.getText()),
                        null, null);
                if (BtnActualizar.getText().equals("Actualizar")){
                    fa.actualizarPropiedad(arma);
                }
                else {
                    fa.anadirPropiedad(arma);
                }
                break;

            case "Inmobiliario":
                Inmobiliario inmobiliario = new Inmobiliario(idPropiedad, Ubicacion.getText(), Integer.parseInt(AmountCapacity.getText()),
                        TipoInmobiliario.stringToTipoInmobiliario(BoxString.getSelectedItem().toString()), Integer.parseInt(Valor.getText()), null, null);

                if (BtnActualizar.getText().equals("Actualizar")){
                    fa.actualizarPropiedad(inmobiliario);
                }
                else {
                    fa.anadirPropiedad(inmobiliario);
                }
                break;

            case "Commodities":
                Commodity commodity = new Commodity(idPropiedad, TipoCommodity.getText(),
                        Integer.parseInt(AmountCapacity.getText()), Integer.parseInt(Valor.getText()), null, null);
                if (BtnActualizar.getText().equals("Actualizar")){
                    fa.actualizarPropiedad(commodity);
                }
                else {
                    fa.anadirPropiedad(commodity);
                }
                break;

            case "Vehículo":
                Vehiculo vehiculo = new Vehiculo(idPropiedad, TipoVehiculo.stringToTipoVehiculo(BoxString.getSelectedItem().toString()),
                        Integer.parseInt(Valor.getText()), Integer.parseInt(AmountCapacity.getText()), null, null);
                if (BtnActualizar.getText().equals("Actualizar")){
                    fa.actualizarPropiedad(vehiculo);
                }
                else {
                    fa.anadirPropiedad(vehiculo);
                }
                break;

            default:
                //Default
        }
        this.dispose();
    }

    // Consulta de los almacenes existentes
    private java.util.List<Inmobiliario> consultaAlmacenes(){
        // TODO add your code here
        return fa.consultaAlmacenes();
    }

    // Inicializa la tabla eventos
    private void buscarEventos(){
        // TODO add your code here
        ModeloTablaEventos mtablaE = (ModeloTablaEventos) tablaEventos.getModel();
        mtablaE.setFilas(propiedad.getEventos());
    }
    private void createUIComponents() {
        // TODO: add custom component creation code here
        // Inicializa tabla propiedades
        tablaEventos = new JTable();
        ModeloTablaEventos mtablaE = new ModeloTablaEventos();
        tablaEventos.setModel(mtablaE);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Diego
        createUIComponents();

        panel1 = new JPanel();
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
        BoxAlmacen = new JComboBox();
        TextUbicacion = new JLabel();
        Ubicacion = new JTextField();
        scrollPane1 = new JScrollPane();
        TextNameType = new JLabel();
        BoxString = new JComboBox();
        TipoCommodity = new JTextField();
        TextTipoCommodity = new JLabel();
        TextBalas = new JLabel();
        Balas = new JTextField();
        BtnContent = new JButton();
        BtnActualizar = new JButton();

        //======== this ========
        setTitle("Detalles");
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
            new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e"
            , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 )
            , java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

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

            //---- TextUbicacion ----
            TextUbicacion.setText("Ubicaci\u00f3n:");

            //======== scrollPane1 ========
            {

                //---- tablaEventos ----
                tablaEventos.setFont(tablaEventos.getFont().deriveFont(tablaEventos.getFont().getStyle() & ~Font.ITALIC));
                scrollPane1.setViewportView(tablaEventos);
            }

            //---- TextNameType ----
            TextNameType.setText("Tipo:");

            //---- BoxString ----
            BoxString.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    BoxStringMouseClicked(e);
                }
            });
            BoxString.addItemListener(e -> BoxStringItemStateChanged(e));

            //---- TextTipoCommodity ----
            TextTipoCommodity.setText("Tipo Commodity:");

            //---- TextBalas ----
            TextBalas.setText("Numero de balas:");

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
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(TextAlmacen)
                                        .addGap(18, 18, 18)
                                        .addComponent(BoxAlmacen, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(TextUbicacion)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Ubicacion, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(TextNameType)
                                            .addComponent(TextTipoCommodity))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(BoxString, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TipoCommodity, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(TextBalas)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Balas, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
                                .addGap(48, 48, 48))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
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
                                        .addComponent(BoxGestor, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(TextEvento, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(AmountCapacity, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
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
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(TextAmountCapacity, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(TextNameType, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BoxString, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AmountCapacity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(TextAlmacen, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TipoCommodity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextTipoCommodity, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextUbicacion, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextBalas)
                                    .addComponent(Balas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Ubicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addComponent(BoxAlmacen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
            );
        }

        //---- BtnContent ----
        BtnContent.setText("Ver contenido");
        BtnContent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                entrarContenido(e);
            }
        });

        //---- BtnActualizar ----
        BtnActualizar.setText("Actualizar");
        BtnActualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BtnActualizar_AnadirMouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(109, 109, 109)
                    .addComponent(BtnContent)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                    .addComponent(BtnActualizar)
                    .addGap(115, 115, 115))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnActualizar)
                        .addComponent(BtnContent))
                    .addContainerGap(41, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Diego
    private JPanel panel1;
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
    private JButton BtnContent;
    private JButton BtnActualizar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
