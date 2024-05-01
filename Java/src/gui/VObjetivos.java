/*
 * Created by JFormDesigner on Wed May 01 17:36:04 CEST 2024
 */

package gui;

import java.beans.*;

import aplicacion.*;
import baseDatos.FachadaBaseDatos;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author mateo
 */
public class VObjetivos extends JDialog {
    private Evento evento;
    private FachadaAplicacion fa;
    private ArrayList<Recompensa> recompensas;
    public VObjetivos(aplicacion.FachadaAplicacion fa, Window owner, Evento evento) {
        super(owner);
        initComponents();
        this.fa = fa;
        this.evento = evento;
        tablaObjetivos.setModel(new ModeloTablaObjetivos());
        ModeloTablaObjetivos m = (ModeloTablaObjetivos) tablaObjetivos.getModel();

        m.setFilas(fa.consultarObjetivosEvento(evento));

        for (int i = 0; i < m.getRowCount(); i++) {
            comboBoxRecompensas.addItem(((ModeloTablaObjetivos)tablaObjetivos.getModel()).getFilas().get(tablaObjetivos.getSelectedRow()).getRecompensa().get(i).toString());
        }

    }

    public ArrayList<Recompensa> getRecompensas() {
        return recompensas;
    }

    public void setRecompensas(ArrayList<Recompensa> recompensas) {
        this.recompensas = recompensas;
    }

    public void addRecompensa(Recompensa recompensa){
        recompensas.add(recompensa);
    }

