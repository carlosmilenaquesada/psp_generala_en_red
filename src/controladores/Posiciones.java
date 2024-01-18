package controladores;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;

public class Posiciones {

    public enum Posicion {
        PRIMERA, SEGUNDA, TERCERA, CUARTA, QUINTA,
        

    }
    public static final HashMap<Posicion, Rectangle> posicionesDados = crearPosiciones();

    private static final Dimension dimensionDado = new Dimension(60, 60);

    private static final HashMap<Posicion, Rectangle> crearPosiciones() {
        HashMap<Posicion, Rectangle> posiciones = new HashMap<>();
        posiciones.put(Posicion.PRIMERA, new Rectangle(new Point(0, 0), dimensionDado));
        posiciones.put(Posicion.SEGUNDA, new Rectangle(new Point(0, 0), dimensionDado));
        posiciones.put(Posicion.TERCERA, new Rectangle(new Point(0, 0), dimensionDado));
        posiciones.put(Posicion.CUARTA, new Rectangle(new Point(0, 0), dimensionDado));
        posiciones.put(Posicion.QUINTA, new Rectangle(new Point(0, 0), dimensionDado));

        return posiciones;

    }
}
