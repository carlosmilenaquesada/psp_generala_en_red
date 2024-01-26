package modelos.flujo;

import java.io.Serializable;
import java.util.ArrayList;
import modelos.datos.PuntosPrevios;
import modelos.datos.PuntuacionJugador;

public class SerializacionPartida implements Serializable {

    //SERIALIZACION DE DADOS----------------------------------------------------
    public static class DadosSerializados implements Serializable {

        private ArrayList<Integer> indexRectanglesEnumDados;
        private ArrayList<Integer> indexValorEnumDados;

        public DadosSerializados(ArrayList<Integer> indexRectanglesEnumDados, ArrayList<Integer> indexValorEnumDados) {
            this.indexRectanglesEnumDados = indexRectanglesEnumDados;
            this.indexValorEnumDados = indexValorEnumDados;
        }

        public ArrayList<Integer> getIndexRectanglesEnumDados() {
            return indexRectanglesEnumDados;
        }

        public void setIndexRectanglesEnumDados(ArrayList<Integer> indexRectanglesEnumDados) {
            this.indexRectanglesEnumDados = indexRectanglesEnumDados;
        }

        public ArrayList<Integer> getIndexValorEnumDados() {
            return indexValorEnumDados;
        }

        public void setIndexValorEnumDados(ArrayList<Integer> indexValorEnumDados) {
            this.indexValorEnumDados = indexValorEnumDados;
        }

        @Override
        public String toString() {
            return "Dados{" + "indexRectanglesEnumDados=" + indexRectanglesEnumDados + ", indexValorEnumDados=" + indexValorEnumDados + '}';
        }

    }
    private DadosSerializados dadosSerializados;

    private PuntosPrevios puntosPrevios;

    private PuntuacionJugador puntuacionJugador;

    public SerializacionPartida(DadosSerializados dadosSerializados, PuntosPrevios puntosPrevios, PuntuacionJugador puntuacionJugador) {
        this.dadosSerializados = dadosSerializados;
        this.puntosPrevios = puntosPrevios;
        this.puntuacionJugador = puntuacionJugador;
    }

    public DadosSerializados getDadosSerializados() {
        return dadosSerializados;
    }

    public void setDadosSerializados(DadosSerializados dadosSerializados) {
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

}