    private void botonVolver(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void cambioSeleccionTablaObjetivos(PropertyChangeEvent e) {
        textEvento.setText(tablaObjetivos.getValueAt(tablaObjetivos.getSelectedRow(), 0).toString());
        textJefe.setText(evento.getOrganizador().getAlias());
        textDescripcionObjetivo.setText(((ModeloTablaObjetivos)tablaObjetivos.getModel()).getFilas().get( tablaObjetivos.getSelectedRow()).getDescripcion());

        button5.setText("Vaciar campos");
    }

    private void comboBoxPrioridadItemStateChanged(ItemEvent e) {
        // TODO add your code here

        Objetivo objetivoSeleccionado = ((ModeloTablaObjetivos)tablaObjetivos.getModel()).getFilas().get(tablaObjetivos.getSelectedRow());
        objetivoSeleccionado.setPrioridad(Integer.parseInt(comboBoxPrioridad.getSelectedItem().toString()));
        fa.actualizarObjetivo(objetivoSeleccionado);
    }

    private void botonCambiarRecompensa(ActionEvent e) {
        // TODO add your code here
        Recompensa recompensa = (Recompensa) comboBoxRecompensas.getSelectedItem();

        editarRecompensa(recompensa);
    }

    private void editarRecompensa(Recompensa recompensa){
        if (recompensa instanceof RecompensaDinero){
            VRecompensaDinero vRecompensaDinero = new VRecompensaDinero(this, fa, (RecompensaDinero) recompensa,
                     ((ModeloTablaObjetivos)tablaObjetivos.getModel()).getFilas().get(tablaObjetivos.getSelectedRow()));
            vRecompensaDinero.setVisible(true);
        } else if (recompensa instanceof RecompensaInfluencia){
            VRecompensaInfluencia vRecompensaInfluencia = new VRecompensaInfluencia(this, fa, (RecompensaInfluencia) recompensa,
                    ((ModeloTablaObjetivos)tablaObjetivos.getModel()).getFilas().get(tablaObjetivos.getSelectedRow()));
            vRecompensaInfluencia.setVisible(true);
        } else
            JOptionPane.showMessageDialog(this, "No se puede editar esta recompensa");
        }

        private void botonActualizar(ActionEvent e) {
            // TODO add your code here
            ModeloTablaObjetivos m = (ModeloTablaObjetivos) tablaObjetivos.getModel();
            m.setFilas(fa.consultarObjetivosEvento(evento));
        }

        private void buttonEliminar(ActionEvent e) {
            // TODO add your code here
            ModeloTablaObjetivos m = (ModeloTablaObjetivos) tablaObjetivos.getModel();
            Objetivo objetivoSeleccionado = m.getFilas().get(tablaObjetivos.getSelectedRow());
            fa.borrarObjetivo(objetivoSeleccionado);

            m.setFilas(fa.consultarObjetivosEvento(evento));
        }

        private void botonVaciarONuevo(ActionEvent e) {
            // TODO add your code here
            if (button5.getText().equals("Nuevo objetivo")){
                Objetivo objetivo = new Objetivo(-1, evento.getUbicacion(), evento.getFecha(),
                        textDescripcionObjetivo.getText(), Integer.parseInt(comboBoxPrioridad.getSelectedItem().toString()),  recompensas);
                fa.actualizarObjetivo(objetivo);
                ModeloTablaObjetivos m = (ModeloTablaObjetivos) tablaObjetivos.getModel();
            } else {
                textEvento.setText("");
                textJefe.setText("");
                textDescripcionObjetivo.setText("");
                comboBoxRecompensas.setSelectedIndex(0);
                comboBoxPrioridad.setSelectedIndex(0);
                Integer a = tablaObjetivos.getSelectedRow();
                a = -1;
            }

        }

        private void comboBoxNuevaItemStateChanged(ItemEvent e) {
            String selec = comboBoxRecompensas.getSelectedItem().toString();
            if (selec.equals("Nueva recompensa dinero")){
                VRecompensaDinero vRecompensaDinero = new VRecompensaDinero(this, fa,
                        new RecompensaDinero(-1, ((ModeloTablaObjetivos)tablaObjetivos.getModel()).getFilas().get(tablaObjetivos.getSelectedRow()).getIdObjetivo(),
                                ((ModeloTablaObjetivos)tablaObjetivos.getModel()).getFilas().get(tablaObjetivos.getSelectedRow()).getFecha(),
                                ((ModeloTablaObjetivos)tablaObjetivos.getModel()).getFilas().get(tablaObjetivos.getSelectedRow()).getUbicacion(), 0),
                        ((ModeloTablaObjetivos)tablaObjetivos.getModel()).getFilas().get(tablaObjetivos.getSelectedRow()));
                vRecompensaDinero.setVisible(true);
            } else if (selec.equals("Nueva recompensa influencia")){
                VRecompensaInfluencia vRecompensaInfluencia = new VRecompensaInfluencia(this, fa,
                        new RecompensaInfluencia(-1, ((ModeloTablaObjetivos)tablaObjetivos.getModel()).getFilas().get(tablaObjetivos.getSelectedRow()).getIdObjetivo(),
                                ((ModeloTablaObjetivos)tablaObjetivos.getModel()).getFilas().get(tablaObjetivos.getSelectedRow()).getFecha(),
                                ((ModeloTablaObjetivos)tablaObjetivos.getModel()).getFilas().get(tablaObjetivos.getSelectedRow()).getUbicacion(), 0),
                        ((ModeloTablaObjetivos)tablaObjetivos.getModel()).getFilas().get(tablaObjetivos.getSelectedRow()));
                vRecompensaInfluencia.setVisible(true);
        }

            }






    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Mateo Bodenlle Villarino
        Titulo = new JLabel();
        button1 = new JButton();
        textEvento = new JTextField();
        textE = new JLabel();
        textJefe = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        textDescripcionObjetivo = new JTextPane();
        label4 = new JLabel();
        comboBoxRecompensas = new JComboBox();
        button2 = new JButton();
        label5 = new JLabel();
        comboBoxPrioridad = new JComboBox<>();
        scrollPane2 = new JScrollPane();
        tablaObjetivos = new JTable();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        comboBoxNueva = new JComboBox<>();

        //======== this ========
        var contentPane = getContentPane();

        //---- Titulo ----
        Titulo.setText("OBJETIVOS");
        Titulo.setHorizontalAlignment(SwingConstants.CENTER);
        Titulo.setFont(new Font("Broadway", Titulo.getFont().getStyle(), Titulo.getFont().getSize() + 20));

        //---- button1 ----
        button1.setText("Volver");
        button1.addActionListener(e -> botonVolver(e));

        //---- textE ----
        textE.setText("Evento");

        //---- label2 ----
        label2.setText("Jefe a cargo");

        //---- label3 ----
        label3.setText("Objetivo");

        //======== scrollPane1 ========
        {
            scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            //---- textDescripcionObjetivo ----
            textDescripcionObjetivo.setText(" Lorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem Ipsum Lorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem Ipsum  Lorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem Ipsum Lorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem Ipsum  Lorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem Ipsum Lorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem Ipsum  Lorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem Ipsum Lorem IpsumLorem IpsumLorem IpsumLorem IpsumLorem Ipsum ");
            scrollPane1.setViewportView(textDescripcionObjetivo);
        }

        //---- label4 ----
        label4.setText("Recompensa");

        //---- button2 ----
        button2.setText("Cambiar");
        button2.addActionListener(e -> botonCambiarRecompensa(e));

        //---- label5 ----
        label5.setText("Prioridad");

        //---- comboBoxPrioridad ----
        comboBoxPrioridad.setModel(new DefaultComboBoxModel<>(new String[] {
            "0",
            "1",
            "2",
            "3",
            "4",
            "5"
        }));
        comboBoxPrioridad.addItemListener(e -> comboBoxPrioridadItemStateChanged(e));

        //======== scrollPane2 ========
        {

            //---- tablaObjetivos ----
            tablaObjetivos.addPropertyChangeListener("selectedRow", e -> cambioSeleccionTablaObjetivos(e));
            scrollPane2.setViewportView(tablaObjetivos);
        }

        //---- button4 ----
        button4.setText("Eliminar objetivo");
        button4.addActionListener(e -> buttonEliminar(e));

        //---- button5 ----
        button5.setText("Vaciar campos");
        button5.addActionListener(e -> botonVaciarONuevo(e));

        //---- button6 ----
        button6.setText("Actualizar");
        button6.addActionListener(e -> botonActualizar(e));

        //---- comboBoxNueva ----
        comboBoxNueva.setModel(new DefaultComboBoxModel<>(new String[] {
            "Nueva recompensa",
            "Nueva recompensa dinero",
            "Nueva recompensa infuencia",
            "Not contacto"
        }));
        comboBoxNueva.addItemListener(e -> comboBoxNuevaItemStateChanged(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                            .addGap(72, 72, 72)
                            .addComponent(Titulo, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(label4)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label5)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(comboBoxPrioridad, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(comboBoxRecompensas, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(comboBoxNueva, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(textE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textEvento, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(button4)
                                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
                                    .addGap(262, 262, 262)
                                    .addComponent(button6, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(106, 106, 106)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textJefe, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(59, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(Titulo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textEvento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(textJefe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxRecompensas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2)
                        .addComponent(comboBoxNueva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxPrioridad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button4)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(14, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Mateo Bodenlle Villarino
    private JLabel Titulo;
    private JButton button1;
    private JTextField textEvento;
    private JLabel textE;
    private JTextField textJefe;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTextPane textDescripcionObjetivo;
    private JLabel label4;
    private JComboBox comboBoxRecompensas;
    private JButton button2;
    private JLabel label5;
    private JComboBox<String> comboBoxPrioridad;
    private JScrollPane scrollPane2;
    private JTable tablaObjetivos;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JComboBox<String> comboBoxNueva;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}