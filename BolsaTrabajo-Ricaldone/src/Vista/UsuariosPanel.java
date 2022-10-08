/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.Utils;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;
import Controlador.ControladorUsuario;
import Controlador.Utils;
import java.awt.Graphics;
import java.awt.Graphics2D;
import Customizar.JTextField;

/**
 * Panel to manage users
 *
 * @author Jonathan
 */
public class UsuariosPanel extends javax.swing.JPanel {

    Utils utils = new Utils();
    JTextField jtxt = new JTextField();
    /**
     * Creates new form UsuariosPanel
     */
    public HashMap<Integer, String> dataGender;
    public HashMap<Integer, String> dataRols;
    public HashMap<Integer, String> dataState;
    public TableRowSorter<TableModel> sorter;
    DefaultTableModel user;
    public String idUser;

    /**
     * Load table and hide graphic components
     */
    public UsuariosPanel(String idU) {
        initComponents();
        String[] Encabezados = {"ID", "Estado", "Usuario", "Contraseña", "Correo", "Numero", "Rol", "Verificacion de correo", "Genero"};
        user = new DefaultTableModel(null, Encabezados);
        dgvUsers.setModel(user);
        CargarTabla();
        idUser = idU;
        dataGender = utils.getDataTable("Genders");
        for (int k = 1; k <= dataGender.size(); k++) {
            cmbGenero.addItem(dataGender.get(k));
        }

        //Getting data from database rols
        dataRols = utils.getDataTable("Rols");
        for (int k = 1; k <= dataRols.size(); k++) {
            cmbRol.addItem(dataRols.get(k));
        }

        //Getting data from database rols
        dataState = utils.getDataTable("States");
        for (int k = 1; k <= dataState.size(); k++) {
            cmbEstado.addItem(dataState.get(k));
        }
//        DefaultTableModel model = new DefaultTableModel();
//        model = Controlador.Utils.rtrnTqble("UserSystems");

//        dgvUsers.setModel(model);
        txtContra.setTransferHandler(null);
        txtID.setVisible(false);

        sorter = new TableRowSorter<>(user);
        dgvUsers.setRowSorter(sorter);
        txtRol.setVisible(false);
        txtGender.setVisible(false);
        txtState.setVisible(false);
        btnAgregarUsuario.setEnabled(true);
        btnEliminar.setEnabled(false);
        jButton10.setEnabled(false);
        dgvUsers.getColumnModel().getColumn(0).setMaxWidth(0);
        dgvUsers.getColumnModel().getColumn(0).setMinWidth(0);
        dgvUsers.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        dgvUsers.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        //mailverific
        dgvUsers.getColumnModel().getColumn(7).setMaxWidth(0);
        dgvUsers.getColumnModel().getColumn(7).setMinWidth(0);
        dgvUsers.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
        dgvUsers.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
    }

