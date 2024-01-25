package modelos.datos;

import java.io.Serializable;
import java.util.ArrayList;

public class PuntosPrevios  implements Serializable{

    private ArrayList<Integer> puntosSuperiorPrevios;
    private ArrayList<Integer> puntosInferiorPrevios;

    public PuntosPrevios() {
        this.puntosSuperiorPrevios = rellenarPuntosDefecto(0);
        this.puntosInferiorPrevios = rellenarPuntosDefecto(0);
        
    }

    public PuntosPrevios(ArrayList<Integer> puntosSuperiorPrevios, ArrayList<Integer> puntosInferiorPrevios) {
        this.puntosSuperiorPrevios = puntosSuperiorPrevios;
        this.puntosInferiorPrevios = puntosInferiorPrevios;
        
    }


    private ArrayList<Integer> rellenarPuntosDefecto(Integer valorDefecto) {
        ArrayList<Integer> arrayDefecto = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            arrayDefecto.add(valorDefecto);
        }
        return arrayDefecto;
    }

    public ArrayList<Integer> getPuntosSuperiorPrevios() {
        return puntosSuperiorPrevios;
    }

    public void setPuntosSuperiorPrevios(ArrayList<Integer> puntosSuperiorPrevios) {
        this.puntosSuperiorPrevios = puntosSuperiorPrevios;
    }

    public ArrayList<Integer> getPuntosInferiorPrevios() {
        return puntosInferiorPrevios;
    }

    public void setPuntosInferiorPrevios(ArrayList<Integer> puntosInferiorPrevios) {
        this.puntosInferiorPrevios = puntosInferiorPrevios;
    }


    
}
