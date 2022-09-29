/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import jdk.jshell.execution.Util;
import Controlador.Utils;

/**
 * Form to manage applicants' branches, general skills and additional skills.
 *
 * @author hello
 */
public class AbilitiesCRUD extends javax.swing.JFrame {

    /**
     * Object from Utils
     */
    Utils utils = new Utils();
    /**
     * Creates new form AbilitiesCRUD
     */

    /**
     * Type of table for skills or branches
     */
    private static int typeA = 0;

    /**
     * Postulant id
     */
    private static String idPos = "";

    /**
     * column arrangement
     */
    String[] arrAb = {"", "idLevel", ""};

    /**
     * table variable
     */
    private static String table = "";
    /**
     * mapping of levels
     */
    public HashMap<Integer, String> levelCMB;

    /**
     * Method to generate an array and a switch to choose the table depending on
     * which one you select.
     *
     * @param abilitie
     * @param id
     * @throws Exception
     */
    public AbilitiesCRUD(int abilitie, String id) throws Exception {
        initComponents();
        this.setLocationRelativeTo(null);
        typeA = abilitie;
        idPos = id;
        switch (typeA) {
            case 0:
                table = "AditionalSkills";
                arrAb[0] = "NameSkill";
                arrAb[2] = "idPostulant";
                break;
            case 1:
                table = "Branches";
                arrAb[0] = "Branch";
                arrAb[2] = "idPostulant";
                break;
            case 2:
                table = "GeneralSkills";
                arrAb[0] = "Skill";
                arrAb[2] = "idPostulant";
                break;

            default:
                throw new AssertionError();
        }

        dgvLol.setModel(utils.rtrnTqble(table, arrAb, id));
        txtId.setVisible(false);

        levelCMB = utils.getDataTable("Levels");
        for (int k = 1; k <= levelCMB.size(); k++) {
            cmbLevel.addItem(levelCMB.get(k));
        }

//        List<String> level = utils.getDataCmb("Levels", "Levels");
//
//        JComboBox combo = new JComboBox<>(level.toArray());
//        TableColumn col = dgvLol.getColumnModel().getColumn(1);
//        col.setCellEditor(new DefaultCellEditor(combo));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvLol = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbLevel = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblRegresar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(239, 245, 213));

        jPanel1.setBackground(new java.awt.Color(239, 245, 213));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dgvLol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        dgvLol.setGridColor(new java.awt.Color(0, 0, 0));
        dgvLol.setSelectionBackground(new java.awt.Color(193, 233, 118));
        dgvLol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvLolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dgvLol);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 250, 600, 386));

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(50, 63, 27));
        jLabel4.setText("Habilidades Extras");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 240, -1));

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel3.setText("Titulo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 125, 23));
        jPanel1.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 182, -1));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel2.setText("Nivel De manejo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, 23));

        jPanel1.add(cmbLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 170, -1));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jButton1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jButton1.setText("Agregar habilidad");
        jButton1.setPreferredSize(new java.awt.Dimension(85, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 170, 34));

        btnActualizar.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnActualizar.setText("Modificar habilidad");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 170, 34));

        btnEliminar.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar habilidad");
        btnEliminar.setPreferredSize(new java.awt.Dimension(85, 25));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 170, 34));

        lblRegresar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lblRegresar.setForeground(new java.awt.Color(133, 175, 75));
        lblRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recu_regresar.png"))); // NOI18N
        lblRegresar.setText("Regresar");
        lblRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarMouseClicked(evt);
            }
        });
        jPanel1.add(lblRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 8, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Insert a record of either a branch, general skill or additional skill. Depending on which one you have previously chosen from the applicants.
     *
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map = collectMap();

        try {
            int res = utils.Agregar(map, table);
            if (res == 1) {
                JOptionPane.showMessageDialog(null, "Agregado exitosamente");
                dgvLol.setModel(utils.rtrnTqble(table, arrAb, idPos));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo insertar el registro");
            }
        } catch (Exception ex) {
            Logger.getLogger(AbilitiesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * Delete a record from either a branch, general skill or additional skill. Depending on which one you have previously chosen from the applicants.
     *
     * @param evt
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            if (JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar este elemento?", "Mensaje",
                    JOptionPane.YES_NO_OPTION) == ConfirmationCallback.YES) {
                // TODO add your handling code here:
                String id = txtId.getText();
                int res = utils.eliminar(id, table, arrAb[2]);
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Elemento eliminado correctamente");
                    try {
                        dgvLol.setModel(utils.rtrnTqble(table, arrAb, idPos));
                    } catch (Exception ex) {
                        Logger.getLogger(UsuariosPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, res);
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    /**
     * Delete a record from either a branch, general skill or additional skill. Depending on which one you have previously chosen from the applicants.
     *
     * @param evt
     */
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        LinkedHashMap<String, String> data = collectMap();

        if (!Controlador.Utils.emptyFields(data)) {
            String id = txtId.getText();
            int res = 0;
            try {
                res = utils.actualizar(data, id, table, arrAb[2]);
                JOptionPane.showMessageDialog(null, res == 1 ? "Elemento correctamente actualizado" : "Hubo un error");

                dgvLol.setModel(utils.rtrnTqble(table, arrAb, idPos));
            } catch (Exception ex) {
                Logger.getLogger(UsuariosPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor revisa que los campos estén correctamente llenos.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed
    /**
     * Event to select the table rows and perform the update function.
     *
     * @param evt
     */
    private void dgvLolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvLolMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {
            JTable Table = (JTable) evt.getSource();
            txtId.setText(Table.getModel().getValueAt(Table.getSelectedRow(), 2).toString());
            cmbLevel.setSelectedItem(levelCMB.get(Integer.valueOf(Table.getModel().getValueAt(Table.getSelectedRow(), 1).toString())));
            txtTitle.setText(Table.getModel().getValueAt(Table.getSelectedRow(), 0).toString());

        }
    }//GEN-LAST:event_dgvLolMouseClicked
    /**
     * Icon to close the form and return to the previous one
     *
     * @param evt
     */
    private void lblRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblRegresarMouseClicked
    private LinkedHashMap<String, String> collectMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put(arrAb[0], txtTitle.getText());
        map.put(arrAb[1], String.valueOf(cmbLevel.getSelectedIndex() + 1));
        map.put("idPostulant", idPos);
        return map;
    }

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
            java.util.logging.Logger.getLogger(AbilitiesCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbilitiesCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbilitiesCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbilitiesCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new AbilitiesCRUD(typeA, idPos).setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(AbilitiesCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cmbLevel;
    private javax.swing.JTable dgvLol;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
