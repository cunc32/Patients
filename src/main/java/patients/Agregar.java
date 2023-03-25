/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package patients;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AORUS
 */
public class Agregar extends javax.swing.JFrame {

    int indice = 0;
    DefaultTableModel modelo = new DefaultTableModel();

    /**
     * Creates new form Agregar
     *
     * @param index
     * @param tabla
     */
    public Agregar(int index, JTable tabla) {
        initComponents();
        indice = index;
        this.modelo.setColumnCount(tabla.getModel().getColumnCount());
        Vector temporal = new Vector();
        for (int i = 0; i < tabla.getModel().getColumnCount(); i++) {
            temporal.add(tabla.getModel().getColumnName(i));
        }
        this.modelo.setColumnIdentifiers(temporal);
        this.modelo.setRowCount(0);
        agregando.setModel(this.modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        agregando = new javax.swing.JTable();
        Insertar = new javax.swing.JButton();
        newFila = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        agregando.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(agregando);

        Insertar.setText("Insertar");
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });

        newFila.setText("Agregar Fila");
        newFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFilaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newFila, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Insertar)
                    .addComponent(newFila))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
        modelo = (DefaultTableModel) agregando.getModel();
        int limite = this.modelo.getRowCount();
        if (indice == 0) {
            for (int i = 0; i < limite; i++) {
                Conexion.Execute(String.format("insert into pacientes values('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%d', '%s', '%s'); ",
                        (String)modelo.getValueAt(i, 0), // no_expediente
                        (String)modelo.getValueAt(i, 1), // identidad
                        (String)modelo.getValueAt(i, 2), // Primer Nombre
                        (String)modelo.getValueAt(i, 3), // Segundo Nombre
                        (String)modelo.getValueAt(i, 4), // Primer Apellido
                        (String)modelo.getValueAt(i, 5), // Segundo Apellido    
                        (String)modelo.getValueAt(i, 6), // Genero
                        Integer.parseInt((String)modelo.getValueAt(i, 7)), // Edad
                        (String)modelo.getValueAt(i, 8), // Telefono
                        (String)modelo.getValueAt(i, 9))); // Fecha de Nacimiento
            }
        }
        this.dispose();
    }//GEN-LAST:event_InsertarActionPerformed

    private void newFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFilaActionPerformed
        modelo.setRowCount(modelo.getRowCount() + 1);
        agregando.setModel(modelo);
    }//GEN-LAST:event_newFilaActionPerformed

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
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Insertar;
    private javax.swing.JTable agregando;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newFila;
    // End of variables declaration//GEN-END:variables
}
