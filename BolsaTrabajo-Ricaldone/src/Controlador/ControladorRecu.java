/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import com.finalhints.HttpClient;
import com.finalhints.Request;
import com.finalhints.RequestMethod;
import com.finalhints.Response;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import java.util.*;
import org.jfree.io.IOUtils;
import Modelo.ModeloUtils;
import Modelo.ModeloRecu;

/**
 * Class for password recovery methods.
 *
 * @author Kevin Rivas
 */
public class ControladorRecu {

    /**
     * Variable for a random number.
     */
    public static int randomCode;
    /**
     * Object from ModeloRecu.
     */
    ModeloRecu recumodel = new ModeloRecu();
    /**
     * Object from ModeloUtils.
     */
    ModeloUtils utils = new ModeloUtils();

    /**
     * Method to validate same user.
     *
     * @param user
     * @return
     */
    public int RecuperacionPWD(String user) {

        return recumodel.RecuperacionPWD(user);

    }

    /**
     * Method to send a code by mail.
     *
     * @param nameUser
     * @return
     */
    public String SentCode(String nameUser) {
        try {
            Random rand = new Random();
            randomCode = rand.nextInt(999999);
            Request request = new Request("http://localhost:3000/api/email", RequestMethod.POST);
            String emailString = recumodel.sentCode(nameUser);
            //Form-Data
            request.form("email", emailString)
                    .form("Codigo", randomCode)
                    .form("subject", "Código de verificación de Sacculum")
                    .form("text", "Tu código de verificación es: ")
                    .form("base64", "");

            Response response = new HttpClient(request).execute();
            if (response.getStatusCode() == 200) {
                JOptionPane.showMessageDialog(null, "Email enviado con exito, por favor verifica en SPAM.");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error");
            }
            return emailString;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    /**
     * Method to validate that the entered code is the same as the sent one.
     *
     * @param code
     * @return
     */
    public static int Verificacion(String code) {
        int retorno;
        retorno = 1;
        try {
            int intcode;
            intcode = Integer.parseInt(code);
            if (intcode == randomCode && randomCode != 0) {
                JOptionPane.showMessageDialog(null, "El codigo es correcto");
                randomCode = 0;
            } else {
                JOptionPane.showMessageDialog(null, "El codigo ingresado no es correcto o ya a sido utilizado","Error",0);
                retorno = retorno + 1;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No dejar espacios vacios","Error",0);
            return retorno = 0;
        }
        return retorno;
    }

    /**
     * Method to update the password.
     *
     * @param Pword
     * @param mailUser
     * @return
     */
    public int ActualizarPWD(String Pword, String mailUser) {
        return recumodel.ActualizarPWD(Pword, mailUser);

    }
}
