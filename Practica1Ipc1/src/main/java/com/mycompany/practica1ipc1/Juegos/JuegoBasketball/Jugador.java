/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1ipc1.Juegos.JuegoBasketball;

/**
 *
 * @author Kenny
 */
public class Jugador {
    private  String nombre;
    private  int cantidadPunteo;

    public Jugador() {
        this.cantidadPunteo = 0;
    }

    public void agregarPuntos(int punteoRecibido){
        cantidadPunteo += punteoRecibido;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getCantidadPunteo() {
        return cantidadPunteo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadPunteo(int cantidadPunteo) {
        this.cantidadPunteo = cantidadPunteo;
    }
    
    
    
}
