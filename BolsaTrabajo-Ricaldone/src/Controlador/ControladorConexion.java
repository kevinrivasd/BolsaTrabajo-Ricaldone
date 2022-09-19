/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import Modelo.ModeloConexion;

/**
 * class made for connection.
 *
 * @author hello
 */
public class ControladorConexion {

    /**
     * This method is used to return the connection query and used in the view.
     *
     * @return
     */
    public static Connection getConection() {
        return ModeloConexion.Conectar();
    }
}
