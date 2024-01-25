package modelos.flujo;

import conexion.ConexionCliente;
import modelos.datos.DadosPartida;
import static controladores.ClavesEnvio.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.datos.Jugador;
import modelos.datos.PuntosPrevios;
import modelos.datos.PuntuacionJugador;
import vistas.Main;

public class RecepcionDatos {

    private ObjetoDato objetoDato;

    public RecepcionDatos() {
        this.objetoDato = null;
    }

    /*public void recibirDatos() {
        try {
            ObjectInputStream ois = new ObjectInputStream(ConexionCliente.getSocketCliente().getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(RecepcionDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

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
