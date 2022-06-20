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
    public static int Login(String user, char[] password) throws Exception{
        String baseString = "";        
        for (char c : password) {
            baseString += c+3;
        }
        
        //juanromero
        return Modelo.ModeloLogin.Login(user,baseString);        
    }
}
