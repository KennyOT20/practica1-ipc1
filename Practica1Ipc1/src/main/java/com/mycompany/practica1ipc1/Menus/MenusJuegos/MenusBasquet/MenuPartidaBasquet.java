/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBasquet;

import com.mycompany.practica1ipc1.Juegos.JuegoBasketball.Jugador;
import com.mycompany.practica1ipc1.Juegos.JuegoBasketball.MotorJuegoBasquet;
import com.mycompany.practica1ipc1.Menus.MenuBase.MenuBase;

/**
 *
 * @author Kenny
 */
public class MenuPartidaBasquet extends MenuBase{
    
    int opcionElegida;
    private final MotorJuegoBasquet motorBasquet;

    public MenuPartidaBasquet(MotorJuegoBasquet motorBasquet) {
        this.motorBasquet = motorBasquet;
    }
    
    

    @Override
    public void mostrarInformacion() {
        System.out.println("-------------------------------------------");
        System.out.println("|| Elija el movimiento que realizara   ||");
        System.out.println("-------------------------------------------");
        System.out.println("|| TIROS                               ||");
        System.out.println("|| 1. Salto largo  (+3 puntos, 65%)    ||");
        System.out.println("|| 2. Salto corto  (+2 puntos, 80%)    ||");
        System.out.println("-------------------------------------------");
        System.out.println("|| DEFENSAS                            ||");
        System.out.println("|| 3. Defensa cuerpo a cuerpo          ||");
        System.out.println("||    (-15% anotacion, 35% falta)      ||");
        System.out.println("|| 4. Defensa fuerte                   ||");
        System.out.println("||    (-30% anotacion, 65% falta)      ||");
        System.out.println("-------------------------------------------");
        System.out.print("Seleccione una opcion: ");
        validarOpcion();
    }

    @Override
    public void ejecutarOpcion() {
    }

    @Override
    public void validarOpcion() {
        
        boolean opcionCorrecta = false; 
        try{
            while(opcionCorrecta == false){
           opcionElegida = getScanner().nextInt();

            if(opcionElegida >= 1 && opcionElegida <= 4){
                opcionCorrecta = true;
            }
            else{
                limpiarPantalla();
                System.out.println("Opcion invalida. Intente otra vez:");
            }
            } 
        } catch(NumberFormatException e){
            getScanner().nextLine();
            System.out.println("Opcion incorrecta, intente de nuevo.");
            mostrarInformacion();
        }
    }
    
    public int obtenerOpcionJugador(Jugador jugador){

        System.out.println("Turno de: " + jugador.getNombre());

        mostrarInformacion();


        return opcionElegida;
    }   

}
