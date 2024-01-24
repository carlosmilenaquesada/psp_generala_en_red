package modelos;

import controladores.Colores;
import controladores.Fuentes;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Celda extends JLabel {

    protected final int celXPos;
    protected final int celYPos;

    public Celda(int celXPos, int celYPos) {
        this.celXPos = celXPos;
        this.celYPos = celYPos;
        this.setBounds(celYPos < 2 ? (150 * celYPos) : ((75 * celYPos) + 75), 30 * celXPos, 150 / (celYPos == 0 ? 1 : 2), 30);
        this.setVisible(true);
        this.setOpaque(true);
        this.setBackground(Colores.getColor(Colores.FONDO_TABLAS));
        this.setBorder(BorderFactory.createLineBorder(Colores.getColor(Colores.MARCO_TABLAS), 2));
        this.setFont(Fuentes.getFont(Fuentes.PUNTOS_EN_TABLA));
    }

    public int getCelXPos() {
        return celXPos;
    }

    public int getCelYPos() {
        return celYPos;
    }

}
