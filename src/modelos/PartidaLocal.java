package modelos;

public class PartidaLocal {    
    private Jugador jugadorLocal;
    private Dado[] dados;

    public PartidaLocal(Jugador jugadorLocal, Dado[] dados) {
        this.jugadorLocal = jugadorLocal;
        this.dados = dados;
    }

    

    public int[] getPuntosSuperiorPrevios() {
        int[] puntosSuperiorPrevios = new int[6];
        for (int i = 0; i < dados.length; i++) {
            //Categorías superior (suma de los puntos de los dados, agrapados por número) 
            int ordinal = dados[i].getValor().ordinal();//el ordinal es el valor del dado
            //conseguidasSuperior es una colección de boolean que nos dice si una categoría ya ha puntuado o no
            if (!jugadorLocal.getConseguidasSuperior()[ordinal - 1]) {
                puntosSuperiorPrevios[ordinal - 1] += ordinal;
            }
        }
        return puntosSuperiorPrevios;
    }

    public int[] getPuntosInferiorPrevios() {
        int[] puntosInferiorPrevios = new int[6];
        //Póker (la suma de los puntos de al menos cuatro dados iguales)
        int[] auxFrecuenciaNumeros = new int[6];
        for (int i = 0; i < dados.length; i++) {
            int ordinal = dados[i].getValor().ordinal();
            auxFrecuenciaNumeros[ordinal - 1]++;

            //Categoría libre (la suma de todos los puntos, de cualquier de dados)
            if (!jugadorLocal.getConseguidasInferior()[0]) {
                puntosInferiorPrevios[0] += ordinal;
            }
        }
        for (int i = 0; i < auxFrecuenciaNumeros.length; i++) {
            if (auxFrecuenciaNumeros[i] >= 4) {
                puntosInferiorPrevios[1] = 4 * (i + 1);

            }
        }
        //Full (la suma de los puntos de una pareja de dados de igual número + un trio de dados igual número)
        auxFrecuenciaNumeros = new int[6];
        for (int i = 0; i < dados.length; i++) {
            int ordinal = dados[i].getValor().ordinal();
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
            puntosInferiorPrevios[2] = pareja + trio;
        }

        //escalera corta (una fila de al menos cuatro números sucesivos)
        auxFrecuenciaNumeros = new int[6];
        for (int i = 0; i < dados.length; i++) {
            int ordinal = dados[i].getValor().ordinal();
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
            puntosInferiorPrevios[3] = 15;
        }
        //escalera larga (una fila de cinco números sucesivos)
        if (contadorSucesivos == 5) {
            puntosInferiorPrevios[4] = 30;
        }

        //generala (cinco números iguales)
        boolean sonIguales = true;
        int ordinal = dados[0].getValor().ordinal();
        for (int i = 1; i < dados.length && sonIguales; i++) {
            if (ordinal != dados[i].getValor().ordinal()) {
                sonIguales = false;
            }
        }

        if (sonIguales) {
            puntosInferiorPrevios[5] = 50;
        }
        return puntosInferiorPrevios;
    }

}
