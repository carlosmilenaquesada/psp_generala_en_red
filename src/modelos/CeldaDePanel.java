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

public class CeldaDePanel extends Celda {

    private boolean estaEnSeleccion;
    private boolean estaEnPrevioPuntos;

    CeldaDePanel(int celXPos, int celYPos) {
        super(celXPos, celYPos);
        this.estaEnSeleccion = false;
        this.estaEnPrevioPuntos = false;
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (getCelYPos() == 1) {
                    if (((PanelPuntos)getParent()).getId().equals("superior") && !getJugadorLocal().getConseguidasSuperior()[getCelXPos()]) {
                        getJugadorLocal().setConseguidaSuperior(getCelXPos(), true);
                        getJugadorLocal().setPuntoSuperior(getCelXPos(), Integer.parseInt(getText()));
                    } else {
                        if (((PanelPuntos)getParent()).getId().equals("inferior") && !getJugadorLocal().getConseguidasInferior()[getCelXPos()]) {
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
    

    public void setEstaEnSeleccion(boolean b) {
        if (b) {
            this.setBackground(Colores.getColor(Colores.CELDA_SELECCIONADA));
        } else {
            this.setBackground(Colores.getColor(Colores.FONDO_TABLAS));
        }
        this.estaEnSeleccion = b;
    }

    public void setEstaEnPrevioPuntos(boolean b) {
        if (b) {
            this.setForeground(Colores.getColor(Colores.PREVIA_PUNTOS));
        } else {
            this.setForeground(Color.BLACK);
        }
        this.estaEnPrevioPuntos = b;

    }

    public boolean estaEnSeleccion() {
        return estaEnSeleccion;
    }

    public boolean estaEnPrevioPuntos() {
        return estaEnPrevioPuntos;
    }

}
