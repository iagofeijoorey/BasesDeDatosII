package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.table.*;

import aplicacion.Acolito;
import aplicacion.Evento;
import aplicacion.PropiedadesYCuentas.Propiedad;
import aplicacion.TipoEvento;

public class VEventos extends JDialog {

    aplicacion.FachadaAplicacion fa;

    // Constructor
    public VEventos(aplicacion.FachadaAplicacion fa) { /** Creates new form VPrincipal */
        this.fa=fa;
        initComponents();
        buscarTodosLosEventos();
    }

    //BOTONES
    private void btnVolverMouseClicked(MouseEvent e) {
        this.dispose();
    }
    private void BtnNuevoEventoMouseClicked(MouseEvent e) {
        TextoUbicacion.setText("");
        TextoFecha.setText("");
        //TextoTipo.setText("");
        TextoOrganizador.setText("");
        TextoPanelDescripcion.setText("");
    }

    private void buscarTipoMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void seleccionarPropiedad(MouseEvent e) {
        // TODO add your code here
    }

    private void entrarDetalles(MouseEvent e) {
        // TODO add your code here
    }

    private void entrarNewProp(MouseEvent e) {
        // TODO add your code here
    }

    private void borrarPropiedad(MouseEvent e) {
        // TODO add your code here
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
        TablaEventos = new JTable();
        ModeloTablaEventos_5 mtablaP = new ModeloTablaEventos_5();
        TablaEventos.setModel(mtablaP);
    }

    private void actualizarCuadrosTexto() {
        ModeloTablaEventos_5 m;
        m = (ModeloTablaEventos_5) TablaEventos.getModel();


        Evento evento = m.obtenerEjemplar(TablaEventos.getSelectedRow());

        TextoFecha.setText(evento.getFecha());
        TextoUbicacion.setText(evento.getUbicacion());
        TextoOrganizador.setText(evento.getOrganizador().getAlias());
        TextoTipo.setText(evento.getTipoEvento().toString());
        TextoPanelDescripcion.setText(evento.getDescripcion());

    }

    public void buscarTodosLosEventos(){
        ModeloTablaEventos_5 m;
        m=(ModeloTablaEventos_5) TablaEventos.getModel();

        m.setFilas(fa.consultarEventosSinArgs());
        if (m.getRowCount() > 0) {
            TablaEventos.setRowSelectionInterval(0, 0);
            actualizarCuadrosTexto();

            BtnGuardarEvento.setEnabled(true);
            BtnVerAcolitos.setEnabled(true);
            BtnVerObjetivos.setEnabled(true);
            BtnVerPropiedades.setEnabled(true);
        } else {
            BtnGuardarEvento.setEnabled(false);
            BtnVerAcolitos.setEnabled(false);
            BtnVerObjetivos.setEnabled(false);
            BtnVerPropiedades.setEnabled(false);
        }
    }




    private void volver(MouseEvent e) {
        // TODO add your code here
    }

    private void TablaEventosMouseClicked(MouseEvent e) {
        actualizarCuadrosTexto();
    }

    private void tablaEventosMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void btnBorrarMouseClicked(MouseEvent e) {
        borrarEvento();
    }

    public void borrarEvento(){
        ModeloTablaEventos_5 m;
        m=(ModeloTablaEventos_5) TablaEventos.getModel();
        Evento evento = m.obtenerEjemplar(TablaEventos.getSelectedRow());
        fa.borrarEvento(evento);
        buscarTodosLosEventos();
    }

