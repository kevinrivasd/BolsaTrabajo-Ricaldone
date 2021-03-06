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
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
/**
 *
 * @author hello
 */
public class ModeloUtils {
    
    //specific field
    public static List<String> getData(String sqlTable, String campoString) throws SQLException, Exception{        
        List<String> data = new ArrayList<>();
        
        Connection sql = ControladorConexion.getConection();
        
        String squery = "SELECT * FROM "+sqlTable ;
        PreparedStatement consult = sql.prepareStatement(squery);

        ResultSet res = consult.executeQuery();
        
        while (res.next()) {
            data.add(res.getString(campoString));            
        }
        return data;
    }
    
    //whole table as RS
    public static ResultSet getTable(String sqlTable) throws SQLException, Exception{
        
        Connection sql = ControladorConexion.getConection();
        
        String squery = "SELECT * FROM "+sqlTable ;
        PreparedStatement consult = sql.prepareStatement(squery);

        ResultSet res = consult.executeQuery();
        
        return res;
    }
    
    //whole table as RS
    public static HashMap<Integer, String> getTableHM(String sqlTable) throws SQLException, Exception{
        
        HashMap<Integer, String> data = new HashMap<>();        
        Connection sql = ControladorConexion.getConection();
        
        String squery = "SELECT * FROM "+sqlTable ;
        PreparedStatement consult = sql.prepareStatement(squery);

        ResultSet res = consult.executeQuery();

        while(res.next()) {
            data.put(res.getInt(1),res.getString(2));
        }
        return data;

    }
    
    public static int Eliminar(String idUsuario, String table) throws Exception {
        Connection sql = ControladorConexion.getConection();
        String squery = "DELETE FROM "+table+" WHERE idUser=?";
        PreparedStatement consult = sql.prepareStatement(squery);
        
        //Sacando values del HashMap        
//        consult.setString(1,table);        
        consult.setInt(1,Integer.parseInt(idUsuario));        

        boolean res = consult.execute();
           
        return res ? 0:1;
    }

    public static int Actualizar(LinkedHashMap<String, String> dataMap, String id, String tabla) throws SQLException, Exception {
        //Getting connection pool
        Connection sql = ControladorConexion.getConection();
         
         
        //Init del SB con el UPDATE y la tabla
        StringBuilder query = new StringBuilder("UPDATE "+tabla+" SET ");
        
        //Tama??o del HM para poder chequear si es el ultimo registro o no
        int mapSize = dataMap.size();
        //Index del for
        int countFirst = 0;
        
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            countFirst++;
            //sacando valor de las llaves del HM
            Object key = entry.getKey();
            //insertandolo al SB
            query.append(key.toString()).append(countFirst == mapSize ? "= ? ":"= ?, ");
        }
        
        //FIN DE LA QUERY
        query.append("WHERE idUser =").append(id);
        
        
        //init de la consulta con el SB a string
        PreparedStatement consult = sql.prepareStatement(query.toString());
        
        int count=1;
         for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            
            //checkeando si deberia ser setInt o setString
             if (key.toString().contains("id")) {
                   consult.setInt(count, Integer.valueOf(val.toString()));
             }else{
                   consult.setString(count, val.toString());
             }

               count++;
        }
         
//         return 1;
        int rowsAffected = consult.executeUpdate();


        return rowsAffected > 0 ? 1 : 0;
    }
    
    public static int Agregar(LinkedHashMap<String,String> dataMap, String tabla) throws SQLException, Exception{
        Connection sql = ControladorConexion.getConection();
        
        StringBuilder query = new StringBuilder("INSERT INTO "+tabla+" VALUES (");
        
        //Tama??o del HM para poder chequear si es el ultimo registro o no
        int mapSize = dataMap.size();
        //Index del for
        int countFirst = 0;
        
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            countFirst++;
            //sacando valor de las llaves del HM
            
            //insertandolo al SB
            query.append(countFirst == mapSize ? "?);":"?, ");
        }
        
        JOptionPane.showMessageDialog(null, query);
        //init de la consulta con el SB a string
        PreparedStatement consult = sql.prepareStatement(query.toString());
        
        int count=1;
        
         for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            
            //checkeando si deberia ser setInt o setString
             if (key.toString().contains("id")) {
                   consult.setInt(count, Integer.valueOf(val.toString()));
             }else{
                   consult.setString(count, val.toString());
             }

               count++;
        }
        

        int rowsAffected = consult.executeUpdate();


        return rowsAffected > 0 ? 1 : 0;
    }

}
