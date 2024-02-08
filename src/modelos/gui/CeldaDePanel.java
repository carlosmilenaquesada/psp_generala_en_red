package modelos.gui;

import controladores.Colores;

import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import modelos.datos.Jugador;
import modelos.datos.PuntuacionJugador;
import modelos.flujo.ObjetoDato;
import modelos.flujo.serializaciones.SerializacionEmision;
import vistas.Main;

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
                    if (((PanelPuntos) getParent()).getId().equals("superior") && !getJugadorLocal().getPuntuacionJugador().getConseguidasSuperior().get(getCelXPos())) {
                        getJugadorLocal().getPuntuacionJugador().setConseguidaSuperior(getCelXPos(), true);
                        getJugadorLocal().getPuntuacionJugador().setPuntoSuperior(getCelXPos(), Integer.parseInt(getText()));

                    } else {
                        if (((PanelPuntos) getParent()).getId().equals("inferior") && !getJugadorLocal().getPuntuacionJugador().getConseguidasInferior().get(getCelXPos())) {
                            getJugadorLocal().getPuntuacionJugador().setConseguidaInferior(getCelXPos(), true);
                            getJugadorLocal().getPuntuacionJugador().setPuntoInferior(getCelXPos(), Integer.parseInt(getText()));
                        }
                    }

                    conexion.ConexionCliente.objetoDato = new ObjetoDato(
                            ObjetoDato.DATOS_PARTIDA, new SerializacionEmision(null,
                                    null, new PuntuacionJugador(
                                            new ArrayList<>(getJugadorLocal().getPuntuacionJugador().getConseguidasSuperior()),
                                            new ArrayList<>(getJugadorLocal().getPuntuacionJugador().getConseguidasInferior()),
                                            new ArrayList<>(getJugadorLocal().getPuntuacionJugador().getPuntosSuperior()),
                                            new ArrayList<>(getJugadorLocal().getPuntuacionJugador().getPuntosInferior()),
                                            getJugadorLocal().getPuntuacionJugador().getBonus()
                                    ), null, null
                            ));
                    Main.getPrincipalJFrame().limpiarColumnaDeCeldas(1);

                }
            }
        });
    }

    public Jugador getJugadorLocal() {
        return Main.getPrincipalJFrame().getJugadorLocal();
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
