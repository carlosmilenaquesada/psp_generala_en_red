package modelos;

import javax.swing.JLabel;
import static controladores.Imagenes.imagenesDado;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class Dado {
    
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
    private Dado dadoEspejo;
    
    public Dado(Valor valor, Estado estado, JLabel jLabel) {
        this.valor = valor;
        this.jLabel = jLabel;
        this.jLabel.setIcon(imagenesDado.get(this.valor));
        this.clickable = true;
        this.jLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON1 && isClickable()) {
                    /*getDadoEspejo().setClickable(true);
                    setClickable(false);
                    getDadoEspejo().cambiarEstado(getEstado());
                    cambiarEstado(Valor.VACIO);*/
                    //((PrincipalJFrame) SwingUtilities.getWindowAncestor(getjLabel())).calcularPrePuntuacion();
                    
                    if (getEstado().equals(Estado.EN_TAPETE)) {
                        setEstado(Estado.EN_RESERVA);
                    } else {
                        setEstado(Estado.EN_TAPETE);
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
    
    public Dado getDadoEspejo() {
        return dadoEspejo;
    }
    
    public void setDadoEspejo(Dado dadoEspejo) {
        this.dadoEspejo = dadoEspejo;
    }
    
    public Estado getEstado() {
        return estado;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public void cambiarPosicion(Rectangle nuevaPosicion){
        this.jLabel.set
    }
    
}
