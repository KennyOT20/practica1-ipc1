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
    private int vidaTotalJugadorBatalla;
    private int vidaTotalMaquinaBatalla;
    private int vidaMaquina;
    private int nivelMaquina;
    private int nivelJugador;
    private int cantidadVecesAdivinadas;
    private int cantidadVecesFalladas;
    private char letraJugador;
    private String dificultadElegida;
    private String rangoDeLetras;
    private final char letrasFacil[] = {'A', 'E', 'I', 'O', 'U'};
    private final char abecedario[] = new char [26];
    private int contadorSubidaNivelMaquina;
    private int contadorSubidaNivelJugador;
    private int vecesGanadasJugador;
    private int vecesGanadasMaquina;
    private int dañoCalculadoJug;
    private int dañoCalculadoMaq;
    private int opcionElegidaDificultas;
    private char letraPensada;

    //constructor para construir o crear el objeto.
    public MotorBatalla() {
        this.vidaJugador = 200;
        this.vidaMaquina = 200;
        this.vidaTotalJugadorBatalla = 200;
        this.vidaTotalMaquinaBatalla = 200;
        this.nivelMaquina = 1;
        this.nivelJugador = 1;
        this.cantidadVecesAdivinadas = 0;
        this.cantidadVecesFalladas = 0;
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
        letraPensada = pensarLetra(dificultad);
    }
    
    /**
     * Metodo encargado para simular el daño entre los personajes
     * @param personaje recibe un boolean para ejecutar el daño
     * si el parametro es verdadero, entonces el jugador ataca y la maquina 
     * recibe el daño, pero si es falso la maquina ataca y el jugador recibe el daño.
     */
    public void recibirDañoPersonajes(boolean personaje){
        if(personaje == true){
            
            dañoCalculadoJug = generarNumeros(15, 30);
            vidaMaquina -= dañoCalculadoJug;
            vecesGanadasJugador ++;
            contadorSubidaNivelJugador ++;

            if(vidaMaquina <= 0){
                vidaMaquina = 0;
            }
        
        subirNivelPersonaje(true);
        
        } else if(personaje == false){
             dañoCalculadoMaq = generarNumeros(15, 30);
            vidaJugador -= dañoCalculadoMaq;
           vecesGanadasMaquina++;
           contadorSubidaNivelMaquina ++;
        
            if(vidaJugador <= 0){
            vidaJugador = 0;
            }
        
        subirNivelPersonaje(false);
        }
        
    }
    
    /**
     * Metodo encargado de subir el nivel del personaje 
     * @param personaje recibe un booleano desde el metodo recibirDaño
     * si es verdadero entonces el personaje sube de nivel y si es falso la maquina
     * sube de nivel, solo se pueden subir de nivel si se cumplen las condiciones 
     * establecidas.
     */
    private void subirNivelPersonaje(boolean personaje){
        
        if(personaje == true && vecesGanadasJugador == 3 ){
            nivelJugador += 1;
            recompensasSubidaDeNivel(personaje);
            vecesGanadasJugador = 0;
            System.out.println("Has subido de nivel!");
            System.out.println("Has recibido 20 puntos de vida extra");
            System.out.println("Y se te ha restablecido la vida completa");
        } else if(personaje == false && vecesGanadasMaquina == 4){
            nivelMaquina ++;
            recompensasSubidaDeNivel(personaje);
            vecesGanadasMaquina = 0;
            System.out.println("La maquina ha subido de nivel.");
            System.out.println("La maquina obtuvo 20 puntos de vida extra");
            System.out.println("La maquina restablecio su vida completa");
        }
    }
    
    /**
     * Metodo encargado de dar recompensar como 20 de vida mas y restauracion total de la misma
     * @param personaje recibe un boolean, si es verdadero el jugador sube de nievel pero si es falso
     * la maquina sube de nivel.
     */
    public void recompensasSubidaDeNivel(boolean personaje){
        
        if(personaje == true){
            vidaTotalJugadorBatalla += 20;
            vidaJugador = vidaTotalJugadorBatalla;
        } else if(personaje == false){
            vidaTotalMaquinaBatalla +=20;
            vidaMaquina = vidaTotalMaquinaBatalla;
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
        return letraJugador == letraPensada;
    }
    
    //Getters y setters para acceder a las variables desde fuera de la clase y aprovechar la encapsulacion
    public int getVidaJugador() {
        return vidaJugador;
    }

    public int getVidaMaquina() {
        return vidaMaquina;
    }

    public int getNivelMaquina() {
        return nivelMaquina;
    }


    public int getNivelJugador() {
        return nivelJugador;
    }

    public int getCantidadVecesAdivinadas() {
        return cantidadVecesAdivinadas;
    }

    public int getCantidadVecesFalladas() {
        return cantidadVecesFalladas;
    }


    public char getLetraPensada() {
        return letraPensada;
    }

    public void setLetraPensada(char letraPensada) {
        this.letraPensada = letraPensada;
    }

    public String getDificultadElegida() {
        return dificultadElegida;
    }

    public String getRangoDeLetras() {
        return rangoDeLetras;
    }

    public char getLetraJugador() {
        return letraJugador;
    }

    public void setLetraJugador(char letraJugador) {
        this.letraJugador = letraJugador;
    }

    public int getDañoCalculadoJug() {
        return dañoCalculadoJug;
    }

    public int getDañoCalculadoMaq() {
        return dañoCalculadoMaq;
    }
     
    

    public int getOpcionElegidaDificultas() {
        return opcionElegidaDificultas;
    }

    public void setOpcionElegidaDificultas(int opcionElegidaDificultas) {
        this.opcionElegidaDificultas = opcionElegidaDificultas;
    }

    public int getVecesGanadasMaquina() {
        return vecesGanadasMaquina;
    }


    public int getVecesGanadasJugador() {
        return vecesGanadasJugador;
    }

    public int getVidaTotalJugadorBatalla() {
        return vidaTotalJugadorBatalla;
    }

    public int getVidaTotalMaquinaBatalla() {
        return vidaTotalMaquinaBatalla;
    }

    
    
}
