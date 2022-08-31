/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.ModeloLogin;

/**
 *
 * @author hello
 */
public class ControladorLogin {

    ModeloLogin login = new ModeloLogin();

    public String Login(String user, char [] password) {
        try {
            String i = "";
            String claveEncrypt = Utils.encrypt(password);
            return login.Login(user, claveEncrypt);
        } catch (Exception ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
