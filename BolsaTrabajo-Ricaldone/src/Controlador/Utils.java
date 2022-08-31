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
 *
 * @author hello
 */
public class Utils {
    ModeloUtils modelUtils = new ModeloUtils();
    //retrieve data for the comboboxes based on the cmbString(table)
    //and the field that retrieves is campoString(tableField)
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

    
    public List<String> getDataCmb(String cmbString, String campoString){
        return modelUtils.getData(cmbString, campoString);
    }

    public HashMap<Integer, String> getDataTable(String cmbString) {
        return modelUtils.getTableHM(cmbString);
    }

    //check if any element on the hashmap is empyt or null
    //the hashmap comes as a parameter.
    public static boolean emptyFields(HashMap<String, String> fields) {

        for (Map.Entry<String, String> entry : fields.entrySet()) {

            String val = entry.getValue();

            if (val == null || val.trim().isEmpty()) {
                return true;
            }
        }

        return false;
    }

    public static String encrypt(char[] password) {
        String baseString = "";

        for (char c : password) {
            baseString += c + 3;
        }

        return baseString;
    }

    public DefaultTableModel rtrnTqble(String sqlTable, String[] colStrings, String idString){

        try {
            ResultSet rs = modelUtils.getTable(sqlTable, colStrings, idString);
            DefaultTableModel table = buildTableModel(rs);
            
            return table;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static DefaultTableModel agruparPersona() {
        return Modelo.ModeloUtils.agruparPersona();
    }

    public DefaultTableModel rtrnTqble(String sqlTable){

        try {
            ResultSet rs = modelUtils.getTable(sqlTable);
            DefaultTableModel table = buildTableModel(rs);
            
            return table;
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

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

    public int eliminar(String id, String tabla, String campo) {
        return modelUtils.Eliminar(id, tabla, campo);
    }

    public int actualizar(LinkedHashMap<String, String> data, String id, String tabla, String idCompare) throws Exception {
        return modelUtils.Actualizar(data, id, tabla, idCompare);
    }

    public int Agregar(LinkedHashMap<String, String> datos, String tabla) {
        return modelUtils.Agregar(datos, tabla);

    }

    public List<String> getUserData(String nameUser) {
        return modelUtils.getUserData(nameUser);
    }

    public static String sendPDF(String b64, String mail) {

        try {
            Random rand = new Random();
            int randomCode = rand.nextInt(999999);
            Request request = new Request("http://localhost:3000/api/email", RequestMethod.POST);
            String emailString = mail;
            //Form-Data
            request.form("email", emailString)
                    .form("subject", "Código de verificación de Sacculum")
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

}
