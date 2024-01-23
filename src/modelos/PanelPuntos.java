package modelos;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.*;
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
    protected void rellenarMatrizCeldas(int filas, int columnas) {
        CeldaDePanel[][] matriz = new CeldaDePanel[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = new CeldaDePanel(i, j, this);
                this.add(matriz[i][j]);
            }
        }
        this.matrizCeldas = matriz;
    }

    public void procesarPuntuacion(boolean[] coleccionConseguidas) {
        for (int i = 0; i < coleccionConseguidas.length; i++) {
            this.getCelda(i, 1).setEstaEnSeleccion(false);
            this.getCelda(i, 1).setEstaEnPrevioPuntos(false);
            if (coleccionConseguidas[i] == false) {
                this.getCelda(i, 1).setText("");
            }
        }
    }

    public Jugador getJugadorLocal() {
        return ((PrincipalJFrame) SwingUtilities.getWindowAncestor(this)).getJugadorLocal();
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

    public CeldaDePanel[][] getMatriz() {
        return matriz;
    }

    public void setValorEnMatriz(int valor, int fila, int columna) {
        this.matriz[fila][columna].setText(String.valueOf(valor));
    }

    public CeldaDePanel getCelda(int fila, int columna) {
        return this.matriz[fila][columna];
    }

    public void setMatriz(CeldaDePanel[][] matriz) {
        this.matriz = matriz;
    }

    public String[] getTextoCeldas() {
        return textoCeldas;
    }

    public void setTextoCeldas(String[] textoCeldas) {
        this.textoCeldas = textoCeldas;
    }

}
