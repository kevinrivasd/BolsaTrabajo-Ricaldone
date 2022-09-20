/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.Connection;
import Controlador.ControladorConexion;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Rivas
 */
public class ModeloUsuarios {
    
    PreparedStatement consult = null;

    /**
     * We use this method to load the data from the users table
     * @return 
     */
    public ResultSet CargarUsuarios() {
        Connection con;
        try {
            con = ControladorConexion.getConection();
            String query = "SELECT * FROM V_Users";
            consult = con.prepareStatement(query);
            ResultSet rs = consult.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }

    /**
     * This method helps us to verify that the entered user is not repeated
     * @param user
     * @param id
     * @return 
     */
    public boolean ValidarUser(String user, String id) {
        Connection con = ControladorConexion.getConection();
        boolean resultado = false;
        String query = "SELECT * FROM UserSystems WHERE nameUser = ? AND NOT idUser= ?";

        try {
            consult = con.prepareStatement(query);
            consult.setString(1, user);
            consult.setString(2, id);
            ResultSet rs = consult.executeQuery();
            if (!rs.isBeforeFirst() && rs.getRow() == 0) {
                resultado = true;
            } else {
                resultado = false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
        return resultado;
    }
    
    /**
     * This method helps us to verify that the user's email is not repeated
     * @param mail
     * @param id
     * @return 
     */
    public boolean ValidarMail(String mail, String id) {
        Connection con = ControladorConexion.getConection();
        boolean resultado = false;
        String query = "SELECT * FROM UserSystems WHERE mailUser = ? AND NOT idUser= ?";

        try {
            consult = con.prepareStatement(query);
            consult.setString(1, mail);
            consult.setString(2, id);
            ResultSet rs = consult.executeQuery();
            if (!rs.isBeforeFirst() && rs.getRow() == 0) {
                resultado = true;
            } else {
                resultado = false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
        return resultado;
    }

}
