package modelos.flujo.serializaciones;

import java.io.Serializable;
import java.util.ArrayList;

public class SerializacionDados implements Serializable {

    private ArrayList<Integer> indexRectanglesEnumDados;
    private ArrayList<Integer> indexValorEnumDados;

    public SerializacionDados(ArrayList<Integer> indexRectanglesEnumDados, ArrayList<Integer> indexValorEnumDados) {
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
