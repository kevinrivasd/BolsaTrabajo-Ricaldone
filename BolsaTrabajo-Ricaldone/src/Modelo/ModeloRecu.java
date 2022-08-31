/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ControladorConexion;
import static Controlador.ControladorConexion.getConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin Rivas
 */
public class ModeloRecu {

    PreparedStatement consult;

    public int RecuperacionPWD(String user) {
        try {
            Connection sql = ControladorConexion.getConection();
            String squery = "SELECT * FROM usersystems WHERE nameUser=?;";
            consult = sql.prepareStatement(squery);
            consult.setString(1, user);
            ResultSet res = consult.executeQuery();
            return res.next() ? 1 : 0;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloRecu.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public String sentCode(String nameUser) {
        try {
            Connection sql = ControladorConexion.getConection();
            String squery = "SELECT mailUser FROM UserSystems WHERE nameUser=?";
            consult = sql.prepareStatement(squery);
            consult.setString(1, nameUser);
            ResultSet res = consult.executeQuery();
            String data = "";
            while (res.next()) {
                data = res.getString("mailUser");
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloRecu.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int ActualizarPWD(String Pword, String mail) {
        try {
            Connection sql = ControladorConexion.getConection();
            String query = "UPDATE UserSystems SET Pword = ?  WHERE mailUser= ?";
            consult = sql.prepareStatement(query);
            consult.setString(1, Pword);
            consult.setString(2, mail);
            int rowsAffected = consult.executeUpdate();

            return rowsAffected > 0 ? 1 : 0;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloRecu.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
