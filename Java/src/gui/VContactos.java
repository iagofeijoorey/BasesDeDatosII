/*
 * Created by JFormDesigner on Mon Apr 29 18:02:36 GMT+02:00 2024
 */

package gui;

import aplicacion.Contacto;
import aplicacion.FachadaAplicacion;
import aplicacion.Trato;
import aplicacion.Acolito;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;

/**
 * @author Usuario
 */
public class VContactos extends JDialog {

    private FachadaAplicacion fa;
    private Acolito acolito;
    private Contacto contacto;

    public VContactos(Window owner, FachadaAplicacion fa) {
        super(owner);
        this.fa = fa;
        initComponents();
    }

    //BOTONES
    private void btnGuardarMouseClicked(MouseEvent e) {
        if(txtPseudonimo.getText() != "Pseudónimo..." && txtNombre.getText() != "Nombre..." && txtNombre.getText() != null
                && txtTelefono.getText() != "Teléfono..." && txtTelefono.getText() != null && txtDescripcion.getText() != "Descripción..."){
            //crear método DAO----------------------------------------------------------------------------
            fa.actualizarContacto(txtPseudonimo.getText(), txtNombre.getText(), txtTelefono.getText(), txtDescripcion.getText());
        }

    }

    private void btnProponerTratoMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void btnRomperTratoMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void bntEliminarMouseClicked(MouseEvent e) {
        if(txtPseudonimo.getText() != "Pseudónimo..."){
            if(!fa.hayTratos(acolito.getAlias(), contacto.getPseudonimo()))
                fa.eliminarContacto(txtPseudonimo.getText());
        }

        //Para actualizar las listas :)
        createUIComponents();
    }

    private void btnAnadirMouseClicked(MouseEvent e) {
        //crear método GUI
        fa.ventanaContactoNuevo(this);

        //Para actualizar las listas :)
        createUIComponents();
    }

    private void btnVolverMouseClicked(MouseEvent e) {
        this.dispose();
    }

    //INICIALIZACIONES
    private void inicializarListaTratos() {
        ArrayList<Trato> tratos = fa.obtenerTratos(acolito, contacto);
        ModeloListaTratos mListaT=new ModeloListaTratos();
        ListaTratos.setModel(mListaT);
        mListaT.setElementos(tratos);
    }

    private void inicializarListaContactos() {
        //crear método DAO----------------------------------------------------------------------------
        ArrayList<Contacto> contactos = fa.obtenerContactos(acolito);
        ModeloListaContactos mListaC=new ModeloListaContactos();
        ListaContactos.setModel(mListaC);
        mListaC.setElementos(contactos);
        if (mListaC.getSize()>0) {
            ListaContactos.setSelectedIndex(0);
            //contacto = ListaContactos.getElementAt(0);          //¿QUÉ COÑO?
            fa.rellenarDatos(this);

            bntEliminar.setEnabled(true);
            btnGuardarEdicion.setEnabled(true);
        } else {
            bntEliminar.setEnabled(false);
            btnGuardarEdicion.setEnabled(false);
        }
    }

