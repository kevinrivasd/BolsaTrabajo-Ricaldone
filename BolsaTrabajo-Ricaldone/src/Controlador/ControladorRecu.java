/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import static java.lang.ProcessBuilder.Redirect.to;
import java.util.Properties;
import java.util.Random;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeJava.to;
import sun.rmi.transport.Transport;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author Kevin Rivas
 */
public class ControladorRecu {
    public static int  randomCode;
            
    public static int RecuperacionPWD(String user) throws Exception{
        
        return Modelo.ModeloRecu.RecuperacionPWD(user);        
    
    }
    
    
        public static void SentCode (String mailUser){
            
            try{
                Random rand = new Random();
                randomCode = rand.nextInt(999999);
                String host = "smtp.gmail.com";
                String maill = "bolsaricald2022@gmail.com";
                String pass = "bolsadetrabajo";
                String correo = Modelo.ModeloRecu.sentCode(mailUser);
                String subject = "Codio de restablecimiento";
                String message = "Tu codigo de restablecimiento es: "+randomCode;
                boolean sessionDebug = false;
                Properties pros = System.getProperties();
                pros.put("mail.smtp.starttls.enable", "true");
                pros.put("mail.smtp.host", "host");
                pros.put("mail.smtp.port", "587");
                pros.put("mail.smtp.auth", "true");
                pros.put("mail.smtp.starttls.required", "true");
                java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                Session mailSession = Session.getDefaultInstance(pros, null);
                mailSession.setDebug(sessionDebug);
                Message msg = new MimeMessage(mailSession);
                msg.setFrom(new InternetAddress(maill));
                InternetAddress [] address = {new InternetAddress(correo)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(subject);
                msg.setText(message);
                Transport transport = mailSession.getTransport("smtp");
                transport.connect(host, maill, pass);
                transport.sendMessage(msg, msg.getAllRecipients());
                transport.close();
                JOptionPane.showMessageDialog(null, "El codigo se a enviado a tu correo");
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
        }
}                            







