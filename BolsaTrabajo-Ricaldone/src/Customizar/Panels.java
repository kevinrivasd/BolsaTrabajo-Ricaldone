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
 * Class used to create boxes or panel configurations in general, organizing the
 * content.
 *
 * @author Kevin Rivas
 */
public class Panels {

    /**
     * Class used to create visual applicant boxes to be displayed in the
     * statistics.
     *
     * @param namePostulant
     * @param LastName
     * @param Progress
     * @param panelcontenedor
     */
    public void CrearPostulantes(String namePostulant, String LastName, String Progress, JPanel panelcontenedor) {

        //Crear componentes
        JPanel container = new JPanel();

        JLabel lblnombre = new JLabel(namePostulant + " " + LastName);
//                JLabel lblapellido = new JLabel(LastName);
        JLabel lblestado = new JLabel(Progress);
        JPanel colorestado = new JPanel();

        //Dimensiones
        lblestado.setPreferredSize(new Dimension(150, 40));
        container.setPreferredSize(new Dimension(1040, 40));
        lblnombre.setPreferredSize(new Dimension(700, 40));
//                lblapellido.setPreferredSize(new Dimension(600, 40));
        colorestado.setPreferredSize(new Dimension(35, 35));

        //Color y tipo de letra
        container.setBackground(Color.white);
        lblestado.setForeground(Color.black);
        lblnombre.setForeground(Color.black);
//                lblapellido.setForeground(Color.black);
        lblestado.setHorizontalAlignment(JLabel.RIGHT);

        //Añadir componentes al principal
        container.add(lblnombre);
//                container.add(lblapellido);
        container.add(colorestado);
        container.add(lblestado);

        //        container.setRoundTopLeft(20);
        //        container.setRoundTopRight(20);
        //        container.setRoundBottomRight(20);
        //        container.setRoundBottomLeft(20);
        switch (Progress) {
            case "Información Solicitada":
                colorestado.setBackground(new Color(50, 63, 27));
                break;
            case "Información Enviada":
                colorestado.setBackground(new Color(132, 175, 75));
                break;
            default:
                colorestado.setBackground(new Color(57, 83, 34));
                break;
        }

        //Agregas a la interfaz
        panelcontenedor.add(container);
        panelcontenedor.repaint();
        panelcontenedor.revalidate();

    }
}
