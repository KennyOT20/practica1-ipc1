/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 package com.mycompany.practica1ipc1.Juegos.JuegoWordle;

/**
 *
 * @author Kenny
 */
public class MotorWordle {
    
    private char [] palabraUsuario;
    private char [] palabraOculta;
    private final String[][] intentosPalabraOculta;
    private String palabraOcultada;
    private String palabraIntento;
    private int cantidadIntentos;
    private int cantidadTotalDeIntentos;
    private static int cantidadVecesPerdidas; 
    private static int cantidadDeIntentos;
    private final String COLOR_ROJO = "\u001B[31m";
    private final String COLOR_VERDE = "\u001B[32m";
    private final String COLOR_AMARILLO =   "\u001B[33m"; 
    private final String RESETEAR_COLOR = "\u001B[0m";

    //COnstructor para crear las instancias necesarias
    public MotorWordle() {
        this.palabraUsuario = new char[5];
        this.palabraOculta = new char [5];
        this.intentosPalabraOculta = new String [6][5];
        this.cantidadIntentos = 0;
        this.cantidadTotalDeIntentos = 6;
    }
    
    /**
     * Metodo encargado para colocar las letras de las palabra oculta o de la palabra adivinada en un arreglo char
     * @param palabraRecibida recibe desde los menus una palabra que se ingrese, esta puede ser una palabra 
     * intento o una palabra oculta
     * @param palabraDelUsuario  recibe parametros booleanos, si es verdadero se ingresa la palabra del usuario
     * en un arreglo, pero si es falso entonces es la palabra oculta para colocar en un arreglo.
     */
  public void ingresarPalabraArreglo(String palabraRecibida, boolean palabraDelUsuario){
        
        if(palabraDelUsuario == true){
           palabraUsuario = palabraRecibida.toCharArray();
        } else{
           palabraOculta = palabraRecibida.toCharArray();
        }     
    }
    
  /**
   * Metodo encargado para ir comparando las letras de la palabra ingresada adivinada con la 
   * palabra oculta. 
   */
    public void compararLetras(){
        char letraOculta;
        char letraIntento;

        for (int i = 0; i < palabraOculta.length; i++) {
            letraOculta = palabraOculta[i];
            letraIntento = palabraUsuario[i];
            
            if(letraIntento == letraOculta){
                pintarLetras(letraIntento, 1, i);
            } else if(verificarLetraExistente(letraIntento) == true){
                pintarLetras(letraIntento, 2, i);
            } else{
                pintarLetras(letraIntento, 3, i);
            }
        }
        
        System.out.println("");
        
        cantidadIntentos ++;
    }

    /**
     * Metodo encargado de verificar si la letra existe en el arreglo de la palabra oculta
     * si es verdadero entonces retorna un true, esta condicion nos facilita pintar las letras correctamente
     * @param letraOculta recibe la letra que se esta verificando desde el metodo compararLetras
     * @return un verdadero si la letra existe en el arreglo de la palabra oculta un falso si tal letra no existe.
     */
    public boolean verificarLetraExistente(char letraOculta){
        
        for (int i = 0; i < palabraOculta.length; i++) {
            if(palabraOculta[i] == letraOculta){
                return true;
            } 
        }
        return false;
    }
    
    /**
     * Verifica si la palabra adivinida es igual a la palrabra oculta, este metodo sirve para poder verificar 
     * si todavia el usuario adivina la palabra para poder terminar la partida.
     * @return un verdadero si la palabra es igual a la oculta, y un falso si n o.
     */
    public boolean verificarPalabraCorrecta(){
        if(palabraIntento.equalsIgnoreCase(palabraOcultada)){
            return true;
        } else{
            return false;
        }
    }
    
    /**
     * Metodo encargado de ir pintando las letras segun su posicion.
     * @param letraVerificada  recibre desde el metodo comparar letras una letra
     * segun su posicion
     * @param posicionLetras recibe numeros para identificar la posicion de las letras, si es 
     * 1 entonces la letra es correcta y se pnta de verde, si es 2 la letra existe en el arreglo
     * palabra oculta pero no esta un su posicion eta se pintara de amarillo, si es 3 la letra no 
     * existe y se pinta de rojo.
     * @param columna recibe la columna que se va recorriendo el arreglo.
     */
    private void pintarLetras(char letraVerificada, int posicionLetras, int columna){
        String letraColoreada;
        
        switch (posicionLetras) {
            case 1:
                letraColoreada = COLOR_VERDE + letraVerificada + RESETEAR_COLOR;
                break;
            case 2:
                letraColoreada = COLOR_AMARILLO + letraVerificada + RESETEAR_COLOR;
                break;
            default:
                letraColoreada = COLOR_ROJO + letraVerificada + RESETEAR_COLOR;
                break;
        }
        
        intentosPalabraOculta[cantidadIntentos][columna] = letraColoreada;
        
    }
    
    /**
     * Metodo encargado de ir imprimiendo los intentos anterios con todo y sus colores asignados
     * eb el metodo pintar letra. Ademas este metodo cumple  con la funcion de llamar dos metodos
     * y un indice para una mejor visualizacion de la partida.
     */
    public void imprimirIntentos(){
        
        System.out.println("-------------------------");
        
        
        for(int fila = 0; fila < cantidadIntentos; fila++){
            System.out.print("|| " + (fila + 1) + " || ");
            
            
            for(int columna = 0; columna < intentosPalabraOculta[fila].length; columna++){

                System.out.print(intentosPalabraOculta[fila][columna] + "  ");
            }
            System.out.println("||");
        }
        
        System.out.println("-------------------------");
    }

    // Getters y setters para acceder desde el exterior de esta clase a los atributos propios.
    public int getCantidadIntentos() {
        return cantidadIntentos;
    }

    public static int getCantidadVecesPerdidas() {
        return cantidadVecesPerdidas;
    }

    public static void setCantidadVecesPerdidas(int cantidadVecesPerdidas) {
        MotorWordle.cantidadVecesPerdidas = cantidadVecesPerdidas;
    }
    public void setCantidadIntentos(int cantidadIntentos) {
        this.cantidadIntentos = cantidadIntentos;
    }

    public static int getCantidadDeIntentos() {
        return cantidadDeIntentos;
    }

    public static void setCantidadDeIntentos(int cantidadDeIntentos) {
        MotorWordle.cantidadDeIntentos = cantidadDeIntentos;
    }

    
    public void setCantidadTotalDeIntentos(int cantidadTotalDeIntentos) {
        this.cantidadTotalDeIntentos = cantidadTotalDeIntentos;
    }
    
    

    public int getCantidadTotalDeIntentos() {
        return cantidadTotalDeIntentos;
    }

    
    public String getPalabraOcultada() {
        return palabraOcultada;
    }

    public void setPalabraOcultada(String palabraOcultada) {
        this.palabraOcultada = palabraOcultada;
    }

    public void setPalabraIntento(String palabraIntento) {
        this.palabraIntento = palabraIntento;
    }

    
    
    
}
