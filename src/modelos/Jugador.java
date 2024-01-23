package modelos;

public class Jugador {

    private String nombre;
    private int puntosTodales;
    private int turnoActual;
    private boolean esSuTurno;

    private boolean[] conseguidasSuperior;
    private boolean[] conseguidasInferior;
    private int[] puntosSuperior;
    private int[] puntosInferior;

    //Constructor defecto
    public Jugador() {
        this.nombre = "";
        this.puntosTodales = 0;
        this.turnoActual = 0;
        this.esSuTurno = false;
        this.conseguidasSuperior = new boolean[6];
        this.conseguidasInferior = new boolean[6];
        this.puntosSuperior = new int[6];
        this.puntosInferior = new int[6];
    }

    //Constructor solo nombre
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntosTodales = 0;
        this.turnoActual = 0;
        this.esSuTurno = false;
        this.conseguidasSuperior = new boolean[6];
        this.conseguidasInferior = new boolean[6];
        this.puntosSuperior = new int[6];
        this.puntosInferior = new int[6];
    }

    //Constructor parámetros total
    public Jugador(String nombre, int puntosTodales, int turnoActual, boolean esSuTurno, boolean[] conseguidasSuperior, boolean[] conseguidasInferior, int[] puntosSuperior, int[] puntosInferior) {
        this.nombre = nombre;
        this.puntosTodales = puntosTodales;
        this.turnoActual = turnoActual;
        this.esSuTurno = esSuTurno;
        this.conseguidasSuperior = conseguidasSuperior;
        this.conseguidasInferior = conseguidasInferior;
        this.puntosSuperior = puntosSuperior;
        this.puntosInferior = puntosInferior;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosTodales() {
        return puntosTodales;
    }

    public void setPuntosTodales(int puntosTodales) {
        this.puntosTodales = puntosTodales;
    }

    public int getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(int turnoActual) {
        this.turnoActual = turnoActual;
    }

    public boolean isEsSuTurno() {
        return esSuTurno;
    }

    public void setEsSuTurno(boolean esSuTurno) {
        this.esSuTurno = esSuTurno;
    }

    public boolean[] getConseguidasSuperior() {
        return conseguidasSuperior;
    }

    public void setConseguidasSuperior(boolean[] conseguidasSuperior) {
        this.conseguidasSuperior = conseguidasSuperior;
    }

    public boolean[] getConseguidasInferior() {
        return conseguidasInferior;
    }

    public void setConseguidasInferior(boolean[] conseguidasInferior) {
        this.conseguidasInferior = conseguidasInferior;
    }

    public int[] getPuntosSuperior() {
        return puntosSuperior;
    }

    public void setPuntosSuperior(int[] puntosSuperior) {
        this.puntosSuperior = puntosSuperior;
    }

    public int[] getPuntosInferior() {
        return puntosInferior;
    }

    public void setPuntosInferior(int[] puntosInferior) {
        this.puntosInferior = puntosInferior;
    }

    public void setConseguidaSuperior(int index, boolean valor) {
        this.conseguidasSuperior[index] = valor;
    }

    public void setConseguidaInferior(int index, boolean valor) {
        this.conseguidasInferior[index] = valor;
    }

    public void setPuntoSuperior(int index, int puntos) {
        this.puntosSuperior[index] = puntos;
    }

    public void setPuntoInferior(int index, int puntos) {
        this.puntosInferior[index] = puntos;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + '}';
    }

}
