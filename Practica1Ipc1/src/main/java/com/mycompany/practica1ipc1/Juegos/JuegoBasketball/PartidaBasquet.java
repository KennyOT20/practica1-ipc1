/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Juegos.JuegoBasketball;

import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBasquet.MenuFinalBasquet;
import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBasquet.MenuPartidaBasquet;

/**
 *
 * @author Kenny
 */
public class PartidaBasquet {
    
    private final MotorJuegoBasquet motorBasquet;
    private final MenuPartidaBasquet menuBasquet;
    
    public PartidaBasquet(MotorJuegoBasquet motorBasquet) {
        this.motorBasquet = motorBasquet;
        this.menuBasquet = new MenuPartidaBasquet(motorBasquet);
    }

    
    public void iniciarPartida(){
        
        int turnos = motorBasquet.getCantidadDeTurnos(); 
       
        
        
        for(int i = 1; i <= turnos; i++){

        System.out.println("           TURNO " + i);

        int opcionJ1 = menuBasquet.obtenerOpcionJugador(motorBasquet.getJugador1());
        menuBasquet.limpiarPantalla();
        int opcionJ2 = menuBasquet.obtenerOpcionJugador(motorBasquet.getJugador2());

        menuBasquet.limpiarPantalla();
        aplicarDecisiones(motorBasquet.getJugador1(), opcionJ1,
                        motorBasquet.getJugador2(), opcionJ2);

        aplicarDecisiones(motorBasquet.getJugador2(), opcionJ2,
                        motorBasquet.getJugador1(), opcionJ1);
        
        mostrarMarcador();

    }
        
        evaluarPartida();
    }

    private void aplicarDecisiones(Jugador jugadorActual, int opcionActual,
                             Jugador oponente, int opcionOponente){

        double reduccion = 0;

        if(opcionOponente == 3)
            reduccion = motorBasquet.defensaCuerpoACuerpo(oponente);

        else if(opcionOponente == 4)
            reduccion = motorBasquet.defensaFuerte(oponente);


        if(opcionActual == 1)
            motorBasquet.saltoLargo(jugadorActual, reduccion);

        else if(opcionActual == 2)
            motorBasquet.saltoCorto(jugadorActual, reduccion);
        
        if(motorBasquet.isHuboFalta()) {

            System.out.println( jugadorActual.getNombre() + " tiene un TIRO LIBRE.");
            System.out.println("Presione enter para lanzarlo. ");
            menuBasquet.getScanner().nextLine();
            menuBasquet.getScanner().nextLine();

            motorBasquet.tiroLibre(jugadorActual);

            motorBasquet.resetearFalta(); 

}

    }
    private void mostrarMarcador(){

    System.out.println("MARCADOR:");

    System.out.println(motorBasquet.getJugador1().getNombre() +  ": " +motorBasquet.getJugador1().getCantidadPunteo() );

    System.out.println(motorBasquet.getJugador2().getNombre() + ": " +motorBasquet.getJugador2().getCantidadPunteo());
}
    
    private void mostrarGanador(){
        System.out.println("Se acabaron los turnos.");
        if(motorBasquet.getJugador1().getCantidadPunteo() > motorBasquet.getJugador2().getCantidadPunteo()){
            System.out.println("El ganador es el jugador: " + motorBasquet.getJugador1().getNombre());
        } else if(motorBasquet.getJugador1().getCantidadPunteo() == motorBasquet.getJugador2().getCantidadPunteo()){
            System.out.println("Nadie gana, es un empate.");
        } else{
            System.out.println("El ganador es: " + motorBasquet.getJugador2().getNombre());
        }
    }

   private void evaluarPartida(){
       MenuFinalBasquet menuFinal = new MenuFinalBasquet();
       System.out.println("");
       System.out.println("");
       mostrarGanador();
       mostrarMarcador();
       menuFinal.mostrarInformacion();
   }
    
}
