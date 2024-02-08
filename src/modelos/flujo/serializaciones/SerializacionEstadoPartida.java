package modelos.flujo.serializaciones;

import java.io.Serializable;

public class SerializacionEstadoPartida implements Serializable {

    private int rondaTurnosActual;//de 1 a 12, doce turnos dura cada partida
    private int tiradasRealizadasEnElTurnoDelJugador;//de 0 a 3 (empieza en cero porque puede que no haya hecho ninguna aún)
    private String idJugadorEnTurno;//la id del jugador al que le toca o le está tocando

    public SerializacionEstadoPartida(int rondaTurnosActual, int tiradasRealizadasEnElTurnoDelJugador, String idJugadorEnTurno) {
        this.rondaTurnosActual = rondaTurnosActual;
        this.tiradasRealizadasEnElTurnoDelJugador = tiradasRealizadasEnElTurnoDelJugador;
        this.idJugadorEnTurno = idJugadorEnTurno;
    }

    //Constructor por defecto para cuando se recién se incie la partida (lo uso cuando
    //ya conozco quien empezará)
    public SerializacionEstadoPartida(String idJugadorEnTurno) {
        this.idJugadorEnTurno = idJugadorEnTurno;
        this.rondaTurnosActual = 1;
        this.tiradasRealizadasEnElTurnoDelJugador = 0;

    }

    public int getRondaTurnosActual() {
        return rondaTurnosActual;
    }

    public void setRondaTurnosActual(int rondaTurnosActual) {
        this.rondaTurnosActual = rondaTurnosActual;
    }

    public int getTiradasRealizadasEnElTurnoDelJugador() {
        return tiradasRealizadasEnElTurnoDelJugador;
    }

    public void setTiradasRealizadasEnElTurnoDelJugador(int tiradasRealizadasEnElTurnoDelJugador) {
        this.tiradasRealizadasEnElTurnoDelJugador = tiradasRealizadasEnElTurnoDelJugador;
    }

    public String getIdJugadorEnTurno() {
        return idJugadorEnTurno;
    }

    public void setIdJugadorEnTurno(String idJugadorEnTurno) {
        this.idJugadorEnTurno = idJugadorEnTurno;
    }

    @Override
    public String toString() {
        return "SerializacionEstadoPartida{" + "rondaTurnosActual=" + rondaTurnosActual + ", tiradasRealizadasEnElTurnoDelJugador=" + tiradasRealizadasEnElTurnoDelJugador + ", idJugadorEnTurno=" + idJugadorEnTurno + '}';
    }

}
