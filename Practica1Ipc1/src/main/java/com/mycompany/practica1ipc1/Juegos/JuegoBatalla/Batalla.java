/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Juegos.JuegoBatalla;

import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBatalla.MenuBatalla;
import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBatalla.MenuFinalBatalla;

/**
 *
 * @author Kenny
 */
public class Batalla {
    private final  MotorJuegoBatalla motorBatalla;
    private final MenuBatalla menuBatalla;
    public Batalla(MotorJuegoBatalla motorBatalla, MenuBatalla menuBatalla) {
        this.motorBatalla = motorBatalla;
        this.menuBatalla = menuBatalla;
    }
    
     public void iniciarBatalla(){
        
        boolean letraCorrecta = motorBatalla.compararLetras(Character.toUpperCase(motorBatalla.getJugador().getLetra()));
        
        if(letraCorrecta == true){
            motorBatalla.recibirDañoPersonajes(true);
            if(motorBatalla.getJugador().isSubioDeNivel() == true){
                menuBatalla.informacionPersonaje();
                motorBatalla.getJugador().setSubioDeNivel(false);
            }
        } else{
            motorBatalla.recibirDañoPersonajes(false);
             if(motorBatalla.getMaquina().isSubioDeNivel() == true){
                menuBatalla.informacionPersonaje();
                motorBatalla.getMaquina().setSubioDeNivel(false);
            }
        }
       
        estadoDeBatalla();
    }

     private void estadoDeBatalla(){
         menuBatalla.informacionBatalla();
         motorBatalla.actualizarLetraPensada(motorBatalla.getOpcionElegidaDificultas());
         
          if(motorBatalla.getJugador().getVida() <= 0 || motorBatalla.getMaquina().getVida() <= 0 ){
            informacionFinal();
        }
          
        menuBatalla.mostrarInformacion();
     }
     
     private void informacionFinal(){
         MenuFinalBatalla menuFinal = new MenuFinalBatalla();
         menuBatalla.informacionFinalDeBatalla();
         menuFinal.mostrarInformacion();
     }
    
}
