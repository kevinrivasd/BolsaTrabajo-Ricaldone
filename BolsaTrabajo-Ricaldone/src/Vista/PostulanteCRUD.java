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

        String[] Encabezados = {"ID", "Nombre del postulante", "Correo del postulante", "Contraseña", "Foto", "Resumen PDF", "Resumen detalles", "Verificacion de correo", "Genero", "Estado", "Ex-Alumno", "Departamento de preferencia", "Departamento de residencia", "Trabajo", "Progreso", "Salario", "Bachillerato", "Tipo de trabajo", "Preferencia laboral", "Nivel de estudio", "Estado del trabajo", "Apellido"};
        post = new DefaultTableModel(null, Encabezados);
        JTPostulantes.setModel(post);
        CargarTabla();
        //IDepartment
        JTPostulantes.getColumnModel().getColumn(11).setMaxWidth(0);
        JTPostulantes.getColumnModel().getColumn(11).setMinWidth(0);
        JTPostulantes.getTableHeader().getColumnModel().getColumn(11).setMaxWidth(0);
        JTPostulantes.getTableHeader().getColumnModel().getColumn(11).setMinWidth(0);
        //RDepartment
        JTPostulantes.getColumnModel().getColumn(12).setMaxWidth(0);
        JTPostulantes.getColumnModel().getColumn(12).setMinWidth(0);
        JTPostulantes.getTableHeader().getColumnModel().getColumn(12).setMaxWidth(0);
        JTPostulantes.getTableHeader().getColumnModel().getColumn(12).setMinWidth(0);
        //photopostulant
        JTPostulantes.getColumnModel().getColumn(4).setMaxWidth(0);
        JTPostulantes.getColumnModel().getColumn(4).setMinWidth(0);
        JTPostulantes.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        JTPostulantes.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
        //resumePDF
        JTPostulantes.getColumnModel().getColumn(5).setMaxWidth(0);
        JTPostulantes.getColumnModel().getColumn(5).setMinWidth(0);
        JTPostulantes.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        JTPostulantes.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
        //resumedetails
        JTPostulantes.getColumnModel().getColumn(6).setMaxWidth(0);
        JTPostulantes.getColumnModel().getColumn(6).setMinWidth(0);
        JTPostulantes.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        JTPostulantes.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
        //mailverification
        JTPostulantes.getColumnModel().getColumn(7).setMaxWidth(0);
        JTPostulantes.getColumnModel().getColumn(7).setMinWidth(0);
        JTPostulantes.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
        JTPostulantes.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
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
        BtnAgregar.setEnabled(true);
        BtnActualizar.setEnabled(false);
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
        txtworktype = new javax.swing.JTextField();
        txtsalary = new javax.swing.JTextField();
        txtworkPreference = new javax.swing.JTextField();
        txtworkState = new javax.swing.JTextField();
        txtRDepartment = new javax.swing.JTextField();
        txtIDepartment = new javax.swing.JTextField();
        txtContractType = new javax.swing.JTextField();
        txthigtType = new javax.swing.JTextField();
        txtprogress = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(239, 245, 213));

        lblTodo.setBackground(new java.awt.Color(239, 245, 213));

        BtnAgregar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnActualizar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

        txtNombrePost.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        txtNombrePost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombrePostKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel1.setText("Nombres del postulante");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel2.setText("Correo del postulante");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel3.setText("Contraseña");

        txtCorreoPost.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        txtCorreoPost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoPostKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoPostKeyTyped(evt);
            }
        });

        BtnImageAdd.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        BtnImageAdd.setText("Agregar imagen");
        BtnImageAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnImageAddActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel4.setText("Genero");

        cmbGenero.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel5.setText("Estado");

        cmbEstadoPost.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel6.setText("Dpt. de residencia");

        cmbDepartReside.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel7.setText("Dpt. de preferencia");

        cmbDepartPreferencia.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel8.setText("Progreso");

        cmbPrefLaboral.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel9.setText("Apellidos del postulante");

        txtApellidoPost.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        txtApellidoPost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPostKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel10.setText("Habilidad general");

        cmbSalario.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel12.setText("Estado de trabajo");

        cmbTipoTrabajo.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        cmbTipoTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoTrabajoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel13.setText("Tipo de trabajo");

        cmbEstadoTrabajo.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel14.setText("Tipo de contrato");

        cmbTipoContrato.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel15.setText("Preferencias laborales");

        cmbProgreso.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel16.setText("Bachilerato:");

        jLabel17.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel17.setText("Rama perteneciente");

        jLabel18.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel18.setText("Habilidad adicional");

        CheckAlumni.setBackground(new java.awt.Color(239, 245, 213));
        CheckAlumni.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        CheckAlumni.setText("Ex-alumno");
        CheckAlumni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckAlumniActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel19.setText("Salario");

        cmbHighType.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N

        txtContraseñaPost.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseñaPostKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jLabel11.setText("Nivel de estudio");

        cmbNivelEstudio.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N

        BtnAddPDF.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        BtnAddPDF.setText("Añadir PDF");
        BtnAddPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddPDFActionPerformed(evt);
            }
        });

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

        txtID.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N

        lblID.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        lblID.setText("ID:");

        btnB.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnB.setText("Gestionar Rama");
        btnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBActionPerformed(evt);
            }
        });

        btnA.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnA.setText("Gestionar Habilidad Adicional");
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });

        btnG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnG.setText("Gestionar Habilidad General");
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
        BTabla.setGridColor(new java.awt.Color(0, 0, 0));
        BTabla.setSelectionBackground(new java.awt.Color(193, 233, 118));
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
        GTable.setGridColor(new java.awt.Color(0, 0, 0));
        GTable.setSelectionBackground(new java.awt.Color(193, 233, 118));
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
        ATable.setGridColor(new java.awt.Color(0, 0, 0));
        ATable.setSelectionBackground(new java.awt.Color(193, 233, 118));
        jScrollPane4.setViewportView(ATable);

        BtnLimpiarCampos.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        BtnLimpiarCampos.setText("Limpiar Campos");
        BtnLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarCamposActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Poppins Medium", 0, 19)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(133, 175, 75));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS SCM/Volver-C-30.png"))); // NOI18N
        jLabel21.setText("Regresar");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Poppins", 1, 30)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(50, 63, 27));
        jLabel22.setText("Postulantes CRUD");

        jLabel23.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(133, 175, 75));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS SCM/Acciones-C-30.png"))); // NOI18N
        jLabel23.setText("Acciones");

        javax.swing.GroupLayout lblTodoLayout = new javax.swing.GroupLayout(lblTodo);
        lblTodo.setLayout(lblTodoLayout);
        lblTodoLayout.setHorizontalGroup(
            lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblTodoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(txtNombrePost, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addComponent(txtApellidoPost, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(txtCorreoPost, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtContraseñaPost))
                            .addComponent(CheckAlumni, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblTodoLayout.createSequentialGroup()
                        .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(lblTodoLayout.createSequentialGroup()
                                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(btnB, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(lblTodoLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(8, 8, 8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnA)
                            .addComponent(jLabel18)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(lblTodoLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btnG))
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(282, 282, 282)))
                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnImageAdd)
                    .addComponent(BtnAddPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLimpiarCampos)
                    .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lblTodoLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbEstadoPost, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthigtType, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbHighType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContractType, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbTipoContrato, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 32, Short.MAX_VALUE)
                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPrefLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsalary, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbDepartReside, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbDepartPreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtworkPreference, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtstudylevel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbNivelEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtworktype, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbTipoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtworkState, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbEstadoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtprogress, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jLabel23)
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(lblTodoLayout.createSequentialGroup()
                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addGap(817, 817, 817)
                        .addComponent(lblPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lblTodoLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(679, 679, 679)
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(lblTodoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel21))
                            .addGroup(lblTodoLayout.createSequentialGroup()
                                .addGap(791, 791, 791)
                                .addComponent(jLabel20))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1095, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lblTodoLayout.setVerticalGroup(
            lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblTodoLayout.createSequentialGroup()
                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lblTodoLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnLimpiarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lblTodoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel21)
                                .addGap(49, 49, 49)
                                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel11)
                                    .addComponent(txtgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtworkPreference, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtstudylevel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbNivelEstudio, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbPrefLaboral, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbGenero, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombrePost, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5)
                                    .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)
                                    .addComponent(txtsalary, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtworktype, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(cmbEstadoPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidoPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTipoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel16)
                                    .addComponent(txthigtType, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtRDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtworkState, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(txtCorreoPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbHighType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbDepartReside, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbEstadoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel14)
                                    .addComponent(txtContractType, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtIDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtprogress, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(txtContraseñaPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbDepartPreferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(lblTodoLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel22)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CheckAlumni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(lblTodoLayout.createSequentialGroup()
                                .addComponent(lblID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(11, 11, 11)))
                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnB, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnG, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addComponent(BtnImageAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BtnAddPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)))
                .addGroup(lblTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel20))
                    .addGroup(lblTodoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        CheckAlumni.setText("Ex-alumno");

        jScrollPane5.setViewportView(lblTodo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        cmbDepartPreferencia.setSelectedIndex(0);
        cmbDepartReside.setSelectedIndex(0);
        cmbEstadoPost.setSelectedIndex(0);
        cmbEstadoTrabajo.setSelectedIndex(0);
        cmbGenero.setSelectedIndex(0);
        cmbHighType.setSelectedIndex(0);
        cmbNivelEstudio.setSelectedIndex(0);
        cmbPrefLaboral.setSelectedIndex(0);
        cmbProgreso.setSelectedIndex(0);
        cmbSalario.setSelectedIndex(0);
        cmbTipoContrato.setSelectedIndex(0);
        cmbTipoTrabajo.setSelectedIndex(0);
        BtnAgregar.setEnabled(true);
        BtnActualizar.setEnabled(false);
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
        String nombres = txtNombrePost.getText();
        String apellidos = txtApellidoPost.getText();
        int res;
        try {
            if (!Controlador.Utils.emptyFields(Required) && !pdf.equals("")) {
                if (verificar_email(mail)) {
                    res = postcontroller.AgreparPostulante(All);
                    JOptionPane.showInternalMessageDialog(null, "Postulante registrado correctamente.", "Confirmacion", 1);
                    CargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor introduzca un correo valido", "Error", 0);
                }
            } else {
                JOptionPane.showInternalMessageDialog(null,  "Por favor, revisa que todos los campos estén llenos y el pdf está añadido.", "Error.", 0);
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
            txtContraseñaPost.setText(Table.getModel().getValueAt(Table.getSelectedRow(), 3).toString());
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
            lblPdf.setText(Table.getModel().getValueAt(Table.getSelectedRow(), 5).toString());
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
            BtnAgregar.setEnabled(false);
            BtnActualizar.setEnabled(true);
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
            if (!Controlador.Utils.emptyFields(Required) && !pdf.equals("")) {
                if (verificar_email(mail)) {
                    res = postcontroller.ActualizarPostulante(All);
                    JOptionPane.showInternalMessageDialog(null, "Postulante actualizado exitosamente", "Confirmacion", 1);
                    CargarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor introduzca un correo valido", "Error", 0);
                }
            } else {
                JOptionPane.showInternalMessageDialog(null, "Por favor, revisa que todos los campos estén llenos y el pdf está añadido.", "Error.", 0);
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

    private void txtNombrePostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePostKeyTyped
        char validar = evt.getKeyChar();
        
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtNombrePost.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombrePostKeyTyped

    private void txtApellidoPostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPostKeyTyped
        char validar = evt.getKeyChar();
        
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtApellidoPost.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoPostKeyTyped

    private void txtCorreoPostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoPostKeyTyped
       if (txtCorreoPost.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCorreoPostKeyTyped

    private void txtContraseñaPostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaPostKeyTyped
        if (txtContraseñaPost.getText().length() >= 999) {
            evt.consume();
        }
    }//GEN-LAST:event_txtContraseñaPostKeyTyped

    private void CheckAlumniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckAlumniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckAlumniActionPerformed

    private void cmbTipoTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoTrabajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoTrabajoActionPerformed
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
//        data.put("photoPostulant", S);        
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
//        data.put("photoPostulant", S);        
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
    private javax.swing.JLabel jLabel23;
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
