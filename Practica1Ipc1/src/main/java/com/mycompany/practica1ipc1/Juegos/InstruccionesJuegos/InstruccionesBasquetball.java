/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Juegos.InstruccionesJuegos;

/**
 *
 * @author Kenny
 */
public class InstruccionesBasquetball extends ClaseBaseInstrucciones {

    @Override
    public void mostrarInstrucciones() {
        
        System.out.println("------------------------------------------------------------");
        System.out.println("||                   INSTRUCCIONES                        ||");
        System.out.println("------------------------------------------------------------");
        System.out.println("|| DESCRIPCION Y OBJETIVO:                               ||");
        System.out.println("|| Juego de dos jugadores por turnos                     ||");
        System.out.println("|| Anotar mas puntos que el oponente.                    ||");
        System.out.println("||                                                       ||");
        System.out.println("|| LANZAMIENTOS:                                         ||");
        System.out.println("|| Salto largo : 3 pts (65%) de anotar                   ||");
        System.out.println("|| Salto corto : 2 pts (80%) de anotar                   ||");
        System.out.println("|| Tiro libre  : 2 pts (90%) de anotar por falta         ||");
        System.out.println("||                                                       ||");
        System.out.println("|| DEFENSA:                                              ||");
        System.out.println("|| Cuerpo a cuerpo : -15% anotacion, 35% falta           ||");
        System.out.println("|| Defensa fuerte  : -30% anotacion, 65% falta           ||");
        System.out.println("||                                                       ||");
        System.out.println("|| El jugador con mas puntos gana.                       ||");
        System.out.println("------------------------------------------------------------");
        System.out.print(  "Presione cualquier tecla para continuar: ");


    }
    
}
