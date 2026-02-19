/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Menus.MenuPrincipal;

import com.mycompany.practica1ipc1.Juegos.InstruccionesJuegos.InstruccionesBasquetball;
import com.mycompany.practica1ipc1.Juegos.InstruccionesJuegos.InstruccionesBatalla;
import com.mycompany.practica1ipc1.Juegos.InstruccionesJuegos.InstruccionesWordle;
import com.mycompany.practica1ipc1.Juegos.Reportes.Reportes;
import com.mycompany.practica1ipc1.Menus.MenuBase.MenuBase;
import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBasquet.MenuInicialBasquet;
import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBatalla.MenuOpcionesBatalla;
import com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusWordle.MenuInicialWordle;

/**
 *
 * @author Kenny
 */
public class MenuPrincipal extends MenuBase {

    private final InstruccionesBatalla instruccionesBatalla;
    private final MenuOpcionesBatalla menuBatalla;
    private final InstruccionesWordle instruccionesWordle;
    private final MenuInicialWordle menuWordle;
    private final InstruccionesBasquetball instruccionesBasquet;
    private final MenuInicialBasquet menuBasquet;
    private final Reportes reportes;
    private int opcion;

    public MenuPrincipal() {
        this.instruccionesBatalla = new InstruccionesBatalla();
        this.menuBatalla = new MenuOpcionesBatalla();
        this.instruccionesWordle = new InstruccionesWordle();
        this.menuWordle = new MenuInicialWordle();
        this.instruccionesBasquet = new InstruccionesBasquetball();
        menuBasquet = new MenuInicialBasquet();
        this.reportes = new Reportes(menuBatalla, menuWordle, menuBasquet);
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("------------------------------------------------------------");
        System.out.println("||                                                        ||");
        System.out.println("||        BIENVENIDO A LA LIBRERIA DE JUEGOS              ||");
        System.out.println("||                                                        ||");
        System.out.println("------------------------------------------------------------");
        System.out.println("||  1. Batallas                                           ||");
        System.out.println("||  2. Wordle                                             ||");
        System.out.println("||  3. Basketball                                         ||");
        System.out.println("||  4. Reportes                                           ||");
        System.out.println("||  5. Salir                                              ||");
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
                instruccionesWordle.mostrarInstrucciones();
                getScanner().nextLine();
                limpiarPantalla();
                menuWordle.mostrarInformacion();
            }
            case 3 -> {
                instruccionesBasquet.mostrarInstrucciones();
                getScanner().nextLine();
                limpiarPantalla();
                menuBasquet.mostrarInformacion();
            }
            case 4 -> {
                reportes.mostrarReportes();
                getScanner().nextLine();
                limpiarPantalla();
                mostrarInformacion();
            }
            case 5 ->{
               System.exit(0);
            }
            default -> {
                 limpiarPantalla();
                System.out.println("Opcion incorrecta, intente de nuevo.");
                mostrarInformacion();
            }
        }
    }

    @Override
    public void validarOpcion() {
        boolean opcionCorrecta = false;
        
        while(!opcionCorrecta){
            try{
                opcion = Integer.parseInt(getScanner().nextLine());
                limpiarPantalla();
                ejecutarOpcion();
                opcionCorrecta = true;
            } catch(NumberFormatException e ){
                getScanner().nextLine();
                limpiarPantalla();
                System.out.println("Opcion Incorrecta, intente de nuevo");
                mostrarInformacion();
            }
            
        }
    }
    
}
