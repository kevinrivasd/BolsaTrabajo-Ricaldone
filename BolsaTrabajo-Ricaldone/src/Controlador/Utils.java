/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.List;

/**
 *
 * @author hello
 */
public class Utils {
    public static List<String> getDataCmb(String cmbString, String campoString) throws Exception{
        return Modelo.ModeloUtils.getData(cmbString, campoString);               
    }
    
}
