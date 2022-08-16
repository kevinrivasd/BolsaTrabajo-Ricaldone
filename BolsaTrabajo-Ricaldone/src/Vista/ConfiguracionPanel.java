/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;
import Controlador.Utils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Jonathan
 */
public class ConfiguracionPanel extends javax.swing.JPanel {

    /**
     * Creates new form ConfiguracionPanel
     */
    public static List<String> userName;
    public ConfiguracionPanel(List<String> userParam) {
        initComponents();
        userName = userParam;
        txtCorreo.setText(userName.get(1));
        txtUser.setText(userName.get(0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        txtCorreo = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(239, 245, 213));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(50, 63, 27));
        jLabel1.setText("Configuracion");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 23, -1, -1));

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(133, 175, 75));
        jLabel3.setText("cambiar contraseña");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, -1));

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(50, 63, 27));
        jLabel4.setText("Nombre de usuario ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(50, 63, 27));
        jLabel6.setText("Correo");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));
        jPanel2.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 338, 46));

        txtCorreo.setText("JuanRomero@gmail.com");
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 332, 46));

        txtUser.setText("JuanRomero");
        jPanel2.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 332, 46));

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(50, 63, 27));
        jLabel5.setText("Lenguaje de sistema");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(50, 63, 27));
        jLabel7.setText("Contraseña");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 216, 31));

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(85, 119, 43));
        jLabel8.setText("Historial de actividad");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        btnActualizar.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 550, 102, 48));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        LinkedHashMap<String,String> data = CollectData();
        int res;
        if (!Controlador.Utils.emptyFields(data)) {
            try {
                res = Controlador.Utils.actualizar(data,userName.get(3),"UserSystems","idUser");
                JOptionPane.showMessageDialog(null, "Te has actualizado con exito");
                userName = Vista.Menú.cargarProps(userName.get(3));

            } catch (Exception ex) {
                Logger.getLogger(ConfiguracionPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No dejes campos sin llenar porfavor.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    private LinkedHashMap<String,String> CollectData() {             
        LinkedHashMap<String,String> data =  new LinkedHashMap<>();
//        char[] pword = txtU.getPassword();
       
        data.put("nameUser", txtUser.getText());        
        data.put("mailUser", txtCorreo.getText());

        
        return data;
    }
}