    private void BtnGuardarEventoMouseClicked(MouseEvent e) {
        ModeloTablaEventos_5 m;
        m=(ModeloTablaEventos_5) TablaEventos.getModel();
        Evento evento = new Evento(TextoUbicacion.getText(),TextoFecha.getText(), TipoEvento.stringToTipoEvento(TextoTipo.getText()), TextoPanelDescripcion.getText(), m.obtenerEjemplar(TablaEventos.getSelectedRow()).getOrganizador());
        fa.anhadirEvento(evento);
        buscarTodosLosEventos();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Iago Feijoo Rey
        createUIComponents();

        panel1 = new JPanel();
        btnVolver = new JButton();
        BtnVerAcolitos = new JButton();
        scrollPane1 = new JScrollPane();
        BtnGuardarEvento = new JButton();
        btnBorrar = new JButton();
        TextoOrganizador = new JTextField();
        TextoFecha = new JTextField();
        BtnVerPropiedades = new JButton();
        BtnVerObjetivos = new JButton();
        BtnNuevoEvento = new JButton();
        scrollPane2 = new JScrollPane();
        TextoPanelDescripcion = new JTextPane();
        TextoUbicacion = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label4 = new JLabel();
        label3 = new JLabel();
        TextoTipo = new JTextField();

        //======== this ========
        setTitle("Eventos");
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
            EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing .border . TitledBorder. CENTER ,javax . swing
            . border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069al\u006fg", java .awt . Font. BOLD ,12 ) ,
            java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
            { @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er" .equals ( e. getPropertyName () ) )
            throw new RuntimeException( ) ;} } );

            //---- btnVolver ----
            btnVolver.setText("volver");
            btnVolver.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    volver(e);
                    btnVolverMouseClicked(e);
                }
            });

            //---- BtnVerAcolitos ----
            BtnVerAcolitos.setText("Ver A\u00f3litos");
            BtnVerAcolitos.addMouseListener(new MouseAdapter() {
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
                        tablaEventosMouseClicked(e);
                    }
                });

                //---- TablaEventos ----
                TablaEventos.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        TablaEventosMouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(TablaEventos);
            }

            //---- BtnGuardarEvento ----
            BtnGuardarEvento.setText("Guardar");
            BtnGuardarEvento.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    entrarNewProp(e);
                    BtnGuardarEventoMouseClicked(e);
                }
            });

            //---- btnBorrar ----
            btnBorrar.setText("Borrar");
            btnBorrar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    borrarPropiedad(e);
                    btnBorrarMouseClicked(e);
                }
            });

            //---- BtnVerPropiedades ----
            BtnVerPropiedades.setText("Ver propiedades");
            BtnVerPropiedades.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buscarTipoMouseClicked(e);
                }
            });

            //---- BtnVerObjetivos ----
            BtnVerObjetivos.setText("Ver objetivos");
            BtnVerObjetivos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buscarTipoMouseClicked(e);
                }
            });

            //---- BtnNuevoEvento ----
            BtnNuevoEvento.setText("Nuevo");
            BtnNuevoEvento.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    entrarNewProp(e);
                    BtnNuevoEventoMouseClicked(e);
                }
            });

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(TextoPanelDescripcion);
            }

            //---- label1 ----
            label1.setText("Ubicaci\u00f3n");

            //---- label2 ----
            label2.setText("Fecha");

            //---- label4 ----
            label4.setText("Organizador");

            //---- label3 ----
            label3.setText("Tipo");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(btnVolver))
                                    .addComponent(label4, GroupLayout.Alignment.TRAILING))
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextoOrganizador, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(label3)
                                        .addGap(18, 18, 18)
                                        .addComponent(TextoTipo, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(label1)
                                        .addComponent(label2))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TextoFecha, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                                        .addComponent(TextoUbicacion, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(BtnVerPropiedades, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(BtnVerAcolitos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(BtnVerObjetivos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(BtnGuardarEvento, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnNuevoEvento, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(btnVolver)
                                        .addGap(24, 24, 24))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label3)
                                            .addComponent(TextoTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextoOrganizador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextoUbicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextoFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnNuevoEvento)
                                    .addComponent(BtnVerObjetivos))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnGuardarEvento)
                                    .addComponent(BtnVerPropiedades)
                                    .addComponent(BtnVerAcolitos)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Iago Feijoo Rey
    private JPanel panel1;
    private JButton btnVolver;
    private JButton BtnVerAcolitos;
    private JScrollPane scrollPane1;
    private JTable TablaEventos;
    private JButton BtnGuardarEvento;
    private JButton btnBorrar;
    private JTextField TextoOrganizador;
    private JTextField TextoFecha;
    private JButton BtnVerPropiedades;
    private JButton BtnVerObjetivos;
    private JButton BtnNuevoEvento;
    private JScrollPane scrollPane2;
    private JTextPane TextoPanelDescripcion;
    private JTextField TextoUbicacion;
    private JLabel label1;
    private JLabel label2;
    private JLabel label4;
    private JLabel label3;
    private JTextField TextoTipo;
    // End of variables declaration//GEN-END:variables


}
