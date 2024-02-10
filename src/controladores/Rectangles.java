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
        rectangles.put(RectanglesDados.PRIMERA_RES, new Rectangle(70, 25, 40, 40));
        rectangles.put(RectanglesDados.SEGUNDA_RES, new Rectangle(125, 25, 40, 40));
        rectangles.put(RectanglesDados.TERCERA_RES, new Rectangle(180, 25, 40, 40));
        rectangles.put(RectanglesDados.CUARTA_RES, new Rectangle(235, 25, 40, 40));
        rectangles.put(RectanglesDados.QUINTA_RES, new Rectangle(290, 25, 40, 40));
        rectangles.put(RectanglesDados.PRIMERA_TAP, new Rectangle(100, 110, 40, 40));
        rectangles.put(RectanglesDados.SEGUNDA_TAP, new Rectangle(100, 270, 40, 40));
        rectangles.put(RectanglesDados.TERCERA_TAP, new Rectangle(180, 190, 40, 40));
        rectangles.put(RectanglesDados.CUARTA_TAP, new Rectangle(260, 110, 40, 40));
        rectangles.put(RectanglesDados.QUINTA_TAP, new Rectangle(260, 270, 40, 40));

        return rectangles;
    }

    public enum RectanglesElementos {
        PANEL_CAT_SUPERIOR, PANEL_CAT_INFERIOR, PANEL_CAT_BONUS, PANEL_CAT_TOTALES;
    }
    public static final HashMap<RectanglesElementos, Rectangle> rectanglesElementos = rectanglesElementos();

    private static HashMap<RectanglesElementos, Rectangle> rectanglesElementos() {
        HashMap<RectanglesElementos, Rectangle> rectangles = new HashMap<>();
        rectangles.put(RectanglesElementos.PANEL_CAT_SUPERIOR, new Rectangle(20, 130, 300, 180));
        rectangles.put(RectanglesElementos.PANEL_CAT_BONUS, new Rectangle(20, 310, 300, 30));
        rectangles.put(RectanglesElementos.PANEL_CAT_INFERIOR, new Rectangle(20, 370, 300, 180));
        rectangles.put(RectanglesElementos.PANEL_CAT_TOTALES, new Rectangle(20, 560, 300, 30));
        return rectangles;
    }

}
