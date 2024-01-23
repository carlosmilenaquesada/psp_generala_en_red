package modelos;

import controladores.Colores;
import controladores.Fuentes;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import vistas.PrincipalJFrame;

public class CeldaDePanel extends JLabel {

    private final int celXPos;
    private final int celYPos;

    CeldaDePanel(int celXPos, int celYPos, PanelPuntos parent) {
        this.celXPos = celXPos;
        this.celYPos = celYPos;
        this.setBounds(celYPos < 2 ? (150 * celYPos) : ((75 * celYPos) + 75), 30 * celXPos, 150 / (celYPos == 0 ? 1 : 2), 30);
        this.setVisible(true);
        this.setOpaque(true);
        this.setBackground(Colores.getColor(Colores.FONDO_TABLAS));
        this.setBorder(BorderFactory.createLineBorder(Colores.getColor(Colores.MARCO_TABLAS), 2));
        this.setFont(Fuentes.getFont(Fuentes.PUNTOS_EN_TABLA));

        if (celYPos == 0) {
            Image image = parent.getIconos()[celXPos];
            this.setIcon(new ImageIcon(image.getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
            this.setText(parent.getTextoCeldas()[celXPos]);
        }
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (getCelYPos() == 1) {

                    if (parent.getId().equals("superior") && getJugadorLocal().getConseguidasSuperior()[getCelXPos()]) {
                        getJugadorLocal().setConseguidaSuperior(getCelXPos(), true);
                        getJugadorLocal().setPuntoSuperior(getCelXPos(), Integer.parseInt(getText()));
                    } else {
                        if (parent.getId().equals("inferior") && getJugadorLocal().getConseguidasInferior()[getCelXPos()]) {
                            getJugadorLocal().setConseguidaInferior(getCelXPos(), true);
                            getJugadorLocal().setPuntoInferior(getCelXPos(), Integer.parseInt(getText()));
                        }
                    }
                    getPrincipalJFrame().getPanelPuntosSuperior().procesarPuntuacion(getJugadorLocal().getConseguidasSuperior());
                    getPrincipalJFrame().getPanelPuntosInferior().procesarPuntuacion(getJugadorLocal().getConseguidasInferior());
                }
            }
        });
    }

    public Jugador getJugadorLocal() {
        return ((PrincipalJFrame) SwingUtilities.getWindowAncestor(this)).getJugadorLocal();
    }

    public PrincipalJFrame getPrincipalJFrame() {
        return (PrincipalJFrame) SwingUtilities.getWindowAncestor(this);
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

    public int getCelXPos() {
        return celXPos;
    }

    public int getCelYPos() {
        return celYPos;
    }

}
