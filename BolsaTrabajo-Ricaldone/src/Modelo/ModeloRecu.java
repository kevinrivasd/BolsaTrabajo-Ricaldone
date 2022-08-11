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
        String squery = "SELECT * FROM usersystems WHERE nameUser=?, mailUser=? ";
        PreparedStatement consult = sql.prepareStatement(squery);
        consult.setString(1, user);
        ResultSet res = consult.executeQuery();
        return res.next() ? 1:0;
}

public static String sentCode (String nameUser) throws Exception{
        Connection sql = ControladorConexion.getConection(); 
        String squery = "SELECT mailUser FROM Userystem WHERE nameUser =?";
        PreparedStatement consult = sql.prepareStatement(squery); 
        consult.setString(1, nameUser);
        ResultSet res = consult.executeQuery();
        String data = "";
         while (res.next()) {
            data = res.getString("mailUser");            
        }
         return data;
        }
}
