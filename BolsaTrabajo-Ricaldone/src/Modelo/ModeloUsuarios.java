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

    public boolean ValidarUser(String user) {
        Connection con = ControladorConexion.getConection();
        boolean resultado = false;
        String query = "SELECT * FROM UserSystems WHERE nameUser = ?";

        try {
            consult = con.prepareStatement(query);
            consult.setString(1, user);
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
    
    public boolean ValidarMail(String mail) {
        Connection con = ControladorConexion.getConection();
        boolean resultado = false;
        String query = "SELECT * FROM UserSystems WHERE mailUser = ?";

        try {
            consult = con.prepareStatement(query);
            consult.setString(1, mail);
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
