package modelos;

import javax.swing.*;
import static controladores.Imagenes.imagenesDado;
import controladores.Rectangles;
import controladores.Rectangles.RectanglesDados;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import vistas.PrincipalJFrame;

public class Dado {

    public enum Valor {
        VACIO, UNO, DOS, TRES, CUATRO, CINCO, SEIS, INTERROGACION;
    }

    public enum Estado {
        EN_TAPETE, EN_RESERVA;
    }

    private final PrincipalJFrame principalJFrame;
    private static ArrayList<Boolean> reservaOcupadas = rellenarOcupadas(false);
    private static ArrayList<Boolean> tapeteOcupadas = rellenarOcupadas(true);

    private static ArrayList<Boolean> rellenarOcupadas(boolean valorInicial) {
        ArrayList<Boolean> arrayOcupadas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayOcupadas.add(valorInicial);
        }
        return arrayOcupadas;
    }

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
                        desocuparPosicionTapete(getPosicion());
                        setPosicion(primeraPosicionLibreReserva());
                        ocuparPosicionReserva(getPosicion());
                        cambiarPosicion(Rectangles.rectanglesDados.get(getPosicion()));

                    } else {
                        setEstado(Estado.EN_TAPETE);
                        desocuparPosicionReserva(getPosicion());
                        setPosicion(primeraPosionLibreTapete());
                        ocuparPosicionTapete(getPosicion());
                        cambiarPosicion(Rectangles.rectanglesDados.get(getPosicion()));
                    }

                }
            }
        });
    }
    
    
    public RectanglesDados primeraPosicionLibreReserva() {
        return RectanglesDados.values()[reservaOcupadas.indexOf(false)];
    }

    public void ocuparPosicionReserva(RectanglesDados posicion) {
        reservaOcupadas.set(posicion.ordinal(), true);
    }

    public void desocuparPosicionReserva(RectanglesDados posicion) {
        reservaOcupadas.set(posicion.ordinal(), false);
    }

    public RectanglesDados primeraPosionLibreTapete() {
        return RectanglesDados.values()[tapeteOcupadas.indexOf(false) + 5];
    }

    public void ocuparPosicionTapete(RectanglesDados posicion) {
        tapeteOcupadas.set(posicion.ordinal() - 5, true);
    }

    public void desocuparPosicionTapete(RectanglesDados posicion) {
        tapeteOcupadas.set(posicion.ordinal() - 5, false);
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
