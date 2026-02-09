/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Menus.MenuBase;

import java.util.Scanner;

/**
 *
 * @author Kenny
 */
public abstract class MenuBase  {
    
    private final Scanner scanner;

    public MenuBase() {
        this.scanner = new Scanner(System.in);
    }
    
    public abstract void mostrarInformacion();
    public abstract void ejecutarOpcion();
    public abstract void validarOpcion();
    
    public void limpiarPantalla(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    } 

    public Scanner getScanner() {
        return scanner;
    }
    
    
    
}
