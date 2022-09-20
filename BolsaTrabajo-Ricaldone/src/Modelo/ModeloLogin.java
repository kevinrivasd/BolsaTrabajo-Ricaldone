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
     * @param Estado
     * @param user
     * @param password
     * @return
     */
    public String Login(int Estado, String user, String password) {
        try {
            Connection sql = ControladorConexion.getConection();
            if (Estado == 2) {
                JOptionPane.showMessageDialog(null, "Bloqueado");
            } else {
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
            }

        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int EstadoBloq(int Estado) {
        try {
            int h = 1;
            Connection sql = ControladorConexion.getConection();
            if (Estado == 2) {
                JOptionPane.showMessageDialog(null, Estado);
            } else {
                String squery = "SELECT * FROM UserSystems WHERE idState = ?";
                consult = sql.prepareStatement(squery);
                consult.setInt(1, Estado);
                consult.execute();
//                ResultSet res = consult.executeQuery();
            }
            return h;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
