/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Controlador.ControladorConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;


/**
 *
 * @author Jonathan
 */
public class ModeloPostulante {
    public static int AgregarPostulante(HashMap<String,String> dataMap) throws Exception,Exception{
         Connection sql = ControladorConexion.getConection();
         String query = "INSERT INTO Postulants VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
         
         PreparedStatement consult = sql.prepareStatement(query);
         consult.setString(1, dataMap.get("namePostulant"));
         consult.setString(2, dataMap.get("mailPostulant"));
         consult.setString(3, dataMap.get("Pword"));
         consult.setString(4, dataMap.get("photoPostulant"));
         consult.setString(5, dataMap.get("resumePDF"));
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
         consult.setInt(21, Integer.parseInt(dataMap.get("lastName")));
         
          boolean res = consult.execute();
           
        return res ? 1:0;
    }
}
