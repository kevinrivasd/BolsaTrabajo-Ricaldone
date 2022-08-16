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
import javax.swing.table.DefaultTableModel;
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
    //specific field
    public static List<String> getUserData(String username) throws SQLException, Exception{        
        List<String> data = new ArrayList<>();
        
        Connection sql = ControladorConexion.getConection();
        
        String squery = "SELECT nameUser,mailUser,idRol,idUser FROM UserSystems WHERE idUser=?";
        PreparedStatement consult = sql.prepareStatement(squery);
        consult.setString(1, username);

        ResultSet res = consult.executeQuery();
        
        while (res.next()) {
            data.add(res.getString("nameUser"));            
            data.add(res.getString("mailUser"));            
            data.add(res.getString("idRol"));            
            data.add(res.getString("idUser"));            
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
    public static ResultSet getTable(String sqlTable, String[] colStrings, String idString) throws SQLException, Exception{
        
        Connection sql = ControladorConexion.getConection();
        
         StringBuilder querTemp = new StringBuilder("SELECT ");
         
          int size = colStrings.length;
          
         for(int k=0;k<colStrings.length;k++){
             querTemp.append(k != size-1 ? colStrings[k]+",":colStrings[k]);             
         }
         
         
         querTemp.append(" FROM ").append(sqlTable).append(" WHERE idPostulant = ").append(idString).append(";");
         
         
         PreparedStatement consult = sql.prepareStatement(querTemp.toString());

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
    
    public static int Eliminar(String idUsuario, String table, String campo) throws Exception {
        Connection sql = ControladorConexion.getConection();
        StringBuilder squery = new StringBuilder("DELETE FROM "+table+" WHERE ");
        
        squery.append(campo).append("= ?;");
        PreparedStatement consult = sql.prepareStatement(squery.toString());
        
        //Sacando values del HashMap        
//        consult.setString(1,table);        
        consult.setInt(1,Integer.parseInt(idUsuario));        

        boolean res = consult.execute();
           
        return res ? 0:1;
    }

    public static int Actualizar(LinkedHashMap<String, String> dataMap, String id, String tabla, String idCompare) throws SQLException, Exception {
        //Getting connection pool
        Connection sql = ControladorConexion.getConection();
         
         
        //Init del SB con el UPDATE y la tabla
        StringBuilder query = new StringBuilder("UPDATE "+tabla+" SET ");
        
        //Tamaño del HM para poder chequear si es el ultimo registro o no
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
        query.append("WHERE ").append(idCompare).append("=").append(id);
        
        
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
        
        //Tamaño del HM para poder chequear si es el ultimo registro o no
        int mapSize = dataMap.size();
        //Index del for
        int countFirst = 0;
        
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            countFirst++;
            //sacando valor de las llaves del HM
            
            //insertandolo al SB
            query.append(countFirst == mapSize ? "?);":"?, ");
        }   
        
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
        public static DefaultTableModel agruparPersona() throws Exception{

        DefaultTableModel miModelo = null;
        Connection cn = ControladorConexion.getConection();
        try{
            String titulos []= {"namePostulant", "States"};
            String dts [] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            String sql = "SELECT Progress.Progress, COUNT(Postulants.namePostulant) as Countp  "
                    + "FROM Progress "
                    + "INNER JOIN Postulants ON Progress.idProgress = Postulants.Progress "
                    + "GROUP BY Progress.Progress";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               dts[0] = rs.getString("Progress");
               dts[1] = rs.getString("Countp");
               miModelo.addRow(dts);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return miModelo;
    }   

    public static String getPDF(String toString) throws SQLException, Exception {
               String b64 = "";

        Connection sql = ControladorConexion.getConection();

        String squery = "SELECT resumePDF FROM Postulants WHERE idPostulant = 2;" ;
        PreparedStatement consult = sql.prepareStatement(squery);

        ResultSet res = consult.executeQuery();

        while (res.next()) {
            b64 += res.getString("resumePDF");            
        }
        return b64;

    }

}
