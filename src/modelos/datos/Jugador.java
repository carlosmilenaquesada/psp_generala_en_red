package modelos.datos;

import java.io.Serializable;

public class Jugador implements Serializable{

    private String nombre;
    private PuntuacionJugador puntuacionJugador;

    //Constructor defecto
    public Jugador() {
        this.nombre = "";
        this.puntuacionJugador = new PuntuacionJugador();
    }

    //Constructor solo nombre
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntuacionJugador = new PuntuacionJugador();
    }

    //Constructor parámetros total

    public Jugador(String nombre, int turnoActual, boolean esSuTurno, PuntuacionJugador puntuacionJugador) {
        this.nombre = nombre;
        this.puntuacionJugador = puntuacionJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public PuntuacionJugador getPuntuacionJugador() {
        return puntuacionJugador;
    }

    public void setPuntuacionJugador(PuntuacionJugador puntuacionJugador) {
        this.puntuacionJugador = puntuacionJugador;
    }
   


}
