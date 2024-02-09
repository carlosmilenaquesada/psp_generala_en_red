package modelos.datos;

import java.io.Serializable;
import java.util.ArrayList;

public class CalculosJugadorLocal {

    public static PuntosPrevios calcularPuntosPreviosJugadorLocal(Jugador jugadorLocal, DadosPartida dadosPartida) {
        PuntosPrevios puntosPrevios = new PuntosPrevios();
        for (int i = 0; i < dadosPartida.getDados().size(); i++) {
            //Categorías superior (suma de los puntos de los dados, agrapados por número) 
            int ordinal = dadosPartida.getDados().get(i).getValor().ordinal();//el ordinal es el valor del dado
            //conseguidasSuperior es una colección de boolean que nos dice si una categoría ya ha puntuado o no
            if (!jugadorLocal.getPuntuacionJugador().getConseguidasSuperior().get(ordinal - 1)) {
                puntosPrevios.getPuntosSuperiorPrevios().set(ordinal - 1, puntosPrevios.getPuntosSuperiorPrevios().get(ordinal - 1) + ordinal);
            }
        }

        //Póker (la suma de los puntos de al menos cuatro dados iguales)
        int[] auxFrecuenciaNumeros = new int[6];
        for (int i = 0; i < dadosPartida.getDados().size(); i++) {
            int ordinal = dadosPartida.getDados().get(i).getValor().ordinal();
            auxFrecuenciaNumeros[ordinal - 1]++;

            //Categoría libre (la suma de todos los puntos, de cualquier de dados)
            if (!jugadorLocal.getPuntuacionJugador().getConseguidasInferior().get(0)) {
                puntosPrevios.getPuntosInferiorPrevios().set(0, puntosPrevios.getPuntosInferiorPrevios().get(0) + ordinal);
            }
        }
        for (int i = 0; i < auxFrecuenciaNumeros.length; i++) {
            if (auxFrecuenciaNumeros[i] >= 4) {
                puntosPrevios.getPuntosInferiorPrevios().set(1, 4 * (i + 1));

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
            puntosPrevios.getPuntosInferiorPrevios().set(2, pareja + trio);
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
            puntosPrevios.getPuntosInferiorPrevios().set(3, 15);
        }
        //escalera larga (una fila de cinco números sucesivos)
        if (contadorSucesivos == 5) {
            puntosPrevios.getPuntosInferiorPrevios().set(4, 30);
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
            puntosPrevios.getPuntosInferiorPrevios().set(5, 50);
        }
        return puntosPrevios;
    }
}
