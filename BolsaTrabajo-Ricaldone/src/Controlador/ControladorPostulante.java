/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author Jonathan
 */
public class ControladorPostulante {

    public static int AgreparPostulante(LinkedHashMap<String, String> dataMap) throws Exception {
        return Modelo.ModeloPostulante.AgregarPostulante(dataMap);
    }

    public static int ActualizarPostulante(LinkedHashMap<String, String> dataMap) throws Exception {
        return Modelo.ModeloPostulante.ActualizarPostulante(dataMap);
    }

    public ResultSet MostrarTablaControlador() throws Exception {
        return Modelo.ModeloPostulante.mostrarTabla();
    }

}
