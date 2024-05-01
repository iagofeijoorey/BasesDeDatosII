/*
 * Created by JFormDesigner on Tue Apr 30 19:27:06 CEST 2024
 */

package gui;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author luis-
 */
public class VRituales extends JFrame {
    public VRituales() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Luis Estrada
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        comboBox1 = new JComboBox();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("RITUALES");
        contentPane.add(label1, "cell 7 1 3 1");

        //---- button1 ----
        button1.setText("Volver");
        contentPane.add(button1, "cell 0 3");

        //---- button2 ----
        button2.setText("Buscar");
        contentPane.add(button2, "cell 9 5 2 1");
        contentPane.add(comboBox1, "cell 0 5 3 1");

        //======== panel1 ========
        {
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder ( 0
            , 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM
            , new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,
            panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]"));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table1);
            }
            panel1.add(scrollPane1, "cell 0 0 8 1");
        }
        contentPane.add(panel1, "cell 1 7 9 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Luis Estrada
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JComboBox comboBox1;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
