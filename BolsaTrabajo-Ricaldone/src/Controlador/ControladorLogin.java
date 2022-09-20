/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.ModeloLogin;
import java.sql.ResultSet;

/**
 * class designed to mediate the login.
 *
 * @author hello
 */
public class ControladorLogin {
    
    int idUser;
    int idState;
    String nameUser;
    String Pword;
    String mailUser;
    int numberUser;
    int idRol;
    int mailverification;
    int idGender;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPword() {
        return Pword;
    }

    public void setPword(String Pword) {
        this.Pword = Pword;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public int getNumberUser() {
        return numberUser;
    }

    public void setNumberUser(int numberUser) {
        this.numberUser = numberUser;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getMailverification() {
        return mailverification;
    }

    public void setMailverification(int mailverification) {
        this.mailverification = mailverification;
    }

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }
    

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
            return login.Login(idState,user, claveEncrypt);
        } catch (Exception ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int EstadoBloqController(){
        return login.EstadoBloq(idState);
    }
}
