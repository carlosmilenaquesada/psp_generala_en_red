package controladores;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.HashMap;

public class Rectangles {

    public enum RectanglesDados {
        PRIMERA_RES, SEGUNDA_RES, TERCERA_RES, CUARTA_RES, QUINTA_RES,
        PRIMERA_TAP, SEGUNDA_TAP, TERCERA_TAP, CUARTA_TAP, QUINTA_TAP;
    }
    public static final HashMap<RectanglesDados, Rectangle> rectanglesDados = rectanglesDados();

    private static HashMap<RectanglesDados, Rectangle> rectanglesDados() {
        HashMap<RectanglesDados, Rectangle> rectangles = new HashMap<>();
        rectangles.put(RectanglesDados.PRIMERA_RES, new Rectangle(0, 0, 60, 60));
        rectangles.put(RectanglesDados.SEGUNDA_RES, new Rectangle(65, 0, 60, 60));
        rectangles.put(RectanglesDados.TERCERA_RES, new Rectangle(130, 0, 60, 60));
        rectangles.put(RectanglesDados.CUARTA_RES, new Rectangle(195, 0, 60, 60));
        rectangles.put(RectanglesDados.QUINTA_RES, new Rectangle(260, 0, 60, 60));
        rectangles.put(RectanglesDados.PRIMERA_TAP, new Rectangle(0, 200, 60, 60));
        rectangles.put(RectanglesDados.SEGUNDA_TAP, new Rectangle(65, 200, 60, 60));
        rectangles.put(RectanglesDados.TERCERA_TAP, new Rectangle(130, 200, 60, 60));
        rectangles.put(RectanglesDados.CUARTA_TAP, new Rectangle(195, 200, 60, 60));
        rectangles.put(RectanglesDados.QUINTA_TAP, new Rectangle(260, 200, 60, 60));

        return rectangles;
    }

    public enum RectanglesElementos {
        PANEL_CAT_SUPERIOR, PANEL_CAT_INFERIOR, PANEL_CAT_BONUS;
    }
    public static final HashMap<RectanglesElementos, Rectangle> rectanglesElementos = rectanglesElementos();

    private static HashMap<RectanglesElementos, Rectangle> rectanglesElementos() {
        HashMap<RectanglesElementos, Rectangle> rectangles = new HashMap<>();
        rectangles.put(RectanglesElementos.PANEL_CAT_SUPERIOR, new Rectangle(20, 130, 300, 180));
        rectangles.put(RectanglesElementos.PANEL_CAT_BONUS, new Rectangle(20, 310, 300, 30));
        rectangles.put(RectanglesElementos.PANEL_CAT_INFERIOR, new Rectangle(20, 370, 300, 180));

        return rectangles;
    }

}
