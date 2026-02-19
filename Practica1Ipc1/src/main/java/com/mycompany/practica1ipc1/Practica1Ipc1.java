/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica1ipc1;

import com.mycompany.practica1ipc1.Menus.MenuPrincipal.MenuPrincipal;
import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBasquet.MenuInicialBasquet;
import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBatalla.MenuOpcionesBatalla;
import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusWordle.MenuInicialWordle;

/**
 *
 * @author Kenny
 */
public class Practica1Ipc1 {

    public static void main(String[] args) {
        
       if(args.length > 0){

            String opcionParametro = args[0];

            switch(opcionParametro){

                case "1":
                    MenuOpcionesBatalla opcionesBatalla = new MenuOpcionesBatalla();
                    opcionesBatalla.limpiarPantalla();
                    System.out.println("Bienvenido al juego de batallas.");
                    opcionesBatalla.mostrarInformacion();
                    break;

                case "2":
                    MenuInicialWordle menuWordle = new MenuInicialWordle();
                    menuWordle.limpiarPantalla();
                    menuWordle.mostrarInformacion();
                    break;

                case "3":
                    MenuInicialBasquet menuBasquet = new MenuInicialBasquet();
                    menuBasquet.limpiarPantalla();
                    menuBasquet.mostrarInformacion();
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.limpiarPantalla();
                    menuPrincipal.mostrarInformacion();
                    break;
            }

        }
        else{

            MenuPrincipal menuPrincipal = new MenuPrincipal();
            menuPrincipal.mostrarInformacion();

        }

    }
}
