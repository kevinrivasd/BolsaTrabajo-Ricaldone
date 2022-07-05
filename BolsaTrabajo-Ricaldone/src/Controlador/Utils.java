/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
}
