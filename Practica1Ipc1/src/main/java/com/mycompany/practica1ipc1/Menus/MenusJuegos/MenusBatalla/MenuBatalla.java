/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Menus.MenusJuegos.MenusBatalla;

import com.mycompany.practica1ipc1.Juegos.JuegoBatalla.Batalla;
import com.mycompany.practica1ipc1.Juegos.JuegoBatalla.MotorJuegoBatalla;
import com.mycompany.practica1ipc1.Menus.MenuBase.MenuBase;

/**
 *
 * @author Kenny
 */
public class MenuBatalla extends MenuBase {

    private final MotorJuegoBatalla motorBatalla;
    private final Batalla batalla;

    public MenuBatalla(MotorJuegoBatalla motorBatalla) {
        this.motorBatalla = motorBatalla;
        this.batalla = new Batalla(motorBatalla, this);
    }
    
    
    
    @Override
    public void mostrarInformacion() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("|| Dificultad:  " +  motorBatalla.getDificultadElegida());
        System.out.println("|| Rango de Letras:  " +  motorBatalla.getRangoDeLetras());
        System.out.println("------------------------------------------------------------------");
        System.out.println("||Datos de la batalla:                   ");
        System.out.println("|| HP Jugador: " + motorBatalla.getJugador().getVida() + "  Nivel jugador:  " + motorBatalla.getJugador().getNivel());
        System.out.println("|| HP Maquina: " + motorBatalla.getMaquina().getVida() + "  Nivel Maquina:  " + motorBatalla.getMaquina().getNivel());
        System.out.println("------------------------------------------------------------------");
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
               motorBatalla.getJugador().setLetra(letraObtenida);
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
        System.out.println("------------------------------------------------------------------");
        System.out.println("|| Resultado del turno                    ");
        System.out.println("------------------------------------------------------------------");
        System.out.println("|| Letra ingresada: " + Character.toUpperCase(motorBatalla.getJugador().getLetra()) + "                     ");
        System.out.println("|| Letra de la maquina: " + motorBatalla.getMaquina().getLetra() + "                   ");
        System.out.println("------------------------------------------------------------------");
        
        if(motorBatalla.getJugador().getLetra() == motorBatalla.getMaquina().getLetra()){
            System.out.println("|| Adivinaste la letra                   ");
            System.out.println("|| Has atacado e hiciste : " + motorBatalla.getMaquina().getDaño()+ "  de daño                ");
        } else {
            System.out.println("|| No adivinaste la letra                ");
            System.out.println("|| La maquina ataco y te hizo : " + motorBatalla.getJugador().getDaño() + "  de daño                  ");
        }
        
        System.out.println("------------------------------------------------------------------");
    }
    
    public void informacionPersonaje(){

           System.out.println("------------------------------------------------------------------");

        if(motorBatalla.getJugador().isSubioDeNivel() == true){

            System.out.println("||           ¡HAS SUBIDO DE NIVEL!         ||");
            System.out.println("------------------------------------------------------------------");
            System.out.println("|| Personaje: " + motorBatalla.getJugador().getNombrePersonaje());
            System.out.println("|| Nivel actual: " + motorBatalla.getJugador().getNivel());
            System.out.println("|| +20 puntos de vida máxima");
            System.out.println("|| Vida restaurada completamente");

        } 
        else if(motorBatalla.getMaquina().isSubioDeNivel() == true){

            System.out.println("||        ¡LA MAQUINA SUBE DE NIVEL!      ||");
            System.out.println("------------------------------------------------------------------");
            System.out.println("|| Personaje: " + motorBatalla.getMaquina().getNombrePersonaje());
            System.out.println("|| Nivel actual: " + motorBatalla.getMaquina().getNivel());
            System.out.println("|| +20 puntos de vida máxima");
            System.out.println("|| Vida restaurada completamente");

        }

        System.out.println("------------------------------------------------------------------");
    }

    
   public void informacionFinalDeBatalla(){

       if(motorBatalla.getJugador().getVida() <= 0){
           System.out.println("Has perdido la batalla, te quedaste sin vida");
       } else{
           System.out.println("La maquina perdio la batalla");
       }
       
       System.out.println("------------------------------------------------------------------");
        System.out.println("||           RESULTADOS FINALES           ");
        System.out.println("------------------------------------------------------------------");

        System.out.println("|| JUGADOR:");
        System.out.println("|| Vida: " + motorBatalla.getJugador().getVida());
        System.out.println("|| Nivel: " + motorBatalla.getJugador().getNivel());
        System.out.println("|| Letras adivinadas : " + motorBatalla.getJugador().getContadorVictorias());
        System.out.println("|| Letras no adivinadas : " + motorBatalla.getMaquina().getContadorVictorias());

        System.out.println("------------------------------------------------------------------");

        System.out.println("|| MAQUINA:");
        System.out.println("|| Vida: " + motorBatalla.getMaquina().getVida());
        System.out.println("|| Nivel: " + motorBatalla.getMaquina().getNivel());

        System.out.println("------------------------------------------------------------------");
    }
    
}
