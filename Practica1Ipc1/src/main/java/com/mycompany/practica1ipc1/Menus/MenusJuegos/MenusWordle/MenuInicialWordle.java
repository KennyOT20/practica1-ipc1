/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusWordle;

import com.mycompany.practica1ipc1.Menus.MenuBase.MenuBase;

/**
 *
 * @author Kenny
 */
public class MenuInicialWordle extends MenuBase {

    private String palabra; 
    
    @Override
    public void mostrarInformacion() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("||         Bienvenido a Wordle                         ||");
        System.out.println("-------------------------------------------------------------");
        System.out.print("Ingrese la palabra a ocultar: ");
        validarOpcion();
    }

    @Override
    public void ejecutarOpcion() {
        
        
    }

    @Override
    public void validarOpcion() {
        
        palabra = getScanner().nextLine().trim().toUpperCase();
        
        if(palabra.length() == 5 && palabra.matches("[A-Z]{5}" )){
            ejecutarOpcion();
        } else {
            limpiarPantalla();
            System.out.println("Error palabra incorrecta.");
            System.out.println("La palabra solo debe de tener 5 letras.");
            mostrarInformacion();
        }
        
    }
    
}
