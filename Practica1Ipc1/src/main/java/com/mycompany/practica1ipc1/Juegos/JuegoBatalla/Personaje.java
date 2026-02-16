/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Juegos.JuegoBatalla;

/**
 *
 * @author Kenny
 */
public abstract class Personaje {
    
    private int vidaMax;
    private int vida;
    private int nivel;
    private int contadorVecesGanadas;
    private int contadorVictorias;
    private int daño;
    private final String nombrePersonaje;
    private boolean subioDeNivel;
    private char letra;
    private int cantidadDeAciertos;
    private int cantidadDeVictorias;

    public Personaje(String nombrePersonaje) {
        this.vidaMax = 200;
        this.vida = 200;
        this.nivel = 1;
        this.contadorVecesGanadas = 0;
        this.nombrePersonaje = nombrePersonaje;
        this.subioDeNivel = false;
        this.cantidadDeAciertos = 0;
        this.cantidadDeVictorias = 0;
    }
    
    public void recibirDaño(int dañoRecibido){
        daño = dañoRecibido;
        vida -= dañoRecibido;
        if(vida <= 0){
            vida = 0;
        }
    }
    
    public void subirDeNivelPersonaje(){
        nivel ++;
        vidaMax += 20;
        vida = vidaMax;
        contadorVecesGanadas = 0;
        subioDeNivel = true;
    }
   
    public void incrementarVecesGanadas(){
        contadorVecesGanadas ++;
    }

    public void incrementarVictorias(){
        contadorVictorias ++;
    }
    
    public int getVidaMax() {
        return vidaMax;
    }

    public int getVida() {
        return vida;
    }

    public int getNivel() {
        return nivel;
    }

    public int getContadorVecesGanadas() {
        return contadorVecesGanadas;
    }

    public int getContadorVictorias() {
        return contadorVictorias;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public boolean isSubioDeNivel() {
        return subioDeNivel;
    }

     public void setSubioDeNivel(boolean subioDeNivel) {
        this.subioDeNivel = subioDeNivel;
    }
     
    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getCantidadDeAciertos() {
        return cantidadDeAciertos;
    }

    public void setCantidadDeAciertos(int cantidadDeAciertos) {
        this.cantidadDeAciertos = cantidadDeAciertos;
    }

    public int getCantidadDeVictorias() {
        return cantidadDeVictorias;
    }

    public void setCantidadDeVictorias(int cantidadDeVictorias) {
        this.cantidadDeVictorias = cantidadDeVictorias;
    }
    
    
    
    
   
}
