/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Juegos.JuegoBatalla;

/**
 *
 * @author Kenny
 */
public class Batalla {
    private final MotorBatalla motorBatalla;
    private boolean batallaActiva;

    public Batalla() {
        this.motorBatalla = new MotorBatalla();
        this.batallaActiva = true;
    }
    
    public void iniciarBatalla(){
        
        while(motorBatalla.getVidaJugador() > 0 && motorBatalla.getVidaMaquina() > 0 && batallaActiva  ){
            
        }
        
    }
    
    
    
}
