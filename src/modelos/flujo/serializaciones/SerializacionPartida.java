package modelos.flujo.serializaciones;

import java.io.Serializable;
import java.util.ArrayList;
import modelos.datos.PerfilJugador;
import modelos.datos.PuntosPrevios;
import modelos.datos.PuntuacionJugador;

public class SerializacionPartida implements Serializable {

    private SerializacionDados dadosSerializados;
    private PuntosPrevios puntosPrevios;
    private PuntuacionJugador puntuacionJugador;
    private PerfilJugador perfilJugador;

    public SerializacionPartida(SerializacionDados dadosSerializados, PuntosPrevios puntosPrevios, PuntuacionJugador puntuacionJugador, PerfilJugador perfilJugador) {
        this.dadosSerializados = dadosSerializados;
        this.puntosPrevios = puntosPrevios;
        this.puntuacionJugador = puntuacionJugador;
        this.perfilJugador = perfilJugador;
    }

    public SerializacionDados getDadosSerializados() {
        return dadosSerializados;
    }

    public void setDadosSerializados(SerializacionDados dadosSerializados) {
        this.dadosSerializados = dadosSerializados;
    }

    public PuntosPrevios getPuntosPrevios() {
        return puntosPrevios;
    }

    public void setPuntosPrevios(PuntosPrevios puntosPrevios) {
        this.puntosPrevios = puntosPrevios;
    }

    public PuntuacionJugador getPuntuacionJugador() {
        return puntuacionJugador;
    }

    public void setPuntuacionJugador(PuntuacionJugador puntuacionJugador) {
        this.puntuacionJugador = puntuacionJugador;
    }

    public PerfilJugador getPerfilJugador() {
        return perfilJugador;
    }

    public void setPerfilJugador(PerfilJugador perfilJugador) {
        this.perfilJugador = perfilJugador;
    }

}
