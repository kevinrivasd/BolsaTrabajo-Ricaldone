/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hello
 */
public class Utils {
    
    //retrieve data for the comboboxes based on the cmbString(table)
    //and the field that retrieves is campoString(tableField)
    public static List<String> getDataCmb(String cmbString, String campoString) throws Exception{
        return Modelo.ModeloUtils.getData(cmbString, campoString);               
    }
    
    //check if any element on the hashmap is empyt or null
    //the hashmap comes as a parameter.
    public static boolean emptyFields(HashMap<String, String> fields){
        
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            
            String val = entry.getValue();
            
            if (val == null || val.trim().isEmpty()) {
                return true;
            }            
        }
           
        return false;
    }
    
    public static String encrypt(char[] password){
        String baseString = "";        
        
        for (char c : password) {
            baseString += c+3;
        }
        
        return baseString;
    }

   public static DefaultTableModel rtrnTqble(String sqlTable) throws Exception{
      
       ResultSet rs = Modelo.ModeloUtils.getTable(sqlTable);
       DefaultTableModel table = buildTableModel(rs);
      
      return table;
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
        for (int columnIndex = 1; columnCount > columnIndex; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}
    
}
