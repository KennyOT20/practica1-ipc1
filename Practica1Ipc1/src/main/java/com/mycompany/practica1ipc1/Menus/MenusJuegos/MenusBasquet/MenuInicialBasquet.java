/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBasquet;

import com.mycompany.practica1ipc1.Juegos.JuegoBasketball.MotorJuegoBasquet;
import com.mycompany.practica1ipc1.Juegos.JuegoBasketball.PartidaBasquet;
import com.mycompany.practica1ipc1.Menus.MenuBase.MenuBase;

/**
 *
 * @author Kenny
 */
public class MenuInicialBasquet extends MenuBase{
    
    private final MotorJuegoBasquet motorBasquet;
    private final PartidaBasquet partidaBasquet;
    private int contadorJugador = 1; 
    private String nombreJugador;
    private int cantidadDeIntentos;
    private static int cantidadIniciadaBaquet = 0;

    public MenuInicialBasquet() {
        this.motorBasquet = new MotorJuegoBasquet();
        this.cantidadDeIntentos = 0;
        this.partidaBasquet = new PartidaBasquet(motorBasquet);
    }
   
    
    @Override
    public void mostrarInformacion() {
        
        
        System.out.println("----------------------------------------");
        System.out.println("||   Juego de basquetball             ||");
        System.out.println("----------------------------------------");
        System.out.println("|| Ingrese el nombre del              ||");
        System.out.println("|| jugador " + contadorJugador + ".                         ||");
        System.out.println("----------------------------------------");
        System.out.print("Nombre de jugador: ");
        validarOpcion();
    }

    @Override
    public void ejecutarOpcion() {
        cantidadIniciadaBaquet ++;
        motorBasquet.setCantidadDeTurnos(cantidadDeIntentos);
        partidaBasquet.iniciarPartida();
    }

    @Override
    public void validarOpcion() {
        
        nombreJugador = getScanner().nextLine();
        
        if(contadorJugador == 1){
                motorBasquet.getJugador1().setNombre(nombreJugador);
                contadorJugador ++;
                limpiarPantalla();
                mostrarInformacion();
        } else if(contadorJugador == 2){
            motorBasquet.getJugador2().setNombre(nombreJugador);
            limpiarPantalla();
            obtenerCantidadIntentos();
        }
        
    }
    
    private void obtenerCantidadIntentos(){
        System.out.println("---------------------------------------");
        System.out.println("|| Ingrese la cantidad               ||");
        System.out.println("|| de intentos a jugar               ||");
        System.out.println("---------------------------------------");
        System.out.print("Cantidad: ");
        validarCantidadIntentos();
    }
    
    private void validarCantidadIntentos(){
        boolean intentosValidos = false;
        while(intentosValidos == false){
            try{
                cantidadDeIntentos = Integer.parseInt(getScanner().nextLine());
                if(cantidadDeIntentos >= 0){
                limpiarPantalla();
                ejecutarOpcion();
                intentosValidos = true;
                } else {
                    limpiarPantalla();
                    System.out.println("Debe de ingresar un numero entero valido");
                    mostrarInformacion();
                }
            } catch(NumberFormatException e){
                getScanner().nextLine();
                limpiarPantalla();
                System.out.println("Error, debe de ingresar un numero entero.");
                obtenerCantidadIntentos();
            }
        }
        
    }

    public static int getCantidadIniciadaBaquet() {
        return cantidadIniciadaBaquet;
    }
    
    
}
