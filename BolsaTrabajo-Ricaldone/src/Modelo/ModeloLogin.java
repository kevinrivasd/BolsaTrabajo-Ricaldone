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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * This class contains the method we use to validate credentials at login
 *
 * @author hello
 */
public class ModeloLogin {

    PreparedStatement consult;

    /**
     * This method is used to validate the credentials, calling a model to make
     * the query
     *
     * @param user
     * @param password
     * @return
     */
    public String Login(String user, String password) {
        try {
            Connection sql = ControladorConexion.getConection();
            String squery = "SELECT idUser FROM UserSystems WHERE nameUser= ? AND Pword=?";
            consult = sql.prepareStatement(squery);
            consult.setString(1, user);
            consult.setString(2, password);

            ResultSet res = consult.executeQuery();
            String id = "";
            while (res.next()) {
                id += res.getInt("idUser");
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * We use this method to verify the status of the users
     *
     * @param user
     * @param password
     * @return
     */
    public String Estado(String user, String password) {
        try {
            Connection sql = ControladorConexion.getConection();
            String squery = "SELECT idState FROM UserSystems WHERE nameUser= ? AND Pword=?";
            consult = sql.prepareStatement(squery);
            consult.setString(1, user);
            consult.setString(2, password);

            ResultSet res = consult.executeQuery();
            String id = "";
            while (res.next()) {
                id += res.getInt("idState");
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int PrimerUso(String user) {
        try {
            Connection sql = ControladorConexion.getConection();
            String squery = "SELECT firstUse FROM UserSystems WHERE nameUser= ?";
            consult = sql.prepareStatement(squery);
            consult.setString(1, user);
            ResultSet res = consult.executeQuery();
            int id = 0;
            while (res.next()) {
                id += res.getInt("firstUse");
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int UpdateFirstUse(String user) {
        try {
            Connection sql = ControladorConexion.getConection();
            String query = "UPDATE UserSystems SET firstUse = 1 WHERE nameUser = ?";
            consult = sql.prepareStatement(query);
            consult.setString(1, user);
            int rowsAffected = consult.executeUpdate();
            return rowsAffected > 0 ? 1 : 0;
        } catch (Exception e) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, e);
            return 0;
        }
    }
}
