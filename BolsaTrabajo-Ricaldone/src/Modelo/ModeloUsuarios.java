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
    
    public static ResultSet CargarUsuarios(){
        Connection con;
        try {
            con = ControladorConexion.getConection();
            String query = "SELECT * FROM VUsuarios";
        PreparedStatement consult = con.prepareStatement(query);
        ResultSet rs = consult.executeQuery();
        return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
}
