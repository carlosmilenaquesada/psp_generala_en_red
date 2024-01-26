package modelos.flujo;

import static controladores.Imagenes.imagenesDado;
import controladores.Rectangles;
import controladores.Rectangles.RectanglesDados;
import modelos.datos.DadosPartida;
import modelos.datos.PuntosPrevios;
import modelos.datos.PuntuacionJugador;
import modelos.gui.CeldaDePanel;
import modelos.gui.Dado.Valor;
import vistas.Main;

public class RecepcionDatos {

    public static void gestionarDatos(ObjetoDato objetoDato) {
        System.out.println(objetoDato);
        String clave = objetoDato.getClave();
        switch (clave) {
            case ObjetoDato.DATOS_PARTIDA:
                SerializacionPartida serializacionPartida = (SerializacionPartida) objetoDato.getValor();
                //DADOS---------------------------------------------------------
                SerializacionPartida.DadosSerializados dadosSerializados = serializacionPartida.getDadosSerializados();
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
                PuntosPrevios puntosPrevios = serializacionPartida.getPuntosPrevios();
                if (puntosPrevios != null) {
                    Main.getPrincipalJFrame().actualizarPuntosPreviosJugadorRemoto(puntosPrevios);
                }
                //PUNTUACIÓN JUGADOR
                PuntuacionJugador puntuacionJugador = serializacionPartida.getPuntuacionJugador();
                if (puntuacionJugador != null) {
                    Main.getPrincipalJFrame().getJugadorRemoto().setPuntuacionJugador(puntuacionJugador);
                    
                    for (int i = 0; i < puntuacionJugador.getConseguidasSuperior().size(); i++) {
                        if (puntuacionJugador.getConseguidasSuperior().get(i).equals(true)) {
                            ((CeldaDePanel) Main.getPrincipalJFrame().getPanelPuntosSuperior().getCelda(i, 2)).setText(
                                    puntuacionJugador.getPuntosSuperior().get(i).toString()
                            );
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
                }

                break;
            case ObjetoDato.MENSAJE_CHAT:
                MensajeChat mensajeChat = (MensajeChat) objetoDato.getValor();

                break;

            default:
                throw new AssertionError();
        }

    }

}
