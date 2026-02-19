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

    //Constructor par iniciarl los obnetos necesarios para el inicio de partida
    public PartidaWordle(MotorWordle motorWordle, MenuPartidaWordle menuPartida) {
        this.motorWordle = motorWordle;
        this.menuPartida = menuPartida;
    }

    /**
     * Metodo encargado para iniciar la partida de wordle, este metodo es encargado para ir instanciando los metodos
     * necesarios desde la clase motorWordle para el funcionamiento del juego.
     */
    public void iniciarPartidaWordle(){
        
        MotorWordle.setCantidadDeIntentos(MotorWordle.getCantidadDeIntentos() + 1);
        motorWordle.compararLetras();
        motorWordle.verificarPalabraCorrecta();
        
        menuPartida.mostrarEstadoDePartida();
        motorWordle.imprimirIntentos();
        
        verificarEstadoDePartida();
        
        menuPartida.mostrarInformacion();
        
    }
    
    /**
     * Metodo encargado de ir verificando el usuario de la partida mediante una condicional que posee 
     * un boolano, si la condicion donde el booleano es verdadero y la cantidad de intentos es igual a 6, automaticamente
     * la partida se termina y se inicia el objeto del menu final del juego, si el booleano es verdadero antes de los 6
     * intentos, la palabra fue adivinada.
     */
    private void verificarEstadoDePartida(){
        
        boolean palabraCorrecta = motorWordle.verificarPalabraCorrecta();
        
        if(palabraCorrecta == true || motorWordle.getCantidadIntentos() == 6){
            if(palabraCorrecta == true){
            menuPartida.estadoFinalDePartida(true);
            } else {
                MotorWordle.setCantidadVecesPerdidas(MotorWordle.getCantidadVecesPerdidas() + 1);
                menuPartida.estadoFinalDePartida(false);
            }
        } 
    }
}
