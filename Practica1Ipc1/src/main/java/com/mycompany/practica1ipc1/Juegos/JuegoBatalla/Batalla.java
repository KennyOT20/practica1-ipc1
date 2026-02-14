/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Juegos.JuegoBatalla;

import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBatalla.MenuBatalla;

/**
 *
 * @author Kenny
 */
public class Batalla {
    private final  MotorBatalla motorBatalla;
    private final MenuBatalla menuBatalla;
    private boolean batallaActiva;
    

    public Batalla(MotorBatalla motorBatalla, MenuBatalla menuBatalla) {
        this.motorBatalla = motorBatalla;
        this.menuBatalla = menuBatalla;
        this.batallaActiva = true;
    }
    
    public void iniciarBatalla(){
        
        boolean letraCorrecta = motorBatalla.compararLetras(Character.toUpperCase(motorBatalla.getLetraJugador()));
        
        if(letraCorrecta == true){
            motorBatalla.recibirDañoPersonajes(true);
        } else{
            motorBatalla.recibirDañoPersonajes(false);
        }
        
        menuBatalla.informacionBatalla();
        motorBatalla.actualizarLetraPensada(motorBatalla.getOpcionElegidaDificultas());

        if(motorBatalla.getVidaJugador() <= 0 || motorBatalla.getVidaMaquina() <= 0 ){
            batallaActiva = false;
            return;
            
        }
        
        menuBatalla.mostrarInformacion();
    }
    

    public boolean isBatallaActiva() {
        return batallaActiva;
    }

    public void setBatallaActiva(boolean batallaActiva) {
        this.batallaActiva = batallaActiva;
    }
    
}
