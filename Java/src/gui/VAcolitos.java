/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VLibro.java
 *
 * Created on 16-feb-2011, 18:17:07
 */

package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.Acolito;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import java.util.ArrayList;


/**
 *
 * @author basesdatos
 */


public class VAcolitos extends JDialog {
    VPrincipal padre;
    FachadaAplicacion fa;
    aplicacion.Acolito acolito;

    public VAcolitos(Window owner, FachadaAplicacion fa) {
        super(owner);
        initComponents();
        this.fa = fa;
    }

    private void inicializarTablaContactos() {

        ArrayList<String> aliasAcolitos = fa.obtenerAliasAcolitos();
        ModeloListaAcolitos mListaA = new ModeloListaAcolitos();

        listaAcolitos.setModel(mListaA);
        mListaA.setElementos(aliasAcolitos);
        if (mListaA.getSize()>0) {
            listaAcolitos.setSelectedIndex(0);
            acolito = fa.obtenerAcolito(mListaA.getElementAt(0));
            bntEliminar.setEnabled(true);
        } else bntEliminar.setEnabled(false);

    }

    /* bntVolver: Al presionar el botón, se va de vuelta a la ventana principal de la aplicación */
    private void btnVolver(ActionEvent e) {
        // TODO add your code here
        padre.buscarEventos();
        this.dispose();
    }

    /* btnGuardar: Al presionar el botón, se guarda la edición de un acólito en la base de datos, concretamente
     * con la información que aparece reflejada en los cuadros de texto */
    private void btnGuardar(ActionEvent e) {
        // TODO add your code here
        Acolito a;

        if(!txtAlias.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtDireccion.getText().isEmpty() &&
                !txtInfluencia.getText().isEmpty() && !txtJefe.getText().isEmpty() && !txtTelefono.getText().isEmpty() &&
                !txtContraseña.getText().isEmpty()) {
            a = new Acolito(txtAlias.getText(), txtContraseña.getText(), );
        }





    }

    private void inicializarTextoEtiquetas() {

        //---- txtAlias ----
        txtAlias.setText("Alias...");

        //---- txtInfluencia ----
        txtInfluencia.setText("Influencia...");

        //---- txtNombre ----
        txtNombre.setText("Nombre completo...");

        //---- txtTelefono ----
        txtTelefono.setText("Tel\u00e9fono...");

        //---- txtNombreDivision ----
        txtNombreDivision.setText("Nombre divisi\u00f3n...");

        //---- txtJefe ----
        txtJefe.setText("Jefe a cargo...");

        //---- imagenAcolito ----
        imagenAcolito.setText("(Imagen del ac\u00f3lito)");

        //---- txtDireccion ----
        txtDireccion.setText("Direcci\u00f3n...");

        //---- txtAltaDivision ----
        txtAltaDivision.setText("Alta divisi\u00f3n...");

        //---- labelAcolitos ----
        labelAcolitos.setText("LISTA DE AC\u00d3LITOS");
        labelAcolitos.setFont(new Font("Inter", Font.BOLD, 14));

        //======== scrollDescripcion ========
        {

            //---- txtDescripcion ----
            txtDescripcion.setText("Descripci\u00f3n...");
            txtDescripcion.setFont(new Font("Inter", Font.PLAIN, 13));
            scrollDescripcion.setViewportView(txtDescripcion);
        }

        //---- btnGuardar ----
        btnGuardar.setText("Guardar edici\u00f3n");
        btnGuardar.addActionListener(e -> btnGuardar(e));

        //======== scrollEventos ========
        {
            scrollEventos.setViewportView(tablaEventos);
        }

        //---- btnAnadir ----
        btnAnadir.setText("A\u00d1ADIR AC\u00d3LITO");
        btnAnadir.setBackground(new Color(0x00cc66));

        //---- bntEliminar ----
        bntEliminar.setText("ELIMINAR");
        bntEliminar.setBackground(new Color(0x990000));
        bntEliminar.addActionListener(e -> bntEliminar(e));

        //---- btnVolver ----
        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(e -> btnVolver(e));

        //======== scrollAcolitos ========
        {
            scrollAcolitos.setViewportView(listaAcolitos);
        }

        //---- btnBuscar ----
        btnBuscar.setText("BUSCAR");

        //---- txtBuscarPorAlias ----
        txtBuscarPorAlias.setText("Buscar por alias...");
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
        inicializarTablaContactos();
    }

    /* btnEliminar: Al presionar el botón, se elimina al acólito de la base de datos. */
    private void bntEliminar(ActionEvent e) {
        // TODO add your code here

    }

    /* btnAnadir: Al presionar el botón, se añade a un nuevo acólito de la base de datos. Para ello,
    *  se ponen todos los botones con el texto predeterminado y se hace el alias, igual que los demás, editable */
    private void btnAnadir(ActionEvent e) {
        // TODO add your code here
        inicializarTextoEtiquetas();
    }

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Sara Castro
        createUIComponents();

