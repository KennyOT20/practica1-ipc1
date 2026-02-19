/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBasquet;

import com.mycompany.practica1ipc1.Menus.MenuBase.MenuBase;
import com.mycompany.practica1ipc1.Menus.MenuPrincipal.MenuPrincipal;

/**
 *
 * @author Kenny
 */
public class MenuFinalBasquet extends MenuBase{

    private final MenuInicialBasquet menuInicialBasquet;
    private final MenuPrincipal menuPrincipal;
    private int opcion;

    public MenuFinalBasquet() {
        this.menuInicialBasquet =new MenuInicialBasquet();
        this.menuPrincipal =new MenuPrincipal();
    }
    
    
    @Override
    public void mostrarInformacion() {
        System.out.println("--------------------------------------");
        System.out.println("|| Que deseas hacer                 ||");
        System.out.println("--------------------------------------");
        System.out.println("||1. Volver a jugar.                ||"      );
        System.out.println("||2. Volver al menu inicial         ||");
        System.out.println("||3. Salir del juego                ||");
        System.out.println("--------------------------------------");
        System.out.print("Ingrese una opcion: ");
        validarOpcion();
    }

    @Override
    public void ejecutarOpcion() {
        switch(opcion){
            case 1:
                limpiarPantalla();
                menuInicialBasquet.mostrarInformacion();
                break;
            case 2:
                limpiarPantalla();
                menuPrincipal.mostrarInformacion();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                    limpiarPantalla();
                    System.out.println("Opcion incorrecta, intente de nuevo.");
                    mostrarInformacion();
                    break;
    }
        
        
    }

    @Override
    public void validarOpcion() {
        
         boolean opcionCorrecta = false; 
        
        while(opcionCorrecta == false){
            try{
            opcion = Integer.parseInt(getScanner().nextLine());
            limpiarPantalla();
            ejecutarOpcion();
            opcionCorrecta = true;
            } catch(NumberFormatException e){
                getScanner().nextLine();
                limpiarPantalla();
                System.out.println("Opcion no valida, intente de nuevo.");
                mostrarInformacion();
            }
           
        }
    }
    
}
