/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author hello
 */
public class ControladorLogin {
    public static String Login(String user, char[] password) throws Exception{
        
        return Modelo.ModeloLogin.Login(user, Utils.encrypt(password));        
    
    }
}
