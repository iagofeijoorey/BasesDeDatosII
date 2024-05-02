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
        // Crear un JDialog modal
        JDialog dialog = new JDialog(this, "Confirmación", true);
        dialog.setLayout(new BorderLayout());

        // Agregar un mensaje al diálogo
        JLabel label = new JLabel("¿Estás seguro de que quieres borrar este evento?");
        dialog.add(label, BorderLayout.CENTER);

        // Agregar un botón para confirmar la eliminación
        JButton button = new JButton("Confirmar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar el diálogo cuando se haga clic en el botón
                dialog.dispose();

                // Continuar con la eliminación de la propiedad
                borrarEvento();
            }
        });
        dialog.add(button, BorderLayout.SOUTH);

        // Mostrar el diálogo
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public void borrarEvento(){
        ModeloTablaEventos_5 m;
        m=(ModeloTablaEventos_5) TablaEventos.getModel();
        Evento evento = m.obtenerEjemplar(TablaEventos.getSelectedRow());
        fa.borrarEvento(evento);
        buscarTodosLosEventos();
    }

    private void BtnGuardarEventoMouseClicked(MouseEvent e) {
        /*ModeloTablaEventos_5 m;
        m=(ModeloTablaEventos_5) TablaEventos.getModel();
        Evento evento = new Evento(TextoUbicacion.getText(),TextoFecha.getText(), TipoEvento.stringToTipoEvento(TextoTipo.getText()), TextoPanelDescripcion.getText(), m.obtenerEjemplar(TablaEventos.getSelectedRow()).getOrganizador());
        fa.anhadirEvento(evento);
        buscarTodosLosEventos();*/
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Diego
        createUIComponents();

        panel1 = new JPanel();
        btnVolver = new JButton();
        BtnVerAcolitos = new JButton();
        scrollPane1 = new JScrollPane();
        BtnGuardarEvento = new JButton();
        btnBorrar = new JButton();
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
        Titulo = new JLabel();
        BoxTipo = new JComboBox();
        BoxOrganizador = new JComboBox();

        //======== this ========
        setTitle("Eventos");
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

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
            BtnVerAcolitos.setText("Ver Ac\u00f3litos");
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
            label1.setText("Ubicaci\u00f3n:");

            //---- label2 ----
            label2.setText("Fecha:");

            //---- label4 ----
            label4.setText("Organizador:");

            //---- label3 ----
            label3.setText("Tipo:");

            //---- Titulo ----
            Titulo.setText("EVENTOS");
            Titulo.setFont(new Font("Broadway", Font.PLAIN, 30));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(label1)
                                            .addComponent(label2))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TextoFecha)
                                            .addComponent(TextoUbicacion, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                    .addComponent(btnVolver)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                                    .addComponent(Titulo, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(label3)
                                            .addGap(55, 55, 55))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                            .addComponent(label4)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BoxTipo, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                                        .addComponent(BoxOrganizador, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)))))
                        .addGap(30, 30, 30)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(BtnGuardarEvento, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(BtnNuevoEvento, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(BtnVerPropiedades, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnVerAcolitos, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollPane2, GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnVerObjetivos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnVolver))
                            .addComponent(Titulo, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label3)
                                    .addComponent(BoxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(BoxOrganizador, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextoUbicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextoFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2)))
                            .addComponent(scrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(BtnVerObjetivos, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtnVerAcolitos, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                    .addComponent(BtnVerPropiedades, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(BtnNuevoEvento, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtnGuardarEvento)))))
                        .addGap(185, 185, 185))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(8, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Diego
    private JPanel panel1;
    private JButton btnVolver;
    private JButton BtnVerAcolitos;
    private JScrollPane scrollPane1;
    private JTable TablaEventos;
    private JButton BtnGuardarEvento;
    private JButton btnBorrar;
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
    private JLabel Titulo;
    private JComboBox BoxTipo;
    private JComboBox BoxOrganizador;
    // End of variables declaration//GEN-END:variables


}
