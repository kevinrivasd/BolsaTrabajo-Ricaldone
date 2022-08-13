/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import com.finalhints.HttpClient;
import com.finalhints.Request;
import com.finalhints.RequestMethod;
import com.finalhints.Response;
import javax.swing.JOptionPane;
import javax.net.ssl.SSLContext;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 *
 * @author Kevin Rivas
 */
public class ControladorRecu {
    public static int  randomCode;
            
    public static int RecuperacionPWD(String user) throws Exception{
        
        return Modelo.ModeloRecu.RecuperacionPWD(user);        
    
    }
    
    
        public static void SentCode(String mailUser){
            try{
             Random rand = new Random();
             randomCode = rand.nextInt(999999);
            Request request = new Request("http://localhost:3000/api/email", RequestMethod.POST);
            String emailString = Modelo.ModeloRecu.sentCode(mailUser);
            //Form-Data
            request.form("email", emailString).form("Codigo", randomCode);

            Response response = new HttpClient(request).execute();
                if (response.getStatusCode() == 200) {
                    JOptionPane.showMessageDialog(null, "Email enviado con exito, por favor verifica en SPAM.");
                }else{                
                    JOptionPane.showMessageDialog(null, "Hubo un error");
                }
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

        
        
        
}                            







