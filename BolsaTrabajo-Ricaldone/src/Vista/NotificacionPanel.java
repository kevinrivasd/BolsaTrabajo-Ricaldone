/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.Utils;
import Controlador.ControladorNotificaciones;
import Controlador.ControladorUsuario;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.ModeloUtils;
import javax.security.auth.callback.ConfirmationCallback;
import Controlador.Utils;

/**
 * Form to manage moderations
 *
 * @author Jonathan
 */
public class NotificacionPanel extends javax.swing.JPanel {

    /**
     * Creates new form NotificacionPanel
     */
    /**
     * Default table
     */
    DefaultTableModel mod;
    /**
     * Object from ModeloUtils
     */
    ModeloUtils utils = new ModeloUtils();
    /**
     * Object from Utils
     */
    Utils utilc = new Utils();
    DefaultTableModel jPost = new DefaultTableModel();
    /**
     * Load moderations
     *
     * @throws SQLException
     * @throws Exception
     */
    public NotificacionPanel() throws SQLException, Exception {
        initComponents();
        String[] Encabezados = {"ID", "Postulante", "Fecha", "Descripción", "respuesta", "Información de la respuesta", "Usuario"};
        mod = new DefaultTableModel(null, Encabezados);
        dgvNoti.setModel(mod);
//        CargarTabla();
        jPost = utilc.rtrnTqble("Moderations");
        dgvNoti.setModel(jPost);

    }

    /**
     * Method to load a table as a back up
     */
    final void CargarTabla() {
        ControladorNotificaciones Cargarnoti = new ControladorNotificaciones();
        while (mod.getRowCount() > 0) {
            mod.removeRow(0);
        }
        try {
            ResultSet rs = Cargarnoti.CargarNotificacionsControlador();
            while (rs.next()) {
                Object[] oValores = {rs.getInt("idMod"), rs.getString("namePostulant"), rs.getDate("dateMod"), rs.getString("context"), rs.getString("request"), rs.getString("requestedInfo"), rs.getString("nameUser")};
                mod.addRow(oValores);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

//    public void AsignarComponentes() throws SQLException{
//        ControladorNotificaciones noti = new ControladorNotificaciones();
//        Object datos[] = new String[7];
//        ResultSet rs = noti.CargarNotificacionsControlador();
//        for (int i = 0; i < datos.length; i++) {
//            lblID = (JLabel) rs.getObject("idMod");
//            lblNombrePost = (JLabel) rs.getObject("namePostulant");
//            lblfecha = (JLabel) rs.getObject("dateMod");
//            lblcontext = (JLabel) rs.getObject("context");
//            lblrequest = (JLabel) rs.getObject("request");
//            lblrequestedinfo = (JLabel) rs.getObject("requestedInfo");
//            lbluser = (JLabel) rs.getObject("nameUser");
//        }
//        
////        try {
////            ControladorNotificaciones noti = new ControladorNotificaciones(Integer.parseInt(lblID.getText()),lblNombrePost.getText(),lblfecha.getText(),lblcontext.getText(),lblrequest.getText(),lblrequestedinfo.getText(),lbluser.getText());
////            noti.idMod = lblID
////        } catch (Exception e) {
////        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvNoti = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1141, 833));

        jPanel8.setBackground(new java.awt.Color(239, 245, 213));
        jPanel8.setPreferredSize(new java.awt.Dimension(1075, 833));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(50, 63, 27));
        jLabel3.setText("Notificaciones");

        dgvNoti.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        dgvNoti.setModel(new javax.swing.table.DefaultTableModel(
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
        dgvNoti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvNotiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dgvNoti);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(312, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1141, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
/**
     * Event to press rows and send pdf's
     *
     * @param evt
     */
    private void dgvNotiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvNotiMouseClicked
        // TODO add your handling code here:
        Utils util = new Utils();
        if (evt.getClickCount() == 1) {
            try {
                var idPostulante = dgvNoti.getModel().getValueAt(dgvNoti.getSelectedRow(), 1);
                int idMod = Integer.valueOf(dgvNoti.getModel().getValueAt(dgvNoti.getSelectedRow(), 0).toString());
                String mailUser = dgvNoti.getModel().getValueAt(dgvNoti.getSelectedRow(), 3).toString();

                if (idPostulante != null) {
                    String b64 = utils.getPDF(idPostulante.toString());
                    
                    if (!b64.equals("") || !mailUser.equals("") || !b64.isEmpty() || !b64.isBlank() ||
                        b64!=null) {
                        if (JOptionPane.showConfirmDialog(null, "¿Deseas enviar el pdf adjunto en un correo?", "Mensaje", JOptionPane.YES_NO_OPTION) == ConfirmationCallback.YES) {
                            util.sendPDF(b64, mailUser);
//                            JOptionPane.showMessageDialog(null, b64);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Este postulante no tiene pdf aun");
                    }
                } else {
                     if (JOptionPane.showConfirmDialog(null, "Seguro que le quieres crear una cuenta a esta persona?", "Mensaje",
                        JOptionPane.YES_NO_OPTION) == ConfirmationCallback.YES) {
                         Utils obj = new Utils();
                         obj.sendConfirmation(idMod);
                         jPost = utilc.rtrnTqble("Moderations");
                         dgvNoti.setModel(jPost);
                         this.revalidate();
                         this.repaint();
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
//                Logger.getLogger(PostulantesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_dgvNotiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dgvNoti;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
