/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBatalla;

import com.mycompany.practica1ipc1.Juegos.JuegoBatalla.Batalla;
import com.mycompany.practica1ipc1.Juegos.JuegoBatalla.MotorBatalla;
import com.mycompany.practica1ipc1.Menus.MenuBase.MenuBase;

/**
 *
 * @author Kenny
 */
public class MenuBatalla extends MenuBase {

    private final MotorBatalla motorBatalla;
    private final Batalla batalla;

    public MenuBatalla(MotorBatalla motorBatalla) {
        this.motorBatalla = motorBatalla;
        this.batalla = new Batalla(motorBatalla, this);
    }
    
    
    
    @Override
    public void mostrarInformacion() {
        System.out.println("---------------------------------------------");
        System.out.println("|| Dificultad:  " +  motorBatalla.getDificultadElegida());
        System.out.println("|| Rango de Letras:  " +  motorBatalla.getRangoDeLetras());
        System.out.println("---------------------------------------------");
        System.out.println("||Datos de la batalla:                   || ");
        System.out.println("|| HP Jugador: " + motorBatalla.getVidaJugador() + "  Nivel jugador:  " + motorBatalla.getNivelJugador());
        System.out.println("|| HP Maquina: " + motorBatalla.getVidaMaquina() + "  Nivel Maquina:  " + motorBatalla.getNivelMaquina());
        System.out.println("-----------------------------------------------");
        System.out.print("||Ingrese una letra para atacar: ");
        validarOpcion();
    }

    @Override
    public void ejecutarOpcion() {
        limpiarPantalla();
        batalla.iniciarBatalla();
    }

    @Override
    public void validarOpcion() {
        String letraJugador ;
        boolean opcionValida = false;
        char letraObtenida;

        while(opcionValida == false ){
            letraJugador = getScanner().nextLine().trim().toUpperCase();
            
            if(letraJugador.length() == 1 && letraJugador.matches("[A-Z]")){
               letraObtenida = letraJugador.charAt(0);
               motorBatalla.setLetraJugador(letraObtenida);
               ejecutarOpcion();
               opcionValida = true;
            } else {
                limpiarPantalla();
                System.out.println("Datos invalidos, solo ingrese una letra.");
                mostrarInformacion();
            }
            
        }
        
    }
    
    public void informacionBatalla(){
        System.out.println("---------------------------------------------");
        System.out.println("|| Resultado del turno                     ||");
        System.out.println("---------------------------------------------");
        System.out.println("|| Letra ingresada: " + Character.toUpperCase(motorBatalla.getLetraJugador()) + "                     ||");
        System.out.println("|| Letra de la maquina: " + motorBatalla.getLetraPensada() + "                   ||");
        System.out.println("---------------------------------------------");
        
        if(motorBatalla.getLetraJugador() == motorBatalla.getLetraPensada()){
            System.out.println("|| Adivinaste la letra                   ||");
            System.out.println("|| Has atacado e hiciste : " + motorBatalla.getDañoCalculadoJug() + "  de daño                ||");
        } else {
            System.out.println("|| No adivinaste la letra                ||");
            System.out.println("|| La maquina ataco y te hizo : " + motorBatalla.getDañoCalculadoMaq() + "  de daño                   ||");
        }
    }
}
