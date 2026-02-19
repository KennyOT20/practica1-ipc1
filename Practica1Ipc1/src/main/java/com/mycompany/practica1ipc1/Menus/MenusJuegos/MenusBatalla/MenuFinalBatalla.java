/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBatalla;

import com.mycompany.practica1ipc1.Menus.MenuBase.MenuBase;
import com.mycompany.practica1ipc1.Menus.MenuPrincipal.MenuPrincipal;

/**
 *
 * @author Kenny
 */
public class MenuFinalBatalla  extends MenuBase{

    private final MenuPrincipal menuPrincipal;
    private final MenuOpcionesBatalla opcionesBatalla;
    int opcion;

    public MenuFinalBatalla() {
        this.menuPrincipal = new MenuPrincipal();
        this.opcionesBatalla  = new MenuOpcionesBatalla() ;
    }
    
    
    
    @Override
    public void mostrarInformacion() {
        System.out.println("------------------------------------------");
        System.out.println("|| La batalla ha finalizado             ||");
        System.out.println("|| ¿Que desea hacer?                    ||");
        System.out.println("------------------------------------------");
        System.out.println("||1. Volver a jugar.                    ||");
        System.out.println("||2. Volver al menu inicial.            ||");
        System.out.println("||3. Salir del programa.                ||");
        System.out.println("------------------------------------------");
        System.out.print("Ingrese una opcion: ");
        validarOpcion();
    }

    @Override
    public void ejecutarOpcion() {
        
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
                System.exit(0);
                break;
            default:
                limpiarPantalla();
                System.out.println("Opcion no valida, intente de nuevo.");
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
