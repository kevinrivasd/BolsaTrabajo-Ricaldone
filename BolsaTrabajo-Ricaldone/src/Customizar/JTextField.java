/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customizar;

/**
 *
 * @author jonat
 */
public class JTextField {

    public void ValidacionCaracteres(java.awt.event.KeyEvent Evento) {
        if (Evento.getKeyChar() >= 32 && Evento.getKeyChar() <= 47
                || Evento.getKeyChar() >= 58 && Evento.getKeyChar() <= 64
                || Evento.getKeyChar() >= 91 && Evento.getKeyChar() <= 96
                || Evento.getKeyChar() >= 123 && Evento.getKeyChar() <= 208
                || Evento.getKeyChar() >= 210 && Evento.getKeyChar() <= 240
                || Evento.getKeyChar() >= 242 && Evento.getKeyChar() <= 255) {
            Evento.consume();
        }
    }

    public void ValidacionCaracteres_Espacio(java.awt.event.KeyEvent Evento) {
        if (Evento.getKeyChar() >= 33 && Evento.getKeyChar() <= 47
                || Evento.getKeyChar() >= 58 && Evento.getKeyChar() <= 64
                || Evento.getKeyChar() >= 91 && Evento.getKeyChar() <= 96
                || Evento.getKeyChar() >= 123 && Evento.getKeyChar() <= 208
                || Evento.getKeyChar() >= 210 && Evento.getKeyChar() <= 240
                || Evento.getKeyChar() >= 242 && Evento.getKeyChar() <= 255) {
            Evento.consume();
        }
    }

    public void ValidacionCaracteres_arroba(java.awt.event.KeyEvent Evento) {
        if (Evento.getKeyChar() >= 32 && Evento.getKeyChar() <= 44
                || Evento.getKeyChar() >= 58 && Evento.getKeyChar() <= 63
                || Evento.getKeyChar() >= 91 && Evento.getKeyChar() <= 94
                || Evento.getKeyChar() >= 96 && Evento.getKeyChar() <= 96
                || Evento.getKeyChar() >= 123 && Evento.getKeyChar() <= 208
                || Evento.getKeyChar() >= 210 && Evento.getKeyChar() <= 240
                || Evento.getKeyChar() >= 242 && Evento.getKeyChar() <= 255) {
            Evento.consume();
        }
    }

    public void ValidacionCaracteres_tilde(java.awt.event.KeyEvent Evento) {
        if (Evento.getKeyChar() >= 32 && Evento.getKeyChar() <= 47
                || Evento.getKeyChar() >= 58 && Evento.getKeyChar() <= 64
                || Evento.getKeyChar() >= 91 && Evento.getKeyChar() <= 96
                || Evento.getKeyChar() >= 123 && Evento.getKeyChar() <= 192
                || Evento.getKeyChar() >= 194 && Evento.getKeyChar() <= 200
                || Evento.getKeyChar() >= 202 && Evento.getKeyChar() <= 204
                || Evento.getKeyChar() >= 206 && Evento.getKeyChar() <= 208
                || Evento.getKeyChar() >= 210 && Evento.getKeyChar() <= 210
                || Evento.getKeyChar() >= 212 && Evento.getKeyChar() <= 217
                || Evento.getKeyChar() >= 219 && Evento.getKeyChar() <= 224
                || Evento.getKeyChar() >= 226 && Evento.getKeyChar() <= 232
                || Evento.getKeyChar() >= 234 && Evento.getKeyChar() <= 236
                || Evento.getKeyChar() >= 238 && Evento.getKeyChar() <= 240
                || Evento.getKeyChar() >= 242 && Evento.getKeyChar() <= 242
                || Evento.getKeyChar() >= 244 && Evento.getKeyChar() <= 249
                || Evento.getKeyChar() >= 251 && Evento.getKeyChar() <= 255) {
            Evento.consume();
        }
    }

    public void ValidacionCaracteres_espacio_arroba(java.awt.event.KeyEvent Evento) {
        if (Evento.getKeyChar() >= 33 && Evento.getKeyChar() <= 44
                || Evento.getKeyChar() >= 58 && Evento.getKeyChar() <= 63
                || Evento.getKeyChar() >= 91 && Evento.getKeyChar() <= 94
                || Evento.getKeyChar() >= 96 && Evento.getKeyChar() <= 96
                || Evento.getKeyChar() >= 123 && Evento.getKeyChar() <= 208
                || Evento.getKeyChar() >= 210 && Evento.getKeyChar() <= 240
                || Evento.getKeyChar() >= 242 && Evento.getKeyChar() <= 255) {
            Evento.consume();
        }
    }

