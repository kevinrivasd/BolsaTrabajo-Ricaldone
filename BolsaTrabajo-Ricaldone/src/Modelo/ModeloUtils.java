/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import Controlador.ControladorConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author hello
 */
public class ModeloUtils {
    public static List<String> getData(String sqlTable, String campoString) throws SQLException, Exception{        
        List<String> data = new ArrayList<>();
        
        Connection sql = ControladorConexion.getConection();
        
        String squery = "SELECT * FROM "+sqlTable ;
        PreparedStatement consult = sql.prepareStatement(squery);

        ResultSet res = consult.executeQuery();
        
        while (res.next()) {
            data.add(res.getString(campoString));            
        }
        return data;
    }
}
