/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import Modelo.ModeloConexion;

/**
 *
 * @author hello
 */
public class ControladorConexion {

    public static Connection getConection() {
        return ModeloConexion.Conectar();
    }
}
