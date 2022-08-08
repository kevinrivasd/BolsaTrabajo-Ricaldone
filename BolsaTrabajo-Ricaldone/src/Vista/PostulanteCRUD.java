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
import org.xml.sax.Attributes;
import java.util.ArrayList;
import java.util.Arrays;
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
    public HashMap<Integer,String> dataGender;
    public HashMap<Integer,String> dataStatus;
    public HashMap<Integer,String> datapreflaboral;
    public HashMap<Integer,String> dptoPreferencia;
    public HashMap<Integer,String> dptoReside;
    public HashMap<Integer,String> EstadoTrabajo;
    public HashMap<Integer,String> TContrato;
    public HashMap<Integer,String> TTrabajo;
    public HashMap<Integer,String> salario;
    public HashMap<Integer,String> hightype;
    public HashMap<Integer,String> progreso;
    public HashMap<Integer,String> nlEstudio;
    public HashMap<Integer,String> RamaPost;
    public HashMap<Integer,String> HAdicional;
    public HashMap<Integer,String> HGeneral;
    public String[] arrG = {"Skill","idLevel"};
    public String[] arrA = {"NameSkill","idLevel"};
    public String[] Branch = {"Branch","idLevel"};
    
    public PostulanteCRUD(int add) throws Exception {
        initComponents();
        txtID.setVisible(false);
        lblID.setVisible(false);
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnG.setEnabled(false);
        
        inti = add;
        if (inti == 1) {
            BtnActualizar.setVisible(true);
        }
        else{
            BtnAgregar.setVisible(false);
        }
        this.setLocationRelativeTo(null);
        setTitle("Gestion de postulantes");
        
        dataGender = Controlador.Utils.getDataTable("Genders");        
        for(int k = 1; k<=dataGender.size();k++){
           cmbGenero.addItem(dataGender.get(k));
       }
        datapreflaboral = Controlador.Utils.getDataTable("WorkPreference");        
        for(int k = 1; k<=datapreflaboral.size();k++){
           cmbPrefLaboral.addItem(datapreflaboral.get(k));
        }
        
        dataStatus = Controlador.Utils.getDataTable("States");        
        for(int k = 1; k<=dataStatus.size();k++){
           cmbEstadoPost.addItem(dataStatus.get(k));
        }
        
        dptoPreferencia = Controlador.Utils.getDataTable("Departments");        
        for(int k = 1; k<=dptoPreferencia.size();k++){
           cmbDepartPreferencia.addItem(dptoPreferencia.get(k));
        }
        
        dptoReside = Controlador.Utils.getDataTable("Departments");        
        for(int k = 1; k<=dptoReside.size();k++){
           cmbDepartReside.addItem(dptoReside.get(k));
        }
        
        EstadoTrabajo = Controlador.Utils.getDataTable("WorkState");        
        for(int k = 1; k<=EstadoTrabajo.size();k++){
           cmbEstadoTrabajo.addItem(EstadoTrabajo.get(k));
        }
        
        TContrato = Controlador.Utils.getDataTable("ContractType");        
        for(int k = 1; k<=TContrato.size();k++){
           cmbTipoContrato.addItem(TContrato.get(k));
        }
        
        TTrabajo = Controlador.Utils.getDataTable("workSubjects");        
        for(int k = 1; k<=TTrabajo.size();k++){
           cmbTipoTrabajo.addItem(TTrabajo.get(k));
        }
        
        salario = Controlador.Utils.getDataTable("SalaryState");        
        for(int k = 1; k<=salario.size();k++){
           cmbSalario.addItem(salario.get(k));
        }
        
        
        hightype = Controlador.Utils.getDataTable("HighType");        
        for(int k = 1; k<=hightype.size();k++){
           cmbHighType.addItem(hightype.get(k));
        }
        
        progreso = Controlador.Utils.getDataTable("Progress");        
        for(int k = 1; k<=progreso.size();k++){
           cmbProgreso.addItem(progreso.get(k));
        }
        
        nlEstudio = Controlador.Utils.getDataTable("studyLevels");        
        for(int k = 1; k<=nlEstudio.size();k++){
           cmbNivelEstudio.addItem(nlEstudio.get(k));
        }
        
       

        JTPostulantes.setModel(Controlador.Utils.rtrnTqble("Postulants"));
        
        txtContraseñaPost.setTransferHandler(null);
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
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
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
        btnB = new javax.swing.JButton();
        btnA = new javax.swing.JButton();
        btnG = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        BTabla = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        GTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        ATable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(239, 245, 213));

        lblAddPDF.setBackground(new java.awt.Color(239, 245, 213));

        BtnRegresarPost.setText("Regresar");
        BtnRegresarPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarPostActionPerformed(evt);
            }
        });

        BtnLimpiarCampos.setText("Limpiar Campos");

        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Nombres del postulante");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Correo del postulante");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Contraseña");

        BtnImageAdd.setText("Agregar imagen");
        BtnImageAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnImageAddActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Genero");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Estado");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Departamento en donde reside");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Departamento de preferencia");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Progreso");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Apellidos del postulante");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Habilidad general");

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Estado de trabajo");

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setText("Tipo de trabajo");

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setText("Tipo de contrato");

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setText("Preferencias laborales");

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setText("Nivel universitario:");

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setText("Rama perteneciente");

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel18.setText("Habilidad adicional");

        CheckAlumni.setText("Ex-alumno");

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel19.setText("Salario");

        txtContraseñaPost.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtContraseñaPostInputMethodTextChanged(evt);
            }
        });
        txtContraseñaPost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaPostKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Nivel de estudio");

        BtnAddPDF.setText("Añadir PDF");
        BtnAddPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddPDFActionPerformed(evt);
            }
        });

        JTPostulantes.setBackground(new java.awt.Color(84, 118, 8));
        JTPostulantes.setForeground(new java.awt.Color(255, 255, 255));
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
        JTPostulantes.setGridColor(new java.awt.Color(255, 255, 255));
        JTPostulantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTPostulantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTPostulantes);

        lblID.setText("ID:");

        btnB.setText("Actualizar Rama");

        btnA.setText("Actualizar Habilidad Adicional");
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });

        btnG.setText("Actualizar Habilidad General");
        btnG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGActionPerformed(evt);
            }
        });

        BTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(BTabla);

        GTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(GTable);

        ATable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(ATable);

        javax.swing.GroupLayout lblAddPDFLayout = new javax.swing.GroupLayout(lblAddPDF);
        lblAddPDF.setLayout(lblAddPDFLayout);
        lblAddPDFLayout.setHorizontalGroup(
            lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblAddPDFLayout.createSequentialGroup()
                .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblAddPDFLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnRegresarPost)
                            .addGroup(lblAddPDFLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtNombrePost, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtApellidoPost, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtCorreoPost, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContraseñaPost, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CheckAlumni, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblID)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(62, 62, 62)
                        .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(cmbEstadoPost, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(cmbTipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(cmbNivelEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(cmbTipoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(cmbSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(cmbPrefLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(cmbEstadoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(cmbDepartReside, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cmbDepartPreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(cmbHighType, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(cmbProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnAddPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnLimpiarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnImageAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(lblAddPDFLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addGroup(lblAddPDFLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel17)
                            .addComponent(btnB, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(btnA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(btnG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        lblAddPDFLayout.setVerticalGroup(
            lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblAddPDFLayout.createSequentialGroup()
                .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblAddPDFLayout.createSequentialGroup()
                        .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lblAddPDFLayout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addComponent(jLabel20))
                            .addGroup(lblAddPDFLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(BtnRegresarPost)
                                .addGap(42, 42, 42)
                                .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(lblAddPDFLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(BtnImageAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(BtnAddPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtnLimpiarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(lblAddPDFLayout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addGap(1, 1, 1)
                                            .addComponent(cmbPrefLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel12)
                                            .addGap(1, 1, 1)
                                            .addComponent(cmbEstadoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel6)
                                            .addGap(1, 1, 1)
                                            .addComponent(cmbDepartReside, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(8, 8, 8)
                                            .addComponent(jLabel7)
                                            .addGap(1, 1, 1)
                                            .addComponent(cmbDepartPreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel16)
                                            .addGap(1, 1, 1)
                                            .addComponent(cmbHighType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel8)
                                            .addGap(1, 1, 1)
                                            .addComponent(cmbProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(lblAddPDFLayout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(1, 1, 1)
                                            .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel5)
                                            .addGap(1, 1, 1)
                                            .addComponent(cmbEstadoPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel14)
                                            .addGap(1, 1, 1)
                                            .addComponent(cmbTipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(8, 8, 8)
                                            .addComponent(jLabel11)
                                            .addGap(1, 1, 1)
                                            .addComponent(cmbNivelEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel13)
                                            .addGap(1, 1, 1)
                                            .addComponent(cmbTipoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel19)
                                            .addGap(1, 1, 1)
                                            .addComponent(cmbSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(lblAddPDFLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(1, 1, 1)
                                        .addComponent(txtNombrePost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addGap(1, 1, 1)
                                        .addComponent(txtApellidoPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addGap(1, 1, 1)
                                        .addComponent(txtCorreoPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addGap(1, 1, 1)
                                        .addComponent(txtContraseñaPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(CheckAlumni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(lblID)
                                        .addGap(4, 4, 4)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(lblAddPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnG, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnB, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(lblAddPDFLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAddPDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAddPDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRegresarPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresarPostActionPerformed
        // TODO add your handling code here:
        Postulantes newfrm = new Postulantes();
        newfrm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnRegresarPostActionPerformed
    
    public void LimpiarCampos(){
        txtNombrePost.setText("");
        txtApellidoPost.setText("");
        txtContraseñaPost.setText("");
        txtCorreoPost.setText("");
    }
    
    
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
        All = CollectAllAdd();
        Required = CollectRequiredAdd();
        
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
        try {
            JTPostulantes.setModel(Controlador.Utils.rtrnTqble("Postulants"));
        } catch (Exception ex) {
            Logger.getLogger(PostulanteCRUD.class.getName()).log(Level.SEVERE, null, ex);
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
            btnA.setEnabled(true);
            btnB.setEnabled(true);
            btnG.setEnabled(true);
            JTable Table = (JTable) evt.getSource();
            txtID.setText(Table.getModel().getValueAt(Table.getSelectedRow(),0).toString());
            txtNombrePost.setText(Table.getModel().getValueAt(Table.getSelectedRow(),1).toString());
            txtCorreoPost.setText(Table.getModel().getValueAt(Table.getSelectedRow(),2).toString());
            txtContraseñaPost.setText(Table.getModel().getValueAt(Table.getSelectedRow(),3).toString());
            lblImage.setText(Table.getModel().getValueAt(Table.getSelectedRow(),4).toString());
            cmbGenero.setSelectedItem(dataGender.get(Integer.valueOf(Table.getModel().getValueAt(Table.getSelectedRow(),8).toString())));
            cmbEstadoPost.setSelectedItem(dataStatus.get(Integer.valueOf(Table.getModel().getValueAt(Table.getSelectedRow(),9).toString())));
            CheckAlumni.setText(Table.getModel().getValueAt(Table.getSelectedRow(),10).toString());
            cmbDepartPreferencia.setSelectedItem(dptoPreferencia.get(Integer.valueOf(Table.getModel().getValueAt(Table.getSelectedRow(),11).toString())));
            cmbDepartReside.setSelectedItem(dptoReside.get(Integer.valueOf(Table.getModel().getValueAt(Table.getSelectedRow(),12).toString())));
            cmbTipoTrabajo.setSelectedItem(TTrabajo.get(Integer.valueOf(Table.getModel().getValueAt(Table.getSelectedRow(),13).toString())));
            cmbProgreso.setSelectedItem(progreso.get(Integer.valueOf(Table.getModel().getValueAt(Table.getSelectedRow(),14).toString())));
            cmbSalario.setSelectedItem(salario.get(Integer.valueOf(Table.getModel().getValueAt(Table.getSelectedRow(),15).toString())));
            cmbHighType.setSelectedItem(hightype.get(Integer.valueOf(Table.getModel().getValueAt(Table.getSelectedRow(),16).toString())));
            cmbTipoContrato.setSelectedItem(TContrato.get(Integer.valueOf(Table.getModel().getValueAt(Table.getSelectedRow(),17).toString())));
            cmbPrefLaboral.setSelectedItem(datapreflaboral.get(Integer.valueOf(Table.getModel().getValueAt(Table.getSelectedRow(),18).toString())));
            cmbNivelEstudio.setSelectedItem(nlEstudio.get(Integer.valueOf(Table.getModel().getValueAt(Table.getSelectedRow(),19).toString())));
            cmbEstadoTrabajo.setSelectedItem(EstadoTrabajo.get(Integer.valueOf(Table.getModel().getValueAt(Table.getSelectedRow(),20).toString())));
            txtApellidoPost.setText(Table.getModel().getValueAt(Table.getSelectedRow(),21).toString());
            try {
                GTable.setModel(Controlador.Utils.rtrnTqble("GeneralSkills", arrG, txtID.getText()));
                ATable.setModel(Controlador.Utils.rtrnTqble("AditionalSkills", arrA, txtID.getText()));
                BTabla.setModel(Controlador.Utils.rtrnTqble("Branches", Branch, txtID.getText()));
            } catch (Exception ex) {
                Logger.getLogger(PostulanteCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JTPostulantesMouseClicked

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        // TODO add your handling code here:
        HashMap<String,String> All = new HashMap<>();
        HashMap<String,String> Required = new HashMap<>();
        All = CollectAllUpdate();
        Required = CollectRequiredUptade();
        
        int res;
        try {
            if (!Controlador.Utils.emptyFields(Required)) {                
                 res = Controlador.ControladorPostulante.ActualizarPostulante(All);
                 JOptionPane.showInternalMessageDialog(null, "Postulante actualizado exitosamente", "Confirmacion", 1);
            }else{
                JOptionPane.showInternalMessageDialog(null, "Por Favor, revisa que todos los campos esten llenos.", "Error.", 0);
            }
        } catch (Exception ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            JTPostulantes.setModel(Controlador.Utils.rtrnTqble("Postulants"));
        } catch (Exception ex) {
            Logger.getLogger(PostulanteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnActualizarActionPerformed

    private void txtContraseñaPostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaPostKeyPressed
        // TODO add your handling code here:
        char[] txt = txtContraseñaPost.getPassword();
           if (txt.length == 6) {
                txt = Arrays.copyOf(txt, txt.length - 1);
        }
           txtContraseñaPost.setText(String.valueOf(txt));
//           JOptionPane.showMessageDialog(null, String.valueOf(txt));
    }//GEN-LAST:event_txtContraseñaPostKeyPressed

    private void txtContraseñaPostInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtContraseñaPostInputMethodTextChanged
        // TODO add your handling code here:
        char[] txt = txtContraseñaPost.getPassword();
           if (txt.length == 6) {
                txt = Arrays.copyOf(txt, txt.length - 1);
        }
           txtContraseñaPost.setText(String.valueOf(txt));

           JOptionPane.showMessageDialog(null, String.valueOf(txt));
    }//GEN-LAST:event_txtContraseñaPostInputMethodTextChanged
    

    
    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
         String idPos = txtID.getText(); 
        try {
            // TODO add your handling code here:
            AbilitiesCRUD frm = new AbilitiesCRUD(0,idPos);
            frm.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(PostulanteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAActionPerformed

    private void btnGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGActionPerformed
        String idPos = txtID.getText(); 
        try {
            // TODO add your handling code here:
            AbilitiesCRUD frm = new AbilitiesCRUD(2, idPos);
            frm.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(PostulanteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGActionPerformed

    private HashMap<String, String> CollectAllAdd() {
        HashMap<String, String> data = new HashMap<>();
        char[] pword = txtContraseñaPost.getPassword();

        data.put("namePostulant", txtNombrePost.getText());
        data.put("mailPostulant", txtCorreoPost.getText());
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
        data.put("Progress", String.valueOf(cmbProgreso.getSelectedIndex() + 1));
        data.put("Salary", String.valueOf(cmbSalario.getSelectedIndex() + 1));
        data.put("HighType", String.valueOf(cmbHighType.getSelectedIndex() + 1));
        data.put("ContractType", String.valueOf(cmbTipoContrato.getSelectedIndex() + 1));
        data.put("WorkPreference", String.valueOf(cmbPrefLaboral.getSelectedIndex() + 1));
        data.put("StudyLevel", String.valueOf(cmbNivelEstudio.getSelectedIndex() + 1));
        data.put("WorkStatus", String.valueOf(cmbEstadoTrabajo.getSelectedIndex() + 1));
        data.put("lastName", txtApellidoPost.getText());

        return data;
    }
     private HashMap<String, String> CollectAllUpdate() {
        HashMap<String, String> data = new HashMap<>();
        char[] pword = txtContraseñaPost.getPassword();

        data.put("namePostulant", txtNombrePost.getText());
        data.put("mailPostulant", txtCorreoPost.getText());
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
        data.put("Progress", String.valueOf(cmbProgreso.getSelectedIndex() + 1));
        data.put("Salary", String.valueOf(cmbSalario.getSelectedIndex() + 1));
        data.put("HighType", String.valueOf(cmbHighType.getSelectedIndex() + 1));
        data.put("ContractType", String.valueOf(cmbTipoContrato.getSelectedIndex() + 1));
        data.put("WorkPreference", String.valueOf(cmbPrefLaboral.getSelectedIndex() + 1));
        data.put("StudyLevel", String.valueOf(cmbNivelEstudio.getSelectedIndex() + 1));
        data.put("WorkStatus", String.valueOf(cmbEstadoTrabajo.getSelectedIndex() + 1));
        data.put("lastName", txtApellidoPost.getText());
        data.put("idPostulant", String.valueOf(txtID.getText()));

        return data;
    }
    
    private HashMap<String, String> CollectRequiredAdd() {
        HashMap<String, String> data = new HashMap<>();
        char[] pword = txtContraseñaPost.getPassword();

        data.put("namePostulant", txtNombrePost.getText());
        data.put("mailPostulant", txtCorreoPost.getText());
        data.put("Pword", Utils.encrypt(pword));
//        data.put("imgByte", S);        
        data.put("Gender", String.valueOf(cmbGenero.getSelectedIndex() + 1));
        data.put("States", String.valueOf(cmbEstadoPost.getSelectedIndex() + 1));
        data.put("Alumni", CheckAlumni.isSelected() ? "1" : "0");
        data.put("RDepartment", String.valueOf(cmbDepartReside.getSelectedIndex() + 1));
        data.put("IDepartment", String.valueOf(cmbDepartPreferencia.getSelectedIndex() + 1));
        data.put("WSubject", String.valueOf(cmbTipoTrabajo.getSelectedIndex() + 1));
        data.put("Progress", String.valueOf(cmbProgreso.getSelectedIndex() + 1));
        data.put("Salary", String.valueOf(cmbSalario.getSelectedIndex() + 1));
        data.put("HighType", String.valueOf(cmbHighType.getSelectedIndex() + 1));
        data.put("ContractType", String.valueOf(cmbTipoContrato.getSelectedIndex() + 1));
        data.put("WorkPreference", String.valueOf(cmbPrefLaboral.getSelectedIndex() + 1));
        data.put("StudyLevel", String.valueOf(cmbNivelEstudio.getSelectedIndex() + 1));
        data.put("WorkStatus", String.valueOf(cmbEstadoTrabajo.getSelectedIndex() + 1));
        data.put("lastName", txtApellidoPost.getText());

        return data;
    }
    
    private HashMap<String, String> CollectRequiredUptade() {
        HashMap<String, String> data = new HashMap<>();
        char[] pword = txtContraseñaPost.getPassword();

        data.put("namePostulant", txtNombrePost.getText());
        data.put("mailPostulant", txtCorreoPost.getText());
        data.put("Pword",Utils.encrypt(pword));
//        data.put("imgByte", S);        
        data.put("Gender", String.valueOf(cmbGenero.getSelectedIndex() + 1));
        data.put("States", String.valueOf(cmbEstadoPost.getSelectedIndex() + 1));
        data.put("Alumni", CheckAlumni.isSelected() ? "1" : "0");
        data.put("RDepartment", String.valueOf(cmbDepartReside.getSelectedIndex() + 1));
        data.put("IDepartment", String.valueOf(cmbDepartPreferencia.getSelectedIndex() + 1));
        data.put("WSubject", String.valueOf(cmbTipoTrabajo.getSelectedIndex() + 1));
        data.put("Progress", String.valueOf(cmbProgreso.getSelectedIndex() + 1));
        data.put("Salary", String.valueOf(cmbSalario.getSelectedIndex() + 1));
        data.put("HighType", String.valueOf(cmbHighType.getSelectedIndex() + 1));
        data.put("ContractType", String.valueOf(cmbTipoContrato.getSelectedIndex() + 1));
        data.put("WorkPreference", String.valueOf(cmbPrefLaboral.getSelectedIndex() + 1));
        data.put("StudyLevel", String.valueOf(cmbNivelEstudio.getSelectedIndex() + 1));
        data.put("WorkStatus", String.valueOf(cmbEstadoTrabajo.getSelectedIndex() + 1));
        data.put("lastName", txtApellidoPost.getText());
        data.put("idPostulant", String.valueOf(txtID.getText()));

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
    private javax.swing.JTable ATable;
    private javax.swing.JTable BTabla;
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnAddPDF;
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnImageAdd;
    private javax.swing.JButton BtnLimpiarCampos;
    private javax.swing.JButton BtnRegresarPost;
    private javax.swing.JCheckBox CheckAlumni;
    private javax.swing.JTable GTable;
    private javax.swing.JTable JTPostulantes;
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnB;
    private javax.swing.JButton btnG;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel lblAddPDF;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextField txtApellidoPost;
    private javax.swing.JPasswordField txtContraseñaPost;
    private javax.swing.JTextField txtCorreoPost;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombrePost;
    // End of variables declaration//GEN-END:variables
}
