/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusWordle;

import com.mycompany.practica1ipc1.Juegos.JuegoWordle.MotorWordle;
import com.mycompany.practica1ipc1.Juegos.JuegoWordle.PartidaWordle;
import com.mycompany.practica1ipc1.Menus.MenuBase.MenuBase;

/**
 *
 * @author Kenny
 */
public class MenuPartidaWordle extends MenuBase {
    
    private final MotorWordle motorWordle;
    private final PartidaWordle iniciarPartida;
    private String palabraUsuario;

    public MenuPartidaWordle(MotorWordle motorWordle) {
        this.motorWordle = motorWordle;
        this.iniciarPartida = new PartidaWordle(motorWordle, this);     
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("---------------------------------------------");
        System.out.println("|| Intente adivinar                 ||");
        System.out.println("||         la palabra:                  || ");
        System.out.println("--------------------------------------------");
        System.out.println("Ingrese la palabra:");
        validarOpcion();
    }

    @Override
    public void ejecutarOpcion() {
        motorWordle.ingresarPalabraArreglo(palabraUsuario, true);
        motorWordle.setPalabraIntento(palabraUsuario);
        iniciarPartida.iniciarPartidaWordle();
    }

    @Override
    public void validarOpcion() {
        palabraUsuario = getScanner().nextLine().trim().toUpperCase();
        
        if(palabraUsuario.length() == 5 && palabraUsuario.matches("[A-Z]{5}")){
            limpiarPantalla();
            ejecutarOpcion();
        } else{
            limpiarPantalla();
            System.out.println("Palabra incorrecta, intente de nuevo.");
            mostrarInformacion();
        }
    }
    
    public void mostrarEstadoDePartida(){
        System.out.println(" Estado de la partida:");
        System.out.println("Cantidad de intentos: " + motorWordle.getCantidadIntentos() + " / " + motorWordle.getCantidadTotalDeIntentos());
    }
   
    public void estadoFinalDePartida(boolean partidaGanada ){
        
        
        if(partidaGanada == true){
            System.out.println("--------------------------------------------------");
            System.out.println("|| Has adivinado la palabra oculta. ||");
            System.out.println("|| --------------------------------------------||");
        } else {
            System.out.println("|| No has logrado adivinar la palbra ||");
            System.out.println("|| se te acabaron los intentos.          ||");
        }
        
        System.out.println("----------------------------------------------------");
        System.out.println("|| La palabra oculta es: " + motorWordle.getPalabraOcultada());
        System.out.println("----------------------------------------------------");
        System.out.println("|| Intentos restantes:  " + motorWordle.getCantidadIntentos() + " / "  + motorWordle.getCantidadTotalDeIntentos());
        System.out.println("-----------------------------------------------------");
        
        MenuFinalWordle menuFinal = new MenuFinalWordle();
        menuFinal.mostrarInformacion();
    }
    
  
    
}
