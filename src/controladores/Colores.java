package controladores;

import java.awt.Color;
import java.util.HashMap;

public class Colores {

    public static final int FONDO_TABLAS = 0;
    public static final int MARCO_TABLAS = 1;
    public static final int CELDA_SELECCIONADA = 2;
    public static final int PREVIA_PUNTOS = 3;

    private static final HashMap<Integer, Color> COLORES = crearColores();

    public static Color getColor(int color) {
        return COLORES.get(color);

    }

    private static HashMap<Integer, Color> crearColores() {
        HashMap<Integer, Color> colores = new HashMap<>();
        colores.put(FONDO_TABLAS, new Color(232, 232, 220));
        colores.put(MARCO_TABLAS, new Color(71, 71, 71));
        colores.put(CELDA_SELECCIONADA, new Color(233, 210, 104));
        colores.put(PREVIA_PUNTOS, new Color(172, 152, 57));
        return colores;
    }
}
