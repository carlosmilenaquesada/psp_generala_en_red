package controladores;

import java.awt.Font;
import java.util.HashMap;

public class Fuentes {

    public static final int PUNTOS_EN_TABLA = 0;

    private static final HashMap<Integer, Font> FUENTES = crearFuentes();

    public static Font getFont(int font) {
        return FUENTES.get(font);

    }

    private static HashMap<Integer, Font> crearFuentes() {
        HashMap<Integer, Font> fuentes = new HashMap<>();
        fuentes.put(PUNTOS_EN_TABLA, new Font("Helvetica", Font.BOLD, 18));
        return fuentes;
    }
}
