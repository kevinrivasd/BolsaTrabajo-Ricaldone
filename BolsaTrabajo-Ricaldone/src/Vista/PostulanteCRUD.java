/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorPostulante;
import Controlador.Utils;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import org.xml.sax.Attributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import Controlador.Utils;
import Controlador.ControladorPostulante;

/**
 * Form to manage applicants
 *
 * @author Jonathan
 */
public class PostulanteCRUD extends javax.swing.JFrame {

    /**
     * Creates new form PostulanteCRUD
     */
    private static int inti;
    DefaultTableModel base;
    public HashMap<Integer, String> dataGender;
    public HashMap<Integer, String> dataStatus;
    public HashMap<Integer, String> datapreflaboral;
    public HashMap<Integer, String> dptoPreferencia;
    public HashMap<Integer, String> dptoReside;
    public HashMap<Integer, String> EstadoTrabajo;
    public HashMap<Integer, String> TContrato;
    public HashMap<Integer, String> TTrabajo;
    public HashMap<Integer, String> salario;
    public HashMap<Integer, String> hightype;
    public HashMap<Integer, String> progreso;
    public HashMap<Integer, String> nlEstudio;
    public HashMap<Integer, String> RamaPost;
    public HashMap<Integer, String> HAdicional;
    public HashMap<Integer, String> HGeneral;
    public String[] arrG = {"Skill", "idLevel"};
    public String[] arrA = {"NameSkill", "idLevel"};
    public String[] Branch = {"Branch", "idLevel"};
    DefaultTableModel post;
    ControladorPostulante postcontroller = new ControladorPostulante();
    Utils utils = new Utils();

    /**
     * Load combo box and hide graphic objects
     *
     * @param add
     */
    public PostulanteCRUD(int add) {
        initComponents();
        this.setLocationRelativeTo(null);
        txtID.setVisible(false);
        lblID.setVisible(false);
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnG.setEnabled(false);
        txtContractType.setVisible(false);
        txtIDepartment.setVisible(false);
        txtRDepartment.setVisible(false);
        txtestado.setVisible(false);
        txtgenero.setVisible(false);
        txthigtType.setVisible(false);
        txtprogress.setVisible(false);
        txtsalary.setVisible(false);
        txtstudylevel.setVisible(false);
        txtworkPreference.setVisible(false);
        txtworkState.setVisible(false);
        txtworktype.setVisible(false);

        String[] Encabezados = {"ID", "Nombre del postulante", "COrreo del postulante", "Contraseña", "Foto", "Resumen PDF", "Resumen detalles", "Verificacion de correo", "Genero", "Estado", "Ex-Alumno", "Departamento de preferencia", "Departamento de residencia", "Trabajo", "Progreso", "Salario", "Bachillerato", "Tipo de trabajo", "Preferencia laboral", "Nivel de estudio", "Estado del trabajo", "Apellido"};
        post = new DefaultTableModel(null, Encabezados);
        JTPostulantes.setModel(post);
        CargarTabla();
        inti = add;
        if (inti == 1) {
            BtnActualizar.setVisible(true);
        } else {
            BtnAgregar.setVisible(false);
        }
        this.setLocationRelativeTo(null);
        setTitle("Gestion de postulantes");

        dataGender = utils.getDataTable("Genders");
        for (int k = 1; k <= dataGender.size(); k++) {
            cmbGenero.addItem(dataGender.get(k));
        }
        datapreflaboral = utils.getDataTable("WorkPreference");
        for (int k = 1; k <= datapreflaboral.size(); k++) {
            cmbPrefLaboral.addItem(datapreflaboral.get(k));
        }

        dataStatus = utils.getDataTable("States");
        for (int k = 1; k <= dataStatus.size(); k++) {
            cmbEstadoPost.addItem(dataStatus.get(k));
        }

        dptoPreferencia = utils.getDataTable("Departments");
        for (int k = 1; k <= dptoPreferencia.size(); k++) {
            cmbDepartPreferencia.addItem(dptoPreferencia.get(k));
        }

        dptoReside = utils.getDataTable("Departments");
        for (int k = 1; k <= dptoReside.size(); k++) {
            cmbDepartReside.addItem(dptoReside.get(k));
        }

        EstadoTrabajo = utils.getDataTable("WorkState");
        for (int k = 1; k <= EstadoTrabajo.size(); k++) {
            cmbEstadoTrabajo.addItem(EstadoTrabajo.get(k));
        }

        TContrato = utils.getDataTable("ContractType");
        for (int k = 1; k <= TContrato.size(); k++) {
            cmbTipoContrato.addItem(TContrato.get(k));
        }

        TTrabajo = utils.getDataTable("workSubjects");
        for (int k = 1; k <= TTrabajo.size(); k++) {
            cmbTipoTrabajo.addItem(TTrabajo.get(k));
        }

        salario = utils.getDataTable("SalaryState");
        for (int k = 1; k <= salario.size(); k++) {
            cmbSalario.addItem(salario.get(k));
        }

        hightype = utils.getDataTable("HighType");
        for (int k = 1; k <= hightype.size(); k++) {
            cmbHighType.addItem(hightype.get(k));
        }

        progreso = utils.getDataTable("Progress");
        for (int k = 1; k <= progreso.size(); k++) {
            cmbProgreso.addItem(progreso.get(k));
        }

        nlEstudio = utils.getDataTable("studyLevels");
        for (int k = 1; k <= nlEstudio.size(); k++) {
            cmbNivelEstudio.addItem(nlEstudio.get(k));
        }

//        JTPostulantes.setModel(Controlador.Utils.rtrnTqble("Postulants"));
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

        jScrollPane5 = new javax.swing.JScrollPane();
        lblTodo = new javax.swing.JPanel();
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
        lblPdf = new javax.swing.JLabel();
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
        lblImage = new javax.swing.JLabel();
        BtnLimpiarCampos = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtgenero = new javax.swing.JTextField();
        txtestado = new javax.swing.JTextField();
        txtstudylevel = new javax.swing.JTextField();
        txthigtType = new javax.swing.JTextField();
        txtworktype = new javax.swing.JTextField();
        txtsalary = new javax.swing.JTextField();
        txtworkPreference = new javax.swing.JTextField();
        txtworkState = new javax.swing.JTextField();
        txtRDepartment = new javax.swing.JTextField();
        txtIDepartment = new javax.swing.JTextField();
        txtContractType = new javax.swing.JTextField();
        txtprogress = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(239, 245, 213));

