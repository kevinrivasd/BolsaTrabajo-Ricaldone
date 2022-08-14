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

/**
 *
 * @author Kevin Rivas
 */
public class ModeloRecu {
   
    public static int RecuperacionPWD (String user) throws Exception{
        Connection sql = ControladorConexion.getConection(); 
        String squery = "SELECT * FROM usersystems WHERE nameUser=?;";
        PreparedStatement consult = sql.prepareStatement(squery);
        consult.setString(1, user);
        ResultSet res = consult.executeQuery();
        return res.next() ? 1:0;
    }

    public static String sentCode (String nameUser) throws Exception{
        Connection sql = ControladorConexion.getConection(); 
        String squery = "SELECT mailUser FROM UserSystems WHERE nameUser=?";
        PreparedStatement consult = sql.prepareStatement(squery); 
        consult.setString(1, nameUser);
        ResultSet res = consult.executeQuery();
        String data = "";
         while (res.next()) {
            data = res.getString("mailUser");            
        }
         return data;
    }
    
    public static int ActualizarPWD( String Pword, String mail) throws Exception, Exception {
        Connection sql = ControladorConexion.getConection();
        String query = "UPDATE UserSystems SET Pword = ?  WHERE mailUser= ?";
        PreparedStatement consult = sql.prepareStatement(query);
        consult.setString(1, Pword);
        consult.setString(2, mail);
        int rowsAffected = consult.executeUpdate();


        return rowsAffected > 0 ? 1 : 0;
    }
}
