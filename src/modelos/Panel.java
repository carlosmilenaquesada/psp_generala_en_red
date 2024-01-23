package modelos;

import controladores.Colores;
import java.awt.Rectangle;
import javax.swing.*;

public class Panel extends JPanel {

    protected String[] textoCeldas;
    protected int filas;
    protected int columnas;
    protected Celda[][] matrizCeldas;

    public Panel(String[] textoCeldas, Rectangle rectangle, int filas, int columnas) {
        this.textoCeldas = textoCeldas;
        this.filas = filas;
        this.columnas = columnas;
        this.setLayout(null);
        this.setBounds(rectangle);
        this.setVisible(true);
        this.setBackground(Colores.getColor(Colores.FONDO_TABLAS));
        this.matrizCeldas = null;
    }

    protected void rellenarMatrizCeldas(int filas, int columnas) {
        Celda[][] matriz = new Celda[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = new Celda(i, j);
                this.add(matriz[i][j]);
            }
        }
        this.matrizCeldas = matriz;
    }

}
