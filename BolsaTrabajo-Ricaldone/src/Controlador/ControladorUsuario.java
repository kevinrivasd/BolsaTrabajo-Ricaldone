/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import Modelo.ModeloUsuarios;

/**
 * class to manage users.
 * @author Kevin Rivas
 */
public class ControladorUsuario {

    /**
     * Object from ModeloUsuarios.
     */
    ModeloUsuarios modeluser = new ModeloUsuarios();

    /**
     * method to load the table or view.
     * @return 
     */
    public ResultSet CargarUsuariosController() {
        return modeluser.CargarUsuarios();
    }

    /**
     * idUser attribute.
     */
    public int idUser;
    /**
     * idState attribute.
     */
    public String idState;
    /**
     * nameUser attribute.
     */
    public String nameUser;
    /**
     * Pword attribute.
     */
    public String Pword;
    /**
     * mailUser attribute.
     */
    public String mailUser;
    /**
     * numberUser attribute.
     */
    public int numberUser;
    /**
     * idRol attribute.
     */
    public String idRol;
    /**
     * mailverification attribute.
     */
    public int mailverification;
    /**
     * idGender attribute.
     */
    public String idGender;

    /**
     * get IdUser.
     * @return 
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * set IdUser.
     * @param idUser 
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * get IdState.
     * @return 
     */
    public String getIdState() {
        return idState;
    }

    /**
     * set IdState.
     * @param idState 
     */
    public void setIdState(String idState) {
        this.idState = idState;
    }

    /**
     * get NameUser.
     * @return 
     */
    public String getNameUser() {
        return nameUser;
    }

    /**
     * set NameUser.
     * @param nameUser 
     */
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    /**
     * Get Pword.
     * @return 
     */
    public String getPword() {
        return Pword;
    }

    /**
     * Set Pword.
     * @param Pword 
     */
    public void setPword(String Pword) {
        this.Pword = Pword;
    }

    /**
     * Get MailUser.
     * @return 
     */
    public String getMailUser() {
        return mailUser;
    }

    /**
     * Set MailUser.
     * @param mailUser 
     */
    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    /**
     * Get NumberUser.
     * @return 
     */
    public int getNumberUser() {
        return numberUser;
    }

    /**
     * Set NumberUser.
     * @param numberUser 
     */
    public void setNumberUser(int numberUser) {
        this.numberUser = numberUser;
    }

    /**
     * Get IdRol.
     * @return 
     */
    public String getIdRol() {
        return idRol;
    }

    /**
     * Set IdRol.
     * @param idRol 
     */
    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    /**
     * Get Mailverification.
     * @return 
     */
    public int getMailverification() {
        return mailverification;
    }

    /**
     * set Mailverification.
     * @param mailverification 
     */
    public void setMailverification(int mailverification) {
        this.mailverification = mailverification;
    }

    /**
     * get IdGender.
     * @return 
     */
    public String getIdGender() {
        return idGender;
    }

    /**
     * Set IdGender.
     * @param idGender 
     */
    public void setIdGender(String idGender) {
        this.idGender = idGender;
    }

    /**
     * Constructor empty from ControladorUser.
     */
    public ControladorUsuario() {
    }

    /**
     * validation on equal users.
     * @param user
     * @param iduser
     * @return 
     */
    public boolean ValidarUserController(String user, String iduser) {
        
        boolean resultado = false;
        resultado = modeluser.ValidarUser(user, iduser);
        return resultado;
    }
    
    /**
     * validation on equal emails.
     * @param mail
     * @param iduser
     * @return 
     */
    public boolean ValidarMailController(String mail, String iduser) {
        boolean resultado = false;
        resultado = modeluser.ValidarMail(mail, iduser);
        return resultado;
    }

}
