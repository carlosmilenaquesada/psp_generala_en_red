package controladores;

import java.awt.Rectangle;
import java.util.HashMap;

public class Posiciones {

    public enum Posicion {
        PRIMERA_RES, SEGUNDA_RES, TERCERA_RES, CUARTA_RES, QUINTA_RES,
        PRIMERA_TAP, SEGUNDA_TAP, TERCERA_TAP, CUARTA_TAP, QUINTA_TAP;
    }
    public static final HashMap<Posicion, Rectangle> posicionesDados = Reserva();

    private static final HashMap<Posicion, Rectangle> Reserva() {
        HashMap<Posicion, Rectangle> posiciones = new HashMap<>();
        posiciones.put(Posicion.PRIMERA_RES, new Rectangle(0, 0, 60, 60));
        posiciones.put(Posicion.SEGUNDA_RES, new Rectangle(65, 0, 60, 60));
        posiciones.put(Posicion.TERCERA_RES, new Rectangle(130, 0, 60, 60));
        posiciones.put(Posicion.CUARTA_RES, new Rectangle(195, 0, 60, 60));
        posiciones.put(Posicion.QUINTA_RES, new Rectangle(260, 0, 60, 60));
        posiciones.put(Posicion.PRIMERA_TAP, new Rectangle(0, 200, 60, 60));
        posiciones.put(Posicion.SEGUNDA_TAP, new Rectangle(65, 200, 60, 60));
        posiciones.put(Posicion.TERCERA_TAP, new Rectangle(130, 200, 60, 60));
        posiciones.put(Posicion.CUARTA_TAP, new Rectangle(195, 200, 60, 60));
        posiciones.put(Posicion.QUINTA_TAP, new Rectangle(260, 200, 60, 60));

        return posiciones;

    }
}
