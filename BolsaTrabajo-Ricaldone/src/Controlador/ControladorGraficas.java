/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hello
 */
public class ControladorGraficas {
    public static DefaultTableModel agruparPersona() throws Exception{
        return Modelo.ModeloUtils.agruparPersona();
    }
}
