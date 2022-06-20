/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ControladorConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hello
 */
public class ModeloLogin {
    public static int Login(String user, String password) throws Exception{
            Connection sql = ControladorConexion.getConection();
            String squery = "SELECT * FROM userSystems WHERE nameUser= ? AND Pword=?" ;
            PreparedStatement consult = sql.prepareStatement(squery);
            consult.setString(1, user);
            consult.setString(2, password);

            ResultSet res = consult.executeQuery();
           
            return res.next()? 1:0;
    }
}