    public void ValidacionCaracteres_tilde_espacio(java.awt.event.KeyEvent Evento) {
        if (Evento.getKeyChar() >= 33 && Evento.getKeyChar() <= 47
                || Evento.getKeyChar() >= 58 && Evento.getKeyChar() <= 64
                || Evento.getKeyChar() >= 91 && Evento.getKeyChar() <= 96
                || Evento.getKeyChar() >= 123 && Evento.getKeyChar() <= 192
                || Evento.getKeyChar() >= 194 && Evento.getKeyChar() <= 200
                || Evento.getKeyChar() >= 202 && Evento.getKeyChar() <= 204
                || Evento.getKeyChar() >= 206 && Evento.getKeyChar() <= 208
                || Evento.getKeyChar() >= 210 && Evento.getKeyChar() <= 210
                || Evento.getKeyChar() >= 212 && Evento.getKeyChar() <= 217
                || Evento.getKeyChar() >= 219 && Evento.getKeyChar() <= 224
                || Evento.getKeyChar() >= 226 && Evento.getKeyChar() <= 232
                || Evento.getKeyChar() >= 234 && Evento.getKeyChar() <= 236
                || Evento.getKeyChar() >= 238 && Evento.getKeyChar() <= 240
                || Evento.getKeyChar() >= 242 && Evento.getKeyChar() <= 242
                || Evento.getKeyChar() >= 244 && Evento.getKeyChar() <= 249
                || Evento.getKeyChar() >= 251 && Evento.getKeyChar() <= 255) {
            Evento.consume();
        }
    }

    public void ValidacionCaracteres_tilde_arroba(java.awt.event.KeyEvent Evento) {
        if (Evento.getKeyChar() >= 32 && Evento.getKeyChar() <= 44
                || Evento.getKeyChar() >= 58 && Evento.getKeyChar() <= 63
                || Evento.getKeyChar() >= 91 && Evento.getKeyChar() <= 94
                || Evento.getKeyChar() >= 96 && Evento.getKeyChar() <= 96
                || Evento.getKeyChar() >= 123 && Evento.getKeyChar() <= 192
                || Evento.getKeyChar() >= 194 && Evento.getKeyChar() <= 200
                || Evento.getKeyChar() >= 202 && Evento.getKeyChar() <= 204
                || Evento.getKeyChar() >= 206 && Evento.getKeyChar() <= 208
                || Evento.getKeyChar() >= 210 && Evento.getKeyChar() <= 210
                || Evento.getKeyChar() >= 212 && Evento.getKeyChar() <= 217
                || Evento.getKeyChar() >= 219 && Evento.getKeyChar() <= 224
                || Evento.getKeyChar() >= 226 && Evento.getKeyChar() <= 232
                || Evento.getKeyChar() >= 234 && Evento.getKeyChar() <= 236
                || Evento.getKeyChar() >= 238 && Evento.getKeyChar() <= 240
                || Evento.getKeyChar() >= 242 && Evento.getKeyChar() <= 242
                || Evento.getKeyChar() >= 244 && Evento.getKeyChar() <= 249
                || Evento.getKeyChar() >= 251 && Evento.getKeyChar() <= 255) {
            Evento.consume();
        }
    }

    public void ValidacionCaracteres_tilde_espacio_arroba(java.awt.event.KeyEvent Evento) {
        if (Evento.getKeyChar() >= 33 && Evento.getKeyChar() <= 44
                || Evento.getKeyChar() >= 58 && Evento.getKeyChar() <= 63
                || Evento.getKeyChar() >= 91 && Evento.getKeyChar() <= 94
                || Evento.getKeyChar() >= 96 && Evento.getKeyChar() <= 96
                || Evento.getKeyChar() >= 123 && Evento.getKeyChar() <= 192
                || Evento.getKeyChar() >= 194 && Evento.getKeyChar() <= 200
                || Evento.getKeyChar() >= 202 && Evento.getKeyChar() <= 204
                || Evento.getKeyChar() >= 206 && Evento.getKeyChar() <= 208
                || Evento.getKeyChar() >= 210 && Evento.getKeyChar() <= 210
                || Evento.getKeyChar() >= 212 && Evento.getKeyChar() <= 217
                || Evento.getKeyChar() >= 219 && Evento.getKeyChar() <= 224
                || Evento.getKeyChar() >= 226 && Evento.getKeyChar() <= 232
                || Evento.getKeyChar() >= 234 && Evento.getKeyChar() <= 236
                || Evento.getKeyChar() >= 238 && Evento.getKeyChar() <= 240
                || Evento.getKeyChar() >= 242 && Evento.getKeyChar() <= 242
                || Evento.getKeyChar() >= 244 && Evento.getKeyChar() <= 249
                || Evento.getKeyChar() >= 251 && Evento.getKeyChar() <= 255) {
            Evento.consume();
        }
    }
}