        lblTodo.setBackground(new java.awt.Color(239, 245, 213));
        lblTodo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        lblTodo.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 330, 140, 32));

        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });
        lblTodo.add(BtnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 140, 30));
        lblTodo.add(txtNombrePost, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 176, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Nombres del postulante");
        lblTodo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Correo del postulante");
        lblTodo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Contraseña");
        lblTodo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 91, -1));

        txtCorreoPost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoPostKeyPressed(evt);
            }
        });
        lblTodo.add(txtCorreoPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 176, -1));

        BtnImageAdd.setText("Agregar imagen");
        BtnImageAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnImageAddActionPerformed(evt);
            }
        });
        lblTodo.add(BtnImageAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 140, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Genero");
        lblTodo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        lblTodo.add(cmbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 180, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Estado");
        lblTodo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        lblTodo.add(cmbEstadoPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 180, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Departamento en donde reside");
        lblTodo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        lblTodo.add(cmbDepartReside, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 190, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Departamento de preferencia");
        lblTodo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        lblTodo.add(cmbDepartPreferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 190, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Progreso");
        lblTodo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, -1, -1));

        lblTodo.add(cmbPrefLaboral, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 190, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Apellidos del postulante");
        lblTodo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        lblTodo.add(txtApellidoPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 176, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Habilidad general");
        lblTodo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, -1));

        lblTodo.add(cmbSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 180, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Estado de trabajo");
        lblTodo.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, -1));

        lblTodo.add(cmbTipoTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 180, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setText("Tipo de trabajo");
        lblTodo.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        lblTodo.add(cmbEstadoTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 190, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setText("Tipo de contrato");
        lblTodo.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, -1, -1));

        lblTodo.add(cmbTipoContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 190, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setText("Preferencias laborales");
        lblTodo.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, -1, -1));

        lblTodo.add(cmbProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 190, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setText("Bachilerato:");
        lblTodo.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setText("Rama perteneciente");
        lblTodo.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel18.setText("Habilidad adicional");
        lblTodo.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, -1, -1));

        CheckAlumni.setText("Ex-alumno");
        lblTodo.add(CheckAlumni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 110, 30));
        CheckAlumni.setText("Ex-alumno");
        lblTodo.add(lblPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(701, 496, 100, 30));

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel19.setText("Salario");
        lblTodo.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        lblTodo.add(cmbHighType, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 180, -1));

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
        lblTodo.add(txtContraseñaPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 180, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Nivel de estudio");
        lblTodo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        lblTodo.add(cmbNivelEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 180, -1));

        BtnAddPDF.setText("Añadir PDF");
        BtnAddPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddPDFActionPerformed(evt);
            }
        });
        lblTodo.add(BtnAddPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 250, 140, 30));
        lblTodo.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 759, -1, -1));

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
        JTPostulantes.setGridColor(new java.awt.Color(0, 0, 0));
        JTPostulantes.setSelectionBackground(new java.awt.Color(193, 233, 118));
        JTPostulantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTPostulantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTPostulantes);

        lblTodo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 810, 150));
        lblTodo.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 90, -1));

        lblID.setText("ID:");
        lblTodo.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        btnB.setText("Gestionar Rama");
        btnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBActionPerformed(evt);
            }
        });
        lblTodo.add(btnB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 190, 34));

        btnA.setText("Gestionar Habilidad Adicional");
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });
        lblTodo.add(btnA, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 190, 34));

        btnG.setText("Gestionar Habilidad General");
        btnG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGActionPerformed(evt);
            }
        });
        lblTodo.add(btnG, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 560, 190, 34));

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
        BTabla.setGridColor(new java.awt.Color(0, 0, 0));
        BTabla.setSelectionBackground(new java.awt.Color(193, 233, 118));
        jScrollPane2.setViewportView(BTabla);

        lblTodo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 432, 190, 120));

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
        GTable.setGridColor(new java.awt.Color(0, 0, 0));
        GTable.setSelectionBackground(new java.awt.Color(193, 233, 118));
        jScrollPane3.setViewportView(GTable);

        lblTodo.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 190, 120));

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
        ATable.setGridColor(new java.awt.Color(0, 0, 0));
        ATable.setSelectionBackground(new java.awt.Color(193, 233, 118));
        jScrollPane4.setViewportView(ATable);

        lblTodo.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 190, 120));
        lblTodo.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 42, 124, 160));

        BtnLimpiarCampos.setText("Limpiar Campos");
        BtnLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarCamposActionPerformed(evt);
            }
        });
        lblTodo.add(BtnLimpiarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, 140, 30));

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Recu_regresar.png"))); // NOI18N
        jLabel21.setText("Regresar");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        lblTodo.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel22.setFont(new java.awt.Font("Poppins", 1, 30)); // NOI18N
        jLabel22.setText("Postulantes");
        lblTodo.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, -1));
        lblTodo.add(txtgenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));
        lblTodo.add(txtestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));
        lblTodo.add(txtstudylevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, -1, -1));
        lblTodo.add(txthigtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, -1));
        lblTodo.add(txtworktype, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, -1, -1));
        lblTodo.add(txtsalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, -1, -1));
        lblTodo.add(txtworkPreference, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));
        lblTodo.add(txtworkState, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));
        lblTodo.add(txtRDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 10, -1));
        lblTodo.add(txtIDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 10, -1));
        lblTodo.add(txtContractType, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, 20, -1));
        lblTodo.add(txtprogress, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 20, -1));

        jScrollPane5.setViewportView(lblTodo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Method to load the table
     */
    final void CargarTabla() {
        ControladorPostulante CargarPost = new ControladorPostulante();
        while (post.getRowCount() > 0) {
            post.removeRow(0);
        }
        try {
            ResultSet rs = CargarPost.TablaCRUD_VController();
            while (rs.next()) {
                Object[] oValores = {rs.getInt("idPostulant"), rs.getString("namePostulant"), rs.getString("mailPostulant"), rs.getString("Pword"), rs.getString("photoPostulant"), rs.getString("resumePDF"), rs.getString("resumeDetails"), rs.getInt("mailverification"), rs.getString("Gender"), rs.getString("States"), rs.getInt("Alumni"), rs.getInt("IDepartment"), rs.getInt("RDepartment"), rs.getString("WorkSubject"), rs.getString("Progress"), rs.getString("Salary"), rs.getString("HighType"), rs.getString("WType"), rs.getString("WPreference"), rs.getString("studyLevel"), rs.getString("WorkState"), rs.getString("lastName")};
                post.addRow(oValores);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    /**
     * Method for clearing fields and resetting combo box
     */
    public void LimpiarCampos() {
        lblPdf.setText("");
        txtNombrePost.setText("");
        lblImage.setIcon(new ImageIcon("src/recursos/candado.png"));
        txtApellidoPost.setText("");
        txtContraseñaPost.setText("");
        txtCorreoPost.setText("");
    }
    /**
     * Variable for image
     */
    private String S = "";

    /**
     * Method for inserting an image
     *
     * @param evt
     */
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
                try ( ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                    //use another encoding if JPG is innappropriate for you
                    ImageIO.write(image1, "jpg", baos);
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
    /**
     * Add applicant
     *
     * @param evt
     */
    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        // TODO add your handling code here:
        LinkedHashMap<String, String> All = new LinkedHashMap<>();
        LinkedHashMap<String, String> Required = new LinkedHashMap<>();
        All = CollectAllAdd();
        Required = CollectRequiredAdd();
        String mail = txtCorreoPost.getText();
        int res;
        try {
            if (!Controlador.Utils.emptyFields(Required)) {
                if (verificar_email(mail)) {
                    res = postcontroller.AgreparPostulante(All);
                    JOptionPane.showInternalMessageDialog(null, "Postulante registrado correctamente.", "Confirmacion", 1);
                    CargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor introduzca un correo valido", "Error", 0);
                }
            } else {
                JOptionPane.showInternalMessageDialog(null, "Por Favor, revisa que todos los campos esten llenos.", "Error.", 0);
            }

        } catch (Exception ex) {
            Logger.getLogger(UsuariosPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
        } catch (Exception ex) {
            Logger.getLogger(PostulanteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed
    /**
     * Variable for PDF
     */
    private String pdf = "";

    /**
     * Method to add PDF
     *
     * @param evt
     */
    private void BtnAddPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddPDFActionPerformed
//         TODO add your handling code here:
        JFileChooser browseImageFile = new JFileChooser();        //Filter image extensions
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("PDF", "pdf");
        browseImageFile.addChoosableFileFilter(fnef);
        int num = browseImageFile.showOpenDialog(null);

        if (num == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();
            String selectedImagePath = selectedImageFile.getAbsolutePath();
            byte[] inFileBytes;
            try {
                inFileBytes = Files.readAllBytes(Paths.get(selectedImagePath));
                byte[] encoded = java.util.Base64.getEncoder().encode(inFileBytes);
                pdf = Base64.getEncoder().encodeToString(inFileBytes);
                decodePdf();
            } catch (IOException ex) {
                Logger.getLogger(PostulanteCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }

            lblPdf.setText(selectedImagePath);
        }
    }//GEN-LAST:event_BtnAddPDFActionPerformed
    /**
     * Method to decode PDF
     *
     * @throws IOException
     */
    private void decodePdf() throws IOException {
        byte[] decoded = java.util.Base64.getDecoder().decode(pdf);

        FileOutputStream fos = new FileOutputStream("Archivo.pdf");
        fos.write(decoded);
        fos.flush();
        fos.close();
    }

    /**
     * Event to select rows
     *
     * @param evt
     */
    private void JTPostulantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTPostulantesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            btnA.setEnabled(true);
            btnB.setEnabled(true);
            btnG.setEnabled(true);
            JTable Table = (JTable) evt.getSource();
            txtID.setText(Table.getModel().getValueAt(Table.getSelectedRow(), 0).toString());
            txtNombrePost.setText(Table.getModel().getValueAt(Table.getSelectedRow(), 1).toString());
            txtCorreoPost.setText(Table.getModel().getValueAt(Table.getSelectedRow(), 2).toString());
//            txtContraseñaPost.setText(Table.getModel().getValueAt(Table.getSelectedRow(), 3).toString());
//            lblImage.setText(Table.getModel().getValueAt(Table.getSelectedRow(),4).toString());
            byte[] btDataFile;
            btDataFile = Base64.getDecoder().decode(Table.getModel().getValueAt(Table.getSelectedRow(), 4).toString());
            BufferedImage image = null;
            try {
                image = ImageIO.read(new ByteArrayInputStream(btDataFile));
                if (image != null) {
                    ImageIcon ii = new ImageIcon(image);
                    Image imagef = ii.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
                    lblImage.setIcon(new ImageIcon(imagef));
                } else {
                    lblImage.setIcon(new ImageIcon("src/recursos/candado.png"));
                }
            } catch (IOException ex) {

            }
            String genero = txtgenero.getText();
            cmbGenero.setSelectedItem(genero + 1);
            cmbGenero.setSelectedItem(Table.getModel().getValueAt(Table.getSelectedRow(), 8).toString());
            String estado = txtestado.getText();
            cmbEstadoPost.setSelectedItem(estado + 1);
            cmbEstadoPost.setSelectedItem(Table.getModel().getValueAt(Table.getSelectedRow(), 9).toString());
            if (Table.getModel().getValueAt(Table.getSelectedRow(), 10).toString().equals("true")) {
                CheckAlumni.setSelected(true);
            } else {
                CheckAlumni.setSelected(false);
            }
            String IDepartamento = txtIDepartment.getText();
            cmbDepartPreferencia.setSelectedItem(IDepartamento + 1);
            cmbDepartPreferencia.setSelectedItem(Table.getModel().getValueAt(Table.getSelectedRow(), 11).toString());
            String RDepartamento = txtRDepartment.getText();
            cmbDepartReside.setSelectedItem(RDepartamento + 1);
            cmbDepartReside.setSelectedItem(Table.getModel().getValueAt(Table.getSelectedRow(), 12).toString());
            String workType = txtworktype.getText();
            cmbTipoTrabajo.setSelectedItem(workType + 1);
            cmbTipoTrabajo.setSelectedItem(Table.getModel().getValueAt(Table.getSelectedRow(), 13).toString());
            String Progress = txtprogress.getText();
            cmbProgreso.setSelectedItem(Progress + 1);
            cmbProgreso.setSelectedItem(Table.getModel().getValueAt(Table.getSelectedRow(), 14).toString());
            String salario = txtsalary.getText();
            cmbSalario.setSelectedItem(salario + 1);
            cmbSalario.setSelectedItem(Table.getModel().getValueAt(Table.getSelectedRow(), 15).toString());
            String hightype = txthigtType.getText();
            cmbHighType.setSelectedItem(hightype + 1);
            cmbHighType.setSelectedItem(Table.getModel().getValueAt(Table.getSelectedRow(), 16).toString());
            String contractType = txtContractType.getText();
            cmbTipoContrato.setSelectedItem(contractType + 1);
            cmbTipoTrabajo.setSelectedItem(Table.getModel().getValueAt(Table.getSelectedRow(), 17).toString());
            String preflaboral = txtworkPreference.getText();
            cmbPrefLaboral.setSelectedItem(preflaboral + 1);
            cmbPrefLaboral.setSelectedItem(Table.getModel().getValueAt(Table.getSelectedRow(), 18).toString());
            String studylevel = txtstudylevel.getText();
            cmbNivelEstudio.setSelectedItem(studylevel + 1);
            cmbNivelEstudio.setSelectedItem(Table.getModel().getValueAt(Table.getSelectedRow(), 19).toString());
            String workstatus = txtworkState.getText();
            cmbEstadoTrabajo.setSelectedItem(workstatus + 1);
            cmbEstadoTrabajo.setSelectedItem(Table.getModel().getValueAt(Table.getSelectedRow(), 20).toString());
            txtApellidoPost.setText(Table.getModel().getValueAt(Table.getSelectedRow(), 21).toString());
            try {
                GTable.setModel(utils.rtrnTqble("GeneralSkills", arrG, txtID.getText()));
                ATable.setModel(utils.rtrnTqble("AditionalSkills", arrA, txtID.getText()));
                BTabla.setModel(utils.rtrnTqble("Branches", Branch, txtID.getText()));
            } catch (Exception ex) {
                Logger.getLogger(PostulanteCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JTPostulantesMouseClicked
    /**
     * Method to update
     *
     * @param evt
     */
    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        // TODO add your handling code here:
        LinkedHashMap<String, String> All = new LinkedHashMap<>();
        LinkedHashMap<String, String> Required = new LinkedHashMap<>();
        All = CollectAllUpdate();
        Required = CollectRequiredUptade();
        String mail = txtCorreoPost.getText();
        int res;
        try {
            if (!Controlador.Utils.emptyFields(Required)) {
                if (verificar_email(mail)) {
                    res = postcontroller.ActualizarPostulante(All);
                    JOptionPane.showInternalMessageDialog(null, "Postulante actualizado exitosamente", "Confirmacion", 1);
                    CargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor introduzca un correo valido", "Error", 0);
                }
            } else {
                JOptionPane.showInternalMessageDialog(null, "Por Favor, revisa que todos los campos esten llenos.", "Error.", 0);
            }

        } catch (Exception ex) {
            Logger.getLogger(UsuariosPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
//            JTPostulantes.setModel(Controlador.Utils.rtrnTqble("Postulants"));
        } catch (Exception ex) {
            Logger.getLogger(PostulanteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnActualizarActionPerformed
    /**
     * Method to assign a limit to the number of characters in the password
     *
     * @param evt
     */
    private void txtContraseñaPostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaPostKeyPressed
        // TODO add your handling code here:
        char[] txt = txtContraseñaPost.getPassword();
        if (txt.length == 6) {
            txt = Arrays.copyOf(txt, txt.length - 1);
        }
        txtContraseñaPost.setText(String.valueOf(txt));
//           JOptionPane.showMessageDialog(null, String.valueOf(txt));
    }//GEN-LAST:event_txtContraseñaPostKeyPressed
    /**
     * Method to assign a limit to the number of characters in the password
     *
     * @param evt
     */
    private void txtContraseñaPostInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtContraseñaPostInputMethodTextChanged
        // TODO add your handling code here:
        char[] txt = txtContraseñaPost.getPassword();
        if (txt.length == 6) {
            txt = Arrays.copyOf(txt, txt.length - 1);
        }
        txtContraseñaPost.setText(String.valueOf(txt));

        JOptionPane.showMessageDialog(null, String.valueOf(txt));
    }//GEN-LAST:event_txtContraseñaPostInputMethodTextChanged

    /**
     * Button to enter the table of additional skills
     *
     * @param evt
     */
    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
        String idPos = txtID.getText();
        try {
            // TODO add your handling code here:
            AbilitiesCRUD frm = new AbilitiesCRUD(0, idPos);
            frm.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(PostulanteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAActionPerformed
    /**
     * Button to enter the table of branches
     *
     * @param evt
     */
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

    /**
     * Button to enter the table of general skills
     *
     * @param evt
     */
    private void btnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBActionPerformed
        String idPos = txtID.getText();
        try {
            // TODO add your handling code here:
            AbilitiesCRUD frm = new AbilitiesCRUD(1, idPos);
            frm.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(PostulanteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBActionPerformed

    private void txtCorreoPostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoPostKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCorreoPostKeyPressed

    private void BtnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarCamposActionPerformed
        // TODO add your handling code here:
        LimpiarCampos();
    }//GEN-LAST:event_BtnLimpiarCamposActionPerformed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        this.dispose();

    }//GEN-LAST:event_jLabel21MouseClicked
    /**
     * Validation of correct mail format
     *
     * @param correo
     * @return
     */
    public boolean verificar_email(String correo) {
        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = patron.matcher(correo);
        return mat.find();
    }

    /**
     * collect all the data to aggregate
     *
     * @return
     */
    private LinkedHashMap<String, String> CollectAllAdd() {
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        char[] pword = txtContraseñaPost.getPassword();

        data.put("namePostulant", txtNombrePost.getText());
        data.put("mailPostulant", txtCorreoPost.getText());
        data.put("Pword", Utils.encrypt(pword));
        data.put("photoPostulant", S);
        data.put("resumePDF", pdf);
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

    /**
     * collect all the data to update
     *
     * @return
     */
    private LinkedHashMap<String, String> CollectAllUpdate() {
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        char[] pword = txtContraseñaPost.getPassword();

        data.put("namePostulant", txtNombrePost.getText());
        data.put("mailPostulant", txtCorreoPost.getText());
        data.put("Pword", Utils.encrypt(pword));
        data.put("photoPostulant", S);
        data.put("resumePDF", pdf);
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

    /**
     * Collect what is required to add
     *
     * @return
     */
    private LinkedHashMap<String, String> CollectRequiredAdd() {
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
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

    /**
     * collect what is required to update
     *
     * @return
     */
    private LinkedHashMap<String, String> CollectRequiredUptade() {
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblPdf;
    private javax.swing.JPanel lblTodo;
    private javax.swing.JTextField txtApellidoPost;
    private javax.swing.JTextField txtContractType;
    private javax.swing.JPasswordField txtContraseñaPost;
    private javax.swing.JTextField txtCorreoPost;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDepartment;
    private javax.swing.JTextField txtNombrePost;
    private javax.swing.JTextField txtRDepartment;
    private javax.swing.JTextField txtestado;
    private javax.swing.JTextField txtgenero;
    private javax.swing.JTextField txthigtType;
    private javax.swing.JTextField txtprogress;
    private javax.swing.JTextField txtsalary;
    private javax.swing.JTextField txtstudylevel;
    private javax.swing.JTextField txtworkPreference;
    private javax.swing.JTextField txtworkState;
    private javax.swing.JTextField txtworktype;
    // End of variables declaration//GEN-END:variables
}
