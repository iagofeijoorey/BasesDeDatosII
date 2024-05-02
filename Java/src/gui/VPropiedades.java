/*
 * Created by JFormDesigner on Tue Apr 30 20:38:27 CEST 2024
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.BorderLayout;


import aplicacion.PropiedadesYCuentas.Propiedad;

/**
 * @author Diego
 */
public class VPropiedades extends JDialog {

    aplicacion.FachadaAplicacion fa;

    // Confirmación de borrado
    boolean confirmacion;

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

    public void setConfirmacion(boolean c){
        confirmacion = c;
    }

    // BOTONES
    private void buscarTipoMouseClicked(MouseEvent e) {
        buscarPropiedades();
    }
    private void borrarPropiedad(MouseEvent e) {

        // Crear un JDialog modal
        JDialog dialog = new JDialog(this, "Confirmación", true);
        dialog.setLayout(new BorderLayout());

        // Agregar un mensaje al diálogo
        JLabel label = new JLabel("¿Estás seguro de que quieres borrar esta propiedad?");
        dialog.add(label, BorderLayout.CENTER);

        // Agregar un botón para confirmar la eliminación
        JButton button = new JButton("Confirmar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar el diálogo cuando se haga clic en el botón
                dialog.dispose();

                // Continuar con la eliminación de la propiedad
                System.out.println("Borrando propiedad...");
                fa.borrarPropiedad(Integer.parseInt(Id.getText()));
                buscarPropiedades();
            }
        });
        dialog.add(button, BorderLayout.SOUTH);

        // Mostrar el diálogo
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

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
        if (p.getEventoProximo() != null)
            Evento.setText(p.getEventoProximo().getDescripcion());
        else Evento.setText("No hay un evento asociado a esta propiedad.");

    }

    // Buscar propiedades
    private void buscarPropiedades() {
        ModeloTablaPropiedades m;
        m=(ModeloTablaPropiedades) tablaPropiedades.getModel();

        java.util.List<Propiedad> propiedades = obtenerPropiedades(TipoSearch.getText());
        m.setFilas(propiedades);
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

    ///ESTA VENTANA
    private void createUIComponents() {

        // Inicializa tabla propiedades
        tablaPropiedades = new JTable();
        ModeloTablaPropiedades mtablaP = new ModeloTablaPropiedades();
        tablaPropiedades.setModel(mtablaP);

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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Diego
        createUIComponents();

        panel1 = new JPanel();
        btnVolver = new JButton();
        TextId = new JLabel();
        Id = new JTextField();
        Valor = new JTextField();
        TextValor = new JLabel();
        TextTipo = new JLabel();
        TextGestor = new JLabel();
        TextTipoSearch = new JLabel();
        TipoSearch = new JTextField();
        buscar = new JButton();
        TextEvento = new JLabel();
        Evento = new JTextField();
        BtnMasInfo = new JButton();
        BtnEraseProp = new JButton();
        Tipo = new JTextField();
        Gestor = new JTextField();
        scrollPane1 = new JScrollPane();
        btnNewProp = new JButton();
        label1 = new JLabel();

        //======== this ========
        setTitle("Propiedades");
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
            border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER
            , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font
            .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order"
            .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

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

            //---- BtnEraseProp ----
            BtnEraseProp.setText("Borrar");
            BtnEraseProp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    borrarPropiedad(e);
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

            //---- btnNewProp ----
            btnNewProp.setText("Nueva Propiedad");
            btnNewProp.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    entrarNewProp(e);
                }
            });

            //---- label1 ----
            label1.setText("PROPIEDADES");
            label1.setFont(new Font("Broadway", Font.PLAIN, 30));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(btnVolver)
                                .addGap(156, 156, 156)
                                .addComponent(label1))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(TextValor)
                                            .addComponent(TextId))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(Valor, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Id, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(TextTipo)
                                            .addComponent(TextGestor))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Tipo)
                                            .addComponent(Gestor, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(TextTipoSearch, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TextEvento, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                                .addComponent(TipoSearch)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buscar))
                                            .addComponent(Evento, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE))))
                                .addGap(29, 29, 29)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(btnNewProp)
                                    .addComponent(BtnMasInfo)
                                    .addComponent(BtnEraseProp))))
                        .addContainerGap(42, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(btnVolver)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextId)
                            .addComponent(TextTipo))
                        .addGap(6, 6, 6)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Valor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Gestor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnMasInfo)
                            .addComponent(TextValor)
                            .addComponent(TextGestor))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Evento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextEvento))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNewProp)
                            .addComponent(buscar)
                            .addComponent(TipoSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextTipoSearch))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnEraseProp))
                        .addGap(24, 24, 24))
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
    private JLabel TextId;
    private JTextField Id;
    private JTextField Valor;
    private JLabel TextValor;
    private JLabel TextTipo;
    private JLabel TextGestor;
    private JLabel TextTipoSearch;
    private JTextField TipoSearch;
    private JButton buscar;
    private JLabel TextEvento;
    private JTextField Evento;
    private JButton BtnMasInfo;
    private JButton BtnEraseProp;
    private JTextField Tipo;
    private JTextField Gestor;
    private JScrollPane scrollPane1;
    private JTable tablaPropiedades;
    private JButton btnNewProp;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
