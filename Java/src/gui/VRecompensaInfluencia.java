/*
 * Created by JFormDesigner on Wed May 01 23:34:59 CEST 2024
 */

package gui;

import aplicacion.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author mateo
 */
public class VRecompensaInfluencia extends JDialog {
    FachadaAplicacion fa;
    RecompensaInfluencia recompensa;
    VObjetivos owner;
    public VRecompensaInfluencia(Window owner, FachadaAplicacion fa, Objetivo objetivo) {
        super(owner);
        this.owner = (VObjetivos) owner;
        initComponents();
        this.fa = fa;
        this.recompensa = new RecompensaInfluencia(-1, objetivo.getIdObjetivo(), objetivo.getFecha(),
                objetivo.getUbicacion(), 0);
        textCantidad.setText("0");
    }

    public VRecompensaInfluencia(Window owner, FachadaAplicacion fa, Recompensa recompensa, Objetivo objetivo) {
        super(owner);
        initComponents();
        this.owner = (VObjetivos) owner;
        this.fa = fa;
        this.recompensa = (RecompensaInfluencia) recompensa;
        textCantidad.setText(((RecompensaInfluencia)recompensa).getCantidad().toString());
    }

    private void botonVolver(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void botonConfirmar(ActionEvent e) {
        recompensa.setCantidad(Integer.parseInt(textCantidad.getText()));
        //En principio, no se añaden ht que se confirma el objetivo
        //fa.actualizarRecompensaDinero(recompensa);

        //Si el objetivo ya está cargado
        if(recompensa.getIdObjetivo()!=-1){
            fa.actualizarRecompensaInfluencia((RecompensaInfluencia) recompensa);
            owner.getRecompensas().remove(recompensa);
        }

        owner.addRecompensa(recompensa);
        owner.actualizarRecompensasBox();
        owner.setCont(1);
        this.dispose();
    }

    private void botonBorrar(ActionEvent e) {

        fa.borrarRecompensaInfluencia(recompensa);
        owner.getRecompensas().remove(recompensa);

        owner.actualizarRecompensasBox();
        this.dispose();
    }

    private void botonEliminar(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Mateo Bodenlle Villarino
        botonVOlver = new JButton();
        titulo = new JLabel();
        textCantidad = new JTextField();
        label = new JLabel();
        botonBorrar = new JButton();
        botonConfirmar = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- botonVOlver ----
        botonVOlver.setText("Volver");
        botonVOlver.addActionListener(e -> botonVolver(e));

        //---- titulo ----
        titulo.setText("Recompensa influencia");
        titulo.setFont(titulo.getFont().deriveFont(titulo.getFont().getSize() + 17f));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVerticalAlignment(SwingConstants.TOP);

        //---- label ----
        label.setText("Influencia");
        label.setFont(label.getFont().deriveFont(label.getFont().getSize() + 8f));

        //---- botonBorrar ----
        botonBorrar.setText("Eliminar recompensa");
        botonBorrar.addActionListener(e -> botonEliminar(e));

        //---- botonConfirmar ----
        botonConfirmar.setText("Confirmar");
        botonConfirmar.addActionListener(e -> {
			botonConfirmar(e);
			botonConfirmar(e);
		});

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(botonVOlver, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(titulo, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(botonBorrar)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonConfirmar, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(24, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(botonVOlver)
                        .addComponent(titulo, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label)
                        .addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(botonConfirmar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonBorrar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(37, 37, 37))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Mateo Bodenlle Villarino
    private JButton botonVOlver;
    private JLabel titulo;
    private JTextField textCantidad;
    private JLabel label;
    private JButton botonBorrar;
    private JButton botonConfirmar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
