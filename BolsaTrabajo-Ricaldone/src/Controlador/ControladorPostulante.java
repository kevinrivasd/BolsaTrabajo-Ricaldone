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
 * Class to manage postulants
 *
 * @author Jonathan
 */
public class ControladorPostulante {

    ModeloPostulante modelpost = new ModeloPostulante();

    /**
     * Method to insert data to the table.
     *
     * @param dataMap
     * @return
     */
    public int AgreparPostulante(LinkedHashMap<String, String> dataMap) {
        return modelpost.AgregarPostulante(dataMap);
    }

    /**
     * Method to update data to the table.
     *
     * @param dataMap
     * @return
     */
    public int ActualizarPostulante(LinkedHashMap<String, String> dataMap) {
        return modelpost.ActualizarPostulante(dataMap);
    }

    /**
     * Return the table of postulants.
     *
     * @return
     */
    public ResultSet MostrarTablaControlador() {
        return modelpost.mostrarTabla();
    }

    /**
     * Return the view of postulants
     *
     * @return
     */
    public ResultSet MostrarTablaVControlador() {
        return modelpost.mostrarTablaV();
    }

    /**
     * Return the view of Postulantes CRUD
     *
     * @return
     */
    public ResultSet TablaCRUD_VController() {
        return modelpost.TablaCRUD_V();
    }
    
    public ResultSet MostrarProgreso(){
        return modelpost.ProgresoPostulants();
    }
    
    

}
