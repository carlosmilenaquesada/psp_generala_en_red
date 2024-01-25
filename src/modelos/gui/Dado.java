package modelos.gui;

import javax.swing.*;
import static controladores.Imagenes.imagenesDado;
import controladores.Rectangles;
import controladores.Rectangles.RectanglesDados;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import modelos.datos.DadosPartida;

public class Dado{

    public enum Valor {
        VACIO, UNO, DOS, TRES, CUATRO, CINCO, SEIS, INTERROGACION;
    }

    public enum Estado {
        EN_TAPETE, EN_RESERVA;
    }

    private Valor valor;
    private Estado estado;
    private JLabel jLabel;
    private boolean clickable;
    private RectanglesDados posicion;
    private DadosPartida dadosPartida;

    public Dado(JLabel jLabel, RectanglesDados posicion, DadosPartida dadosPartida) {
        this.jLabel = jLabel;
        this.posicion = posicion;
        this.dadosPartida = dadosPartida;
        this.jLabel.setBounds(Rectangles.rectanglesDados.get(this.posicion));
        this.valor = Valor.SEIS;
        this.estado = Estado.EN_TAPETE;
        this.jLabel.setIcon(imagenesDado.get(this.valor));
        this.clickable = true;
        this.jLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON1 && isClickable()) {

                    if (getEstado().equals(Estado.EN_TAPETE)) {
                        setEstado(Estado.EN_RESERVA);
                        getDadosPartida().desocuparPosicionTapete(getPosicion());
                        setPosicion(getDadosPartida().primeraPosicionLibreReserva());
                        getDadosPartida().ocuparPosicionReserva(getPosicion());
                        cambiarPosicion(Rectangles.rectanglesDados.get(getPosicion()));

                    } else {
                        setEstado(Estado.EN_TAPETE);
                        getDadosPartida().desocuparPosicionReserva(getPosicion());
                        setPosicion(getDadosPartida().primeraPosionLibreTapete());
                        getDadosPartida().ocuparPosicionTapete(getPosicion());
                        cambiarPosicion(Rectangles.rectanglesDados.get(getPosicion()));
                    }

                }
            }
        });
    }

    public DadosPartida getDadosPartida() {
        return dadosPartida;
    }

    public void setDadosPartida(DadosPartida dadosPartida) {
        this.dadosPartida = dadosPartida;
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    public JLabel getjLabel() {
        return jLabel;
    }

    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void cambiarPosicion(Rectangle nuevaPosicion) {
        this.jLabel.setBounds(nuevaPosicion);
    }

    public RectanglesDados getPosicion() {
        return posicion;
    }

    public void setPosicion(RectanglesDados posicion) {
        this.posicion = posicion;
    }
}
