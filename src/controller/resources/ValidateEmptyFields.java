/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.resources;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;

/**
 *
 * @author Usuario
 */
public class ValidateEmptyFields {
    
    public static boolean requerido(JComponent txt, String value) {
        boolean band = true;//esta lleno
        value = value.trim();
        if (value.isEmpty() == true) {
            band = false;//no esta llenado
            txt.setBorder(BorderFactory.createLineBorder(Color.red));
            txt.setToolTipText("Ingrese un valor");
        } else {
            txt.setBorder(BorderFactory.createEmptyBorder());
            txt.setToolTipText(" ");
        }
        return band;
    }
    public static void validarCaracterNoValido(KeyEvent evt){
        char caracter = evt.getKeyChar();
        if((caracter<'a' || caracter>'z')&&(caracter< 'A'|| caracter > 'Z')&&(caracter!='ñ'|| caracter!='Ñ')){
            evt.consume();
        }
    }
    public static void validarLetras(KeyEvent evt){
        char caracter = evt.getKeyChar();
        if(!Character.isLetter(caracter) && !Character.isSpaceChar(caracter)){
            evt.consume();
        }
    }
    public static void validarNumeor(KeyEvent evt){//valida numeros
        char caracter = evt.getKeyChar();
        if(!Character.isDigit(caracter)){
            evt.consume();
        }
    }
    
    public static void validarNumeroYPunto(KeyEvent evt){//valida numeros
        char caracter = evt.getKeyChar();
        if(!Character.isDigit(caracter) && evt.getKeyChar()!='.'){
            evt.consume();
        }
    }
    
    
}
