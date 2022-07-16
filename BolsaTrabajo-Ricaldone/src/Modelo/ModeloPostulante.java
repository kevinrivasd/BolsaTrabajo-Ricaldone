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
import java.util.Base64;
import java.util.HashMap;

/**
 *
 * @author Jonathan
 */
import javax.swing.JOptionPane;
public class ModeloPostulante {

    public static int AgregarPostulante(HashMap<String, String> dataMap) throws Exception, Exception {
        Connection sql = ControladorConexion.getConection();
        String query = "INSERT INTO Postulants VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        byte[] decode = Base64.getDecoder().decode(dataMap.get("imgByte"));
        byte[] decode2 = Base64.getDecoder().decode(dataMap.get("resumePDF"));

        PreparedStatement consult = sql.prepareStatement(query);
        consult.setString(1, dataMap.get("namePostulant"));
        consult.setString(2, dataMap.get("mailPostulant"));
        consult.setString(3, dataMap.get("Pword"));
        consult.setBytes(4, decode);//Add image
        consult.setBytes(5, decode2);
        consult.setString(6, dataMap.get("resumeDetails"));
        consult.setInt(7, Integer.parseInt(dataMap.get("mailverification")));
        consult.setInt(8, Integer.parseInt(dataMap.get("Gender")));
        consult.setInt(9, Integer.parseInt(dataMap.get("States")));
        consult.setInt(10, Integer.parseInt(dataMap.get("Alumni")));
        consult.setInt(11, Integer.parseInt(dataMap.get("RDepartment")));
        consult.setInt(12, Integer.parseInt(dataMap.get("IDepartment")));
        consult.setInt(13, Integer.parseInt(dataMap.get("WSubject")));
        consult.setInt(14, Integer.parseInt(dataMap.get("Progress")));
        consult.setInt(15, Integer.parseInt(dataMap.get("Salary")));
        consult.setInt(16, Integer.parseInt(dataMap.get("HighType")));
        consult.setInt(17, Integer.parseInt(dataMap.get("ContractType")));
        consult.setInt(18, Integer.parseInt(dataMap.get("WorkPreference")));
        consult.setInt(19, Integer.parseInt(dataMap.get("StudyLevel")));
        consult.setInt(20, Integer.parseInt(dataMap.get("WorkStatus")));
        consult.setString(21, dataMap.get("lastName"));

        boolean res = consult.execute();

        return res ? 1 : 0;
    }
    
    public static ResultSet MostrarTablaPostulantes() throws Exception,Exception{
        Connection sql;
        try {
            sql = ControladorConexion.getConection();
        String query = "SELECT * FORM Postulants";
        PreparedStatement ps = sql.prepareStatement(query);
         ResultSet rs = ps.executeQuery();
        return rs;  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
        
        
    }

}