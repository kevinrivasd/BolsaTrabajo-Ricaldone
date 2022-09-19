/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ModeloNotificaciones;
import java.sql.ResultSet;

/**
 * Class to control the moderation or notifications of the web portal.
 *
 * @author Jonathan
 */
public class ControladorNotificaciones {

    /**
     * Object from ModeloNotificaciones.
     */
    Modelo.ModeloNotificaciones model = new ModeloNotificaciones();

    /**
     * idMod Attributes.
     */
    public int idMod;
    /**
     * namePostulant Attributes.
     */
    public String namePostulant;
    /**
     * dateMod Attributes.
     */
    public String dateMod;
    /**
     * context Attributes.
     */
    public String context;
    /**
     * Request Attributes.
     */
    public String request;
    /**
     * RequestInfo Attributes.
     */
    public String requestInfo;
    /**
     * NameUser attributes
     */
    public String nameUser;

    /**
     * Get idMod.
     *
     * @return
     */
    public int getIdMod() {
        return idMod;
    }

    /**
     * Set idMod.
     *
     * @param idMod
     */
    public void setIdMod(int idMod) {
        this.idMod = idMod;
    }

    /**
     * Get NamePostulant.
     *
     * @return
     */
    public String getNamePostulant() {
        return namePostulant;
    }

    /**
     * set NamePostulant.
     *
     * @param namePostulant
     */
    public void setNamePostulant(String namePostulant) {
        this.namePostulant = namePostulant;
    }

    /**
     * Get DateMod.
     *
     * @return
     */
    public String getDateMod() {
        return dateMod;
    }

    /**
     * Set DateMod.
     *
     * @param dateMod
     */
    public void setDateMod(String dateMod) {
        this.dateMod = dateMod;
    }

    /**
     * Get Context.
     *
     * @return
     */
    public String getContext() {
        return context;
    }

    /**
     * Set Context.
     *
     * @param context
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * Get Request.
     *
     * @return
     */
    public String getRequest() {
        return request;
    }

    /**
     * Set Request.
     *
     * @param request
     */
    public void setRequest(String request) {
        this.request = request;
    }

    /**
     * Get RequestedInfo.
     *
     * @return
     */
    public String getRequestInfo() {
        return requestInfo;
    }

    /**
     * Set RequestedInfo.
     *
     * @param requestInfo
     */
    public void setRequestInfo(String requestInfo) {
        this.requestInfo = requestInfo;
    }

    /**
     * Get NameUser
     *
     * @return
     */
    public String getNameUser() {
        return nameUser;
    }

    /**
     * Set NameUser
     *
     * @param nameUser
     */
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    /**
     * method used to return the query from the table or view.
     *
     * @return
     */
    public ResultSet CargarNotificacionsControlador() {
        return model.CargarNotificaciones();
    }
}
