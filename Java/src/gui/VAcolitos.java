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
import aplicacion.TipoAcolito;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import java.util.ArrayList;
import java.text.SimpleDateFormat;


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
        this.fa = fa;
        initComponents();
    }

    private void inicializarListaAcolitos() {
        listaAcolitos = new JList<>();
        ArrayList<String> aliasAcolitos = fa.obtenerAliasAcolitos();
        ModeloListaAcolitos mListaA = new ModeloListaAcolitos();

        listaAcolitos.setModel(mListaA);
        mListaA.setElementos(aliasAcolitos);
        if (mListaA.getSize() > 0) {

            listaAcolitos.setSelectedIndex(0);
            Acolito a = fa.obtenerAcolito(mListaA.getElementAt(0));

            // Convertir la fecha de ingreso a un formato de texto adecuado
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaIngresoTexto = sdf.format(a.getFechaingreso());

            // Poner el texto correcto en los campos de texto
            txtAlias.setText(a.getAlias());
            txtNombre.setText(a.getNombreCompleto());
            txtAltaComunidad.setText(fechaIngresoTexto);
            txtContraseña.setText(a.getContraseña());
            txtTelefono.setText(Integer.toString(a.getTelefono()));
            txtInfluencia.setText(Integer.toString(a.getInfluencia()));
            txtDireccion.setText(a.getDireccion());
            txtJefe.setText(a.getJefeDivision());
            txtNombreDivision.setText(a.getNombreDivision());

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

        ModeloListaAcolitos mListaA = new ModeloListaAcolitos();
        listaAcolitos.setModel(mListaA);

        if(!txtAlias.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtDireccion.getText().isEmpty() &&
                !txtInfluencia.getText().isEmpty() && !txtJefe.getText().isEmpty() && !txtTelefono.getText().isEmpty() &&
                !txtContraseña.getText().isEmpty()) {

            a = new Acolito(txtAlias.getText(), txtContraseña.getText(), txtNombre.getText(), Integer.parseInt(txtTelefono.getText()), txtDireccion.getText(),
                    Integer.parseInt(txtInfluencia.getText()), TipoAcolito.stringToTipoAcolito(cbTipoAcolito.getSelectedItem().toString()), txtJefe.getText(),
                    txtNombreDivision.getText());

            if(txtAlias.isEditable()) {
                fa.nuevoAcolito(a);
                mListaA.nuevoElemento(a.getAlias());
            }
            else fa.actualizarAcolito(a);
        }
    }

    /* inicializarTextoEtiquetas: Establece el texto predeterminado de cada etiqueta de texto, para orientar al usuario
       a la hora de rellenar los datos */
    private void inicializarTextoEtiquetas() {

        //---- txtAlias ----
        txtAlias.setText("Alias...");
        txtAlias.setEditable(true);

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

        //---- txtDireccion ----
        txtDireccion.setText("Direcci\u00f3n...");

        //---- txtAltaComunidad ----
        txtAltaComunidad.setText("Alta Comunidad...");

        //---- txtBuscarPorAlias ----
        txtBuscarPorAlias.setText("Buscar por alias...");

        cbTipoAcolito.setSelectedIndex(3);
    }

    /* btnEliminar: Al presionar el botón, se elimina al acólito de la base de datos. */
    private void bntEliminar(ActionEvent e) {
        // TODO add your code here
        fa.eliminarAcolito(txtAlias.getText());
    }

    /* btnAnadir: Al presionar el botón, se añade a un nuevo acólito de la base de datos. Para ello,
    *  se ponen todos los botones con el texto predeterminado y se hace el alias, igual que los demás, editable */
    private void btnAnadir(ActionEvent e) {
        // TODO add your code here
        inicializarTextoEtiquetas();
    }

    /* Inicializa las tablas/listas que hay en la ventana */
    private void createUIComponents() {
        // TODO: add custom component creation code here
        inicializarListaAcolitos();
        inicializarTablaEventos();
    }

    private void inicializarTablaEventos() {
        tablaEventos = new JTable();
        ModeloTablaEventos mte = new ModeloTablaEventos();
        tablaEventos.setModel(mte);
        if (listaAcolitos.getModel().getSize() > 0) {
            mte.setFilas(fa.consultarEventos((String) listaAcolitos.getModel().getElementAt(0)));
        }
    }

    /* listaAcolitosMouseClicked: Al seleccionar con el mouse un alias, se cargará en los cuadros de texto toda
     * la información del acólito */
    private void listaAcolitosMouseClicked(MouseEvent e) {
        // TODO add your code here
        Acolito a = fa.obtenerAcolito((String) listaAcolitos.getSelectedValue());

        // Convertir la fecha de ingreso a un formato de texto adecuado
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaIngresoTexto = sdf.format(a.getFechaingreso());

        // Poner el texto correcto en los campos de texto
        txtAlias.setText(a.getAlias());
        txtNombre.setText(a.getNombreCompleto());
        txtAltaComunidad.setText(fechaIngresoTexto);
        txtContraseña.setText(a.getContraseña());
        txtTelefono.setText(Integer.toString(a.getTelefono()));
        txtInfluencia.setText(Integer.toString(a.getInfluencia()));
        txtDireccion.setText(a.getDireccion());
        txtJefe.setText(a.getJefeDivision());
        txtNombreDivision.setText(a.getNombreDivision());

        // Establecer la tabla de eventos del usuario
        ModeloTablaEventos mte;
        mte = (ModeloTablaEventos) tablaEventos.getModel();
        mte.setFilas(fa.consultarEventos((String) listaAcolitos.getSelectedValue()));

    }

    private void btnBuscar(ActionEvent e) {
        // Obtener el nombre buscado del campo de texto de búsqueda
        String nombreBuscado = txtBuscarPorAlias.getText();

        // Obtener el modelo de la lista de acólitos
        ModeloListaAcolitos modeloLista = (ModeloListaAcolitos) listaAcolitos.getModel();

        // Limpiar la selección actual de la lista
        listaAcolitos.clearSelection();

        // Lista para almacenar los acólitos filtrados
        ArrayList<String> acolitosFiltrados = new ArrayList<>();

        // Recorrer los elementos de la lista y mostrar solo los que contienen el texto buscado en el alias
        for (int i = 0; i < modeloLista.getSize(); i++) {
            String alias = modeloLista.getElementAt(i);
            if (alias.contains(nombreBuscado)) {
                listaAcolitos.addSelectionInterval(i, i); // Seleccionar el elemento
                acolitosFiltrados.add(alias); // Agregar el alias filtrado a la lista
            }
        }

        // Si hay acólitos filtrados, seleccionar el primero de ellos
        if (!acolitosFiltrados.isEmpty()) {
            listaAcolitos.setSelectedIndex(0);
        }
    }


    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Sara Castro

        txtAlias = new JTextField();
        txtInfluencia = new JTextField();
        txtNombre = new JTextField();
        txtTelefono = new JTextField();
        txtNombreDivision = new JTextField();
        txtJefe = new JTextField();
        imagenAcolito = new JLabel();
        txtDireccion = new JTextField();
        txtAltaComunidad = new JTextField();
        labelAcolitos = new JLabel();
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
        cbTipoAcolito = new JComboBox<>();

        createUIComponents();

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

        //---- txtAltaComunidad ----
        txtAltaComunidad.setText("Alta Comunidad...");
        txtAltaComunidad.setEditable(false);

        //---- labelAcolitos ----
        labelAcolitos.setText("LISTA DE AC\u00d3LITOS");
        labelAcolitos.setFont(new Font("Inter", Font.BOLD, 14));

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

            //---- listaAcolitos ----
            listaAcolitos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    listaAcolitosMouseClicked(e);
                }
            });
            scrollAcolitos.setViewportView(listaAcolitos);
        }

        //---- btnBuscar ----
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(e -> btnBuscar(e));

        //---- txtBuscarPorAlias ----
        txtBuscarPorAlias.setText("Buscar por alias...");

        //---- txtContraseña ----
        txtContraseña.setText("Contrase\u00f1a...");

        //---- cbTipoAcolito ----
        cbTipoAcolito.setModel(new DefaultComboBoxModel<>(new String[] {
            "Cabecilla",
            "JefeDivision",
            "Normal",
            "GuiaEspiritual",
            "Gestor"
        }));

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
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(btnAnadir, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                    .addComponent(txtAlias)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txtNombre))
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(txtNombreDivision, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                                                .addComponent(txtDireccion, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                                                            .addGap(18, 18, 18)
                                                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(txtAltaComunidad, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                                                .addComponent(txtJefe, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                            .addComponent(bntEliminar, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(btnGuardar))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                            .addComponent(txtInfluencia, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(txtContraseña, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                            .addGap(25, 25, 25))
                                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(scrollEventos, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE)
                                            .addGap(31, 31, 31))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(cbTipoAcolito, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                    .addComponent(imagenAcolito, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(46, 46, 46)
                                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtBuscarPorAlias, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                                        .addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))))
                                            .addGap(18, 18, 18)))
                                    .addComponent(scrollAcolitos, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
                            .addGap(16, 16, 16))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(btnVolver)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelAcolitos)
                            .addGap(58, 58, 58))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelAcolitos)
                                .addComponent(txtBuscarPorAlias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollAcolitos)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(btnBuscar)
                                        .addComponent(imagenAcolito, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbTipoAcolito, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(198, 198, 198)
                                    .addComponent(scrollEventos, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                    .addGap(4, 4, 4)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(btnVolver)
                            .addGap(143, 143, 143)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAlias))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtInfluencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNombreDivision, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtJefe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAltaComunidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(186, 186, 186)))
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bntEliminar, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnadir, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar)))
                    .addGap(12, 12, 12))
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
    private JTextField txtAltaComunidad;
    private JLabel labelAcolitos;
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
    private JComboBox<String> cbTipoAcolito;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