        txtAlias = new JTextField();
        txtInfluencia = new JTextField();
        txtNombre = new JTextField();
        txtTelefono = new JTextField();
        txtNombreDivision = new JTextField();
        txtJefe = new JTextField();
        imagenAcolito = new JLabel();
        txtDireccion = new JTextField();
        txtAltaDivision = new JTextField();
        labelAcolitos = new JLabel();
        scrollDescripcion = new JScrollPane();
        txtDescripcion = new JTextArea();
        btnGuardar = new JButton();
        scrollEventos = new JScrollPane();
        tablaEventos = new JTable();
        btnAnadir = new JButton();
        bntEliminar = new JButton();
        btnVolver = new JButton();
        scrollAcolitos = new JScrollPane();
        listaAcolitos = new JList();
        txtBuscarPorAlias = new JTextField();
        txtContraseña = new JTextField();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ac\u00f3litos");
        setResizable(false);
        var contentPane = getContentPane();

        //---- txtAlias ----
        txtAlias.setText("Alias...");
        txtAlias.setEditable(false);

        //---- txtInfluencia ----
        txtInfluencia.setText("Influencia...");

        //---- txtNombre ----
        txtNombre.setText("Nombre completo...");

        //---- txtTelefono ----
        txtTelefono.setText("Tel\u00e9fono...");

        //---- txtNombreDivision ----
        txtNombreDivision.setText("Nombre divisi\u00f3n...");

        //---- txtJefe ----
        txtJefe.setText("Jefe a cargo...");

        //---- imagenAcolito ----
        imagenAcolito.setText("(Imagen del ac\u00f3lito)");

        //---- txtDireccion ----
        txtDireccion.setText("Direcci\u00f3n...");

        //---- txtAltaDivision ----
        txtAltaDivision.setText("Alta divisi\u00f3n...");
        txtAltaDivision.setEditable(false);

        //---- labelAcolitos ----
        labelAcolitos.setText("LISTA DE AC\u00d3LITOS");
        labelAcolitos.setFont(new Font("Inter", Font.BOLD, 14));

        //======== scrollDescripcion ========
        {

            //---- txtDescripcion ----
            txtDescripcion.setText("Descripci\u00f3n...");
            txtDescripcion.setFont(new Font("Inter", Font.PLAIN, 13));
            scrollDescripcion.setViewportView(txtDescripcion);
        }

        //---- btnGuardar ----
        btnGuardar.setText("Guardar edici\u00f3n");
        btnGuardar.addActionListener(e -> btnGuardar(e));

        //======== scrollEventos ========
        {
            scrollEventos.setViewportView(tablaEventos);
        }

        //---- btnAnadir ----
        btnAnadir.setText("A\u00d1ADIR AC\u00d3LITO");
        btnAnadir.setBackground(new Color(0x00cc66));
        btnAnadir.addActionListener(e -> btnAnadir(e));

        //---- bntEliminar ----
        bntEliminar.setText("ELIMINAR");
        bntEliminar.setBackground(new Color(0x990000));
        bntEliminar.addActionListener(e -> bntEliminar(e));

        //---- btnVolver ----
        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(e -> btnVolver(e));

        //======== scrollAcolitos ========
        {
            scrollAcolitos.setViewportView(listaAcolitos);
        }

        //---- btnBuscar ----
        btnBuscar.setText("BUSCAR");

        //---- txtBuscarPorAlias ----
        txtBuscarPorAlias.setText("Buscar por alias...");

        //---- txtContraseña ----
        txtContraseña.setText("Contrase\u00f1a...");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(0, 530, Short.MAX_VALUE)
                                    .addComponent(btnAnadir, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(txtInfluencia, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                                .addComponent(txtAlias))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(txtNombre)
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                    .addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtContraseña, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtNombreDivision, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                                        .addComponent(txtDireccion, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtAltaDivision, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                                        .addComponent(txtJefe, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)))
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                                        .addComponent(bntEliminar, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnGuardar))
                                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                                        .addComponent(scrollDescripcion, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(scrollEventos, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                                            .addComponent(imagenAcolito, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                            .addGap(51, 51, 51)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtBuscarPorAlias))))
                                    .addGap(25, 25, 25)
                                    .addComponent(scrollAcolitos, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
                            .addGap(16, 16, 16))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(btnVolver)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 395, Short.MAX_VALUE)
                            .addComponent(labelAcolitos)
                            .addGap(58, 58, 58))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(labelAcolitos)
                    .addGap(18, 18, 18)
                    .addComponent(scrollAcolitos)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnAnadir, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(btnVolver)
                    .addGap(40, 40, 40)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(txtBuscarPorAlias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                        .addComponent(imagenAcolito, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAlias, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtInfluencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombreDivision, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtJefe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAltaDivision, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollDescripcion, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollEventos, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(bntEliminar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(14, 14, 14))))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Sara Castro
    private JTextField txtAlias;
    private JTextField txtInfluencia;
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JTextField txtNombreDivision;
    private JTextField txtJefe;
    private JLabel imagenAcolito;
    private JTextField txtDireccion;
    private JTextField txtAltaDivision;
    private JLabel labelAcolitos;
    private JScrollPane scrollDescripcion;
    private JTextArea txtDescripcion;
    private JButton btnGuardar;
    private JScrollPane scrollEventos;
    private JTable tablaEventos;
    private JButton btnAnadir;
    private JButton bntEliminar;
    private JButton btnVolver;
    private JScrollPane scrollAcolitos;
    private JList listaAcolitos;
    private JButton btnBuscar;
    private JTextField txtBuscarPorAlias;
    private JTextField txtContraseña;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
