package modelos.gui;

import controladores.Imagenes;
import javax.swing.*;

import controladores.Rectangles;
import controladores.Rectangles.RectanglesDados;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;
import modelos.datos.DadosPartida;
import modelos.flujo.ObjetoDato;
import modelos.flujo.serializaciones.SerializacionDados;
import modelos.flujo.serializaciones.SerializacionEmision;
import vistas.Main;

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
    private boolean esClickable;
    private RectanglesDados posicion;
    private DadosPartida dadosPartida;

    public Dado(JLabel jLabel, RectanglesDados posicion, DadosPartida dadosPartida) {
        this.jLabel = jLabel;
        this.posicion = posicion;
        this.dadosPartida = dadosPartida;
        this.jLabel.setBounds(Rectangles.rectanglesDados.get(this.posicion));
        this.valor = Valor.SEIS;
        this.estado = Estado.EN_TAPETE;
        
        this.jLabel.setIcon(
            new ImageIcon(
                     
                new Imagenes().imagenesDado.get(this.valor).getImage().getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_SMOOTH)
            )
        );
        this.esClickable = true;
        this.jLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (esTurnoJugadorLocal() && !esTurnoCero() && evt.getButton() == MouseEvent.BUTTON1 && esClickable()) {

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

                    ArrayList<Integer> indexRectanglesEnumDados = new ArrayList<>();
                    ArrayList<Integer> indexValorEnumDados = new ArrayList<>();

                    for (int i = 0; i < dadosPartida.getDados().size(); i++) {
                        indexRectanglesEnumDados.add(dadosPartida.getDados().get(i).getPosicion().ordinal());
                        indexValorEnumDados.add(dadosPartida.getDados().get(i).getValor().ordinal());
                    }

                    conexion.ConexionCliente.enviarObjeto(new ObjetoDato(
                            ObjetoDato.DATOS_PARTIDA, new SerializacionEmision(
                                    new SerializacionDados(new ArrayList<>(indexRectanglesEnumDados), new ArrayList<>(indexValorEnumDados)),
                                    null, null, null, null
                            )));

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

    public boolean esClickable() {
        return esClickable;
    }

    public void setEsClickable(boolean esClickable) {
        this.esClickable = esClickable;
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

    private boolean esTurnoJugadorLocal() {
        return Main.getPrincipalJFrame().esTurnoJugadorLocal();
    }

    private boolean esTurnoCero() {
        return Main.getPrincipalJFrame().getSerializacionEstadoPartida().getTiradasRealizadasEnElTurnoDelJugador() == 0;

    }
}
