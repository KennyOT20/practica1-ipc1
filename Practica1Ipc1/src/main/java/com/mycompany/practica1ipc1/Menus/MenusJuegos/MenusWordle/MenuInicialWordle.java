/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusWordle;

import com.mycompany.practica1ipc1.Juegos.JuegoWordle.MotorWordle;
import com.mycompany.practica1ipc1.Menus.MenuBase.MenuBase;

/**
 *
 * @author Kenny
 */
public class MenuInicialWordle extends MenuBase {

    private String palabra; 
    private final MotorWordle wordle;
    private final MenuPartidaWordle menuPartida;
    private static int cantidadIniciadaWordle = 0;
    
    public MenuInicialWordle(){
        this.wordle = new MotorWordle();
        this.menuPartida = new MenuPartidaWordle(wordle);
    }
    
    
    @Override
    public void mostrarInformacion() {
        cantidadIniciadaWordle ++;
        System.out.println("---------------------------------------------------------");
        System.out.println("||         Bienvenido a Wordle                         ||");
        System.out.println("---------------------------------------------------------");
        System.out.print("Ingrese la palabra a ocultar: ");
        validarOpcion();
    }

    @Override
    public void ejecutarOpcion() {
        wordle.ingresarPalabraArreglo(palabra, false);
        wordle.setPalabraOcultada(palabra);
        menuPartida.mostrarInformacion();
    }

    @Override
    public void validarOpcion() {
        
        palabra = getScanner().nextLine().trim().toUpperCase();
        
        if(palabra.length() == 5 && palabra.matches("[A-Z]{5}")){
            limpiarPantalla();
            System.out.println("Palabra ocultada");
            ejecutarOpcion();
        } else {
            limpiarPantalla();
            System.out.println("Error palabra incorrecta.");
            System.out.println("La palabra solo debe de tener 5 letras.");
            mostrarInformacion();
        }
        
    }

    public static int getCantidadIniciadaWordle() {
        return cantidadIniciadaWordle;
    }
    
}
