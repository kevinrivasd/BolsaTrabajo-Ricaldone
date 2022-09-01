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
 *
 * @author Kevin Rivas
 */
public class ControladorUsuario {

    ModeloUsuarios modeluser = new ModeloUsuarios();

    public ResultSet CargarUsuariosController() {
        return modeluser.CargarUsuarios();
    }

    public int idUser;
    public String idState;
    public String nameUser;
    public String Pword;
    public String mailUser;
    public int numberUser;
    public String idRol;
    public int mailverification;
    public String idGender;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getIdState() {
        return idState;
    }

    public void setIdState(String idState) {
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

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public int getMailverification() {
        return mailverification;
    }

    public void setMailverification(int mailverification) {
        this.mailverification = mailverification;
    }

    public String getIdGender() {
        return idGender;
    }

    public void setIdGender(String idGender) {
        this.idGender = idGender;
    }

    public ControladorUsuario() {
    }

    public boolean ValidarUserController(String user) {
        boolean resultado = false;
        resultado = modeluser.ValidarUser(user);
        return resultado;
    }
    
    public boolean ValidarMailController(String mail) {
        boolean resultado = false;
        resultado = modeluser.ValidarMail(mail);
        return resultado;
    }

}
