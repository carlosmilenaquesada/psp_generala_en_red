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

    public void rellenarMatrizCeldas() {
        Celda[][] matriz = new Celda[this.filas][this.columnas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = new Celda(i, j);
                this.add(matriz[i][j]);
            }
        }
        this.matrizCeldas = matriz;
    }

    public Celda[][] getMatriz() {
        return matrizCeldas;
    }

    public void setValorEnMatriz(int valor, int fila, int columna) {
        this.matrizCeldas[fila][columna].setText(String.valueOf(valor));
    }

    public Celda getCelda(int fila, int columna) {
        return this.matrizCeldas[fila][columna];
    }

}
