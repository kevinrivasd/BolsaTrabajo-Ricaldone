/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customizar;

import Vista.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kevin Rivas
 */
public class Panels {
    
    public void CrearPostulantes(String nombre, String estado, JPanel PEstadisticas) {
        //Crear componentes
        JPanel container = new JPanel();

        JLabel lblnombre = new JLabel(nombre);
        JLabel lblestado = new JLabel(estado);
        JPanel colorestado = new JPanel();
        
        //Dimensiones
        lblestado.setPreferredSize(new Dimension(100, 50));
        container.setPreferredSize(new Dimension(500, 50));
        lblnombre.setPreferredSize(new Dimension(350, 50));
        colorestado.setPreferredSize(new Dimension(30, 30));
        
        //Color y tipo de letra
        container.setBackground(Color.red);
        lblestado.setForeground(Color.white);
        lblestado.setHorizontalAlignment(JLabel.RIGHT);
        
        //Añadir componentes al principal
        container.add(lblnombre);
        container.add(colorestado);
        container.add(lblestado);

//        container.setRoundTopLeft(20);
//        container.setRoundTopRight(20);
//        container.setRoundBottomRight(20);
//        container.setRoundBottomLeft(20);
        switch (estado) {
            case "Disponible":
                colorestado.setBackground(Color.green);
                break;
            default:
                colorestado.setBackground(Color.black);
                break;
        }

        //Agregas a la interfaz
        PEstadisticas.add(container);
        PEstadisticas.repaint();
        PEstadisticas.revalidate();
    }
}
