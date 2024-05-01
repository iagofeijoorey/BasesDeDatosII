/*
 * Created by JFormDesigner on Tue Apr 30 20:38:27 CEST 2024
 */

package gui;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

import aplicacion.PropiedadesYCuentas.Propiedad;

/**
 * @author Diego
 */
public class VPropiedades extends JDialog {

    aplicacion.FachadaAplicacion fa;

    // Constructor
    public VPropiedades(aplicacion.FachadaAplicacion fa) { /** Creates new form VPrincipal */
        this.fa=fa;
        initComponents();
    }

    // BOTONES
    private void buscarTipoMouseClicked(MouseEvent e) {
        buscarPropiedades();
    }
    private void borrarPropiedad(MouseEvent e) {
        fa.borrarPropiedad(Id.getText());
    }
    private void volver(MouseEvent e) {
        this.dispose();
    }
    private void entrarDetalles(MouseEvent e) {
        fa.ventanaDetalles();
    }
    private void entrarNewProp(MouseEvent e) {
        fa.ventanaDetalles();
    }


    //ACCIONES
    private void seleccionarPropiedad(MouseEvent e) {
        // TODO add your code here
        TextId.setText(((ModeloTablaPropiedades)tablaPropiedades.getModel()).obtenerPropiedad(tablaPropiedades.getSelectedRow()).getIdPropiedad().toString());
        TextValor.setText(((ModeloTablaPropiedades)tablaPropiedades.getModel()).obtenerPropiedad(tablaPropiedades.getSelectedRow()).getValorActual().toString());
        TextTipo.setText(((ModeloTablaPropiedades)tablaPropiedades.getModel()).obtenerPropiedad(tablaPropiedades.getSelectedRow()).getTipoGeneral());
        TextEvento.setText(((ModeloTablaPropiedades)tablaPropiedades.getModel()).obtenerPropiedad(tablaPropiedades.getSelectedRow()).getEventoActual().getDescripcion());

    }
    private void buscarPropiedades() {
        ModeloTablaPropiedades m = new ModeloTablaPropiedades();
        m=(ModeloTablaPropiedades) tablaPropiedades.getModel();

        m.setFilas(fa.consultarPropiedades(TipoSearch.getText()));
        if (m.getRowCount() > 0) {
            tablaPropiedades.setRowSelectionInterval(0, 0);
            BtnEraseProp.setEnabled(true);
            BtnMasInfo.setEnabled(true);
        } else {
            BtnEraseProp.setEnabled(false);
            BtnMasInfo.setEnabled(false);
        }
    }
    public java.util.List<Propiedad> obtenerPropiedades(String uno){
        return fa.consultarPropiedades(uno);   // (buscaUbicacion.getText().isEmpty())?null:Integer.parseInt(buscaUbicacion.getText())
    }


    //Funciones para inicializarTablas
    private void inicializartablaProp() {

        ModeloTablaPropiedades mtablaP = new ModeloTablaPropiedades();
        tablaPropiedades.setModel(mtablaP);

    }






    ///ESTA VENTANA
    private void createUIComponents() {

        inicializartablaProp();
        buscarPropiedades();

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
        TextEvento = new JLabel();
        Evento = new JTextField();
        BtnMasInfo = new JButton();
        Gestor = new JComboBox();
        Tipo = new JComboBox();
        btnNewProp = new JButton();
        BtnEraseProp = new JButton();
        tablaPropiedades = new JTable();

        createUIComponents();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
            EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax . swing
            . border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,
            java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
            { @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName () ) )
            throw new RuntimeException( ) ;} } );

            //---- btnVolver ----
            btnVolver.setText("volver");
            btnVolver.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    volver(e);
                }
            });

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
            buscar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buscarTipoMouseClicked(e);
                }
            });

            //======== scrollPane1 ========
            {
                scrollPane1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        seleccionarPropiedad(e);
                    }
                });
                scrollPane1.setViewportView(tablaPropiedades);
            }

            //---- TextEvento ----
            TextEvento.setText("Evento:");

            //---- BtnMasInfo ----
            BtnMasInfo.setText("Detalles");
            BtnMasInfo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    entrarDetalles(e);
                }
            });

            //---- btnNewProp ----
            btnNewProp.setText("Nueva Propiedad");
            btnNewProp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    entrarNewProp(e);
                }
            });

            //---- BtnEraseProp ----
            BtnEraseProp.setText("Borrar");
            BtnEraseProp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    borrarPropiedad(e);
                }
            });

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
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(btnNewProp, GroupLayout.Alignment.TRAILING)
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addComponent(TextTipoSearch, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TipoSearch, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buscar)))
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(38, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnVolver))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(TipoSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buscar)
                                        .addComponent(TextTipoSearch))
                                    .addComponent(ImagenPropiedad, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))))
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
                            .addComponent(BtnEraseProp))
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap(83, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNewProp)
                        .addGap(16, 16, 16))
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
    private JTable tablaPropiedades;
    private JLabel TextEvento;
    private JTextField Evento;
    private JButton BtnMasInfo;
    private JComboBox Gestor;
    private JComboBox Tipo;
    private JButton btnNewProp;
    private JButton BtnEraseProp;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
