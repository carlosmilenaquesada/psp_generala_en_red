package modelos;

import controladores.Colores;
import controladores.Fuentes;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import vistas.PrincipalJFrame;

public class PanelPuntos extends JPanel {

    public static class CeldaLabel extends JLabel {

        CeldaLabel(int celYPos, int celXPos, PanelPuntos parent) {
            this.setBounds(celXPos < 2 ? (150 * celXPos) : ((75 * celXPos) + 75), 30 * celYPos, 150 / (celXPos == 0 ? 1 : 2), 30);
            this.setVisible(true);
            this.setOpaque(true);
            this.setBackground(Colores.getColor(Colores.FONDO_TABLAS));
            this.setBorder(BorderFactory.createLineBorder(Colores.getColor(Colores.MARCO_TABLAS), 2));
            this.setFont(Fuentes.getFont(Fuentes.PUNTOS_EN_TABLA));

            if (celXPos == 0) {
                Image image = parent.getIconos()[celYPos];
                this.setIcon(new ImageIcon(image.getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
                this.setText(parent.getTextoCeldas()[celYPos]);
            }
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (parent.getId().equals("superior")) {
                        parent.getPrincipalJFrame().getConseguidasSuperior();
                        HASTA AQUí
                    } else {
                        if (parent.getId().equals("inferior")) {
                            System.out.println("inferior");
                        }
                    }

                }
            });

        }

        public void estaEnSeleccion(boolean b) {
            if (b) {
                this.setBackground(Colores.getColor(Colores.CELDA_SELECCIONADA));
            } else {
                this.setBackground(Colores.getColor(Colores.FONDO_TABLAS));
            }
        }

        public void estaEnPrevioPuntos(boolean b) {
            if (b) {
                this.setForeground(Colores.getColor(Colores.PREVIA_PUNTOS));
            } else {
                this.setForeground(Color.BLACK);
            }

        }

    }
    private String[] textoCeldas;
    private CeldaLabel[][] matriz;
    private Image[] iconos;
    private final String id;

    public PanelPuntos(String[] textoCeldas, Image[] iconos, Rectangle rectangle, int filas, int columnas, String id) {
        this.id = id;
        this.textoCeldas = textoCeldas;
        this.iconos = iconos;
        this.setLayout(null);
        this.setBounds(rectangle);
        this.setVisible(true);
        this.setBackground(Colores.getColor(Colores.FONDO_TABLAS));
        this.matriz = new CeldaLabel[filas][columnas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = new CeldaLabel(i, j, this);
                this.add(matriz[i][j]);
            }
        }
    }

    public String getId() {
        return id;
    }

    public PrincipalJFrame getPrincipalJFrame() {
        return ((PrincipalJFrame) SwingUtilities.getWindowAncestor(this));
    }

    public Image[] getIconos() {
        return iconos;
    }

    public void setIconos(Image[] iconos) {
        this.iconos = iconos;
    }

    public CeldaLabel[][] getMatriz() {
        return matriz;
    }

    public void setValorEnMatriz(int valor, int fila, int columna) {
        this.matriz[fila][columna].setText(String.valueOf(valor));
    }

    public CeldaLabel getCelda(int fila, int columna) {
        return this.matriz[fila][columna];
    }

    public void setMatriz(CeldaLabel[][] matriz) {
        this.matriz = matriz;
    }

    public String[] getTextoCeldas() {
        return textoCeldas;
    }

    public void setTextoCeldas(String[] textoCeldas) {
        this.textoCeldas = textoCeldas;
    }

}
