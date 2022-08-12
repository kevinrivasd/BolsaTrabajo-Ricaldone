/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import desplazable.Desface;
import desplazable.Desface;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Jonathan
 */
public class Menú extends javax.swing.JFrame {

    /**
     * Creates new form Menú
     */
    Desface desplace;
    Dimension d = new Dimension(500, 757);
    public JPanel previo = new JPanel();
    public Menú() {
        initComponents();
        this.setLocationRelativeTo(null);
        setPreferredSize(d);
        desplace = new Desface();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMenu = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        btnMenu1 = new javax.swing.JButton();
        btnUsuarioGrafi = new javax.swing.JButton();
        btnEstadisticasGrafi = new javax.swing.JButton();
        btnPostulantesGrafi = new javax.swing.JButton();
        btnNotificacionesGrafi = new javax.swing.JButton();
        btnConfiguracionGrafi = new javax.swing.JButton();
        btnSalirPostu = new javax.swing.JButton();
        PanelHolder = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1333, 757));

        PanelMenu.setBackground(new java.awt.Color(133, 175, 75));

        jPanel5.setBackground(new java.awt.Color(133, 175, 75));

        btnMenu.setBackground(new java.awt.Color(133, 175, 75));
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Menu Menu.png"))); // NOI18N
        btnMenu.setBorder(null);
        btnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuMouseClicked(evt);
            }
        });
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnMenu1.setBackground(new java.awt.Color(133, 175, 75));
        btnMenu1.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Logo Menu.png"))); // NOI18N
        btnMenu1.setBorder(null);
        btnMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenu1MouseClicked(evt);
            }
        });
        btnMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(btnMenu1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMenu)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        btnUsuarioGrafi.setBackground(new java.awt.Color(133, 175, 75));
        btnUsuarioGrafi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUsuarioGrafi.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuarioGrafi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/User menu.png"))); // NOI18N
        btnUsuarioGrafi.setText("Usuario");
        btnUsuarioGrafi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 85));
        btnUsuarioGrafi.setBorderPainted(false);
        btnUsuarioGrafi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioGrafiActionPerformed(evt);
            }
        });

        btnEstadisticasGrafi.setBackground(new java.awt.Color(133, 175, 75));
        btnEstadisticasGrafi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEstadisticasGrafi.setForeground(new java.awt.Color(255, 255, 255));
        btnEstadisticasGrafi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Estadisticas menu.png"))); // NOI18N
        btnEstadisticasGrafi.setText("Estadisticas");
        btnEstadisticasGrafi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 55));
        btnEstadisticasGrafi.setBorderPainted(false);
        btnEstadisticasGrafi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadisticasGrafiActionPerformed(evt);
            }
        });

        btnPostulantesGrafi.setBackground(new java.awt.Color(133, 175, 75));
        btnPostulantesGrafi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPostulantesGrafi.setForeground(new java.awt.Color(255, 255, 255));
        btnPostulantesGrafi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CV Menu.png"))); // NOI18N
        btnPostulantesGrafi.setText("Postulantes");
        btnPostulantesGrafi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 45));
        btnPostulantesGrafi.setBorderPainted(false);
        btnPostulantesGrafi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostulantesGrafiActionPerformed(evt);
            }
        });

        btnNotificacionesGrafi.setBackground(new java.awt.Color(133, 175, 75));
        btnNotificacionesGrafi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNotificacionesGrafi.setForeground(new java.awt.Color(255, 255, 255));
        btnNotificacionesGrafi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/NotificacionesMenu.png"))); // NOI18N
        btnNotificacionesGrafi.setText("Notificaciones");
        btnNotificacionesGrafi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 35));
        btnNotificacionesGrafi.setBorderPainted(false);
        btnNotificacionesGrafi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotificacionesGrafiActionPerformed(evt);
            }
        });

        btnConfiguracionGrafi.setBackground(new java.awt.Color(133, 175, 75));
        btnConfiguracionGrafi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnConfiguracionGrafi.setForeground(new java.awt.Color(255, 255, 255));
        btnConfiguracionGrafi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Configuracion Menu.png"))); // NOI18N
        btnConfiguracionGrafi.setText("Configuracion");
        btnConfiguracionGrafi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 35));
        btnConfiguracionGrafi.setBorderPainted(false);
        btnConfiguracionGrafi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionGrafiActionPerformed(evt);
            }
        });

        btnSalirPostu.setBackground(new java.awt.Color(133, 175, 75));
        btnSalirPostu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Cerrar sesion menu.png"))); // NOI18N
        btnSalirPostu.setBorderPainted(false);
        btnSalirPostu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirPostuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalirPostu)
                .addContainerGap())
            .addComponent(btnConfiguracionGrafi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPostulantesGrafi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEstadisticasGrafi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUsuarioGrafi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNotificacionesGrafi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuarioGrafi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNotificacionesGrafi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEstadisticasGrafi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPostulantesGrafi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfiguracionGrafi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSalirPostu)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        PanelHolder.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout PanelHolderLayout = new javax.swing.GroupLayout(PanelHolder);
        PanelHolder.setLayout(PanelHolderLayout);
        PanelHolderLayout.setHorizontalGroup(
            PanelHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1141, Short.MAX_VALUE)
        );
        PanelHolderLayout.setVerticalGroup(
            PanelHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuMouseClicked

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu1MouseClicked

    private void btnMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu1ActionPerformed

    private void btnUsuarioGrafiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioGrafiActionPerformed
        try {
            PanelHolder.remove(previo);
            previo = new UsuariosPanel();
            PanelHolder.setLayout(new BorderLayout());
            PanelHolder.add(previo, BorderLayout.NORTH);
            previo.repaint();
            previo.revalidate();

        } catch (Exception ex) {
            Logger.getLogger(Menú.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUsuarioGrafiActionPerformed

    private void btnEstadisticasGrafiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadisticasGrafiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEstadisticasGrafiActionPerformed

    private void btnPostulantesGrafiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostulantesGrafiActionPerformed
        try {
            PanelHolder.remove(previo);
            previo = new PostulantesPanel();
            PanelHolder.setLayout(new BorderLayout());
            PanelHolder.add(previo, BorderLayout.NORTH);
            previo.repaint();
            previo.revalidate();
        } catch (Exception ex) {
            Logger.getLogger(Menú.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPostulantesGrafiActionPerformed

    private void btnNotificacionesGrafiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificacionesGrafiActionPerformed
        try {
            PanelHolder.remove(previo);
            previo = new NotificacionPanel();
            PanelHolder.setLayout(new BorderLayout());
            PanelHolder.add(previo, BorderLayout.NORTH);
            previo.repaint();
            previo.revalidate();

        } catch (Exception ex) {
            Logger.getLogger(Menú.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNotificacionesGrafiActionPerformed

    private void btnConfiguracionGrafiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionGrafiActionPerformed
        // TODO add your handling code here:
        try {
            PanelHolder.remove(previo);
            previo = new ConfiguracionPanel();
            PanelHolder.setLayout(new BorderLayout());
            PanelHolder.add(previo, BorderLayout.NORTH);
            previo.repaint();
            previo.revalidate();

        } catch (Exception ex) {
            Logger.getLogger(Menú.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfiguracionGrafiActionPerformed

    private void btnSalirPostuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirPostuActionPerformed
        // TODO add your handling code here:
        Login newFrm = new Login();
        newFrm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirPostuActionPerformed

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
            java.util.logging.Logger.getLogger(Menú.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menú.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menú.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menú.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menú().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelHolder;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JButton btnConfiguracionGrafi;
    private javax.swing.JButton btnEstadisticasGrafi;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnMenu1;
    private javax.swing.JButton btnNotificacionesGrafi;
    private javax.swing.JButton btnPostulantesGrafi;
    private javax.swing.JButton btnSalirPostu;
    private javax.swing.JButton btnUsuarioGrafi;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
