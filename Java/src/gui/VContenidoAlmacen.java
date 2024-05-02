/*
 * Created by JFormDesigner on Tue Apr 30 23:13:53 CEST 2024
 */

package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Diego
 */
public class VContenidoAlmacen extends JDialog {
    aplicacion.FachadaAplicacion fa;

    public VContenidoAlmacen(aplicacion.FachadaAplicacion fa) { /** Creates new form VPrincipal */
        this.fa=fa;
        initComponents();
    }

    private static String concatenar(Integer numero, String cadena) {
        return numero.toString() + "-" + cadena;
    }


    private void inicializarListas() {
        ModeloListaStrings v;
        v=(ModeloListaStrings) Vehicles.getModel();
        java.util.List<Vehiculo> vehiculos = fa.consultarVehiculos(almacen.getIdPropiedad());
        for (Propiedad vehiculo : vehiculos) {
            v.nuevoElemento(concatenar(vehiculo.getIdPropiedad(), vehiculo.getTipoString()));
        }


        ModeloListaStrings a;
        a=(ModeloListaStrings) Armas.getModel();
        java.util.List<Arma> armas = fa.consultarArmas(almacen.getIdPropiedad());
        for (Propiedad arma : armas) {
            a.nuevoElemento(concatenar(arma.getIdPropiedad(), arma.getTipoString()));
        }

    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
        // Inicializa lista Vehículos
        Vehicles = new JList();
        ModeloListaStrings mlistaV = new ModeloListaStrings();
        Vehicles.setModel(mlistaV);

        // Inicializa lista Armas
        Armas = new JList();
        ModeloListaStrings mlistaA = new ModeloListaStrings();
        Armas.setModel(mlistaA);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Diego
        createUIComponents();

        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        TextVehicle = new JLabel();
        TextWeapon = new JLabel();
        scrollPane2 = new JScrollPane();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(Vehicles);
            }

            //---- TextVehicle ----
            TextVehicle.setText("Veh\u00edculos");

            //---- TextWeapon ----
            TextWeapon.setText("Armas");

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(Armas);
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(TextVehicle)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                                .addComponent(TextWeapon)
                                .addGap(66, 66, 66))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(TextVehicle)
                            .addComponent(TextWeapon, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollPane2))
                        .addGap(26, 26, 26))
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
    private JScrollPane scrollPane1;
    private JList Vehicles;
    private JLabel TextVehicle;
    private JLabel TextWeapon;
    private JScrollPane scrollPane2;
    private JList Armas;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
