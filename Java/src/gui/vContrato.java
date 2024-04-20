/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VUsuarios.java
 *
 * Created on 16-feb-2011, 18:17:07
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

import aplicacion.Acolito;
/**
 *
 * @author basesdatos
 */
public class vContrato extends JFrame {

     private aplicacion.FachadaAplicacion fa;



    // Creación de una ventana de contrato inicial
    public vContrato(aplicacion.FachadaAplicacion fa) {
        this.fa=fa;
        initComponents();
    }

    // Si el usuario firma el contrato, lo redirigimos a una ventana principal
    private void btnAceptar(ActionEvent e) {
        // TODO add your code here

    }

    // Si el usuario no firma el contrato, saldrá del programa
    private void btnRechazar(ActionEvent e) {
        // TODO add your code here
        System.exit(0);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Sara Castro
    private void initComponents() {
        btnAceptar = new JButton();
        btnRechazar = new JButton();
        scrollPane1 = new JScrollPane();
        editorPane1 = new JEditorPane();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contrato de Aceptaci\u00f3n del Inicio de Sesi\u00f3n a la Comunidad Ymiriano");
        setResizable(false);
        setBackground(new Color(0xcccccc));
        var contentPane = getContentPane();

        //---- btnAceptar ----
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(e -> btnAceptar(e));

        //---- btnRechazar ----
        btnRechazar.setText("Rechazar");
        btnRechazar.addActionListener(e -> btnRechazar(e));

        //======== scrollPane1 ========
        {

            //---- editorPane1 ----
            editorPane1.setText("<!DOCTYPE html>\n<html lang=\"es\">\n<head>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<title>Contrato de Aceptaci\u00f3n del Inicio de Sesi\u00f3n a la Comunidad</title>\n<style>\n  body {\n    font-family: Arial, sans-serif;\n    text-align: justify;\n  }\n  h1 {\n    font-size: 18px; /* Reducir el tama\u00f1o de la letra para h1 */\n  }\n  h2 {\n    font-size: 14px; /* Reducir el tama\u00f1o de la letra para h2 */\n    margin-bottom: 10px; /* Agregar un espacio inferior */\n  }\n</style>\n</head>\n<body>\n<h1>Contrato de Aceptaci\u00f3n del Inicio de Sesi\u00f3n a la Comunidad</h1>\n\n<p>Este Contrato de Aceptaci\u00f3n del Inicio de Sesi\u00f3n se celebra entre <em>sectas.gal/imiriano.sec/users_accept</em>, en adelante sectas.gal/imiriano.sec/users_accept, y el Usuario, en adelante \"%nombreUsuario\".</p>\n\n<h2>1. Aceptaci\u00f3n del Inicio de Sesi\u00f3n</h2>\n<p>El Usuario acepta que al iniciar sesi\u00f3n en la base de datos utilizando su nombre de usuario y contrase\u00f1a, est\u00e1 accediendo a los servicios y contenidos proporcionados por la comunidad Imiriano.</p>\n\n<h2>2. Responsabilidad del Usuario</h2>\n<ul>\n<li>El Usuario es responsable de mantener la confidencialidad de su nombre de usuario y contrase\u00f1a, y de todas las actividades que ocurran bajo su cuenta.</li>\n<li>Al aceptar este contrato, el Usuario se compromete a mostrar su ubicaci\u00f3n en tiempo real durante el resto de su vida, con el fin de poder localizarlo para cualquier fin de la Comunidad.</li>\n<li>Asimismo, al optar por dejar de formar parte de nuestra Comunidad, el Usuario est\u00e1 incumpliendo con los principios y valores fundamentales que sustentan nuestra Sociedad, poniendo en peligro su propia vida.</li>\n</ul>\n\n<h2>3. Uso Aceptable</h2>\n<p>El Usuario acepta utilizar la Base de Datos de nuestra Comunidad de acuerdo con los t\u00e9rminos y condiciones establecidos por la misma, as\u00ed como cumplir con todas las leyes y regulaciones aplicables.</p>\n\n<h2>4. Privacidad</h2>\n<p>La Base de Datos se compromete a proteger la privacidad del Usuario de acuerdo con su pol\u00edtica de privacidad. Al aceptar este Contrato, el Usuario tambi\u00e9n acepta los t\u00e9rminos de la pol\u00edtica de privacidad de la Base de Datos.</p>\n\n<h2>5. Terminaci\u00f3n</h2>\n<p>Este Contrato permanecer\u00e1 en vigor hasta que sea terminado por cualquiera de las partes. La Base de Datos se reserva el derecho de terminar este Contrato y de bloquear el acceso del Usuario a su cuenta en caso de violaci\u00f3n de los t\u00e9rminos y condiciones establecidos. Como bien se dijo en el punto 2, cualquier tipo de desligue del Usuario con nuestra Comunidad ser\u00e1 penado seriamente, con una decisi\u00f3n que no tendr\u00e1 vuelta atr\u00e1s.</p>\n\n<h2>6. Ley Aplicable</h2>\n<p>Este Contrato se regir\u00e1 e interpretar\u00e1 de acuerdo con las leyes del Mundo Imir sin tener en cuenta sus principios de conflicto de leyes.</p>\n\n<p>Al iniciar sesi\u00f3n en la Base de Datos, el Usuario acepta los t\u00e9rminos y condiciones establecidos en este Contrato.</p>\n</body>\n</html>");
            editorPane1.setContentType("text/html");
            scrollPane1.setViewportView(editorPane1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addComponent(btnRechazar, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                    .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                    .addGap(90, 90, 90))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 439, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(63, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRechazar)
                        .addComponent(btnAceptar))
                    .addGap(29, 29, 29))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sara Castro
    private JButton btnAceptar;
    private JButton btnRechazar;
    private JScrollPane scrollPane1;
    private JEditorPane editorPane1;
    // End of variables declaration//GEN-END:variables

}
