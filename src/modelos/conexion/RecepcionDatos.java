package modelos.conexion;

import modelos.datos.DadosPartida;
import static controladores.ClavesEnvio.*;
import modelos.datos.Jugador;
import modelos.datos.PuntosPrevios;
import modelos.datos.PuntuacionJugador;
import vistas.Main;

public class RecepcionDatos {

    private ObjetoDato objetoDato;

    public RecepcionDatos() {
        this.objetoDato = null;
    }

    public void recibirDatos(ObjetoDato objetoDato) {
        this.objetoDato = objetoDato;
    }

    public void gestionarDatosRecibidos() {
        String clave = this.objetoDato.getClave();
        switch (clave) {
            case DADOS_PARTIDA:
                DadosPartida dadosPartida = (DadosPartida) this.objetoDato.getValor();
                Main.getPrincipalJFrame().setDadosPartida(dadosPartida);
                break;
            case PUNTOS_PREVIOS:
                PuntosPrevios puntosPrevios = (PuntosPrevios) this.objetoDato.getValor();
                Main.getPrincipalJFrame().actualizarPuntosPreviosJugadorRemoto(puntosPrevios);
                break;
            case PUNTUACION_JUGADOR:
                PuntuacionJugador puntuacionJugador = (PuntuacionJugador) this.objetoDato.getValor();

                break;
            case JUGADOR:
                Jugador jugador = (Jugador) this.objetoDato.getValor();

                break;
            default:
                throw new AssertionError();
        }

    }
}
