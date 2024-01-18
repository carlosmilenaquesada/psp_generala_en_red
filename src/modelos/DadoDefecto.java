package modelos;

import javax.swing.JLabel;
import static controladores.Imagenes.imagenesDado;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import vistas.PrincipalJFrame;

public class DadoDefecto {

    public enum Estado {
        VACIO, UNO, DOS, TRES, CUATRO, CINCO, SEIS, INTERROGACION;
    }
    private Estado estado;
    private JLabel jLabel;
    private boolean clickable;
    private DadoDefecto dadoEspejo;

    public DadoDefecto(Estado estado, JLabel jLabel) {
        this.estado = estado;
        this.jLabel = jLabel;
        this.jLabel.setIcon(imagenesDado.get(this.estado));
        this.clickable = true;
        this.jLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON1 && isClickable()) {
                    getDadoEspejo().setClickable(true);
                    setClickable(false);
                    getDadoEspejo().cambiarEstado(getEstado());
                    cambiarEstado(Estado.VACIO);
                    ((PrincipalJFrame) SwingUtilities.getWindowAncestor(getjLabel())).calcularPrePuntuacion();
                }
            }
        });
    }

    public void cambiarEstado(Estado estado) {
        this.estado = estado;
        this.jLabel.setIcon(imagenesDado.get(this.estado));
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

    public JLabel getjLabel() {
        return jLabel;
    }

    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    public DadoDefecto getDadoEspejo() {
        return dadoEspejo;
    }

    public void setDadoEspejo(DadoDefecto dadoEspejo) {
        this.dadoEspejo = dadoEspejo;
    }

}
