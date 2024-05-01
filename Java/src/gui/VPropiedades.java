/*
 * Created by JFormDesigner on Tue Apr 30 20:38:27 CEST 2024
 */

package gui;

import java.awt.*;
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
        buscarPropiedades();

        Id.setEditable(false);
        Valor.setEditable(false);
        Tipo.setEditable(false);
        Gestor.setEditable(false);
        Evento.setEditable(false);

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
        abrirVentanaDetalles(0);
    }
    private void entrarNewProp(MouseEvent e) {
        abrirVentanaDetalles(1);
    }

    //ACCIONES
    public java.util.List<Propiedad> obtenerPropiedades(String uno){
        return fa.consultarPropiedades(uno);
    }
    // Actualizar cuadros de texto
    private void actualizarCuadrosTexto() {
        ModeloTablaPropiedades m;
        m=(ModeloTablaPropiedades) tablaPropiedades.getModel();

        Propiedad p = m.getPropiedad(tablaPropiedades.getSelectedRow());

        Id.setText(p.getIdPropiedad().toString());
        Valor.setText(p.getValorActual().toString());
        Tipo.setText(p.getTipoGeneral());
        Gestor.setText(p.getGestor().getNombreCompleto());
        if (p.getEventoActual() != null)
            Evento.setText(p.getEventoActual().getDescripcion());
        else Evento.setText("No hay un evento asociado a esta propiedad.");

    }

    // Buscar propiedades
    private void buscarPropiedades() {
        ModeloTablaPropiedades m;
        m=(ModeloTablaPropiedades) tablaPropiedades.getModel();

        m.setFilas(fa.consultarPropiedades(""));
        if (m.getRowCount() > 0) {
            tablaPropiedades.setRowSelectionInterval(0, 0);
            actualizarCuadrosTexto();
            BtnEraseProp.setEnabled(true);
            BtnMasInfo.setEnabled(true);
        } else {
            BtnEraseProp.setEnabled(false);
            BtnMasInfo.setEnabled(false);
        }
    }

    private void abrirVentanaDetalles(int behavior) {
        // TODO add your code here
        ModeloTablaPropiedades m;
        m=(ModeloTablaPropiedades) tablaPropiedades.getModel();

        Propiedad p = m.getPropiedad(tablaPropiedades.getSelectedRow());
        fa.ventanaDetalles(p, behavior);
    }

    //Funciones para inicializarTablas
    private void inicializartablaProp() {

        tablaPropiedades = new JTable();
        ModeloTablaPropiedades mtablaP = new ModeloTablaPropiedades();
        tablaPropiedades.setModel(mtablaP);

    }

    ///ESTA VENTANA
    private void createUIComponents() {

        inicializartablaProp();

    }

    private void tablaPropiedadesMouseClicked(MouseEvent e) {
        // TODO add your code here
        actualizarCuadrosTexto();
    }

    private void seleccionarPropiedad(MouseEvent e) {
        // TODO add your code here
    }

    private void scrollPane1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void BtnErasePropMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Iago Feijoo Rey
        createUIComponents();

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
        btnNewProp = new JButton();
        BtnEraseProp = new JButton();
        Tipo = new JTextField();
        Gestor = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
            EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing
            . border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,
            java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
            { @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )
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
                        scrollPane1MouseClicked(e);
                    }
                });

                //---- tablaPropiedades ----
                tablaPropiedades.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        tablaPropiedadesMouseClicked(e);
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
                    BtnErasePropMouseClicked(e);
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
                                                    .addComponent(Tipo)
                                                    .addComponent(Gestor)))
                                            .addComponent(Evento, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
                                        .addGap(4, 4, 4))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addComponent(BtnEraseProp)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BtnMasInfo)))
                                .addGap(1, 1, 1)))
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(btnNewProp, GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(TextTipoSearch, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TipoSearch, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscar))
                            .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
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
                        .addGap(37, 37, 37)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(TextId)
                            .addComponent(Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextTipo)
                            .addComponent(Tipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
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
                        .addContainerGap(42, Short.MAX_VALUE))
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
    // Generated using JFormDesigner Evaluation license - Iago Feijoo Rey
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
    private JButton btnNewProp;
    private JButton BtnEraseProp;
    private JTextField Tipo;
    private JTextField Gestor;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
