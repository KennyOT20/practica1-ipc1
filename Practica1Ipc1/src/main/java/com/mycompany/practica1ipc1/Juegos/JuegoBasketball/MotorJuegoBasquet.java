/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Juegos.JuegoBasketball;

import java.util.Random;

/**
 *
 * @author Kenny
 */
public class MotorJuegoBasquet {
    
    private final Jugador jugador1;
    private  final  Jugador jugador2;
    private final Random random;
    private  int cantidadDeTurnos;
    private boolean huboFalta;
    
    public MotorJuegoBasquet(){
        this.jugador1 = new Jugador();
        this.jugador2 = new Jugador();
        this.random = new Random();
        this.huboFalta = false; 
    }
    
    public boolean saltoLargo(Jugador jugador, double modificadorDefensa){
         double probabilidad = 0.65 - modificadorDefensa;

            if (probabilidad < 0) {
                probabilidad = 0;
            }
            if (random.nextDouble() <= probabilidad) {
                jugador.agregarPuntos(3);
                System.out.println(jugador.getNombre() + " anoto en un salto largo ");
                System.out.println(jugador.getNombre() + " ha ganado +3 puntos");
                return true;
            } else {
                System.out.println(jugador.getNombre() + " fallo el salto largo");
                return false;
            }
    }
    
    public boolean saltoCorto(Jugador jugador, double modificadorDefensa) {

        double probabilidad = 0.80 - modificadorDefensa;

        if (probabilidad < 0) {
            probabilidad = 0;
        }

        if (random.nextDouble() <= probabilidad) {
            jugador.agregarPuntos(2);
            System.out.println(jugador.getNombre() + " anot o en un salto corto");
            System.out.println(jugador.getNombre() +" ha ganado + 2 puntoss.");
            return true;
        } else {
            System.out.println(jugador.getNombre() + " fall0 el salto corto");
            return false;
        }
   }
    
    public boolean tiroLibre(Jugador jugador) {

        double probabilidad = 0.90;

        if (random.nextDouble() <= probabilidad) {
            jugador.agregarPuntos(2);
            System.out.println(jugador.getNombre() + " anoto desde el tiro libre ");
            System.out.println(jugador.getNombre() + " gana +2 puntos.");
            return true;
        } else {
            System.out.println(jugador.getNombre() + " fallo el tiro libre");
            return false;
        }
  }

   public double defensaCuerpoACuerpo(Jugador defensor) {

        double reduccion = 0.15;

        huboFalta = random.nextDouble() <= 0.35;

        if (huboFalta) {
            System.out.println(defensor.getNombre() + " hizo falta con defensa cuerpo a cuerpo");
        } else {
            System.out.println(defensor.getNombre() + " defendio correctamente con defensa cuerpo a cuerpo");
        }

        return reduccion;
    }
   
   public double defensaFuerte(Jugador defensor) {

        double reduccion = 0.30;

        huboFalta = random.nextDouble() <= 0.65;

        if (huboFalta) {
            System.out.println(defensor.getNombre() + " hizo falta con defensa fuerte)");
        } else {
            System.out.println(defensor.getNombre() + " defendio correctamente con defensa fuerte)");
        }
        return reduccion;
    }

    public void resetearFalta(){
        huboFalta = false;
    }

    
    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public int getCantidadDeTurnos() {
        return cantidadDeTurnos;
    }

    public void setCantidadDeTurnos(int cantidadDeTurnos) {
        this.cantidadDeTurnos = cantidadDeTurnos;
    }
    
    public boolean isHuboFalta() {
        return huboFalta;
    }
    
    
    
}
