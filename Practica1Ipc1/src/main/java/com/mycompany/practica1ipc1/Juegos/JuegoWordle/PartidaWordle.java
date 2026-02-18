/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Juegos.JuegoWordle;

import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusWordle.MenuPartidaWordle;


/**
 *
 * @author Kenny
 */
public class PartidaWordle {
    
    private final MotorWordle motorWordle;
    private final MenuPartidaWordle menuPartida;

    public PartidaWordle(MotorWordle motorWordle, MenuPartidaWordle menuPartida) {
        this.motorWordle = motorWordle;
        this.menuPartida = menuPartida;
    }

    public void iniciarPartidaWordle(){
        
        motorWordle.compararLetras();
        motorWordle.imprimirIntentos();
        motorWordle.verificarPalabraCorrecta();
        
        verificarEstadoDePartida();
        
        menuPartida.mostrarEstadoDePartida();
        menuPartida.mostrarInformacion();
        
    }
    
    private void verificarEstadoDePartida(){
        
        boolean palabraCorrecta = motorWordle.verificarPalabraCorrecta();
        
        if(palabraCorrecta == true || motorWordle.getCantidadIntentos() == 6){
            if(palabraCorrecta == true){
            menuPartida.estadoFinalDePartida(true);
            } else {
                menuPartida.estadoFinalDePartida(false);
            }
        } 
    }
}
