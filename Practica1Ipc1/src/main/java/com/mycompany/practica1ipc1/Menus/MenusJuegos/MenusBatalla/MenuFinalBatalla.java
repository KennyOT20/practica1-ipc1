/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBatalla;

import com.mycompany.practica1ipc1.Juegos.JuegoBatalla.MotorBatalla;
import com.mycompany.practica1ipc1.Menus.MenuBase.MenuBase;
import com.mycompany.practica1ipc1.Menus.MenusIniciales.MenuPrincipal;

/**
 *
 * @author Kenny
 */
public class MenuFinalBatalla  extends MenuBase{

    private final MenuPrincipal menuPrincipal;
    private final MenuOpcionesBatalla opcionesBatalla;
    private final MotorBatalla motorBatalla;
    int opcion;

    public MenuFinalBatalla(MenuPrincipal menuPrincipal, MenuOpcionesBatalla opcionesBatalla, MotorBatalla motorBatalla) {
        this.menuPrincipal = menuPrincipal;
        this.opcionesBatalla  = opcionesBatalla ;
        this.motorBatalla = motorBatalla;
    }
    
    
    
    @Override
    public void mostrarInformacion() {
        System.out.println("-------------------------------------------");
        System.out.println("|| La batalla ha finalizado      ||");
        System.out.println("|| ¿Que desea hacer?             ||");
        System.out.println("-------------------------------------------");
        System.out.println("||1. Volver a jugar.                  ||");
        System.out.println("||2. Volver al menu inicial.     ||");
        System.out.println("||3. Salir del programa.         ||");
        System.out.println("------------------------------------------");
        validarOpcion();
    }

    @Override
    public void ejecutarOpcion() {
        
        boolean opcionCorrecta = false; 
        
        while(opcionCorrecta == false){
            try{
            opcion = Integer.valueOf(getScanner().nextLine());
            limpiarPantalla();
            validarOpcion();
            opcionCorrecta = true;
            } catch(NumberFormatException e){
                getScanner().nextLine();
                limpiarPantalla();
                System.out.println("Opcion no valida, intente de nuevo.");
                mostrarInformacion();
            }
           
        }
       
    }

    @Override
    public void validarOpcion() {
        
        switch(opcion){
            case 1:
                limpiarPantalla();
                opcionesBatalla.mostrarInformacion();
                break;
            case 2:
                limpiarPantalla();
                menuPrincipal.mostrarInformacion();
                break;
            case 3:
                break;
            default:
                break;
        }
        
    }
    
}
