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
public class MotorBatalla {
    
    private final Random random = new Random();
    private int vidaJugador;
    private int vidaMaquina;
    private int nivelMaquina;
    private int nivelJugador;
    private int cantidadVecesAdivinadas;
    private int cantidadVecesFalladas;
    private final char letrasFacil[] = {'A', 'E', 'I', 'O', 'U'};
    private final char abecedario[] = new char [26];
    private char letraPensada;

    public MotorBatalla() {
        this.vidaJugador = 200;
        this.vidaMaquina = 200;
        this.nivelMaquina = 1;
        this.nivelJugador = 1;
        this.cantidadVecesAdivinadas = 0;
        this.cantidadVecesFalladas = 0;
        generarAbecedario();
    }
    
    public char pensarLetra(int opcionElegida){
        int numeroIndice;
        
        switch (opcionElegida) {
            case 1 -> {
                numeroIndice = generarNumeros(0, letrasFacil.length);
                return letrasFacil[numeroIndice];
            }
            case 2 -> {
                numeroIndice = generarNumeros(0, 11);
                return abecedario[numeroIndice];
            }
            case 3 ->{
                numeroIndice = generarNumeros(0, abecedario.length);
                return abecedario[numeroIndice];
            }
            default -> {
                return 'A';
            }
                
        }

    }
    
    public void mostrarOpcion(int opcion){
        if(opcion == 1){
            
            for (int i = 0; i < letrasFacil.length; i++) {
                System.out.println(letrasFacil[i] + " ");
            }
            
            for (char letra : letrasFacil) {
                System.out.println(letra + " ");
            }
            
        } else if(opcion == 2 ){
                for (int i = 0; i < 10; i++) {
                    System.out.println(abecedario[i] + " ");
            }
        } else {
             for (int i = 0; i < abecedario.length; i++) {
                 System.out.println(abecedario[i]);
            }
        }
            
    }
    
    private int generarNumeros(int min, int max){
        return random.nextInt(min, max);
    }
    
    private void generarAbecedario(){
        int indice = 0;
        
        for (char letra  = 'a'; letra <= 'z'; letra ++) {
            abecedario[indice++] = letra;
        }
    }
    
    protected boolean compararLetras(char letraJugador){
        return letraJugador == letraPensada;
        
    }
    
    public void generarLetrasAbecedario(){
        
    }
    
    public boolean verificarLetraArreglo(){
        return false;
    }

    public int getVidaJugador() {
        return vidaJugador;
    }

    public void setVidaJugador(int vidaJugador) {
        this.vidaJugador = vidaJugador;
    }

    public int getVidaMaquina() {
        return vidaMaquina;
    }

    public void setVidaMaquina(int vidaMaquina) {
        this.vidaMaquina = vidaMaquina;
    }

    public int getNivelMaquina() {
        return nivelMaquina;
    }

    public void setNivelMaquina(int nivelMaquina) {
        this.nivelMaquina = nivelMaquina;
    }

    public int getNivelJugador() {
        return nivelJugador;
    }

    public void setNivelJugador(int nivelJugador) {
        this.nivelJugador = nivelJugador;
    }

    public int getCantidadVecesAdivinadas() {
        return cantidadVecesAdivinadas;
    }

    public void setCantidadVecesAdivinadas(int cantidadVecesAdivinadas) {
        this.cantidadVecesAdivinadas = cantidadVecesAdivinadas;
    }

    public int getCantidadVecesFalladas() {
        return cantidadVecesFalladas;
    }

    public void setCantidadVecesFalladas(int cantidadVecesFalladas) {
        this.cantidadVecesFalladas = cantidadVecesFalladas;
    }

    public char getLetraPensada() {
        return letraPensada;
    }

    public void setLetraPensada(char letraPensada) {
        this.letraPensada = letraPensada;
    }
    
    
    
}
