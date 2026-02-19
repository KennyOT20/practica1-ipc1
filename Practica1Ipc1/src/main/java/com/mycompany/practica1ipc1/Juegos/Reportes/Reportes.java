/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Juegos.Reportes;

import com.mycompany.practica1ipc1.Juegos.JuegoBatalla.MotorJuegoBatalla;
import com.mycompany.practica1ipc1.Juegos.JuegoWordle.MotorWordle;
import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBasquet.MenuInicialBasquet;
import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBatalla.MenuOpcionesBatalla;
import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusWordle.MenuInicialWordle;

/**
 *
 * @author Kenny
 */
public class Reportes {
    
    private final MenuOpcionesBatalla opcionesBatalla;
    private final MenuInicialWordle menuWordle;
    private final MenuInicialBasquet menuBasquet;
    private final MotorWordle motorWordle;
    private final MotorJuegoBatalla motorBatalla;

    public Reportes(MenuOpcionesBatalla opcionesBatalla, MenuInicialWordle menuWordle, MenuInicialBasquet menuBasquet) {
        this.opcionesBatalla = opcionesBatalla;
        this.menuWordle = menuWordle;
        this.menuBasquet = menuBasquet;
        this.motorWordle = new MotorWordle();
        this.motorBatalla = new MotorJuegoBatalla();
    }
    
    
    
    public void mostrarReportes() {

        System.out.println("------------------------------------------------------------");
        System.out.println("||                   REPORTES GENERALES                  ||");
        System.out.println("------------------------------------------------------------");
        System.out.println("|| Cantidad de veces iniciado Wordle:      " + MenuInicialWordle.getCantidadIniciadaWordle() + "              ||");
        System.out.println("|| Cantidad de veces iniciado Batalla:    "   + MenuOpcionesBatalla.getCantidadIniciadaBatalla() + "              ||");
        System.out.println("|| Cantidad de veces iniciado Basquet:    "      + MenuInicialBasquet.getCantidadIniciadaBaquet() + "              ||");
        System.out.println("|| Cantidad de veces perdido Wordle:      "     + MotorWordle.getCantidadVecesPerdidas() + "              ||");
        System.out.println("|| Cantidad de intentos en Wordle:        "    + MotorWordle.getCantidadDeIntentos() + "              ||");
        System.out.println("|| Cantidad de victorias en Batalla:     "    + MotorJuegoBatalla.getCantidadVecesGanadas() + "              ||");
        System.out.println("|| Nivel más alto alcanzado en Batalla:  "  + MotorJuegoBatalla.getNivelAlto() + "              ||");
        System.out.println("------------------------------------------------------------");
        System.out.print("Presione enter para continuar: ");
}

}
