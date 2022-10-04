/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.ModeloLogin;

/**
 * class designed to mediate the login.
 *
 * @author hello
 */
public class ControladorLogin {

    /**
     * Object from ModeloLogin.
     */
    ModeloLogin login = new ModeloLogin();

    /**
     * login method to capture username and password, encrypting the password.
     *
     * @param user
     * @param password
     * @return
     */
    public String Login(String user, char[] password) {
        try {
            String i = "";
            String claveEncrypt = Utils.encrypt(password);
            return login.Login(user, claveEncrypt);
        } catch (Exception ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * With this method we consult the base the state of the users to verify that they are not blocked
     * @param user
     * @param password
     * @return 
     */
    public String EstadoC(String user, char[] password) {
        try {
            String i = "";
            String claveEncrypt = Utils.encrypt(password);
            return login.Estado(user, claveEncrypt);
        } catch (Exception ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    public int PrimerUsoController(String us){
        return  login.PrimerUso(us);
    }
    
    public int UpdatePrimerUsoCOntroller(String us){
        return login.UpdateFirstUse(us);
    }
}
