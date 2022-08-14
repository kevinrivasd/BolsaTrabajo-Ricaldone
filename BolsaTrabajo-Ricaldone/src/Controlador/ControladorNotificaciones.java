/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ModeloNotificaciones;
import java.sql.ResultSet;

/**
 *
 * @author Jonathan
 */
public class ControladorNotificaciones {
    Modelo.ModeloNotificaciones model = new ModeloNotificaciones();
    
    public int idMod;
    public String namePostulant;
    public String dateMod;
    public String context;
    public String request;
    public String requestInfo;
    public String nameUser;

    public int getIdMod() {
        return idMod;
    }

    public void setIdMod(int idMod) {
        this.idMod = idMod;
    }

    public String getNamePostulant() {
        return namePostulant;
    }

    public void setNamePostulant(String namePostulant) {
        this.namePostulant = namePostulant;
    }

    public String getDateMod() {
        return dateMod;
    }

    public void setDateMod(String dateMod) {
        this.dateMod = dateMod;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(String requestInfo) {
        this.requestInfo = requestInfo;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

 
    
    
    public ResultSet CargarNotificacionsControlador(){
       return model.CargarNotificaciones();
    }
}
