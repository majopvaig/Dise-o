/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author aaron
 */
public class BotonUtileria {
    
    private BotonUtileria(){
        
    }
    public static Component estilizarBoton(Component boton){
        // que cambie de color
        boton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e){
            boton.setBackground(Color.decode("#00318D"));
        }
        @Override
        public void mouseExited(MouseEvent e){
            boton.setBackground(Color.decode("#2C72F3"));
        }
        });
        
        
        // pa ponerle la manita cuando se pase por encima de un boton
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setEnabled(true);
        return boton;
    }
}
