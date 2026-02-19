/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Juegos.JuegoBatalla;

/**
 *
 * @author Kenny
 */
public class Jugador extends Personaje {
    
    private static int nivelMasAlto = 0;
    
    public Jugador() {
        super("Jugador");
    }

    public void verificarNivel(){
        if (getNivel() > nivelMasAlto) {
            nivelMasAlto = getNivel();
        }
    }
    
    public static int getNivelMasAlto() {
        return nivelMasAlto;
    }

}
