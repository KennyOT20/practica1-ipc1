/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica1ipc1;

import com.mycompany.practica1ipc1.Menus.MenusIniciales.MenuPrincipal;

/**
 *
 * @author Kenny
 */
public class Practica1Ipc1 {

    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.mostrarInformacion();
        String opcionParametro; 
        
       if(args.length > 0 ){
            opcionParametro = args[0].toLowerCase();
            
            switch(opcionParametro){
                case "1" :
                    break;
                case "2" :
                    break;
                case "3" :
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    menuPrincipal.mostrarInformacion();
                    break;
            } 
        } else{
            menuPrincipal.mostrarInformacion();
        }
        
    }
}
