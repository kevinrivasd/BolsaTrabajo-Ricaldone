/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import com.finalhints.HttpClient;
import com.finalhints.Request;
import com.finalhints.RequestMethod;
import com.finalhints.Response;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Modelo.ModeloUtils;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * kind of utilities to streamline processes.
 *
 * @author hello
 */
public class Utils {

    /**
     * Object from ModeloUtils.
     */
    ModeloUtils modelUtils = new ModeloUtils();

    //retrieve data for the comboboxes based on the cmbString(table)
    //and the field that retrieves is campoString(tableField)
    /**
     * MD5 encryption method.
     *
     * @param input
     * @return
     */
    public static String encryptMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get data for combo box.
     *
     * @param cmbString
     * @param campoString
     * @return
     */
    public List<String> getDataCmb(String cmbString, String campoString) {
        return modelUtils.getData(cmbString, campoString);
    }

    /**
     * Get data for table.
     *
     * @param cmbString
     * @return
     */
    public HashMap<Integer, String> getDataTable(String cmbString) {
        return modelUtils.getTableHM(cmbString);
    }

    //check if any element on the hashmap is empyt or null.
    //the hashmap comes as a parameter.
    /**
     * Check empty fields
     *
     * @param fields
     * @return
     */
    public static boolean emptyFields(HashMap<String, String> fields) {

        for (Map.Entry<String, String> entry : fields.entrySet()) {

            String val = entry.getValue();

            if (val == null || val.trim().isEmpty()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Password encryption usin the value from table ASCII + 3.
     *
     * @param password
     * @return
     */
    public static String encrypt(char[] password) {
        String baseString = "";

        for (char c : password) {
            baseString += c + 3;
        }

        return baseString;
    }

    /**
     * Table return with via with where condition using the values of "table,
     * field and ID".
     *
     * @param sqlTable
     * @param colStrings
     * @param idString
     * @return
     */
    public DefaultTableModel rtrnTqble(String sqlTable, String[] colStrings, String idString) {

        try {
            ResultSet rs = modelUtils.getTable(sqlTable, colStrings, idString);
            DefaultTableModel table = buildTableModel(rs);

            return table;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Method to gather the amount and count a data.
     *
     * @return
     */
    public static DefaultTableModel agruparPersona() {
        return Modelo.ModeloUtils.agruparPersona();
    }

    /**
     * Return table from base.
     *
     * @param sqlTable
     * @return
     */
    public DefaultTableModel rtrnTqble(String sqlTable) {

        try {
            ResultSet rs = modelUtils.getTable(sqlTable);
            DefaultTableModel table = buildTableModel(rs);

            return table;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Reconstruct the table from the metadata entered through LinkedHasMap.
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnCount >= columnIndex; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }

    /**
     * Delete data with the values of "ID, Table and field".
     *
     * @param id
     * @param tabla
     * @param campo
     * @return
     */
    public int eliminar(String id, String tabla, String campo) {
        return modelUtils.Eliminar(id, tabla, campo);
    }

    /**
     * Update data with the values of "LinkedHasMap from view, ID or question
     * mark, table and comparation".
     *
     * @param data
     * @param id
     * @param tabla
     * @param idCompare
     * @return
     * @throws Exception
     */
    public int actualizar(LinkedHashMap<String, String> data, String id, String tabla, String idCompare) throws Exception {
        return modelUtils.Actualizar(data, id, tabla, idCompare);
    }

    /**
     * Insert data with the values of "LinkedHasMap and table".
     *
     * @param datos
     * @param tabla
     * @return
     */
    public int Agregar(LinkedHashMap<String, String> datos, String tabla) {
        return modelUtils.Agregar(datos, tabla);

    }

    /**
     * Get user data.
     *
     * @param nameUser
     * @return
     */
    public List<String> getUserData(String nameUser) {
        return modelUtils.getUserData(nameUser);
    }

    /**
     * Send PDF for Email with Base64.
     *
     * @param b64
     * @param mail
     * @return
     */
    public String sendPDF(String b64, String mail) {

        try {
            Random rand = new Random();
            int randomCode = rand.nextInt(999999);
            Request request = new Request("http://localhost:3000/api/email", RequestMethod.POST);
            String emailString = mail;
            //Form-Data
            request.form("email", emailString)
                    .form("subject", "PDF del postulante")
                    .form("text", "Este es el Curriculum del postulante que solicitaste: ")
                    .form("base64", b64);

            Response response = new HttpClient(request).execute();
            if (response.getStatusCode() == 200) {
                JOptionPane.showMessageDialog(null, "Email enviado con exito, por favor verifica en SPAM.");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error");
            }
            return emailString;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    //todo: test it
    public int createCallback(List<String> lista, String Pword, String username) {

        LinkedHashMap<String, String> data_user = new LinkedHashMap<>();

        data_user.put("idState", "1");
        data_user.put("nameUser", username);
        data_user.put("Pword", Pword);
        data_user.put("mailUser", lista.get(0));
        data_user.put("numberUser", "000000");
        data_user.put("idRol", "3");
        data_user.put("mailVerification", String.valueOf(1));
        data_user.put("idGender", "1");
        data_user.put("firstUse", "0");

        ModeloUtils obj = new ModeloUtils();
        return obj.Agregar(data_user, "UserSystems");
    }

    public int gen() {
        Random r = new Random(System.currentTimeMillis());
        return 10000 + r.nextInt(20000);
    }
    /**
     * Confirmation and mailing for users requesting an account on the portal
     * @param idMod
     * @return 
     */
    public boolean sendConfirmation(int idMod) {

        try {
            Random rand = new Random();
            int random = gen();

            Request request = new Request("http://localhost:3000/api/email", RequestMethod.POST);

            List<String> lista = ModeloUtils.getMod(idMod);
            
            String us = lista.get(1);
            String[] splited = us.split("\\s+");
            String userName = splited[0].toLowerCase() + "123";
            
            String Pword = encrypt(String.valueOf(random).toCharArray());
            int callback = createCallback(lista, Pword, userName);

            StringBuilder str = new StringBuilder("Tu cuenta ha sido creada con exito ");
            str.append("Usuario: " + userName + " ");
            str.append("Contraseña: " + String.valueOf(random));

            if (callback == 1) {
                request.form("email", lista.get(0))
                        .form("subject", "Tu cuenta ha sido creada")
                        .form("text", str)
                        .form("base64", "");

                Response response = new HttpClient(request).execute();
                JOptionPane.showMessageDialog(null, "Cuenta creada con exito, se le ha notificado al usuario");
                ModeloUtils objmodel = new ModeloUtils();
                objmodel.Eliminar(String.valueOf(idMod), "Moderations", "idMod");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear la cuenta");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

}
