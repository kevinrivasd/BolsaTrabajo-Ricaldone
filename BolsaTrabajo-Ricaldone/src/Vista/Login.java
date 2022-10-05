/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import Controlador.ControladorLogin;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import Controlador.ControladorLogin;
import Controlador.Utils;

/**
 * Login Form
 *
 * @author hello
 */
public class Login extends javax.swing.JFrame {

    /**
     * Object from ControladorLogin
     */
    ControladorLogin logincontroller = new ControladorLogin();

    /**
     * Creates new form Login
     */
//    
    /**
     * assign titles and dimensions
     */
    public Login() {
        initComponents();

        Toolkit t = Toolkit.getDefaultToolkit();

        Dimension h = t.getScreenSize();

        setTitle("Login");
        this.setLocationRelativeTo(null);  // *** this will center your app ***
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
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(133, 175, 75));

        jLabel3.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Logo pequeño.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel3)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(244, 244, 244));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 486));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUser.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });
        jPanel3.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 297, 37));
        txtUser.getAccessibleContext().setAccessibleName("txtUser");

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/User Login.png"))); // NOI18N
        jLabel2.setText("   Usuario");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/key login.png"))); // NOI18N
        jLabel5.setText("   Contraseña");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        btnIniciarSesion.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnIniciarSesion.setText("Ingresar");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        jPanel3.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 455, 126, 50));

        jLabel1.setBackground(new java.awt.Color(133, 175, 75));
        jLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(133, 175, 75));
        jLabel1.setText("¿Olvidaste tu Contraseña?");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 468, -1, -1));

        txtpassword.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpasswordKeyTyped(evt);
            }
        });
        jPanel3.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 297, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * button to log in with the correct credentials
     *
     * @param evt
     */
    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_btnIniciarSesionActionPerformed

        String user;
        char[] password;
        try {
            user = txtUser.getText();
            password = txtpassword.getPassword();
            String num = logincontroller.Login(user, password);
            String State = logincontroller.EstadoC(user, password);
            int primeruso = logincontroller.PrimerUsoController(user);
            if (!"".equals(num)) {
                if (!"2".equals(State)) {
                    if (primeruso == 0) {
                        JOptionPane.showMessageDialog(null, "<html><center>" + "Acceso permitido" + "</html></center>", "Proceso completado", 1);
                        PrimerUso frm = new PrimerUso(num);
                        frm.setVisible(true);
                        logincontroller.UpdatePrimerUsoCOntroller(user);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "<html><center>" + "Acceso permitido" + "</html></center>", "Proceso completado", 1);
                        Menú newfrm = new Menú(num);
                        newfrm.setVisible(true);
                        this.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario bloqueado, pruebe con otros datos", "Error", 0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, verifica tus datos", "Hubo un error!", 0);
            }

        } catch (Exception e) {
            //TODO: handle exception
            JOptionPane.showMessageDialog(null, "e: " + e.getMessage());
        }

    }//GEN-LAST:event_btnIniciarSesionActionPerformed
    /**
     * Button to enter the password recovery form
     *
     * @param evt
     */
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        RecuperacionPWD frm = new RecuperacionPWD();
        frm.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        if (txtUser.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUserKeyTyped

    private void txtpasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyTyped
        if (txtpassword.getText().length() >= 250) {
            evt.consume();
        }
    }//GEN-LAST:event_txtpasswordKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtUser;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
