/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.HashMap;

/**
 *
 * @author hello
 */
public class ControladorUsuario {
    public static int AgregarUsuario(HashMap<String,String> dataMap) throws Exception{
        return Modelo.ModeloUsuario.AgregarUsuario(dataMap);
    }
}
