/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package patients;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class PreCheck extends javax.swing.JFrame {

    /**
     * Creates new form PreCheck
     */
    int index = -1;
    
    public PreCheck(String no_expediente) {
        initComponents();
        this.setLocationRelativeTo(null);
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)Expediente.getModel();
        modelo.removeAllElements();
        ResultSet res = Conexion.Consulta("SELECT no_expediente FROM pacientes");
        try {
            while (res.next()) {
                modelo.addElement(res.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        if (no_expediente != null) {
            modelo.setSelectedItem(no_expediente);
        } else {
            no_expediente = (String)modelo.getSelectedItem();
        }
        index = modelo.getIndexOf(no_expediente);
        loadInfo(no_expediente);
    }
    
    private void loadInfo(String no_expediente) {
        ResultSet res = Conexion.Consulta(String.format("SELECT * FROM pacientes where no_expediente like '%s'", no_expediente));
        DateField.setText(DateField.getText()+java.time.LocalDate.now().toString());
        try {
            while (res.next()) {
                GenderField.setText(GenderField.getText()+res.getString("genero"));
                AgeField.setText(AgeField.getText()+res.getString("edad"));
                BirthField.setText(BirthField.getText()+res.getString("fecha_nacimiento"));
                NameField.setText(NameField.getText()+res.getString("primer_nombre")+" "+
                        res.getString("segundo_nombre")+" "+res.getString("primer_apellido")+" "+
                        res.getString("segundo_apellido"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PreCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DateField = new javax.swing.JLabel();
        GenderField = new javax.swing.JLabel();
        AgeField = new javax.swing.JLabel();
        BirthField = new javax.swing.JLabel();
        NameField = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PresionField = new javax.swing.JTextField();
        CFrequenceField = new javax.swing.JTextField();
        TemperatureField = new javax.swing.JTextField();
        RFrequenceField = new javax.swing.JTextField();
        SaturationField = new javax.swing.JTextField();
        WeightField = new javax.swing.JTextField();
        HeightField = new javax.swing.JTextField();
        Expediente = new javax.swing.JComboBox<>();
        SubmittButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(620, 320));

        DateField.setText("Fecha: ");

        GenderField.setText("Genero: ");

        AgeField.setText("Edad: ");

        BirthField.setText("Fecha de Nacimiento:");

        NameField.setText("Nombre Completo: ");

        jLabel1.setText("Presión");

        jLabel2.setText("F.C.");

        jLabel3.setText("T°");

        jLabel4.setText("F.R.");

        jLabel5.setText("SPO2");

        jLabel6.setText("Peso");

        jLabel7.setText("Talla");

        Expediente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Expediente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ExpedienteItemStateChanged(evt);
            }
        });
        Expediente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                ExpedientePopupMenuCanceled(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                ExpedientePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        SubmittButton.setBackground(new java.awt.Color(28, 158, 153));
        SubmittButton.setForeground(new java.awt.Color(250, 250, 250));
        SubmittButton.setText("Completar");
        SubmittButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmittButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NameField)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DateField)
                                .addGap(51, 51, 51)
                                .addComponent(GenderField)
                                .addGap(43, 43, 43)
                                .addComponent(AgeField)
                                .addGap(48, 48, 48)
                                .addComponent(BirthField))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)
                                    .addComponent(PresionField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(HeightField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(CFrequenceField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(TemperatureField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(RFrequenceField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(SaturationField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(WeightField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Expediente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(SubmittButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Expediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DateField)
                    .addComponent(GenderField)
                    .addComponent(AgeField)
                    .addComponent(BirthField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NameField)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PresionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CFrequenceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TemperatureField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RFrequenceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaturationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WeightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HeightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SubmittButton)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExpedienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ExpedienteItemStateChanged
        
    }//GEN-LAST:event_ExpedienteItemStateChanged

    private void ExpedientePopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ExpedientePopupMenuCanceled
        
    }//GEN-LAST:event_ExpedientePopupMenuCanceled

    private void ExpedientePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ExpedientePopupMenuWillBecomeInvisible
        if (Expediente.getSelectedIndex() != index) {
            DateField.setText("Fecha: ");
            GenderField.setText("Género: ");
            AgeField.setText("Edad: ");
            BirthField.setText("Fecha de Nacimiento: ");
            NameField.setText("Nombre Completo: ");
            loadInfo((String)Expediente.getSelectedItem());
            index = Expediente.getSelectedIndex();
        }
    }//GEN-LAST:event_ExpedientePopupMenuWillBecomeInvisible

    private void SubmittButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmittButtonActionPerformed
        if (PresionField.getText().equals("") || CFrequenceField.getText().equals("") ||
                TemperatureField.getText().equals("") || RFrequenceField.getText().equals("") ||
                SaturationField.getText().equals("") || WeightField.getText().equals("") ||
                HeightField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Error: Favor terminar de llenar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Conexion.Execute(String.format("insert into consultas(presion, frecuencia_cardiaca, temperatura, "
                    + "frecuencia_respiratoria, saturacion, peso, estatura, id_paciente, estado) values('%s', %s, %s, %s, %s, %s, %s, %s, '%s'); ",
                    PresionField.getText(), CFrequenceField.getText(), TemperatureField.getText(),
                    RFrequenceField.getText(), SaturationField.getText(), WeightField.getText(), HeightField.getText(),
                    ((String)Expediente.getSelectedItem()).substring(1), "CONSULTA"));
            this.dispose();
            JOptionPane.showMessageDialog(null, "Consulta creada correctamente ", "Creado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_SubmittButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PreCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PreCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PreCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PreCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PreCheck(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AgeField;
    private javax.swing.JLabel BirthField;
    private javax.swing.JTextField CFrequenceField;
    private javax.swing.JLabel DateField;
    private javax.swing.JComboBox<String> Expediente;
    private javax.swing.JLabel GenderField;
    private javax.swing.JTextField HeightField;
    private javax.swing.JLabel NameField;
    private javax.swing.JTextField PresionField;
    private javax.swing.JTextField RFrequenceField;
    private javax.swing.JTextField SaturationField;
    private javax.swing.JButton SubmittButton;
    private javax.swing.JTextField TemperatureField;
    private javax.swing.JTextField WeightField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
