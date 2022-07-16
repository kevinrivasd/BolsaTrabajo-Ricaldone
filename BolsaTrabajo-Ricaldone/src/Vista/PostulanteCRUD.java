/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Utils;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jonathan
 */
public class PostulanteCRUD extends javax.swing.JFrame {

    /**
     * Creates new form PostulanteCRUD
     */
    private static int inti;
    DefaultTableModel base;
    public PostulanteCRUD(int add) throws Exception {
        initComponents();
        txtID.setVisible(false);
        lblID.setVisible(false);
        
        inti = add;
        if (inti == 1) {
            BtnActualizar.setVisible(false);
        }
        else{
            BtnAgregar.setVisible(false);
        }
        this.setLocationRelativeTo(null);
        setTitle("Gestion de postulantes");
        
        List<String> dataGender = Controlador.Utils.getDataCmb("Genders","Gender");        
        for(int k = 0; k<dataGender.size();k++){
           cmbGenero.addItem(dataGender.get(k));
       }
        List<String> datapreflaboral = Controlador.Utils.getDataCmb("WorkPreference","WPreference");        
        for(int k = 0; k<datapreflaboral.size();k++){
           cmbPrefLaboral.addItem(datapreflaboral.get(k));
        }
        
        List<String> dataStatus = Controlador.Utils.getDataCmb("States","States");        
        for(int k = 0; k<dataStatus.size();k++){
           cmbEstadoPost.addItem(dataStatus.get(k));
        }
        
        List<String> dptoPreferencia = Controlador.Utils.getDataCmb("Departments","Department");        
        for(int k = 0; k<dptoPreferencia.size();k++){
           cmbDepartPreferencia.addItem(dptoPreferencia.get(k));
        }
        
        List<String> dptoReside = Controlador.Utils.getDataCmb("Departments","Department");        
        for(int k = 0; k<dptoReside.size();k++){
           cmbDepartReside.addItem(dptoReside.get(k));
        }
        
        List<String> EstadoTrabajo = Controlador.Utils.getDataCmb("WorkState","WorkState");        
        for(int k = 0; k<EstadoTrabajo.size();k++){
           cmbEstadoTrabajo.addItem(EstadoTrabajo.get(k));
        }
        
        List<String> TContrato = Controlador.Utils.getDataCmb("ContractType","WType");        
        for(int k = 0; k<TContrato.size();k++){
           cmbTipoContrato.addItem(TContrato.get(k));
        }
        
        List<String> TTrabajo = Controlador.Utils.getDataCmb("workSubjects","WorkSubject");        
        for(int k = 0; k<TTrabajo.size();k++){
           cmbTipoTrabajo.addItem(TTrabajo.get(k));
        }
        
        List<String> salario = Controlador.Utils.getDataCmb("SalaryState","Salary");        
        for(int k = 0; k<salario.size();k++){
           cmbSalario.addItem(salario.get(k));
        }
        
        
        List<String> hightype = Controlador.Utils.getDataCmb("HighType","HighType");        
        for(int k = 0; k<hightype.size();k++){
           cmbHighType.addItem(hightype.get(k));
        }
        
        List<String> progreso = Controlador.Utils.getDataCmb("Progress","Progress");        
        for(int k = 0; k<progreso.size();k++){
           cmbProgreso.addItem(progreso.get(k));
        }
        
        List<String> nlEstudio = Controlador.Utils.getDataCmb("studyLevels","studyLevel");        
        for(int k = 0; k<nlEstudio.size();k++){
           cmbNivelEstudio.addItem(nlEstudio.get(k));
        }
        JTPostulantes.setModel(Controlador.Utils.rtrnTqble("Postulants"));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAddPDF = new javax.swing.JPanel();
        BtnRegresarPost = new javax.swing.JButton();
        BtnLimpiarCampos = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        txtNombrePost = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCorreoPost = new javax.swing.JTextField();
        BtnImageAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbEstadoPost = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbDepartReside = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmbDepartPreferencia = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbPrefLaboral = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtApellidoPost = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbSalario = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cmbTipoTrabajo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cmbEstadoTrabajo = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cmbTipoContrato = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cmbProgreso = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtHabilidadGeneral = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtRama = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtHabilidadAdicional = new javax.swing.JTextField();
        CheckAlumni = new javax.swing.JCheckBox();
        lblImage = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cmbHighType = new javax.swing.JComboBox<>();
        txtContraseñaPost = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        cmbNivelEstudio = new javax.swing.JComboBox<>();
        BtnAddPDF = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTPostulantes = new javax.swing.JTable();
        txtID = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(239, 245, 213));

