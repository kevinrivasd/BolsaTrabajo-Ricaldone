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
    
    public ResultSet CargarUsuariosController(){
    return ModeloUsuarios.CargarUsuarios();
}

}
