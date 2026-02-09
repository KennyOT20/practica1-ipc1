/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBatalla;

import com.mycompany.practica1ipc1.Juegos.JuegoBatalla.MotorBatalla;
import com.mycompany.practica1ipc1.Menus.MenuBase.MenuBase;
import java.util.InputMismatchException;

/**
 *
 * @author Kenny
 */
public class MenuBatalla extends MenuBase{
    
    private int opcion;
    private final MotorBatalla motorBatalla;

    public MenuBatalla() {
        this.motorBatalla = new MotorBatalla();
    }
    
    

    @Override
    public void mostrarInformacion() {
        System.out.println("------------------------------------------------------------");
        System.out.println("||                                                        ||");
        System.out.println("||            SELECCIONE LA DIFICULTAD                    ||");
        System.out.println("||                                                        ||");
        System.out.println("------------------------------------------------------------");
        System.out.println("||  1. Facil   (A - U)                                    ||");
        System.out.println("||  2. Medio   (A - K)                                    ||");
        System.out.println("||  3. Dificil (A - Z)                                    ||");
        System.out.println("------------------------------------------------------------");
        System.out.print("Ingrese una opcion: ");
        validarOpcion();


    }

    @Override
    public void ejecutarOpcion() {
        motorBatalla.pensarLetra(opcion);
        motorBatalla.mostrarOpcion(opcion);
    }

    @Override
    public void validarOpcion() {
        boolean opcionCorrecta = false;
        
        while(!opcionCorrecta){
            try{
                opcion = getScanner().nextInt();
                limpiarPantalla();
                ejecutarOpcion();
                opcionCorrecta = true;
            } catch(InputMismatchException e){
                getScanner().nextLine();
                limpiarPantalla();
                System.out.println("Opcion no valida, intente de nuevo.");
                mostrarInformacion();
            }
        }
    }
    
}