    /**
     * Method to load back up table
     */
    final void CargarTabla() {
        ControladorUsuario CargarUser = new ControladorUsuario();
        while (user.getRowCount() > 0) {
            user.removeRow(0);
        }
        try {
            ResultSet rs = CargarUser.CargarUsuariosController();
            while (rs.next()) {
                Object[] oValores = {rs.getInt("idUser"), rs.getString("States"), rs.getString("nameUser"), rs.getString("Pword"), rs.getString("mailuser"), rs.getInt("numberUser"), rs.getString("Rol"), rs.getInt("mailverification"), rs.getString("Gender")};
                user.addRow(oValores);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public int radius = 0;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    protected void Components(Graphics graph) {
        Graphics2D g2 = (Graphics2D) graph;
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(graph);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAgregarUsuario = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        txtFilter = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvUsers = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        txtContra = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JFormattedTextField();
        txtGender = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();
        txtRol = new javax.swing.JTextField();

        setBackground(new java.awt.Color(239, 245, 213));
        setPreferredSize(new java.awt.Dimension(1141, 850));

        jPanel3.setBackground(new java.awt.Color(239, 245, 213));
        jPanel3.setPreferredSize(new java.awt.Dimension(1105, 790));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(50, 63, 27));
        jLabel3.setText("Usuario");

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(133, 175, 75));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS SCM/Acciones-C-40.png"))); // NOI18N
        jLabel4.setText("Acciones");

        btnAgregarUsuario.setFont(new java.awt.Font("Poppins Medium", 0, 17)); // NOI18N
        btnAgregarUsuario.setText("Agregar Usuario");
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Poppins Medium", 0, 17)); // NOI18N
        btnEliminar.setText("Eliminar Usuario");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Poppins Medium", 0, 17)); // NOI18N
        jButton9.setText("Limpiar campos");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Poppins Medium", 0, 17)); // NOI18N
        jButton10.setText("Modificar usuario");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        txtFilter.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        txtFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilterActionPerformed(evt);
            }
        });
        txtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFilterKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS SCM/Lupa-C-40.png"))); // NOI18N

        dgvUsers.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        dgvUsers.setColumnSelectionAllowed(true);
        dgvUsers.setSelectionBackground(new java.awt.Color(193, 233, 118));
        dgvUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dgvUsers);

        jPanel4.setBackground(new java.awt.Color(133, 175, 75));

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contraseña");

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Número Telefónico");

        txtUsuario.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        txtID.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Correo electronico");

        cmbGenero.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Estado");

        cmbRol.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N

        txtCorreo.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tipo de usuario");

        jLabel10.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Género");

        cmbEstado.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N

        txtContra.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        txtContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtContraMouseClicked(evt);
            }
        });
        txtContra.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtContraInputMethodTextChanged(evt);
            }
        });
        txtContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraActionPerformed(evt);
            }
        });
        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Usuario ");

        txtNumero.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        try {
            MaskFormatter formato = new MaskFormatter("########");
            formato.setPlaceholderCharacter('_');
            formato.install(txtNumero);
        } catch (Exception e) {
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1071, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(41, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnAgregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(66, 66, 66))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, 0)))
                        .addGap(0, 0, 0)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnAgregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39)
                                .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)))
                        .addGap(14, 14, 14)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );

        btnAgregarUsuario.setText("<html><center>"+"Agregar Usuario"+"</html></center>");
        btnEliminar.setText("<html><center>"+"Eliminar Usuario"+"</html></center>");
        jButton9.setText("<html><center>"+"Limpiar campos"+"</html></center>");
        jButton10.setText("<html><center>"+"Modificar Usuario"+"</center></html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1141, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
/**
     * Add user
     *
     * @param evt
     */
    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
        //Initializing map to then collect data
        LinkedHashMap<String, String> datos = CollectData();
        String mail = txtCorreo.getText();
        int res;
        ControladorUsuario us = new ControladorUsuario();
        String user = txtUsuario.getText();
        String id = txtID.getText();
//        ResultSet rs = us.ValidarUserController();
        try {

            if (!Controlador.Utils.emptyFields(datos)) {
                if (verificar_email(mail)) {
                    if (us.ValidarUserController(txtUsuario.getText(), id) == true) {
                        res = utils.Agregar(datos, "UserSystems");
                        JOptionPane.showMessageDialog(null, res == 1 ? "Usuario correctamente Agregado" : "Hubo un error");
                        CargarTabla();
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Compruebe que el usuario no se repita con otro registro.", "Error", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor introduzca un correo valido", "Error", 0);
                }
            } else {
                JOptionPane.showInternalMessageDialog(null, "Por Favor, revisa que todos los campos estén llenos.", "Error.", 0);
            }

        } catch (Exception ex) {
            Logger.getLogger(UsuariosPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed
    /**
     * Clear fields and reset combo box
     */
    public void limpiarCampos() {
        txtUsuario.setText("");
        txtCorreo.setText("");
        txtNumero.setText("");
        txtContra.setText("");
        cmbEstado.setSelectedIndex(0);
        cmbGenero.setSelectedIndex(0);
        cmbRol.setSelectedIndex(0);
        btnAgregarUsuario.setEnabled(true);
        btnEliminar.setEnabled(false);
        jButton10.setEnabled(false);
    }

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

    public boolean CheckUser(String idUs) {
        return idUs.equals(idUser);
    }

    /**
     * Delete user
     *
     * @param evt
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            String id = txtID.getText();

            if (JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar a " + txtUsuario.getText() + "?", "Mensaje",
                    JOptionPane.YES_NO_OPTION) == ConfirmationCallback.YES) {
                // TODO add your handling code here:
                if (!CheckUser(id)) {
                    int res = utils.eliminar(id, "UserSystems", "idUser");
                    if (res == 1) {
                        JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
                        CargarTabla();
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(null, res);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar el mismo usuario");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuariosPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraMouseClicked
    /**
     * Method to assign a limit to the number of characters in the password
     *
     * @param evt
     */
    private void txtContraInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtContraInputMethodTextChanged
        char[] txt = txtContra.getPassword();
        if (txt.length == 6) {
            txt = Arrays.copyOf(txt, txt.length - 1);
        }
        txtContra.setText(String.valueOf(txt));

        JOptionPane.showMessageDialog(null, String.valueOf(txt));
    }//GEN-LAST:event_txtContraInputMethodTextChanged

    private void txtContraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraKeyPressed
    /**
     * Method to assign a limit to the number of characters in the password
     *
     * @param evt
     */
    private void txtContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyTyped
        // TODO add your handling code here:
        char[] txt = txtContra.getPassword();
        if (txt.length == 6) {
            txt = Arrays.copyOf(txt, txt.length - 1);
        }
        txtContra.setText(String.valueOf(txt));
        if (txtContra.getText().length() >= 250) {
            evt.consume();
        }
        jtxt.ValidacionCaracteres(evt);
    }//GEN-LAST:event_txtContraKeyTyped
    /**
     * Event to select rows
     *
     * @param evt
     */
    private void dgvUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvUsersMouseClicked
        if (evt.getClickCount() == 1) {
            JTable Table = (JTable) evt.getSource();
            txtID.setText(Table.getModel().getValueAt(Table.getSelectedRow(), 0).toString());
            String idState = txtState.getText();
            cmbEstado.setSelectedItem(idState + 1);
            cmbEstado.setSelectedItem(Table.getModel().getValueAt(Table.getSelectedRow(), 1).toString());
            txtUsuario.setText(Table.getModel().getValueAt(Table.getSelectedRow(), 2).toString());

            //            txtContra.setText(Table.getModel().getValueAt(Table.getSelectedRow(),3).toString());
            txtCorreo.setText(Table.getModel().getValueAt(Table.getSelectedRow(), 4).toString());
            txtNumero.setText(Table.getModel().getValueAt(Table.getSelectedRow(), 5).toString());
            String rol = txtRol.getText();
            cmbRol.setSelectedItem(rol + 1);
            cmbRol.setSelectedItem(Table.getModel().getValueAt(Table.getSelectedRow(), 6).toString());
            String Genero = txtGender.getText();
            cmbGenero.setSelectedItem(Genero + 1);
            cmbGenero.setSelectedItem(Table.getModel().getValueAt(Table.getSelectedRow(), 8).toString());
            btnAgregarUsuario.setEnabled(false);
            btnEliminar.setEnabled(true);
            jButton10.setEnabled(true);
        }
    }//GEN-LAST:event_dgvUsersMouseClicked
    /**
     * Update user
     *
     * @param evt
     */
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        LinkedHashMap<String, String> data = CollectDataUpdate();
        String mail = txtCorreo.getText();
        ControladorUsuario us = new ControladorUsuario();
        if (data.get("Pword").trim().isEmpty()
                && JOptionPane.showConfirmDialog(null, "La contraseña no ha sido modificada, se dejara la antigua, deseas continuar?", "Mensaje",
                        JOptionPane.YES_NO_OPTION) == ConfirmationCallback.YES) {

            data.remove("Pword");
            if (!Controlador.Utils.emptyFields(data)) {
                if (verificar_email(mail)) {
                    String id = txtID.getText();
                    if (us.ValidarUserController(txtUsuario.getText(), id) == true) {
                        int res = 0;
                        try {
                            res = utils.actualizar(data, id, "UserSystems", "idUser");
                        } catch (Exception ex) {
                            Logger.getLogger(UsuariosPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(null, res == 1 ? "Usuario correctamente actualizado" : "Hubo un error");
                        CargarTabla();
                        limpiarCampos();
                    }else {
                        JOptionPane.showMessageDialog(null, "Compruebe que el usuario no se repita.", "Error", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor introduzca un correo valido", "Error", 0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor revisa que los campos a parte de la contraseña estén correctamente llenos.");
            }

        } else if (!data.get("Pword").trim().isEmpty()) {
            String id = txtID.getText();
            if (!Controlador.Utils.emptyFields(data)) {
                if (verificar_email(mail)) {
                    if (us.ValidarUserController(txtUsuario.getText(), id) == true) {
                        try {
                            int res = utils.actualizar(data, id, "UserSystems", "idUser");
                            JOptionPane.showMessageDialog(null, res == 1 ? "Usuario correctamente actualizado" : "Hubo un error");
                            CargarTabla();
                            limpiarCampos();
                        } catch (Exception ex) {
                            Logger.getLogger(UsuariosPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Compruebe que el usuario no se repita.", "Error", 0);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Por favor introduzca un correo valido", "Error", 0);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Por favor revisa que los campos estén correctamente llenos.");
            }
        }

        try {
//            dgvUsers.setModel(Controlador.Utils.rtrnTqble("UserSystems"));
        } catch (Exception ex) {
            Logger.getLogger(UsuariosPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFilterActionPerformed
    /**
     * Search filter
     *
     * @param evt
     */
    private void txtFilterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyTyped
        // TODO add your handling code here:
        String text = txtFilter.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter(text));
            } catch (PatternSyntaxException pse) {
                System.out.println("Mal Patron REGEX");
            }
        }
      jtxt.ValidacionCaracteres_tilde_espacio_arroba(evt);
    }//GEN-LAST:event_txtFilterKeyTyped

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void txtContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        if (txtUsuario.getText().length() >= 30) {
            evt.consume();
        }
        jtxt.ValidacionCaracteres(evt);
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        if (txtCorreo.getText().length() >= 45) {
            evt.consume();
        }
        jtxt.ValidacionCaracteres_tilde_arroba(evt);
    }//GEN-LAST:event_txtCorreoKeyTyped
    /**
     * Collect data from the users table
     *
     * @return
     */
    private LinkedHashMap<String, String> CollectData() {
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        char[] pword = txtContra.getPassword();

        data.put("idState", String.valueOf(cmbEstado.getSelectedIndex() + 1));
        data.put("nameUser", txtUsuario.getText());
        data.put("Pword", Utils.encrypt(pword));
        data.put("mailUser", txtCorreo.getText());
        data.put("numberUser", txtNumero.getText());
        data.put("idRol", String.valueOf(cmbRol.getSelectedIndex() + 1));
        data.put("mailVerification", String.valueOf(1));
        data.put("idGender", String.valueOf(cmbGenero.getSelectedIndex() + 1));
        data.put("firstUse", "0");

        return data;
    }
     private LinkedHashMap<String, String> CollectDataUpdate() {
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        char[] pword = txtContra.getPassword();

        data.put("idState", String.valueOf(cmbEstado.getSelectedIndex() + 1));
        data.put("nameUser", txtUsuario.getText());
        data.put("Pword", Utils.encrypt(pword));
        data.put("mailUser", txtCorreo.getText());
        data.put("numberUser", txtNumero.getText());
        data.put("idRol", String.valueOf(cmbRol.getSelectedIndex() + 1));
        data.put("mailVerification", String.valueOf(1));
        data.put("idGender", String.valueOf(cmbGenero.getSelectedIndex() + 1));
        data.put("firstUse", "1");

        return data;
    
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarUsuario;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JTable dgvUsers;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtFilter;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtID;
    private javax.swing.JFormattedTextField txtNumero;
    private javax.swing.JTextField txtRol;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