    private void createUIComponents() {
        inicializarListaContactos();
        inicializarListaTratos();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Laura Antelo González
        createUIComponents();

        btnGuardarEdicion = new JButton();
        btnVolver = new JButton();
        txtPseudonimo = new JTextField();
        txtNombre = new JTextField();
        scrollPane1 = new JScrollPane();
        txtDescripcion = new JTextPane();
        Imagen_texto = new JLabel();
        Imagen = new JLabel();
        txtTelefono = new JTextField();
        btnProponerTrato = new JButton();
        btnRomperTrato = new JButton();
        scrollPane2 = new JScrollPane();
        tratis_texto = new JLabel();
        bntEliminar = new JButton();
        btnAnadir = new JButton();
        contactos_texto = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mis Contactos");
        setResizable(false);
        var contentPane = getContentPane();

        //---- btnGuardarEdicion ----
        btnGuardarEdicion.setText("Guardar edici\u00f3n");
        btnGuardarEdicion.setEnabled(false);
        btnGuardarEdicion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnGuardarMouseClicked(e);
            }
        });

        //---- btnVolver ----
        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnVolverMouseClicked(e);
            }
        });

        //---- txtPseudonimo ----
        txtPseudonimo.setText("Pseud\u00f3nimo...");
        txtPseudonimo.setEditable(false);
        txtPseudonimo.setForeground(Color.gray);

        //---- txtNombre ----
        txtNombre.setText("Nombre...");
        txtNombre.setForeground(Color.gray);

        //======== scrollPane1 ========
        {

            //---- txtDescripcion ----
            txtDescripcion.setText("Descripci\u00f3n...");
            txtDescripcion.setForeground(Color.gray);
            scrollPane1.setViewportView(txtDescripcion);
        }

        //---- Imagen_texto ----
        Imagen_texto.setText("Foto de perfil");

        //---- Imagen ----
        Imagen.setText("(imagen)");

        //---- txtTelefono ----
        txtTelefono.setText("Tel\u00e9fono...");
        txtTelefono.setForeground(Color.gray);

        //---- btnProponerTrato ----
        btnProponerTrato.setText("Proponer trato");
        btnProponerTrato.setEnabled(false);
        btnProponerTrato.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnProponerTratoMouseClicked(e);
            }
        });

        //---- btnRomperTrato ----
        btnRomperTrato.setText("Romper trato");
        btnRomperTrato.setEnabled(false);
        btnRomperTrato.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnRomperTratoMouseClicked(e);
            }
        });

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(ListaTratos);
        }

        //---- tratis_texto ----
        tratis_texto.setText("LISTA DE TRATOS");
        tratis_texto.setFont(new Font("Inter", Font.BOLD, 14));

        //---- ListaContactos ----
        ListaContactos.setBorder(LineBorder.createBlackLineBorder());

        //---- bntEliminar ----
        bntEliminar.setText("ELIMINAR CONTACTO");
        bntEliminar.setBackground(new Color(0x990000));
        bntEliminar.setEnabled(false);
        bntEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bntEliminarMouseClicked(e);
            }
        });

        //---- btnAnadir ----
        btnAnadir.setText("A\u00d1ADIR CONTACTO");
        btnAnadir.setBackground(new Color(0x00cc66));
        btnAnadir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnAnadirMouseClicked(e);
            }
        });

        //---- contactos_texto ----
        contactos_texto.setText("LISTA DE CONTACTOS");
        contactos_texto.setFont(new Font("Inter", Font.BOLD, 14));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                            .addGap(193, 193, 193)
                            .addComponent(tratis_texto))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(btnGuardarEdicion, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnProponerTrato, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRomperTrato, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPseudonimo, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18))
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addGroup(contentPaneLayout.createParallelGroup()
                                            .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(Imagen, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(Imagen_texto)))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                            .addComponent(contactos_texto)
                            .addGap(82, 82, 82))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnAnadir, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bntEliminar, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ListaContactos, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(29, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tratis_texto)
                        .addComponent(contactos_texto))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(ListaContactos, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(bntEliminar)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAnadir))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(Imagen_texto)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addComponent(Imagen, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                    .addGap(48, 48, 48)
                                    .addComponent(txtPseudonimo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(btnRomperTrato)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnProponerTrato)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnGuardarEdicion)))))
                    .addGap(28, 28, 28))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Laura Antelo González
    private JButton btnGuardarEdicion;
    private JButton btnVolver;
    private JTextField txtPseudonimo;
    private JTextField txtNombre;
    private JScrollPane scrollPane1;
    private JTextPane txtDescripcion;
    private JLabel Imagen_texto;
    private JLabel Imagen;
    private JTextField txtTelefono;
    private JButton btnProponerTrato;
    private JButton btnRomperTrato;
    private JScrollPane scrollPane2;
    private JList ListaTratos;
    private JLabel tratis_texto;
    private JList ListaContactos;
    private JButton bntEliminar;
    private JButton btnAnadir;
    private JLabel contactos_texto;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    //OTROS MÉTODOS

    //Al seleccionar un contacto, se rellenan sus datos en las celdas de texto
    public void rellenarDatos(){
        txtPseudonimo.setText(contacto.getPseudonimo());
        txtNombre.setText(contacto.getNombre());
        txtTelefono.setText(contacto.getTelefono().toString());
        txtDescripcion.setText(contacto.getDescripcion());
    }

}
