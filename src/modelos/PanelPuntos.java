package modelos;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.*;
import vistas.Main;
import vistas.PrincipalJFrame;

public class PanelPuntos extends Panel {

    private Image[] iconos;
    private final String id;

    public PanelPuntos(String[] textoCeldas, Rectangle rectangle, Image[] iconos, int filas, int columnas, String id) {
        super(textoCeldas, rectangle, filas, columnas);
        this.id = id;
        this.iconos = iconos;
    }

    @Override
    public void rellenarMatrizCeldas() {
        CeldaDePanel[][] matriz = new CeldaDePanel[this.filas][this.columnas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = new CeldaDePanel(i, j);
                this.add(matriz[i][j]);
                if (j == 0) {
                    Image image = this.getIconos()[i];
                    matriz[i][j].setIcon(new ImageIcon(image.getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
                    matriz[i][j].setText(this.getTextoCeldas()[i]);
                }
            }
        }
        this.matrizCeldas = matriz;
    }

    public void procesarPuntuacion(boolean[] coleccionConseguidas) {
        for (int i = 0; i < coleccionConseguidas.length; i++) {
            ((CeldaDePanel) this.getCelda(i, 1)).setEstaEnSeleccion(false);
            ((CeldaDePanel) this.getCelda(i, 1)).setEstaEnPrevioPuntos(false);
            if (coleccionConseguidas[i] == false) {
                this.getCelda(i, 1).setText("");
            }
        }
    }

    public Jugador getJugadorLocal() {
        return Main.getPrincipalJFrame().getJugadorLocal();
    }

    public String getId() {
        return id;
    }

    public Image[] getIconos() {
        return iconos;
    }

    public void setIconos(Image[] iconos) {
        this.iconos = iconos;
    }

}
