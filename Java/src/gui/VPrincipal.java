/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VPrincipal.java
 *
 * Created on 27-ene-2011, 10:31:24
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.table.*;

/**
 *
 * @author basesdatos
 */
public class VPrincipal extends javax.swing.JFrame {
  
    aplicacion.FachadaAplicacion fa;

    public VPrincipal(aplicacion.FachadaAplicacion fa) { /** Creates new form VPrincipal */
        this.fa=fa;
        initComponents();
    }

    //EVENTOS DE LA BARRA DE OPCIONES
    private void entrarPerfil(MouseEvent e) {
        fa.ventanaPerfil(this);
    }

    private void entrarContactos(MouseEvent e) {
        fa.ventanaContactos();
    }

    private void entrarPropiedades(MouseEvent e) {
        fa.ventanaPropiedades();
    }

    private void entrarEventos(MouseEvent e) {
        fa.ventanaEventos();
    }

    private void entrarRituales(MouseEvent e) {
        fa.ventanaRituales();
    }

    private void entrarAcolitos(MouseEvent e) {
        fa.ventanaAcolitos();
    }


    //BOTONES
    private void btnBuscarMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void btnSalirMouseClicked(MouseEvent e) {
        System.exit(0);
    }




    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Mateo Bodenlle Villarino
    private void initComponents() {
        Desplegable = new JMenu();
        PerfilBotonDesplegable = new JButton();
        ContactosBotonDesplegable = new JButton();
        AcólitosBotonDesplegable = new JButton();
        PropiedadesBotonDesplegable = new JButton();
        EventosBotonDesplegable = new JButton();
        RitualesBotonDesplegable = new JButton();
        scrollListaEventos = new JScrollPane();
        tablaEventos = new JTable();
        presentacion = new JTextPane();
        buscaUbicacion = new JTextField();
        buscaFecha = new JTextField();
        btnBuscar = new JButton();
        txtUbicacion = new JLabel();
        txtFecha = new JLabel();
        ScrollListaRituales = new JScrollPane();
        TablaRituales = new JTable();
        scrollPane2 = new JScrollPane();
        ListaEstadísticas = new JList();
        btnSalir = new JButton();
        Logo = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bienvenido a la Comunidad Imyriano");
        setName("vPrincipal");
        setResizable(false);
        var contentPane = getContentPane();

        //======== Desplegable ========
        {
            Desplegable.setText("Opciones");
            Desplegable.setSelectedIcon(new ImageIcon(getClass().getResource("/gui/flechaI.jpg")));
            Desplegable.setIcon(UIManager.getIcon("FileView.hardDriveIcon"));
            Desplegable.setBackground(new Color(0xffffcc));

            //---- PerfilBotonDesplegable ----
            PerfilBotonDesplegable.setText("Perfil");
            PerfilBotonDesplegable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    entrarPerfil(e);
                }
            });
            Desplegable.add(PerfilBotonDesplegable);

            //---- ContactosBotonDesplegable ----
            ContactosBotonDesplegable.setText("Contactos");
            ContactosBotonDesplegable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    entrarContactos(e);
                }
            });
            Desplegable.add(ContactosBotonDesplegable);

            //---- AcólitosBotonDesplegable ----
            AcólitosBotonDesplegable.setText("Ac\u00f3litos");
            AcólitosBotonDesplegable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    entrarAcolitos(e);
                }
            });
            Desplegable.add(AcólitosBotonDesplegable);

            //---- PropiedadesBotonDesplegable ----
            PropiedadesBotonDesplegable.setText("Propiedades");
            PropiedadesBotonDesplegable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    entrarPropiedades(e);
                }
            });
            Desplegable.add(PropiedadesBotonDesplegable);

            //---- EventosBotonDesplegable ----
            EventosBotonDesplegable.setText("Eventos");
            EventosBotonDesplegable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    entrarEventos(e);
                }
            });
            Desplegable.add(EventosBotonDesplegable);

            //---- RitualesBotonDesplegable ----
            RitualesBotonDesplegable.setText("Rituales");
            RitualesBotonDesplegable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    entrarRituales(e);
                }
            });
            Desplegable.add(RitualesBotonDesplegable);
        }

        //======== scrollListaEventos ========
        {

            //---- tablaEventos ----
            tablaEventos.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    null, null, null, null
                }
            ));
            scrollListaEventos.setViewportView(tablaEventos);
        }

        //---- presentacion ----
        presentacion.setText("La diosa Imyr, una figura misteriosa que emergi\u00f3 de los oc\u00e9anos en tiempos antiguos, es reverenciada por su sabidur\u00eda y su capacidad para dar forma a la tierra y las aguas. Aunque enfrent\u00f3 desaf\u00edos y conflictos, Imyr siempre mostr\u00f3 compasi\u00f3n por aquellos que la adoraban. Su culto gan\u00f3 seguidores devotos en todo el mundo, quienes comparten su creencia en la armon\u00eda, la prosperidad y la justicia. Imyr se convirti\u00f3 en un s\u00edmbolo de esperanza y redenci\u00f3n, inspirando a generaciones futuras a seguir sus ense\u00f1anzas de sabidur\u00eda y valent\u00eda");
        presentacion.setForeground(new Color(0x999999));
        presentacion.setFont(presentacion.getFont().deriveFont(presentacion.getFont().getStyle() | Font.BOLD));

        //---- btnBuscar ----
        btnBuscar.setText("buscar");
        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnBuscarMouseClicked(e);
            }
        });

        //---- txtUbicacion ----
        txtUbicacion.setText("Ubicaci\u00f3n:");

        //---- txtFecha ----
        txtFecha.setText("Fecha:");

        //======== ScrollListaRituales ========
        {
            ScrollListaRituales.setViewportView(TablaRituales);
        }

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(ListaEstadísticas);
        }

        //---- btnSalir ----
        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnSalirMouseClicked(e);
            }
        });

        //---- Logo ----
        Logo.setIcon(new ImageIcon(getClass().getResource("/gui/logoPeque\u00f1o1.jpg")));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(Logo))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(presentacion, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(txtUbicacion)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buscaUbicacion))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(txtFecha)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                    .addComponent(buscaFecha, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addComponent(btnBuscar))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollListaEventos, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane2)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(ScrollListaRituales, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Desplegable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap(16, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                            .addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(btnBuscar))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buscaUbicacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtUbicacion))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(txtFecha)
                                        .addComponent(buscaFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addComponent(scrollListaEventos, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(8, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(Logo, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(presentacion, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(ScrollListaRituales, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Desplegable, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                    .addGap(13, 13, 13)
                                    .addComponent(btnSalir)
                                    .addGap(12, 12, 12)))))
                    .addContainerGap(8, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mateo Bodenlle Villarino
    private JMenu Desplegable;
    private JButton PerfilBotonDesplegable;
    private JButton ContactosBotonDesplegable;
    private JButton AcólitosBotonDesplegable;
    private JButton PropiedadesBotonDesplegable;
    private JButton EventosBotonDesplegable;
    private JButton RitualesBotonDesplegable;
    private JScrollPane scrollListaEventos;
    private JTable tablaEventos;
    private JTextPane presentacion;
    private JTextField buscaUbicacion;
    private JTextField buscaFecha;
    private JButton btnBuscar;
    private JLabel txtUbicacion;
    private JLabel txtFecha;
    private JScrollPane ScrollListaRituales;
    private JTable TablaRituales;
    private JScrollPane scrollPane2;
    private JList ListaEstadísticas;
    private JButton btnSalir;
    private JLabel Logo;
    // End of variables declaration//GEN-END:variables

/*
    public void buscarEventos(){
        ModeloTablaEventos m;

        m=(ModeloTablaEventos) tablaEventos.getModel();
        m.setFilas(fa.obtenerEventos(buscaUbicacion.getText(), buscaFecha.getText()));   // (buscaUbicacion.getText().isEmpty())?null:Integer.parseInt(buscaUbicacion.getText())
        tablaEventos.setRowSelectionInterval(0, 0);
    }
    */

}
