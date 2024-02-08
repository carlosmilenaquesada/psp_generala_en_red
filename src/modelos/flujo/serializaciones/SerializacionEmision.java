package modelos.flujo.serializaciones;

import java.io.Serializable;

import modelos.datos.PerfilJugador;
import modelos.datos.PuntosPrevios;
import modelos.datos.PuntuacionJugador;

public class SerializacionEmision implements Serializable {

    private SerializacionDados dadosSerializados;
    private PuntosPrevios puntosPrevios;
    private PuntuacionJugador puntuacionJugador;
    private PerfilJugador perfilJugador;
    private SerializacionEstadoPartida serializacionEstadoPartida;

    public SerializacionEmision(SerializacionDados dadosSerializados, PuntosPrevios puntosPrevios, PuntuacionJugador puntuacionJugador, PerfilJugador perfilJugador, SerializacionEstadoPartida serializacionEstadoPartida) {
        this.dadosSerializados = dadosSerializados;
        this.puntosPrevios = puntosPrevios;
        this.puntuacionJugador = puntuacionJugador;
        this.perfilJugador = perfilJugador;
        this.serializacionEstadoPartida = serializacionEstadoPartida;
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

    public SerializacionEstadoPartida getSerializacionEstadoPartida() {
        return serializacionEstadoPartida;
    }

    public void setSerializacionEstadoPartida(SerializacionEstadoPartida serializacionEstadoPartida) {
        this.serializacionEstadoPartida = serializacionEstadoPartida;
    }


}
