package modelos;

import javax.swing.*;
import static controladores.Imagenes.imagenesDado;
import controladores.Posiciones;
import controladores.Posiciones.Posicion;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import vistas.PrincipalJFrame;

public class Dado {

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public enum Valor {
        VACIO, UNO, DOS, TRES, CUATRO, CINCO, SEIS, INTERROGACION;
    }

    public enum Estado {
        EN_TAPETE, EN_RESERVA;
    }

    private final PrincipalJFrame principalJFrame;

    private Valor valor;
    private Estado estado;
    private JLabel jLabel;
    private boolean clickable;
    private Posicion posicion;

    public Dado(JLabel jLabel, Posicion posicion) {
        this.jLabel = jLabel;
        this.principalJFrame = ((PrincipalJFrame) SwingUtilities.getWindowAncestor(this.jLabel));
        this.valor = Valor.SEIS;
        this.estado = Estado.EN_TAPETE;
        this.posicion = posicion;
        this.jLabel.setBounds(Posiciones.posicionesDados.get(this.posicion));
        this.jLabel.setIcon(imagenesDado.get(this.valor));
        this.clickable = true;
        this.jLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON1 && isClickable()) {
                   
                    if (getEstado().equals(Estado.EN_TAPETE)) {
                        setEstado(Estado.EN_RESERVA);
                        principalJFrame.desocuparPosicionTapete(getPosicion());
                        setPosicion(principalJFrame.primeraPosionLibreReserva());
                        principalJFrame.ocuparPosicionReserva(getPosicion());
                        cambiarPosicion(Posiciones.posicionesDados.get(getPosicion()));

                    } else {
                        setEstado(Estado.EN_TAPETE);
                        principalJFrame.desocuparPosicionReserva(getPosicion());
                        setPosicion(principalJFrame.primeraPosionLibreTapete());
                        principalJFrame.ocuparPosicionTapete(getPosicion());
                        cambiarPosicion(Posiciones.posicionesDados.get(getPosicion()));
                    }
                    
                    
                }
            }
        });
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

}
