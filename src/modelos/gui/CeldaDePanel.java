package modelos.gui;

import controladores.Colores;

import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelos.datos.Jugador;
import modelos.datos.PuntuacionJugador;
import modelos.flujo.ObjetoDato;
import modelos.flujo.serializaciones.SerializacionEmision;
import vistas.Main;


public class CeldaDePanel extends Celda {

    private boolean estaEnPrevioPuntos;
    private boolean esClickable;

    CeldaDePanel(int celXPos, int celYPos) {
        super(celXPos, celYPos);
        this.estaEnPrevioPuntos = false;

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                if (esTurnoJugadorLocal() && !esTurnoCero() && evt.getButton() == MouseEvent.BUTTON1 && esClickable() && getCelYPos() == 1) {

                    if (((PanelPuntos) getParent()).getId().equals("superior") && !getJugadorLocal().getPuntuacionJugador().getConseguidasSuperior().get(getCelXPos())) {
                        getJugadorLocal().getPuntuacionJugador().setConseguidaSuperior(getCelXPos(), true);
                        getJugadorLocal().getPuntuacionJugador().setPuntoSuperior(getCelXPos(), Integer.parseInt(getText()));
                        
                        if (getJugadorLocal().getPuntuacionJugador().getBonus() < 63) {
                            getJugadorLocal().getPuntuacionJugador().setBonus(getJugadorLocal().getPuntuacionJugador().getBonus() + Integer.parseInt(getText()));
                            Main.getPrincipalJFrame().getPanelBonus().getCelda(0, 1).setText(getJugadorLocal().getPuntuacionJugador().getBonus() + "/63");
                            if (getJugadorLocal().getPuntuacionJugador().getBonus() >= 63) {
                                JLabel jLabelBonus = new JLabel(getJugadorLocal().getIdentificadorJugador() + " consiguió el bonus! + 35 puntos!", JLabel.CENTER);
                                JOptionPane.showMessageDialog(Main.getPrincipalJFrame(), jLabelBonus);
                            }
                        }
                    } else {
                        if (((PanelPuntos) getParent()).getId().equals("inferior") && !getJugadorLocal().getPuntuacionJugador().getConseguidasInferior().get(getCelXPos())) {
                            getJugadorLocal().getPuntuacionJugador().setConseguidaInferior(getCelXPos(), true);
                            getJugadorLocal().getPuntuacionJugador().setPuntoInferior(getCelXPos(), Integer.parseInt(getText()));
                        }
                    }
                    
                    conexion.ConexionCliente.enviarObjeto(new ObjetoDato(
                            ObjetoDato.DATOS_PARTIDA, new SerializacionEmision(null,
                                    null, new PuntuacionJugador(
                                            new ArrayList<>(getJugadorLocal().getPuntuacionJugador().getConseguidasSuperior()),
                                            new ArrayList<>(getJugadorLocal().getPuntuacionJugador().getConseguidasInferior()),
                                            new ArrayList<>(getJugadorLocal().getPuntuacionJugador().getPuntosSuperior()),
                                            new ArrayList<>(getJugadorLocal().getPuntuacionJugador().getPuntosInferior()),
                                            getJugadorLocal().getPuntuacionJugador().getBonus()
                                    ), null, null
                            )));
                    Main.getPrincipalJFrame().limpiarColumnaDeCeldas(1);
                    Main.getPrincipalJFrame().getPanelPuntosTotales().getCelda(0, 1).setText(String.valueOf(getJugadorLocal().getPuntuacionJugador().getCalculoPuntosTotales()));
                    Main.getPrincipalJFrame().cambiarJugadorEnTurno();
                }
            }
        });
    }

    public Jugador getJugadorLocal() {
        return Main.getPrincipalJFrame().getJugadorLocal();
    }

    public void setEstaEnPrevioPuntos(boolean b) {
        if (b) {
            this.setForeground(Colores.getColor(Colores.PREVIA_PUNTOS));
        } else {
            this.setForeground(Color.BLACK);
        }
        this.estaEnPrevioPuntos = b;

    }

    public boolean estaEnPrevioPuntos() {
        return estaEnPrevioPuntos;
    }

    private boolean esTurnoJugadorLocal() {
        return Main.getPrincipalJFrame().esTurnoJugadorLocal();
    }

    private boolean esTurnoCero() {
        return Main.getPrincipalJFrame().getSerializacionEstadoPartida().getTiradasRealizadasEnElTurnoDelJugador() == 0;

    }

    public boolean esClickable() {
        return esClickable;
    }

    public void setEsClickable(boolean esClickable) {
        this.esClickable = esClickable;
    }
}
