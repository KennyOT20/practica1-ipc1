/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Menus.MenusIniciales;

import com.mycompany.practica1ipc1.Juegos.InstruccionesJuegos.InstruccionesBatalla;
import com.mycompany.practica1ipc1.Menus.MenuBase.MenuBase;
import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBatalla.MenuBatalla;
import java.util.Scanner;

/**
 *
 * @author Kenny
 */
public class MenuPrincipal extends MenuBase {

    private final InstruccionesBatalla instruccionesBatalla;
    private final MenuBatalla menuBatalla;
    private int opcion;

    public MenuPrincipal() {
        this.instruccionesBatalla = new InstruccionesBatalla();
        this.menuBatalla = new MenuBatalla();
    }
    
    
    
    @Override
    public void mostrarInformacion() {
        System.out.println("------------------------------------------------------------");
        System.out.println("||                                                        ||");
        System.out.println("||        BIENVENIDO A LA LIBRERIA DE JUEGOS               ||");
        System.out.println("||                                                        ||");
        System.out.println("------------------------------------------------------------");
        System.out.println("||  1. Batallas                                           ||");
        System.out.println("||  2. Wordle                                             ||");
        System.out.println("||  3. Basketball                                         ||");
        System.out.println("||  4. Salir                                              ||");
        System.out.println("------------------------------------------------------------");
        System.out.print("Ingrese una opcion: ");
        validarOpcion();

    }

    @Override
    public void ejecutarOpcion() {
        
        switch(opcion){
            case 1 -> {
                instruccionesBatalla.mostrarInstrucciones();
                 getScanner().nextLine();
                 limpiarPantalla();
                menuBatalla.mostrarInformacion();
            }
            case 2 -> {
            }
            case 3 -> {
            }
            case 4 -> {
            }
            default -> {
            }
        }
    }

    @Override
    public void validarOpcion() {
         Scanner scanner = new Scanner(System.in);
        boolean opcionCorrecta = false;
        
        while(!opcionCorrecta){
            try{
                opcion = Integer.parseInt(scanner.nextLine());
                limpiarPantalla();
                ejecutarOpcion();
                opcionCorrecta = true;
            } catch(NumberFormatException e ){
                scanner.nextLine();
                limpiarPantalla();
                System.out.println("Opcion Incorrecta, intente de nuevo");
                mostrarInformacion();
            }
            
        }
    }
    
}
