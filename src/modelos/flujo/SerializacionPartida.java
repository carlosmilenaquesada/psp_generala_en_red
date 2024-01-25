package modelos.flujo;

import java.io.Serializable;
import java.util.ArrayList;

public class SerializacionPartida implements Serializable {

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

    public SerializacionPartida(DadosSerializados dadosSerializados) {
        this.dadosSerializados = dadosSerializados;
    }

    public DadosSerializados getDadosSerializados() {
        return dadosSerializados;
    }

    public void setDadosSerializados(DadosSerializados dadosSerializados) {
        this.dadosSerializados = dadosSerializados;
    }

    @Override
    public String toString() {
        return "SerializacionPartida{" + "dadosSerializados=" + dadosSerializados + '}';
    }

}
