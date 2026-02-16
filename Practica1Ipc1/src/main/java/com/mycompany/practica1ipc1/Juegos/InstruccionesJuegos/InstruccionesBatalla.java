/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Juegos.InstruccionesJuegos;

/**
 *
 * @author Kenny
 */
public class InstruccionesBatalla extends ClaseBaseInstrucciones{

    @Override
    public void mostrarInstrucciones() {
      
        System.out.println("------------------------------------------------------------");
        System.out.println("||                                                        ||");
        System.out.println("||        INSTRUCCIONES - JUEGO DE BATALLA                ||");
        System.out.println("||                                                        ||");
        System.out.println("------------------------------------------------------------");
        System.out.println("|| La computadora pensará en una letra                    ||");
        System.out.println("|| y el jugador deberá adivinarla.                        ||");
        System.out.println("||                                                        ||");
        System.out.println("|| No importa si la letra es mayúscula o minúscula.       ||");
        System.out.println("||                                                        ||");
        System.out.println("|| * Acierto: la computadora recibe 15 a 30 de daño       ||");
        System.out.println("|| * Error: el jugador recibe 15 a 30 de daño             ||");
        System.out.println("||                                                        ||");
        System.out.println("|| Cada 3 aciertos el jugador sube de nivel               ||");
        System.out.println("|| Cada 4 errores la computadora sube de nivel            ||");
        System.out.println("||                                                        ||");
        System.out.println("|| Al subir de nivel se recupera toda la vida             ||");
        System.out.println("|| y la vida máxima aumenta en 20 puntos                  ||");
        System.out.println("||                                                        ||");
        System.out.println("|| Ambos inician con 200 puntos de vida                   ||");
        System.out.println("||                                                        ||");
        System.out.println("||---------------------- NIVELES -------------------------||");
        System.out.println("||                                                        ||");
        System.out.println("|| FACIL    : Solo letras vocales (A, E, I, O, U)         ||");
        System.out.println("|| MEDIO    : Letras del abecedario de la A a la K        ||");
        System.out.println("|| DIFICIL  : Todas las letras del alfabeto               ||");
        System.out.println("||                                                        ||");
        System.out.println("|| Pierde quien se quede sin vida                         ||");
        System.out.println("|| Puntaje: letras adivinadas correctamente               ||");
        System.out.println("||                                                        ||");
        System.out.println("------------------------------------------------------------");
        System.out.print("Presione cualquier tecla para continuar: ");


    }
    
}
