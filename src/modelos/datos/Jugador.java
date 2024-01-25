package modelos.datos;

import java.io.Serializable;

public class Jugador implements Serializable{

    private String nombre;
    private int turnoActual;
    private boolean esSuTurno;

    private PuntuacionJugador puntuacionJugador;

    //Constructor defecto
    public Jugador() {
        this.nombre = "";
        this.turnoActual = 0;
        this.esSuTurno = false;
        this.puntuacionJugador = new PuntuacionJugador();
    }

    //Constructor solo nombre
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.turnoActual = 0;
        this.esSuTurno = false;
        this.puntuacionJugador = new PuntuacionJugador();
    }

    //Constructor parámetros total

    public Jugador(String nombre, int turnoActual, boolean esSuTurno, PuntuacionJugador puntuacionJugador) {
        this.nombre = nombre;
        this.turnoActual = turnoActual;
        this.esSuTurno = esSuTurno;
        this.puntuacionJugador = puntuacionJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public PuntuacionJugador getPuntuacionJugador() {
        return puntuacionJugador;
    }

    public void setPuntuacionJugador(PuntuacionJugador puntuacionJugador) {
        this.puntuacionJugador = puntuacionJugador;
    }
   


}
