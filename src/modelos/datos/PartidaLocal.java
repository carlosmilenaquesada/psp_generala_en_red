package modelos.datos;

import java.io.Serializable;
import java.util.ArrayList;

public class PartidaLocal  implements Serializable{

    private Jugador jugadorLocal;
    private Jugador jugadorRemoto;
    private DadosPartida dadosPartida;

    public PartidaLocal(Jugador jugadorLocal, Jugador jugadorRemoto, DadosPartida dadosPartida) {
        this.jugadorLocal = jugadorLocal;
        this.jugadorRemoto = jugadorRemoto;
        this.dadosPartida = dadosPartida;
    }

    public PuntosPrevios getPuntosPreviosJugadorLocal() {
        PuntosPrevios puntosPrevios = new PuntosPrevios();
        calcularPuntosSuperiorPreviosJugadorLocal(puntosPrevios.getPuntosSuperiorPrevios());
        calcularPuntosInferiorPreviosJugadorLocal(puntosPrevios.getPuntosInferiorPrevios());
        return puntosPrevios;
    }

    private void calcularPuntosSuperiorPreviosJugadorLocal(ArrayList<Integer> puntosSuperiorPrevios) {

        for (int i = 0; i < dadosPartida.getDados().size(); i++) {
            //Categorías superior (suma de los puntos de los dados, agrapados por número) 
            int ordinal = dadosPartida.getDados().get(i).getValor().ordinal();//el ordinal es el valor del dado
            //conseguidasSuperior es una colección de boolean que nos dice si una categoría ya ha puntuado o no
            if (!jugadorLocal.getPuntuacionJugador().getConseguidasSuperior().get(ordinal - 1)) {
                puntosSuperiorPrevios.set(ordinal - 1, puntosSuperiorPrevios.get(ordinal - 1) + ordinal);
            }
        }
    }

    private void calcularPuntosInferiorPreviosJugadorLocal(ArrayList<Integer> puntosInferiorPrevios) {

        //Póker (la suma de los puntos de al menos cuatro dados iguales)
        int[] auxFrecuenciaNumeros = new int[6];
        for (int i = 0; i < dadosPartida.getDados().size(); i++) {
            int ordinal = dadosPartida.getDados().get(i).getValor().ordinal();
            auxFrecuenciaNumeros[ordinal - 1]++;

            //Categoría libre (la suma de todos los puntos, de cualquier de dados)
            if (!jugadorLocal.getPuntuacionJugador().getConseguidasInferior().get(0)) {
                puntosInferiorPrevios.set(0, puntosInferiorPrevios.get(0) + ordinal);
            }
        }
        for (int i = 0; i < auxFrecuenciaNumeros.length; i++) {
            if (auxFrecuenciaNumeros[i] >= 4) {
                puntosInferiorPrevios.set(1, 4 * (i + 1));

            }
        }
        //Full (la suma de los puntos de una pareja de dados de igual número + un trio de dados igual número)
        auxFrecuenciaNumeros = new int[6];
        for (int i = 0; i < dadosPartida.getDados().size(); i++) {
            int ordinal = dadosPartida.getDados().get(i).getValor().ordinal();
            auxFrecuenciaNumeros[ordinal - 1]++;
        }
        int pareja = 0;
        int trio = 0;
        for (int i = 0; i < auxFrecuenciaNumeros.length; i++) {
            if (auxFrecuenciaNumeros[i] == 2) {
                pareja = 2 * (i + 1);
            }
            if (auxFrecuenciaNumeros[i] == 3) {
                trio = 3 * (i + 1);
            }
        }
        if (pareja > 0 && trio > 0) {
            puntosInferiorPrevios.set(2, pareja + trio);
        }

        //escalera corta (una fila de al menos cuatro números sucesivos)
        auxFrecuenciaNumeros = new int[6];
        for (int i = 0; i < dadosPartida.getDados().size(); i++) {
            int ordinal = dadosPartida.getDados().get(i).getValor().ordinal();
            auxFrecuenciaNumeros[ordinal - 1]++;
        }

        int contadorSucesivos = 0;
        for (int i = 0; i < auxFrecuenciaNumeros.length; i++) {
            if (auxFrecuenciaNumeros[i] >= 1) {
                contadorSucesivos++;
            } else {
                if (contadorSucesivos < 4) {
                    contadorSucesivos = 0;
                }
            }
        }
        if (contadorSucesivos >= 4) {
            puntosInferiorPrevios.set(3, 15);
        }
        //escalera larga (una fila de cinco números sucesivos)
        if (contadorSucesivos == 5) {
            puntosInferiorPrevios.set(4, 30);
        }

        //generala (cinco números iguales)
        boolean sonIguales = true;
        int ordinal = dadosPartida.getDados().get(0).getValor().ordinal();
        for (int i = 1; i < dadosPartida.getDados().size() && sonIguales; i++) {
            if (ordinal != dadosPartida.getDados().get(i).getValor().ordinal()) {
                sonIguales = false;
            }
        }

        if (sonIguales) {
            puntosInferiorPrevios.set(5, 50);
        }

    }

}
