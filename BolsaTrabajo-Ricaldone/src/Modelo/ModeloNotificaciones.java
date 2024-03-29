/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ControladorConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * This method consults the moderation of who they requested, when and who requested it
 * @author Jonathan
 */
public class ModeloNotificaciones {

    public ResultSet CargarNotificaciones() {
        Connection con;
        PreparedStatement ps;
        try {
            con = ControladorConexion.getConection();
            String query = "SELECT * FROM Moderations";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
}