        lblAddPDF.setBackground(new java.awt.Color(239, 245, 213));
        lblAddPDF.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnRegresarPost.setText("Regresar");
        BtnRegresarPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarPostActionPerformed(evt);
            }
        });
        lblAddPDF.add(BtnRegresarPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        BtnLimpiarCampos.setText("Limpiar Campos");
        lblAddPDF.add(BtnLimpiarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, 124, 34));

        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        lblAddPDF.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, 124, 32));

        BtnActualizar.setText("Actualizar");
        lblAddPDF.add(BtnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 124, 33));
        lblAddPDF.add(txtNombrePost, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 176, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombres del postulante");
        lblAddPDF.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Correo del postulante");
        lblAddPDF.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Contraseña");
        lblAddPDF.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 91, -1));
        lblAddPDF.add(txtCorreoPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 176, -1));

        BtnImageAdd.setText("Agregar imagen");
        BtnImageAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnImageAddActionPerformed(evt);
            }
        });
        lblAddPDF.add(BtnImageAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 80, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Genero");
        lblAddPDF.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        lblAddPDF.add(cmbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 140, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Estado");
        lblAddPDF.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        lblAddPDF.add(cmbEstadoPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 140, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Departamento en donde reside");
        lblAddPDF.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        lblAddPDF.add(cmbDepartReside, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 140, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Departamento de preferencia");
        lblAddPDF.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, -1));

        lblAddPDF.add(cmbDepartPreferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 140, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Progreso");
        lblAddPDF.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, -1, -1));

        lblAddPDF.add(cmbPrefLaboral, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 140, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Apellidos del postulante");
        lblAddPDF.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));
        lblAddPDF.add(txtApellidoPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 176, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Habilidad general");
        jLabel10.setEnabled(false);
        lblAddPDF.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, -1, -1));

        lblAddPDF.add(cmbSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 140, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Estado de trabajo");
        lblAddPDF.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        lblAddPDF.add(cmbTipoTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 160, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Tipo de trabajo");
        lblAddPDF.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        lblAddPDF.add(cmbEstadoTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 190, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Tipo de contrato");
        lblAddPDF.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        lblAddPDF.add(cmbTipoContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 140, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Preferencias laborales");
        lblAddPDF.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        lblAddPDF.add(cmbProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 140, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Nivel universitario:");
        lblAddPDF.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, -1));

        txtHabilidadGeneral.setEnabled(false);
        lblAddPDF.add(txtHabilidadGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, 170, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Rama perteneciente");
        jLabel17.setEnabled(false);
        lblAddPDF.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        txtRama.setEnabled(false);
        lblAddPDF.add(txtRama, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 170, -1));

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Habilidad adicional");
        jLabel18.setEnabled(false);
        lblAddPDF.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, -1, -1));

        txtHabilidadAdicional.setEnabled(false);
        lblAddPDF.add(txtHabilidadAdicional, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 170, -1));

        CheckAlumni.setText("Ex-alumno");
        lblAddPDF.add(CheckAlumni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 110, 30));
        lblAddPDF.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 110, 100));

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Salario");
        lblAddPDF.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, -1, -1));

        lblAddPDF.add(cmbHighType, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 140, -1));
        lblAddPDF.add(txtContraseñaPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 170, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Nivel de estudio");
        lblAddPDF.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        lblAddPDF.add(cmbNivelEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 140, -1));

        BtnAddPDF.setText("Añadir PDF");
        BtnAddPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddPDFActionPerformed(evt);
            }
        });
        lblAddPDF.add(BtnAddPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, 124, 33));
        lblAddPDF.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, -1, -1));

        JTPostulantes.setModel(new javax.swing.table.DefaultTableModel(
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
        JTPostulantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTPostulantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTPostulantes);

        lblAddPDF.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 940, -1));
        lblAddPDF.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 90, -1));

        lblID.setForeground(new java.awt.Color(0, 0, 0));
        lblID.setText("ID:");
        lblAddPDF.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAddPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 1725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAddPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRegresarPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresarPostActionPerformed
        // TODO add your handling code here:
        Postulantes newfrm = new Postulantes();
        newfrm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnRegresarPostActionPerformed

    
    
    private String S = "";
    
    private void BtnImageAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnImageAddActionPerformed
        // TODO add your handling code here:
        JFileChooser browseImageFile = new JFileChooser();        //Filter image extensions
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        browseImageFile.addChoosableFileFilter(fnef);
        int num = browseImageFile.showOpenDialog(null);

        if (num == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();
            String selectedImagePath = selectedImageFile.getAbsolutePath();
            //Display image on jlable
            ImageIcon ii = new ImageIcon(selectedImagePath);
//            Resize image to fit jlabel
            Image image = ii.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);

            try {
                BufferedImage image1 = ImageIO.read(selectedImageFile);

                byte[] immAsBytes;
                //use another encoding if JPG is innappropriate for you
                try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                    //use another encoding if JPG is innappropriate for you
                    ImageIO.write(image1, "jpg", baos );
                    baos.flush();
                    immAsBytes = baos.toByteArray();

                }
                try {
                    S = Base64.getEncoder().encodeToString(immAsBytes);
                    
                } catch (Exception e) {
                }

            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

            lblImage.setIcon(new ImageIcon(image));

        }
    }//GEN-LAST:event_BtnImageAddActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        // TODO add your handling code here:
        HashMap<String,String> All = new HashMap<>();
        HashMap<String,String> Required = new HashMap<>();
        All = CollectAll();
        Required = CollectRequired();
        
        int res;
        try {
            if (!Controlador.Utils.emptyFields(Required)) {                
                 res = Controlador.ControladorPostulante.AgreparPostulante(All);
                 JOptionPane.showInternalMessageDialog(null, "Postulante registrado correctamente.", "Confirmacion", 1);
            }else{
                JOptionPane.showInternalMessageDialog(null, "Por Favor, revisa que todos los campos esten llenos.", "Error.", 0);
            }
        } catch (Exception ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnAddPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddPDFActionPerformed
        // TODO add your handling code here:
//        JFileChooser browseImageFile = new JFileChooser();        //Filter image extensions
//        FileNameExtensionFilter fnef = new FileNameExtensionFilter("PDF", "pdf");
//        browseImageFile.addChoosableFileFilter(fnef);
//        int num = browseImageFile.showOpenDialog(null);
//
//        if (num == JFileChooser.APPROVE_OPTION) {
//            File selectedImageFile = browseImageFile.getSelectedFile();
//            String selectedImagePath = selectedImageFile.getAbsolutePath();
//            //Display image on jlable
//            ImageIcon ii = new ImageIcon(selectedImagePath);
////            Resize image to fit jlabel
//            Image image = ii.getImage().getScaledInstance(lblAddPDF.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
//
//            try {
//                BufferedImage image1 = ImageIO.read(selectedImageFile);
//
//                byte[] immAsBytes;
//                //use another encoding if JPG is innappropriate for you
//                try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
//                    //use another encoding if JPG is innappropriate for you
//                    ImageIO.write(image1, "pdf", baos );
//                    baos.flush();
//                    immAsBytes = baos.toByteArray();
//
//                }
//                try {
//                    S = Base64.getEncoder().encodeToString(immAsBytes);
//                    
//                } catch (Exception e) {
//                }
//
//            } catch (IOException ex) {
//                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            lblAddPDF.setIcon(new ImageIcon(image));
//
//        }
    }//GEN-LAST:event_BtnAddPDFActionPerformed

    private void JTPostulantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTPostulantesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==1) {
            JTable Table = (JTable) evt.getSource();
            txtID.setText(Table.getModel().getValueAt(Table.getSelectedRow(),0).toString());
            txtNombrePost.setText(Table.getModel().getValueAt(Table.getSelectedRow(),1).toString());
            txtCorreoPost.setText(Table.getModel().getValueAt(Table.getSelectedRow(),2).toString());
            txtContraseñaPost.setText(Table.getModel().getValueAt(Table.getSelectedRow(),3).toString());
            lblImage.setText(Table.getModel().getValueAt(Table.getSelectedRow(),4).toString());
            cmbGenero.addItem(Table.getModel().getValueAt(Table.getSelectedRow(),8).toString());
            cmbEstadoPost.addItem(Table.getModel().getValueAt(Table.getSelectedRow(),9).toString());
            CheckAlumni.setText(Table.getModel().getValueAt(Table.getSelectedRow(),10).toString());
            cmbDepartPreferencia.addItem(Table.getModel().getValueAt(Table.getSelectedRow(),11).toString());
            cmbDepartReside.addItem(Table.getModel().getValueAt(Table.getSelectedRow(),12).toString());
            cmbTipoTrabajo.addItem(Table.getModel().getValueAt(Table.getSelectedRow(),13).toString());
            cmbProgreso.addItem(Table.getModel().getValueAt(Table.getSelectedRow(),14).toString());
            cmbSalario.addItem(Table.getModel().getValueAt(Table.getSelectedRow(),15).toString());
            cmbHighType.addItem(Table.getModel().getValueAt(Table.getSelectedRow(),16).toString());
            cmbTipoContrato.addItem(Table.getModel().getValueAt(Table.getSelectedRow(),17).toString());
            cmbPrefLaboral.addItem(Table.getModel().getValueAt(Table.getSelectedRow(),18).toString());
            cmbNivelEstudio.addItem(Table.getModel().getValueAt(Table.getSelectedRow(),19).toString());
            cmbEstadoTrabajo.addItem(Table.getModel().getValueAt(Table.getSelectedRow(),20).toString());
            txtApellidoPost.setText(Table.getModel().getValueAt(Table.getSelectedRow(),21).toString());
            


        }
    }//GEN-LAST:event_JTPostulantesMouseClicked

    private HashMap<String,String> CollectAll() {             
        HashMap<String,String> data =  new HashMap<>();
        char[] pword = txtContraseñaPost.getPassword();
        
        data.put("namePostulant", txtNombrePost.getText());        
        data.put("mailpostulant", txtCorreoPost.getText());
        data.put("Pword", Utils.encrypt(pword));
        data.put("imgByte", S);
        data.put("resumePDF", "");
        data.put("resumeDetails", "");         
        data.put("mailverification", "0");
        data.put("Gender", String.valueOf(cmbGenero.getSelectedIndex() + 1));
        data.put("States", String.valueOf(cmbEstadoPost.getSelectedIndex() + 1));
        data.put("Alumni", CheckAlumni.isSelected() ? "1" : "0");
        data.put("RDepartment", String.valueOf(cmbDepartPreferencia.getSelectedIndex() + 1));
        data.put("IDepartment", String.valueOf(cmbDepartReside.getSelectedIndex() + 1));
        data.put("WSubject", String.valueOf(cmbTipoTrabajo.getSelectedIndex() + 1));
        data.put("Progress",String.valueOf(cmbProgreso.getSelectedIndex() + 1));
        data.put("Salary", String.valueOf(cmbSalario.getSelectedIndex() + 1));
        data.put("HighType", String.valueOf(cmbHighType.getSelectedIndex() + 1));
        data.put("ContractType", String.valueOf(cmbTipoContrato.getSelectedIndex() + 1));
        data.put("WorkPreference", String.valueOf(cmbPrefLaboral.getSelectedIndex() + 1));
        data.put("StudyLevel", String.valueOf(cmbNivelEstudio.getSelectedIndex() + 1));
        data.put("WorkStatus", String.valueOf(cmbEstadoTrabajo.getSelectedIndex() + 1));
        data.put("lastName", txtApellidoPost.getText());

      
        return data;
    }
    
    private HashMap<String,String> CollectRequired() {             
        HashMap<String,String> data =  new HashMap<>();
        char[] pword = txtContraseñaPost.getPassword();
        
        data.put("namePostulant", txtNombrePost.getText());        
        data.put("mailpostulant", txtCorreoPost.getText());
        data.put("Pword", Utils.encrypt(pword));
//        data.put("imgByte", S);        
        data.put("Gender", String.valueOf(cmbGenero.getSelectedIndex() + 1));
        data.put("States", String.valueOf(cmbEstadoPost.getSelectedIndex() + 1));
        data.put("Alumni", CheckAlumni.isSelected() ? "1" : "0");
        data.put("RDepartment", String.valueOf(cmbDepartReside.getSelectedIndex() + 1));
        data.put("IDepartment", String.valueOf(cmbDepartPreferencia.getSelectedIndex() + 1));
        data.put("WSubject", String.valueOf(cmbTipoTrabajo.getSelectedIndex() + 1));
        data.put("Progress",String.valueOf(cmbProgreso.getSelectedIndex() + 1));
        data.put("Salary", String.valueOf(cmbSalario.getSelectedIndex() + 1));
        data.put("HighType", String.valueOf(cmbHighType.getSelectedIndex() + 1));
        data.put("ContractType", String.valueOf(cmbTipoContrato.getSelectedIndex() + 1));
        data.put("WorkPreference", String.valueOf(cmbPrefLaboral.getSelectedIndex() + 1));
        data.put("StudyLevel", String.valueOf(cmbNivelEstudio.getSelectedIndex() + 1));
        data.put("WorkStatus", String.valueOf(cmbEstadoTrabajo.getSelectedIndex() + 1));
        data.put("lastName", txtApellidoPost.getText());
     
        return data;
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
            java.util.logging.Logger.getLogger(PostulanteCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PostulanteCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PostulanteCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PostulanteCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PostulanteCRUD(inti).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(PostulanteCRUD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnAddPDF;
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnImageAdd;
    private javax.swing.JButton BtnLimpiarCampos;
    private javax.swing.JButton BtnRegresarPost;
    private javax.swing.JCheckBox CheckAlumni;
    private javax.swing.JTable JTPostulantes;
    private javax.swing.JComboBox<String> cmbDepartPreferencia;
    private javax.swing.JComboBox<String> cmbDepartReside;
    private javax.swing.JComboBox<String> cmbEstadoPost;
    private javax.swing.JComboBox<String> cmbEstadoTrabajo;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JComboBox<String> cmbHighType;
    private javax.swing.JComboBox<String> cmbNivelEstudio;
    private javax.swing.JComboBox<String> cmbPrefLaboral;
    private javax.swing.JComboBox<String> cmbProgreso;
    private javax.swing.JComboBox<String> cmbSalario;
    private javax.swing.JComboBox<String> cmbTipoContrato;
    private javax.swing.JComboBox<String> cmbTipoTrabajo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel lblAddPDF;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextField txtApellidoPost;
    private javax.swing.JPasswordField txtContraseñaPost;
    private javax.swing.JTextField txtCorreoPost;
    private javax.swing.JTextField txtHabilidadAdicional;
    private javax.swing.JTextField txtHabilidadGeneral;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombrePost;
    private javax.swing.JTextField txtRama;
    // End of variables declaration//GEN-END:variables
}
