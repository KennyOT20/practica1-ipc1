/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Juegos.JuegoBatalla;

import java.util.Random;

/**
 *
 * @author Kenny
 */
public class MotorJuegoBatalla {
    
    private final Random random = new Random();
    private final Jugador jugador;
    private final Maquina maquina;
    private String dificultadElegida;
    private String rangoDeLetras;
    private final char letrasFacil[] = {'A', 'E', 'I', 'O', 'U'};
    private final char abecedario[] = new char [26];
    private int opcionElegidaDificultas;

    //constructor para construir o crear el objeto.
    public MotorJuegoBatalla() {
        this.jugador = new Jugador();
        this.maquina = new Maquina();
        generarAbecedario();
    }
    
    /**
     * Metodo encargado de simular que la maquina piense una letra
     * @param opcionElegida recibe la opcion de dificultad que eligio el usuario
     * si es 1 es facil, 2 es media y 3 es dificil.
     * @return la letra pensada dependientemente de la dificultad que uso el usuario
     * si hay un error entonces retorna una A por defecto.
     */
    public char pensarLetra(int opcionElegida){
        int numeroIndice;
        switch (opcionElegida) {
            case 1 -> {
                numeroIndice = generarNumeros(0, letrasFacil.length);
                dificultadElegida = "Facil";
                rangoDeLetras = "(A-U)";
                return letrasFacil[numeroIndice];
            }
            case 2 -> {
                numeroIndice = generarNumeros(0, 11);
                dificultadElegida = "Media";
                rangoDeLetras = "(A-K)";
                return abecedario[numeroIndice];
            }
            case 3 ->{
                numeroIndice = generarNumeros(0, abecedario.length);
                dificultadElegida = "Dificil";
                rangoDeLetras = " (A-Z)";
                return abecedario[numeroIndice];
            }
            default -> {
                return 'A';
            }
                
        }

    }
    
    /**
     * Metodo encargado para ir actualizando la letra que la maquina piense independientemente
     * si el usuario adivina o no la letra.
     * @param dificultad recibe un entero de la dificultad que eligio el usuario y llama al metodo
     * pensar letra.
     */
    public void actualizarLetraPensada(int dificultad){
        char letraPensada = pensarLetra(dificultad);
        maquina.setLetra(letraPensada);
    }

    
    public void recibirDañoPersonajes(boolean personaje){

        int dañoCalculado = generarNumeros(15, 30);
        
        if(personaje == true){
            maquina.recibirDaño(dañoCalculado);
            jugador.incrementarVecesGanadas();
            jugador.incrementarVictorias();
            
            if(jugador.getContadorVecesGanadas() == 3){
                jugador.subirDeNivelPersonaje();
            }
            
        } else if(personaje == false){
            jugador.recibirDaño(dañoCalculado);
            maquina.incrementarVecesGanadas();
            maquina.incrementarVictorias();
            
            if(maquina.getContadorVecesGanadas() == 4){
                maquina.subirDeNivelPersonaje();
            }
        }
        
    }
    
    /**
     * Metodo encargado para generar un numero random en un intervalo definido
     * esto sirve y facilita el calculo de año, aleatorizar los indices de los arreglos de letras
     * y asi simular que la maquina piense una letra.
     * @param min recibe un numero minimo de un intervalo
     * @param max recibe un numero maximo del intervalo
     * @return un numero random entre << min >> y << max >> 
     */
    public int generarNumeros(int min, int max){
        return random.nextInt(min, max);
    }
    
    /**
     * Genera las letras  del abecedario en letras mayusculas y las agrega en un arreglo.
     */
    private void generarAbecedario(){
        int indice = 0;
        
        for (char letra  = 'A'; letra <= 'Z'; letra ++) {
            abecedario[indice++] = letra;
        }
    }
    
    protected boolean compararLetras(char letraJugador){       
        return letraJugador == maquina.getLetra();
    }

    public String getDificultadElegida() {
        return dificultadElegida;
    }

    public String getRangoDeLetras() {
        return rangoDeLetras;
    }

    public int getOpcionElegidaDificultas() {
        return opcionElegidaDificultas;
    }

    public void setOpcionElegidaDificultas(int opcionElegidaDificultas) {
        this.opcionElegidaDificultas = opcionElegidaDificultas;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Maquina getMaquina() {
        return maquina;
    }
    
}
