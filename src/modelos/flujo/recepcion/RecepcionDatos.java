package modelos.flujo.recepcion;

import static controladores.Imagenes.imagenesDado;
import controladores.Rectangles;
import controladores.Rectangles.RectanglesDados;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelos.datos.DadosPartida;
import modelos.datos.PerfilJugador;
import modelos.datos.PuntosPrevios;
import modelos.datos.PuntuacionJugador;
import modelos.flujo.ObjetoDato;
import modelos.flujo.serializaciones.SerializacionDados;
import modelos.flujo.serializaciones.SerializacionEmision;
import modelos.flujo.serializaciones.SerializacionEstadoPartida;
import modelos.gui.CeldaDePanel;
import modelos.gui.Dado.Valor;
import vistas.EleccionPersonajeJDialog;
import vistas.Main;

public class RecepcionDatos {

    public static void gestionarDatos(ObjetoDato objetoDato) {

        String clave = objetoDato.getClave();
        switch (clave) {
            case ObjetoDato.DATOS_PARTIDA:
                SerializacionEmision serializacionEmision = (SerializacionEmision) objetoDato.getValor();
                //DADOS---------------------------------------------------------
                SerializacionDados dadosSerializados = serializacionEmision.getDadosSerializados();
                if (dadosSerializados != null) {

                    DadosPartida dadosPartida = Main.getPrincipalJFrame().getDadosPartida();
                    for (int i = 0; i < dadosPartida.getDados().size(); i++) {
                        dadosPartida.getDados().get(i).getjLabel().setBounds(Rectangles.rectanglesDados.get(RectanglesDados.values()[dadosSerializados.getIndexRectanglesEnumDados().get(i)]));
                        dadosPartida.getDados().get(i).getjLabel().setIcon(imagenesDado.get(Valor.values()[dadosSerializados.getIndexValorEnumDados().get(i)]));
                        dadosPartida.getDados().get(i).setValor(Valor.values()[dadosSerializados.getIndexValorEnumDados().get(i)]);
                    }
                    Main.getPrincipalJFrame().setDadosPartida(dadosPartida);
                }
                //PUNTOS PREVIOS------------------------------------------------
                PuntosPrevios puntosPrevios = serializacionEmision.getPuntosPrevios();
                if (puntosPrevios != null) {
                    Main.getPrincipalJFrame().actualizarPuntosPreviosJugadorRemoto(puntosPrevios);
                }
                //PUNTUACIÓN JUGADOR--------------------------------------------
                PuntuacionJugador puntuacionJugador = serializacionEmision.getPuntuacionJugador();
                if (puntuacionJugador != null) {
                    int bonusAnterior = Main.getPrincipalJFrame().getJugadorRemoto().getPuntuacionJugador().getBonus();
                    Main.getPrincipalJFrame().getJugadorRemoto().setPuntuacionJugador(puntuacionJugador);
                    int bonusActual = Main.getPrincipalJFrame().getJugadorRemoto().getPuntuacionJugador().getBonus();

                    for (int i = 0; i < puntuacionJugador.getConseguidasSuperior().size(); i++) {
                        if (puntuacionJugador.getConseguidasSuperior().get(i).equals(true)) {
                            ((CeldaDePanel) Main.getPrincipalJFrame().getPanelPuntosSuperior().getCelda(i, 2)).setText(
                                    puntuacionJugador.getPuntosSuperior().get(i).toString()
                            );
                        }
                    }
                    if (bonusAnterior < 63) {
                        Main.getPrincipalJFrame().getPanelBonus().getCelda(0, 2).setText(bonusActual + "/63");
                        if (bonusActual >= 63) {
                            JLabel jLabelBonus = new JLabel(Main.getPrincipalJFrame().getJugadorRemoto().getIdentificadorJugador() + " consiguió el bonus!\n"
                                    + "+ 35 puntos!", JLabel.CENTER);
                            JOptionPane.showMessageDialog(Main.getPrincipalJFrame(), jLabelBonus);
                        }
                    }

                    for (int i = 0; i < puntuacionJugador.getConseguidasInferior().size(); i++) {
                        if (puntuacionJugador.getConseguidasInferior().get(i).equals(true)) {
                            ((CeldaDePanel) Main.getPrincipalJFrame().getPanelPuntosInferior().getCelda(i, 2)).setText(
                                    puntuacionJugador.getPuntosInferior().get(i).toString()
                            );
                        }
                    }
                    Main.getPrincipalJFrame().limpiarColumnaDeCeldas(2);
                    Main.getPrincipalJFrame().getPanelPuntosTotales().getCelda(0, 2).setText(String.valueOf(Main.getPrincipalJFrame().getJugadorRemoto().getPuntuacionJugador().getCalculoPuntosTotales()));
                }

                //PERFIL JUGADOR------------------------------------------------
                PerfilJugador perfilJugador = serializacionEmision.getPerfilJugador();

                if (perfilJugador != null) {
                    for (Window window : Window.getWindows()) {

                        if (window instanceof EleccionPersonajeJDialog) {

                            ((EleccionPersonajeJDialog) window).setPerfilJugadorRemoto(perfilJugador);
                        }

                    }
                }
                //ESTADO PARTIDA------------------------------------------------
                SerializacionEstadoPartida serializacionEstadoPartida = serializacionEmision.getSerializacionEstadoPartida();
                if (serializacionEstadoPartida != null) {
                    Main.getPrincipalJFrame().setSerializacionEstadoPartida(serializacionEstadoPartida);
                }
                break;

            case ObjetoDato.MENSAJE_CHAT:
                String mensajeRecibido = (String) objetoDato.getValor();
                Main.getPrincipalJFrame().escribirEnTextArea(Main.getPrincipalJFrame().getJugadorRemoto().getIdentificadorJugador(), mensajeRecibido);
                break;

            default:
                throw new AssertionError();
        }

    }

}
