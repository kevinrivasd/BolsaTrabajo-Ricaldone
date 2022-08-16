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

/**
 *
 * @author Kevin Rivas
 */
public class ControladorRecu {
   public static int randomCode;
    
    public static int RecuperacionPWD(String user) throws Exception{
        
        return Modelo.ModeloRecu.RecuperacionPWD(user);        
    
    }
    
    public static String SentCode(String nameUser){
         try{
          Random rand = new Random();
          randomCode = rand.nextInt(999999);
          Request request = new Request("http://localhost:3000/api/email", RequestMethod.POST);
          String emailString = Modelo.ModeloRecu.sentCode(nameUser);
          //Form-Data
            request.form("email", emailString)
                   .form("Codigo", randomCode)
                   .form("subject", "Código de verificación de Sacculum")
                   .form("text", "Tu código de verificación es: ")
                   .form("base64", "");

          Response response = new HttpClient(request).execute();
              if (response.getStatusCode() == 200) {
                  JOptionPane.showMessageDialog(null, "Email enviado con exito, por favor verifica en SPAM.");
              }else{                
                  JOptionPane.showMessageDialog(null, "Hubo un error");
              }return emailString;
        }catch (Exception ex) {
              JOptionPane.showMessageDialog(null, ex);
          }
         return null;
    }
    
    //prueba 
    
    public static int Verificacion (String code){
        int retorno;
        retorno = 1;
        try{
            int intcode;
            intcode = Integer.parseInt(code);
            if (intcode == randomCode){
                JOptionPane.showMessageDialog(null, "El codigo es correcto");
            }else{
                JOptionPane.showMessageDialog(null, "El codigo ingresado no es correcto");
                retorno = retorno + 1;
            }
        }catch (Exception ex) {
              JOptionPane.showMessageDialog(null, ex);
          }return retorno;
    }    
    
    public static int ActualizarPWD(String Pword, String mailUser) throws Exception{
        return Modelo.ModeloRecu.ActualizarPWD(Pword, mailUser);
        
    }
}







