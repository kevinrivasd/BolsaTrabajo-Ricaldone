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

/**
 *
 * @author hello
 */
public class ModeloLogin {

    PreparedStatement consult;

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
}
