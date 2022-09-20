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
import java.sql.ResultSet;
import Controlador.ControladorPostulante;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin Rivas
 */
public class Panels {

    public void CrearPostulantes(String namePostulant, String Progress, JPanel panelcontenedor) {
                
                //Crear componentes
                JPanel container = new JPanel();

                JLabel lblnombre = new JLabel(namePostulant);
                JLabel lblestado = new JLabel(Progress);
                JPanel colorestado = new JPanel();

                //Dimensiones
                lblestado.setPreferredSize(new Dimension(100, 50));
                container.setPreferredSize(new Dimension(500, 50));
                lblnombre.setPreferredSize(new Dimension(490, 50));
                colorestado.setPreferredSize(new Dimension(30, 30));

                //Color y tipo de letra
                container.setBackground(new Color(32, 32, 32));
                lblestado.setForeground(Color.white);
                lblnombre.setForeground(Color.white);
                lblestado.setHorizontalAlignment(JLabel.RIGHT);

                //Añadir componentes al principal
                container.add(lblnombre);
                container.add(colorestado);
                container.add(lblestado);

                //        container.setRoundTopLeft(20);
                //        container.setRoundTopRight(20);
                //        container.setRoundBottomRight(20);
                //        container.setRoundBottomLeft(20);
//                switch (Progress) {
//                    case "1":
//                        colorestado.setBackground(new Color(132, 175, 75));
//                        break;
//                    case "2":
//                        colorestado.setBackground(new Color(132, 175, 75));
//                        break;
//                    case "3":
//                        colorestado.setBackground(new Color(132, 175, 75));
//                        break;
//                    case "4":
//                        colorestado.setBackground(new Color(132, 175, 75));
//                        break;
//                    case "5":
//                        colorestado.setBackground(new Color(132, 175, 75));
//                        break;
//                    case "6":
//                        colorestado.setBackground(new Color(132, 175, 75));
//                        break;
//                    default:
//                        colorestado.setBackground(new Color(57, 83, 34));
//                        break;
//                }
            
                //Agregas a la interfaz
                panelcontenedor.add(container);
                panelcontenedor.repaint();
                panelcontenedor.revalidate();
            
    }
}
