package modelos.datos;

import java.io.Serializable;

public class Jugador implements Serializable{

    private String identificadorJugador;
    private PuntuacionJugador puntuacionJugador;

    //Constructor defecto
    public Jugador() {
        this.identificadorJugador = "";
        this.puntuacionJugador = new PuntuacionJugador();
    }

    //Constructor solo identificadorJugador
    public Jugador(String nombre) {
        this.identificadorJugador = nombre;
        this.puntuacionJugador = new PuntuacionJugador();
    }

    //Constructor parámetros total

    public Jugador(String nombre, int turnoActual, boolean esSuTurno, PuntuacionJugador puntuacionJugador) {
        this.identificadorJugador = nombre;
        this.puntuacionJugador = puntuacionJugador;
    }

    public String getIdentificadorJugador() {
        return identificadorJugador;
    }

    public void setIdentificadorJugador(String identificadorJugador) {
        this.identificadorJugador = identificadorJugador;
    }


    public PuntuacionJugador getPuntuacionJugador() {
        return puntuacionJugador;
    }

    public void setPuntuacionJugador(PuntuacionJugador puntuacionJugador) {
        this.puntuacionJugador = puntuacionJugador;
    }
   


}
