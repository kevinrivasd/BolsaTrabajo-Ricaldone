/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import Modelo.ModeloPostulante;

/**
 *
 * @author Jonathan
 */
public class ControladorPostulante {
    ModeloPostulante modelpost = new ModeloPostulante();

    public int AgreparPostulante(LinkedHashMap<String, String> dataMap) {
        return modelpost.AgregarPostulante(dataMap);
    }

    public int ActualizarPostulante(LinkedHashMap<String, String> dataMap){
        return modelpost.ActualizarPostulante(dataMap);
    }

    public ResultSet MostrarTablaControlador(){
        return modelpost.mostrarTabla();
    }
    
    public ResultSet MostrarTablaVControlador(){
        return modelpost.mostrarTablaV();
    }
    
    public ResultSet TablaCRUD_VController(){
        return modelpost.TablaCRUD_V();
    }

}
