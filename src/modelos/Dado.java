package modelos;

import javax.swing.*;
import static controladores.Imagenes.imagenesDado;
import controladores.Rectangles;
import controladores.Rectangles.RectanglesDados;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import vistas.PrincipalJFrame;

public class Dado {

    public RectanglesDados getPosicion() {
        return posicion;
    }

    public void setPosicion(RectanglesDados posicion) {
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
    private RectanglesDados posicion;

    public Dado(JLabel jLabel, RectanglesDados posicion) {
        this.jLabel = jLabel;
        this.principalJFrame = ((PrincipalJFrame) SwingUtilities.getWindowAncestor(this.jLabel));
        this.valor = Valor.SEIS;
        this.estado = Estado.EN_TAPETE;
        this.posicion = posicion;
        this.jLabel.setBounds(Rectangles.rectanglesDados.get(this.posicion));
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
                        cambiarPosicion(Rectangles.rectanglesDados.get(getPosicion()));

                    } else {
                        setEstado(Estado.EN_TAPETE);
                        principalJFrame.desocuparPosicionReserva(getPosicion());
                        setPosicion(principalJFrame.primeraPosionLibreTapete());
                        principalJFrame.ocuparPosicionTapete(getPosicion());
                        cambiarPosicion(Rectangles.rectanglesDados.get(getPosicion()));
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
