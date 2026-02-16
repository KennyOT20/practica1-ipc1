/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Juegos.InstruccionesJuegos;

/**
 *
 * @author Kenny
 */
public class InstruccionesWordle extends ClaseBaseInstrucciones {

    @Override
    public void mostrarInstrucciones() {
        System.out.println("");
        System.out.println("------------------------------------------------------------");
        System.out.println("||                                                        ||");
        System.out.println("||              INSTRUCCIONES - WORDLE                    ||");
        System.out.println("||                                                        ||");
        System.out.println("------------------------------------------------------------");
        System.out.println("|| Una persona externa ingresara una palabra oculta       ||");
        System.out.println("|| de 5 letras en idioma español.                         ||");
        System.out.println("||                                                        ||");
        System.out.println("|| El jugador tendra 6 intentos para adivinarla.          ||");
        System.out.println("||                                                        ||");
        System.out.println("|| En cada intento se debe ingresar una palabra           ||");
        System.out.println("|| valida de 5 letras.                                    ||");
        System.out.println("||                                                        ||");
        System.out.println("|| Si la palabra coincide exactamente, se gana la partida ||");
        System.out.println("||                                                        ||");
        System.out.println("|| Si no coincide, cada letra se mostrara con un color:   ||");
        System.out.println("||                                                        ||");
        System.out.println("|| VERDE    : La letra esta en la palabra y en la         ||");
        System.out.println("||            posicion correcta.                          ||");
        System.out.println("||                                                        ||");
        System.out.println("|| AMARILLO : La letra esta en la palabra pero en         ||");
        System.out.println("||            una posicion incorrecta.                    ||");
        System.out.println("||                                                        ||");
        System.out.println("|| ROJO     : La letra no existe en la palabra.           ||");
        System.out.println("||                                                        ||");
        System.out.println("|| Se mostraran todos los intentos anteriores             ||");
        System.out.println("|| para facilitar poder adivinar la palabra.              ||");
        System.out.println("||                                                        ||");
        System.out.println("|| Si no se adivina en los 6 intentos, se pierde          ||");
        System.out.println("|| y se revelara la palabra oculta.                       ||");
        System.out.println("||                                                        ||");
        System.out.println("------------------------------------------------------------");
        System.out.print("Presione cualquier tecla para continuar: ");

    }
    
}
