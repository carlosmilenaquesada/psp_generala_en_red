package modelos.flujo.serializaciones;

import java.io.Serializable;

public class SerializacionEstadoPartida implements Serializable {

    private int rondaActual;//de 1 a 12, doce turnos dura cada partida
    private int tiradasRealizadasEnElTurnoDelJugador;//de 0 a 3 (empieza en cero porque puede que no haya hecho ninguna aún)
    private int turnoDeLaRonda;//de 1 a 2 (1 primer jugador tira hasta 3 veces, 2 segundo jugador tira hasta 3 veces)
    private String idJugadorEnTurno;//la id del jugador al que le toca o le está tocando

    public SerializacionEstadoPartida(int rondaActual, int tiradasRealizadasEnElTurnoDelJugador, int turnoDeLaRonda, String idJugadorEnTurno) {
        this.rondaActual = rondaActual;
        this.tiradasRealizadasEnElTurnoDelJugador = tiradasRealizadasEnElTurnoDelJugador;
        this.turnoDeLaRonda = turnoDeLaRonda;
        this.idJugadorEnTurno = idJugadorEnTurno;
    }

   

    //Constructor por defecto para cuando se recién se incie la partida (lo uso cuando
    //ya conozco quien empezará)   
    public SerializacionEstadoPartida(String idJugadorEnTurno) {
        this.rondaActual = 1;
        this.tiradasRealizadasEnElTurnoDelJugador = 0;
        this.turnoDeLaRonda = 1;
        this.idJugadorEnTurno = idJugadorEnTurno;
    }

    public int getRondaActual() {
        return rondaActual;
    }

    public void setRondaActual(int rondaActual) {
        this.rondaActual = rondaActual;
    }

    public int getTiradasRealizadasEnElTurnoDelJugador() {
        return tiradasRealizadasEnElTurnoDelJugador;
    }

    public void setTiradasRealizadasEnElTurnoDelJugador(int tiradasRealizadasEnElTurnoDelJugador) {
        this.tiradasRealizadasEnElTurnoDelJugador = tiradasRealizadasEnElTurnoDelJugador;
    }

    public int getTurnoDeLaRonda() {
        return turnoDeLaRonda;
    }

    public void setTurnoDeLaRonda(int turnoDeLaRonda) {
        this.turnoDeLaRonda = turnoDeLaRonda;
    }

    public String getIdJugadorEnTurno() {
        return idJugadorEnTurno;
    }

    public void setIdJugadorEnTurno(String idJugadorEnTurno) {
        this.idJugadorEnTurno = idJugadorEnTurno;
    }


}
