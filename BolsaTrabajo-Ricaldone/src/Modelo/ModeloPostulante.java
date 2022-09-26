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
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * We use this class for maintenance and to consult some tables
 *
 * @author Jonathan
 */
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModeloPostulante {

    PreparedStatement ps;

    /**
     * This method is the one that helps us to insert data to the base
     *
     * @param dataMap
     * @return
     */
    public int AgregarPostulante(LinkedHashMap<String, String> dataMap) {
        try {
            Connection sql = ControladorConexion.getConection();
            String query = "INSERT INTO Postulants VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            byte[] decode2 = Base64.getDecoder().decode(dataMap.get("resumePDF"));

            PreparedStatement consult = sql.prepareStatement(query);
            consult.setString(1, dataMap.get("namePostulant"));
            consult.setString(2, dataMap.get("mailPostulant"));
            consult.setString(3, dataMap.get("Pword"));
            consult.setString(4, dataMap.get("photoPostulant"));//Add image
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
            consult.setString(21, dataMap.get("lastName"));

            boolean res = consult.execute();

            return res ? 1 : 0;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPostulante.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    /**
     * This method is the one that helps us to update the data based on
     *
     * @param dataMap
     * @return
     */
    public int ActualizarPostulante(LinkedHashMap<String, String> dataMap) {
        try {
            Connection sql = ControladorConexion.getConection();
            String query = "UPDATE Postulants SET namePostulant = ?, mailPostulant = ?, Pword = ?, photoPostulant = ?, resumePDF= ?, resumeDetails = ?, mailverification= ?, Gender = ?,States = ?, Alumni = ?, RDepartment = ?, IDepartment = ?, WSubject = ?, Progress = ?, Salary = ?, HighType = ?, ContractType = ?, WorkPreference = ?, StudyLevel = ?, WorkStatus = ?, lastName = ? WHERE idPostulant = ?";

            byte[] decode2 = Base64.getDecoder().decode(dataMap.get("resumePDF"));

            PreparedStatement consult = sql.prepareStatement(query);
            consult.setString(1, dataMap.get("namePostulant"));
            consult.setString(2, dataMap.get("mailPostulant"));
            consult.setString(3, dataMap.get("Pword"));
            consult.setString(4, dataMap.get("photoPostulant"));//Add image
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
            consult.setString(21, dataMap.get("lastName"));
            consult.setInt(22, Integer.parseInt(dataMap.get("idPostulant")));

            boolean res = consult.execute();

            return res ? 1 : 0;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPostulante.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    /**
     * This method helps us to load the table of applicants to consult data
     *
     * @return
     */
    public ResultSet mostrarTabla() {
        Connection con;
        try {
            con = ControladorConexion.getConection();
            String query = "SELECT * FROM Postulants";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }

    }

    /**
     * Upload applicants for preview
     *
     * @return
     */
    public ResultSet mostrarTablaV() {
        Connection con;
        try {
            con = ControladorConexion.getConection();
            String query = "SELECT * FROM V_Post";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }

    }

    /**
     * Upload all applicant data
     *
     * @return
     */
    public ResultSet TablaCRUD_V() {
        Connection con;
        try {
            con = ControladorConexion.getConection();
            String query = "SELECT * FROM V_PostCRUD";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }

    }

    /**
     * This method helps us to give a preview of the processes carried out by
     * applicants
     *
     * @return
     */
    public ResultSet ProgresoPostulants() {
        Connection con;
        try {
            con = ControladorConexion.getConection();
            String query = "SELECT Postulants.namePostulant, Postulants.lastName ,Progress.Progress FROM Postulants, Progress WHERE Postulants.Progress = Progress.idProgress and Progress.idProgress in(4,5)";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }

    }

}
