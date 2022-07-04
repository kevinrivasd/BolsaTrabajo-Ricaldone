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
import java.util.HashMap;

/**
 *
 * @author hello
 */
public class ModeloUsuario {
    public static int AgregarUsuario(HashMap<String,String> dataMap) throws SQLException, Exception{
        Connection sql = ControladorConexion.getConection();
        String squery = "INSERT INTO UserSystems "
                + "VALUES(?,?,?,?,?,?,?,?);" ;
        PreparedStatement consult = sql.prepareStatement(squery);
        
        //Sacando values del HashMap        
        consult.setInt(1, Integer.parseInt(dataMap.get("Estado")));        
        consult.setString(2, dataMap.get("Usuario"));
        consult.setString(3, dataMap.get("Contrasena"));
        consult.setString(4, dataMap.get("Correo"));
        consult.setString(5, dataMap.get("Numero"));
        consult.setInt(6, Integer.parseInt(dataMap.get("Rol")));
        consult.setInt(7, 1);
        consult.setInt(8, Integer.parseInt(dataMap.get("Genero")));

        boolean res = consult.execute();
           
        return res ? 1:0;
    }
}
